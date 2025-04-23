<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='caigouyuangong'"  label='采购员工工号' prop="caigouyuangongUuidNumber">
               <el-input v-model="ruleForm.caigouyuangongUuidNumber"  placeholder='采购员工工号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='caigouyuangong'"  label='采购员工姓名' prop="caigouyuangongName">
               <el-input v-model="ruleForm.caigouyuangongName"  placeholder='采购员工姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='caigouyuangong'"  label='采购员工手机号' prop="caigouyuangongPhone">
               <el-input v-model="ruleForm.caigouyuangongPhone"  placeholder='采购员工手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='caigouyuangong'"  label='采购员工身份证号' prop="caigouyuangongIdNumber">
               <el-input v-model="ruleForm.caigouyuangongIdNumber"  placeholder='采购员工身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='caigouyuangong'" label='采购员工头像' prop="caigouyuangongPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.caigouyuangongPhoto?ruleForm.caigouyuangongPhoto:''"
                         @change="caigouyuangongPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='caigouyuangong'"  label='电子邮箱' prop="caigouyuangongEmail">
               <el-input v-model="ruleForm.caigouyuangongEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xiaoshouyuangong'"  label='工号' prop="xiaoshouyuangongUuidNumber">
               <el-input v-model="ruleForm.xiaoshouyuangongUuidNumber"  placeholder='工号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xiaoshouyuangong'"  label='销售员工姓名' prop="xiaoshouyuangongName">
               <el-input v-model="ruleForm.xiaoshouyuangongName"  placeholder='销售员工姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xiaoshouyuangong'"  label='销售员工手机号' prop="xiaoshouyuangongPhone">
               <el-input v-model="ruleForm.xiaoshouyuangongPhone"  placeholder='销售员工手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='xiaoshouyuangong'"  label='销售员工身份证号' prop="xiaoshouyuangongIdNumber">
               <el-input v-model="ruleForm.xiaoshouyuangongIdNumber"  placeholder='销售员工身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='xiaoshouyuangong'" label='销售员工头像' prop="xiaoshouyuangongPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.xiaoshouyuangongPhoto?ruleForm.xiaoshouyuangongPhoto:''"
                         @change="xiaoshouyuangongPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='xiaoshouyuangong'"  label='电子邮箱' prop="xiaoshouyuangongEmail">
               <el-input v-model="ruleForm.xiaoshouyuangongEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });
  },
  methods: {
    caigouyuangongPhotoUploadChange(fileUrls) {
        this.ruleForm.caigouyuangongPhoto = fileUrls;
    },
    xiaoshouyuangongPhotoUploadChange(fileUrls) {
        this.ruleForm.xiaoshouyuangongPhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.caigouyuangongUuidNumber)&& 'caigouyuangong'==this.flag){
                             this.$message.error('采购员工工号不能为空');
                             return
                         }

                         if((!this.ruleForm.caigouyuangongName)&& 'caigouyuangong'==this.flag){
                             this.$message.error('采购员工姓名不能为空');
                             return
                         }

                             if( 'caigouyuangong' ==this.flag && this.ruleForm.caigouyuangongPhone&&(!isMobile(this.ruleForm.caigouyuangongPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.caigouyuangongIdNumber)&& 'caigouyuangong'==this.flag){
                             this.$message.error('采购员工身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.caigouyuangongPhoto)&& 'caigouyuangong'==this.flag){
                             this.$message.error('采购员工头像不能为空');
                             return
                         }

                             if( 'caigouyuangong' ==this.flag && this.ruleForm.caigouyuangongEmail&&(!isEmail(this.ruleForm.caigouyuangongEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.xiaoshouyuangongUuidNumber)&& 'xiaoshouyuangong'==this.flag){
                             this.$message.error('工号不能为空');
                             return
                         }

                         if((!this.ruleForm.xiaoshouyuangongName)&& 'xiaoshouyuangong'==this.flag){
                             this.$message.error('销售员工姓名不能为空');
                             return
                         }

                             if( 'xiaoshouyuangong' ==this.flag && this.ruleForm.xiaoshouyuangongPhone&&(!isMobile(this.ruleForm.xiaoshouyuangongPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.xiaoshouyuangongIdNumber)&& 'xiaoshouyuangong'==this.flag){
                             this.$message.error('销售员工身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.xiaoshouyuangongPhoto)&& 'xiaoshouyuangong'==this.flag){
                             this.$message.error('销售员工头像不能为空');
                             return
                         }

                             if( 'xiaoshouyuangong' ==this.flag && this.ruleForm.xiaoshouyuangongEmail&&(!isEmail(this.ruleForm.xiaoshouyuangongEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes)&& this.flag !='users'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
