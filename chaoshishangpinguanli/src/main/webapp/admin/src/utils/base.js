const base = {
    get() {
        return {
            url : "http://localhost:8080/chaoshishangpinguanli/",
            name: "chaoshishangpinguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/chaoshishangpinguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "超市商品管理系统"
        } 
    }
}
export default base
