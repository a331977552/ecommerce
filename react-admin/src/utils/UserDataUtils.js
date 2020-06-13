export function setUser(payload) {
    localStorage.setItem('merchant', JSON.stringify(payload.merchant))
    localStorage.setItem('token', payload.token)
}



export function removeUser() {
    localStorage.removeItem('merchant')
    localStorage.removeItem('token')
}

export function getUser() {
    return JSON.parse(localStorage.getItem('merchant'))
}
export function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}
export const pageUtil = {
    getPageSize: () => {
        return localStorage.getItem('pageSize')|| 20;
    },
    setPageSize: (pageSize) => {
        localStorage.setItem('pageSize',pageSize);
    }
};



