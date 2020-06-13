import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter,Redirect} from "react-router-dom";
import {bindActionCreators} from "redux";
import {
    Switch,
    Route
} from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import MainPage from "./pages/MainPage";
import {merchantSignIn} from "./data/redux/actionCreators/commonActionCreator";
import NotFound404Page from "./pages/NotFound404Page";
import {Spin} from "antd";
class App extends Component {


    constructor(props) {
        super(props);
        const {token, merchant} = this.props;
        if (!token || !merchant) {
            this.props.history.replace("/login")
        }
        //todo INITIAL loading

        console.log(this.props)
    }


    render() {
        console.log(this.props)
        const {token, merchant, location} = this.props;


        return (<Switch>
                <Route path="/login">
                    <LoginPage/>
                </Route>
                <Route path='/notFound' >
                <NotFound404Page/>
                </Route>
                {token && merchant && < Route path="/" >
                    <MainPage/>
                    </Route>
                }
            </Switch>
        );
    }
}

function mapState(state) {
    return {...state.merchantReducer};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        merchantSignIn: merchantSignIn
}, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(App));