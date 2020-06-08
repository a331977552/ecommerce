

import React, { Component } from 'react';
import {Button, Result} from "antd";

export class RetryResult extends Component {
 render() {
  return (
   <div>
       <Result
           status="404"
           title="404"
           subTitle="网络连接失败!"
           extra={<Button type="primary" onClick={this.props.onRetryClicked}>重试</Button>}
       />
   </div>
  );
 }
}