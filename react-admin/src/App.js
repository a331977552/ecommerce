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
import merchantReducer from "./data/redux/reducers/MerchantReducer";
import {httpGetMerchantIfTokenValid} from "./data/http/HttpRequest";
import {merchantSignIn} from "./data/redux/actionCreators/commonActionCreator";

class App extends Component {


    constructor(props) {
        super(props);
        const {token, merchant} = this.props;
        if (!token || !merchant) {
            this.props.history.replace("/login")
        }
    }

    render() {
        return (<Switch>
                <Route path="/login">
                    <LoginPage/>
                </Route>
                <Route path='/notFound' >
                    <div>
                        page not found
                    </div>
                </Route>
                <Route path="/" >
                    <MainPage/>
                </Route>


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