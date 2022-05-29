app.service("apiHandler", function ($http) {
    this.callPost = (url, dataa, onSuccess, onError) => {
        url="/api/"+url
        $http.post(url,dataa).then((response)=>{
            if(response!=null && response.data!=null){
                let result = response.data;
                if (result.status == "success"){
                    onSuccess(result);
                }else if (result.hasError){
                     alert(result.message)
                }else {
                    alert("unknown error")
                }

            }
        },(err)=>{
            alert("exception");
            onError(err)
            }
        )
    }

    this.callGet = (url, onSuccess, onError) => {
        url="/api/"+url
        $http.get(url).then((response)=>{
                if(response!=null && response.data!=null){
                    let result = response.data;
                    if (result.status == "success"){
                        onSuccess(result);
                    }else if (result.hasError){
                        alert(result.message)
                    }else {
                        alert("unknown error")
                    }

                }
            },(err)=>{
                alert("exception");
                onError(err)
            }
        )
    }

    this.callPut = (url,dataa, onSuccess, onError) => {
        url="/api/"+url
        $http.put(url,dataa).then((response)=>{
                if(response!=null && response.data!=null){
                    let result = response.data;
                    if (result.status == "success"){
                        onSuccess(result);
                    }else if (result.hasError){
                        alert(result.message)
                    }else {
                        alert("unknown error")
                    }

                }
            },(err)=>{
                alert("exception");
                onError(err)
            }
        )
    }

    this.callDelete = (url, onSuccess, onError) => {
        url="/api/"+url
        $http.delete(url).then((response)=>{
                if(response!=null && response.data!=null){
                    let result = response.data;
                    if (result.status == "success"){
                        onSuccess(result);
                    }else if (result.hasError){
                        alert(result.message)
                    }else {
                        alert("unknown error")
                    }

                }
            },(err)=>{
                alert("exception");
                onError(err)
            }
        )
    }
})