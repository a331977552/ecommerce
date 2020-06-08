
export const Category_constants = {
    DELETE_CATEGORY : "DELETE_CATEGORY",
    ADD_CATEGORY : "ADD_CATEGORY",
    UPDATE_CATEGORY : "UPDATE_CATEGORY",
    REFRESH_CATEGORY_SUCCEED:'REFRESH_CATEGORY_SUCCEED',
    REFRESH_CATEGORY_FAILED:'REFRESH_CATEGORY_FAILED',
    REFRESH_CATEGORY_RETRY:'REFRESH_CATEGORY_RETRY',
}

export function refreshCategoryList(data) {
    return {
        type:Category_constants.REFRESH_CATEGORY_SUCCEED,
        payload:data
    }
}
export function onCategoryRefreshFailed(data) {
    return {
        type:Category_constants.REFRESH_CATEGORY_FAILED,
        payload:data
    }
}
export function onCategoryRefreshRetry(data) {
    return {
        type:Category_constants.REFRESH_CATEGORY_RETRY,
        payload:data
    }
}

export function deleteCategory(data) {
    return {
        type:Category_constants.DELETE_CATEGORY,
        payload:data
    }
}
export function updateCategory(data) {
    return {
        type:Category_constants.UPDATE_CATEGORY,
        payload:data
    }
}