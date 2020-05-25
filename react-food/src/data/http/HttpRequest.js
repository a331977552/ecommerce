import axios from "axios";


export function httpInitData(merchantId,success,failed) {
    axios.post("/api/user/home/"+merchantId, {}).then((response) => {
        if (response.status >= 200 && response.status < 300) {
            success(response.data);
        }else{
            failed(response.data);
        }
    }).catch((error) => {
        failed(error);
        console.log(error);
    })

}

export function httpOrdering(orderData,success,failed) {

    console.log(orderData);
    /**
     *
     * address: ""
     cartItems: (2) [{…}, {…}]
     customerName: "123213213"
     diningMethod: "eatIn"
     paymentMethod: "wechat"
     phoneNumber: "213213213213213"
     *
     */




    return;
    axios.post("/api/user/home/", {}).then((response) => {
        if (response.status >= 200 && response.status < 300) {
            success(response.data);
        }else{
            failed(response.data);
        }
    }).catch((error) => {
        failed(error);
        console.log(error);
    })

}