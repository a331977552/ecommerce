import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Form, Input, Button, Checkbox, Layout, Row, Col, Divider} from 'antd';
import {UserOutlined, LockOutlined} from '@ant-design/icons';
import {httpSignIn} from "../data/http/HttpRequest";
import {merchantSignIn} from "../data/redux/actionCreators/commonActionCreator";
import AppFooter from "../components/AppFooter";


class LoginPage extends Component {
    onFinish = values => {

        httpSignIn(values,(response)=>{
            const token =response.headers['token'].substring('Bearer '.length);
            this.props.merchantSignIn({token,merchant:response.data});
            this.props.history.push("/")
        },(error)=>{
            if (error.response && error.response.status) {
                    alert("账户或用户名密码不正确!");
            } else {
                alert(error.message);
            }
        });
    };
    copyToClipboard = (e) => {
        const supported = document.queryCommandSupported('copy');
        if(!supported)
            return;
        const textField = document.createElement('textarea');
        textField.innerText = e.target.innerText;
        document.body.appendChild(textField);
        textField.select();
        textField.setSelectionRange(0, 99); /*For mobile devices*/
        document.execCommand('copy');
        textField.remove();
        e.target.focus();
        alert('Copied!')
    };

    render() {
        return (
            <div style={{
                width: '100vw',
                height: '100vh',
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'space-between',
                alignItems: 'center'
            }}>
                <div />
                <div style={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    marginBottom:'150px'
                }}>
                    <div style={{marginBottom:'100px',fontSize:'40px'}}>管理系统</div>
                    <Row style={{width: '100vw'}} gutter={{xs: 8, sm: 16, md: 24, lg: 32}}>
                        <Col xs={{span: 22, offset: 1}} sm={{span: 20, offset: 2}} md={{span: 14, offset: 5}}
                             lg={{span: 10, offset: 7}} xl={{span: 6, offset: 9}} xxl={{span: 4, offset: 10}}>
                            <Form
                                name="normal_login"
                                className="login-form"
                                initialValues={{
                                    remember: true,
                                }}
                                onFinish={this.onFinish}
                            >
                                <Form.Item
                                    name="username"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please input your Username!',
                                        },
                                    ]}
                                >
                                    <Input prefix={<UserOutlined className="site-form-item-icon"/>}
                                           placeholder="Username"/>
                                </Form.Item>
                                <Form.Item
                                    name="password"
                                    rules={[
                                        {
                                            required: true,
                                            message: 'Please input your Password!',
                                        },
                                    ]}
                                >
                                    <Input
                                        prefix={<LockOutlined className="site-form-item-icon"/>}
                                        type="password"
                                        placeholder="Password"
                                    />
                                </Form.Item>
                                <Form.Item>
                                    <Form.Item name="remember" valuePropName="checked" noStyle>
                                        <Checkbox>Remember me</Checkbox>
                                    </Form.Item>
                                    {/*<a className="login-form-forgot" href="">*/}
                                    {/*    Forgot password*/}
                                    {/*</a>*/}
                                </Form.Item>

                                <Form.Item>
                                    <Button type="primary"  htmlType={'submit'} className="login-form-button">
                                       登录
                                    </Button>
                                </Form.Item>
                            </Form>
                        </Col>
                    </Row>
                </div>
                <AppFooter/>

            </div>
        );
    }
}

function mapState(state) {
    console.log(state)
    return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        merchantSignIn:merchantSignIn
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(LoginPage));