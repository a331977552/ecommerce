import React, {Component} from 'react';
import {connect} from 'react-redux';
import {withRouter} from "react-router-dom";
import {bindActionCreators} from "redux";
import WithContentLoadingHOC from "../../../components/WithContentLoadingHOC";
import {Form, Input, Popconfirm, Table, message, InputNumber, Button} from "antd";
import {deleteCategory, updateCategory} from "../../../data/redux/reducers/shop/CategoryActionCreator";
import {httpAddCategory, httpDeleteCategory, httpGetContent, httpUpdateCategory} from "../../../data/http/HttpRequest";

class CategoryEditContent extends Component {

    state = {
        addingData: undefined,
        editingKey: ''
    };
    form = React.createRef();

    isEditing = record => record.id === this.state.editingKey;

    edit = record => {
        this.setFormData({...record});
        this.setState({editingKey: record.id});
    };

    cancel = () => this.setState({editingKey: '', addingData: undefined});


    delete = key => {
        const newData = [...this.props.data];
        const index = newData.findIndex(item => item.id === key);
        if (index > -1) {
            const item = newData[index];
            httpDeleteCategory(item.id, () => {
                newData.splice(index, 1);
                this.props.updateCategory({data: newData});
                message.success("删除成功");
            }, (error) => {
                message.warn(error.message);
            })
        } else {
            message.warn("找不到要删除的目录")
        }
    }

    addCategory = (newData, row) => {
        httpAddCategory(row, (response) => {
            message.success("添加目录成功");
            newData.push(response.data);
            this.props.updateCategory({data: newData,latestInsertId:response.data.id});
        }, (error) => {
            message.error(error.message);
        })

    }

    save = async key => {
        try {
            const row = await this.form.current.validateFields();
            const newData = [...this.props.data];
            if (key === -1) {
                this.addCategory(newData, row);
            } else {
                const index = newData.findIndex(item => key === item.id);
                if (index > -1) {
                    const item = newData[index];
                    httpUpdateCategory({...item, ...row}, () => {
                        message.success("修改成功");
                        newData.splice(index, 1, {...item, ...row});
                        this.props.updateCategory({data: newData});
                    }, (error) => {
                        message.warn(error.message);
                    });
                } else {
                    message.warn("找不到要修改的目录")
                }
            }
            this.setState({
                editingKey: '',
                addingData: undefined
            });
        } catch (errInfo) {
            console.log(errInfo);
            message.error((errInfo.errors || errInfo.errorFields[0].errors)[0]);
        }

    };
    columns = [
        {
            title: '目录名称',
            dataIndex: 'title',
            editable: true,
            render: (text, row, index) => (row.latestInsertId ? <span style={{fontWeight:'700',color:'red'}}>{text}</span>:text)
        },
        {
            title: '排名',
            dataIndex: 'priority',
            editable: true,
            width: '100px',
            render: (text, row, index) => text,
        },
        {
            title: '操作',
            dataIndex: 'operation',
            width: '200px',
            render: (_, record) => {
                const editable = this.isEditing(record);
                return editable ? (<span>
                    <a href="#!" onClick={() => this.save(record.id)} style={{marginRight: 8}}>
                        保存
                    </a>
                    <Popconfirm title={record.id === -1 ? '确定取消添加吗?' : '确定取消编辑吗?'} onConfirm={this.cancel}>
                      <a>取消</a>
                    </Popconfirm>
                    </span>) : (
                    <span>
                    <a style={{marginRight: '16px'}} disabled={this.state.editingKey !== ''}
                       onClick={() => this.edit(record)}>
                        编辑
                    </a>
                    <Popconfirm title="确定要删除吗?" onConfirm={() => this.delete(record.id)}>
                      <a disabled={this.state.editingKey !== ''}>删除</a>
                    </Popconfirm>
                    </span>
                )
            }
        }
    ]

    mergedColumns = this.columns.map(col => {
        if (!col.editable) {
            return col;
        }
        return {
            ...col,
            onCell: record => ({
                record,
                inputType: col.dataIndex === 'priority' ? 'number' : 'text',
                dataIndex: col.dataIndex,
                title: col.title,
                editing: this.isEditing(record),
            }),
        };
    });

    setFormData = (row) =>{
        this.form.current.setFieldsValue(row);
    }
    handleAdd = () => {
        const addingData= {priority: 0, title: '', id: -1};
        this.setFormData({...addingData});
        this.setState({
            addingData,
            editingKey: -1,
        })
    }

    EditableCell = ({editing, dataIndex, title, inputType, record, index, children, ...restProps}) =>(
            <td {...restProps}>
                {editing ? (<Form.Item
                        name={dataIndex}
                        style={{margin: 0}}
                        rules={[{required: true, message: `${title} 不能为空`},]}>
                        {inputType === 'number' ? <InputNumber placeholder={`请输入 ${title}`} min={0} max={65536}/> : <Input placeholder={ `请输入 ${title}`}/>}
                    </Form.Item>) :
                    (children)}
            </td>);



    render() {
        const newData = [...this.props.categoryTreeData];
        this.state.addingData && newData.unshift(this.state.addingData);
        return (
            <div>
                <Button onClick={this.handleAdd} type="primary" style={{marginBottom: 16}}>
                    添加一个新的目录
                </Button>
                <Form ref={this.form} component={false}>
                    <Table
                        columns={this.mergedColumns} components={{
                        body: {
                            cell: this.EditableCell,
                        },
                    }} indentSize={40} rowKey={"id"} dataSource={newData} bordered/>
                </Form>
            </div>
        );
    }
}


const mapDispatch = (dispatch, ownProps) => {
    return bindActionCreators({
        deleteCategory,
        updateCategory
    }, dispatch);
}

export default withRouter(connect(null, mapDispatch)(WithContentLoadingHOC(CategoryEditContent)));