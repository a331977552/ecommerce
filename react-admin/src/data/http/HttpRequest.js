import axios from "axios";



export function httpSignIn(merchantVo, success,failed) {
    axios.post("/auth/manage/login",null,{params:merchantVo}).then(success).catch(failed)

}
export function httpGetMerchantIfTokenValid(success, failed) {
    axios.post("/api/merchant").then(success).catch(failed)
}


