import React from 'react';
import './App.css';
import MenuPage from "./MenuPage";
import StagePage from "./StagePage";

import {
    Switch,
    Route
} from "react-router-dom";
import {bindActionCreators} from "redux";
import {initAppFromNetwork} from "../data/actions/httpActionCreators";
import {connect} from "react-redux";
import {withRouter} from "react-router";


class  App extends React.Component{


    componentDidMount() {
        if(this.success)
            return;
        const query = new URLSearchParams(this.props.location.search);
        const merchantId = query.get('mid');
        if(!merchantId){

            //TODO delete this default id
            this.props.initAppFromNetwork(1);
            return;
            //init all merchant and let user select
            this.props.history.push("/errorMid");
            return;
        }
        //TODO get merchant id from url
        this.props.initAppFromNetwork(merchantId);
    }
    render() {
        return (
                <Switch>
                    <Route path="/menu">
                        <MenuPage/>
                    </Route>
                    <Route path="/stage">
                        <StagePage/>
                    </Route>
                    <Route path={"/errorMid"}>
                        <div>请选择正确的商家!</div>
                    </Route>
                    <Route path="/">
                        <MenuPage/>
                    </Route>

                </Switch>
        );
    }
}

const mapState=(state) =>{
    const {loading, success} = state.menuReducer;
    return {loading, success}
}
const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        initAppFromNetwork
    }, dispatch);
}


export default withRouter(connect(mapState,mapDispatch)(App));
