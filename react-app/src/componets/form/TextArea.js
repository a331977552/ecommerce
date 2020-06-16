import React from "react";

export default function  TextArea(props) {

    const  labelStyle= (props.labelStyle)||{};
    const  errorStyle= (props.errorStyle)||{};
    return  <div  style={props.style}>
        <label style={{display: 'block', width: '100%', marginTop: '5px',...labelStyle}}
               htmlFor={props.name}>{props.label}{props.required && <span style={{color:'red',marginLeft:'5px',fontSize:(labelStyle.fontSize)||'15px'}}>*</span>}</label>

        {!props.valid&&<label style={{display: 'block', color: 'red', width: '100%', marginTop: '5px', ...errorStyle,fontSize:(errorStyle.fontSize)||'12px'}}
                htmlFor={props.name}>{props.errorMsg}</label>}
        <textarea placeholder={props.placeholder} name={props.name} onChange={props.onChange} style={{width:'100%',marginTop:'15px'}} rows={props.rows} maxLength={props.maxLength}  />
    </div>
}