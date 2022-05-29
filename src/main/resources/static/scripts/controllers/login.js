app.controller("loginCtrl", function ($scope, apiHandler,$cookies) {

    $scope.user = {};

    $scope.doLogin = () => {
        debugger;
        apiHandler.callPost('user/login', $scope.user, (response) => {
                debugger;
                var token = response.dataList[0].token;
                if (token==null || token==""){
                   alert("token is not valid")
                    return
                }
                $cookies.put("userToken",token)
            location.href='/panel';
            },
            (error) => {
                debugger;
            })

    }
});