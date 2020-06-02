import { createStore,applyMiddleware } from 'redux'
import thunk from 'redux-thunk';
import { combineReducers } from 'redux'
import merchantReducer from './reducers/MerchantReducer'
import carouselReducer from './reducers/CarouselReducer'
import productReducer from './reducers/ProductReducer'
import orderReducer from './reducers/OrderReducer'
import categoryReducer from './reducers/CategoryReducer'
import menuReducer from "./reducers/MenuReducer";
const rootReducer = combineReducers({
    merchantReducer,
    carouselReducer,
    productReducer,
    orderReducer,
    categoryReducer,
    menuReducer
})

const store = createStore(rootReducer,applyMiddleware(thunk));

export  default  store;