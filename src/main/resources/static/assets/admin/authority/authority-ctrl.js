app.controller("authority-ctrl",function($scope,$http,$location){
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    $scope.initialize = function() {
        //load all roles
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })

        //load staff va directors(admin)
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
        })

         //load authorites of staff and directors
         $http.get("/rest/authorites?admin=true").then(resp => {
            $scope.authorites = resp.data;
        }).catch(error => {
            $location.path("/unauthorized");
        })
    }

    $scope.authority_of = function (acc, role) {
        if($scope.authorites) {
            return $scope.authorites.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
        }
    }

    $scope.athority_changed = function (acc, role) {
        var authority = $scope.authority_of(acc, role);
        if(authority) { //Đã cấp quyền (thu hồi quyền xóa)
            $scope.revoke_authority(authority);
        }
        else { //Chưa được cấp quyền(cấp quyền mới)
            authority = {account: acc, role: role};
            $scope.grant_authority(authority);
        }
    }

    //Xoa authority
    $scope.revoke_authority = function(authority) {
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
            alert("Thu hồi quyền sử dụng thành công");
        }).catch(error => {
            alert("Thu hồi quyền sử dụng thất bại");
            console.log("Error", error);
        })
    }

    //Them moi authority
    $scope.grant_authority = function(authority){
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp.data)
            alert("Cấp quyền sử dụng thành công");
        }).catch(error => {
            alert("Cấp quyền sử dụng thất bại")
            console.log("Error", error);
        })
    }

    $scope.initialize();
})  