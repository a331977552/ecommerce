import React, { Component } from 'react';
import {Spin} from "antd";

export default function CenteredLoading(props) {


    return <div style={{height:props.height || '100%',width:'100%',display:'flex',alignItems:'center',justifyContent:'center'}}><Spin size={props.size || 'large'}/></div>

}