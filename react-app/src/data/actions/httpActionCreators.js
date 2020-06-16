import {httpInitData,httpOrdering} from "../http/HttpRequest";
import {initApp,orderComplete} from "../actions/componentActionCreators";

/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function initAppFromNetwork(requestData) {

    return function (dispatch) {
        httpInitData(requestData,(result)=>{
            console.log(result);
            dispatch(initApp(result))
        },(error)=>{
            alert(error);
        });


    }

}
export function ordering(requestData) {

    return function (dispatch) {
        httpOrdering(requestData,(result)=>{
            console.log(result);
            dispatch(orderComplete(result))
        },(error)=>{
            alert(error);
        });


    }

}