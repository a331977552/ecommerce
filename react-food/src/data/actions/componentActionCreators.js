
export  const MenuItemConstraints= {
    UPDATE_MENU_ITEM:'UPDATE_MENU_ITEM',
    INIT_MENU:'INIT_MENU',
    EMPTY_CART:'EMPTY_CART',
    CATE_LEFT_SELECTED:'CATE_RIGHT_SELECTED',
    CATE_RIGHT_SELECTED:'CATE_LEFT_SELECTED',
    CATEGORY_SELECTED:'CATEGORY_SELECTED',

}
export  const StageConstraints= {
    STAGE_SHOW:'STAGE_SHOW'


}

/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function updateItemInCartAction(data) {
    return {
        type: MenuItemConstraints.UPDATE_MENU_ITEM,
        payload:data,
    }
}
/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function emptyCartAction() {
    return {
        type: MenuItemConstraints.EMPTY_CART,
        payload:null
    }
}
/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function initMenuAction(data) {
    return {
        type: MenuItemConstraints.INIT_MENU,
        payload:data
    }
}
/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function showStage(data) {
    return {
        type: StageConstraints.STAGE_SHOW,
        payload:data
    }
}

/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function onCategorySelected(data) {
    return {
        type: MenuItemConstraints.CATEGORY_SELECTED,
        payload:data
    }
}