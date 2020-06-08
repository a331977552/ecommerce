import React, {Component} from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from "redux";
import {Skeleton, Spin} from "antd";
import {RetryResult} from "./RetryResult";
import {httpGetContent} from "../data/http/HttpRequest";
import {findDataByPathname} from "../data/MenuData";

export default function WithContentLoadingHOC(WrappedContent) {
    const mapStateToProps = (state,props) => {
        const data = findDataByPathname(props.location.pathname);
        const reducer = data.reducer.name;
        if(reducer)
        {
            //cached
            return {...state[reducer],dataPath:data.dataPath};
        }else{
            return {contentLoading: false,success: true}
        }
    }
    const mapDispatch = (dispatch, ownProps) => {
        const actions = findDataByPathname(ownProps.location.pathname).actions||{};
        return bindActionCreators({
            onContentSuccess:actions.success,
            onContentFailed:actions.failed,
            onContentRetry:actions.retry,
        }, dispatch);
    }

    return connect(mapStateToProps, mapDispatch)(class extends React.Component {
        constructor(props) {
            super(props);
        }
        onRetryClicked = (e) => {
            const { dataPath} = this.props;
            this.props.onContentRetry&&this.props.onContentRetry({dataPath});
            this.loadingContentData();
        };

        componentDidMount() {
            this.loadingContentData();
        }
        loadingContentData = () => {
            if(this.props.success)
                return ;
            const { dataPath} = this.props;
            if(dataPath){
                httpGetContent(dataPath,
                        response =>
                                this.props.onContentSuccess&& this.props.onContentSuccess({dataPath,data:response.data}),
                        failed =>
                            this.props.onContentFailed&&this.props.onContentFailed({dataPath})
            );
            }
        };

        render() {
            const {contentLoading, success} = this.props;
            if (contentLoading) {
                return (
                    <div style={{textAlign: 'center'}}>
                        <Spin/>
                        <Skeleton/>
                    </div>)
            } else if (success) {
                return <WrappedContent {...this.props}/>;
            } else {
                return <RetryResult onRetryClicked={this.onRetryClicked}/>
            }
        }
    })
}

