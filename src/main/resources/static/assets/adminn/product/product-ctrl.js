app.controller("product-ctrl",function($scope,$http){
    $scope.items =[];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function (){
        //load product
        $http.get("/rest/products").then(resp =>{
            $scope.items = resp.data;
            $scope.items.forEach(item =>{
                item.createDate = new Date(item.createDate);
            })
        });

        //load category
        $http.get("/rest/categories").then(resp =>{
            $scope.cates = resp.data;

        })
    }

    $scope.initialize();

    //xoá form
    $scope.reset = function (){
        $scope.form ={
            createDate :new Date(),
            iamge:'instagram-05.jpg',
            available :true
        };

    }

    //hiện thị thông tin lên form
    $scope.edit = function (item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //thêm sản phẩm
    $scope.create = function (){
        var item =angular.copy($scope.form);
        $http.post(`/rest/products`,item).then(resp =>{
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công");

        }).catch(error =>{
            alert("Lỗi thêm mới sản phẩm");
            console.log("Error",error);
        });
    }

    //cập nhật sản phẩm
    $scope.update = function (){
        var item =angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`,item).then(resp =>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật thành công");

        }).catch(error =>{
            alert("Lỗi Cập nhật  sản phẩm");
            console.log("Error",error);
        });

    }

    //xoá sản phẩm
    $scope.delete = function (item){
        $http.delete(`/rest/products/${item.id}`).then(resp =>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xoá thành công");

        }).catch(error =>{
            alert("Lỗi xoá sản phẩm");
            console.log("Error",error);
        });

    }

    //upload hình
    $scope.imageChanged = function (files){
        var data = new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/images',data,{
            transformRequest: angular.identity,
            headers:{'Content-Type':undefined}
        }).then(resp =>{
            $scope.form.image = resp.data.name;
        }).catch(error =>{
            alert("Loi upload hinh");
            console.log("Eror:",error);
        })
    }

    //phân trang
    $scope.pager={
        page:0,
        size:10,
        get items(){
            var start=this.page*this.size;
            return $scope.items.slice(start,start+this.size);
        },
        get count(){
            return Math.ceil(1.0*$scope.items.length/this.size);
        },
        first(){
            this.page=0;
        },
        prev(){
            this.page--;
            if(this.page <0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page >= this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count -1;
        }
    }

});