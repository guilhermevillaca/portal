import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  localStorage.setItem('token', 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IlJETkVOMEV6UmtVM05VWkRNRUZETlVORE1VUTROa1EzUXpZeFFrTXhRVFV5TlVVMlJEVXpNZyJ9.eyJpc3MiOiJodHRwczovL2d1aWxoZXJtZXZpbGxhY2EuYXV0aDAuY29tLyIsInN1YiI6IkZvR1hhcmZXZEt3OVlCNHM2QjVYaFNiM2JLVEpFTmZLQGNsaWVudHMiLCJhdWQiOiJodHRwczovL2d1aWxoZXJtZXZpbGxhY2EuZ2l0aHViLmlvLyIsImlhdCI6MTc0ODM4ODUwNSwiZXhwIjoxNzQ4NDc0OTA1LCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMiLCJhenAiOiJGb0dYYXJmV2RLdzlZQjRzNkI1WGhTYjNiS1RKRU5mSyJ9.WXCyxv03Wkxz9IFe5nyA3GiZqXtoyp5WditLdEWvGOCzILvZZArnmtqosC3PBFctBXy7C-ybOT-pB7G3vuBKxJ9c7kIxhwXrBNOU8Y9IQDtm9Mhhqu4qmp6Rs2BasiLBSWfvhR1_Ap9My3sutzX88-cTGV_bHXN3qMDtDIC_dMsYZKWS_2-JeGL5MyHcnx_uGB4WBudgEWq_fdaZink4aQoRUiSSHLiLzV_El7w65cQTOH-GjzjtmoVVnakGmD6Htn5CBCqwH2GOkvKHI7wh2v_RfWY3fBP9nZaxTPU_vTtxDCwXonDwdwHHDwEfMHEg2MYuNG3EZsbJNfj0uifwzw');
  const token = localStorage.getItem('token');
  const authReq = token
    ? req.clone({ setHeaders: { Authorization: `Bearer ${token}` } })
    : req;
  return next(authReq);
};