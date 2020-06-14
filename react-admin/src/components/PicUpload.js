import React, {Component} from 'react';
import {Modal, Spin, Upload} from "antd";
import { PlusOutlined } from '@ant-design/icons';
class PicUpload extends Component {
    constructor(props) {
        super(props);
        const fileList = (this.props.fileList||[]).map(file=>({uid:file.id, status:'done',name: file.file_name,url:file.url,response:file}));
        this.state ={
            previewVisible: false,
            previewImage: null,
            previewTitle: '',
            fileList,
        }
    }
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
        this.setImgIds(fileList)
    };
    componentDidMount() {
        this.setImgIds(this.state.fileList)
    }

    setImgIds(fileList){
        if(this.props.imgIdList){
            this.props.imgIdList(fileList.filter(file=>file.status === 'done').map(file=>({
                id:file.response.id})));
        }
    }

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
                        <img alt="img"
                             src={previewImage}/>
                </Modal>
            </div>
        );
    }
}




export default PicUpload;