<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-col cols="12">
        <v-banner border class="mb-2">Cadastre-se</v-banner>
        <v-banner border>
          <v-form v-model="isValid">
            <v-container>
              <v-row>
                <v-col cols="12">
                  <v-text-field variant="outlined" v-model="viajante.nome" label="Nome" :rules="ruleNome"
                                placeholder="Informe o nome"></v-text-field>
                </v-col>
                <v-col cols="3">
                  <v-text-field variant="outlined" v-model="viajante.telefone" label="Telefone" :rules="ruleTelefone"
                                placeholder="Inform o Telefone"></v-text-field>
                </v-col>
                <v-col cols="3">
                  <v-text-field variant="outlined" v-model="viajante.dataNascimento" label="Data de Nascimento"
                                :rules="ruleDataNasc"
                                placeholder="Inform a Data de Nascimento"></v-text-field>
                </v-col>
                <v-col cols="3">
                  <v-text-field variant="outlined" v-model="viajante.cpf" label="CPF" :rules="ruleCpf"
                                placeholder="Inform o CPF"></v-text-field>
                </v-col>
                <v-col cols="3">
                  <v-text-field variant="outlined" v-model="viajante.password" label="Senha" type="password"
                                :rules="ruleSenha"
                                placeholder="Inform a Senha"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-btn variant="elevated" prepend-icon="mdi-save" block color="green" @click="salvar()"
                         :disabled="!isValid">Salvar
                  </v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-banner>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ViajanteModel from "@/models/viajante/ViajanteModel";
import viajanteService from "@/services/viajante/ViajanteService";

export default {
  data() {
    return {
      isValid: true,
      viajante: new ViajanteModel(),
      ruleNome: [(v) => !!v || "O Nome é obrigatório"],
      ruleTelefone: [(v) => !!v || "O telefone é obrigatório"],
      ruleDataNasc: [(v) => !!v || "A Data de nascimento é obrigatória"],
      ruleCpf: [(v) => !!v || "O CPF é obrigatório"],
      ruleSenha: [(v) => !!v || "A senha é obrigatória"]
    }
  },
  methods:{
    async salvar(){
      let retorno = await viajanteService.inserir(this.viajante)
      if (retorno.status===200){
        alert('Cadastrado com sucesso!')
        this.$emit("fechar");
      }else{
        alert('Ocorreu um erro')
        this.$router.push({name: 'home'})
      }
    }
  }
}
</script>