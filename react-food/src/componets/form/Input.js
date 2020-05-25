import React from "react";

export default function Input(props) {

    const labelStyle =props.labelStyle||{};
    const errorStyle =props.errorStyle||{};
    const localProps = {...props};
    delete localProps.labelStyle;
    delete localProps.errorStyle;
    delete localProps.errorMsg;
    delete localProps.required;
    delete localProps.valid;

    return (<div>
            <label style={{display: 'block', width: '100%', marginTop: '5px',...labelStyle}}
                   htmlFor={props.name}>{props.label}{props.required && <span style={{color:'red',marginLeft:'5px',fontSize:(labelStyle.fontSize)||'15px'}}>*</span>}</label>

            {!props.valid&&<label style={{display: 'block', color: 'red', width: '100%', marginTop: '5px', ...errorStyle,fontSize:(errorStyle.fontSize)||'12px'}}
                    htmlFor={props.name}>{props.errorMsg}</label>}
            <input style={{
                display: 'block',
                width: '100%',
                marginTop: '5px',
                fontSize: '14px',
                height: '30px',
                padding: '10px'
            }}
                   {...localProps}
            />
        </div>
    )
}