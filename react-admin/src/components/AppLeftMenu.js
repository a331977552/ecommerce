import React, { Component } from 'react';
import { connect } from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";

import {UploadOutlined, UserOutlined, VideoCameraOutlined} from '@ant-design/icons';
import {Menu} from "antd";
import {selectMenu} from "../data/redux/actionCreators/commonActionCreator";
const {SubMenu} = Menu;
class AppLeftMenu extends Component {
    handleClick = (e) =>
    {
        this.props.selectMenu(e.key);
        this.props.history.push(e.key);
    }


 render() {
     const {pathname} =this.props.location;
  return (
       <Menu theme="dark" mode="inline" defaultSelectedKeys={[pathname]} defaultOpenKeys={[pathname.substring(0,pathname.lastIndexOf('/'))]}
             onClick={this.handleClick}>
           <Menu.Item key="/" icon={<UserOutlined />}>主页</Menu.Item>
           <SubMenu key="/shop" icon={<UserOutlined />} title="店铺管理">
               <Menu.Item key="/shop/productAdd">商品添加</Menu.Item>
               <Menu.Item key="/shop/productEdit">商品编辑</Menu.Item>
               <Menu.Item key="/shop/categoryEdit">种类编辑</Menu.Item>
           </SubMenu>
           <SubMenu key="/order" icon={<UserOutlined />} title="订单管理">
               <Menu.Item key="/order/orderEdit">订单编辑</Menu.Item>
           </SubMenu>
           <SubMenu key="/statis" icon={<UserOutlined />} title="数据统计">
               <Menu.Item key="/statis/overview">数据统计</Menu.Item>
           </SubMenu>
           <SubMenu key="/marketing" icon={<UserOutlined />} title="营销管理">
               <Menu.Item key="/marketing/ad">营销管理</Menu.Item>
           </SubMenu>
           <SubMenu key="/admin" icon={<UserOutlined />} title="超级管理员">
               <Menu.Item key="/admin/merchant">商户管理</Menu.Item>
               <Menu.Item key="/admin/user">用户管理</Menu.Item>
           </SubMenu>
       </Menu>
  );
 }
}
function mapState(state) {
 return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        selectMenu
    }, dispatch);
}

export default withRouter(connect(mapState,mapDispatch)(AppLeftMenu));