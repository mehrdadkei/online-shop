app.controller("panelCtrl", function ($scope,apiHandler,$cookies) {

    $scope.checkAccess = () => {
       var token = $cookies.get("userToken", token)
        if (token== undefined || token ==null || token==""){
            location.href= "/login"
        }
    }

    $scope.checkAccess();
});