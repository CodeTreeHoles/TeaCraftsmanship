<template>
  <div class="popup">
    <el-card style="width: 35em; margin-top: 20px; margin-left: 20px" shadow="hover">
      <el-form label-width="80px" size="small">
        <el-upload class="avatar-uploader" action='http://localhost:8081/tea/avatar/upload' :show-file-list="false"
          :on-success="handleAvatarSuccess">
          <img v-if="form.avatarUrl" :src="form.avatarUrl" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-form-item label="用户名" style="margin-left: 10em; margin-top: -150px">
          <el-input v-model="form.name" autocomplete="off" style="width: 20em"></el-input>
        </el-form-item>
        <el-form-item label="性别" style="margin-left: 10em">
          <el-select v-model="form.sex" placeholder="请选择您的性别" style="width: 18.5em">
            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="个人介绍" style="margin-left: 10em">
          <el-input type="textarea" v-model="form.personalProfile" autocomplete="off" style="width: 20em"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button class="btn" @click="save" type="primary">保 存</el-button>
          <el-button class="btn" @click="unLogin" type="primary">登出</el-button>
          <el-button class="btn" type="primary" @click="return1">取消</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import instance from '@/api/home';
import axios from 'axios';

export default {
  name: "popup",
  data() {
    return {
      form: {
        avatarUrl: '',
        name: '',
        // email: '',
        personalProfile: '',
        sex: '',
      },
      userId: localStorage.getItem("userId"),
      options: [
        {
          value: "男",
          label: "男",
        },
        {
          value: "女",
          label: "女",
        },
      ],
      value: "",
      rules: {
      },
      interval: null,
    };
  },
  mounted() {
    this.getUser()
  },
  methods: {
    getUser() {
      instance.get('/user/' + this.userId).then(res => {
        this.form.name = res.data.name;
        this.form.sex = res.data.sex;
        this.form.personalProfile = res.data.personalProfile;
        this.form.avatarUrl = res.data.avatarUrl;
      })
    },
    // 头像上传
    handleAvatarSuccess(res) {
      // res就是头像文件路径
      this.form.avatarUrl = res;
    },
    return1() {
      this.$emit('close');
    },
    unLogin() {
      localStorage.removeItem("jwt");
      localStorage.removeItem("userId");
      localStorage.removeItem("username");
      localStorage.removeItem("password");
      localStorage.removeItem("avatar");
      window.location.reload();
    },
    save() {
      const user = new Object(this.form);
      user.id = this.userId
      axios.put("http://localhost:8081/tea/user/update", user).then()
      this.getUser()
      localStorage.setItem("avatar",this.form.avatarUrl)
      window.location.reload()
    }
  },
};
</script>

<style scoped>
.popup {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
}

.avatar-uploader {
  text-align: left;
  padding-bottom: 10px;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.el-card{
  background-color: #eee;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 138px;
  height: 138px;
  line-height: 138px;
  text-align: center;
}

.avatar {
  width: 160px;
  height: 160px;
  display: block;
}
.btn {
    background: #6a7e6b;
    color: #fff;
    border: 0;
  }
  
  .btn:hover {
    background: #6c766c;
    color: #fff;
    border: 0;
  }
  
  .btn:focus {
    background: #6c766c;
    color: #fff;
    border: 0;
  }
</style>
