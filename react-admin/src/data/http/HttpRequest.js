import axios from "axios";



export function httpSignIn(merchantVo, success,failed) {
    axios.post("/auth/manage/login",null,{params:merchantVo}).then(success).catch(failed)

}
export function httpGetMerchantIfTokenValid(success, failed) {
    axios.post("/api/merchant").then(success).catch(failed)
}

export function httpGetContent(url,success, failed) {
    axios.post(url).then(success).catch(failed)
}


export function httpUpdateCategory(category,success, failed) {
    axios.post('/api/cate/update',category).then(success).catch(failed)
}
export function httpDeleteCategory(categoryId,success, failed) {
    axios.post(`/api/cate/delete/${categoryId}`).then(success).catch(failed)
}
export function httpAddCategory(category,success, failed) {
    axios.post("/api/cate/add/",category).then(success).catch(failed)
}


export function httpAddProduct(product,success, failed) {
    axios.post("/api/product/add",product).then(success).catch(failed)
}





