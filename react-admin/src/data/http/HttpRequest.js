import axios from "axios";
import {getUser} from "../../utils/UserDataUtils";



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
export function httpCategoryList(success, failed) {
    axios.post('/api/shop/categoryList').then(success).catch(failed)
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
export function httpUpdateProduct(product,success, failed) {
    axios.post("/api/product/update",product).then(success).catch(failed)
}

export function httpListProducts(pagination, orderBy, by, example={}, success, failed, final) {
    // dataPath: '/api/product/findAll/0/'+pageUtil.getPageSize()+'?mId='+getUser().id+'&orderBy=price',
        axios.post(`/api/product/findAll/${pagination.current-1}/${pagination.pageSize}?mId=${getUser().id}&orderBy=${orderBy?orderBy:'update_date'}&by=${by}`,example).then(success).catch(failed).finally(final)
}
export function httpDeleteProduct(id,success, failed,final) {
    // dataPath: '/api/product/findAll/0/'+pageUtil.getPageSize()+'?mId='+getUser().id+'&orderBy=price',
        axios.post(`/api/product/delete/${id}`).then(success).catch(failed).finally(final)
}

export function httpListOrders(pagination,orderBy,by,example={}, success, failed,final) {
    // dataPath: '/api/product/findAll/0/'+pageUtil.getPageSize()+'?mId='+getUser().id+'&orderBy=price',
    axios.post(`/api/order/findAllOrdersByMerchant/${pagination.current-1}/${pagination.pageSize}?orderBy=${orderBy?orderBy:'update_date'}&by=${by}`,example).then(success).catch(failed).finally(final)
}








