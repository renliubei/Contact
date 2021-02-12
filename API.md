# Contact接口文档

v1.0

powered by xmx

## 0 规范说明

### 0.1 通信协议

HTTPS通信协议

### 0.2 字符编码

HTTP通讯及报文BASE64编码均采用UTF-8字符集编码格式。

### 0.3 格式说明

元素出现要求说明:

| 符号 |                    说明                     |
| :--: | :-----------------------------------------: |
|  R   |      报文中该元素必须出现（Required）       |
|  O   |      报文中该元素可选出现（Optional）       |
|  C   | 报文中该元素在一定条件下出现（Conditional） |

### 0.4 相应报文说明

#### 0.4.1 结构说明

所有接口响应均采用JSON格式，如无特殊说明，每次请求的返回值中，都包含下列字段：

| 参数名称  |  类型   | 出现要求 |         描述         |
| :-------: | :-----: | :------: | :------------------: |
|   code    | Integer |    R     |        响应码        |
|    msg    | String  |    R     |       相应描述       |
|   data    | Object  |    R     | 每个接口有对应的数据 |
| timestamp | String  |    R     |         时间         |

#### 0.4.2 响应报文实例

```json
{
    "code" : 200,
    "msg" : "OK",
    "data" : {
        "id" : "0001",
        "password" : "0001"
    },
    "timestamp": "2021-02-09T20:28:29.3658782"
}
```



## 1 服务器总接口

```
(IP地址):8080/api
```

## 2 用户操作接口

```
/user
```

### 2.1 注册接口

- **接口地址:**	`/register`

#### 2.1.1 请求方法

POST

#### 2.1.2 请求参数

|  参数名  | 数据类型 | 出现要求 |          描述          |
| :------: | :------: | :------: | :--------------------: |
|  moblie  |  String  |    R     |      用户手机号码      |
| password |  String  |    R     |        用户密码        |
| username |  String  |    R     |         用户名         |
|   sex    |  String  |    R     | 1 表示男性，0 表示女性 |

#### 2.1.3 响应参数

| 参数名称  |  类型   | 出现要求 |   描述   |
| :-------: | :-----: | :------: | :------: |
|   code    | Integer |    R     |  响应码  |
|    msg    | String  |    R     | 相应描述 |
|   data    | Object  |    R     |   null   |
| timestamp | String  |    R     |   时间   |

响应示例

```json
{
    "code": 200,
    "msg": "OK",
    "data": null,
    "timestamp": "2021-02-12T16:25:36.9514297"
}
```

```json
{
    "code": 503,
    "msg": "该手机号已注册，请直接登录",
    "data": null,
    "timestamp": "2021-02-09T20:28:29.3658782"
}
```

### 2.2 登录接口

- **接口地址:**	`/login`

#### 2.1.1 请求方法

POST

#### 2.1.2 请求参数

|  参数名  | 数据类型 | 出现要求 |     描述     |
| :------: | :------: | :------: | :----------: |
|  moblie  |  String  |    R     | 用户手机号码 |
| password |  String  |    R     |   用户密码   |

#### 2.1.3 响应参数

| 参数名称  |  类型   | 出现要求 |          描述           |
| :-------- | :-----: | :------: | :---------------------: |
| code      | Integer |    R     |         响应码          |
| msg       | String  |    R     |        相应描述         |
| data      | Object  |    R     |          null           |
| id        | String  |    C     | 登陆成功返回用户实际 id |
| token     | String  |    C     | 登陆成功返回用户 token  |
| timestamp | String  |    R     |          时间           |

响应示例

```json
{
    "code": 200,
    "msg": "OK",
    "data": {
        "id": "2",
        "token": "l85Xs+pDuyOvva68QclCuKdO49rD1U4DqwNgspSlFHc="
    },
    "timestamp": "2021-02-12T16:25:36.9514297"
}
```

```json
{
    "code": 503,
    "msg": "密码错误或账号已被删除",
    "data": null,
    "timestamp": "2021-02-12T16:28:47.6843639"
}
```

