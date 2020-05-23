import React from "react";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {onCategorySelected} from "../data/actions/componentActionCreators";


const categoryItemStyle = {
    width: '100%', flex: 'none',
    borderBottom: "1px solid", padding: '3vw'
}

const categoryListStyle = {
    overflowY: 'scroll',
    height: '100%',
    width: '100%',
}

class LeftMenuList extends React.Component {

    constructor(props) {
        super(props);
        this.cateRefs = {};
        props.categories.forEach((cate, index) => {
            this.cateRefs[cate.id] = React.createRef();
        })
        this.state = {
            localSelectedIndex: props.categorySelectedIndex
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevProps.categorySelectedIndex !== this.props.categorySelectedIndex && this.props.sender !== 'leftlist') {
            this.scrollToView();
        }
    }

    scrollToView = () => {
        this.cateRefs[this.props.categorySelectedIndex].current.scrollIntoView(
            {
                behavior: 'instant',
                block: 'center',
            });

    }
    onCategorySelected = (e, id) => {
        this.props.onCategorySelected({categorySelectedIndex: id, sender: 'leftlist'});
    }

    render() {
        const {props, state} = this;
        return (
            <div style={categoryListStyle}>
                {props.categories.map(category => <div ref={this.cateRefs[category.id]} key={category.id}
                                                       style={{
                                                           ...categoryItemStyle,
                                                           backgroundColor: props.categorySelectedIndex === category.id ? 'gray' : ''
                                                       }} onClick={(e) => {
                    this.onCategorySelected(e, category.id)
                }}>{category.title}</div>)}
            </div>
        )
    }
}


const mapState = (state) => {
    return {categorySelectedIndex: state.menuReducer.categorySelectedIndex, sender: state.menuReducer.sender}
}
const mapDispatch = (dispatch, ownProps) => bindActionCreators({
    onCategorySelected: onCategorySelected
}, dispatch);


export default connect(mapState, mapDispatch)(LeftMenuList);