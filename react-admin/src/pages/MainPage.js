import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Redirect, Route, Switch, withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import './HomePage.css'
import {Layout, Spin} from 'antd';
import AppHeader from "../components/AppHeader";
import AppFooter from "../components/AppFooter";
import AppLeftMenu from "../components/AppLeftMenu";
import AppLogo from "../components/AppLogo";
import AppBreadcrumb from "../components/AppBreadcrumb";
import HomeContent from "./contents/HomeContent";

import ProductAddContent from "./contents/shop/ProductAddContent";
import ProductEditContent from "./contents/shop/ProductEditContent";
import CategoryEditContent from "./contents/shop/CategoryEditContent";
import OrderEditContent from "./contents/order/OrderEditContent";
import StatisOverviewContent from "./contents/statistic/StatisOverviewContent";
import AdvertiseContent from "./contents/marketing/AdvertiseContent";
import MerchantContent from "./contents/admin/MerchantContent";
import UserContent from "./contents/admin/UserContent";

const {Header, Content, Footer, Sider} = Layout;

class MainPage extends Component {
    state = {
        collapsed: false,
    };




    render() {
        return (
            <Layout style={{minHeight: '100vh'}}>
                <Sider
                    breakpoint="lg"
                    collapsedWidth="0"
                    onBreakpoint={broken => {
                        console.log(broken);
                    }}
                    onCollapse={(collapsed, type) => {
                        console.log(collapsed, type);
                    }}
                >
                    <AppLogo/>
                    <AppLeftMenu/>

                </Sider>

                <Layout>
                    <Header style={{padding: '0 16px', backgroundColor: '#fff'}}>
                        <AppHeader/>
                    </Header>
                    <Content style={{margin: '16px 16px 0'}}>
                        <AppBreadcrumb/>
                        <div debug={'content'} style={{padding: 24, minHeight: 720, backgroundColor: '#fff'}}>
                                <Switch>
                                    <Route path="/shop/productAdd" exact={true}>
                                        <ProductAddContent/>
                                    </Route>
                                    <Route path="/shop/productEdit" exact={true}>
                                        <ProductEditContent/>
                                    </Route>
                                    <Route path="/shop/categoryEdit" exact={true}>
                                        <CategoryEditContent/>
                                    </Route>
                                    <Route path="/order/orderEdit" exact={true}>
                                        <OrderEditContent/>
                                    </Route>
                                    <Route path="/statis/overview" exact={true}>
                                        <StatisOverviewContent/>
                                    </Route>
                                    <Route path="/marketing/ad" exact={true}>
                                        <AdvertiseContent/>
                                    </Route>
                                    <Route path="/admin/merchant" exact={true}>
                                        <MerchantContent/>
                                    </Route>
                                    <Route path="/admin/user" exact={true}>
                                        <UserContent/>
                                    </Route>
                                    <Route path="/"  exact={true}>
                                        <HomeContent/>
                                    </Route>

                                    <Redirect from='*' to='/notFound'/>
                                </Switch>

                        </div>
                    </Content>
                    <Footer>
                        <AppFooter/>
                    </Footer>
                </Layout>
            </Layout>
        );
    }
}

function mapState(state) {
    return state.merchantReducer;
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({}, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(MainPage));