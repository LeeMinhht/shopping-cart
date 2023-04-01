const app = angular.module("shopping-cart-app",[])
app.controller("shopping-cart-ctrl",function($scope,$http){
    $scope.tinhthanh = [];

    //Quản lý giỏ hàng
    $scope.cart = {
        items:[],
        //Thêm sản phẩm vào giỏ hàng
        add(id){
            var item = this.items.find(item => item.id == id);
            if(item){
                item.quantity++;
                this.saveToLocalStorage();
            }
            else{
                $http.get(`/rest/products/${id}`).then(resp =>{
                    resp.data.quantity = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
            alert("Thêm vào giỏ hàng thành công")
        },

        //xoá sản phẩm khỏi giỏ hàng
        remove(id){

            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
            alert("Xoá thành công")
        },

        //xoas sạch giỏ hàng
        clear(){
            this.items = [];
            this.saveToLocalStorage();
        },

        //Lưu giỏ hàng vào trong local Storage
        saveToLocalStorage() {
            var json =JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },

        //tính tổng số lượng các mặt hàng trong giỏ
        get count(){
            return this.items.map(item => item.quantity).reduce((total,quantity) => total +=quantity ,0);
        },

        //Tổng thành tiền các mặt hàng trong giỏ

        get amount(){
            return this.items.map(item => item.quantity * item.unitPrice).reduce((total,quantity) => total +=quantity ,0);
        },

        loadFormLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.order = {
        createDate: new Date(),
        address: "",
        account:{username:$("#username").text()},
        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return{
                    product:{id:item.id},
                    price:item.price,
                    quantity:item.quantity
                }
            });
        },
        purchase() {
            var orderr = angular.copy(this);
            //thực hiện đặt hàng
            $http.post("/rest/orders",orderr).then(resp =>{
                alert("Đặt hàng thành công");
                $scope.cart.clear();
                location.href = "/order/detail/" +resp.data.id;
            }).catch(error =>{
                alert("Đặt hàng lỗi")
                console.log(error)
            })
        }

    }

    $scope.loadLocation = function (){
        $http.get(`https://provinces.open-api.vn/api/`).then(resp =>{
            $scope.tinhthanh = resp.data;
            console.log($scope.tinhthanh.length)
        })


    }

    $scope.loadLocation();
    $scope.cart.loadFormLocalStorage()



})
