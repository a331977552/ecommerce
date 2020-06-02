import React, {Component} from 'react';
import {Button} from "antd";

class AppFooter extends Component {
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