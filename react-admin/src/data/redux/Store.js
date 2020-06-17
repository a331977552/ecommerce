import { createStore,applyMiddleware } from 'redux'
import thunk from 'redux-thunk';
import { combineReducers,compose } from 'redux'
import merchantReducer from './reducers/MerchantReducer'
import carouselReducer from './reducers/marketing/CarouselReducer'
import productListReducer from './reducers/shop/ProductListReducer'
import orderListReducer from './reducers/order/OrderListReducer'
import categoryReducer from './reducers/shop/CategoryReducer'
import menuReducer from "./reducers/MenuReducer";
import statisticsReducer from "./reducers/statistics/StatisticsReducer";
import homeReducer from "./reducers/HomeReducer";
import advertiseReducer from "./reducers/marketing/AdvertiseReducer";
import adminMerchantReducer from "./reducers/admin/AdminMerchantReducer";
import adminUserReducer from "./reducers/admin/AdminUserReducer";
import productAddingReducer from "./reducers/shop/ProductAddingReducer";

const rootReducer = combineReducers({
    merchantReducer,
    carouselReducer,
    productListReducer,
    orderListReducer,
    categoryReducer,
    menuReducer,
    statisticsReducer,
    homeReducer,
    advertiseReducer,
    adminMerchantReducer,
    adminUserReducer,
    productAddingReducer
})

const store = createStore(rootReducer,window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())

// const store = createStore(rootReducer,applyMiddleware(thunk));

export  default  store;