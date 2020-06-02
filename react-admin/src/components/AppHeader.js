import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Menu, Dropdown, Button} from 'antd';
import {DownOutlined} from '@ant-design/icons';
import {merchantSignOut} from "../data/redux/actionCreators/commonActionCreator";


class AppHeader extends Component {

    signOut = (e) => {
        this.props.merchantSignOut();
        this.props.history.replace("/login")

    }



    menu = () => {
        return <Menu>
            <Menu.Item>
                <Button type="link" htmlType="button" onClick={this.copyToClipboard}>
                    编辑</Button>
            </Menu.Item>
            <Menu.Item>
                <Button type="link" htmlType="button" onClick={this.signOut}>
                    注销</Button>
            </Menu.Item>
        </Menu>
    }



    render() {
        const {merchant} = this.props;
        return (
            <div style={{width: '100%', display: 'flex', flexDirection: 'row'}}>
                <div style={{flexGrow: '1'}}/>
                <div><Dropdown overlay={this.menu()}>
                    <a className="ant-dropdown-link" onClick={e => e.preventDefault()}>
                        {merchant.name} <DownOutlined/>
                    </a>
                </Dropdown></div>
            </div>
        );
    }
}

function mapState(state) {
    return {merchant: state.merchantReducer.merchant};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        merchantSignOut
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(AppHeader));