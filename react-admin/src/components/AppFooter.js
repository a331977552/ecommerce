import React, {Component} from 'react';
import {Button,message} from "antd";

class AppFooter extends Component {

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
        message.success("Copied!");
    };
    componentWillUnmount() {
        message.destroy();
    }

    render() {
        return (
            <div style={{width: '100%', textAlign: 'center'}}>
                <div ><span style={{marginRight:'20px'}}>©2020 Copyright</span>  商业合作,请联系
                    <Button style={{
                        fontStyle: 'oblique',
                        fontWeight: 'bold'
                    }} type="link" htmlType="button" onClick={this.copyToClipboard}>
                        a13521874221@gmail.com</Button>
                </div>
            </div>
        );
    }
}


export default AppFooter;