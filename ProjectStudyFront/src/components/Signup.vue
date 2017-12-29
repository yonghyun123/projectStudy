<template>
  <div class='panel panel-default'>
    <div class="panel-heading">회원가입</div>
    <div class="panel-body">
        <vue-form-generator :schema="schema" :model="model" :options="formOptions"></vue-form-generator>
        <md-dialog-alert
        :md-active.sync="isPassword"
        md-content="비밀번호를 입력하세요"
        md-confirm-text="확인" />
        <md-dialog-alert
        :md-active.sync="isConfirmPassword"
        md-content="확인 비밀번호를 입력하세요"
        md-confirm-text="확인" />   
        <md-dialog-alert
        :md-active.sync="isEmail"
        md-content="이메일을 입력하세요"
        md-confirm-text="확인" />   
        <md-dialog-alert
        :md-active.sync="isRrn"
        md-content="주민등록번호를 입력하세요"
        md-confirm-text="확인" />
        <md-dialog-alert
        :md-active.sync="lenRrn"
        md-content="13자리 주민번호를 입력하세요"
        md-confirm-text="확인" />   
        <md-dialog-alert
        :md-active.sync="isSame"
        md-content="비밀번호가 일치하지 않습니다"
        md-confirm-text="확인" />
        <md-dialog-alert
        :md-active.sync="fail"
        md-content="중복된 주민번호가 있습니다."
        md-confirm-text="확인" />         
        <md-dialog-alert
        :md-active.sync="success"
        md-content="회원가입이 성공했습니다."
        md-confirm-text="확인" />      
    </div>
    <footer>
      <md-button class="md-raised md-primary" @click="Confirm()">회원가입</md-button>
    </footer> 
  </div>
</template>

<script>
export default {
  name: 'signup',
  data() {
    return {
      title: 'Input Your Information in SignUp Page',
      isPassword: false,
      isConfirmPassword: false,
      isEmail: false,
      isSame: false,
      isRrn: false,
      lenRrn: false,
      fail: false,
      success: false,
      model: {
        name: null,
        password: null,
        confirmPassword: null,
        rrn: null,
        edu: null,
        department: '개발부',
        email: null,
      },
      schema: {
        fields: [
          {
            type: 'input',
            inputType: 'text',
            label: '이름',
            model: 'name',
            placeholder: 'Your Name',
            featured: true,
            // validator: this.$VueFormGenerator.validators.string,
          },
          {
            type: 'input',
            inputType: 'password',
            label: '주민번호(공백없이 입력)',
            model: 'rrn',
            featured: true,
            required: true,
            // validator: this.$VueFormGenerator.validators.string,
          },
          {
            type: 'input',
            inputType: 'password',
            label: '비밀번호',
            model: 'password',
            min: 6,
            hint: 'Minimum 6 Characters',
            featured: true,
            required: true,
            // validator: this.$VueFormGenerator.validators.string,
          },
          {
            type: 'input',
            inputType: 'password',
            label: '비밀번호 확인',
            model: 'confirmPassword',
            min: 6,
            featured: true,
            required: true,
            // validator: this.$VueFormGenerator.validators.string,
          },
          {
            type: 'select',
            label: '근무부서',
            model: 'department',
            featured: true,
            values: ['마케팅 부서', '경영지원', '연구개발', '개발부'],
          },
          {
            type: 'select',
            label: '졸업구분',
            model: 'edu',
            featured: true,
            values: ['박사', '석사', '학사', '전문학사', '고졸'],
          },
          {
            type: 'input',
            inputType: 'email',
            label: '이메일',
            model: 'email',
            placeholder: '이메일을 입력하시오',
            required: true,
            featured: true,
            // validator: this.$VueFormGenerator.validators.string,
          },
        ],
      },
      formOptions: {
        validateAfterLoad: true,
        validateAfterChanged: true,
      },
    };
  },
  methods: {
    Confirm() {
      if (this.model.rrn === null) this.isRrn = true;
      else if (this.model.rrn.length !== 13) this.lenRrn = true;
      else if (this.model.password === null) this.isPassword = true;
      else if (this.model.confirmPassword === null) this.isConfirmPassword = true;
      else if (this.model.password !== this.model.confirmPassword) this.isSame = true;
      else if (this.model.email === null) this.isEmail = true;
      else {
        this.axios.post('http://localhost:8080/app/signup/', {
          empRrn: this.model.rrn,
        })
      .then((res) => { // DB에 같은 주민번호가 있을시,
        if (res.data) this.fail = true;
        else {
          this.success = true;
          this.$router.push({ path: '/' });
        }
      });
      }
    },
  },
};
</script>
<style style lang="scss" >
fieldset {
  align-self: auto;
}
.panel {
  max-width: 560px; // 가운데 정렬을 위하여
  margin-top: 60px;
  margin-right: auto;
  margin-bottom: 60px;
  margin-left: auto;
}
.panel-heading {
  font-size: 24px;
  font-weight: bold;
  margin-top: 30px;
  margin-bottom: 30px;      
}
.panel-body {
  max-width: 560px; // 가운데 정렬을 위하여
  margin-bottom: 60px;
}				
.field-checklist .wrapper {
	width: 100%;
}
footer {
  display: flex;
  justify-content: center;
}
</style>