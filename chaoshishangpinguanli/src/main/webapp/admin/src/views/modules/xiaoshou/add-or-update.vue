<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='shangpin'">
                    <el-form-item class="select" v-if="type!='info'"  label="商品" prop="shangpinId">
                        <el-select v-model="ruleForm.shangpinId" :disabled="ro.shangpinId" filterable placeholder="请选择商品" @change="shangpinChange">
                            <el-option
                                    v-for="(item,index) in shangpinOptions"
                                    v-bind:key="item.id"
                                    :label="item.shangpinName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="商品编号" prop="shangpinUuidNumber">
                        <el-input v-model="shangpinForm.shangpinUuidNumber"
                                  placeholder="商品编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="商品编号" prop="shangpinUuidNumber">
                            <el-input v-model="ruleForm.shangpinUuidNumber"
                                      placeholder="商品编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="商品名称" prop="shangpinName">
                        <el-input v-model="shangpinForm.shangpinName"
                                  placeholder="商品名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="商品名称" prop="shangpinName">
                            <el-input v-model="ruleForm.shangpinName"
                                      placeholder="商品名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="sessionTable !='shangpin' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.shangpinPhoto" label="商品照片" prop="shangpinPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (shangpinForm.shangpinPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.shangpinPhoto" label="商品照片" prop="shangpinPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.shangpinPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="商品类型" prop="shangpinValue">
                        <el-input v-model="shangpinForm.shangpinValue"
                                  placeholder="商品类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="商品类型" prop="shangpinValue">
                            <el-input v-model="ruleForm.shangpinValue"
                                      placeholder="商品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="商品库存" prop="shangpinKucunNumber">
                        <el-input v-model="shangpinForm.shangpinKucunNumber"
                                  placeholder="商品库存" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="商品库存" prop="shangpinKucunNumber">
                            <el-input v-model="ruleForm.shangpinKucunNumber"
                                      placeholder="商品库存" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="单位" prop="shangpinDanwei">
                        <el-input v-model="shangpinForm.shangpinDanwei"
                                  placeholder="单位" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="单位" prop="shangpinDanwei">
                            <el-input v-model="ruleForm.shangpinDanwei"
                                      placeholder="单位" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="进价" prop="shangpinJinjiaMoney">
                        <el-input v-model="shangpinForm.shangpinJinjiaMoney"
                                  placeholder="进价" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="进价" prop="shangpinJinjiaMoney">
                            <el-input v-model="ruleForm.shangpinJinjiaMoney"
                                      placeholder="进价" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shangpin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="售价" prop="shangpinShoujiaMoney">
                        <el-input v-model="shangpinForm.shangpinShoujiaMoney"
                                  placeholder="售价" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="售价" prop="shangpinShoujiaMoney">
                            <el-input v-model="ruleForm.shangpinShoujiaMoney"
                                      placeholder="售价" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoshouyuangong'">
                    <el-form-item class="select" v-if="type!='info'"  label="销售员工" prop="xiaoshouyuangongId">
                        <el-select v-model="ruleForm.xiaoshouyuangongId" :disabled="ro.xiaoshouyuangongId" filterable placeholder="请选择销售员工" @change="xiaoshouyuangongChange">
                            <el-option
                                    v-for="(item,index) in xiaoshouyuangongOptions"
                                    v-bind:key="item.id"
                                    :label="item.xiaoshouyuangongName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='xiaoshouyuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="工号" prop="xiaoshouyuangongUuidNumber">
                        <el-input v-model="xiaoshouyuangongForm.xiaoshouyuangongUuidNumber"
                                  placeholder="工号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="工号" prop="xiaoshouyuangongUuidNumber">
                            <el-input v-model="ruleForm.xiaoshouyuangongUuidNumber"
                                      placeholder="工号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoshouyuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="销售员工姓名" prop="xiaoshouyuangongName">
                        <el-input v-model="xiaoshouyuangongForm.xiaoshouyuangongName"
                                  placeholder="销售员工姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="销售员工姓名" prop="xiaoshouyuangongName">
                            <el-input v-model="ruleForm.xiaoshouyuangongName"
                                      placeholder="销售员工姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoshouyuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="销售员工手机号" prop="xiaoshouyuangongPhone">
                        <el-input v-model="xiaoshouyuangongForm.xiaoshouyuangongPhone"
                                  placeholder="销售员工手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="销售员工手机号" prop="xiaoshouyuangongPhone">
                            <el-input v-model="ruleForm.xiaoshouyuangongPhone"
                                      placeholder="销售员工手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoshouyuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="销售员工身份证号" prop="xiaoshouyuangongIdNumber">
                        <el-input v-model="xiaoshouyuangongForm.xiaoshouyuangongIdNumber"
                                  placeholder="销售员工身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="销售员工身份证号" prop="xiaoshouyuangongIdNumber">
                            <el-input v-model="ruleForm.xiaoshouyuangongIdNumber"
                                      placeholder="销售员工身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="sessionTable !='xiaoshouyuangong' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xiaoshouyuangongPhoto" label="销售员工头像" prop="xiaoshouyuangongPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (xiaoshouyuangongForm.xiaoshouyuangongPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xiaoshouyuangongPhoto" label="销售员工头像" prop="xiaoshouyuangongPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xiaoshouyuangongPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoshouyuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="xiaoshouyuangongEmail">
                        <el-input v-model="xiaoshouyuangongForm.xiaoshouyuangongEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="电子邮箱" prop="xiaoshouyuangongEmail">
                            <el-input v-model="ruleForm.xiaoshouyuangongEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="shangpinId" name="shangpinId" type="hidden">
            <input id="xiaoshouyuangongId" name="xiaoshouyuangongId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="销售编号" prop="xiaoshouUuidNumber">
                       <el-input v-model="ruleForm.xiaoshouUuidNumber"
                                 placeholder="销售编号" clearable  :readonly="ro.xiaoshouUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="销售编号" prop="xiaoshouUuidNumber">
                           <el-input v-model="ruleForm.xiaoshouUuidNumber"
                                     placeholder="销售编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="销售数量" prop="xiaoshouKucunNumber">
                       <el-input v-model="ruleForm.xiaoshouKucunNumber"
                                 placeholder="销售数量" clearable  :readonly="ro.xiaoshouKucunNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="销售数量" prop="xiaoshouKucunNumber">
                           <el-input v-model="ruleForm.xiaoshouKucunNumber"
                                     placeholder="销售数量" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12"  v-if="type=='info'">
                    <div>
                       <el-form-item class="input" label="总成本" prop="xiaoshouZongchengbenMoney">
                           <el-input v-model="ruleForm.xiaoshouZongchengbenMoney"
                                     placeholder="总成本" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12"  v-if="type=='info'">
                   <div>
                       <el-form-item class="input" label="总售价" prop="xiaoshouZongshoujiaMoney">
                           <el-input v-model="ruleForm.xiaoshouZongshoujiaMoney"
                                     placeholder="总售价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12"  v-if="type=='info'">
                   <div>
                       <el-form-item class="input" label="总利润" prop="xiaoshouZonglirunMoney">
                           <el-input v-model="ruleForm.xiaoshouZonglirunMoney"
                                     placeholder="总利润" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="备注" prop="xiaoshouContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.xiaoshouContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xiaoshouContent" label="备注" prop="xiaoshouContent">
                            <span v-html="ruleForm.xiaoshouContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                shangpinForm: {},
                xiaoshouyuangongForm: {},
                ro:{
                    shangpinId: false,
                    xiaoshouyuangongId: false,
                    xiaoshouUuidNumber: false,
                    xiaoshouKucunNumber: false,
                    xiaoshouZongchengbenMoney: false,
                    xiaoshouZongshoujiaMoney: false,
                    xiaoshouZonglirunMoney: false,
                    xiaoshouContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    shangpinId: '',
                    xiaoshouyuangongId: '',
                    xiaoshouUuidNumber: new Date().getTime(),
                    xiaoshouKucunNumber: '',
                    xiaoshouZongchengbenMoney: '',
                    xiaoshouZongshoujiaMoney: '',
                    xiaoshouZonglirunMoney: '',
                    xiaoshouContent: '',
                    insertTime: '',
                },
                shangpinOptions : [],
                xiaoshouyuangongOptions : [],
                rules: {
                   shangpinId: [
                              { required: true, message: '商品不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouyuangongId: [
                              { required: true, message: '销售员工不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouUuidNumber: [
                              { required: true, message: '销售编号不能为空', trigger: 'blur' },
                          ],
                   xiaoshouKucunNumber: [
                              { required: true, message: '销售数量不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouZongchengbenMoney: [
                              { required: true, message: '总成本不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouZongshoujiaMoney: [
                              { required: true, message: '总售价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouZonglirunMoney: [
                              { required: true, message: '总利润不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoshouContent: [
                              { required: true, message: '备注不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '销售时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

            if (this.role != "管理员"){
                this.ro.xiaoshouZongchengbenMoney = true;
                this.ro.xiaoshouZongshoujiaMoney = true;
                this.ro.xiaoshouZonglirunMoney = true;
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息

         this.$http({
             url: `shangpin/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.shangpinOptions = data.data.list;
            }
         });
         this.$http({
             url: `xiaoshouyuangong/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.xiaoshouyuangongOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            shangpinChange(id){
                this.$http({
                    url: `shangpin/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shangpinForm = data.data;
                    }
                });
            },
            xiaoshouyuangongChange(id){
                this.$http({
                    url: `xiaoshouyuangong/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xiaoshouyuangongForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `xiaoshou/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.shangpinChange(data.data.shangpinId)
                        _this.xiaoshouyuangongChange(data.data.xiaoshouyuangongId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`xiaoshou/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.xiaoshouCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.xiaoshouCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

