<!doctype html>
<html lang="en-US">
<head>
    <title>login page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0 , maximum-scale=1.0" >
    <script src="libs/angular.min.js"></script>
    <script src="libs/angular-cookies.js"></script>
    <script src="libs/jquery-3.6.0.min.js"></script>
    <script src="libs/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <link href="libs/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="scripts/app.js"></script>
    <link href="scripts/css/login.css" rel="stylesheet" />
    <script src="scripts/controllers/login.js"></script>
    <script src="scripts/services/ApiHandler.js"></script>


</head>

<body ng-app="onlineShop">
<div class="container-fluid" ng-controller="loginCtrl">
    <div class="row justify-content-md-center " >
        <div class="col-3 login">
        <form >
            <h3>Login to panel</h3>
            <div class="mb-3">
                <label for="user" class="form-label">Username</label>
                <input type="text" class="form-control" id="user" aria-describedby="emailHelp" ng-model="user.username">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" ng-model="user.password">
            </div>

            <button type="submit" class="btn btn-primary" ng-click="doLogin()">Login</button>
        </form>
        </div>
    </div>
</div>
</body>