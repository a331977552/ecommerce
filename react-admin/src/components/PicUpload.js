import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import {Modal, Upload} from "antd";
import { PlusOutlined } from '@ant-design/icons';

class PicUpload extends Component {
    getBase64 = (file) => {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    }
    handleCancel = () => this.setState({ previewVisible: false });
    handlePreview = async file => {
        if (!file.url && !file.preview) {
            file.preview = await this.getBase64(file.originFileObj);
        }

        this.setState({
            previewImage: file.url || file.preview,
            previewVisible: true,
            previewTitle: file.name || file.url.substring(file.url.lastIndexOf('/') + 1),
        });
    };

    handleChange = ({fileList}) =>
    {
        this.setState({ fileList });
        if(this.props.onUploadFinished)
            this.props.onUploadFinished(fileList.filter(file=>file.status === 'done').map(file=>({id:file.response.id})));
    }
    state = {
        previewVisible: false,
        previewImage: '',
        previewTitle: '',
        fileList: [],
    };

    render() {
        const { previewVisible, previewImage, fileList, previewTitle } = this.state;
        const uploadButton = (
            <div>
                <PlusOutlined />
                <div className="ant-upload-text">Upload</div>
            </div>
        );
        return (
            <div className="clearfix">
                <Upload
                    headers={{Authorization:`Bearer ${localStorage.getItem('token')}`}}
                    accept={'.jpg,.png'}
                    action="/api/img/add"
                    listType="picture-card"
                    name={"img"}
                    fileList={fileList}
                    onPreview={this.handlePreview}
                    onChange={this.handleChange}
                >
                    {fileList.length >= 9 ? null : uploadButton}
                </Upload>
                <Modal
                    visible={previewVisible}
                    title={previewTitle}
                    footer={null}
                    onCancel={this.handleCancel}
                >
                    <img alt="example" style={{width: '100%'}} src={previewImage}/>
                </Modal>
            </div>
        );
    }
}

function mapState(state) {
    return {};
}

const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        //emptyCart: emptyCartAction
    }, dispatch);
}

export default withRouter(connect(mapState, mapDispatch)(PicUpload));