import React, {Component} from 'react';
import {withRouter} from "react-router-dom";
import {Breadcrumb} from "antd";
import {findDataByPathname} from "../data/MenuData";

class AppBreadcrumb extends Component {

    render() {
        const data = findDataByPathname(this.props.location.pathname);
        const items = data.breadCrumb;

        return (
            <Breadcrumb style={{margin: '8px 0'}}>
                {
                    items.map(item => <Breadcrumb.Item key={item}>{item}</Breadcrumb.Item>)
                }
            </Breadcrumb>
        );
    }
}

export default withRouter(AppBreadcrumb);