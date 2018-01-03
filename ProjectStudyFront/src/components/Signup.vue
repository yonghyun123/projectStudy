<template>
  <div>
    <form novalidate class="md-layout-row md-gutter" @submit.prevent="validateUser">
      <md-card class="md-flex-50 md-flex-small-100">
        <md-card-header>
          <div class="md-title">Users</div>
        </md-card-header>

        <md-card-content>
          <div class="md-layout-row md-layout-wrap md-gutter">
            <div class="md-flex md-flex-small-100">
              <md-field :class="getValidationClass('name')">
                <label for="name">이름</label>
                <md-input name="name" id="name" autocomplete="given-name" v-model="form.name" :disabled="sending" />
                <span class="md-error" v-if="!$v.form.name.required">The name is required</span>
                <span class="md-error" v-else-if="!$v.form.name.minlength">Invalid name</span>
              </md-field>
            </div>
          </div>

          <md-field :class="getValidationClass('email')">
            <label for="email">Email</label>
            <md-input type="email" name="email" id="email" autocomplete="email" v-model="form.email" :disabled="sending" />
            <span class="md-error" v-if="!$v.form.email.required">The email is required</span>
            <span class="md-error" v-else-if="!$v.form.email.email">Invalid email</span>
          </md-field>
        </md-card-content>

        <md-progress-bar md-mode="indeterminate" v-if="sending" />

        <md-card-actions>
          <md-button type="submit" class="md-primary" :disabled="sending">Create user</md-button>
        </md-card-actions>
      </md-card>

      <md-snackbar :md-active.sync="userSaved">회원가입이 완료되었습니다.</md-snackbar>
    </form>
  </div>
</template>

<script>
  import { validationMixin } from 'vuelidate';
  import {
    required,
    email,
    minLength,
  } from 'vuelidate/lib/validators';

  export default {
    name: 'signup',
    mixins: [validationMixin],
    data: () => ({
      form: {
        name: null,
        email: null,
      },
      userSaved: false,
      sending: false,
      lastUser: null,
    }),
    validations: {
      form: {
        name: {
          required,
          minLength: minLength(2),
        },
        email: {
          required,
          email,
        },
      },
    },
    methods: {
      getValidationClass(fieldName) {
        const field = this.$v.form[fieldName];

        if (field) {
          return {
            'md-invalid': field.$invalid && field.$dirty,
          };
        } return null;
      },
      clearForm() {
        this.$v.$reset();
        this.form.name = null;
        this.form.email = null;
      },
      saveUser() {
        this.sending = true;

        // Instead of this timeout, here you can call your API
        window.setTimeout(() => {
          this.lastUser = `${this.form.name} `;
          this.userSaved = true;
          this.sending = false;
          this.clearForm();
        }, 1500);
      },
      validateUser() {
        this.$v.$touch();

        if (!this.$v.$invalid) {
          this.saveUser();
        }
      },
    },
  };
</script>

<style lang="scss" scoped>
  .md-progress-bar {
    position: absolute;
    top: 0;
    right: 0;
    left: 0;
  }
  .md-card{
    max-width: 560px;
    margin-top: 60px;
    margin-bottom: 60px;
    margin-left: auto;
    margin-right: auto;
  }
</style>