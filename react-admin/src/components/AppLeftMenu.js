import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";

import {UploadOutlined, UserOutlined, VideoCameraOutlined} from '@ant-design/icons';
import {Menu} from "antd";
import {selectMenu} from "../data/redux/actionCreators/commonActionCreator";
import menuData from '../data/MenuData'
const {SubMenu} = Menu;

class AppLeftMenu extends Component {

    handleClick = (e) => {
        this.navigateToNewContent(e.key)
    }
    componentDidMount() {
        this.navigateToNewContent(this.props.location.pathname)
    }
    navigateToNewContent=(key) =>{
        this.props.selectMenu();
        this.props.history.push(key);
    }



    render() {
        const {pathname} = this.props.location;
        return (
            <Menu theme="dark" mode="inline"
                  defaultOpenKeys={[pathname.substring(0, pathname.lastIndexOf('/'))]}
                  selectedKeys={[pathname]}
                  onSelect={this.handleClick}>
                {
                    menuData.map(node=>{
                        return node.children.length === 0?
                            <Menu.Item   key={node.routerPath}>{node.title}</Menu.Item>
                            :
                            <SubMenu   key={node.routerPath} title={node.title}>
                                {
                                    node.children.map(child=>{
                                        return  <Menu.Item key={child.routerPath}>{child.title}</Menu.Item>
                                    })
                                }
                            </SubMenu>
                    })
                }
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

export default withRouter(connect(mapState, mapDispatch)(AppLeftMenu));