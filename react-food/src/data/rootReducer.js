import { combineReducers } from 'redux'
import menuReducer from './reducers/menuReducer'
import stageReducer from './reducers/stageReducer'
const foodAppReducer = combineReducers({
    menuReducer: menuReducer,
    stageReducer: stageReducer
})

export default foodAppReducer
