import axios from "axios";


export function httpInitData(merchantId,success,failed) {
    axios.post("/api/ui/merchant/"+merchantId, {}).then((response) => {
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
    const {customerName,totalPrice, phoneNumber, address, cartItems,paymentMethod, diningMethod,merchant_id,comment } = orderData;

    const orderItems = cartItems.map(item=>({product_id: item.id,...item}));

    const postData = {totalPrice,merchant_id,address,paymentMethod,diningMethod, customer: { name:customerName,phone:phoneNumber}, orderItems,comment};
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
    axios.post("/api/order/place", postData).then((response) => {
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