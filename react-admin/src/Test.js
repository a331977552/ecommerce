import logo from "./logo.svg";
import React from "react";

class Test extends React.Component {

    componentDidMount() {
        console.log("test componentDidMount", this.props.state);
    }

    componentWillUnmount() {
        console.log("test componentWillUnmount", this.props.state);
    }

    render() {

       const aaaaRecord= this.props.state === 1;
           if (aaaaRecord)
           return <div>div</div>
        else
            return <span>span</span>

    }

}


export default Test;