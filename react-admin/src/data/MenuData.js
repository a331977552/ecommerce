import HomeReducer from "./redux/reducers/HomeReducer";
import ProductReducer from "./redux/reducers/shop/ProductListReducer";
import CategoryReducer from "./redux/reducers/shop/CategoryReducer";
import OrderReducer from "./redux/reducers/order/OrderReducer";
import statisticsReducer from "./redux/reducers/statistics/StatisticsReducer";
import advertiseReducer from "./redux/reducers/marketing/AdvertiseReducer";
import adminMerchantReducer from "./redux/reducers/admin/AdminMerchantReducer";
import adminUserReducer from "./redux/reducers/admin/AdminUserReducer";
import ProductAddingReducer from "./redux/reducers/shop/ProductAddingReducer";

import {
    onCategoryRefreshFailed,
    onCategoryRefreshRetry,
    refreshCategoryList
} from "./redux/reducers/shop/CategoryActionCreator";
import {onProductAddInitSuccess, onProductAddInitFailed, onProductAddInitRetry
} from "./redux/reducers/shop/ProductActionCreator";

const menuData = [
    {
        routerPath: '/',
        title: '主页',
        breadCrumb: ['主页'],
        dataPath: '/api/shop/home',
        children: [],
        reducer: HomeReducer,
        actions: {}
    },
    {
        routerPath: '/shop',
        title: '店铺管理',
        breadCrumb: ['店铺管理'],
        dataPath: null,
        children: [{
            routerPath: '/shop/productAdd',
            title: '商品添加',
            breadCrumb: ['店铺管理', '商品添加'],
            dataPath: '/api/shop/categoryEdit',
            children: [],
            reducer: ProductAddingReducer,
            actions: {
                success: onProductAddInitSuccess,
                failed: onProductAddInitFailed,
                retry: onProductAddInitRetry
                }
            },
            {
                routerPath: '/shop/productEdit',
                title: '商品编辑',
                breadCrumb: ['店铺管理', '商品编辑'],
                dataPath: '/api/shop/productEdit',
                children: [],
                reducer: ProductReducer
            },
            {
                routerPath: '/shop/categoryEdit',
                title: '种类编辑',
                breadCrumb: ['店铺管理', '种类编辑'],
                dataPath: '/api/shop/categoryEdit',
                children: [],
                reducer: CategoryReducer,
                actions: {
                    success: refreshCategoryList,
                    failed: onCategoryRefreshFailed,
                    retry: onCategoryRefreshRetry
                }
            }
        ]
    },
    {
        routerPath: '/order',
        title: '订单管理',
        breadCrumb: ['订单管理'],
        dataPath: null,
        children: [{
            routerPath: '/order/orderEdit',
            title: '订单编辑',
            breadCrumb: ['订单管理', '订单编辑'],
            dataPath: '/api/shop/categoryEdit',
            children: [],
            reducer: OrderReducer

        }]
    },
    {
        routerPath: '/statis',
        title: '数据统计',
        breadCrumb: ['数据统计'],
        dataPath: null,
        children: [{
            routerPath: '/statis/overview',
            title: '数据统计',
            breadCrumb: ['数据统计', '数据统计'],
            dataPath: '/statis/overview',
            children: [],
            reducer: statisticsReducer
        }]
    },

    {
        routerPath: '/marketing',
        title: '营销管理',
        breadCrumb: ['营销管理'],
        dataPath: null,
        children: [{
            routerPath: '/marketing/ad',
            title: '广告管理',
            breadCrumb: ['营销管理', '广告管理'],
            dataPath: null,
            children: [],
            reducer: advertiseReducer
        }]
    },

    {
        routerPath: '/admin',
        title: '超级管理员',
        breadCrumb: ['超级管理员'],
        dataPath: null,
        children: [{
            routerPath: '/admin/merchant',
            title: '商户管理',
            breadCrumb: ['超级管理员', '商户管理'],
            dataPath: '/admin/merchant',
            children: [],
            reducer: adminMerchantReducer
        },
            {
                routerPath: '/admin/user',
                title: '用户管理',
                breadCrumb: ['超级管理员', '用户管理'],
                dataPath: '/admin/user',
                children: [],
                reducer: adminUserReducer
            }]
    }
]

const data404 = {
    routerPath: '/notFound',
    title: '页面无法找到',
    breadCrumb: ['页面无法找到'],
    dataPath: null,
    children: []
}
const foundedPath = {}

export function findDataByPathname(routerPath) {
    if (foundedPath[routerPath]) {
        return foundedPath[routerPath]
    }

    for (const data of menuData) {
        if (data.routerPath === routerPath) {
            foundedPath[routerPath] = data;
            return data;
        } else {
            for (const childData of data.children) {
                if (childData.routerPath === routerPath) {
                    foundedPath[routerPath] = childData;
                    return childData;
                }
            }
        }
    }
    foundedPath[routerPath] = data404;
    return data404
}

export default menuData