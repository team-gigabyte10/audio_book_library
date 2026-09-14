var dC=Object.defineProperty;var fC=(t,e,n)=>e in t?dC(t,e,{enumerable:!0,configurable:!0,writable:!0,value:n}):t[e]=n;var be=(t,e,n)=>fC(t,typeof e!="symbol"?e+"":e,n);(function(){const e=document.createElement("link").relList;if(e&&e.supports&&e.supports("modulepreload"))return;for(const i of document.querySelectorAll('link[rel="modulepreload"]'))r(i);new MutationObserver(i=>{for(const s of i)if(s.type==="childList")for(const o of s.addedNodes)o.tagName==="LINK"&&o.rel==="modulepreload"&&r(o)}).observe(document,{childList:!0,subtree:!0});function n(i){const s={};return i.integrity&&(s.integrity=i.integrity),i.referrerPolicy&&(s.referrerPolicy=i.referrerPolicy),i.crossOrigin==="use-credentials"?s.credentials="include":i.crossOrigin==="anonymous"?s.credentials="omit":s.credentials="same-origin",s}function r(i){if(i.ep)return;i.ep=!0;const s=n(i);fetch(i.href,s)}})();function pC(t){return t&&t.__esModule&&Object.prototype.hasOwnProperty.call(t,"default")?t.default:t}var T0={exports:{}},qc={},I0={exports:{}},ue={};/**
 * @license React
 * react.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var ul=Symbol.for("react.element"),mC=Symbol.for("react.portal"),gC=Symbol.for("react.fragment"),_C=Symbol.for("react.strict_mode"),yC=Symbol.for("react.profiler"),vC=Symbol.for("react.provider"),wC=Symbol.for("react.context"),EC=Symbol.for("react.forward_ref"),TC=Symbol.for("react.suspense"),IC=Symbol.for("react.memo"),SC=Symbol.for("react.lazy"),ty=Symbol.iterator;function kC(t){return t===null||typeof t!="object"?null:(t=ty&&t[ty]||t["@@iterator"],typeof t=="function"?t:null)}var S0={isMounted:function(){return!1},enqueueForceUpdate:function(){},enqueueReplaceState:function(){},enqueueSetState:function(){}},k0=Object.assign,C0={};function uo(t,e,n){this.props=t,this.context=e,this.refs=C0,this.updater=n||S0}uo.prototype.isReactComponent={};uo.prototype.setState=function(t,e){if(typeof t!="object"&&typeof t!="function"&&t!=null)throw Error("setState(...): takes an object of state variables to update or a function which returns an object of state variables.");this.updater.enqueueSetState(this,t,e,"setState")};uo.prototype.forceUpdate=function(t){this.updater.enqueueForceUpdate(this,t,"forceUpdate")};function R0(){}R0.prototype=uo.prototype;function Dp(t,e,n){this.props=t,this.context=e,this.refs=C0,this.updater=n||S0}var Mp=Dp.prototype=new R0;Mp.constructor=Dp;k0(Mp,uo.prototype);Mp.isPureReactComponent=!0;var ny=Array.isArray,A0=Object.prototype.hasOwnProperty,Lp={current:null},x0={key:!0,ref:!0,__self:!0,__source:!0};function P0(t,e,n){var r,i={},s=null,o=null;if(e!=null)for(r in e.ref!==void 0&&(o=e.ref),e.key!==void 0&&(s=""+e.key),e)A0.call(e,r)&&!x0.hasOwnProperty(r)&&(i[r]=e[r]);var a=arguments.length-2;if(a===1)i.children=n;else if(1<a){for(var u=Array(a),c=0;c<a;c++)u[c]=arguments[c+2];i.children=u}if(t&&t.defaultProps)for(r in a=t.defaultProps,a)i[r]===void 0&&(i[r]=a[r]);return{$$typeof:ul,type:t,key:s,ref:o,props:i,_owner:Lp.current}}function CC(t,e){return{$$typeof:ul,type:t.type,key:e,ref:t.ref,props:t.props,_owner:t._owner}}function Vp(t){return typeof t=="object"&&t!==null&&t.$$typeof===ul}function RC(t){var e={"=":"=0",":":"=2"};return"$"+t.replace(/[=:]/g,function(n){return e[n]})}var ry=/\/+/g;function ed(t,e){return typeof t=="object"&&t!==null&&t.key!=null?RC(""+t.key):e.toString(36)}function Su(t,e,n,r,i){var s=typeof t;(s==="undefined"||s==="boolean")&&(t=null);var o=!1;if(t===null)o=!0;else switch(s){case"string":case"number":o=!0;break;case"object":switch(t.$$typeof){case ul:case mC:o=!0}}if(o)return o=t,i=i(o),t=r===""?"."+ed(o,0):r,ny(i)?(n="",t!=null&&(n=t.replace(ry,"$&/")+"/"),Su(i,e,n,"",function(c){return c})):i!=null&&(Vp(i)&&(i=CC(i,n+(!i.key||o&&o.key===i.key?"":(""+i.key).replace(ry,"$&/")+"/")+t)),e.push(i)),1;if(o=0,r=r===""?".":r+":",ny(t))for(var a=0;a<t.length;a++){s=t[a];var u=r+ed(s,a);o+=Su(s,e,n,u,i)}else if(u=kC(t),typeof u=="function")for(t=u.call(t),a=0;!(s=t.next()).done;)s=s.value,u=r+ed(s,a++),o+=Su(s,e,n,u,i);else if(s==="object")throw e=String(t),Error("Objects are not valid as a React child (found: "+(e==="[object Object]"?"object with keys {"+Object.keys(t).join(", ")+"}":e)+"). If you meant to render a collection of children, use an array instead.");return o}function Yl(t,e,n){if(t==null)return t;var r=[],i=0;return Su(t,r,"","",function(s){return e.call(n,s,i++)}),r}function AC(t){if(t._status===-1){var e=t._result;e=e(),e.then(function(n){(t._status===0||t._status===-1)&&(t._status=1,t._result=n)},function(n){(t._status===0||t._status===-1)&&(t._status=2,t._result=n)}),t._status===-1&&(t._status=0,t._result=e)}if(t._status===1)return t._result.default;throw t._result}var $t={current:null},ku={transition:null},xC={ReactCurrentDispatcher:$t,ReactCurrentBatchConfig:ku,ReactCurrentOwner:Lp};function b0(){throw Error("act(...) is not supported in production builds of React.")}ue.Children={map:Yl,forEach:function(t,e,n){Yl(t,function(){e.apply(this,arguments)},n)},count:function(t){var e=0;return Yl(t,function(){e++}),e},toArray:function(t){return Yl(t,function(e){return e})||[]},only:function(t){if(!Vp(t))throw Error("React.Children.only expected to receive a single React element child.");return t}};ue.Component=uo;ue.Fragment=gC;ue.Profiler=yC;ue.PureComponent=Dp;ue.StrictMode=_C;ue.Suspense=TC;ue.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED=xC;ue.act=b0;ue.cloneElement=function(t,e,n){if(t==null)throw Error("React.cloneElement(...): The argument must be a React element, but you passed "+t+".");var r=k0({},t.props),i=t.key,s=t.ref,o=t._owner;if(e!=null){if(e.ref!==void 0&&(s=e.ref,o=Lp.current),e.key!==void 0&&(i=""+e.key),t.type&&t.type.defaultProps)var a=t.type.defaultProps;for(u in e)A0.call(e,u)&&!x0.hasOwnProperty(u)&&(r[u]=e[u]===void 0&&a!==void 0?a[u]:e[u])}var u=arguments.length-2;if(u===1)r.children=n;else if(1<u){a=Array(u);for(var c=0;c<u;c++)a[c]=arguments[c+2];r.children=a}return{$$typeof:ul,type:t.type,key:i,ref:s,props:r,_owner:o}};ue.createContext=function(t){return t={$$typeof:wC,_currentValue:t,_currentValue2:t,_threadCount:0,Provider:null,Consumer:null,_defaultValue:null,_globalName:null},t.Provider={$$typeof:vC,_context:t},t.Consumer=t};ue.createElement=P0;ue.createFactory=function(t){var e=P0.bind(null,t);return e.type=t,e};ue.createRef=function(){return{current:null}};ue.forwardRef=function(t){return{$$typeof:EC,render:t}};ue.isValidElement=Vp;ue.lazy=function(t){return{$$typeof:SC,_payload:{_status:-1,_result:t},_init:AC}};ue.memo=function(t,e){return{$$typeof:IC,type:t,compare:e===void 0?null:e}};ue.startTransition=function(t){var e=ku.transition;ku.transition={};try{t()}finally{ku.transition=e}};ue.unstable_act=b0;ue.useCallback=function(t,e){return $t.current.useCallback(t,e)};ue.useContext=function(t){return $t.current.useContext(t)};ue.useDebugValue=function(){};ue.useDeferredValue=function(t){return $t.current.useDeferredValue(t)};ue.useEffect=function(t,e){return $t.current.useEffect(t,e)};ue.useId=function(){return $t.current.useId()};ue.useImperativeHandle=function(t,e,n){return $t.current.useImperativeHandle(t,e,n)};ue.useInsertionEffect=function(t,e){return $t.current.useInsertionEffect(t,e)};ue.useLayoutEffect=function(t,e){return $t.current.useLayoutEffect(t,e)};ue.useMemo=function(t,e){return $t.current.useMemo(t,e)};ue.useReducer=function(t,e,n){return $t.current.useReducer(t,e,n)};ue.useRef=function(t){return $t.current.useRef(t)};ue.useState=function(t){return $t.current.useState(t)};ue.useSyncExternalStore=function(t,e,n){return $t.current.useSyncExternalStore(t,e,n)};ue.useTransition=function(){return $t.current.useTransition()};ue.version="18.3.1";I0.exports=ue;var oe=I0.exports;const PC=pC(oe);/**
 * @license React
 * react-jsx-runtime.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var bC=oe,NC=Symbol.for("react.element"),OC=Symbol.for("react.fragment"),DC=Object.prototype.hasOwnProperty,MC=bC.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED.ReactCurrentOwner,LC={key:!0,ref:!0,__self:!0,__source:!0};function N0(t,e,n){var r,i={},s=null,o=null;n!==void 0&&(s=""+n),e.key!==void 0&&(s=""+e.key),e.ref!==void 0&&(o=e.ref);for(r in e)DC.call(e,r)&&!LC.hasOwnProperty(r)&&(i[r]=e[r]);if(t&&t.defaultProps)for(r in e=t.defaultProps,e)i[r]===void 0&&(i[r]=e[r]);return{$$typeof:NC,type:t,key:s,ref:o,props:i,_owner:MC.current}}qc.Fragment=OC;qc.jsx=N0;qc.jsxs=N0;T0.exports=qc;var v=T0.exports,Zd={},O0={exports:{}},cn={},D0={exports:{}},M0={};/**
 * @license React
 * scheduler.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */(function(t){function e(W,X){var b=W.length;W.push(X);e:for(;0<b;){var A=b-1>>>1,B=W[A];if(0<i(B,X))W[A]=X,W[b]=B,b=A;else break e}}function n(W){return W.length===0?null:W[0]}function r(W){if(W.length===0)return null;var X=W[0],b=W.pop();if(b!==X){W[0]=b;e:for(var A=0,B=W.length,q=B>>>1;A<q;){var J=2*(A+1)-1,ee=W[J],te=J+1,Q=W[te];if(0>i(ee,b))te<B&&0>i(Q,ee)?(W[A]=Q,W[te]=b,A=te):(W[A]=ee,W[J]=b,A=J);else if(te<B&&0>i(Q,b))W[A]=Q,W[te]=b,A=te;else break e}}return X}function i(W,X){var b=W.sortIndex-X.sortIndex;return b!==0?b:W.id-X.id}if(typeof performance=="object"&&typeof performance.now=="function"){var s=performance;t.unstable_now=function(){return s.now()}}else{var o=Date,a=o.now();t.unstable_now=function(){return o.now()-a}}var u=[],c=[],d=1,f=null,m=3,w=!1,I=!1,P=!1,O=typeof setTimeout=="function"?setTimeout:null,C=typeof clearTimeout=="function"?clearTimeout:null,T=typeof setImmediate<"u"?setImmediate:null;typeof navigator<"u"&&navigator.scheduling!==void 0&&navigator.scheduling.isInputPending!==void 0&&navigator.scheduling.isInputPending.bind(navigator.scheduling);function S(W){for(var X=n(c);X!==null;){if(X.callback===null)r(c);else if(X.startTime<=W)r(c),X.sortIndex=X.expirationTime,e(u,X);else break;X=n(c)}}function M(W){if(P=!1,S(W),!I)if(n(u)!==null)I=!0,ve(V);else{var X=n(c);X!==null&&et(M,X.startTime-W)}}function V(W,X){I=!1,P&&(P=!1,C(g),g=-1),w=!0;var b=m;try{for(S(X),f=n(u);f!==null&&(!(f.expirationTime>X)||W&&!x());){var A=f.callback;if(typeof A=="function"){f.callback=null,m=f.priorityLevel;var B=A(f.expirationTime<=X);X=t.unstable_now(),typeof B=="function"?f.callback=B:f===n(u)&&r(u),S(X)}else r(u);f=n(u)}if(f!==null)var q=!0;else{var J=n(c);J!==null&&et(M,J.startTime-X),q=!1}return q}finally{f=null,m=b,w=!1}}var F=!1,y=null,g=-1,E=5,k=-1;function x(){return!(t.unstable_now()-k<E)}function N(){if(y!==null){var W=t.unstable_now();k=W;var X=!0;try{X=y(!0,W)}finally{X?R():(F=!1,y=null)}}else F=!1}var R;if(typeof T=="function")R=function(){T(N)};else if(typeof MessageChannel<"u"){var Ye=new MessageChannel,ct=Ye.port2;Ye.port1.onmessage=N,R=function(){ct.postMessage(null)}}else R=function(){O(N,0)};function ve(W){y=W,F||(F=!0,R())}function et(W,X){g=O(function(){W(t.unstable_now())},X)}t.unstable_IdlePriority=5,t.unstable_ImmediatePriority=1,t.unstable_LowPriority=4,t.unstable_NormalPriority=3,t.unstable_Profiling=null,t.unstable_UserBlockingPriority=2,t.unstable_cancelCallback=function(W){W.callback=null},t.unstable_continueExecution=function(){I||w||(I=!0,ve(V))},t.unstable_forceFrameRate=function(W){0>W||125<W?console.error("forceFrameRate takes a positive int between 0 and 125, forcing frame rates higher than 125 fps is not supported"):E=0<W?Math.floor(1e3/W):5},t.unstable_getCurrentPriorityLevel=function(){return m},t.unstable_getFirstCallbackNode=function(){return n(u)},t.unstable_next=function(W){switch(m){case 1:case 2:case 3:var X=3;break;default:X=m}var b=m;m=X;try{return W()}finally{m=b}},t.unstable_pauseExecution=function(){},t.unstable_requestPaint=function(){},t.unstable_runWithPriority=function(W,X){switch(W){case 1:case 2:case 3:case 4:case 5:break;default:W=3}var b=m;m=W;try{return X()}finally{m=b}},t.unstable_scheduleCallback=function(W,X,b){var A=t.unstable_now();switch(typeof b=="object"&&b!==null?(b=b.delay,b=typeof b=="number"&&0<b?A+b:A):b=A,W){case 1:var B=-1;break;case 2:B=250;break;case 5:B=1073741823;break;case 4:B=1e4;break;default:B=5e3}return B=b+B,W={id:d++,callback:X,priorityLevel:W,startTime:b,expirationTime:B,sortIndex:-1},b>A?(W.sortIndex=b,e(c,W),n(u)===null&&W===n(c)&&(P?(C(g),g=-1):P=!0,et(M,b-A))):(W.sortIndex=B,e(u,W),I||w||(I=!0,ve(V))),W},t.unstable_shouldYield=x,t.unstable_wrapCallback=function(W){var X=m;return function(){var b=m;m=X;try{return W.apply(this,arguments)}finally{m=b}}}})(M0);D0.exports=M0;var VC=D0.exports;/**
 * @license React
 * react-dom.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var FC=oe,un=VC;function z(t){for(var e="https://reactjs.org/docs/error-decoder.html?invariant="+t,n=1;n<arguments.length;n++)e+="&args[]="+encodeURIComponent(arguments[n]);return"Minified React error #"+t+"; visit "+e+" for the full message or use the non-minified dev environment for full errors and additional helpful warnings."}var L0=new Set,Na={};function Zi(t,e){Hs(t,e),Hs(t+"Capture",e)}function Hs(t,e){for(Na[t]=e,t=0;t<e.length;t++)L0.add(e[t])}var mr=!(typeof window>"u"||typeof window.document>"u"||typeof window.document.createElement>"u"),ef=Object.prototype.hasOwnProperty,UC=/^[:A-Z_a-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD][:A-Z_a-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD\-.0-9\u00B7\u0300-\u036F\u203F-\u2040]*$/,iy={},sy={};function jC(t){return ef.call(sy,t)?!0:ef.call(iy,t)?!1:UC.test(t)?sy[t]=!0:(iy[t]=!0,!1)}function zC(t,e,n,r){if(n!==null&&n.type===0)return!1;switch(typeof e){case"function":case"symbol":return!0;case"boolean":return r?!1:n!==null?!n.acceptsBooleans:(t=t.toLowerCase().slice(0,5),t!=="data-"&&t!=="aria-");default:return!1}}function BC(t,e,n,r){if(e===null||typeof e>"u"||zC(t,e,n,r))return!0;if(r)return!1;if(n!==null)switch(n.type){case 3:return!e;case 4:return e===!1;case 5:return isNaN(e);case 6:return isNaN(e)||1>e}return!1}function Wt(t,e,n,r,i,s,o){this.acceptsBooleans=e===2||e===3||e===4,this.attributeName=r,this.attributeNamespace=i,this.mustUseProperty=n,this.propertyName=t,this.type=e,this.sanitizeURL=s,this.removeEmptyString=o}var kt={};"children dangerouslySetInnerHTML defaultValue defaultChecked innerHTML suppressContentEditableWarning suppressHydrationWarning style".split(" ").forEach(function(t){kt[t]=new Wt(t,0,!1,t,null,!1,!1)});[["acceptCharset","accept-charset"],["className","class"],["htmlFor","for"],["httpEquiv","http-equiv"]].forEach(function(t){var e=t[0];kt[e]=new Wt(e,1,!1,t[1],null,!1,!1)});["contentEditable","draggable","spellCheck","value"].forEach(function(t){kt[t]=new Wt(t,2,!1,t.toLowerCase(),null,!1,!1)});["autoReverse","externalResourcesRequired","focusable","preserveAlpha"].forEach(function(t){kt[t]=new Wt(t,2,!1,t,null,!1,!1)});"allowFullScreen async autoFocus autoPlay controls default defer disabled disablePictureInPicture disableRemotePlayback formNoValidate hidden loop noModule noValidate open playsInline readOnly required reversed scoped seamless itemScope".split(" ").forEach(function(t){kt[t]=new Wt(t,3,!1,t.toLowerCase(),null,!1,!1)});["checked","multiple","muted","selected"].forEach(function(t){kt[t]=new Wt(t,3,!0,t,null,!1,!1)});["capture","download"].forEach(function(t){kt[t]=new Wt(t,4,!1,t,null,!1,!1)});["cols","rows","size","span"].forEach(function(t){kt[t]=new Wt(t,6,!1,t,null,!1,!1)});["rowSpan","start"].forEach(function(t){kt[t]=new Wt(t,5,!1,t.toLowerCase(),null,!1,!1)});var Fp=/[\-:]([a-z])/g;function Up(t){return t[1].toUpperCase()}"accent-height alignment-baseline arabic-form baseline-shift cap-height clip-path clip-rule color-interpolation color-interpolation-filters color-profile color-rendering dominant-baseline enable-background fill-opacity fill-rule flood-color flood-opacity font-family font-size font-size-adjust font-stretch font-style font-variant font-weight glyph-name glyph-orientation-horizontal glyph-orientation-vertical horiz-adv-x horiz-origin-x image-rendering letter-spacing lighting-color marker-end marker-mid marker-start overline-position overline-thickness paint-order panose-1 pointer-events rendering-intent shape-rendering stop-color stop-opacity strikethrough-position strikethrough-thickness stroke-dasharray stroke-dashoffset stroke-linecap stroke-linejoin stroke-miterlimit stroke-opacity stroke-width text-anchor text-decoration text-rendering underline-position underline-thickness unicode-bidi unicode-range units-per-em v-alphabetic v-hanging v-ideographic v-mathematical vector-effect vert-adv-y vert-origin-x vert-origin-y word-spacing writing-mode xmlns:xlink x-height".split(" ").forEach(function(t){var e=t.replace(Fp,Up);kt[e]=new Wt(e,1,!1,t,null,!1,!1)});"xlink:actuate xlink:arcrole xlink:role xlink:show xlink:title xlink:type".split(" ").forEach(function(t){var e=t.replace(Fp,Up);kt[e]=new Wt(e,1,!1,t,"http://www.w3.org/1999/xlink",!1,!1)});["xml:base","xml:lang","xml:space"].forEach(function(t){var e=t.replace(Fp,Up);kt[e]=new Wt(e,1,!1,t,"http://www.w3.org/XML/1998/namespace",!1,!1)});["tabIndex","crossOrigin"].forEach(function(t){kt[t]=new Wt(t,1,!1,t.toLowerCase(),null,!1,!1)});kt.xlinkHref=new Wt("xlinkHref",1,!1,"xlink:href","http://www.w3.org/1999/xlink",!0,!1);["src","href","action","formAction"].forEach(function(t){kt[t]=new Wt(t,1,!1,t.toLowerCase(),null,!0,!0)});function jp(t,e,n,r){var i=kt.hasOwnProperty(e)?kt[e]:null;(i!==null?i.type!==0:r||!(2<e.length)||e[0]!=="o"&&e[0]!=="O"||e[1]!=="n"&&e[1]!=="N")&&(BC(e,n,i,r)&&(n=null),r||i===null?jC(e)&&(n===null?t.removeAttribute(e):t.setAttribute(e,""+n)):i.mustUseProperty?t[i.propertyName]=n===null?i.type===3?!1:"":n:(e=i.attributeName,r=i.attributeNamespace,n===null?t.removeAttribute(e):(i=i.type,n=i===3||i===4&&n===!0?"":""+n,r?t.setAttributeNS(r,e,n):t.setAttribute(e,n))))}var Rr=FC.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED,Xl=Symbol.for("react.element"),ws=Symbol.for("react.portal"),Es=Symbol.for("react.fragment"),zp=Symbol.for("react.strict_mode"),tf=Symbol.for("react.profiler"),V0=Symbol.for("react.provider"),F0=Symbol.for("react.context"),Bp=Symbol.for("react.forward_ref"),nf=Symbol.for("react.suspense"),rf=Symbol.for("react.suspense_list"),$p=Symbol.for("react.memo"),Dr=Symbol.for("react.lazy"),U0=Symbol.for("react.offscreen"),oy=Symbol.iterator;function zo(t){return t===null||typeof t!="object"?null:(t=oy&&t[oy]||t["@@iterator"],typeof t=="function"?t:null)}var qe=Object.assign,td;function ra(t){if(td===void 0)try{throw Error()}catch(n){var e=n.stack.trim().match(/\n( *(at )?)/);td=e&&e[1]||""}return`
`+td+t}var nd=!1;function rd(t,e){if(!t||nd)return"";nd=!0;var n=Error.prepareStackTrace;Error.prepareStackTrace=void 0;try{if(e)if(e=function(){throw Error()},Object.defineProperty(e.prototype,"props",{set:function(){throw Error()}}),typeof Reflect=="object"&&Reflect.construct){try{Reflect.construct(e,[])}catch(c){var r=c}Reflect.construct(t,[],e)}else{try{e.call()}catch(c){r=c}t.call(e.prototype)}else{try{throw Error()}catch(c){r=c}t()}}catch(c){if(c&&r&&typeof c.stack=="string"){for(var i=c.stack.split(`
`),s=r.stack.split(`
`),o=i.length-1,a=s.length-1;1<=o&&0<=a&&i[o]!==s[a];)a--;for(;1<=o&&0<=a;o--,a--)if(i[o]!==s[a]){if(o!==1||a!==1)do if(o--,a--,0>a||i[o]!==s[a]){var u=`
`+i[o].replace(" at new "," at ");return t.displayName&&u.includes("<anonymous>")&&(u=u.replace("<anonymous>",t.displayName)),u}while(1<=o&&0<=a);break}}}finally{nd=!1,Error.prepareStackTrace=n}return(t=t?t.displayName||t.name:"")?ra(t):""}function $C(t){switch(t.tag){case 5:return ra(t.type);case 16:return ra("Lazy");case 13:return ra("Suspense");case 19:return ra("SuspenseList");case 0:case 2:case 15:return t=rd(t.type,!1),t;case 11:return t=rd(t.type.render,!1),t;case 1:return t=rd(t.type,!0),t;default:return""}}function sf(t){if(t==null)return null;if(typeof t=="function")return t.displayName||t.name||null;if(typeof t=="string")return t;switch(t){case Es:return"Fragment";case ws:return"Portal";case tf:return"Profiler";case zp:return"StrictMode";case nf:return"Suspense";case rf:return"SuspenseList"}if(typeof t=="object")switch(t.$$typeof){case F0:return(t.displayName||"Context")+".Consumer";case V0:return(t._context.displayName||"Context")+".Provider";case Bp:var e=t.render;return t=t.displayName,t||(t=e.displayName||e.name||"",t=t!==""?"ForwardRef("+t+")":"ForwardRef"),t;case $p:return e=t.displayName||null,e!==null?e:sf(t.type)||"Memo";case Dr:e=t._payload,t=t._init;try{return sf(t(e))}catch{}}return null}function WC(t){var e=t.type;switch(t.tag){case 24:return"Cache";case 9:return(e.displayName||"Context")+".Consumer";case 10:return(e._context.displayName||"Context")+".Provider";case 18:return"DehydratedFragment";case 11:return t=e.render,t=t.displayName||t.name||"",e.displayName||(t!==""?"ForwardRef("+t+")":"ForwardRef");case 7:return"Fragment";case 5:return e;case 4:return"Portal";case 3:return"Root";case 6:return"Text";case 16:return sf(e);case 8:return e===zp?"StrictMode":"Mode";case 22:return"Offscreen";case 12:return"Profiler";case 21:return"Scope";case 13:return"Suspense";case 19:return"SuspenseList";case 25:return"TracingMarker";case 1:case 0:case 17:case 2:case 14:case 15:if(typeof e=="function")return e.displayName||e.name||null;if(typeof e=="string")return e}return null}function ai(t){switch(typeof t){case"boolean":case"number":case"string":case"undefined":return t;case"object":return t;default:return""}}function j0(t){var e=t.type;return(t=t.nodeName)&&t.toLowerCase()==="input"&&(e==="checkbox"||e==="radio")}function qC(t){var e=j0(t)?"checked":"value",n=Object.getOwnPropertyDescriptor(t.constructor.prototype,e),r=""+t[e];if(!t.hasOwnProperty(e)&&typeof n<"u"&&typeof n.get=="function"&&typeof n.set=="function"){var i=n.get,s=n.set;return Object.defineProperty(t,e,{configurable:!0,get:function(){return i.call(this)},set:function(o){r=""+o,s.call(this,o)}}),Object.defineProperty(t,e,{enumerable:n.enumerable}),{getValue:function(){return r},setValue:function(o){r=""+o},stopTracking:function(){t._valueTracker=null,delete t[e]}}}}function Jl(t){t._valueTracker||(t._valueTracker=qC(t))}function z0(t){if(!t)return!1;var e=t._valueTracker;if(!e)return!0;var n=e.getValue(),r="";return t&&(r=j0(t)?t.checked?"true":"false":t.value),t=r,t!==n?(e.setValue(t),!0):!1}function Hu(t){if(t=t||(typeof document<"u"?document:void 0),typeof t>"u")return null;try{return t.activeElement||t.body}catch{return t.body}}function of(t,e){var n=e.checked;return qe({},e,{defaultChecked:void 0,defaultValue:void 0,value:void 0,checked:n??t._wrapperState.initialChecked})}function ay(t,e){var n=e.defaultValue==null?"":e.defaultValue,r=e.checked!=null?e.checked:e.defaultChecked;n=ai(e.value!=null?e.value:n),t._wrapperState={initialChecked:r,initialValue:n,controlled:e.type==="checkbox"||e.type==="radio"?e.checked!=null:e.value!=null}}function B0(t,e){e=e.checked,e!=null&&jp(t,"checked",e,!1)}function af(t,e){B0(t,e);var n=ai(e.value),r=e.type;if(n!=null)r==="number"?(n===0&&t.value===""||t.value!=n)&&(t.value=""+n):t.value!==""+n&&(t.value=""+n);else if(r==="submit"||r==="reset"){t.removeAttribute("value");return}e.hasOwnProperty("value")?lf(t,e.type,n):e.hasOwnProperty("defaultValue")&&lf(t,e.type,ai(e.defaultValue)),e.checked==null&&e.defaultChecked!=null&&(t.defaultChecked=!!e.defaultChecked)}function ly(t,e,n){if(e.hasOwnProperty("value")||e.hasOwnProperty("defaultValue")){var r=e.type;if(!(r!=="submit"&&r!=="reset"||e.value!==void 0&&e.value!==null))return;e=""+t._wrapperState.initialValue,n||e===t.value||(t.value=e),t.defaultValue=e}n=t.name,n!==""&&(t.name=""),t.defaultChecked=!!t._wrapperState.initialChecked,n!==""&&(t.name=n)}function lf(t,e,n){(e!=="number"||Hu(t.ownerDocument)!==t)&&(n==null?t.defaultValue=""+t._wrapperState.initialValue:t.defaultValue!==""+n&&(t.defaultValue=""+n))}var ia=Array.isArray;function Ds(t,e,n,r){if(t=t.options,e){e={};for(var i=0;i<n.length;i++)e["$"+n[i]]=!0;for(n=0;n<t.length;n++)i=e.hasOwnProperty("$"+t[n].value),t[n].selected!==i&&(t[n].selected=i),i&&r&&(t[n].defaultSelected=!0)}else{for(n=""+ai(n),e=null,i=0;i<t.length;i++){if(t[i].value===n){t[i].selected=!0,r&&(t[i].defaultSelected=!0);return}e!==null||t[i].disabled||(e=t[i])}e!==null&&(e.selected=!0)}}function uf(t,e){if(e.dangerouslySetInnerHTML!=null)throw Error(z(91));return qe({},e,{value:void 0,defaultValue:void 0,children:""+t._wrapperState.initialValue})}function uy(t,e){var n=e.value;if(n==null){if(n=e.children,e=e.defaultValue,n!=null){if(e!=null)throw Error(z(92));if(ia(n)){if(1<n.length)throw Error(z(93));n=n[0]}e=n}e==null&&(e=""),n=e}t._wrapperState={initialValue:ai(n)}}function $0(t,e){var n=ai(e.value),r=ai(e.defaultValue);n!=null&&(n=""+n,n!==t.value&&(t.value=n),e.defaultValue==null&&t.defaultValue!==n&&(t.defaultValue=n)),r!=null&&(t.defaultValue=""+r)}function cy(t){var e=t.textContent;e===t._wrapperState.initialValue&&e!==""&&e!==null&&(t.value=e)}function W0(t){switch(t){case"svg":return"http://www.w3.org/2000/svg";case"math":return"http://www.w3.org/1998/Math/MathML";default:return"http://www.w3.org/1999/xhtml"}}function cf(t,e){return t==null||t==="http://www.w3.org/1999/xhtml"?W0(e):t==="http://www.w3.org/2000/svg"&&e==="foreignObject"?"http://www.w3.org/1999/xhtml":t}var Zl,q0=function(t){return typeof MSApp<"u"&&MSApp.execUnsafeLocalFunction?function(e,n,r,i){MSApp.execUnsafeLocalFunction(function(){return t(e,n,r,i)})}:t}(function(t,e){if(t.namespaceURI!=="http://www.w3.org/2000/svg"||"innerHTML"in t)t.innerHTML=e;else{for(Zl=Zl||document.createElement("div"),Zl.innerHTML="<svg>"+e.valueOf().toString()+"</svg>",e=Zl.firstChild;t.firstChild;)t.removeChild(t.firstChild);for(;e.firstChild;)t.appendChild(e.firstChild)}});function Oa(t,e){if(e){var n=t.firstChild;if(n&&n===t.lastChild&&n.nodeType===3){n.nodeValue=e;return}}t.textContent=e}var ca={animationIterationCount:!0,aspectRatio:!0,borderImageOutset:!0,borderImageSlice:!0,borderImageWidth:!0,boxFlex:!0,boxFlexGroup:!0,boxOrdinalGroup:!0,columnCount:!0,columns:!0,flex:!0,flexGrow:!0,flexPositive:!0,flexShrink:!0,flexNegative:!0,flexOrder:!0,gridArea:!0,gridRow:!0,gridRowEnd:!0,gridRowSpan:!0,gridRowStart:!0,gridColumn:!0,gridColumnEnd:!0,gridColumnSpan:!0,gridColumnStart:!0,fontWeight:!0,lineClamp:!0,lineHeight:!0,opacity:!0,order:!0,orphans:!0,tabSize:!0,widows:!0,zIndex:!0,zoom:!0,fillOpacity:!0,floodOpacity:!0,stopOpacity:!0,strokeDasharray:!0,strokeDashoffset:!0,strokeMiterlimit:!0,strokeOpacity:!0,strokeWidth:!0},HC=["Webkit","ms","Moz","O"];Object.keys(ca).forEach(function(t){HC.forEach(function(e){e=e+t.charAt(0).toUpperCase()+t.substring(1),ca[e]=ca[t]})});function H0(t,e,n){return e==null||typeof e=="boolean"||e===""?"":n||typeof e!="number"||e===0||ca.hasOwnProperty(t)&&ca[t]?(""+e).trim():e+"px"}function G0(t,e){t=t.style;for(var n in e)if(e.hasOwnProperty(n)){var r=n.indexOf("--")===0,i=H0(n,e[n],r);n==="float"&&(n="cssFloat"),r?t.setProperty(n,i):t[n]=i}}var GC=qe({menuitem:!0},{area:!0,base:!0,br:!0,col:!0,embed:!0,hr:!0,img:!0,input:!0,keygen:!0,link:!0,meta:!0,param:!0,source:!0,track:!0,wbr:!0});function hf(t,e){if(e){if(GC[t]&&(e.children!=null||e.dangerouslySetInnerHTML!=null))throw Error(z(137,t));if(e.dangerouslySetInnerHTML!=null){if(e.children!=null)throw Error(z(60));if(typeof e.dangerouslySetInnerHTML!="object"||!("__html"in e.dangerouslySetInnerHTML))throw Error(z(61))}if(e.style!=null&&typeof e.style!="object")throw Error(z(62))}}function df(t,e){if(t.indexOf("-")===-1)return typeof e.is=="string";switch(t){case"annotation-xml":case"color-profile":case"font-face":case"font-face-src":case"font-face-uri":case"font-face-format":case"font-face-name":case"missing-glyph":return!1;default:return!0}}var ff=null;function Wp(t){return t=t.target||t.srcElement||window,t.correspondingUseElement&&(t=t.correspondingUseElement),t.nodeType===3?t.parentNode:t}var pf=null,Ms=null,Ls=null;function hy(t){if(t=dl(t)){if(typeof pf!="function")throw Error(z(280));var e=t.stateNode;e&&(e=Yc(e),pf(t.stateNode,t.type,e))}}function K0(t){Ms?Ls?Ls.push(t):Ls=[t]:Ms=t}function Q0(){if(Ms){var t=Ms,e=Ls;if(Ls=Ms=null,hy(t),e)for(t=0;t<e.length;t++)hy(e[t])}}function Y0(t,e){return t(e)}function X0(){}var id=!1;function J0(t,e,n){if(id)return t(e,n);id=!0;try{return Y0(t,e,n)}finally{id=!1,(Ms!==null||Ls!==null)&&(X0(),Q0())}}function Da(t,e){var n=t.stateNode;if(n===null)return null;var r=Yc(n);if(r===null)return null;n=r[e];e:switch(e){case"onClick":case"onClickCapture":case"onDoubleClick":case"onDoubleClickCapture":case"onMouseDown":case"onMouseDownCapture":case"onMouseMove":case"onMouseMoveCapture":case"onMouseUp":case"onMouseUpCapture":case"onMouseEnter":(r=!r.disabled)||(t=t.type,r=!(t==="button"||t==="input"||t==="select"||t==="textarea")),t=!r;break e;default:t=!1}if(t)return null;if(n&&typeof n!="function")throw Error(z(231,e,typeof n));return n}var mf=!1;if(mr)try{var Bo={};Object.defineProperty(Bo,"passive",{get:function(){mf=!0}}),window.addEventListener("test",Bo,Bo),window.removeEventListener("test",Bo,Bo)}catch{mf=!1}function KC(t,e,n,r,i,s,o,a,u){var c=Array.prototype.slice.call(arguments,3);try{e.apply(n,c)}catch(d){this.onError(d)}}var ha=!1,Gu=null,Ku=!1,gf=null,QC={onError:function(t){ha=!0,Gu=t}};function YC(t,e,n,r,i,s,o,a,u){ha=!1,Gu=null,KC.apply(QC,arguments)}function XC(t,e,n,r,i,s,o,a,u){if(YC.apply(this,arguments),ha){if(ha){var c=Gu;ha=!1,Gu=null}else throw Error(z(198));Ku||(Ku=!0,gf=c)}}function es(t){var e=t,n=t;if(t.alternate)for(;e.return;)e=e.return;else{t=e;do e=t,e.flags&4098&&(n=e.return),t=e.return;while(t)}return e.tag===3?n:null}function Z0(t){if(t.tag===13){var e=t.memoizedState;if(e===null&&(t=t.alternate,t!==null&&(e=t.memoizedState)),e!==null)return e.dehydrated}return null}function dy(t){if(es(t)!==t)throw Error(z(188))}function JC(t){var e=t.alternate;if(!e){if(e=es(t),e===null)throw Error(z(188));return e!==t?null:t}for(var n=t,r=e;;){var i=n.return;if(i===null)break;var s=i.alternate;if(s===null){if(r=i.return,r!==null){n=r;continue}break}if(i.child===s.child){for(s=i.child;s;){if(s===n)return dy(i),t;if(s===r)return dy(i),e;s=s.sibling}throw Error(z(188))}if(n.return!==r.return)n=i,r=s;else{for(var o=!1,a=i.child;a;){if(a===n){o=!0,n=i,r=s;break}if(a===r){o=!0,r=i,n=s;break}a=a.sibling}if(!o){for(a=s.child;a;){if(a===n){o=!0,n=s,r=i;break}if(a===r){o=!0,r=s,n=i;break}a=a.sibling}if(!o)throw Error(z(189))}}if(n.alternate!==r)throw Error(z(190))}if(n.tag!==3)throw Error(z(188));return n.stateNode.current===n?t:e}function eE(t){return t=JC(t),t!==null?tE(t):null}function tE(t){if(t.tag===5||t.tag===6)return t;for(t=t.child;t!==null;){var e=tE(t);if(e!==null)return e;t=t.sibling}return null}var nE=un.unstable_scheduleCallback,fy=un.unstable_cancelCallback,ZC=un.unstable_shouldYield,eR=un.unstable_requestPaint,Ze=un.unstable_now,tR=un.unstable_getCurrentPriorityLevel,qp=un.unstable_ImmediatePriority,rE=un.unstable_UserBlockingPriority,Qu=un.unstable_NormalPriority,nR=un.unstable_LowPriority,iE=un.unstable_IdlePriority,Hc=null,qn=null;function rR(t){if(qn&&typeof qn.onCommitFiberRoot=="function")try{qn.onCommitFiberRoot(Hc,t,void 0,(t.current.flags&128)===128)}catch{}}var Dn=Math.clz32?Math.clz32:oR,iR=Math.log,sR=Math.LN2;function oR(t){return t>>>=0,t===0?32:31-(iR(t)/sR|0)|0}var eu=64,tu=4194304;function sa(t){switch(t&-t){case 1:return 1;case 2:return 2;case 4:return 4;case 8:return 8;case 16:return 16;case 32:return 32;case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:return t&4194240;case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:return t&130023424;case 134217728:return 134217728;case 268435456:return 268435456;case 536870912:return 536870912;case 1073741824:return 1073741824;default:return t}}function Yu(t,e){var n=t.pendingLanes;if(n===0)return 0;var r=0,i=t.suspendedLanes,s=t.pingedLanes,o=n&268435455;if(o!==0){var a=o&~i;a!==0?r=sa(a):(s&=o,s!==0&&(r=sa(s)))}else o=n&~i,o!==0?r=sa(o):s!==0&&(r=sa(s));if(r===0)return 0;if(e!==0&&e!==r&&!(e&i)&&(i=r&-r,s=e&-e,i>=s||i===16&&(s&4194240)!==0))return e;if(r&4&&(r|=n&16),e=t.entangledLanes,e!==0)for(t=t.entanglements,e&=r;0<e;)n=31-Dn(e),i=1<<n,r|=t[n],e&=~i;return r}function aR(t,e){switch(t){case 1:case 2:case 4:return e+250;case 8:case 16:case 32:case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:return e+5e3;case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:return-1;case 134217728:case 268435456:case 536870912:case 1073741824:return-1;default:return-1}}function lR(t,e){for(var n=t.suspendedLanes,r=t.pingedLanes,i=t.expirationTimes,s=t.pendingLanes;0<s;){var o=31-Dn(s),a=1<<o,u=i[o];u===-1?(!(a&n)||a&r)&&(i[o]=aR(a,e)):u<=e&&(t.expiredLanes|=a),s&=~a}}function _f(t){return t=t.pendingLanes&-1073741825,t!==0?t:t&1073741824?1073741824:0}function sE(){var t=eu;return eu<<=1,!(eu&4194240)&&(eu=64),t}function sd(t){for(var e=[],n=0;31>n;n++)e.push(t);return e}function cl(t,e,n){t.pendingLanes|=e,e!==536870912&&(t.suspendedLanes=0,t.pingedLanes=0),t=t.eventTimes,e=31-Dn(e),t[e]=n}function uR(t,e){var n=t.pendingLanes&~e;t.pendingLanes=e,t.suspendedLanes=0,t.pingedLanes=0,t.expiredLanes&=e,t.mutableReadLanes&=e,t.entangledLanes&=e,e=t.entanglements;var r=t.eventTimes;for(t=t.expirationTimes;0<n;){var i=31-Dn(n),s=1<<i;e[i]=0,r[i]=-1,t[i]=-1,n&=~s}}function Hp(t,e){var n=t.entangledLanes|=e;for(t=t.entanglements;n;){var r=31-Dn(n),i=1<<r;i&e|t[r]&e&&(t[r]|=e),n&=~i}}var Ie=0;function oE(t){return t&=-t,1<t?4<t?t&268435455?16:536870912:4:1}var aE,Gp,lE,uE,cE,yf=!1,nu=[],Hr=null,Gr=null,Kr=null,Ma=new Map,La=new Map,Lr=[],cR="mousedown mouseup touchcancel touchend touchstart auxclick dblclick pointercancel pointerdown pointerup dragend dragstart drop compositionend compositionstart keydown keypress keyup input textInput copy cut paste click change contextmenu reset submit".split(" ");function py(t,e){switch(t){case"focusin":case"focusout":Hr=null;break;case"dragenter":case"dragleave":Gr=null;break;case"mouseover":case"mouseout":Kr=null;break;case"pointerover":case"pointerout":Ma.delete(e.pointerId);break;case"gotpointercapture":case"lostpointercapture":La.delete(e.pointerId)}}function $o(t,e,n,r,i,s){return t===null||t.nativeEvent!==s?(t={blockedOn:e,domEventName:n,eventSystemFlags:r,nativeEvent:s,targetContainers:[i]},e!==null&&(e=dl(e),e!==null&&Gp(e)),t):(t.eventSystemFlags|=r,e=t.targetContainers,i!==null&&e.indexOf(i)===-1&&e.push(i),t)}function hR(t,e,n,r,i){switch(e){case"focusin":return Hr=$o(Hr,t,e,n,r,i),!0;case"dragenter":return Gr=$o(Gr,t,e,n,r,i),!0;case"mouseover":return Kr=$o(Kr,t,e,n,r,i),!0;case"pointerover":var s=i.pointerId;return Ma.set(s,$o(Ma.get(s)||null,t,e,n,r,i)),!0;case"gotpointercapture":return s=i.pointerId,La.set(s,$o(La.get(s)||null,t,e,n,r,i)),!0}return!1}function hE(t){var e=xi(t.target);if(e!==null){var n=es(e);if(n!==null){if(e=n.tag,e===13){if(e=Z0(n),e!==null){t.blockedOn=e,cE(t.priority,function(){lE(n)});return}}else if(e===3&&n.stateNode.current.memoizedState.isDehydrated){t.blockedOn=n.tag===3?n.stateNode.containerInfo:null;return}}}t.blockedOn=null}function Cu(t){if(t.blockedOn!==null)return!1;for(var e=t.targetContainers;0<e.length;){var n=vf(t.domEventName,t.eventSystemFlags,e[0],t.nativeEvent);if(n===null){n=t.nativeEvent;var r=new n.constructor(n.type,n);ff=r,n.target.dispatchEvent(r),ff=null}else return e=dl(n),e!==null&&Gp(e),t.blockedOn=n,!1;e.shift()}return!0}function my(t,e,n){Cu(t)&&n.delete(e)}function dR(){yf=!1,Hr!==null&&Cu(Hr)&&(Hr=null),Gr!==null&&Cu(Gr)&&(Gr=null),Kr!==null&&Cu(Kr)&&(Kr=null),Ma.forEach(my),La.forEach(my)}function Wo(t,e){t.blockedOn===e&&(t.blockedOn=null,yf||(yf=!0,un.unstable_scheduleCallback(un.unstable_NormalPriority,dR)))}function Va(t){function e(i){return Wo(i,t)}if(0<nu.length){Wo(nu[0],t);for(var n=1;n<nu.length;n++){var r=nu[n];r.blockedOn===t&&(r.blockedOn=null)}}for(Hr!==null&&Wo(Hr,t),Gr!==null&&Wo(Gr,t),Kr!==null&&Wo(Kr,t),Ma.forEach(e),La.forEach(e),n=0;n<Lr.length;n++)r=Lr[n],r.blockedOn===t&&(r.blockedOn=null);for(;0<Lr.length&&(n=Lr[0],n.blockedOn===null);)hE(n),n.blockedOn===null&&Lr.shift()}var Vs=Rr.ReactCurrentBatchConfig,Xu=!0;function fR(t,e,n,r){var i=Ie,s=Vs.transition;Vs.transition=null;try{Ie=1,Kp(t,e,n,r)}finally{Ie=i,Vs.transition=s}}function pR(t,e,n,r){var i=Ie,s=Vs.transition;Vs.transition=null;try{Ie=4,Kp(t,e,n,r)}finally{Ie=i,Vs.transition=s}}function Kp(t,e,n,r){if(Xu){var i=vf(t,e,n,r);if(i===null)md(t,e,r,Ju,n),py(t,r);else if(hR(i,t,e,n,r))r.stopPropagation();else if(py(t,r),e&4&&-1<cR.indexOf(t)){for(;i!==null;){var s=dl(i);if(s!==null&&aE(s),s=vf(t,e,n,r),s===null&&md(t,e,r,Ju,n),s===i)break;i=s}i!==null&&r.stopPropagation()}else md(t,e,r,null,n)}}var Ju=null;function vf(t,e,n,r){if(Ju=null,t=Wp(r),t=xi(t),t!==null)if(e=es(t),e===null)t=null;else if(n=e.tag,n===13){if(t=Z0(e),t!==null)return t;t=null}else if(n===3){if(e.stateNode.current.memoizedState.isDehydrated)return e.tag===3?e.stateNode.containerInfo:null;t=null}else e!==t&&(t=null);return Ju=t,null}function dE(t){switch(t){case"cancel":case"click":case"close":case"contextmenu":case"copy":case"cut":case"auxclick":case"dblclick":case"dragend":case"dragstart":case"drop":case"focusin":case"focusout":case"input":case"invalid":case"keydown":case"keypress":case"keyup":case"mousedown":case"mouseup":case"paste":case"pause":case"play":case"pointercancel":case"pointerdown":case"pointerup":case"ratechange":case"reset":case"resize":case"seeked":case"submit":case"touchcancel":case"touchend":case"touchstart":case"volumechange":case"change":case"selectionchange":case"textInput":case"compositionstart":case"compositionend":case"compositionupdate":case"beforeblur":case"afterblur":case"beforeinput":case"blur":case"fullscreenchange":case"focus":case"hashchange":case"popstate":case"select":case"selectstart":return 1;case"drag":case"dragenter":case"dragexit":case"dragleave":case"dragover":case"mousemove":case"mouseout":case"mouseover":case"pointermove":case"pointerout":case"pointerover":case"scroll":case"toggle":case"touchmove":case"wheel":case"mouseenter":case"mouseleave":case"pointerenter":case"pointerleave":return 4;case"message":switch(tR()){case qp:return 1;case rE:return 4;case Qu:case nR:return 16;case iE:return 536870912;default:return 16}default:return 16}}var $r=null,Qp=null,Ru=null;function fE(){if(Ru)return Ru;var t,e=Qp,n=e.length,r,i="value"in $r?$r.value:$r.textContent,s=i.length;for(t=0;t<n&&e[t]===i[t];t++);var o=n-t;for(r=1;r<=o&&e[n-r]===i[s-r];r++);return Ru=i.slice(t,1<r?1-r:void 0)}function Au(t){var e=t.keyCode;return"charCode"in t?(t=t.charCode,t===0&&e===13&&(t=13)):t=e,t===10&&(t=13),32<=t||t===13?t:0}function ru(){return!0}function gy(){return!1}function hn(t){function e(n,r,i,s,o){this._reactName=n,this._targetInst=i,this.type=r,this.nativeEvent=s,this.target=o,this.currentTarget=null;for(var a in t)t.hasOwnProperty(a)&&(n=t[a],this[a]=n?n(s):s[a]);return this.isDefaultPrevented=(s.defaultPrevented!=null?s.defaultPrevented:s.returnValue===!1)?ru:gy,this.isPropagationStopped=gy,this}return qe(e.prototype,{preventDefault:function(){this.defaultPrevented=!0;var n=this.nativeEvent;n&&(n.preventDefault?n.preventDefault():typeof n.returnValue!="unknown"&&(n.returnValue=!1),this.isDefaultPrevented=ru)},stopPropagation:function(){var n=this.nativeEvent;n&&(n.stopPropagation?n.stopPropagation():typeof n.cancelBubble!="unknown"&&(n.cancelBubble=!0),this.isPropagationStopped=ru)},persist:function(){},isPersistent:ru}),e}var co={eventPhase:0,bubbles:0,cancelable:0,timeStamp:function(t){return t.timeStamp||Date.now()},defaultPrevented:0,isTrusted:0},Yp=hn(co),hl=qe({},co,{view:0,detail:0}),mR=hn(hl),od,ad,qo,Gc=qe({},hl,{screenX:0,screenY:0,clientX:0,clientY:0,pageX:0,pageY:0,ctrlKey:0,shiftKey:0,altKey:0,metaKey:0,getModifierState:Xp,button:0,buttons:0,relatedTarget:function(t){return t.relatedTarget===void 0?t.fromElement===t.srcElement?t.toElement:t.fromElement:t.relatedTarget},movementX:function(t){return"movementX"in t?t.movementX:(t!==qo&&(qo&&t.type==="mousemove"?(od=t.screenX-qo.screenX,ad=t.screenY-qo.screenY):ad=od=0,qo=t),od)},movementY:function(t){return"movementY"in t?t.movementY:ad}}),_y=hn(Gc),gR=qe({},Gc,{dataTransfer:0}),_R=hn(gR),yR=qe({},hl,{relatedTarget:0}),ld=hn(yR),vR=qe({},co,{animationName:0,elapsedTime:0,pseudoElement:0}),wR=hn(vR),ER=qe({},co,{clipboardData:function(t){return"clipboardData"in t?t.clipboardData:window.clipboardData}}),TR=hn(ER),IR=qe({},co,{data:0}),yy=hn(IR),SR={Esc:"Escape",Spacebar:" ",Left:"ArrowLeft",Up:"ArrowUp",Right:"ArrowRight",Down:"ArrowDown",Del:"Delete",Win:"OS",Menu:"ContextMenu",Apps:"ContextMenu",Scroll:"ScrollLock",MozPrintableKey:"Unidentified"},kR={8:"Backspace",9:"Tab",12:"Clear",13:"Enter",16:"Shift",17:"Control",18:"Alt",19:"Pause",20:"CapsLock",27:"Escape",32:" ",33:"PageUp",34:"PageDown",35:"End",36:"Home",37:"ArrowLeft",38:"ArrowUp",39:"ArrowRight",40:"ArrowDown",45:"Insert",46:"Delete",112:"F1",113:"F2",114:"F3",115:"F4",116:"F5",117:"F6",118:"F7",119:"F8",120:"F9",121:"F10",122:"F11",123:"F12",144:"NumLock",145:"ScrollLock",224:"Meta"},CR={Alt:"altKey",Control:"ctrlKey",Meta:"metaKey",Shift:"shiftKey"};function RR(t){var e=this.nativeEvent;return e.getModifierState?e.getModifierState(t):(t=CR[t])?!!e[t]:!1}function Xp(){return RR}var AR=qe({},hl,{key:function(t){if(t.key){var e=SR[t.key]||t.key;if(e!=="Unidentified")return e}return t.type==="keypress"?(t=Au(t),t===13?"Enter":String.fromCharCode(t)):t.type==="keydown"||t.type==="keyup"?kR[t.keyCode]||"Unidentified":""},code:0,location:0,ctrlKey:0,shiftKey:0,altKey:0,metaKey:0,repeat:0,locale:0,getModifierState:Xp,charCode:function(t){return t.type==="keypress"?Au(t):0},keyCode:function(t){return t.type==="keydown"||t.type==="keyup"?t.keyCode:0},which:function(t){return t.type==="keypress"?Au(t):t.type==="keydown"||t.type==="keyup"?t.keyCode:0}}),xR=hn(AR),PR=qe({},Gc,{pointerId:0,width:0,height:0,pressure:0,tangentialPressure:0,tiltX:0,tiltY:0,twist:0,pointerType:0,isPrimary:0}),vy=hn(PR),bR=qe({},hl,{touches:0,targetTouches:0,changedTouches:0,altKey:0,metaKey:0,ctrlKey:0,shiftKey:0,getModifierState:Xp}),NR=hn(bR),OR=qe({},co,{propertyName:0,elapsedTime:0,pseudoElement:0}),DR=hn(OR),MR=qe({},Gc,{deltaX:function(t){return"deltaX"in t?t.deltaX:"wheelDeltaX"in t?-t.wheelDeltaX:0},deltaY:function(t){return"deltaY"in t?t.deltaY:"wheelDeltaY"in t?-t.wheelDeltaY:"wheelDelta"in t?-t.wheelDelta:0},deltaZ:0,deltaMode:0}),LR=hn(MR),VR=[9,13,27,32],Jp=mr&&"CompositionEvent"in window,da=null;mr&&"documentMode"in document&&(da=document.documentMode);var FR=mr&&"TextEvent"in window&&!da,pE=mr&&(!Jp||da&&8<da&&11>=da),wy=" ",Ey=!1;function mE(t,e){switch(t){case"keyup":return VR.indexOf(e.keyCode)!==-1;case"keydown":return e.keyCode!==229;case"keypress":case"mousedown":case"focusout":return!0;default:return!1}}function gE(t){return t=t.detail,typeof t=="object"&&"data"in t?t.data:null}var Ts=!1;function UR(t,e){switch(t){case"compositionend":return gE(e);case"keypress":return e.which!==32?null:(Ey=!0,wy);case"textInput":return t=e.data,t===wy&&Ey?null:t;default:return null}}function jR(t,e){if(Ts)return t==="compositionend"||!Jp&&mE(t,e)?(t=fE(),Ru=Qp=$r=null,Ts=!1,t):null;switch(t){case"paste":return null;case"keypress":if(!(e.ctrlKey||e.altKey||e.metaKey)||e.ctrlKey&&e.altKey){if(e.char&&1<e.char.length)return e.char;if(e.which)return String.fromCharCode(e.which)}return null;case"compositionend":return pE&&e.locale!=="ko"?null:e.data;default:return null}}var zR={color:!0,date:!0,datetime:!0,"datetime-local":!0,email:!0,month:!0,number:!0,password:!0,range:!0,search:!0,tel:!0,text:!0,time:!0,url:!0,week:!0};function Ty(t){var e=t&&t.nodeName&&t.nodeName.toLowerCase();return e==="input"?!!zR[t.type]:e==="textarea"}function _E(t,e,n,r){K0(r),e=Zu(e,"onChange"),0<e.length&&(n=new Yp("onChange","change",null,n,r),t.push({event:n,listeners:e}))}var fa=null,Fa=null;function BR(t){AE(t,0)}function Kc(t){var e=ks(t);if(z0(e))return t}function $R(t,e){if(t==="change")return e}var yE=!1;if(mr){var ud;if(mr){var cd="oninput"in document;if(!cd){var Iy=document.createElement("div");Iy.setAttribute("oninput","return;"),cd=typeof Iy.oninput=="function"}ud=cd}else ud=!1;yE=ud&&(!document.documentMode||9<document.documentMode)}function Sy(){fa&&(fa.detachEvent("onpropertychange",vE),Fa=fa=null)}function vE(t){if(t.propertyName==="value"&&Kc(Fa)){var e=[];_E(e,Fa,t,Wp(t)),J0(BR,e)}}function WR(t,e,n){t==="focusin"?(Sy(),fa=e,Fa=n,fa.attachEvent("onpropertychange",vE)):t==="focusout"&&Sy()}function qR(t){if(t==="selectionchange"||t==="keyup"||t==="keydown")return Kc(Fa)}function HR(t,e){if(t==="click")return Kc(e)}function GR(t,e){if(t==="input"||t==="change")return Kc(e)}function KR(t,e){return t===e&&(t!==0||1/t===1/e)||t!==t&&e!==e}var Vn=typeof Object.is=="function"?Object.is:KR;function Ua(t,e){if(Vn(t,e))return!0;if(typeof t!="object"||t===null||typeof e!="object"||e===null)return!1;var n=Object.keys(t),r=Object.keys(e);if(n.length!==r.length)return!1;for(r=0;r<n.length;r++){var i=n[r];if(!ef.call(e,i)||!Vn(t[i],e[i]))return!1}return!0}function ky(t){for(;t&&t.firstChild;)t=t.firstChild;return t}function Cy(t,e){var n=ky(t);t=0;for(var r;n;){if(n.nodeType===3){if(r=t+n.textContent.length,t<=e&&r>=e)return{node:n,offset:e-t};t=r}e:{for(;n;){if(n.nextSibling){n=n.nextSibling;break e}n=n.parentNode}n=void 0}n=ky(n)}}function wE(t,e){return t&&e?t===e?!0:t&&t.nodeType===3?!1:e&&e.nodeType===3?wE(t,e.parentNode):"contains"in t?t.contains(e):t.compareDocumentPosition?!!(t.compareDocumentPosition(e)&16):!1:!1}function EE(){for(var t=window,e=Hu();e instanceof t.HTMLIFrameElement;){try{var n=typeof e.contentWindow.location.href=="string"}catch{n=!1}if(n)t=e.contentWindow;else break;e=Hu(t.document)}return e}function Zp(t){var e=t&&t.nodeName&&t.nodeName.toLowerCase();return e&&(e==="input"&&(t.type==="text"||t.type==="search"||t.type==="tel"||t.type==="url"||t.type==="password")||e==="textarea"||t.contentEditable==="true")}function QR(t){var e=EE(),n=t.focusedElem,r=t.selectionRange;if(e!==n&&n&&n.ownerDocument&&wE(n.ownerDocument.documentElement,n)){if(r!==null&&Zp(n)){if(e=r.start,t=r.end,t===void 0&&(t=e),"selectionStart"in n)n.selectionStart=e,n.selectionEnd=Math.min(t,n.value.length);else if(t=(e=n.ownerDocument||document)&&e.defaultView||window,t.getSelection){t=t.getSelection();var i=n.textContent.length,s=Math.min(r.start,i);r=r.end===void 0?s:Math.min(r.end,i),!t.extend&&s>r&&(i=r,r=s,s=i),i=Cy(n,s);var o=Cy(n,r);i&&o&&(t.rangeCount!==1||t.anchorNode!==i.node||t.anchorOffset!==i.offset||t.focusNode!==o.node||t.focusOffset!==o.offset)&&(e=e.createRange(),e.setStart(i.node,i.offset),t.removeAllRanges(),s>r?(t.addRange(e),t.extend(o.node,o.offset)):(e.setEnd(o.node,o.offset),t.addRange(e)))}}for(e=[],t=n;t=t.parentNode;)t.nodeType===1&&e.push({element:t,left:t.scrollLeft,top:t.scrollTop});for(typeof n.focus=="function"&&n.focus(),n=0;n<e.length;n++)t=e[n],t.element.scrollLeft=t.left,t.element.scrollTop=t.top}}var YR=mr&&"documentMode"in document&&11>=document.documentMode,Is=null,wf=null,pa=null,Ef=!1;function Ry(t,e,n){var r=n.window===n?n.document:n.nodeType===9?n:n.ownerDocument;Ef||Is==null||Is!==Hu(r)||(r=Is,"selectionStart"in r&&Zp(r)?r={start:r.selectionStart,end:r.selectionEnd}:(r=(r.ownerDocument&&r.ownerDocument.defaultView||window).getSelection(),r={anchorNode:r.anchorNode,anchorOffset:r.anchorOffset,focusNode:r.focusNode,focusOffset:r.focusOffset}),pa&&Ua(pa,r)||(pa=r,r=Zu(wf,"onSelect"),0<r.length&&(e=new Yp("onSelect","select",null,e,n),t.push({event:e,listeners:r}),e.target=Is)))}function iu(t,e){var n={};return n[t.toLowerCase()]=e.toLowerCase(),n["Webkit"+t]="webkit"+e,n["Moz"+t]="moz"+e,n}var Ss={animationend:iu("Animation","AnimationEnd"),animationiteration:iu("Animation","AnimationIteration"),animationstart:iu("Animation","AnimationStart"),transitionend:iu("Transition","TransitionEnd")},hd={},TE={};mr&&(TE=document.createElement("div").style,"AnimationEvent"in window||(delete Ss.animationend.animation,delete Ss.animationiteration.animation,delete Ss.animationstart.animation),"TransitionEvent"in window||delete Ss.transitionend.transition);function Qc(t){if(hd[t])return hd[t];if(!Ss[t])return t;var e=Ss[t],n;for(n in e)if(e.hasOwnProperty(n)&&n in TE)return hd[t]=e[n];return t}var IE=Qc("animationend"),SE=Qc("animationiteration"),kE=Qc("animationstart"),CE=Qc("transitionend"),RE=new Map,Ay="abort auxClick cancel canPlay canPlayThrough click close contextMenu copy cut drag dragEnd dragEnter dragExit dragLeave dragOver dragStart drop durationChange emptied encrypted ended error gotPointerCapture input invalid keyDown keyPress keyUp load loadedData loadedMetadata loadStart lostPointerCapture mouseDown mouseMove mouseOut mouseOver mouseUp paste pause play playing pointerCancel pointerDown pointerMove pointerOut pointerOver pointerUp progress rateChange reset resize seeked seeking stalled submit suspend timeUpdate touchCancel touchEnd touchStart volumeChange scroll toggle touchMove waiting wheel".split(" ");function mi(t,e){RE.set(t,e),Zi(e,[t])}for(var dd=0;dd<Ay.length;dd++){var fd=Ay[dd],XR=fd.toLowerCase(),JR=fd[0].toUpperCase()+fd.slice(1);mi(XR,"on"+JR)}mi(IE,"onAnimationEnd");mi(SE,"onAnimationIteration");mi(kE,"onAnimationStart");mi("dblclick","onDoubleClick");mi("focusin","onFocus");mi("focusout","onBlur");mi(CE,"onTransitionEnd");Hs("onMouseEnter",["mouseout","mouseover"]);Hs("onMouseLeave",["mouseout","mouseover"]);Hs("onPointerEnter",["pointerout","pointerover"]);Hs("onPointerLeave",["pointerout","pointerover"]);Zi("onChange","change click focusin focusout input keydown keyup selectionchange".split(" "));Zi("onSelect","focusout contextmenu dragend focusin keydown keyup mousedown mouseup selectionchange".split(" "));Zi("onBeforeInput",["compositionend","keypress","textInput","paste"]);Zi("onCompositionEnd","compositionend focusout keydown keypress keyup mousedown".split(" "));Zi("onCompositionStart","compositionstart focusout keydown keypress keyup mousedown".split(" "));Zi("onCompositionUpdate","compositionupdate focusout keydown keypress keyup mousedown".split(" "));var oa="abort canplay canplaythrough durationchange emptied encrypted ended error loadeddata loadedmetadata loadstart pause play playing progress ratechange resize seeked seeking stalled suspend timeupdate volumechange waiting".split(" "),ZR=new Set("cancel close invalid load scroll toggle".split(" ").concat(oa));function xy(t,e,n){var r=t.type||"unknown-event";t.currentTarget=n,XC(r,e,void 0,t),t.currentTarget=null}function AE(t,e){e=(e&4)!==0;for(var n=0;n<t.length;n++){var r=t[n],i=r.event;r=r.listeners;e:{var s=void 0;if(e)for(var o=r.length-1;0<=o;o--){var a=r[o],u=a.instance,c=a.currentTarget;if(a=a.listener,u!==s&&i.isPropagationStopped())break e;xy(i,a,c),s=u}else for(o=0;o<r.length;o++){if(a=r[o],u=a.instance,c=a.currentTarget,a=a.listener,u!==s&&i.isPropagationStopped())break e;xy(i,a,c),s=u}}}if(Ku)throw t=gf,Ku=!1,gf=null,t}function Me(t,e){var n=e[Cf];n===void 0&&(n=e[Cf]=new Set);var r=t+"__bubble";n.has(r)||(xE(e,t,2,!1),n.add(r))}function pd(t,e,n){var r=0;e&&(r|=4),xE(n,t,r,e)}var su="_reactListening"+Math.random().toString(36).slice(2);function ja(t){if(!t[su]){t[su]=!0,L0.forEach(function(n){n!=="selectionchange"&&(ZR.has(n)||pd(n,!1,t),pd(n,!0,t))});var e=t.nodeType===9?t:t.ownerDocument;e===null||e[su]||(e[su]=!0,pd("selectionchange",!1,e))}}function xE(t,e,n,r){switch(dE(e)){case 1:var i=fR;break;case 4:i=pR;break;default:i=Kp}n=i.bind(null,e,n,t),i=void 0,!mf||e!=="touchstart"&&e!=="touchmove"&&e!=="wheel"||(i=!0),r?i!==void 0?t.addEventListener(e,n,{capture:!0,passive:i}):t.addEventListener(e,n,!0):i!==void 0?t.addEventListener(e,n,{passive:i}):t.addEventListener(e,n,!1)}function md(t,e,n,r,i){var s=r;if(!(e&1)&&!(e&2)&&r!==null)e:for(;;){if(r===null)return;var o=r.tag;if(o===3||o===4){var a=r.stateNode.containerInfo;if(a===i||a.nodeType===8&&a.parentNode===i)break;if(o===4)for(o=r.return;o!==null;){var u=o.tag;if((u===3||u===4)&&(u=o.stateNode.containerInfo,u===i||u.nodeType===8&&u.parentNode===i))return;o=o.return}for(;a!==null;){if(o=xi(a),o===null)return;if(u=o.tag,u===5||u===6){r=s=o;continue e}a=a.parentNode}}r=r.return}J0(function(){var c=s,d=Wp(n),f=[];e:{var m=RE.get(t);if(m!==void 0){var w=Yp,I=t;switch(t){case"keypress":if(Au(n)===0)break e;case"keydown":case"keyup":w=xR;break;case"focusin":I="focus",w=ld;break;case"focusout":I="blur",w=ld;break;case"beforeblur":case"afterblur":w=ld;break;case"click":if(n.button===2)break e;case"auxclick":case"dblclick":case"mousedown":case"mousemove":case"mouseup":case"mouseout":case"mouseover":case"contextmenu":w=_y;break;case"drag":case"dragend":case"dragenter":case"dragexit":case"dragleave":case"dragover":case"dragstart":case"drop":w=_R;break;case"touchcancel":case"touchend":case"touchmove":case"touchstart":w=NR;break;case IE:case SE:case kE:w=wR;break;case CE:w=DR;break;case"scroll":w=mR;break;case"wheel":w=LR;break;case"copy":case"cut":case"paste":w=TR;break;case"gotpointercapture":case"lostpointercapture":case"pointercancel":case"pointerdown":case"pointermove":case"pointerout":case"pointerover":case"pointerup":w=vy}var P=(e&4)!==0,O=!P&&t==="scroll",C=P?m!==null?m+"Capture":null:m;P=[];for(var T=c,S;T!==null;){S=T;var M=S.stateNode;if(S.tag===5&&M!==null&&(S=M,C!==null&&(M=Da(T,C),M!=null&&P.push(za(T,M,S)))),O)break;T=T.return}0<P.length&&(m=new w(m,I,null,n,d),f.push({event:m,listeners:P}))}}if(!(e&7)){e:{if(m=t==="mouseover"||t==="pointerover",w=t==="mouseout"||t==="pointerout",m&&n!==ff&&(I=n.relatedTarget||n.fromElement)&&(xi(I)||I[gr]))break e;if((w||m)&&(m=d.window===d?d:(m=d.ownerDocument)?m.defaultView||m.parentWindow:window,w?(I=n.relatedTarget||n.toElement,w=c,I=I?xi(I):null,I!==null&&(O=es(I),I!==O||I.tag!==5&&I.tag!==6)&&(I=null)):(w=null,I=c),w!==I)){if(P=_y,M="onMouseLeave",C="onMouseEnter",T="mouse",(t==="pointerout"||t==="pointerover")&&(P=vy,M="onPointerLeave",C="onPointerEnter",T="pointer"),O=w==null?m:ks(w),S=I==null?m:ks(I),m=new P(M,T+"leave",w,n,d),m.target=O,m.relatedTarget=S,M=null,xi(d)===c&&(P=new P(C,T+"enter",I,n,d),P.target=S,P.relatedTarget=O,M=P),O=M,w&&I)t:{for(P=w,C=I,T=0,S=P;S;S=ps(S))T++;for(S=0,M=C;M;M=ps(M))S++;for(;0<T-S;)P=ps(P),T--;for(;0<S-T;)C=ps(C),S--;for(;T--;){if(P===C||C!==null&&P===C.alternate)break t;P=ps(P),C=ps(C)}P=null}else P=null;w!==null&&Py(f,m,w,P,!1),I!==null&&O!==null&&Py(f,O,I,P,!0)}}e:{if(m=c?ks(c):window,w=m.nodeName&&m.nodeName.toLowerCase(),w==="select"||w==="input"&&m.type==="file")var V=$R;else if(Ty(m))if(yE)V=GR;else{V=qR;var F=WR}else(w=m.nodeName)&&w.toLowerCase()==="input"&&(m.type==="checkbox"||m.type==="radio")&&(V=HR);if(V&&(V=V(t,c))){_E(f,V,n,d);break e}F&&F(t,m,c),t==="focusout"&&(F=m._wrapperState)&&F.controlled&&m.type==="number"&&lf(m,"number",m.value)}switch(F=c?ks(c):window,t){case"focusin":(Ty(F)||F.contentEditable==="true")&&(Is=F,wf=c,pa=null);break;case"focusout":pa=wf=Is=null;break;case"mousedown":Ef=!0;break;case"contextmenu":case"mouseup":case"dragend":Ef=!1,Ry(f,n,d);break;case"selectionchange":if(YR)break;case"keydown":case"keyup":Ry(f,n,d)}var y;if(Jp)e:{switch(t){case"compositionstart":var g="onCompositionStart";break e;case"compositionend":g="onCompositionEnd";break e;case"compositionupdate":g="onCompositionUpdate";break e}g=void 0}else Ts?mE(t,n)&&(g="onCompositionEnd"):t==="keydown"&&n.keyCode===229&&(g="onCompositionStart");g&&(pE&&n.locale!=="ko"&&(Ts||g!=="onCompositionStart"?g==="onCompositionEnd"&&Ts&&(y=fE()):($r=d,Qp="value"in $r?$r.value:$r.textContent,Ts=!0)),F=Zu(c,g),0<F.length&&(g=new yy(g,t,null,n,d),f.push({event:g,listeners:F}),y?g.data=y:(y=gE(n),y!==null&&(g.data=y)))),(y=FR?UR(t,n):jR(t,n))&&(c=Zu(c,"onBeforeInput"),0<c.length&&(d=new yy("onBeforeInput","beforeinput",null,n,d),f.push({event:d,listeners:c}),d.data=y))}AE(f,e)})}function za(t,e,n){return{instance:t,listener:e,currentTarget:n}}function Zu(t,e){for(var n=e+"Capture",r=[];t!==null;){var i=t,s=i.stateNode;i.tag===5&&s!==null&&(i=s,s=Da(t,n),s!=null&&r.unshift(za(t,s,i)),s=Da(t,e),s!=null&&r.push(za(t,s,i))),t=t.return}return r}function ps(t){if(t===null)return null;do t=t.return;while(t&&t.tag!==5);return t||null}function Py(t,e,n,r,i){for(var s=e._reactName,o=[];n!==null&&n!==r;){var a=n,u=a.alternate,c=a.stateNode;if(u!==null&&u===r)break;a.tag===5&&c!==null&&(a=c,i?(u=Da(n,s),u!=null&&o.unshift(za(n,u,a))):i||(u=Da(n,s),u!=null&&o.push(za(n,u,a)))),n=n.return}o.length!==0&&t.push({event:e,listeners:o})}var eA=/\r\n?/g,tA=/\u0000|\uFFFD/g;function by(t){return(typeof t=="string"?t:""+t).replace(eA,`
`).replace(tA,"")}function ou(t,e,n){if(e=by(e),by(t)!==e&&n)throw Error(z(425))}function ec(){}var Tf=null,If=null;function Sf(t,e){return t==="textarea"||t==="noscript"||typeof e.children=="string"||typeof e.children=="number"||typeof e.dangerouslySetInnerHTML=="object"&&e.dangerouslySetInnerHTML!==null&&e.dangerouslySetInnerHTML.__html!=null}var kf=typeof setTimeout=="function"?setTimeout:void 0,nA=typeof clearTimeout=="function"?clearTimeout:void 0,Ny=typeof Promise=="function"?Promise:void 0,rA=typeof queueMicrotask=="function"?queueMicrotask:typeof Ny<"u"?function(t){return Ny.resolve(null).then(t).catch(iA)}:kf;function iA(t){setTimeout(function(){throw t})}function gd(t,e){var n=e,r=0;do{var i=n.nextSibling;if(t.removeChild(n),i&&i.nodeType===8)if(n=i.data,n==="/$"){if(r===0){t.removeChild(i),Va(e);return}r--}else n!=="$"&&n!=="$?"&&n!=="$!"||r++;n=i}while(n);Va(e)}function Qr(t){for(;t!=null;t=t.nextSibling){var e=t.nodeType;if(e===1||e===3)break;if(e===8){if(e=t.data,e==="$"||e==="$!"||e==="$?")break;if(e==="/$")return null}}return t}function Oy(t){t=t.previousSibling;for(var e=0;t;){if(t.nodeType===8){var n=t.data;if(n==="$"||n==="$!"||n==="$?"){if(e===0)return t;e--}else n==="/$"&&e++}t=t.previousSibling}return null}var ho=Math.random().toString(36).slice(2),Bn="__reactFiber$"+ho,Ba="__reactProps$"+ho,gr="__reactContainer$"+ho,Cf="__reactEvents$"+ho,sA="__reactListeners$"+ho,oA="__reactHandles$"+ho;function xi(t){var e=t[Bn];if(e)return e;for(var n=t.parentNode;n;){if(e=n[gr]||n[Bn]){if(n=e.alternate,e.child!==null||n!==null&&n.child!==null)for(t=Oy(t);t!==null;){if(n=t[Bn])return n;t=Oy(t)}return e}t=n,n=t.parentNode}return null}function dl(t){return t=t[Bn]||t[gr],!t||t.tag!==5&&t.tag!==6&&t.tag!==13&&t.tag!==3?null:t}function ks(t){if(t.tag===5||t.tag===6)return t.stateNode;throw Error(z(33))}function Yc(t){return t[Ba]||null}var Rf=[],Cs=-1;function gi(t){return{current:t}}function Ue(t){0>Cs||(t.current=Rf[Cs],Rf[Cs]=null,Cs--)}function Oe(t,e){Cs++,Rf[Cs]=t.current,t.current=e}var li={},Vt=gi(li),Xt=gi(!1),Ui=li;function Gs(t,e){var n=t.type.contextTypes;if(!n)return li;var r=t.stateNode;if(r&&r.__reactInternalMemoizedUnmaskedChildContext===e)return r.__reactInternalMemoizedMaskedChildContext;var i={},s;for(s in n)i[s]=e[s];return r&&(t=t.stateNode,t.__reactInternalMemoizedUnmaskedChildContext=e,t.__reactInternalMemoizedMaskedChildContext=i),i}function Jt(t){return t=t.childContextTypes,t!=null}function tc(){Ue(Xt),Ue(Vt)}function Dy(t,e,n){if(Vt.current!==li)throw Error(z(168));Oe(Vt,e),Oe(Xt,n)}function PE(t,e,n){var r=t.stateNode;if(e=e.childContextTypes,typeof r.getChildContext!="function")return n;r=r.getChildContext();for(var i in r)if(!(i in e))throw Error(z(108,WC(t)||"Unknown",i));return qe({},n,r)}function nc(t){return t=(t=t.stateNode)&&t.__reactInternalMemoizedMergedChildContext||li,Ui=Vt.current,Oe(Vt,t),Oe(Xt,Xt.current),!0}function My(t,e,n){var r=t.stateNode;if(!r)throw Error(z(169));n?(t=PE(t,e,Ui),r.__reactInternalMemoizedMergedChildContext=t,Ue(Xt),Ue(Vt),Oe(Vt,t)):Ue(Xt),Oe(Xt,n)}var ir=null,Xc=!1,_d=!1;function bE(t){ir===null?ir=[t]:ir.push(t)}function aA(t){Xc=!0,bE(t)}function _i(){if(!_d&&ir!==null){_d=!0;var t=0,e=Ie;try{var n=ir;for(Ie=1;t<n.length;t++){var r=n[t];do r=r(!0);while(r!==null)}ir=null,Xc=!1}catch(i){throw ir!==null&&(ir=ir.slice(t+1)),nE(qp,_i),i}finally{Ie=e,_d=!1}}return null}var Rs=[],As=0,rc=null,ic=0,dn=[],fn=0,ji=null,sr=1,or="";function Si(t,e){Rs[As++]=ic,Rs[As++]=rc,rc=t,ic=e}function NE(t,e,n){dn[fn++]=sr,dn[fn++]=or,dn[fn++]=ji,ji=t;var r=sr;t=or;var i=32-Dn(r)-1;r&=~(1<<i),n+=1;var s=32-Dn(e)+i;if(30<s){var o=i-i%5;s=(r&(1<<o)-1).toString(32),r>>=o,i-=o,sr=1<<32-Dn(e)+i|n<<i|r,or=s+t}else sr=1<<s|n<<i|r,or=t}function em(t){t.return!==null&&(Si(t,1),NE(t,1,0))}function tm(t){for(;t===rc;)rc=Rs[--As],Rs[As]=null,ic=Rs[--As],Rs[As]=null;for(;t===ji;)ji=dn[--fn],dn[fn]=null,or=dn[--fn],dn[fn]=null,sr=dn[--fn],dn[fn]=null}var ln=null,on=null,Be=!1,Pn=null;function OE(t,e){var n=mn(5,null,null,0);n.elementType="DELETED",n.stateNode=e,n.return=t,e=t.deletions,e===null?(t.deletions=[n],t.flags|=16):e.push(n)}function Ly(t,e){switch(t.tag){case 5:var n=t.type;return e=e.nodeType!==1||n.toLowerCase()!==e.nodeName.toLowerCase()?null:e,e!==null?(t.stateNode=e,ln=t,on=Qr(e.firstChild),!0):!1;case 6:return e=t.pendingProps===""||e.nodeType!==3?null:e,e!==null?(t.stateNode=e,ln=t,on=null,!0):!1;case 13:return e=e.nodeType!==8?null:e,e!==null?(n=ji!==null?{id:sr,overflow:or}:null,t.memoizedState={dehydrated:e,treeContext:n,retryLane:1073741824},n=mn(18,null,null,0),n.stateNode=e,n.return=t,t.child=n,ln=t,on=null,!0):!1;default:return!1}}function Af(t){return(t.mode&1)!==0&&(t.flags&128)===0}function xf(t){if(Be){var e=on;if(e){var n=e;if(!Ly(t,e)){if(Af(t))throw Error(z(418));e=Qr(n.nextSibling);var r=ln;e&&Ly(t,e)?OE(r,n):(t.flags=t.flags&-4097|2,Be=!1,ln=t)}}else{if(Af(t))throw Error(z(418));t.flags=t.flags&-4097|2,Be=!1,ln=t}}}function Vy(t){for(t=t.return;t!==null&&t.tag!==5&&t.tag!==3&&t.tag!==13;)t=t.return;ln=t}function au(t){if(t!==ln)return!1;if(!Be)return Vy(t),Be=!0,!1;var e;if((e=t.tag!==3)&&!(e=t.tag!==5)&&(e=t.type,e=e!=="head"&&e!=="body"&&!Sf(t.type,t.memoizedProps)),e&&(e=on)){if(Af(t))throw DE(),Error(z(418));for(;e;)OE(t,e),e=Qr(e.nextSibling)}if(Vy(t),t.tag===13){if(t=t.memoizedState,t=t!==null?t.dehydrated:null,!t)throw Error(z(317));e:{for(t=t.nextSibling,e=0;t;){if(t.nodeType===8){var n=t.data;if(n==="/$"){if(e===0){on=Qr(t.nextSibling);break e}e--}else n!=="$"&&n!=="$!"&&n!=="$?"||e++}t=t.nextSibling}on=null}}else on=ln?Qr(t.stateNode.nextSibling):null;return!0}function DE(){for(var t=on;t;)t=Qr(t.nextSibling)}function Ks(){on=ln=null,Be=!1}function nm(t){Pn===null?Pn=[t]:Pn.push(t)}var lA=Rr.ReactCurrentBatchConfig;function Ho(t,e,n){if(t=n.ref,t!==null&&typeof t!="function"&&typeof t!="object"){if(n._owner){if(n=n._owner,n){if(n.tag!==1)throw Error(z(309));var r=n.stateNode}if(!r)throw Error(z(147,t));var i=r,s=""+t;return e!==null&&e.ref!==null&&typeof e.ref=="function"&&e.ref._stringRef===s?e.ref:(e=function(o){var a=i.refs;o===null?delete a[s]:a[s]=o},e._stringRef=s,e)}if(typeof t!="string")throw Error(z(284));if(!n._owner)throw Error(z(290,t))}return t}function lu(t,e){throw t=Object.prototype.toString.call(e),Error(z(31,t==="[object Object]"?"object with keys {"+Object.keys(e).join(", ")+"}":t))}function Fy(t){var e=t._init;return e(t._payload)}function ME(t){function e(C,T){if(t){var S=C.deletions;S===null?(C.deletions=[T],C.flags|=16):S.push(T)}}function n(C,T){if(!t)return null;for(;T!==null;)e(C,T),T=T.sibling;return null}function r(C,T){for(C=new Map;T!==null;)T.key!==null?C.set(T.key,T):C.set(T.index,T),T=T.sibling;return C}function i(C,T){return C=Zr(C,T),C.index=0,C.sibling=null,C}function s(C,T,S){return C.index=S,t?(S=C.alternate,S!==null?(S=S.index,S<T?(C.flags|=2,T):S):(C.flags|=2,T)):(C.flags|=1048576,T)}function o(C){return t&&C.alternate===null&&(C.flags|=2),C}function a(C,T,S,M){return T===null||T.tag!==6?(T=Sd(S,C.mode,M),T.return=C,T):(T=i(T,S),T.return=C,T)}function u(C,T,S,M){var V=S.type;return V===Es?d(C,T,S.props.children,M,S.key):T!==null&&(T.elementType===V||typeof V=="object"&&V!==null&&V.$$typeof===Dr&&Fy(V)===T.type)?(M=i(T,S.props),M.ref=Ho(C,T,S),M.return=C,M):(M=Mu(S.type,S.key,S.props,null,C.mode,M),M.ref=Ho(C,T,S),M.return=C,M)}function c(C,T,S,M){return T===null||T.tag!==4||T.stateNode.containerInfo!==S.containerInfo||T.stateNode.implementation!==S.implementation?(T=kd(S,C.mode,M),T.return=C,T):(T=i(T,S.children||[]),T.return=C,T)}function d(C,T,S,M,V){return T===null||T.tag!==7?(T=Li(S,C.mode,M,V),T.return=C,T):(T=i(T,S),T.return=C,T)}function f(C,T,S){if(typeof T=="string"&&T!==""||typeof T=="number")return T=Sd(""+T,C.mode,S),T.return=C,T;if(typeof T=="object"&&T!==null){switch(T.$$typeof){case Xl:return S=Mu(T.type,T.key,T.props,null,C.mode,S),S.ref=Ho(C,null,T),S.return=C,S;case ws:return T=kd(T,C.mode,S),T.return=C,T;case Dr:var M=T._init;return f(C,M(T._payload),S)}if(ia(T)||zo(T))return T=Li(T,C.mode,S,null),T.return=C,T;lu(C,T)}return null}function m(C,T,S,M){var V=T!==null?T.key:null;if(typeof S=="string"&&S!==""||typeof S=="number")return V!==null?null:a(C,T,""+S,M);if(typeof S=="object"&&S!==null){switch(S.$$typeof){case Xl:return S.key===V?u(C,T,S,M):null;case ws:return S.key===V?c(C,T,S,M):null;case Dr:return V=S._init,m(C,T,V(S._payload),M)}if(ia(S)||zo(S))return V!==null?null:d(C,T,S,M,null);lu(C,S)}return null}function w(C,T,S,M,V){if(typeof M=="string"&&M!==""||typeof M=="number")return C=C.get(S)||null,a(T,C,""+M,V);if(typeof M=="object"&&M!==null){switch(M.$$typeof){case Xl:return C=C.get(M.key===null?S:M.key)||null,u(T,C,M,V);case ws:return C=C.get(M.key===null?S:M.key)||null,c(T,C,M,V);case Dr:var F=M._init;return w(C,T,S,F(M._payload),V)}if(ia(M)||zo(M))return C=C.get(S)||null,d(T,C,M,V,null);lu(T,M)}return null}function I(C,T,S,M){for(var V=null,F=null,y=T,g=T=0,E=null;y!==null&&g<S.length;g++){y.index>g?(E=y,y=null):E=y.sibling;var k=m(C,y,S[g],M);if(k===null){y===null&&(y=E);break}t&&y&&k.alternate===null&&e(C,y),T=s(k,T,g),F===null?V=k:F.sibling=k,F=k,y=E}if(g===S.length)return n(C,y),Be&&Si(C,g),V;if(y===null){for(;g<S.length;g++)y=f(C,S[g],M),y!==null&&(T=s(y,T,g),F===null?V=y:F.sibling=y,F=y);return Be&&Si(C,g),V}for(y=r(C,y);g<S.length;g++)E=w(y,C,g,S[g],M),E!==null&&(t&&E.alternate!==null&&y.delete(E.key===null?g:E.key),T=s(E,T,g),F===null?V=E:F.sibling=E,F=E);return t&&y.forEach(function(x){return e(C,x)}),Be&&Si(C,g),V}function P(C,T,S,M){var V=zo(S);if(typeof V!="function")throw Error(z(150));if(S=V.call(S),S==null)throw Error(z(151));for(var F=V=null,y=T,g=T=0,E=null,k=S.next();y!==null&&!k.done;g++,k=S.next()){y.index>g?(E=y,y=null):E=y.sibling;var x=m(C,y,k.value,M);if(x===null){y===null&&(y=E);break}t&&y&&x.alternate===null&&e(C,y),T=s(x,T,g),F===null?V=x:F.sibling=x,F=x,y=E}if(k.done)return n(C,y),Be&&Si(C,g),V;if(y===null){for(;!k.done;g++,k=S.next())k=f(C,k.value,M),k!==null&&(T=s(k,T,g),F===null?V=k:F.sibling=k,F=k);return Be&&Si(C,g),V}for(y=r(C,y);!k.done;g++,k=S.next())k=w(y,C,g,k.value,M),k!==null&&(t&&k.alternate!==null&&y.delete(k.key===null?g:k.key),T=s(k,T,g),F===null?V=k:F.sibling=k,F=k);return t&&y.forEach(function(N){return e(C,N)}),Be&&Si(C,g),V}function O(C,T,S,M){if(typeof S=="object"&&S!==null&&S.type===Es&&S.key===null&&(S=S.props.children),typeof S=="object"&&S!==null){switch(S.$$typeof){case Xl:e:{for(var V=S.key,F=T;F!==null;){if(F.key===V){if(V=S.type,V===Es){if(F.tag===7){n(C,F.sibling),T=i(F,S.props.children),T.return=C,C=T;break e}}else if(F.elementType===V||typeof V=="object"&&V!==null&&V.$$typeof===Dr&&Fy(V)===F.type){n(C,F.sibling),T=i(F,S.props),T.ref=Ho(C,F,S),T.return=C,C=T;break e}n(C,F);break}else e(C,F);F=F.sibling}S.type===Es?(T=Li(S.props.children,C.mode,M,S.key),T.return=C,C=T):(M=Mu(S.type,S.key,S.props,null,C.mode,M),M.ref=Ho(C,T,S),M.return=C,C=M)}return o(C);case ws:e:{for(F=S.key;T!==null;){if(T.key===F)if(T.tag===4&&T.stateNode.containerInfo===S.containerInfo&&T.stateNode.implementation===S.implementation){n(C,T.sibling),T=i(T,S.children||[]),T.return=C,C=T;break e}else{n(C,T);break}else e(C,T);T=T.sibling}T=kd(S,C.mode,M),T.return=C,C=T}return o(C);case Dr:return F=S._init,O(C,T,F(S._payload),M)}if(ia(S))return I(C,T,S,M);if(zo(S))return P(C,T,S,M);lu(C,S)}return typeof S=="string"&&S!==""||typeof S=="number"?(S=""+S,T!==null&&T.tag===6?(n(C,T.sibling),T=i(T,S),T.return=C,C=T):(n(C,T),T=Sd(S,C.mode,M),T.return=C,C=T),o(C)):n(C,T)}return O}var Qs=ME(!0),LE=ME(!1),sc=gi(null),oc=null,xs=null,rm=null;function im(){rm=xs=oc=null}function sm(t){var e=sc.current;Ue(sc),t._currentValue=e}function Pf(t,e,n){for(;t!==null;){var r=t.alternate;if((t.childLanes&e)!==e?(t.childLanes|=e,r!==null&&(r.childLanes|=e)):r!==null&&(r.childLanes&e)!==e&&(r.childLanes|=e),t===n)break;t=t.return}}function Fs(t,e){oc=t,rm=xs=null,t=t.dependencies,t!==null&&t.firstContext!==null&&(t.lanes&e&&(Qt=!0),t.firstContext=null)}function Tn(t){var e=t._currentValue;if(rm!==t)if(t={context:t,memoizedValue:e,next:null},xs===null){if(oc===null)throw Error(z(308));xs=t,oc.dependencies={lanes:0,firstContext:t}}else xs=xs.next=t;return e}var Pi=null;function om(t){Pi===null?Pi=[t]:Pi.push(t)}function VE(t,e,n,r){var i=e.interleaved;return i===null?(n.next=n,om(e)):(n.next=i.next,i.next=n),e.interleaved=n,_r(t,r)}function _r(t,e){t.lanes|=e;var n=t.alternate;for(n!==null&&(n.lanes|=e),n=t,t=t.return;t!==null;)t.childLanes|=e,n=t.alternate,n!==null&&(n.childLanes|=e),n=t,t=t.return;return n.tag===3?n.stateNode:null}var Mr=!1;function am(t){t.updateQueue={baseState:t.memoizedState,firstBaseUpdate:null,lastBaseUpdate:null,shared:{pending:null,interleaved:null,lanes:0},effects:null}}function FE(t,e){t=t.updateQueue,e.updateQueue===t&&(e.updateQueue={baseState:t.baseState,firstBaseUpdate:t.firstBaseUpdate,lastBaseUpdate:t.lastBaseUpdate,shared:t.shared,effects:t.effects})}function dr(t,e){return{eventTime:t,lane:e,tag:0,payload:null,callback:null,next:null}}function Yr(t,e,n){var r=t.updateQueue;if(r===null)return null;if(r=r.shared,ge&2){var i=r.pending;return i===null?e.next=e:(e.next=i.next,i.next=e),r.pending=e,_r(t,n)}return i=r.interleaved,i===null?(e.next=e,om(r)):(e.next=i.next,i.next=e),r.interleaved=e,_r(t,n)}function xu(t,e,n){if(e=e.updateQueue,e!==null&&(e=e.shared,(n&4194240)!==0)){var r=e.lanes;r&=t.pendingLanes,n|=r,e.lanes=n,Hp(t,n)}}function Uy(t,e){var n=t.updateQueue,r=t.alternate;if(r!==null&&(r=r.updateQueue,n===r)){var i=null,s=null;if(n=n.firstBaseUpdate,n!==null){do{var o={eventTime:n.eventTime,lane:n.lane,tag:n.tag,payload:n.payload,callback:n.callback,next:null};s===null?i=s=o:s=s.next=o,n=n.next}while(n!==null);s===null?i=s=e:s=s.next=e}else i=s=e;n={baseState:r.baseState,firstBaseUpdate:i,lastBaseUpdate:s,shared:r.shared,effects:r.effects},t.updateQueue=n;return}t=n.lastBaseUpdate,t===null?n.firstBaseUpdate=e:t.next=e,n.lastBaseUpdate=e}function ac(t,e,n,r){var i=t.updateQueue;Mr=!1;var s=i.firstBaseUpdate,o=i.lastBaseUpdate,a=i.shared.pending;if(a!==null){i.shared.pending=null;var u=a,c=u.next;u.next=null,o===null?s=c:o.next=c,o=u;var d=t.alternate;d!==null&&(d=d.updateQueue,a=d.lastBaseUpdate,a!==o&&(a===null?d.firstBaseUpdate=c:a.next=c,d.lastBaseUpdate=u))}if(s!==null){var f=i.baseState;o=0,d=c=u=null,a=s;do{var m=a.lane,w=a.eventTime;if((r&m)===m){d!==null&&(d=d.next={eventTime:w,lane:0,tag:a.tag,payload:a.payload,callback:a.callback,next:null});e:{var I=t,P=a;switch(m=e,w=n,P.tag){case 1:if(I=P.payload,typeof I=="function"){f=I.call(w,f,m);break e}f=I;break e;case 3:I.flags=I.flags&-65537|128;case 0:if(I=P.payload,m=typeof I=="function"?I.call(w,f,m):I,m==null)break e;f=qe({},f,m);break e;case 2:Mr=!0}}a.callback!==null&&a.lane!==0&&(t.flags|=64,m=i.effects,m===null?i.effects=[a]:m.push(a))}else w={eventTime:w,lane:m,tag:a.tag,payload:a.payload,callback:a.callback,next:null},d===null?(c=d=w,u=f):d=d.next=w,o|=m;if(a=a.next,a===null){if(a=i.shared.pending,a===null)break;m=a,a=m.next,m.next=null,i.lastBaseUpdate=m,i.shared.pending=null}}while(!0);if(d===null&&(u=f),i.baseState=u,i.firstBaseUpdate=c,i.lastBaseUpdate=d,e=i.shared.interleaved,e!==null){i=e;do o|=i.lane,i=i.next;while(i!==e)}else s===null&&(i.shared.lanes=0);Bi|=o,t.lanes=o,t.memoizedState=f}}function jy(t,e,n){if(t=e.effects,e.effects=null,t!==null)for(e=0;e<t.length;e++){var r=t[e],i=r.callback;if(i!==null){if(r.callback=null,r=n,typeof i!="function")throw Error(z(191,i));i.call(r)}}}var fl={},Hn=gi(fl),$a=gi(fl),Wa=gi(fl);function bi(t){if(t===fl)throw Error(z(174));return t}function lm(t,e){switch(Oe(Wa,e),Oe($a,t),Oe(Hn,fl),t=e.nodeType,t){case 9:case 11:e=(e=e.documentElement)?e.namespaceURI:cf(null,"");break;default:t=t===8?e.parentNode:e,e=t.namespaceURI||null,t=t.tagName,e=cf(e,t)}Ue(Hn),Oe(Hn,e)}function Ys(){Ue(Hn),Ue($a),Ue(Wa)}function UE(t){bi(Wa.current);var e=bi(Hn.current),n=cf(e,t.type);e!==n&&(Oe($a,t),Oe(Hn,n))}function um(t){$a.current===t&&(Ue(Hn),Ue($a))}var $e=gi(0);function lc(t){for(var e=t;e!==null;){if(e.tag===13){var n=e.memoizedState;if(n!==null&&(n=n.dehydrated,n===null||n.data==="$?"||n.data==="$!"))return e}else if(e.tag===19&&e.memoizedProps.revealOrder!==void 0){if(e.flags&128)return e}else if(e.child!==null){e.child.return=e,e=e.child;continue}if(e===t)break;for(;e.sibling===null;){if(e.return===null||e.return===t)return null;e=e.return}e.sibling.return=e.return,e=e.sibling}return null}var yd=[];function cm(){for(var t=0;t<yd.length;t++)yd[t]._workInProgressVersionPrimary=null;yd.length=0}var Pu=Rr.ReactCurrentDispatcher,vd=Rr.ReactCurrentBatchConfig,zi=0,We=null,ot=null,pt=null,uc=!1,ma=!1,qa=0,uA=0;function xt(){throw Error(z(321))}function hm(t,e){if(e===null)return!1;for(var n=0;n<e.length&&n<t.length;n++)if(!Vn(t[n],e[n]))return!1;return!0}function dm(t,e,n,r,i,s){if(zi=s,We=e,e.memoizedState=null,e.updateQueue=null,e.lanes=0,Pu.current=t===null||t.memoizedState===null?fA:pA,t=n(r,i),ma){s=0;do{if(ma=!1,qa=0,25<=s)throw Error(z(301));s+=1,pt=ot=null,e.updateQueue=null,Pu.current=mA,t=n(r,i)}while(ma)}if(Pu.current=cc,e=ot!==null&&ot.next!==null,zi=0,pt=ot=We=null,uc=!1,e)throw Error(z(300));return t}function fm(){var t=qa!==0;return qa=0,t}function zn(){var t={memoizedState:null,baseState:null,baseQueue:null,queue:null,next:null};return pt===null?We.memoizedState=pt=t:pt=pt.next=t,pt}function In(){if(ot===null){var t=We.alternate;t=t!==null?t.memoizedState:null}else t=ot.next;var e=pt===null?We.memoizedState:pt.next;if(e!==null)pt=e,ot=t;else{if(t===null)throw Error(z(310));ot=t,t={memoizedState:ot.memoizedState,baseState:ot.baseState,baseQueue:ot.baseQueue,queue:ot.queue,next:null},pt===null?We.memoizedState=pt=t:pt=pt.next=t}return pt}function Ha(t,e){return typeof e=="function"?e(t):e}function wd(t){var e=In(),n=e.queue;if(n===null)throw Error(z(311));n.lastRenderedReducer=t;var r=ot,i=r.baseQueue,s=n.pending;if(s!==null){if(i!==null){var o=i.next;i.next=s.next,s.next=o}r.baseQueue=i=s,n.pending=null}if(i!==null){s=i.next,r=r.baseState;var a=o=null,u=null,c=s;do{var d=c.lane;if((zi&d)===d)u!==null&&(u=u.next={lane:0,action:c.action,hasEagerState:c.hasEagerState,eagerState:c.eagerState,next:null}),r=c.hasEagerState?c.eagerState:t(r,c.action);else{var f={lane:d,action:c.action,hasEagerState:c.hasEagerState,eagerState:c.eagerState,next:null};u===null?(a=u=f,o=r):u=u.next=f,We.lanes|=d,Bi|=d}c=c.next}while(c!==null&&c!==s);u===null?o=r:u.next=a,Vn(r,e.memoizedState)||(Qt=!0),e.memoizedState=r,e.baseState=o,e.baseQueue=u,n.lastRenderedState=r}if(t=n.interleaved,t!==null){i=t;do s=i.lane,We.lanes|=s,Bi|=s,i=i.next;while(i!==t)}else i===null&&(n.lanes=0);return[e.memoizedState,n.dispatch]}function Ed(t){var e=In(),n=e.queue;if(n===null)throw Error(z(311));n.lastRenderedReducer=t;var r=n.dispatch,i=n.pending,s=e.memoizedState;if(i!==null){n.pending=null;var o=i=i.next;do s=t(s,o.action),o=o.next;while(o!==i);Vn(s,e.memoizedState)||(Qt=!0),e.memoizedState=s,e.baseQueue===null&&(e.baseState=s),n.lastRenderedState=s}return[s,r]}function jE(){}function zE(t,e){var n=We,r=In(),i=e(),s=!Vn(r.memoizedState,i);if(s&&(r.memoizedState=i,Qt=!0),r=r.queue,pm(WE.bind(null,n,r,t),[t]),r.getSnapshot!==e||s||pt!==null&&pt.memoizedState.tag&1){if(n.flags|=2048,Ga(9,$E.bind(null,n,r,i,e),void 0,null),gt===null)throw Error(z(349));zi&30||BE(n,e,i)}return i}function BE(t,e,n){t.flags|=16384,t={getSnapshot:e,value:n},e=We.updateQueue,e===null?(e={lastEffect:null,stores:null},We.updateQueue=e,e.stores=[t]):(n=e.stores,n===null?e.stores=[t]:n.push(t))}function $E(t,e,n,r){e.value=n,e.getSnapshot=r,qE(e)&&HE(t)}function WE(t,e,n){return n(function(){qE(e)&&HE(t)})}function qE(t){var e=t.getSnapshot;t=t.value;try{var n=e();return!Vn(t,n)}catch{return!0}}function HE(t){var e=_r(t,1);e!==null&&Mn(e,t,1,-1)}function zy(t){var e=zn();return typeof t=="function"&&(t=t()),e.memoizedState=e.baseState=t,t={pending:null,interleaved:null,lanes:0,dispatch:null,lastRenderedReducer:Ha,lastRenderedState:t},e.queue=t,t=t.dispatch=dA.bind(null,We,t),[e.memoizedState,t]}function Ga(t,e,n,r){return t={tag:t,create:e,destroy:n,deps:r,next:null},e=We.updateQueue,e===null?(e={lastEffect:null,stores:null},We.updateQueue=e,e.lastEffect=t.next=t):(n=e.lastEffect,n===null?e.lastEffect=t.next=t:(r=n.next,n.next=t,t.next=r,e.lastEffect=t)),t}function GE(){return In().memoizedState}function bu(t,e,n,r){var i=zn();We.flags|=t,i.memoizedState=Ga(1|e,n,void 0,r===void 0?null:r)}function Jc(t,e,n,r){var i=In();r=r===void 0?null:r;var s=void 0;if(ot!==null){var o=ot.memoizedState;if(s=o.destroy,r!==null&&hm(r,o.deps)){i.memoizedState=Ga(e,n,s,r);return}}We.flags|=t,i.memoizedState=Ga(1|e,n,s,r)}function By(t,e){return bu(8390656,8,t,e)}function pm(t,e){return Jc(2048,8,t,e)}function KE(t,e){return Jc(4,2,t,e)}function QE(t,e){return Jc(4,4,t,e)}function YE(t,e){if(typeof e=="function")return t=t(),e(t),function(){e(null)};if(e!=null)return t=t(),e.current=t,function(){e.current=null}}function XE(t,e,n){return n=n!=null?n.concat([t]):null,Jc(4,4,YE.bind(null,e,t),n)}function mm(){}function JE(t,e){var n=In();e=e===void 0?null:e;var r=n.memoizedState;return r!==null&&e!==null&&hm(e,r[1])?r[0]:(n.memoizedState=[t,e],t)}function ZE(t,e){var n=In();e=e===void 0?null:e;var r=n.memoizedState;return r!==null&&e!==null&&hm(e,r[1])?r[0]:(t=t(),n.memoizedState=[t,e],t)}function eT(t,e,n){return zi&21?(Vn(n,e)||(n=sE(),We.lanes|=n,Bi|=n,t.baseState=!0),e):(t.baseState&&(t.baseState=!1,Qt=!0),t.memoizedState=n)}function cA(t,e){var n=Ie;Ie=n!==0&&4>n?n:4,t(!0);var r=vd.transition;vd.transition={};try{t(!1),e()}finally{Ie=n,vd.transition=r}}function tT(){return In().memoizedState}function hA(t,e,n){var r=Jr(t);if(n={lane:r,action:n,hasEagerState:!1,eagerState:null,next:null},nT(t))rT(e,n);else if(n=VE(t,e,n,r),n!==null){var i=Bt();Mn(n,t,r,i),iT(n,e,r)}}function dA(t,e,n){var r=Jr(t),i={lane:r,action:n,hasEagerState:!1,eagerState:null,next:null};if(nT(t))rT(e,i);else{var s=t.alternate;if(t.lanes===0&&(s===null||s.lanes===0)&&(s=e.lastRenderedReducer,s!==null))try{var o=e.lastRenderedState,a=s(o,n);if(i.hasEagerState=!0,i.eagerState=a,Vn(a,o)){var u=e.interleaved;u===null?(i.next=i,om(e)):(i.next=u.next,u.next=i),e.interleaved=i;return}}catch{}finally{}n=VE(t,e,i,r),n!==null&&(i=Bt(),Mn(n,t,r,i),iT(n,e,r))}}function nT(t){var e=t.alternate;return t===We||e!==null&&e===We}function rT(t,e){ma=uc=!0;var n=t.pending;n===null?e.next=e:(e.next=n.next,n.next=e),t.pending=e}function iT(t,e,n){if(n&4194240){var r=e.lanes;r&=t.pendingLanes,n|=r,e.lanes=n,Hp(t,n)}}var cc={readContext:Tn,useCallback:xt,useContext:xt,useEffect:xt,useImperativeHandle:xt,useInsertionEffect:xt,useLayoutEffect:xt,useMemo:xt,useReducer:xt,useRef:xt,useState:xt,useDebugValue:xt,useDeferredValue:xt,useTransition:xt,useMutableSource:xt,useSyncExternalStore:xt,useId:xt,unstable_isNewReconciler:!1},fA={readContext:Tn,useCallback:function(t,e){return zn().memoizedState=[t,e===void 0?null:e],t},useContext:Tn,useEffect:By,useImperativeHandle:function(t,e,n){return n=n!=null?n.concat([t]):null,bu(4194308,4,YE.bind(null,e,t),n)},useLayoutEffect:function(t,e){return bu(4194308,4,t,e)},useInsertionEffect:function(t,e){return bu(4,2,t,e)},useMemo:function(t,e){var n=zn();return e=e===void 0?null:e,t=t(),n.memoizedState=[t,e],t},useReducer:function(t,e,n){var r=zn();return e=n!==void 0?n(e):e,r.memoizedState=r.baseState=e,t={pending:null,interleaved:null,lanes:0,dispatch:null,lastRenderedReducer:t,lastRenderedState:e},r.queue=t,t=t.dispatch=hA.bind(null,We,t),[r.memoizedState,t]},useRef:function(t){var e=zn();return t={current:t},e.memoizedState=t},useState:zy,useDebugValue:mm,useDeferredValue:function(t){return zn().memoizedState=t},useTransition:function(){var t=zy(!1),e=t[0];return t=cA.bind(null,t[1]),zn().memoizedState=t,[e,t]},useMutableSource:function(){},useSyncExternalStore:function(t,e,n){var r=We,i=zn();if(Be){if(n===void 0)throw Error(z(407));n=n()}else{if(n=e(),gt===null)throw Error(z(349));zi&30||BE(r,e,n)}i.memoizedState=n;var s={value:n,getSnapshot:e};return i.queue=s,By(WE.bind(null,r,s,t),[t]),r.flags|=2048,Ga(9,$E.bind(null,r,s,n,e),void 0,null),n},useId:function(){var t=zn(),e=gt.identifierPrefix;if(Be){var n=or,r=sr;n=(r&~(1<<32-Dn(r)-1)).toString(32)+n,e=":"+e+"R"+n,n=qa++,0<n&&(e+="H"+n.toString(32)),e+=":"}else n=uA++,e=":"+e+"r"+n.toString(32)+":";return t.memoizedState=e},unstable_isNewReconciler:!1},pA={readContext:Tn,useCallback:JE,useContext:Tn,useEffect:pm,useImperativeHandle:XE,useInsertionEffect:KE,useLayoutEffect:QE,useMemo:ZE,useReducer:wd,useRef:GE,useState:function(){return wd(Ha)},useDebugValue:mm,useDeferredValue:function(t){var e=In();return eT(e,ot.memoizedState,t)},useTransition:function(){var t=wd(Ha)[0],e=In().memoizedState;return[t,e]},useMutableSource:jE,useSyncExternalStore:zE,useId:tT,unstable_isNewReconciler:!1},mA={readContext:Tn,useCallback:JE,useContext:Tn,useEffect:pm,useImperativeHandle:XE,useInsertionEffect:KE,useLayoutEffect:QE,useMemo:ZE,useReducer:Ed,useRef:GE,useState:function(){return Ed(Ha)},useDebugValue:mm,useDeferredValue:function(t){var e=In();return ot===null?e.memoizedState=t:eT(e,ot.memoizedState,t)},useTransition:function(){var t=Ed(Ha)[0],e=In().memoizedState;return[t,e]},useMutableSource:jE,useSyncExternalStore:zE,useId:tT,unstable_isNewReconciler:!1};function An(t,e){if(t&&t.defaultProps){e=qe({},e),t=t.defaultProps;for(var n in t)e[n]===void 0&&(e[n]=t[n]);return e}return e}function bf(t,e,n,r){e=t.memoizedState,n=n(r,e),n=n==null?e:qe({},e,n),t.memoizedState=n,t.lanes===0&&(t.updateQueue.baseState=n)}var Zc={isMounted:function(t){return(t=t._reactInternals)?es(t)===t:!1},enqueueSetState:function(t,e,n){t=t._reactInternals;var r=Bt(),i=Jr(t),s=dr(r,i);s.payload=e,n!=null&&(s.callback=n),e=Yr(t,s,i),e!==null&&(Mn(e,t,i,r),xu(e,t,i))},enqueueReplaceState:function(t,e,n){t=t._reactInternals;var r=Bt(),i=Jr(t),s=dr(r,i);s.tag=1,s.payload=e,n!=null&&(s.callback=n),e=Yr(t,s,i),e!==null&&(Mn(e,t,i,r),xu(e,t,i))},enqueueForceUpdate:function(t,e){t=t._reactInternals;var n=Bt(),r=Jr(t),i=dr(n,r);i.tag=2,e!=null&&(i.callback=e),e=Yr(t,i,r),e!==null&&(Mn(e,t,r,n),xu(e,t,r))}};function $y(t,e,n,r,i,s,o){return t=t.stateNode,typeof t.shouldComponentUpdate=="function"?t.shouldComponentUpdate(r,s,o):e.prototype&&e.prototype.isPureReactComponent?!Ua(n,r)||!Ua(i,s):!0}function sT(t,e,n){var r=!1,i=li,s=e.contextType;return typeof s=="object"&&s!==null?s=Tn(s):(i=Jt(e)?Ui:Vt.current,r=e.contextTypes,s=(r=r!=null)?Gs(t,i):li),e=new e(n,s),t.memoizedState=e.state!==null&&e.state!==void 0?e.state:null,e.updater=Zc,t.stateNode=e,e._reactInternals=t,r&&(t=t.stateNode,t.__reactInternalMemoizedUnmaskedChildContext=i,t.__reactInternalMemoizedMaskedChildContext=s),e}function Wy(t,e,n,r){t=e.state,typeof e.componentWillReceiveProps=="function"&&e.componentWillReceiveProps(n,r),typeof e.UNSAFE_componentWillReceiveProps=="function"&&e.UNSAFE_componentWillReceiveProps(n,r),e.state!==t&&Zc.enqueueReplaceState(e,e.state,null)}function Nf(t,e,n,r){var i=t.stateNode;i.props=n,i.state=t.memoizedState,i.refs={},am(t);var s=e.contextType;typeof s=="object"&&s!==null?i.context=Tn(s):(s=Jt(e)?Ui:Vt.current,i.context=Gs(t,s)),i.state=t.memoizedState,s=e.getDerivedStateFromProps,typeof s=="function"&&(bf(t,e,s,n),i.state=t.memoizedState),typeof e.getDerivedStateFromProps=="function"||typeof i.getSnapshotBeforeUpdate=="function"||typeof i.UNSAFE_componentWillMount!="function"&&typeof i.componentWillMount!="function"||(e=i.state,typeof i.componentWillMount=="function"&&i.componentWillMount(),typeof i.UNSAFE_componentWillMount=="function"&&i.UNSAFE_componentWillMount(),e!==i.state&&Zc.enqueueReplaceState(i,i.state,null),ac(t,n,i,r),i.state=t.memoizedState),typeof i.componentDidMount=="function"&&(t.flags|=4194308)}function Xs(t,e){try{var n="",r=e;do n+=$C(r),r=r.return;while(r);var i=n}catch(s){i=`
Error generating stack: `+s.message+`
`+s.stack}return{value:t,source:e,stack:i,digest:null}}function Td(t,e,n){return{value:t,source:null,stack:n??null,digest:e??null}}function Of(t,e){try{console.error(e.value)}catch(n){setTimeout(function(){throw n})}}var gA=typeof WeakMap=="function"?WeakMap:Map;function oT(t,e,n){n=dr(-1,n),n.tag=3,n.payload={element:null};var r=e.value;return n.callback=function(){dc||(dc=!0,$f=r),Of(t,e)},n}function aT(t,e,n){n=dr(-1,n),n.tag=3;var r=t.type.getDerivedStateFromError;if(typeof r=="function"){var i=e.value;n.payload=function(){return r(i)},n.callback=function(){Of(t,e)}}var s=t.stateNode;return s!==null&&typeof s.componentDidCatch=="function"&&(n.callback=function(){Of(t,e),typeof r!="function"&&(Xr===null?Xr=new Set([this]):Xr.add(this));var o=e.stack;this.componentDidCatch(e.value,{componentStack:o!==null?o:""})}),n}function qy(t,e,n){var r=t.pingCache;if(r===null){r=t.pingCache=new gA;var i=new Set;r.set(e,i)}else i=r.get(e),i===void 0&&(i=new Set,r.set(e,i));i.has(n)||(i.add(n),t=PA.bind(null,t,e,n),e.then(t,t))}function Hy(t){do{var e;if((e=t.tag===13)&&(e=t.memoizedState,e=e!==null?e.dehydrated!==null:!0),e)return t;t=t.return}while(t!==null);return null}function Gy(t,e,n,r,i){return t.mode&1?(t.flags|=65536,t.lanes=i,t):(t===e?t.flags|=65536:(t.flags|=128,n.flags|=131072,n.flags&=-52805,n.tag===1&&(n.alternate===null?n.tag=17:(e=dr(-1,1),e.tag=2,Yr(n,e,1))),n.lanes|=1),t)}var _A=Rr.ReactCurrentOwner,Qt=!1;function zt(t,e,n,r){e.child=t===null?LE(e,null,n,r):Qs(e,t.child,n,r)}function Ky(t,e,n,r,i){n=n.render;var s=e.ref;return Fs(e,i),r=dm(t,e,n,r,s,i),n=fm(),t!==null&&!Qt?(e.updateQueue=t.updateQueue,e.flags&=-2053,t.lanes&=~i,yr(t,e,i)):(Be&&n&&em(e),e.flags|=1,zt(t,e,r,i),e.child)}function Qy(t,e,n,r,i){if(t===null){var s=n.type;return typeof s=="function"&&!Im(s)&&s.defaultProps===void 0&&n.compare===null&&n.defaultProps===void 0?(e.tag=15,e.type=s,lT(t,e,s,r,i)):(t=Mu(n.type,null,r,e,e.mode,i),t.ref=e.ref,t.return=e,e.child=t)}if(s=t.child,!(t.lanes&i)){var o=s.memoizedProps;if(n=n.compare,n=n!==null?n:Ua,n(o,r)&&t.ref===e.ref)return yr(t,e,i)}return e.flags|=1,t=Zr(s,r),t.ref=e.ref,t.return=e,e.child=t}function lT(t,e,n,r,i){if(t!==null){var s=t.memoizedProps;if(Ua(s,r)&&t.ref===e.ref)if(Qt=!1,e.pendingProps=r=s,(t.lanes&i)!==0)t.flags&131072&&(Qt=!0);else return e.lanes=t.lanes,yr(t,e,i)}return Df(t,e,n,r,i)}function uT(t,e,n){var r=e.pendingProps,i=r.children,s=t!==null?t.memoizedState:null;if(r.mode==="hidden")if(!(e.mode&1))e.memoizedState={baseLanes:0,cachePool:null,transitions:null},Oe(bs,rn),rn|=n;else{if(!(n&1073741824))return t=s!==null?s.baseLanes|n:n,e.lanes=e.childLanes=1073741824,e.memoizedState={baseLanes:t,cachePool:null,transitions:null},e.updateQueue=null,Oe(bs,rn),rn|=t,null;e.memoizedState={baseLanes:0,cachePool:null,transitions:null},r=s!==null?s.baseLanes:n,Oe(bs,rn),rn|=r}else s!==null?(r=s.baseLanes|n,e.memoizedState=null):r=n,Oe(bs,rn),rn|=r;return zt(t,e,i,n),e.child}function cT(t,e){var n=e.ref;(t===null&&n!==null||t!==null&&t.ref!==n)&&(e.flags|=512,e.flags|=2097152)}function Df(t,e,n,r,i){var s=Jt(n)?Ui:Vt.current;return s=Gs(e,s),Fs(e,i),n=dm(t,e,n,r,s,i),r=fm(),t!==null&&!Qt?(e.updateQueue=t.updateQueue,e.flags&=-2053,t.lanes&=~i,yr(t,e,i)):(Be&&r&&em(e),e.flags|=1,zt(t,e,n,i),e.child)}function Yy(t,e,n,r,i){if(Jt(n)){var s=!0;nc(e)}else s=!1;if(Fs(e,i),e.stateNode===null)Nu(t,e),sT(e,n,r),Nf(e,n,r,i),r=!0;else if(t===null){var o=e.stateNode,a=e.memoizedProps;o.props=a;var u=o.context,c=n.contextType;typeof c=="object"&&c!==null?c=Tn(c):(c=Jt(n)?Ui:Vt.current,c=Gs(e,c));var d=n.getDerivedStateFromProps,f=typeof d=="function"||typeof o.getSnapshotBeforeUpdate=="function";f||typeof o.UNSAFE_componentWillReceiveProps!="function"&&typeof o.componentWillReceiveProps!="function"||(a!==r||u!==c)&&Wy(e,o,r,c),Mr=!1;var m=e.memoizedState;o.state=m,ac(e,r,o,i),u=e.memoizedState,a!==r||m!==u||Xt.current||Mr?(typeof d=="function"&&(bf(e,n,d,r),u=e.memoizedState),(a=Mr||$y(e,n,a,r,m,u,c))?(f||typeof o.UNSAFE_componentWillMount!="function"&&typeof o.componentWillMount!="function"||(typeof o.componentWillMount=="function"&&o.componentWillMount(),typeof o.UNSAFE_componentWillMount=="function"&&o.UNSAFE_componentWillMount()),typeof o.componentDidMount=="function"&&(e.flags|=4194308)):(typeof o.componentDidMount=="function"&&(e.flags|=4194308),e.memoizedProps=r,e.memoizedState=u),o.props=r,o.state=u,o.context=c,r=a):(typeof o.componentDidMount=="function"&&(e.flags|=4194308),r=!1)}else{o=e.stateNode,FE(t,e),a=e.memoizedProps,c=e.type===e.elementType?a:An(e.type,a),o.props=c,f=e.pendingProps,m=o.context,u=n.contextType,typeof u=="object"&&u!==null?u=Tn(u):(u=Jt(n)?Ui:Vt.current,u=Gs(e,u));var w=n.getDerivedStateFromProps;(d=typeof w=="function"||typeof o.getSnapshotBeforeUpdate=="function")||typeof o.UNSAFE_componentWillReceiveProps!="function"&&typeof o.componentWillReceiveProps!="function"||(a!==f||m!==u)&&Wy(e,o,r,u),Mr=!1,m=e.memoizedState,o.state=m,ac(e,r,o,i);var I=e.memoizedState;a!==f||m!==I||Xt.current||Mr?(typeof w=="function"&&(bf(e,n,w,r),I=e.memoizedState),(c=Mr||$y(e,n,c,r,m,I,u)||!1)?(d||typeof o.UNSAFE_componentWillUpdate!="function"&&typeof o.componentWillUpdate!="function"||(typeof o.componentWillUpdate=="function"&&o.componentWillUpdate(r,I,u),typeof o.UNSAFE_componentWillUpdate=="function"&&o.UNSAFE_componentWillUpdate(r,I,u)),typeof o.componentDidUpdate=="function"&&(e.flags|=4),typeof o.getSnapshotBeforeUpdate=="function"&&(e.flags|=1024)):(typeof o.componentDidUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=4),typeof o.getSnapshotBeforeUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=1024),e.memoizedProps=r,e.memoizedState=I),o.props=r,o.state=I,o.context=u,r=c):(typeof o.componentDidUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=4),typeof o.getSnapshotBeforeUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=1024),r=!1)}return Mf(t,e,n,r,s,i)}function Mf(t,e,n,r,i,s){cT(t,e);var o=(e.flags&128)!==0;if(!r&&!o)return i&&My(e,n,!1),yr(t,e,s);r=e.stateNode,_A.current=e;var a=o&&typeof n.getDerivedStateFromError!="function"?null:r.render();return e.flags|=1,t!==null&&o?(e.child=Qs(e,t.child,null,s),e.child=Qs(e,null,a,s)):zt(t,e,a,s),e.memoizedState=r.state,i&&My(e,n,!0),e.child}function hT(t){var e=t.stateNode;e.pendingContext?Dy(t,e.pendingContext,e.pendingContext!==e.context):e.context&&Dy(t,e.context,!1),lm(t,e.containerInfo)}function Xy(t,e,n,r,i){return Ks(),nm(i),e.flags|=256,zt(t,e,n,r),e.child}var Lf={dehydrated:null,treeContext:null,retryLane:0};function Vf(t){return{baseLanes:t,cachePool:null,transitions:null}}function dT(t,e,n){var r=e.pendingProps,i=$e.current,s=!1,o=(e.flags&128)!==0,a;if((a=o)||(a=t!==null&&t.memoizedState===null?!1:(i&2)!==0),a?(s=!0,e.flags&=-129):(t===null||t.memoizedState!==null)&&(i|=1),Oe($e,i&1),t===null)return xf(e),t=e.memoizedState,t!==null&&(t=t.dehydrated,t!==null)?(e.mode&1?t.data==="$!"?e.lanes=8:e.lanes=1073741824:e.lanes=1,null):(o=r.children,t=r.fallback,s?(r=e.mode,s=e.child,o={mode:"hidden",children:o},!(r&1)&&s!==null?(s.childLanes=0,s.pendingProps=o):s=nh(o,r,0,null),t=Li(t,r,n,null),s.return=e,t.return=e,s.sibling=t,e.child=s,e.child.memoizedState=Vf(n),e.memoizedState=Lf,t):gm(e,o));if(i=t.memoizedState,i!==null&&(a=i.dehydrated,a!==null))return yA(t,e,o,r,a,i,n);if(s){s=r.fallback,o=e.mode,i=t.child,a=i.sibling;var u={mode:"hidden",children:r.children};return!(o&1)&&e.child!==i?(r=e.child,r.childLanes=0,r.pendingProps=u,e.deletions=null):(r=Zr(i,u),r.subtreeFlags=i.subtreeFlags&14680064),a!==null?s=Zr(a,s):(s=Li(s,o,n,null),s.flags|=2),s.return=e,r.return=e,r.sibling=s,e.child=r,r=s,s=e.child,o=t.child.memoizedState,o=o===null?Vf(n):{baseLanes:o.baseLanes|n,cachePool:null,transitions:o.transitions},s.memoizedState=o,s.childLanes=t.childLanes&~n,e.memoizedState=Lf,r}return s=t.child,t=s.sibling,r=Zr(s,{mode:"visible",children:r.children}),!(e.mode&1)&&(r.lanes=n),r.return=e,r.sibling=null,t!==null&&(n=e.deletions,n===null?(e.deletions=[t],e.flags|=16):n.push(t)),e.child=r,e.memoizedState=null,r}function gm(t,e){return e=nh({mode:"visible",children:e},t.mode,0,null),e.return=t,t.child=e}function uu(t,e,n,r){return r!==null&&nm(r),Qs(e,t.child,null,n),t=gm(e,e.pendingProps.children),t.flags|=2,e.memoizedState=null,t}function yA(t,e,n,r,i,s,o){if(n)return e.flags&256?(e.flags&=-257,r=Td(Error(z(422))),uu(t,e,o,r)):e.memoizedState!==null?(e.child=t.child,e.flags|=128,null):(s=r.fallback,i=e.mode,r=nh({mode:"visible",children:r.children},i,0,null),s=Li(s,i,o,null),s.flags|=2,r.return=e,s.return=e,r.sibling=s,e.child=r,e.mode&1&&Qs(e,t.child,null,o),e.child.memoizedState=Vf(o),e.memoizedState=Lf,s);if(!(e.mode&1))return uu(t,e,o,null);if(i.data==="$!"){if(r=i.nextSibling&&i.nextSibling.dataset,r)var a=r.dgst;return r=a,s=Error(z(419)),r=Td(s,r,void 0),uu(t,e,o,r)}if(a=(o&t.childLanes)!==0,Qt||a){if(r=gt,r!==null){switch(o&-o){case 4:i=2;break;case 16:i=8;break;case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:i=32;break;case 536870912:i=268435456;break;default:i=0}i=i&(r.suspendedLanes|o)?0:i,i!==0&&i!==s.retryLane&&(s.retryLane=i,_r(t,i),Mn(r,t,i,-1))}return Tm(),r=Td(Error(z(421))),uu(t,e,o,r)}return i.data==="$?"?(e.flags|=128,e.child=t.child,e=bA.bind(null,t),i._reactRetry=e,null):(t=s.treeContext,on=Qr(i.nextSibling),ln=e,Be=!0,Pn=null,t!==null&&(dn[fn++]=sr,dn[fn++]=or,dn[fn++]=ji,sr=t.id,or=t.overflow,ji=e),e=gm(e,r.children),e.flags|=4096,e)}function Jy(t,e,n){t.lanes|=e;var r=t.alternate;r!==null&&(r.lanes|=e),Pf(t.return,e,n)}function Id(t,e,n,r,i){var s=t.memoizedState;s===null?t.memoizedState={isBackwards:e,rendering:null,renderingStartTime:0,last:r,tail:n,tailMode:i}:(s.isBackwards=e,s.rendering=null,s.renderingStartTime=0,s.last=r,s.tail=n,s.tailMode=i)}function fT(t,e,n){var r=e.pendingProps,i=r.revealOrder,s=r.tail;if(zt(t,e,r.children,n),r=$e.current,r&2)r=r&1|2,e.flags|=128;else{if(t!==null&&t.flags&128)e:for(t=e.child;t!==null;){if(t.tag===13)t.memoizedState!==null&&Jy(t,n,e);else if(t.tag===19)Jy(t,n,e);else if(t.child!==null){t.child.return=t,t=t.child;continue}if(t===e)break e;for(;t.sibling===null;){if(t.return===null||t.return===e)break e;t=t.return}t.sibling.return=t.return,t=t.sibling}r&=1}if(Oe($e,r),!(e.mode&1))e.memoizedState=null;else switch(i){case"forwards":for(n=e.child,i=null;n!==null;)t=n.alternate,t!==null&&lc(t)===null&&(i=n),n=n.sibling;n=i,n===null?(i=e.child,e.child=null):(i=n.sibling,n.sibling=null),Id(e,!1,i,n,s);break;case"backwards":for(n=null,i=e.child,e.child=null;i!==null;){if(t=i.alternate,t!==null&&lc(t)===null){e.child=i;break}t=i.sibling,i.sibling=n,n=i,i=t}Id(e,!0,n,null,s);break;case"together":Id(e,!1,null,null,void 0);break;default:e.memoizedState=null}return e.child}function Nu(t,e){!(e.mode&1)&&t!==null&&(t.alternate=null,e.alternate=null,e.flags|=2)}function yr(t,e,n){if(t!==null&&(e.dependencies=t.dependencies),Bi|=e.lanes,!(n&e.childLanes))return null;if(t!==null&&e.child!==t.child)throw Error(z(153));if(e.child!==null){for(t=e.child,n=Zr(t,t.pendingProps),e.child=n,n.return=e;t.sibling!==null;)t=t.sibling,n=n.sibling=Zr(t,t.pendingProps),n.return=e;n.sibling=null}return e.child}function vA(t,e,n){switch(e.tag){case 3:hT(e),Ks();break;case 5:UE(e);break;case 1:Jt(e.type)&&nc(e);break;case 4:lm(e,e.stateNode.containerInfo);break;case 10:var r=e.type._context,i=e.memoizedProps.value;Oe(sc,r._currentValue),r._currentValue=i;break;case 13:if(r=e.memoizedState,r!==null)return r.dehydrated!==null?(Oe($e,$e.current&1),e.flags|=128,null):n&e.child.childLanes?dT(t,e,n):(Oe($e,$e.current&1),t=yr(t,e,n),t!==null?t.sibling:null);Oe($e,$e.current&1);break;case 19:if(r=(n&e.childLanes)!==0,t.flags&128){if(r)return fT(t,e,n);e.flags|=128}if(i=e.memoizedState,i!==null&&(i.rendering=null,i.tail=null,i.lastEffect=null),Oe($e,$e.current),r)break;return null;case 22:case 23:return e.lanes=0,uT(t,e,n)}return yr(t,e,n)}var pT,Ff,mT,gT;pT=function(t,e){for(var n=e.child;n!==null;){if(n.tag===5||n.tag===6)t.appendChild(n.stateNode);else if(n.tag!==4&&n.child!==null){n.child.return=n,n=n.child;continue}if(n===e)break;for(;n.sibling===null;){if(n.return===null||n.return===e)return;n=n.return}n.sibling.return=n.return,n=n.sibling}};Ff=function(){};mT=function(t,e,n,r){var i=t.memoizedProps;if(i!==r){t=e.stateNode,bi(Hn.current);var s=null;switch(n){case"input":i=of(t,i),r=of(t,r),s=[];break;case"select":i=qe({},i,{value:void 0}),r=qe({},r,{value:void 0}),s=[];break;case"textarea":i=uf(t,i),r=uf(t,r),s=[];break;default:typeof i.onClick!="function"&&typeof r.onClick=="function"&&(t.onclick=ec)}hf(n,r);var o;n=null;for(c in i)if(!r.hasOwnProperty(c)&&i.hasOwnProperty(c)&&i[c]!=null)if(c==="style"){var a=i[c];for(o in a)a.hasOwnProperty(o)&&(n||(n={}),n[o]="")}else c!=="dangerouslySetInnerHTML"&&c!=="children"&&c!=="suppressContentEditableWarning"&&c!=="suppressHydrationWarning"&&c!=="autoFocus"&&(Na.hasOwnProperty(c)?s||(s=[]):(s=s||[]).push(c,null));for(c in r){var u=r[c];if(a=i!=null?i[c]:void 0,r.hasOwnProperty(c)&&u!==a&&(u!=null||a!=null))if(c==="style")if(a){for(o in a)!a.hasOwnProperty(o)||u&&u.hasOwnProperty(o)||(n||(n={}),n[o]="");for(o in u)u.hasOwnProperty(o)&&a[o]!==u[o]&&(n||(n={}),n[o]=u[o])}else n||(s||(s=[]),s.push(c,n)),n=u;else c==="dangerouslySetInnerHTML"?(u=u?u.__html:void 0,a=a?a.__html:void 0,u!=null&&a!==u&&(s=s||[]).push(c,u)):c==="children"?typeof u!="string"&&typeof u!="number"||(s=s||[]).push(c,""+u):c!=="suppressContentEditableWarning"&&c!=="suppressHydrationWarning"&&(Na.hasOwnProperty(c)?(u!=null&&c==="onScroll"&&Me("scroll",t),s||a===u||(s=[])):(s=s||[]).push(c,u))}n&&(s=s||[]).push("style",n);var c=s;(e.updateQueue=c)&&(e.flags|=4)}};gT=function(t,e,n,r){n!==r&&(e.flags|=4)};function Go(t,e){if(!Be)switch(t.tailMode){case"hidden":e=t.tail;for(var n=null;e!==null;)e.alternate!==null&&(n=e),e=e.sibling;n===null?t.tail=null:n.sibling=null;break;case"collapsed":n=t.tail;for(var r=null;n!==null;)n.alternate!==null&&(r=n),n=n.sibling;r===null?e||t.tail===null?t.tail=null:t.tail.sibling=null:r.sibling=null}}function Pt(t){var e=t.alternate!==null&&t.alternate.child===t.child,n=0,r=0;if(e)for(var i=t.child;i!==null;)n|=i.lanes|i.childLanes,r|=i.subtreeFlags&14680064,r|=i.flags&14680064,i.return=t,i=i.sibling;else for(i=t.child;i!==null;)n|=i.lanes|i.childLanes,r|=i.subtreeFlags,r|=i.flags,i.return=t,i=i.sibling;return t.subtreeFlags|=r,t.childLanes=n,e}function wA(t,e,n){var r=e.pendingProps;switch(tm(e),e.tag){case 2:case 16:case 15:case 0:case 11:case 7:case 8:case 12:case 9:case 14:return Pt(e),null;case 1:return Jt(e.type)&&tc(),Pt(e),null;case 3:return r=e.stateNode,Ys(),Ue(Xt),Ue(Vt),cm(),r.pendingContext&&(r.context=r.pendingContext,r.pendingContext=null),(t===null||t.child===null)&&(au(e)?e.flags|=4:t===null||t.memoizedState.isDehydrated&&!(e.flags&256)||(e.flags|=1024,Pn!==null&&(Hf(Pn),Pn=null))),Ff(t,e),Pt(e),null;case 5:um(e);var i=bi(Wa.current);if(n=e.type,t!==null&&e.stateNode!=null)mT(t,e,n,r,i),t.ref!==e.ref&&(e.flags|=512,e.flags|=2097152);else{if(!r){if(e.stateNode===null)throw Error(z(166));return Pt(e),null}if(t=bi(Hn.current),au(e)){r=e.stateNode,n=e.type;var s=e.memoizedProps;switch(r[Bn]=e,r[Ba]=s,t=(e.mode&1)!==0,n){case"dialog":Me("cancel",r),Me("close",r);break;case"iframe":case"object":case"embed":Me("load",r);break;case"video":case"audio":for(i=0;i<oa.length;i++)Me(oa[i],r);break;case"source":Me("error",r);break;case"img":case"image":case"link":Me("error",r),Me("load",r);break;case"details":Me("toggle",r);break;case"input":ay(r,s),Me("invalid",r);break;case"select":r._wrapperState={wasMultiple:!!s.multiple},Me("invalid",r);break;case"textarea":uy(r,s),Me("invalid",r)}hf(n,s),i=null;for(var o in s)if(s.hasOwnProperty(o)){var a=s[o];o==="children"?typeof a=="string"?r.textContent!==a&&(s.suppressHydrationWarning!==!0&&ou(r.textContent,a,t),i=["children",a]):typeof a=="number"&&r.textContent!==""+a&&(s.suppressHydrationWarning!==!0&&ou(r.textContent,a,t),i=["children",""+a]):Na.hasOwnProperty(o)&&a!=null&&o==="onScroll"&&Me("scroll",r)}switch(n){case"input":Jl(r),ly(r,s,!0);break;case"textarea":Jl(r),cy(r);break;case"select":case"option":break;default:typeof s.onClick=="function"&&(r.onclick=ec)}r=i,e.updateQueue=r,r!==null&&(e.flags|=4)}else{o=i.nodeType===9?i:i.ownerDocument,t==="http://www.w3.org/1999/xhtml"&&(t=W0(n)),t==="http://www.w3.org/1999/xhtml"?n==="script"?(t=o.createElement("div"),t.innerHTML="<script><\/script>",t=t.removeChild(t.firstChild)):typeof r.is=="string"?t=o.createElement(n,{is:r.is}):(t=o.createElement(n),n==="select"&&(o=t,r.multiple?o.multiple=!0:r.size&&(o.size=r.size))):t=o.createElementNS(t,n),t[Bn]=e,t[Ba]=r,pT(t,e,!1,!1),e.stateNode=t;e:{switch(o=df(n,r),n){case"dialog":Me("cancel",t),Me("close",t),i=r;break;case"iframe":case"object":case"embed":Me("load",t),i=r;break;case"video":case"audio":for(i=0;i<oa.length;i++)Me(oa[i],t);i=r;break;case"source":Me("error",t),i=r;break;case"img":case"image":case"link":Me("error",t),Me("load",t),i=r;break;case"details":Me("toggle",t),i=r;break;case"input":ay(t,r),i=of(t,r),Me("invalid",t);break;case"option":i=r;break;case"select":t._wrapperState={wasMultiple:!!r.multiple},i=qe({},r,{value:void 0}),Me("invalid",t);break;case"textarea":uy(t,r),i=uf(t,r),Me("invalid",t);break;default:i=r}hf(n,i),a=i;for(s in a)if(a.hasOwnProperty(s)){var u=a[s];s==="style"?G0(t,u):s==="dangerouslySetInnerHTML"?(u=u?u.__html:void 0,u!=null&&q0(t,u)):s==="children"?typeof u=="string"?(n!=="textarea"||u!=="")&&Oa(t,u):typeof u=="number"&&Oa(t,""+u):s!=="suppressContentEditableWarning"&&s!=="suppressHydrationWarning"&&s!=="autoFocus"&&(Na.hasOwnProperty(s)?u!=null&&s==="onScroll"&&Me("scroll",t):u!=null&&jp(t,s,u,o))}switch(n){case"input":Jl(t),ly(t,r,!1);break;case"textarea":Jl(t),cy(t);break;case"option":r.value!=null&&t.setAttribute("value",""+ai(r.value));break;case"select":t.multiple=!!r.multiple,s=r.value,s!=null?Ds(t,!!r.multiple,s,!1):r.defaultValue!=null&&Ds(t,!!r.multiple,r.defaultValue,!0);break;default:typeof i.onClick=="function"&&(t.onclick=ec)}switch(n){case"button":case"input":case"select":case"textarea":r=!!r.autoFocus;break e;case"img":r=!0;break e;default:r=!1}}r&&(e.flags|=4)}e.ref!==null&&(e.flags|=512,e.flags|=2097152)}return Pt(e),null;case 6:if(t&&e.stateNode!=null)gT(t,e,t.memoizedProps,r);else{if(typeof r!="string"&&e.stateNode===null)throw Error(z(166));if(n=bi(Wa.current),bi(Hn.current),au(e)){if(r=e.stateNode,n=e.memoizedProps,r[Bn]=e,(s=r.nodeValue!==n)&&(t=ln,t!==null))switch(t.tag){case 3:ou(r.nodeValue,n,(t.mode&1)!==0);break;case 5:t.memoizedProps.suppressHydrationWarning!==!0&&ou(r.nodeValue,n,(t.mode&1)!==0)}s&&(e.flags|=4)}else r=(n.nodeType===9?n:n.ownerDocument).createTextNode(r),r[Bn]=e,e.stateNode=r}return Pt(e),null;case 13:if(Ue($e),r=e.memoizedState,t===null||t.memoizedState!==null&&t.memoizedState.dehydrated!==null){if(Be&&on!==null&&e.mode&1&&!(e.flags&128))DE(),Ks(),e.flags|=98560,s=!1;else if(s=au(e),r!==null&&r.dehydrated!==null){if(t===null){if(!s)throw Error(z(318));if(s=e.memoizedState,s=s!==null?s.dehydrated:null,!s)throw Error(z(317));s[Bn]=e}else Ks(),!(e.flags&128)&&(e.memoizedState=null),e.flags|=4;Pt(e),s=!1}else Pn!==null&&(Hf(Pn),Pn=null),s=!0;if(!s)return e.flags&65536?e:null}return e.flags&128?(e.lanes=n,e):(r=r!==null,r!==(t!==null&&t.memoizedState!==null)&&r&&(e.child.flags|=8192,e.mode&1&&(t===null||$e.current&1?lt===0&&(lt=3):Tm())),e.updateQueue!==null&&(e.flags|=4),Pt(e),null);case 4:return Ys(),Ff(t,e),t===null&&ja(e.stateNode.containerInfo),Pt(e),null;case 10:return sm(e.type._context),Pt(e),null;case 17:return Jt(e.type)&&tc(),Pt(e),null;case 19:if(Ue($e),s=e.memoizedState,s===null)return Pt(e),null;if(r=(e.flags&128)!==0,o=s.rendering,o===null)if(r)Go(s,!1);else{if(lt!==0||t!==null&&t.flags&128)for(t=e.child;t!==null;){if(o=lc(t),o!==null){for(e.flags|=128,Go(s,!1),r=o.updateQueue,r!==null&&(e.updateQueue=r,e.flags|=4),e.subtreeFlags=0,r=n,n=e.child;n!==null;)s=n,t=r,s.flags&=14680066,o=s.alternate,o===null?(s.childLanes=0,s.lanes=t,s.child=null,s.subtreeFlags=0,s.memoizedProps=null,s.memoizedState=null,s.updateQueue=null,s.dependencies=null,s.stateNode=null):(s.childLanes=o.childLanes,s.lanes=o.lanes,s.child=o.child,s.subtreeFlags=0,s.deletions=null,s.memoizedProps=o.memoizedProps,s.memoizedState=o.memoizedState,s.updateQueue=o.updateQueue,s.type=o.type,t=o.dependencies,s.dependencies=t===null?null:{lanes:t.lanes,firstContext:t.firstContext}),n=n.sibling;return Oe($e,$e.current&1|2),e.child}t=t.sibling}s.tail!==null&&Ze()>Js&&(e.flags|=128,r=!0,Go(s,!1),e.lanes=4194304)}else{if(!r)if(t=lc(o),t!==null){if(e.flags|=128,r=!0,n=t.updateQueue,n!==null&&(e.updateQueue=n,e.flags|=4),Go(s,!0),s.tail===null&&s.tailMode==="hidden"&&!o.alternate&&!Be)return Pt(e),null}else 2*Ze()-s.renderingStartTime>Js&&n!==1073741824&&(e.flags|=128,r=!0,Go(s,!1),e.lanes=4194304);s.isBackwards?(o.sibling=e.child,e.child=o):(n=s.last,n!==null?n.sibling=o:e.child=o,s.last=o)}return s.tail!==null?(e=s.tail,s.rendering=e,s.tail=e.sibling,s.renderingStartTime=Ze(),e.sibling=null,n=$e.current,Oe($e,r?n&1|2:n&1),e):(Pt(e),null);case 22:case 23:return Em(),r=e.memoizedState!==null,t!==null&&t.memoizedState!==null!==r&&(e.flags|=8192),r&&e.mode&1?rn&1073741824&&(Pt(e),e.subtreeFlags&6&&(e.flags|=8192)):Pt(e),null;case 24:return null;case 25:return null}throw Error(z(156,e.tag))}function EA(t,e){switch(tm(e),e.tag){case 1:return Jt(e.type)&&tc(),t=e.flags,t&65536?(e.flags=t&-65537|128,e):null;case 3:return Ys(),Ue(Xt),Ue(Vt),cm(),t=e.flags,t&65536&&!(t&128)?(e.flags=t&-65537|128,e):null;case 5:return um(e),null;case 13:if(Ue($e),t=e.memoizedState,t!==null&&t.dehydrated!==null){if(e.alternate===null)throw Error(z(340));Ks()}return t=e.flags,t&65536?(e.flags=t&-65537|128,e):null;case 19:return Ue($e),null;case 4:return Ys(),null;case 10:return sm(e.type._context),null;case 22:case 23:return Em(),null;case 24:return null;default:return null}}var cu=!1,Ot=!1,TA=typeof WeakSet=="function"?WeakSet:Set,G=null;function Ps(t,e){var n=t.ref;if(n!==null)if(typeof n=="function")try{n(null)}catch(r){Ke(t,e,r)}else n.current=null}function Uf(t,e,n){try{n()}catch(r){Ke(t,e,r)}}var Zy=!1;function IA(t,e){if(Tf=Xu,t=EE(),Zp(t)){if("selectionStart"in t)var n={start:t.selectionStart,end:t.selectionEnd};else e:{n=(n=t.ownerDocument)&&n.defaultView||window;var r=n.getSelection&&n.getSelection();if(r&&r.rangeCount!==0){n=r.anchorNode;var i=r.anchorOffset,s=r.focusNode;r=r.focusOffset;try{n.nodeType,s.nodeType}catch{n=null;break e}var o=0,a=-1,u=-1,c=0,d=0,f=t,m=null;t:for(;;){for(var w;f!==n||i!==0&&f.nodeType!==3||(a=o+i),f!==s||r!==0&&f.nodeType!==3||(u=o+r),f.nodeType===3&&(o+=f.nodeValue.length),(w=f.firstChild)!==null;)m=f,f=w;for(;;){if(f===t)break t;if(m===n&&++c===i&&(a=o),m===s&&++d===r&&(u=o),(w=f.nextSibling)!==null)break;f=m,m=f.parentNode}f=w}n=a===-1||u===-1?null:{start:a,end:u}}else n=null}n=n||{start:0,end:0}}else n=null;for(If={focusedElem:t,selectionRange:n},Xu=!1,G=e;G!==null;)if(e=G,t=e.child,(e.subtreeFlags&1028)!==0&&t!==null)t.return=e,G=t;else for(;G!==null;){e=G;try{var I=e.alternate;if(e.flags&1024)switch(e.tag){case 0:case 11:case 15:break;case 1:if(I!==null){var P=I.memoizedProps,O=I.memoizedState,C=e.stateNode,T=C.getSnapshotBeforeUpdate(e.elementType===e.type?P:An(e.type,P),O);C.__reactInternalSnapshotBeforeUpdate=T}break;case 3:var S=e.stateNode.containerInfo;S.nodeType===1?S.textContent="":S.nodeType===9&&S.documentElement&&S.removeChild(S.documentElement);break;case 5:case 6:case 4:case 17:break;default:throw Error(z(163))}}catch(M){Ke(e,e.return,M)}if(t=e.sibling,t!==null){t.return=e.return,G=t;break}G=e.return}return I=Zy,Zy=!1,I}function ga(t,e,n){var r=e.updateQueue;if(r=r!==null?r.lastEffect:null,r!==null){var i=r=r.next;do{if((i.tag&t)===t){var s=i.destroy;i.destroy=void 0,s!==void 0&&Uf(e,n,s)}i=i.next}while(i!==r)}}function eh(t,e){if(e=e.updateQueue,e=e!==null?e.lastEffect:null,e!==null){var n=e=e.next;do{if((n.tag&t)===t){var r=n.create;n.destroy=r()}n=n.next}while(n!==e)}}function jf(t){var e=t.ref;if(e!==null){var n=t.stateNode;switch(t.tag){case 5:t=n;break;default:t=n}typeof e=="function"?e(t):e.current=t}}function _T(t){var e=t.alternate;e!==null&&(t.alternate=null,_T(e)),t.child=null,t.deletions=null,t.sibling=null,t.tag===5&&(e=t.stateNode,e!==null&&(delete e[Bn],delete e[Ba],delete e[Cf],delete e[sA],delete e[oA])),t.stateNode=null,t.return=null,t.dependencies=null,t.memoizedProps=null,t.memoizedState=null,t.pendingProps=null,t.stateNode=null,t.updateQueue=null}function yT(t){return t.tag===5||t.tag===3||t.tag===4}function ev(t){e:for(;;){for(;t.sibling===null;){if(t.return===null||yT(t.return))return null;t=t.return}for(t.sibling.return=t.return,t=t.sibling;t.tag!==5&&t.tag!==6&&t.tag!==18;){if(t.flags&2||t.child===null||t.tag===4)continue e;t.child.return=t,t=t.child}if(!(t.flags&2))return t.stateNode}}function zf(t,e,n){var r=t.tag;if(r===5||r===6)t=t.stateNode,e?n.nodeType===8?n.parentNode.insertBefore(t,e):n.insertBefore(t,e):(n.nodeType===8?(e=n.parentNode,e.insertBefore(t,n)):(e=n,e.appendChild(t)),n=n._reactRootContainer,n!=null||e.onclick!==null||(e.onclick=ec));else if(r!==4&&(t=t.child,t!==null))for(zf(t,e,n),t=t.sibling;t!==null;)zf(t,e,n),t=t.sibling}function Bf(t,e,n){var r=t.tag;if(r===5||r===6)t=t.stateNode,e?n.insertBefore(t,e):n.appendChild(t);else if(r!==4&&(t=t.child,t!==null))for(Bf(t,e,n),t=t.sibling;t!==null;)Bf(t,e,n),t=t.sibling}var vt=null,xn=!1;function Nr(t,e,n){for(n=n.child;n!==null;)vT(t,e,n),n=n.sibling}function vT(t,e,n){if(qn&&typeof qn.onCommitFiberUnmount=="function")try{qn.onCommitFiberUnmount(Hc,n)}catch{}switch(n.tag){case 5:Ot||Ps(n,e);case 6:var r=vt,i=xn;vt=null,Nr(t,e,n),vt=r,xn=i,vt!==null&&(xn?(t=vt,n=n.stateNode,t.nodeType===8?t.parentNode.removeChild(n):t.removeChild(n)):vt.removeChild(n.stateNode));break;case 18:vt!==null&&(xn?(t=vt,n=n.stateNode,t.nodeType===8?gd(t.parentNode,n):t.nodeType===1&&gd(t,n),Va(t)):gd(vt,n.stateNode));break;case 4:r=vt,i=xn,vt=n.stateNode.containerInfo,xn=!0,Nr(t,e,n),vt=r,xn=i;break;case 0:case 11:case 14:case 15:if(!Ot&&(r=n.updateQueue,r!==null&&(r=r.lastEffect,r!==null))){i=r=r.next;do{var s=i,o=s.destroy;s=s.tag,o!==void 0&&(s&2||s&4)&&Uf(n,e,o),i=i.next}while(i!==r)}Nr(t,e,n);break;case 1:if(!Ot&&(Ps(n,e),r=n.stateNode,typeof r.componentWillUnmount=="function"))try{r.props=n.memoizedProps,r.state=n.memoizedState,r.componentWillUnmount()}catch(a){Ke(n,e,a)}Nr(t,e,n);break;case 21:Nr(t,e,n);break;case 22:n.mode&1?(Ot=(r=Ot)||n.memoizedState!==null,Nr(t,e,n),Ot=r):Nr(t,e,n);break;default:Nr(t,e,n)}}function tv(t){var e=t.updateQueue;if(e!==null){t.updateQueue=null;var n=t.stateNode;n===null&&(n=t.stateNode=new TA),e.forEach(function(r){var i=NA.bind(null,t,r);n.has(r)||(n.add(r),r.then(i,i))})}}function Rn(t,e){var n=e.deletions;if(n!==null)for(var r=0;r<n.length;r++){var i=n[r];try{var s=t,o=e,a=o;e:for(;a!==null;){switch(a.tag){case 5:vt=a.stateNode,xn=!1;break e;case 3:vt=a.stateNode.containerInfo,xn=!0;break e;case 4:vt=a.stateNode.containerInfo,xn=!0;break e}a=a.return}if(vt===null)throw Error(z(160));vT(s,o,i),vt=null,xn=!1;var u=i.alternate;u!==null&&(u.return=null),i.return=null}catch(c){Ke(i,e,c)}}if(e.subtreeFlags&12854)for(e=e.child;e!==null;)wT(e,t),e=e.sibling}function wT(t,e){var n=t.alternate,r=t.flags;switch(t.tag){case 0:case 11:case 14:case 15:if(Rn(e,t),jn(t),r&4){try{ga(3,t,t.return),eh(3,t)}catch(P){Ke(t,t.return,P)}try{ga(5,t,t.return)}catch(P){Ke(t,t.return,P)}}break;case 1:Rn(e,t),jn(t),r&512&&n!==null&&Ps(n,n.return);break;case 5:if(Rn(e,t),jn(t),r&512&&n!==null&&Ps(n,n.return),t.flags&32){var i=t.stateNode;try{Oa(i,"")}catch(P){Ke(t,t.return,P)}}if(r&4&&(i=t.stateNode,i!=null)){var s=t.memoizedProps,o=n!==null?n.memoizedProps:s,a=t.type,u=t.updateQueue;if(t.updateQueue=null,u!==null)try{a==="input"&&s.type==="radio"&&s.name!=null&&B0(i,s),df(a,o);var c=df(a,s);for(o=0;o<u.length;o+=2){var d=u[o],f=u[o+1];d==="style"?G0(i,f):d==="dangerouslySetInnerHTML"?q0(i,f):d==="children"?Oa(i,f):jp(i,d,f,c)}switch(a){case"input":af(i,s);break;case"textarea":$0(i,s);break;case"select":var m=i._wrapperState.wasMultiple;i._wrapperState.wasMultiple=!!s.multiple;var w=s.value;w!=null?Ds(i,!!s.multiple,w,!1):m!==!!s.multiple&&(s.defaultValue!=null?Ds(i,!!s.multiple,s.defaultValue,!0):Ds(i,!!s.multiple,s.multiple?[]:"",!1))}i[Ba]=s}catch(P){Ke(t,t.return,P)}}break;case 6:if(Rn(e,t),jn(t),r&4){if(t.stateNode===null)throw Error(z(162));i=t.stateNode,s=t.memoizedProps;try{i.nodeValue=s}catch(P){Ke(t,t.return,P)}}break;case 3:if(Rn(e,t),jn(t),r&4&&n!==null&&n.memoizedState.isDehydrated)try{Va(e.containerInfo)}catch(P){Ke(t,t.return,P)}break;case 4:Rn(e,t),jn(t);break;case 13:Rn(e,t),jn(t),i=t.child,i.flags&8192&&(s=i.memoizedState!==null,i.stateNode.isHidden=s,!s||i.alternate!==null&&i.alternate.memoizedState!==null||(vm=Ze())),r&4&&tv(t);break;case 22:if(d=n!==null&&n.memoizedState!==null,t.mode&1?(Ot=(c=Ot)||d,Rn(e,t),Ot=c):Rn(e,t),jn(t),r&8192){if(c=t.memoizedState!==null,(t.stateNode.isHidden=c)&&!d&&t.mode&1)for(G=t,d=t.child;d!==null;){for(f=G=d;G!==null;){switch(m=G,w=m.child,m.tag){case 0:case 11:case 14:case 15:ga(4,m,m.return);break;case 1:Ps(m,m.return);var I=m.stateNode;if(typeof I.componentWillUnmount=="function"){r=m,n=m.return;try{e=r,I.props=e.memoizedProps,I.state=e.memoizedState,I.componentWillUnmount()}catch(P){Ke(r,n,P)}}break;case 5:Ps(m,m.return);break;case 22:if(m.memoizedState!==null){rv(f);continue}}w!==null?(w.return=m,G=w):rv(f)}d=d.sibling}e:for(d=null,f=t;;){if(f.tag===5){if(d===null){d=f;try{i=f.stateNode,c?(s=i.style,typeof s.setProperty=="function"?s.setProperty("display","none","important"):s.display="none"):(a=f.stateNode,u=f.memoizedProps.style,o=u!=null&&u.hasOwnProperty("display")?u.display:null,a.style.display=H0("display",o))}catch(P){Ke(t,t.return,P)}}}else if(f.tag===6){if(d===null)try{f.stateNode.nodeValue=c?"":f.memoizedProps}catch(P){Ke(t,t.return,P)}}else if((f.tag!==22&&f.tag!==23||f.memoizedState===null||f===t)&&f.child!==null){f.child.return=f,f=f.child;continue}if(f===t)break e;for(;f.sibling===null;){if(f.return===null||f.return===t)break e;d===f&&(d=null),f=f.return}d===f&&(d=null),f.sibling.return=f.return,f=f.sibling}}break;case 19:Rn(e,t),jn(t),r&4&&tv(t);break;case 21:break;default:Rn(e,t),jn(t)}}function jn(t){var e=t.flags;if(e&2){try{e:{for(var n=t.return;n!==null;){if(yT(n)){var r=n;break e}n=n.return}throw Error(z(160))}switch(r.tag){case 5:var i=r.stateNode;r.flags&32&&(Oa(i,""),r.flags&=-33);var s=ev(t);Bf(t,s,i);break;case 3:case 4:var o=r.stateNode.containerInfo,a=ev(t);zf(t,a,o);break;default:throw Error(z(161))}}catch(u){Ke(t,t.return,u)}t.flags&=-3}e&4096&&(t.flags&=-4097)}function SA(t,e,n){G=t,ET(t)}function ET(t,e,n){for(var r=(t.mode&1)!==0;G!==null;){var i=G,s=i.child;if(i.tag===22&&r){var o=i.memoizedState!==null||cu;if(!o){var a=i.alternate,u=a!==null&&a.memoizedState!==null||Ot;a=cu;var c=Ot;if(cu=o,(Ot=u)&&!c)for(G=i;G!==null;)o=G,u=o.child,o.tag===22&&o.memoizedState!==null?iv(i):u!==null?(u.return=o,G=u):iv(i);for(;s!==null;)G=s,ET(s),s=s.sibling;G=i,cu=a,Ot=c}nv(t)}else i.subtreeFlags&8772&&s!==null?(s.return=i,G=s):nv(t)}}function nv(t){for(;G!==null;){var e=G;if(e.flags&8772){var n=e.alternate;try{if(e.flags&8772)switch(e.tag){case 0:case 11:case 15:Ot||eh(5,e);break;case 1:var r=e.stateNode;if(e.flags&4&&!Ot)if(n===null)r.componentDidMount();else{var i=e.elementType===e.type?n.memoizedProps:An(e.type,n.memoizedProps);r.componentDidUpdate(i,n.memoizedState,r.__reactInternalSnapshotBeforeUpdate)}var s=e.updateQueue;s!==null&&jy(e,s,r);break;case 3:var o=e.updateQueue;if(o!==null){if(n=null,e.child!==null)switch(e.child.tag){case 5:n=e.child.stateNode;break;case 1:n=e.child.stateNode}jy(e,o,n)}break;case 5:var a=e.stateNode;if(n===null&&e.flags&4){n=a;var u=e.memoizedProps;switch(e.type){case"button":case"input":case"select":case"textarea":u.autoFocus&&n.focus();break;case"img":u.src&&(n.src=u.src)}}break;case 6:break;case 4:break;case 12:break;case 13:if(e.memoizedState===null){var c=e.alternate;if(c!==null){var d=c.memoizedState;if(d!==null){var f=d.dehydrated;f!==null&&Va(f)}}}break;case 19:case 17:case 21:case 22:case 23:case 25:break;default:throw Error(z(163))}Ot||e.flags&512&&jf(e)}catch(m){Ke(e,e.return,m)}}if(e===t){G=null;break}if(n=e.sibling,n!==null){n.return=e.return,G=n;break}G=e.return}}function rv(t){for(;G!==null;){var e=G;if(e===t){G=null;break}var n=e.sibling;if(n!==null){n.return=e.return,G=n;break}G=e.return}}function iv(t){for(;G!==null;){var e=G;try{switch(e.tag){case 0:case 11:case 15:var n=e.return;try{eh(4,e)}catch(u){Ke(e,n,u)}break;case 1:var r=e.stateNode;if(typeof r.componentDidMount=="function"){var i=e.return;try{r.componentDidMount()}catch(u){Ke(e,i,u)}}var s=e.return;try{jf(e)}catch(u){Ke(e,s,u)}break;case 5:var o=e.return;try{jf(e)}catch(u){Ke(e,o,u)}}}catch(u){Ke(e,e.return,u)}if(e===t){G=null;break}var a=e.sibling;if(a!==null){a.return=e.return,G=a;break}G=e.return}}var kA=Math.ceil,hc=Rr.ReactCurrentDispatcher,_m=Rr.ReactCurrentOwner,vn=Rr.ReactCurrentBatchConfig,ge=0,gt=null,nt=null,It=0,rn=0,bs=gi(0),lt=0,Ka=null,Bi=0,th=0,ym=0,_a=null,Kt=null,vm=0,Js=1/0,rr=null,dc=!1,$f=null,Xr=null,hu=!1,Wr=null,fc=0,ya=0,Wf=null,Ou=-1,Du=0;function Bt(){return ge&6?Ze():Ou!==-1?Ou:Ou=Ze()}function Jr(t){return t.mode&1?ge&2&&It!==0?It&-It:lA.transition!==null?(Du===0&&(Du=sE()),Du):(t=Ie,t!==0||(t=window.event,t=t===void 0?16:dE(t.type)),t):1}function Mn(t,e,n,r){if(50<ya)throw ya=0,Wf=null,Error(z(185));cl(t,n,r),(!(ge&2)||t!==gt)&&(t===gt&&(!(ge&2)&&(th|=n),lt===4&&Vr(t,It)),Zt(t,r),n===1&&ge===0&&!(e.mode&1)&&(Js=Ze()+500,Xc&&_i()))}function Zt(t,e){var n=t.callbackNode;lR(t,e);var r=Yu(t,t===gt?It:0);if(r===0)n!==null&&fy(n),t.callbackNode=null,t.callbackPriority=0;else if(e=r&-r,t.callbackPriority!==e){if(n!=null&&fy(n),e===1)t.tag===0?aA(sv.bind(null,t)):bE(sv.bind(null,t)),rA(function(){!(ge&6)&&_i()}),n=null;else{switch(oE(r)){case 1:n=qp;break;case 4:n=rE;break;case 16:n=Qu;break;case 536870912:n=iE;break;default:n=Qu}n=xT(n,TT.bind(null,t))}t.callbackPriority=e,t.callbackNode=n}}function TT(t,e){if(Ou=-1,Du=0,ge&6)throw Error(z(327));var n=t.callbackNode;if(Us()&&t.callbackNode!==n)return null;var r=Yu(t,t===gt?It:0);if(r===0)return null;if(r&30||r&t.expiredLanes||e)e=pc(t,r);else{e=r;var i=ge;ge|=2;var s=ST();(gt!==t||It!==e)&&(rr=null,Js=Ze()+500,Mi(t,e));do try{AA();break}catch(a){IT(t,a)}while(!0);im(),hc.current=s,ge=i,nt!==null?e=0:(gt=null,It=0,e=lt)}if(e!==0){if(e===2&&(i=_f(t),i!==0&&(r=i,e=qf(t,i))),e===1)throw n=Ka,Mi(t,0),Vr(t,r),Zt(t,Ze()),n;if(e===6)Vr(t,r);else{if(i=t.current.alternate,!(r&30)&&!CA(i)&&(e=pc(t,r),e===2&&(s=_f(t),s!==0&&(r=s,e=qf(t,s))),e===1))throw n=Ka,Mi(t,0),Vr(t,r),Zt(t,Ze()),n;switch(t.finishedWork=i,t.finishedLanes=r,e){case 0:case 1:throw Error(z(345));case 2:ki(t,Kt,rr);break;case 3:if(Vr(t,r),(r&130023424)===r&&(e=vm+500-Ze(),10<e)){if(Yu(t,0)!==0)break;if(i=t.suspendedLanes,(i&r)!==r){Bt(),t.pingedLanes|=t.suspendedLanes&i;break}t.timeoutHandle=kf(ki.bind(null,t,Kt,rr),e);break}ki(t,Kt,rr);break;case 4:if(Vr(t,r),(r&4194240)===r)break;for(e=t.eventTimes,i=-1;0<r;){var o=31-Dn(r);s=1<<o,o=e[o],o>i&&(i=o),r&=~s}if(r=i,r=Ze()-r,r=(120>r?120:480>r?480:1080>r?1080:1920>r?1920:3e3>r?3e3:4320>r?4320:1960*kA(r/1960))-r,10<r){t.timeoutHandle=kf(ki.bind(null,t,Kt,rr),r);break}ki(t,Kt,rr);break;case 5:ki(t,Kt,rr);break;default:throw Error(z(329))}}}return Zt(t,Ze()),t.callbackNode===n?TT.bind(null,t):null}function qf(t,e){var n=_a;return t.current.memoizedState.isDehydrated&&(Mi(t,e).flags|=256),t=pc(t,e),t!==2&&(e=Kt,Kt=n,e!==null&&Hf(e)),t}function Hf(t){Kt===null?Kt=t:Kt.push.apply(Kt,t)}function CA(t){for(var e=t;;){if(e.flags&16384){var n=e.updateQueue;if(n!==null&&(n=n.stores,n!==null))for(var r=0;r<n.length;r++){var i=n[r],s=i.getSnapshot;i=i.value;try{if(!Vn(s(),i))return!1}catch{return!1}}}if(n=e.child,e.subtreeFlags&16384&&n!==null)n.return=e,e=n;else{if(e===t)break;for(;e.sibling===null;){if(e.return===null||e.return===t)return!0;e=e.return}e.sibling.return=e.return,e=e.sibling}}return!0}function Vr(t,e){for(e&=~ym,e&=~th,t.suspendedLanes|=e,t.pingedLanes&=~e,t=t.expirationTimes;0<e;){var n=31-Dn(e),r=1<<n;t[n]=-1,e&=~r}}function sv(t){if(ge&6)throw Error(z(327));Us();var e=Yu(t,0);if(!(e&1))return Zt(t,Ze()),null;var n=pc(t,e);if(t.tag!==0&&n===2){var r=_f(t);r!==0&&(e=r,n=qf(t,r))}if(n===1)throw n=Ka,Mi(t,0),Vr(t,e),Zt(t,Ze()),n;if(n===6)throw Error(z(345));return t.finishedWork=t.current.alternate,t.finishedLanes=e,ki(t,Kt,rr),Zt(t,Ze()),null}function wm(t,e){var n=ge;ge|=1;try{return t(e)}finally{ge=n,ge===0&&(Js=Ze()+500,Xc&&_i())}}function $i(t){Wr!==null&&Wr.tag===0&&!(ge&6)&&Us();var e=ge;ge|=1;var n=vn.transition,r=Ie;try{if(vn.transition=null,Ie=1,t)return t()}finally{Ie=r,vn.transition=n,ge=e,!(ge&6)&&_i()}}function Em(){rn=bs.current,Ue(bs)}function Mi(t,e){t.finishedWork=null,t.finishedLanes=0;var n=t.timeoutHandle;if(n!==-1&&(t.timeoutHandle=-1,nA(n)),nt!==null)for(n=nt.return;n!==null;){var r=n;switch(tm(r),r.tag){case 1:r=r.type.childContextTypes,r!=null&&tc();break;case 3:Ys(),Ue(Xt),Ue(Vt),cm();break;case 5:um(r);break;case 4:Ys();break;case 13:Ue($e);break;case 19:Ue($e);break;case 10:sm(r.type._context);break;case 22:case 23:Em()}n=n.return}if(gt=t,nt=t=Zr(t.current,null),It=rn=e,lt=0,Ka=null,ym=th=Bi=0,Kt=_a=null,Pi!==null){for(e=0;e<Pi.length;e++)if(n=Pi[e],r=n.interleaved,r!==null){n.interleaved=null;var i=r.next,s=n.pending;if(s!==null){var o=s.next;s.next=i,r.next=o}n.pending=r}Pi=null}return t}function IT(t,e){do{var n=nt;try{if(im(),Pu.current=cc,uc){for(var r=We.memoizedState;r!==null;){var i=r.queue;i!==null&&(i.pending=null),r=r.next}uc=!1}if(zi=0,pt=ot=We=null,ma=!1,qa=0,_m.current=null,n===null||n.return===null){lt=1,Ka=e,nt=null;break}e:{var s=t,o=n.return,a=n,u=e;if(e=It,a.flags|=32768,u!==null&&typeof u=="object"&&typeof u.then=="function"){var c=u,d=a,f=d.tag;if(!(d.mode&1)&&(f===0||f===11||f===15)){var m=d.alternate;m?(d.updateQueue=m.updateQueue,d.memoizedState=m.memoizedState,d.lanes=m.lanes):(d.updateQueue=null,d.memoizedState=null)}var w=Hy(o);if(w!==null){w.flags&=-257,Gy(w,o,a,s,e),w.mode&1&&qy(s,c,e),e=w,u=c;var I=e.updateQueue;if(I===null){var P=new Set;P.add(u),e.updateQueue=P}else I.add(u);break e}else{if(!(e&1)){qy(s,c,e),Tm();break e}u=Error(z(426))}}else if(Be&&a.mode&1){var O=Hy(o);if(O!==null){!(O.flags&65536)&&(O.flags|=256),Gy(O,o,a,s,e),nm(Xs(u,a));break e}}s=u=Xs(u,a),lt!==4&&(lt=2),_a===null?_a=[s]:_a.push(s),s=o;do{switch(s.tag){case 3:s.flags|=65536,e&=-e,s.lanes|=e;var C=oT(s,u,e);Uy(s,C);break e;case 1:a=u;var T=s.type,S=s.stateNode;if(!(s.flags&128)&&(typeof T.getDerivedStateFromError=="function"||S!==null&&typeof S.componentDidCatch=="function"&&(Xr===null||!Xr.has(S)))){s.flags|=65536,e&=-e,s.lanes|=e;var M=aT(s,a,e);Uy(s,M);break e}}s=s.return}while(s!==null)}CT(n)}catch(V){e=V,nt===n&&n!==null&&(nt=n=n.return);continue}break}while(!0)}function ST(){var t=hc.current;return hc.current=cc,t===null?cc:t}function Tm(){(lt===0||lt===3||lt===2)&&(lt=4),gt===null||!(Bi&268435455)&&!(th&268435455)||Vr(gt,It)}function pc(t,e){var n=ge;ge|=2;var r=ST();(gt!==t||It!==e)&&(rr=null,Mi(t,e));do try{RA();break}catch(i){IT(t,i)}while(!0);if(im(),ge=n,hc.current=r,nt!==null)throw Error(z(261));return gt=null,It=0,lt}function RA(){for(;nt!==null;)kT(nt)}function AA(){for(;nt!==null&&!ZC();)kT(nt)}function kT(t){var e=AT(t.alternate,t,rn);t.memoizedProps=t.pendingProps,e===null?CT(t):nt=e,_m.current=null}function CT(t){var e=t;do{var n=e.alternate;if(t=e.return,e.flags&32768){if(n=EA(n,e),n!==null){n.flags&=32767,nt=n;return}if(t!==null)t.flags|=32768,t.subtreeFlags=0,t.deletions=null;else{lt=6,nt=null;return}}else if(n=wA(n,e,rn),n!==null){nt=n;return}if(e=e.sibling,e!==null){nt=e;return}nt=e=t}while(e!==null);lt===0&&(lt=5)}function ki(t,e,n){var r=Ie,i=vn.transition;try{vn.transition=null,Ie=1,xA(t,e,n,r)}finally{vn.transition=i,Ie=r}return null}function xA(t,e,n,r){do Us();while(Wr!==null);if(ge&6)throw Error(z(327));n=t.finishedWork;var i=t.finishedLanes;if(n===null)return null;if(t.finishedWork=null,t.finishedLanes=0,n===t.current)throw Error(z(177));t.callbackNode=null,t.callbackPriority=0;var s=n.lanes|n.childLanes;if(uR(t,s),t===gt&&(nt=gt=null,It=0),!(n.subtreeFlags&2064)&&!(n.flags&2064)||hu||(hu=!0,xT(Qu,function(){return Us(),null})),s=(n.flags&15990)!==0,n.subtreeFlags&15990||s){s=vn.transition,vn.transition=null;var o=Ie;Ie=1;var a=ge;ge|=4,_m.current=null,IA(t,n),wT(n,t),QR(If),Xu=!!Tf,If=Tf=null,t.current=n,SA(n),eR(),ge=a,Ie=o,vn.transition=s}else t.current=n;if(hu&&(hu=!1,Wr=t,fc=i),s=t.pendingLanes,s===0&&(Xr=null),rR(n.stateNode),Zt(t,Ze()),e!==null)for(r=t.onRecoverableError,n=0;n<e.length;n++)i=e[n],r(i.value,{componentStack:i.stack,digest:i.digest});if(dc)throw dc=!1,t=$f,$f=null,t;return fc&1&&t.tag!==0&&Us(),s=t.pendingLanes,s&1?t===Wf?ya++:(ya=0,Wf=t):ya=0,_i(),null}function Us(){if(Wr!==null){var t=oE(fc),e=vn.transition,n=Ie;try{if(vn.transition=null,Ie=16>t?16:t,Wr===null)var r=!1;else{if(t=Wr,Wr=null,fc=0,ge&6)throw Error(z(331));var i=ge;for(ge|=4,G=t.current;G!==null;){var s=G,o=s.child;if(G.flags&16){var a=s.deletions;if(a!==null){for(var u=0;u<a.length;u++){var c=a[u];for(G=c;G!==null;){var d=G;switch(d.tag){case 0:case 11:case 15:ga(8,d,s)}var f=d.child;if(f!==null)f.return=d,G=f;else for(;G!==null;){d=G;var m=d.sibling,w=d.return;if(_T(d),d===c){G=null;break}if(m!==null){m.return=w,G=m;break}G=w}}}var I=s.alternate;if(I!==null){var P=I.child;if(P!==null){I.child=null;do{var O=P.sibling;P.sibling=null,P=O}while(P!==null)}}G=s}}if(s.subtreeFlags&2064&&o!==null)o.return=s,G=o;else e:for(;G!==null;){if(s=G,s.flags&2048)switch(s.tag){case 0:case 11:case 15:ga(9,s,s.return)}var C=s.sibling;if(C!==null){C.return=s.return,G=C;break e}G=s.return}}var T=t.current;for(G=T;G!==null;){o=G;var S=o.child;if(o.subtreeFlags&2064&&S!==null)S.return=o,G=S;else e:for(o=T;G!==null;){if(a=G,a.flags&2048)try{switch(a.tag){case 0:case 11:case 15:eh(9,a)}}catch(V){Ke(a,a.return,V)}if(a===o){G=null;break e}var M=a.sibling;if(M!==null){M.return=a.return,G=M;break e}G=a.return}}if(ge=i,_i(),qn&&typeof qn.onPostCommitFiberRoot=="function")try{qn.onPostCommitFiberRoot(Hc,t)}catch{}r=!0}return r}finally{Ie=n,vn.transition=e}}return!1}function ov(t,e,n){e=Xs(n,e),e=oT(t,e,1),t=Yr(t,e,1),e=Bt(),t!==null&&(cl(t,1,e),Zt(t,e))}function Ke(t,e,n){if(t.tag===3)ov(t,t,n);else for(;e!==null;){if(e.tag===3){ov(e,t,n);break}else if(e.tag===1){var r=e.stateNode;if(typeof e.type.getDerivedStateFromError=="function"||typeof r.componentDidCatch=="function"&&(Xr===null||!Xr.has(r))){t=Xs(n,t),t=aT(e,t,1),e=Yr(e,t,1),t=Bt(),e!==null&&(cl(e,1,t),Zt(e,t));break}}e=e.return}}function PA(t,e,n){var r=t.pingCache;r!==null&&r.delete(e),e=Bt(),t.pingedLanes|=t.suspendedLanes&n,gt===t&&(It&n)===n&&(lt===4||lt===3&&(It&130023424)===It&&500>Ze()-vm?Mi(t,0):ym|=n),Zt(t,e)}function RT(t,e){e===0&&(t.mode&1?(e=tu,tu<<=1,!(tu&130023424)&&(tu=4194304)):e=1);var n=Bt();t=_r(t,e),t!==null&&(cl(t,e,n),Zt(t,n))}function bA(t){var e=t.memoizedState,n=0;e!==null&&(n=e.retryLane),RT(t,n)}function NA(t,e){var n=0;switch(t.tag){case 13:var r=t.stateNode,i=t.memoizedState;i!==null&&(n=i.retryLane);break;case 19:r=t.stateNode;break;default:throw Error(z(314))}r!==null&&r.delete(e),RT(t,n)}var AT;AT=function(t,e,n){if(t!==null)if(t.memoizedProps!==e.pendingProps||Xt.current)Qt=!0;else{if(!(t.lanes&n)&&!(e.flags&128))return Qt=!1,vA(t,e,n);Qt=!!(t.flags&131072)}else Qt=!1,Be&&e.flags&1048576&&NE(e,ic,e.index);switch(e.lanes=0,e.tag){case 2:var r=e.type;Nu(t,e),t=e.pendingProps;var i=Gs(e,Vt.current);Fs(e,n),i=dm(null,e,r,t,i,n);var s=fm();return e.flags|=1,typeof i=="object"&&i!==null&&typeof i.render=="function"&&i.$$typeof===void 0?(e.tag=1,e.memoizedState=null,e.updateQueue=null,Jt(r)?(s=!0,nc(e)):s=!1,e.memoizedState=i.state!==null&&i.state!==void 0?i.state:null,am(e),i.updater=Zc,e.stateNode=i,i._reactInternals=e,Nf(e,r,t,n),e=Mf(null,e,r,!0,s,n)):(e.tag=0,Be&&s&&em(e),zt(null,e,i,n),e=e.child),e;case 16:r=e.elementType;e:{switch(Nu(t,e),t=e.pendingProps,i=r._init,r=i(r._payload),e.type=r,i=e.tag=DA(r),t=An(r,t),i){case 0:e=Df(null,e,r,t,n);break e;case 1:e=Yy(null,e,r,t,n);break e;case 11:e=Ky(null,e,r,t,n);break e;case 14:e=Qy(null,e,r,An(r.type,t),n);break e}throw Error(z(306,r,""))}return e;case 0:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),Df(t,e,r,i,n);case 1:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),Yy(t,e,r,i,n);case 3:e:{if(hT(e),t===null)throw Error(z(387));r=e.pendingProps,s=e.memoizedState,i=s.element,FE(t,e),ac(e,r,null,n);var o=e.memoizedState;if(r=o.element,s.isDehydrated)if(s={element:r,isDehydrated:!1,cache:o.cache,pendingSuspenseBoundaries:o.pendingSuspenseBoundaries,transitions:o.transitions},e.updateQueue.baseState=s,e.memoizedState=s,e.flags&256){i=Xs(Error(z(423)),e),e=Xy(t,e,r,n,i);break e}else if(r!==i){i=Xs(Error(z(424)),e),e=Xy(t,e,r,n,i);break e}else for(on=Qr(e.stateNode.containerInfo.firstChild),ln=e,Be=!0,Pn=null,n=LE(e,null,r,n),e.child=n;n;)n.flags=n.flags&-3|4096,n=n.sibling;else{if(Ks(),r===i){e=yr(t,e,n);break e}zt(t,e,r,n)}e=e.child}return e;case 5:return UE(e),t===null&&xf(e),r=e.type,i=e.pendingProps,s=t!==null?t.memoizedProps:null,o=i.children,Sf(r,i)?o=null:s!==null&&Sf(r,s)&&(e.flags|=32),cT(t,e),zt(t,e,o,n),e.child;case 6:return t===null&&xf(e),null;case 13:return dT(t,e,n);case 4:return lm(e,e.stateNode.containerInfo),r=e.pendingProps,t===null?e.child=Qs(e,null,r,n):zt(t,e,r,n),e.child;case 11:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),Ky(t,e,r,i,n);case 7:return zt(t,e,e.pendingProps,n),e.child;case 8:return zt(t,e,e.pendingProps.children,n),e.child;case 12:return zt(t,e,e.pendingProps.children,n),e.child;case 10:e:{if(r=e.type._context,i=e.pendingProps,s=e.memoizedProps,o=i.value,Oe(sc,r._currentValue),r._currentValue=o,s!==null)if(Vn(s.value,o)){if(s.children===i.children&&!Xt.current){e=yr(t,e,n);break e}}else for(s=e.child,s!==null&&(s.return=e);s!==null;){var a=s.dependencies;if(a!==null){o=s.child;for(var u=a.firstContext;u!==null;){if(u.context===r){if(s.tag===1){u=dr(-1,n&-n),u.tag=2;var c=s.updateQueue;if(c!==null){c=c.shared;var d=c.pending;d===null?u.next=u:(u.next=d.next,d.next=u),c.pending=u}}s.lanes|=n,u=s.alternate,u!==null&&(u.lanes|=n),Pf(s.return,n,e),a.lanes|=n;break}u=u.next}}else if(s.tag===10)o=s.type===e.type?null:s.child;else if(s.tag===18){if(o=s.return,o===null)throw Error(z(341));o.lanes|=n,a=o.alternate,a!==null&&(a.lanes|=n),Pf(o,n,e),o=s.sibling}else o=s.child;if(o!==null)o.return=s;else for(o=s;o!==null;){if(o===e){o=null;break}if(s=o.sibling,s!==null){s.return=o.return,o=s;break}o=o.return}s=o}zt(t,e,i.children,n),e=e.child}return e;case 9:return i=e.type,r=e.pendingProps.children,Fs(e,n),i=Tn(i),r=r(i),e.flags|=1,zt(t,e,r,n),e.child;case 14:return r=e.type,i=An(r,e.pendingProps),i=An(r.type,i),Qy(t,e,r,i,n);case 15:return lT(t,e,e.type,e.pendingProps,n);case 17:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),Nu(t,e),e.tag=1,Jt(r)?(t=!0,nc(e)):t=!1,Fs(e,n),sT(e,r,i),Nf(e,r,i,n),Mf(null,e,r,!0,t,n);case 19:return fT(t,e,n);case 22:return uT(t,e,n)}throw Error(z(156,e.tag))};function xT(t,e){return nE(t,e)}function OA(t,e,n,r){this.tag=t,this.key=n,this.sibling=this.child=this.return=this.stateNode=this.type=this.elementType=null,this.index=0,this.ref=null,this.pendingProps=e,this.dependencies=this.memoizedState=this.updateQueue=this.memoizedProps=null,this.mode=r,this.subtreeFlags=this.flags=0,this.deletions=null,this.childLanes=this.lanes=0,this.alternate=null}function mn(t,e,n,r){return new OA(t,e,n,r)}function Im(t){return t=t.prototype,!(!t||!t.isReactComponent)}function DA(t){if(typeof t=="function")return Im(t)?1:0;if(t!=null){if(t=t.$$typeof,t===Bp)return 11;if(t===$p)return 14}return 2}function Zr(t,e){var n=t.alternate;return n===null?(n=mn(t.tag,e,t.key,t.mode),n.elementType=t.elementType,n.type=t.type,n.stateNode=t.stateNode,n.alternate=t,t.alternate=n):(n.pendingProps=e,n.type=t.type,n.flags=0,n.subtreeFlags=0,n.deletions=null),n.flags=t.flags&14680064,n.childLanes=t.childLanes,n.lanes=t.lanes,n.child=t.child,n.memoizedProps=t.memoizedProps,n.memoizedState=t.memoizedState,n.updateQueue=t.updateQueue,e=t.dependencies,n.dependencies=e===null?null:{lanes:e.lanes,firstContext:e.firstContext},n.sibling=t.sibling,n.index=t.index,n.ref=t.ref,n}function Mu(t,e,n,r,i,s){var o=2;if(r=t,typeof t=="function")Im(t)&&(o=1);else if(typeof t=="string")o=5;else e:switch(t){case Es:return Li(n.children,i,s,e);case zp:o=8,i|=8;break;case tf:return t=mn(12,n,e,i|2),t.elementType=tf,t.lanes=s,t;case nf:return t=mn(13,n,e,i),t.elementType=nf,t.lanes=s,t;case rf:return t=mn(19,n,e,i),t.elementType=rf,t.lanes=s,t;case U0:return nh(n,i,s,e);default:if(typeof t=="object"&&t!==null)switch(t.$$typeof){case V0:o=10;break e;case F0:o=9;break e;case Bp:o=11;break e;case $p:o=14;break e;case Dr:o=16,r=null;break e}throw Error(z(130,t==null?t:typeof t,""))}return e=mn(o,n,e,i),e.elementType=t,e.type=r,e.lanes=s,e}function Li(t,e,n,r){return t=mn(7,t,r,e),t.lanes=n,t}function nh(t,e,n,r){return t=mn(22,t,r,e),t.elementType=U0,t.lanes=n,t.stateNode={isHidden:!1},t}function Sd(t,e,n){return t=mn(6,t,null,e),t.lanes=n,t}function kd(t,e,n){return e=mn(4,t.children!==null?t.children:[],t.key,e),e.lanes=n,e.stateNode={containerInfo:t.containerInfo,pendingChildren:null,implementation:t.implementation},e}function MA(t,e,n,r,i){this.tag=e,this.containerInfo=t,this.finishedWork=this.pingCache=this.current=this.pendingChildren=null,this.timeoutHandle=-1,this.callbackNode=this.pendingContext=this.context=null,this.callbackPriority=0,this.eventTimes=sd(0),this.expirationTimes=sd(-1),this.entangledLanes=this.finishedLanes=this.mutableReadLanes=this.expiredLanes=this.pingedLanes=this.suspendedLanes=this.pendingLanes=0,this.entanglements=sd(0),this.identifierPrefix=r,this.onRecoverableError=i,this.mutableSourceEagerHydrationData=null}function Sm(t,e,n,r,i,s,o,a,u){return t=new MA(t,e,n,a,u),e===1?(e=1,s===!0&&(e|=8)):e=0,s=mn(3,null,null,e),t.current=s,s.stateNode=t,s.memoizedState={element:r,isDehydrated:n,cache:null,transitions:null,pendingSuspenseBoundaries:null},am(s),t}function LA(t,e,n){var r=3<arguments.length&&arguments[3]!==void 0?arguments[3]:null;return{$$typeof:ws,key:r==null?null:""+r,children:t,containerInfo:e,implementation:n}}function PT(t){if(!t)return li;t=t._reactInternals;e:{if(es(t)!==t||t.tag!==1)throw Error(z(170));var e=t;do{switch(e.tag){case 3:e=e.stateNode.context;break e;case 1:if(Jt(e.type)){e=e.stateNode.__reactInternalMemoizedMergedChildContext;break e}}e=e.return}while(e!==null);throw Error(z(171))}if(t.tag===1){var n=t.type;if(Jt(n))return PE(t,n,e)}return e}function bT(t,e,n,r,i,s,o,a,u){return t=Sm(n,r,!0,t,i,s,o,a,u),t.context=PT(null),n=t.current,r=Bt(),i=Jr(n),s=dr(r,i),s.callback=e??null,Yr(n,s,i),t.current.lanes=i,cl(t,i,r),Zt(t,r),t}function rh(t,e,n,r){var i=e.current,s=Bt(),o=Jr(i);return n=PT(n),e.context===null?e.context=n:e.pendingContext=n,e=dr(s,o),e.payload={element:t},r=r===void 0?null:r,r!==null&&(e.callback=r),t=Yr(i,e,o),t!==null&&(Mn(t,i,o,s),xu(t,i,o)),o}function mc(t){if(t=t.current,!t.child)return null;switch(t.child.tag){case 5:return t.child.stateNode;default:return t.child.stateNode}}function av(t,e){if(t=t.memoizedState,t!==null&&t.dehydrated!==null){var n=t.retryLane;t.retryLane=n!==0&&n<e?n:e}}function km(t,e){av(t,e),(t=t.alternate)&&av(t,e)}function VA(){return null}var NT=typeof reportError=="function"?reportError:function(t){console.error(t)};function Cm(t){this._internalRoot=t}ih.prototype.render=Cm.prototype.render=function(t){var e=this._internalRoot;if(e===null)throw Error(z(409));rh(t,e,null,null)};ih.prototype.unmount=Cm.prototype.unmount=function(){var t=this._internalRoot;if(t!==null){this._internalRoot=null;var e=t.containerInfo;$i(function(){rh(null,t,null,null)}),e[gr]=null}};function ih(t){this._internalRoot=t}ih.prototype.unstable_scheduleHydration=function(t){if(t){var e=uE();t={blockedOn:null,target:t,priority:e};for(var n=0;n<Lr.length&&e!==0&&e<Lr[n].priority;n++);Lr.splice(n,0,t),n===0&&hE(t)}};function Rm(t){return!(!t||t.nodeType!==1&&t.nodeType!==9&&t.nodeType!==11)}function sh(t){return!(!t||t.nodeType!==1&&t.nodeType!==9&&t.nodeType!==11&&(t.nodeType!==8||t.nodeValue!==" react-mount-point-unstable "))}function lv(){}function FA(t,e,n,r,i){if(i){if(typeof r=="function"){var s=r;r=function(){var c=mc(o);s.call(c)}}var o=bT(e,r,t,0,null,!1,!1,"",lv);return t._reactRootContainer=o,t[gr]=o.current,ja(t.nodeType===8?t.parentNode:t),$i(),o}for(;i=t.lastChild;)t.removeChild(i);if(typeof r=="function"){var a=r;r=function(){var c=mc(u);a.call(c)}}var u=Sm(t,0,!1,null,null,!1,!1,"",lv);return t._reactRootContainer=u,t[gr]=u.current,ja(t.nodeType===8?t.parentNode:t),$i(function(){rh(e,u,n,r)}),u}function oh(t,e,n,r,i){var s=n._reactRootContainer;if(s){var o=s;if(typeof i=="function"){var a=i;i=function(){var u=mc(o);a.call(u)}}rh(e,o,t,i)}else o=FA(n,e,t,i,r);return mc(o)}aE=function(t){switch(t.tag){case 3:var e=t.stateNode;if(e.current.memoizedState.isDehydrated){var n=sa(e.pendingLanes);n!==0&&(Hp(e,n|1),Zt(e,Ze()),!(ge&6)&&(Js=Ze()+500,_i()))}break;case 13:$i(function(){var r=_r(t,1);if(r!==null){var i=Bt();Mn(r,t,1,i)}}),km(t,1)}};Gp=function(t){if(t.tag===13){var e=_r(t,134217728);if(e!==null){var n=Bt();Mn(e,t,134217728,n)}km(t,134217728)}};lE=function(t){if(t.tag===13){var e=Jr(t),n=_r(t,e);if(n!==null){var r=Bt();Mn(n,t,e,r)}km(t,e)}};uE=function(){return Ie};cE=function(t,e){var n=Ie;try{return Ie=t,e()}finally{Ie=n}};pf=function(t,e,n){switch(e){case"input":if(af(t,n),e=n.name,n.type==="radio"&&e!=null){for(n=t;n.parentNode;)n=n.parentNode;for(n=n.querySelectorAll("input[name="+JSON.stringify(""+e)+'][type="radio"]'),e=0;e<n.length;e++){var r=n[e];if(r!==t&&r.form===t.form){var i=Yc(r);if(!i)throw Error(z(90));z0(r),af(r,i)}}}break;case"textarea":$0(t,n);break;case"select":e=n.value,e!=null&&Ds(t,!!n.multiple,e,!1)}};Y0=wm;X0=$i;var UA={usingClientEntryPoint:!1,Events:[dl,ks,Yc,K0,Q0,wm]},Ko={findFiberByHostInstance:xi,bundleType:0,version:"18.3.1",rendererPackageName:"react-dom"},jA={bundleType:Ko.bundleType,version:Ko.version,rendererPackageName:Ko.rendererPackageName,rendererConfig:Ko.rendererConfig,overrideHookState:null,overrideHookStateDeletePath:null,overrideHookStateRenamePath:null,overrideProps:null,overridePropsDeletePath:null,overridePropsRenamePath:null,setErrorHandler:null,setSuspenseHandler:null,scheduleUpdate:null,currentDispatcherRef:Rr.ReactCurrentDispatcher,findHostInstanceByFiber:function(t){return t=eE(t),t===null?null:t.stateNode},findFiberByHostInstance:Ko.findFiberByHostInstance||VA,findHostInstancesForRefresh:null,scheduleRefresh:null,scheduleRoot:null,setRefreshHandler:null,getCurrentFiber:null,reconcilerVersion:"18.3.1-next-f1338f8080-20240426"};if(typeof __REACT_DEVTOOLS_GLOBAL_HOOK__<"u"){var du=__REACT_DEVTOOLS_GLOBAL_HOOK__;if(!du.isDisabled&&du.supportsFiber)try{Hc=du.inject(jA),qn=du}catch{}}cn.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED=UA;cn.createPortal=function(t,e){var n=2<arguments.length&&arguments[2]!==void 0?arguments[2]:null;if(!Rm(e))throw Error(z(200));return LA(t,e,null,n)};cn.createRoot=function(t,e){if(!Rm(t))throw Error(z(299));var n=!1,r="",i=NT;return e!=null&&(e.unstable_strictMode===!0&&(n=!0),e.identifierPrefix!==void 0&&(r=e.identifierPrefix),e.onRecoverableError!==void 0&&(i=e.onRecoverableError)),e=Sm(t,1,!1,null,null,n,!1,r,i),t[gr]=e.current,ja(t.nodeType===8?t.parentNode:t),new Cm(e)};cn.findDOMNode=function(t){if(t==null)return null;if(t.nodeType===1)return t;var e=t._reactInternals;if(e===void 0)throw typeof t.render=="function"?Error(z(188)):(t=Object.keys(t).join(","),Error(z(268,t)));return t=eE(e),t=t===null?null:t.stateNode,t};cn.flushSync=function(t){return $i(t)};cn.hydrate=function(t,e,n){if(!sh(e))throw Error(z(200));return oh(null,t,e,!0,n)};cn.hydrateRoot=function(t,e,n){if(!Rm(t))throw Error(z(405));var r=n!=null&&n.hydratedSources||null,i=!1,s="",o=NT;if(n!=null&&(n.unstable_strictMode===!0&&(i=!0),n.identifierPrefix!==void 0&&(s=n.identifierPrefix),n.onRecoverableError!==void 0&&(o=n.onRecoverableError)),e=bT(e,null,t,1,n??null,i,!1,s,o),t[gr]=e.current,ja(t),r)for(t=0;t<r.length;t++)n=r[t],i=n._getVersion,i=i(n._source),e.mutableSourceEagerHydrationData==null?e.mutableSourceEagerHydrationData=[n,i]:e.mutableSourceEagerHydrationData.push(n,i);return new ih(e)};cn.render=function(t,e,n){if(!sh(e))throw Error(z(200));return oh(null,t,e,!1,n)};cn.unmountComponentAtNode=function(t){if(!sh(t))throw Error(z(40));return t._reactRootContainer?($i(function(){oh(null,null,t,!1,function(){t._reactRootContainer=null,t[gr]=null})}),!0):!1};cn.unstable_batchedUpdates=wm;cn.unstable_renderSubtreeIntoContainer=function(t,e,n,r){if(!sh(n))throw Error(z(200));if(t==null||t._reactInternals===void 0)throw Error(z(38));return oh(t,e,n,!1,r)};cn.version="18.3.1-next-f1338f8080-20240426";function OT(){if(!(typeof __REACT_DEVTOOLS_GLOBAL_HOOK__>"u"||typeof __REACT_DEVTOOLS_GLOBAL_HOOK__.checkDCE!="function"))try{__REACT_DEVTOOLS_GLOBAL_HOOK__.checkDCE(OT)}catch(t){console.error(t)}}OT(),O0.exports=cn;var zA=O0.exports,uv=zA;Zd.createRoot=uv.createRoot,Zd.hydrateRoot=uv.hydrateRoot;/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const BA=t=>t.replace(/([a-z0-9])([A-Z])/g,"$1-$2").toLowerCase(),DT=(...t)=>t.filter((e,n,r)=>!!e&&r.indexOf(e)===n).join(" ");/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */var $A={xmlns:"http://www.w3.org/2000/svg",width:24,height:24,viewBox:"0 0 24 24",fill:"none",stroke:"currentColor",strokeWidth:2,strokeLinecap:"round",strokeLinejoin:"round"};/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const WA=oe.forwardRef(({color:t="currentColor",size:e=24,strokeWidth:n=2,absoluteStrokeWidth:r,className:i="",children:s,iconNode:o,...a},u)=>oe.createElement("svg",{ref:u,...$A,width:e,height:e,stroke:t,strokeWidth:r?Number(n)*24/Number(e):n,className:DT("lucide",i),...a},[...o.map(([c,d])=>oe.createElement(c,d)),...Array.isArray(s)?s:[s]]));/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ke=(t,e)=>{const n=oe.forwardRef(({className:r,...i},s)=>oe.createElement(WA,{ref:s,iconNode:e,className:DT(`lucide-${BA(t)}`,r),...i}));return n.displayName=`${t}`,n};/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const qA=ke("ArrowLeft",[["path",{d:"m12 19-7-7 7-7",key:"1l729n"}],["path",{d:"M19 12H5",key:"x3x0zl"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Am=ke("BookOpen",[["path",{d:"M12 7v14",key:"1akyts"}],["path",{d:"M3 18a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h5a4 4 0 0 1 4 4 4 4 0 0 1 4-4h5a1 1 0 0 1 1 1v13a1 1 0 0 1-1 1h-6a3 3 0 0 0-3 3 3 3 0 0 0-3-3z",key:"ruj8y"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Gf=ke("Check",[["path",{d:"M20 6 9 17l-5-5",key:"1gmf2c"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const HA=ke("CircleAlert",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["line",{x1:"12",x2:"12",y1:"8",y2:"12",key:"1pkeuh"}],["line",{x1:"12",x2:"12.01",y1:"16",y2:"16",key:"4dfq90"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const GA=ke("CircleCheck",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["path",{d:"m9 12 2 2 4-4",key:"dzmm74"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const KA=ke("Clock",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["polyline",{points:"12 6 12 12 16 14",key:"68esgv"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const xm=ke("CloudUpload",[["path",{d:"M12 13v8",key:"1l5pq0"}],["path",{d:"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242",key:"1pljnt"}],["path",{d:"m8 17 4-4 4 4",key:"1quai1"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const QA=ke("Code",[["polyline",{points:"16 18 22 12 16 6",key:"z7tu5w"}],["polyline",{points:"8 6 2 12 8 18",key:"1eg1df"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const cv=ke("Copy",[["rect",{width:"14",height:"14",x:"8",y:"8",rx:"2",ry:"2",key:"17jyea"}],["path",{d:"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2",key:"zix9uf"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const YA=ke("Database",[["ellipse",{cx:"12",cy:"5",rx:"9",ry:"3",key:"msslwz"}],["path",{d:"M3 5V19A9 3 0 0 0 21 19V5",key:"1wlel7"}],["path",{d:"M3 12A9 3 0 0 0 21 12",key:"mv7ke4"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const hv=ke("ExternalLink",[["path",{d:"M15 3h6v6",key:"1q9fwt"}],["path",{d:"M10 14 21 3",key:"gplh6r"}],["path",{d:"M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6",key:"a6xqqp"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const XA=ke("Eye",[["path",{d:"M2.062 12.348a1 1 0 0 1 0-.696 10.75 10.75 0 0 1 19.876 0 1 1 0 0 1 0 .696 10.75 10.75 0 0 1-19.876 0",key:"1nclc0"}],["circle",{cx:"12",cy:"12",r:"3",key:"1v7zrd"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const JA=ke("FileDown",[["path",{d:"M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7Z",key:"1rqfz7"}],["path",{d:"M14 2v4a2 2 0 0 0 2 2h4",key:"tnqrlb"}],["path",{d:"M12 18v-6",key:"17g6i2"}],["path",{d:"m9 15 3 3 3-3",key:"1npd3o"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ZA=ke("FileText",[["path",{d:"M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7Z",key:"1rqfz7"}],["path",{d:"M14 2v4a2 2 0 0 0 2 2h4",key:"tnqrlb"}],["path",{d:"M10 9H8",key:"b1mrlr"}],["path",{d:"M16 13H8",key:"t4e002"}],["path",{d:"M16 17H8",key:"z1uh3a"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ex=ke("HardDrive",[["line",{x1:"22",x2:"2",y1:"12",y2:"12",key:"1y58io"}],["path",{d:"M5.45 5.11 2 12v6a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-6l-3.45-6.89A2 2 0 0 0 16.76 4H7.24a2 2 0 0 0-1.79 1.11z",key:"oot6mr"}],["line",{x1:"6",x2:"6.01",y1:"16",y2:"16",key:"sgf278"}],["line",{x1:"10",x2:"10.01",y1:"16",y2:"16",key:"1l4acy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const tx=ke("Headphones",[["path",{d:"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3",key:"1xhozi"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const nx=ke("Image",[["rect",{width:"18",height:"18",x:"3",y:"3",rx:"2",ry:"2",key:"1m3agn"}],["circle",{cx:"9",cy:"9",r:"2",key:"af1f0g"}],["path",{d:"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21",key:"1xmnt7"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const MT=ke("Info",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["path",{d:"M12 16v-4",key:"1dtifu"}],["path",{d:"M12 8h.01",key:"e9boi3"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const rx=ke("Layers",[["path",{d:"m12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 1.66 0l8.58-3.9a1 1 0 0 0 0-1.83Z",key:"8b97xw"}],["path",{d:"m22 17.65-9.17 4.16a2 2 0 0 1-1.66 0L2 17.65",key:"dd6zsq"}],["path",{d:"m22 12.65-9.17 4.16a2 2 0 0 1-1.66 0L2 12.65",key:"ep9fru"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ix=ke("Library",[["path",{d:"m16 6 4 14",key:"ji33uf"}],["path",{d:"M12 6v14",key:"1n7gus"}],["path",{d:"M8 8v12",key:"1gg7y9"}],["path",{d:"M4 4v16",key:"6qkkli"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const sx=ke("LoaderCircle",[["path",{d:"M21 12a9 9 0 1 1-6.219-8.56",key:"13zald"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ox=ke("PenLine",[["path",{d:"M12 20h9",key:"t2du7b"}],["path",{d:"M16.376 3.622a1 1 0 0 1 3.002 3.002L7.368 18.635a2 2 0 0 1-.855.506l-2.872.838a.5.5 0 0 1-.62-.62l.838-2.872a2 2 0 0 1 .506-.854z",key:"1ykcvy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const dv=ke("RefreshCw",[["path",{d:"M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8",key:"v9h5vc"}],["path",{d:"M21 3v5h-5",key:"1q7to0"}],["path",{d:"M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16",key:"3uifl3"}],["path",{d:"M8 16H3v5",key:"1cv678"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ax=ke("Search",[["circle",{cx:"11",cy:"11",r:"8",key:"4ej97u"}],["path",{d:"m21 21-4.3-4.3",key:"1qie3q"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const lx=ke("ShieldAlert",[["path",{d:"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z",key:"oel41y"}],["path",{d:"M12 8v4",key:"1got3b"}],["path",{d:"M12 16h.01",key:"1drbdi"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const fv=ke("Sparkles",[["path",{d:"M9.937 15.5A2 2 0 0 0 8.5 14.063l-6.135-1.582a.5.5 0 0 1 0-.962L8.5 9.936A2 2 0 0 0 9.937 8.5l1.582-6.135a.5.5 0 0 1 .963 0L14.063 8.5A2 2 0 0 0 15.5 9.937l6.135 1.581a.5.5 0 0 1 0 .964L15.5 14.063a2 2 0 0 0-1.437 1.437l-1.582 6.135a.5.5 0 0 1-.963 0z",key:"4pj2yx"}],["path",{d:"M20 3v4",key:"1olli1"}],["path",{d:"M22 5h-4",key:"1gvqau"}],["path",{d:"M4 17v2",key:"vumght"}],["path",{d:"M5 18H3",key:"zchphs"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ux=ke("Trash2",[["path",{d:"M3 6h18",key:"d0wm0j"}],["path",{d:"M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6",key:"4alrt4"}],["path",{d:"M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2",key:"v07s0e"}],["line",{x1:"10",x2:"10",y1:"11",y2:"17",key:"1uufr5"}],["line",{x1:"14",x2:"14",y1:"11",y2:"17",key:"xtxkd"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const cx=ke("TriangleAlert",[["path",{d:"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3",key:"wmoenq"}],["path",{d:"M12 9v4",key:"juzpu7"}],["path",{d:"M12 17h.01",key:"p32p05"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const LT=ke("X",[["path",{d:"M18 6 6 18",key:"1bl5f8"}],["path",{d:"m6 6 12 12",key:"d8bk6v"}]]);var pv={};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const VT={NODE_ADMIN:!1,SDK_VERSION:"${JSCORE_VERSION}"};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const H=function(t,e){if(!t)throw fo(e)},fo=function(t){return new Error("Firebase Database ("+VT.SDK_VERSION+") INTERNAL ASSERT FAILED: "+t)};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const FT=function(t){const e=[];let n=0;for(let r=0;r<t.length;r++){let i=t.charCodeAt(r);i<128?e[n++]=i:i<2048?(e[n++]=i>>6|192,e[n++]=i&63|128):(i&64512)===55296&&r+1<t.length&&(t.charCodeAt(r+1)&64512)===56320?(i=65536+((i&1023)<<10)+(t.charCodeAt(++r)&1023),e[n++]=i>>18|240,e[n++]=i>>12&63|128,e[n++]=i>>6&63|128,e[n++]=i&63|128):(e[n++]=i>>12|224,e[n++]=i>>6&63|128,e[n++]=i&63|128)}return e},hx=function(t){const e=[];let n=0,r=0;for(;n<t.length;){const i=t[n++];if(i<128)e[r++]=String.fromCharCode(i);else if(i>191&&i<224){const s=t[n++];e[r++]=String.fromCharCode((i&31)<<6|s&63)}else if(i>239&&i<365){const s=t[n++],o=t[n++],a=t[n++],u=((i&7)<<18|(s&63)<<12|(o&63)<<6|a&63)-65536;e[r++]=String.fromCharCode(55296+(u>>10)),e[r++]=String.fromCharCode(56320+(u&1023))}else{const s=t[n++],o=t[n++];e[r++]=String.fromCharCode((i&15)<<12|(s&63)<<6|o&63)}}return e.join("")},Pm={byteToCharMap_:null,charToByteMap_:null,byteToCharMapWebSafe_:null,charToByteMapWebSafe_:null,ENCODED_VALS_BASE:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",get ENCODED_VALS(){return this.ENCODED_VALS_BASE+"+/="},get ENCODED_VALS_WEBSAFE(){return this.ENCODED_VALS_BASE+"-_."},HAS_NATIVE_SUPPORT:typeof atob=="function",encodeByteArray(t,e){if(!Array.isArray(t))throw Error("encodeByteArray takes an array as a parameter");this.init_();const n=e?this.byteToCharMapWebSafe_:this.byteToCharMap_,r=[];for(let i=0;i<t.length;i+=3){const s=t[i],o=i+1<t.length,a=o?t[i+1]:0,u=i+2<t.length,c=u?t[i+2]:0,d=s>>2,f=(s&3)<<4|a>>4;let m=(a&15)<<2|c>>6,w=c&63;u||(w=64,o||(m=64)),r.push(n[d],n[f],n[m],n[w])}return r.join("")},encodeString(t,e){return this.HAS_NATIVE_SUPPORT&&!e?btoa(t):this.encodeByteArray(FT(t),e)},decodeString(t,e){return this.HAS_NATIVE_SUPPORT&&!e?atob(t):hx(this.decodeStringToByteArray(t,e))},decodeStringToByteArray(t,e){this.init_();const n=e?this.charToByteMapWebSafe_:this.charToByteMap_,r=[];for(let i=0;i<t.length;){const s=n[t.charAt(i++)],a=i<t.length?n[t.charAt(i)]:0;++i;const c=i<t.length?n[t.charAt(i)]:64;++i;const f=i<t.length?n[t.charAt(i)]:64;if(++i,s==null||a==null||c==null||f==null)throw new dx;const m=s<<2|a>>4;if(r.push(m),c!==64){const w=a<<4&240|c>>2;if(r.push(w),f!==64){const I=c<<6&192|f;r.push(I)}}}return r},init_(){if(!this.byteToCharMap_){this.byteToCharMap_={},this.charToByteMap_={},this.byteToCharMapWebSafe_={},this.charToByteMapWebSafe_={};for(let t=0;t<this.ENCODED_VALS.length;t++)this.byteToCharMap_[t]=this.ENCODED_VALS.charAt(t),this.charToByteMap_[this.byteToCharMap_[t]]=t,this.byteToCharMapWebSafe_[t]=this.ENCODED_VALS_WEBSAFE.charAt(t),this.charToByteMapWebSafe_[this.byteToCharMapWebSafe_[t]]=t,t>=this.ENCODED_VALS_BASE.length&&(this.charToByteMap_[this.ENCODED_VALS_WEBSAFE.charAt(t)]=t,this.charToByteMapWebSafe_[this.ENCODED_VALS.charAt(t)]=t)}}};class dx extends Error{constructor(){super(...arguments),this.name="DecodeBase64StringError"}}const UT=function(t){const e=FT(t);return Pm.encodeByteArray(e,!0)},gc=function(t){return UT(t).replace(/\./g,"")},_c=function(t){try{return Pm.decodeString(t,!0)}catch(e){console.error("base64Decode failed: ",e)}return null};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function fx(t){return jT(void 0,t)}function jT(t,e){if(!(e instanceof Object))return e;switch(e.constructor){case Date:const n=e;return new Date(n.getTime());case Object:t===void 0&&(t={});break;case Array:t=[];break;default:return e}for(const n in e)!e.hasOwnProperty(n)||!px(n)||(t[n]=jT(t[n],e[n]));return t}function px(t){return t!=="__proto__"}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function mx(){if(typeof self<"u")return self;if(typeof window<"u")return window;if(typeof global<"u")return global;throw new Error("Unable to locate global object.")}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const gx=()=>mx().__FIREBASE_DEFAULTS__,_x=()=>{if(typeof process>"u"||typeof pv>"u")return;const t=pv.__FIREBASE_DEFAULTS__;if(t)return JSON.parse(t)},yx=()=>{if(typeof document>"u")return;let t;try{t=document.cookie.match(/__FIREBASE_DEFAULTS__=([^;]+)/)}catch{return}const e=t&&_c(t[1]);return e&&JSON.parse(e)},ah=()=>{try{return gx()||_x()||yx()}catch(t){console.info(`Unable to get __FIREBASE_DEFAULTS__ due to: ${t}`);return}},zT=t=>{var e,n;return(n=(e=ah())===null||e===void 0?void 0:e.emulatorHosts)===null||n===void 0?void 0:n[t]},bm=t=>{const e=zT(t);if(!e)return;const n=e.lastIndexOf(":");if(n<=0||n+1===e.length)throw new Error(`Invalid host ${e} with no separate hostname and port!`);const r=parseInt(e.substring(n+1),10);return e[0]==="["?[e.substring(1,n-1),r]:[e.substring(0,n),r]},BT=()=>{var t;return(t=ah())===null||t===void 0?void 0:t.config},$T=t=>{var e;return(e=ah())===null||e===void 0?void 0:e[`_${t}`]};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class lh{constructor(){this.reject=()=>{},this.resolve=()=>{},this.promise=new Promise((e,n)=>{this.resolve=e,this.reject=n})}wrapCallback(e){return(n,r)=>{n?this.reject(n):this.resolve(r),typeof e=="function"&&(this.promise.catch(()=>{}),e.length===1?e(n):e(n,r))}}}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Nm(t,e){if(t.uid)throw new Error('The "uid" field is no longer supported by mockUserToken. Please use "sub" instead for Firebase Auth User ID.');const n={alg:"none",type:"JWT"},r=e||"demo-project",i=t.iat||0,s=t.sub||t.user_id;if(!s)throw new Error("mockUserToken must contain 'sub' or 'user_id' field!");const o=Object.assign({iss:`https://securetoken.google.com/${r}`,aud:r,iat:i,exp:i+3600,auth_time:i,sub:s,user_id:s,firebase:{sign_in_provider:"custom",identities:{}}},t);return[gc(JSON.stringify(n)),gc(JSON.stringify(o)),""].join(".")}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Ft(){return typeof navigator<"u"&&typeof navigator.userAgent=="string"?navigator.userAgent:""}function Om(){return typeof window<"u"&&!!(window.cordova||window.phonegap||window.PhoneGap)&&/ios|iphone|ipod|ipad|android|blackberry|iemobile/i.test(Ft())}function vx(){var t;const e=(t=ah())===null||t===void 0?void 0:t.forceEnvironment;if(e==="node")return!0;if(e==="browser")return!1;try{return Object.prototype.toString.call(global.process)==="[object process]"}catch{return!1}}function wx(){return typeof navigator<"u"&&navigator.userAgent==="Cloudflare-Workers"}function Ex(){const t=typeof chrome=="object"?chrome.runtime:typeof browser=="object"?browser.runtime:void 0;return typeof t=="object"&&t.id!==void 0}function WT(){return typeof navigator=="object"&&navigator.product==="ReactNative"}function Tx(){const t=Ft();return t.indexOf("MSIE ")>=0||t.indexOf("Trident/")>=0}function Ix(){return VT.NODE_ADMIN===!0}function Sx(){return!vx()&&!!navigator.userAgent&&navigator.userAgent.includes("Safari")&&!navigator.userAgent.includes("Chrome")}function kx(){try{return typeof indexedDB=="object"}catch{return!1}}function Cx(){return new Promise((t,e)=>{try{let n=!0;const r="validate-browser-context-for-indexeddb-analytics-module",i=self.indexedDB.open(r);i.onsuccess=()=>{i.result.close(),n||self.indexedDB.deleteDatabase(r),t(!0)},i.onupgradeneeded=()=>{n=!1},i.onerror=()=>{var s;e(((s=i.error)===null||s===void 0?void 0:s.message)||"")}}catch(n){e(n)}})}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Rx="FirebaseError";class Zn extends Error{constructor(e,n,r){super(n),this.code=e,this.customData=r,this.name=Rx,Object.setPrototypeOf(this,Zn.prototype),Error.captureStackTrace&&Error.captureStackTrace(this,pl.prototype.create)}}class pl{constructor(e,n,r){this.service=e,this.serviceName=n,this.errors=r}create(e,...n){const r=n[0]||{},i=`${this.service}/${e}`,s=this.errors[e],o=s?Ax(s,r):"Error",a=`${this.serviceName}: ${o} (${i}).`;return new Zn(i,a,r)}}function Ax(t,e){return t.replace(xx,(n,r)=>{const i=e[r];return i!=null?String(i):`<${r}?>`})}const xx=/\{\$([^}]+)}/g;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Qa(t){return JSON.parse(t)}function Et(t){return JSON.stringify(t)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const qT=function(t){let e={},n={},r={},i="";try{const s=t.split(".");e=Qa(_c(s[0])||""),n=Qa(_c(s[1])||""),i=s[2],r=n.d||{},delete n.d}catch{}return{header:e,claims:n,data:r,signature:i}},Px=function(t){const e=qT(t),n=e.claims;return!!n&&typeof n=="object"&&n.hasOwnProperty("iat")},bx=function(t){const e=qT(t).claims;return typeof e=="object"&&e.admin===!0};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Ar(t,e){return Object.prototype.hasOwnProperty.call(t,e)}function Zs(t,e){if(Object.prototype.hasOwnProperty.call(t,e))return t[e]}function Kf(t){for(const e in t)if(Object.prototype.hasOwnProperty.call(t,e))return!1;return!0}function yc(t,e,n){const r={};for(const i in t)Object.prototype.hasOwnProperty.call(t,i)&&(r[i]=e.call(n,t[i],i,t));return r}function vc(t,e){if(t===e)return!0;const n=Object.keys(t),r=Object.keys(e);for(const i of n){if(!r.includes(i))return!1;const s=t[i],o=e[i];if(mv(s)&&mv(o)){if(!vc(s,o))return!1}else if(s!==o)return!1}for(const i of r)if(!n.includes(i))return!1;return!0}function mv(t){return t!==null&&typeof t=="object"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function po(t){const e=[];for(const[n,r]of Object.entries(t))Array.isArray(r)?r.forEach(i=>{e.push(encodeURIComponent(n)+"="+encodeURIComponent(i))}):e.push(encodeURIComponent(n)+"="+encodeURIComponent(r));return e.length?"&"+e.join("&"):""}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Nx{constructor(){this.chain_=[],this.buf_=[],this.W_=[],this.pad_=[],this.inbuf_=0,this.total_=0,this.blockSize=512/8,this.pad_[0]=128;for(let e=1;e<this.blockSize;++e)this.pad_[e]=0;this.reset()}reset(){this.chain_[0]=1732584193,this.chain_[1]=4023233417,this.chain_[2]=2562383102,this.chain_[3]=271733878,this.chain_[4]=3285377520,this.inbuf_=0,this.total_=0}compress_(e,n){n||(n=0);const r=this.W_;if(typeof e=="string")for(let f=0;f<16;f++)r[f]=e.charCodeAt(n)<<24|e.charCodeAt(n+1)<<16|e.charCodeAt(n+2)<<8|e.charCodeAt(n+3),n+=4;else for(let f=0;f<16;f++)r[f]=e[n]<<24|e[n+1]<<16|e[n+2]<<8|e[n+3],n+=4;for(let f=16;f<80;f++){const m=r[f-3]^r[f-8]^r[f-14]^r[f-16];r[f]=(m<<1|m>>>31)&4294967295}let i=this.chain_[0],s=this.chain_[1],o=this.chain_[2],a=this.chain_[3],u=this.chain_[4],c,d;for(let f=0;f<80;f++){f<40?f<20?(c=a^s&(o^a),d=1518500249):(c=s^o^a,d=1859775393):f<60?(c=s&o|a&(s|o),d=2400959708):(c=s^o^a,d=3395469782);const m=(i<<5|i>>>27)+c+u+d+r[f]&4294967295;u=a,a=o,o=(s<<30|s>>>2)&4294967295,s=i,i=m}this.chain_[0]=this.chain_[0]+i&4294967295,this.chain_[1]=this.chain_[1]+s&4294967295,this.chain_[2]=this.chain_[2]+o&4294967295,this.chain_[3]=this.chain_[3]+a&4294967295,this.chain_[4]=this.chain_[4]+u&4294967295}update(e,n){if(e==null)return;n===void 0&&(n=e.length);const r=n-this.blockSize;let i=0;const s=this.buf_;let o=this.inbuf_;for(;i<n;){if(o===0)for(;i<=r;)this.compress_(e,i),i+=this.blockSize;if(typeof e=="string"){for(;i<n;)if(s[o]=e.charCodeAt(i),++o,++i,o===this.blockSize){this.compress_(s),o=0;break}}else for(;i<n;)if(s[o]=e[i],++o,++i,o===this.blockSize){this.compress_(s),o=0;break}}this.inbuf_=o,this.total_+=n}digest(){const e=[];let n=this.total_*8;this.inbuf_<56?this.update(this.pad_,56-this.inbuf_):this.update(this.pad_,this.blockSize-(this.inbuf_-56));for(let i=this.blockSize-1;i>=56;i--)this.buf_[i]=n&255,n/=256;this.compress_(this.buf_);let r=0;for(let i=0;i<5;i++)for(let s=24;s>=0;s-=8)e[r]=this.chain_[i]>>s&255,++r;return e}}function Ox(t,e){const n=new Dx(t,e);return n.subscribe.bind(n)}class Dx{constructor(e,n){this.observers=[],this.unsubscribes=[],this.observerCount=0,this.task=Promise.resolve(),this.finalized=!1,this.onNoObservers=n,this.task.then(()=>{e(this)}).catch(r=>{this.error(r)})}next(e){this.forEachObserver(n=>{n.next(e)})}error(e){this.forEachObserver(n=>{n.error(e)}),this.close(e)}complete(){this.forEachObserver(e=>{e.complete()}),this.close()}subscribe(e,n,r){let i;if(e===void 0&&n===void 0&&r===void 0)throw new Error("Missing Observer.");Mx(e,["next","error","complete"])?i=e:i={next:e,error:n,complete:r},i.next===void 0&&(i.next=Cd),i.error===void 0&&(i.error=Cd),i.complete===void 0&&(i.complete=Cd);const s=this.unsubscribeOne.bind(this,this.observers.length);return this.finalized&&this.task.then(()=>{try{this.finalError?i.error(this.finalError):i.complete()}catch{}}),this.observers.push(i),s}unsubscribeOne(e){this.observers===void 0||this.observers[e]===void 0||(delete this.observers[e],this.observerCount-=1,this.observerCount===0&&this.onNoObservers!==void 0&&this.onNoObservers(this))}forEachObserver(e){if(!this.finalized)for(let n=0;n<this.observers.length;n++)this.sendOne(n,e)}sendOne(e,n){this.task.then(()=>{if(this.observers!==void 0&&this.observers[e]!==void 0)try{n(this.observers[e])}catch(r){typeof console<"u"&&console.error&&console.error(r)}})}close(e){this.finalized||(this.finalized=!0,e!==void 0&&(this.finalError=e),this.task.then(()=>{this.observers=void 0,this.onNoObservers=void 0}))}}function Mx(t,e){if(typeof t!="object"||t===null)return!1;for(const n of e)if(n in t&&typeof t[n]=="function")return!0;return!1}function Cd(){}function Dm(t,e){return`${t} failed: ${e} argument `}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Lx=function(t){const e=[];let n=0;for(let r=0;r<t.length;r++){let i=t.charCodeAt(r);if(i>=55296&&i<=56319){const s=i-55296;r++,H(r<t.length,"Surrogate pair missing trail surrogate.");const o=t.charCodeAt(r)-56320;i=65536+(s<<10)+o}i<128?e[n++]=i:i<2048?(e[n++]=i>>6|192,e[n++]=i&63|128):i<65536?(e[n++]=i>>12|224,e[n++]=i>>6&63|128,e[n++]=i&63|128):(e[n++]=i>>18|240,e[n++]=i>>12&63|128,e[n++]=i>>6&63|128,e[n++]=i&63|128)}return e},uh=function(t){let e=0;for(let n=0;n<t.length;n++){const r=t.charCodeAt(n);r<128?e++:r<2048?e+=2:r>=55296&&r<=56319?(e+=4,n++):e+=3}return e};/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Qe(t){return t&&t._delegate?t._delegate:t}class vr{constructor(e,n,r){this.name=e,this.instanceFactory=n,this.type=r,this.multipleInstances=!1,this.serviceProps={},this.instantiationMode="LAZY",this.onInstanceCreated=null}setInstantiationMode(e){return this.instantiationMode=e,this}setMultipleInstances(e){return this.multipleInstances=e,this}setServiceProps(e){return this.serviceProps=e,this}setInstanceCreatedCallback(e){return this.onInstanceCreated=e,this}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Ci="[DEFAULT]";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Vx{constructor(e,n){this.name=e,this.container=n,this.component=null,this.instances=new Map,this.instancesDeferred=new Map,this.instancesOptions=new Map,this.onInitCallbacks=new Map}get(e){const n=this.normalizeInstanceIdentifier(e);if(!this.instancesDeferred.has(n)){const r=new lh;if(this.instancesDeferred.set(n,r),this.isInitialized(n)||this.shouldAutoInitialize())try{const i=this.getOrInitializeService({instanceIdentifier:n});i&&r.resolve(i)}catch{}}return this.instancesDeferred.get(n).promise}getImmediate(e){var n;const r=this.normalizeInstanceIdentifier(e==null?void 0:e.identifier),i=(n=e==null?void 0:e.optional)!==null&&n!==void 0?n:!1;if(this.isInitialized(r)||this.shouldAutoInitialize())try{return this.getOrInitializeService({instanceIdentifier:r})}catch(s){if(i)return null;throw s}else{if(i)return null;throw Error(`Service ${this.name} is not available`)}}getComponent(){return this.component}setComponent(e){if(e.name!==this.name)throw Error(`Mismatching Component ${e.name} for Provider ${this.name}.`);if(this.component)throw Error(`Component for ${this.name} has already been provided`);if(this.component=e,!!this.shouldAutoInitialize()){if(Ux(e))try{this.getOrInitializeService({instanceIdentifier:Ci})}catch{}for(const[n,r]of this.instancesDeferred.entries()){const i=this.normalizeInstanceIdentifier(n);try{const s=this.getOrInitializeService({instanceIdentifier:i});r.resolve(s)}catch{}}}}clearInstance(e=Ci){this.instancesDeferred.delete(e),this.instancesOptions.delete(e),this.instances.delete(e)}async delete(){const e=Array.from(this.instances.values());await Promise.all([...e.filter(n=>"INTERNAL"in n).map(n=>n.INTERNAL.delete()),...e.filter(n=>"_delete"in n).map(n=>n._delete())])}isComponentSet(){return this.component!=null}isInitialized(e=Ci){return this.instances.has(e)}getOptions(e=Ci){return this.instancesOptions.get(e)||{}}initialize(e={}){const{options:n={}}=e,r=this.normalizeInstanceIdentifier(e.instanceIdentifier);if(this.isInitialized(r))throw Error(`${this.name}(${r}) has already been initialized`);if(!this.isComponentSet())throw Error(`Component ${this.name} has not been registered yet`);const i=this.getOrInitializeService({instanceIdentifier:r,options:n});for(const[s,o]of this.instancesDeferred.entries()){const a=this.normalizeInstanceIdentifier(s);r===a&&o.resolve(i)}return i}onInit(e,n){var r;const i=this.normalizeInstanceIdentifier(n),s=(r=this.onInitCallbacks.get(i))!==null&&r!==void 0?r:new Set;s.add(e),this.onInitCallbacks.set(i,s);const o=this.instances.get(i);return o&&e(o,i),()=>{s.delete(e)}}invokeOnInitCallbacks(e,n){const r=this.onInitCallbacks.get(n);if(r)for(const i of r)try{i(e,n)}catch{}}getOrInitializeService({instanceIdentifier:e,options:n={}}){let r=this.instances.get(e);if(!r&&this.component&&(r=this.component.instanceFactory(this.container,{instanceIdentifier:Fx(e),options:n}),this.instances.set(e,r),this.instancesOptions.set(e,n),this.invokeOnInitCallbacks(r,e),this.component.onInstanceCreated))try{this.component.onInstanceCreated(this.container,e,r)}catch{}return r||null}normalizeInstanceIdentifier(e=Ci){return this.component?this.component.multipleInstances?e:Ci:e}shouldAutoInitialize(){return!!this.component&&this.component.instantiationMode!=="EXPLICIT"}}function Fx(t){return t===Ci?void 0:t}function Ux(t){return t.instantiationMode==="EAGER"}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jx{constructor(e){this.name=e,this.providers=new Map}addComponent(e){const n=this.getProvider(e.name);if(n.isComponentSet())throw new Error(`Component ${e.name} has already been registered with ${this.name}`);n.setComponent(e)}addOrOverwriteComponent(e){this.getProvider(e.name).isComponentSet()&&this.providers.delete(e.name),this.addComponent(e)}getProvider(e){if(this.providers.has(e))return this.providers.get(e);const n=new Vx(e,this);return this.providers.set(e,n),n}getProviders(){return Array.from(this.providers.values())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */var ce;(function(t){t[t.DEBUG=0]="DEBUG",t[t.VERBOSE=1]="VERBOSE",t[t.INFO=2]="INFO",t[t.WARN=3]="WARN",t[t.ERROR=4]="ERROR",t[t.SILENT=5]="SILENT"})(ce||(ce={}));const zx={debug:ce.DEBUG,verbose:ce.VERBOSE,info:ce.INFO,warn:ce.WARN,error:ce.ERROR,silent:ce.SILENT},Bx=ce.INFO,$x={[ce.DEBUG]:"log",[ce.VERBOSE]:"log",[ce.INFO]:"info",[ce.WARN]:"warn",[ce.ERROR]:"error"},Wx=(t,e,...n)=>{if(e<t.logLevel)return;const r=new Date().toISOString(),i=$x[e];if(i)console[i](`[${r}]  ${t.name}:`,...n);else throw new Error(`Attempted to log a message with an invalid logType (value: ${e})`)};class ch{constructor(e){this.name=e,this._logLevel=Bx,this._logHandler=Wx,this._userLogHandler=null}get logLevel(){return this._logLevel}set logLevel(e){if(!(e in ce))throw new TypeError(`Invalid value "${e}" assigned to \`logLevel\``);this._logLevel=e}setLogLevel(e){this._logLevel=typeof e=="string"?zx[e]:e}get logHandler(){return this._logHandler}set logHandler(e){if(typeof e!="function")throw new TypeError("Value assigned to `logHandler` must be a function");this._logHandler=e}get userLogHandler(){return this._userLogHandler}set userLogHandler(e){this._userLogHandler=e}debug(...e){this._userLogHandler&&this._userLogHandler(this,ce.DEBUG,...e),this._logHandler(this,ce.DEBUG,...e)}log(...e){this._userLogHandler&&this._userLogHandler(this,ce.VERBOSE,...e),this._logHandler(this,ce.VERBOSE,...e)}info(...e){this._userLogHandler&&this._userLogHandler(this,ce.INFO,...e),this._logHandler(this,ce.INFO,...e)}warn(...e){this._userLogHandler&&this._userLogHandler(this,ce.WARN,...e),this._logHandler(this,ce.WARN,...e)}error(...e){this._userLogHandler&&this._userLogHandler(this,ce.ERROR,...e),this._logHandler(this,ce.ERROR,...e)}}const qx=(t,e)=>e.some(n=>t instanceof n);let gv,_v;function Hx(){return gv||(gv=[IDBDatabase,IDBObjectStore,IDBIndex,IDBCursor,IDBTransaction])}function Gx(){return _v||(_v=[IDBCursor.prototype.advance,IDBCursor.prototype.continue,IDBCursor.prototype.continuePrimaryKey])}const HT=new WeakMap,Qf=new WeakMap,GT=new WeakMap,Rd=new WeakMap,Mm=new WeakMap;function Kx(t){const e=new Promise((n,r)=>{const i=()=>{t.removeEventListener("success",s),t.removeEventListener("error",o)},s=()=>{n(ei(t.result)),i()},o=()=>{r(t.error),i()};t.addEventListener("success",s),t.addEventListener("error",o)});return e.then(n=>{n instanceof IDBCursor&&HT.set(n,t)}).catch(()=>{}),Mm.set(e,t),e}function Qx(t){if(Qf.has(t))return;const e=new Promise((n,r)=>{const i=()=>{t.removeEventListener("complete",s),t.removeEventListener("error",o),t.removeEventListener("abort",o)},s=()=>{n(),i()},o=()=>{r(t.error||new DOMException("AbortError","AbortError")),i()};t.addEventListener("complete",s),t.addEventListener("error",o),t.addEventListener("abort",o)});Qf.set(t,e)}let Yf={get(t,e,n){if(t instanceof IDBTransaction){if(e==="done")return Qf.get(t);if(e==="objectStoreNames")return t.objectStoreNames||GT.get(t);if(e==="store")return n.objectStoreNames[1]?void 0:n.objectStore(n.objectStoreNames[0])}return ei(t[e])},set(t,e,n){return t[e]=n,!0},has(t,e){return t instanceof IDBTransaction&&(e==="done"||e==="store")?!0:e in t}};function Yx(t){Yf=t(Yf)}function Xx(t){return t===IDBDatabase.prototype.transaction&&!("objectStoreNames"in IDBTransaction.prototype)?function(e,...n){const r=t.call(Ad(this),e,...n);return GT.set(r,e.sort?e.sort():[e]),ei(r)}:Gx().includes(t)?function(...e){return t.apply(Ad(this),e),ei(HT.get(this))}:function(...e){return ei(t.apply(Ad(this),e))}}function Jx(t){return typeof t=="function"?Xx(t):(t instanceof IDBTransaction&&Qx(t),qx(t,Hx())?new Proxy(t,Yf):t)}function ei(t){if(t instanceof IDBRequest)return Kx(t);if(Rd.has(t))return Rd.get(t);const e=Jx(t);return e!==t&&(Rd.set(t,e),Mm.set(e,t)),e}const Ad=t=>Mm.get(t);function Zx(t,e,{blocked:n,upgrade:r,blocking:i,terminated:s}={}){const o=indexedDB.open(t,e),a=ei(o);return r&&o.addEventListener("upgradeneeded",u=>{r(ei(o.result),u.oldVersion,u.newVersion,ei(o.transaction),u)}),n&&o.addEventListener("blocked",u=>n(u.oldVersion,u.newVersion,u)),a.then(u=>{s&&u.addEventListener("close",()=>s()),i&&u.addEventListener("versionchange",c=>i(c.oldVersion,c.newVersion,c))}).catch(()=>{}),a}const eP=["get","getKey","getAll","getAllKeys","count"],tP=["put","add","delete","clear"],xd=new Map;function yv(t,e){if(!(t instanceof IDBDatabase&&!(e in t)&&typeof e=="string"))return;if(xd.get(e))return xd.get(e);const n=e.replace(/FromIndex$/,""),r=e!==n,i=tP.includes(n);if(!(n in(r?IDBIndex:IDBObjectStore).prototype)||!(i||eP.includes(n)))return;const s=async function(o,...a){const u=this.transaction(o,i?"readwrite":"readonly");let c=u.store;return r&&(c=c.index(a.shift())),(await Promise.all([c[n](...a),i&&u.done]))[0]};return xd.set(e,s),s}Yx(t=>({...t,get:(e,n,r)=>yv(e,n)||t.get(e,n,r),has:(e,n)=>!!yv(e,n)||t.has(e,n)}));/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class nP{constructor(e){this.container=e}getPlatformInfoString(){return this.container.getProviders().map(n=>{if(rP(n)){const r=n.getImmediate();return`${r.library}/${r.version}`}else return null}).filter(n=>n).join(" ")}}function rP(t){const e=t.getComponent();return(e==null?void 0:e.type)==="VERSION"}const Xf="@firebase/app",vv="0.10.13";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const wr=new ch("@firebase/app"),iP="@firebase/app-compat",sP="@firebase/analytics-compat",oP="@firebase/analytics",aP="@firebase/app-check-compat",lP="@firebase/app-check",uP="@firebase/auth",cP="@firebase/auth-compat",hP="@firebase/database",dP="@firebase/data-connect",fP="@firebase/database-compat",pP="@firebase/functions",mP="@firebase/functions-compat",gP="@firebase/installations",_P="@firebase/installations-compat",yP="@firebase/messaging",vP="@firebase/messaging-compat",wP="@firebase/performance",EP="@firebase/performance-compat",TP="@firebase/remote-config",IP="@firebase/remote-config-compat",SP="@firebase/storage",kP="@firebase/storage-compat",CP="@firebase/firestore",RP="@firebase/vertexai-preview",AP="@firebase/firestore-compat",xP="firebase",PP="10.14.1";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Jf="[DEFAULT]",bP={[Xf]:"fire-core",[iP]:"fire-core-compat",[oP]:"fire-analytics",[sP]:"fire-analytics-compat",[lP]:"fire-app-check",[aP]:"fire-app-check-compat",[uP]:"fire-auth",[cP]:"fire-auth-compat",[hP]:"fire-rtdb",[dP]:"fire-data-connect",[fP]:"fire-rtdb-compat",[pP]:"fire-fn",[mP]:"fire-fn-compat",[gP]:"fire-iid",[_P]:"fire-iid-compat",[yP]:"fire-fcm",[vP]:"fire-fcm-compat",[wP]:"fire-perf",[EP]:"fire-perf-compat",[TP]:"fire-rc",[IP]:"fire-rc-compat",[SP]:"fire-gcs",[kP]:"fire-gcs-compat",[CP]:"fire-fst",[AP]:"fire-fst-compat",[RP]:"fire-vertex","fire-js":"fire-js",[xP]:"fire-js-all"};/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const wc=new Map,NP=new Map,Zf=new Map;function wv(t,e){try{t.container.addComponent(e)}catch(n){wr.debug(`Component ${e.name} failed to register with FirebaseApp ${t.name}`,n)}}function ui(t){const e=t.name;if(Zf.has(e))return wr.debug(`There were multiple attempts to register component ${e}.`),!1;Zf.set(e,t);for(const n of wc.values())wv(n,t);for(const n of NP.values())wv(n,t);return!0}function ml(t,e){const n=t.container.getProvider("heartbeat").getImmediate({optional:!0});return n&&n.triggerHeartbeat(),t.container.getProvider(e)}function ar(t){return t.settings!==void 0}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const OP={"no-app":"No Firebase App '{$appName}' has been created - call initializeApp() first","bad-app-name":"Illegal App name: '{$appName}'","duplicate-app":"Firebase App named '{$appName}' already exists with different options or config","app-deleted":"Firebase App named '{$appName}' already deleted","server-app-deleted":"Firebase Server App has been deleted","no-options":"Need to provide options, when not being deployed to hosting via source.","invalid-app-argument":"firebase.{$appName}() takes either no argument or a Firebase App instance.","invalid-log-argument":"First argument to `onLog` must be null or a function.","idb-open":"Error thrown when opening IndexedDB. Original error: {$originalErrorMessage}.","idb-get":"Error thrown when reading from IndexedDB. Original error: {$originalErrorMessage}.","idb-set":"Error thrown when writing to IndexedDB. Original error: {$originalErrorMessage}.","idb-delete":"Error thrown when deleting from IndexedDB. Original error: {$originalErrorMessage}.","finalization-registry-not-supported":"FirebaseServerApp deleteOnDeref field defined but the JS runtime does not support FinalizationRegistry.","invalid-server-app-environment":"FirebaseServerApp is not for use in browser environments."},ti=new pl("app","Firebase",OP);/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class DP{constructor(e,n,r){this._isDeleted=!1,this._options=Object.assign({},e),this._config=Object.assign({},n),this._name=n.name,this._automaticDataCollectionEnabled=n.automaticDataCollectionEnabled,this._container=r,this.container.addComponent(new vr("app",()=>this,"PUBLIC"))}get automaticDataCollectionEnabled(){return this.checkDestroyed(),this._automaticDataCollectionEnabled}set automaticDataCollectionEnabled(e){this.checkDestroyed(),this._automaticDataCollectionEnabled=e}get name(){return this.checkDestroyed(),this._name}get options(){return this.checkDestroyed(),this._options}get config(){return this.checkDestroyed(),this._config}get container(){return this._container}get isDeleted(){return this._isDeleted}set isDeleted(e){this._isDeleted=e}checkDestroyed(){if(this.isDeleted)throw ti.create("app-deleted",{appName:this._name})}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const yi=PP;function KT(t,e={}){let n=t;typeof e!="object"&&(e={name:e});const r=Object.assign({name:Jf,automaticDataCollectionEnabled:!1},e),i=r.name;if(typeof i!="string"||!i)throw ti.create("bad-app-name",{appName:String(i)});if(n||(n=BT()),!n)throw ti.create("no-options");const s=wc.get(i);if(s){if(vc(n,s.options)&&vc(r,s.config))return s;throw ti.create("duplicate-app",{appName:i})}const o=new jx(i);for(const u of Zf.values())o.addComponent(u);const a=new DP(n,r,o);return wc.set(i,a),a}function hh(t=Jf){const e=wc.get(t);if(!e&&t===Jf&&BT())return KT();if(!e)throw ti.create("no-app",{appName:t});return e}function wn(t,e,n){var r;let i=(r=bP[t])!==null&&r!==void 0?r:t;n&&(i+=`-${n}`);const s=i.match(/\s|\//),o=e.match(/\s|\//);if(s||o){const a=[`Unable to register library "${i}" with version "${e}":`];s&&a.push(`library name "${i}" contains illegal characters (whitespace or "/")`),s&&o&&a.push("and"),o&&a.push(`version name "${e}" contains illegal characters (whitespace or "/")`),wr.warn(a.join(" "));return}ui(new vr(`${i}-version`,()=>({library:i,version:e}),"VERSION"))}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const MP="firebase-heartbeat-database",LP=1,Ya="firebase-heartbeat-store";let Pd=null;function QT(){return Pd||(Pd=Zx(MP,LP,{upgrade:(t,e)=>{switch(e){case 0:try{t.createObjectStore(Ya)}catch(n){console.warn(n)}}}}).catch(t=>{throw ti.create("idb-open",{originalErrorMessage:t.message})})),Pd}async function VP(t){try{const n=(await QT()).transaction(Ya),r=await n.objectStore(Ya).get(YT(t));return await n.done,r}catch(e){if(e instanceof Zn)wr.warn(e.message);else{const n=ti.create("idb-get",{originalErrorMessage:e==null?void 0:e.message});wr.warn(n.message)}}}async function Ev(t,e){try{const r=(await QT()).transaction(Ya,"readwrite");await r.objectStore(Ya).put(e,YT(t)),await r.done}catch(n){if(n instanceof Zn)wr.warn(n.message);else{const r=ti.create("idb-set",{originalErrorMessage:n==null?void 0:n.message});wr.warn(r.message)}}}function YT(t){return`${t.name}!${t.options.appId}`}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const FP=1024,UP=30*24*60*60*1e3;class jP{constructor(e){this.container=e,this._heartbeatsCache=null;const n=this.container.getProvider("app").getImmediate();this._storage=new BP(n),this._heartbeatsCachePromise=this._storage.read().then(r=>(this._heartbeatsCache=r,r))}async triggerHeartbeat(){var e,n;try{const i=this.container.getProvider("platform-logger").getImmediate().getPlatformInfoString(),s=Tv();return((e=this._heartbeatsCache)===null||e===void 0?void 0:e.heartbeats)==null&&(this._heartbeatsCache=await this._heartbeatsCachePromise,((n=this._heartbeatsCache)===null||n===void 0?void 0:n.heartbeats)==null)||this._heartbeatsCache.lastSentHeartbeatDate===s||this._heartbeatsCache.heartbeats.some(o=>o.date===s)?void 0:(this._heartbeatsCache.heartbeats.push({date:s,agent:i}),this._heartbeatsCache.heartbeats=this._heartbeatsCache.heartbeats.filter(o=>{const a=new Date(o.date).valueOf();return Date.now()-a<=UP}),this._storage.overwrite(this._heartbeatsCache))}catch(r){wr.warn(r)}}async getHeartbeatsHeader(){var e;try{if(this._heartbeatsCache===null&&await this._heartbeatsCachePromise,((e=this._heartbeatsCache)===null||e===void 0?void 0:e.heartbeats)==null||this._heartbeatsCache.heartbeats.length===0)return"";const n=Tv(),{heartbeatsToSend:r,unsentEntries:i}=zP(this._heartbeatsCache.heartbeats),s=gc(JSON.stringify({version:2,heartbeats:r}));return this._heartbeatsCache.lastSentHeartbeatDate=n,i.length>0?(this._heartbeatsCache.heartbeats=i,await this._storage.overwrite(this._heartbeatsCache)):(this._heartbeatsCache.heartbeats=[],this._storage.overwrite(this._heartbeatsCache)),s}catch(n){return wr.warn(n),""}}}function Tv(){return new Date().toISOString().substring(0,10)}function zP(t,e=FP){const n=[];let r=t.slice();for(const i of t){const s=n.find(o=>o.agent===i.agent);if(s){if(s.dates.push(i.date),Iv(n)>e){s.dates.pop();break}}else if(n.push({agent:i.agent,dates:[i.date]}),Iv(n)>e){n.pop();break}r=r.slice(1)}return{heartbeatsToSend:n,unsentEntries:r}}class BP{constructor(e){this.app=e,this._canUseIndexedDBPromise=this.runIndexedDBEnvironmentCheck()}async runIndexedDBEnvironmentCheck(){return kx()?Cx().then(()=>!0).catch(()=>!1):!1}async read(){if(await this._canUseIndexedDBPromise){const n=await VP(this.app);return n!=null&&n.heartbeats?n:{heartbeats:[]}}else return{heartbeats:[]}}async overwrite(e){var n;if(await this._canUseIndexedDBPromise){const i=await this.read();return Ev(this.app,{lastSentHeartbeatDate:(n=e.lastSentHeartbeatDate)!==null&&n!==void 0?n:i.lastSentHeartbeatDate,heartbeats:e.heartbeats})}else return}async add(e){var n;if(await this._canUseIndexedDBPromise){const i=await this.read();return Ev(this.app,{lastSentHeartbeatDate:(n=e.lastSentHeartbeatDate)!==null&&n!==void 0?n:i.lastSentHeartbeatDate,heartbeats:[...i.heartbeats,...e.heartbeats]})}else return}}function Iv(t){return gc(JSON.stringify({version:2,heartbeats:t})).length}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function $P(t){ui(new vr("platform-logger",e=>new nP(e),"PRIVATE")),ui(new vr("heartbeat",e=>new jP(e),"PRIVATE")),wn(Xf,vv,t),wn(Xf,vv,"esm2017"),wn("fire-js","")}$P("");var WP="firebase",qP="10.14.1";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */wn(WP,qP,"app");var Sv=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};/** @license
Copyright The Closure Library Authors.
SPDX-License-Identifier: Apache-2.0
*/var Vi,XT;(function(){var t;/** @license

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/function e(y,g){function E(){}E.prototype=g.prototype,y.D=g.prototype,y.prototype=new E,y.prototype.constructor=y,y.C=function(k,x,N){for(var R=Array(arguments.length-2),Ye=2;Ye<arguments.length;Ye++)R[Ye-2]=arguments[Ye];return g.prototype[x].apply(k,R)}}function n(){this.blockSize=-1}function r(){this.blockSize=-1,this.blockSize=64,this.g=Array(4),this.B=Array(this.blockSize),this.o=this.h=0,this.s()}e(r,n),r.prototype.s=function(){this.g[0]=1732584193,this.g[1]=4023233417,this.g[2]=2562383102,this.g[3]=271733878,this.o=this.h=0};function i(y,g,E){E||(E=0);var k=Array(16);if(typeof g=="string")for(var x=0;16>x;++x)k[x]=g.charCodeAt(E++)|g.charCodeAt(E++)<<8|g.charCodeAt(E++)<<16|g.charCodeAt(E++)<<24;else for(x=0;16>x;++x)k[x]=g[E++]|g[E++]<<8|g[E++]<<16|g[E++]<<24;g=y.g[0],E=y.g[1],x=y.g[2];var N=y.g[3],R=g+(N^E&(x^N))+k[0]+3614090360&4294967295;g=E+(R<<7&4294967295|R>>>25),R=N+(x^g&(E^x))+k[1]+3905402710&4294967295,N=g+(R<<12&4294967295|R>>>20),R=x+(E^N&(g^E))+k[2]+606105819&4294967295,x=N+(R<<17&4294967295|R>>>15),R=E+(g^x&(N^g))+k[3]+3250441966&4294967295,E=x+(R<<22&4294967295|R>>>10),R=g+(N^E&(x^N))+k[4]+4118548399&4294967295,g=E+(R<<7&4294967295|R>>>25),R=N+(x^g&(E^x))+k[5]+1200080426&4294967295,N=g+(R<<12&4294967295|R>>>20),R=x+(E^N&(g^E))+k[6]+2821735955&4294967295,x=N+(R<<17&4294967295|R>>>15),R=E+(g^x&(N^g))+k[7]+4249261313&4294967295,E=x+(R<<22&4294967295|R>>>10),R=g+(N^E&(x^N))+k[8]+1770035416&4294967295,g=E+(R<<7&4294967295|R>>>25),R=N+(x^g&(E^x))+k[9]+2336552879&4294967295,N=g+(R<<12&4294967295|R>>>20),R=x+(E^N&(g^E))+k[10]+4294925233&4294967295,x=N+(R<<17&4294967295|R>>>15),R=E+(g^x&(N^g))+k[11]+2304563134&4294967295,E=x+(R<<22&4294967295|R>>>10),R=g+(N^E&(x^N))+k[12]+1804603682&4294967295,g=E+(R<<7&4294967295|R>>>25),R=N+(x^g&(E^x))+k[13]+4254626195&4294967295,N=g+(R<<12&4294967295|R>>>20),R=x+(E^N&(g^E))+k[14]+2792965006&4294967295,x=N+(R<<17&4294967295|R>>>15),R=E+(g^x&(N^g))+k[15]+1236535329&4294967295,E=x+(R<<22&4294967295|R>>>10),R=g+(x^N&(E^x))+k[1]+4129170786&4294967295,g=E+(R<<5&4294967295|R>>>27),R=N+(E^x&(g^E))+k[6]+3225465664&4294967295,N=g+(R<<9&4294967295|R>>>23),R=x+(g^E&(N^g))+k[11]+643717713&4294967295,x=N+(R<<14&4294967295|R>>>18),R=E+(N^g&(x^N))+k[0]+3921069994&4294967295,E=x+(R<<20&4294967295|R>>>12),R=g+(x^N&(E^x))+k[5]+3593408605&4294967295,g=E+(R<<5&4294967295|R>>>27),R=N+(E^x&(g^E))+k[10]+38016083&4294967295,N=g+(R<<9&4294967295|R>>>23),R=x+(g^E&(N^g))+k[15]+3634488961&4294967295,x=N+(R<<14&4294967295|R>>>18),R=E+(N^g&(x^N))+k[4]+3889429448&4294967295,E=x+(R<<20&4294967295|R>>>12),R=g+(x^N&(E^x))+k[9]+568446438&4294967295,g=E+(R<<5&4294967295|R>>>27),R=N+(E^x&(g^E))+k[14]+3275163606&4294967295,N=g+(R<<9&4294967295|R>>>23),R=x+(g^E&(N^g))+k[3]+4107603335&4294967295,x=N+(R<<14&4294967295|R>>>18),R=E+(N^g&(x^N))+k[8]+1163531501&4294967295,E=x+(R<<20&4294967295|R>>>12),R=g+(x^N&(E^x))+k[13]+2850285829&4294967295,g=E+(R<<5&4294967295|R>>>27),R=N+(E^x&(g^E))+k[2]+4243563512&4294967295,N=g+(R<<9&4294967295|R>>>23),R=x+(g^E&(N^g))+k[7]+1735328473&4294967295,x=N+(R<<14&4294967295|R>>>18),R=E+(N^g&(x^N))+k[12]+2368359562&4294967295,E=x+(R<<20&4294967295|R>>>12),R=g+(E^x^N)+k[5]+4294588738&4294967295,g=E+(R<<4&4294967295|R>>>28),R=N+(g^E^x)+k[8]+2272392833&4294967295,N=g+(R<<11&4294967295|R>>>21),R=x+(N^g^E)+k[11]+1839030562&4294967295,x=N+(R<<16&4294967295|R>>>16),R=E+(x^N^g)+k[14]+4259657740&4294967295,E=x+(R<<23&4294967295|R>>>9),R=g+(E^x^N)+k[1]+2763975236&4294967295,g=E+(R<<4&4294967295|R>>>28),R=N+(g^E^x)+k[4]+1272893353&4294967295,N=g+(R<<11&4294967295|R>>>21),R=x+(N^g^E)+k[7]+4139469664&4294967295,x=N+(R<<16&4294967295|R>>>16),R=E+(x^N^g)+k[10]+3200236656&4294967295,E=x+(R<<23&4294967295|R>>>9),R=g+(E^x^N)+k[13]+681279174&4294967295,g=E+(R<<4&4294967295|R>>>28),R=N+(g^E^x)+k[0]+3936430074&4294967295,N=g+(R<<11&4294967295|R>>>21),R=x+(N^g^E)+k[3]+3572445317&4294967295,x=N+(R<<16&4294967295|R>>>16),R=E+(x^N^g)+k[6]+76029189&4294967295,E=x+(R<<23&4294967295|R>>>9),R=g+(E^x^N)+k[9]+3654602809&4294967295,g=E+(R<<4&4294967295|R>>>28),R=N+(g^E^x)+k[12]+3873151461&4294967295,N=g+(R<<11&4294967295|R>>>21),R=x+(N^g^E)+k[15]+530742520&4294967295,x=N+(R<<16&4294967295|R>>>16),R=E+(x^N^g)+k[2]+3299628645&4294967295,E=x+(R<<23&4294967295|R>>>9),R=g+(x^(E|~N))+k[0]+4096336452&4294967295,g=E+(R<<6&4294967295|R>>>26),R=N+(E^(g|~x))+k[7]+1126891415&4294967295,N=g+(R<<10&4294967295|R>>>22),R=x+(g^(N|~E))+k[14]+2878612391&4294967295,x=N+(R<<15&4294967295|R>>>17),R=E+(N^(x|~g))+k[5]+4237533241&4294967295,E=x+(R<<21&4294967295|R>>>11),R=g+(x^(E|~N))+k[12]+1700485571&4294967295,g=E+(R<<6&4294967295|R>>>26),R=N+(E^(g|~x))+k[3]+2399980690&4294967295,N=g+(R<<10&4294967295|R>>>22),R=x+(g^(N|~E))+k[10]+4293915773&4294967295,x=N+(R<<15&4294967295|R>>>17),R=E+(N^(x|~g))+k[1]+2240044497&4294967295,E=x+(R<<21&4294967295|R>>>11),R=g+(x^(E|~N))+k[8]+1873313359&4294967295,g=E+(R<<6&4294967295|R>>>26),R=N+(E^(g|~x))+k[15]+4264355552&4294967295,N=g+(R<<10&4294967295|R>>>22),R=x+(g^(N|~E))+k[6]+2734768916&4294967295,x=N+(R<<15&4294967295|R>>>17),R=E+(N^(x|~g))+k[13]+1309151649&4294967295,E=x+(R<<21&4294967295|R>>>11),R=g+(x^(E|~N))+k[4]+4149444226&4294967295,g=E+(R<<6&4294967295|R>>>26),R=N+(E^(g|~x))+k[11]+3174756917&4294967295,N=g+(R<<10&4294967295|R>>>22),R=x+(g^(N|~E))+k[2]+718787259&4294967295,x=N+(R<<15&4294967295|R>>>17),R=E+(N^(x|~g))+k[9]+3951481745&4294967295,y.g[0]=y.g[0]+g&4294967295,y.g[1]=y.g[1]+(x+(R<<21&4294967295|R>>>11))&4294967295,y.g[2]=y.g[2]+x&4294967295,y.g[3]=y.g[3]+N&4294967295}r.prototype.u=function(y,g){g===void 0&&(g=y.length);for(var E=g-this.blockSize,k=this.B,x=this.h,N=0;N<g;){if(x==0)for(;N<=E;)i(this,y,N),N+=this.blockSize;if(typeof y=="string"){for(;N<g;)if(k[x++]=y.charCodeAt(N++),x==this.blockSize){i(this,k),x=0;break}}else for(;N<g;)if(k[x++]=y[N++],x==this.blockSize){i(this,k),x=0;break}}this.h=x,this.o+=g},r.prototype.v=function(){var y=Array((56>this.h?this.blockSize:2*this.blockSize)-this.h);y[0]=128;for(var g=1;g<y.length-8;++g)y[g]=0;var E=8*this.o;for(g=y.length-8;g<y.length;++g)y[g]=E&255,E/=256;for(this.u(y),y=Array(16),g=E=0;4>g;++g)for(var k=0;32>k;k+=8)y[E++]=this.g[g]>>>k&255;return y};function s(y,g){var E=a;return Object.prototype.hasOwnProperty.call(E,y)?E[y]:E[y]=g(y)}function o(y,g){this.h=g;for(var E=[],k=!0,x=y.length-1;0<=x;x--){var N=y[x]|0;k&&N==g||(E[x]=N,k=!1)}this.g=E}var a={};function u(y){return-128<=y&&128>y?s(y,function(g){return new o([g|0],0>g?-1:0)}):new o([y|0],0>y?-1:0)}function c(y){if(isNaN(y)||!isFinite(y))return f;if(0>y)return O(c(-y));for(var g=[],E=1,k=0;y>=E;k++)g[k]=y/E|0,E*=4294967296;return new o(g,0)}function d(y,g){if(y.length==0)throw Error("number format error: empty string");if(g=g||10,2>g||36<g)throw Error("radix out of range: "+g);if(y.charAt(0)=="-")return O(d(y.substring(1),g));if(0<=y.indexOf("-"))throw Error('number format error: interior "-" character');for(var E=c(Math.pow(g,8)),k=f,x=0;x<y.length;x+=8){var N=Math.min(8,y.length-x),R=parseInt(y.substring(x,x+N),g);8>N?(N=c(Math.pow(g,N)),k=k.j(N).add(c(R))):(k=k.j(E),k=k.add(c(R)))}return k}var f=u(0),m=u(1),w=u(16777216);t=o.prototype,t.m=function(){if(P(this))return-O(this).m();for(var y=0,g=1,E=0;E<this.g.length;E++){var k=this.i(E);y+=(0<=k?k:4294967296+k)*g,g*=4294967296}return y},t.toString=function(y){if(y=y||10,2>y||36<y)throw Error("radix out of range: "+y);if(I(this))return"0";if(P(this))return"-"+O(this).toString(y);for(var g=c(Math.pow(y,6)),E=this,k="";;){var x=M(E,g).g;E=C(E,x.j(g));var N=((0<E.g.length?E.g[0]:E.h)>>>0).toString(y);if(E=x,I(E))return N+k;for(;6>N.length;)N="0"+N;k=N+k}},t.i=function(y){return 0>y?0:y<this.g.length?this.g[y]:this.h};function I(y){if(y.h!=0)return!1;for(var g=0;g<y.g.length;g++)if(y.g[g]!=0)return!1;return!0}function P(y){return y.h==-1}t.l=function(y){return y=C(this,y),P(y)?-1:I(y)?0:1};function O(y){for(var g=y.g.length,E=[],k=0;k<g;k++)E[k]=~y.g[k];return new o(E,~y.h).add(m)}t.abs=function(){return P(this)?O(this):this},t.add=function(y){for(var g=Math.max(this.g.length,y.g.length),E=[],k=0,x=0;x<=g;x++){var N=k+(this.i(x)&65535)+(y.i(x)&65535),R=(N>>>16)+(this.i(x)>>>16)+(y.i(x)>>>16);k=R>>>16,N&=65535,R&=65535,E[x]=R<<16|N}return new o(E,E[E.length-1]&-2147483648?-1:0)};function C(y,g){return y.add(O(g))}t.j=function(y){if(I(this)||I(y))return f;if(P(this))return P(y)?O(this).j(O(y)):O(O(this).j(y));if(P(y))return O(this.j(O(y)));if(0>this.l(w)&&0>y.l(w))return c(this.m()*y.m());for(var g=this.g.length+y.g.length,E=[],k=0;k<2*g;k++)E[k]=0;for(k=0;k<this.g.length;k++)for(var x=0;x<y.g.length;x++){var N=this.i(k)>>>16,R=this.i(k)&65535,Ye=y.i(x)>>>16,ct=y.i(x)&65535;E[2*k+2*x]+=R*ct,T(E,2*k+2*x),E[2*k+2*x+1]+=N*ct,T(E,2*k+2*x+1),E[2*k+2*x+1]+=R*Ye,T(E,2*k+2*x+1),E[2*k+2*x+2]+=N*Ye,T(E,2*k+2*x+2)}for(k=0;k<g;k++)E[k]=E[2*k+1]<<16|E[2*k];for(k=g;k<2*g;k++)E[k]=0;return new o(E,0)};function T(y,g){for(;(y[g]&65535)!=y[g];)y[g+1]+=y[g]>>>16,y[g]&=65535,g++}function S(y,g){this.g=y,this.h=g}function M(y,g){if(I(g))throw Error("division by zero");if(I(y))return new S(f,f);if(P(y))return g=M(O(y),g),new S(O(g.g),O(g.h));if(P(g))return g=M(y,O(g)),new S(O(g.g),g.h);if(30<y.g.length){if(P(y)||P(g))throw Error("slowDivide_ only works with positive integers.");for(var E=m,k=g;0>=k.l(y);)E=V(E),k=V(k);var x=F(E,1),N=F(k,1);for(k=F(k,2),E=F(E,2);!I(k);){var R=N.add(k);0>=R.l(y)&&(x=x.add(E),N=R),k=F(k,1),E=F(E,1)}return g=C(y,x.j(g)),new S(x,g)}for(x=f;0<=y.l(g);){for(E=Math.max(1,Math.floor(y.m()/g.m())),k=Math.ceil(Math.log(E)/Math.LN2),k=48>=k?1:Math.pow(2,k-48),N=c(E),R=N.j(g);P(R)||0<R.l(y);)E-=k,N=c(E),R=N.j(g);I(N)&&(N=m),x=x.add(N),y=C(y,R)}return new S(x,y)}t.A=function(y){return M(this,y).h},t.and=function(y){for(var g=Math.max(this.g.length,y.g.length),E=[],k=0;k<g;k++)E[k]=this.i(k)&y.i(k);return new o(E,this.h&y.h)},t.or=function(y){for(var g=Math.max(this.g.length,y.g.length),E=[],k=0;k<g;k++)E[k]=this.i(k)|y.i(k);return new o(E,this.h|y.h)},t.xor=function(y){for(var g=Math.max(this.g.length,y.g.length),E=[],k=0;k<g;k++)E[k]=this.i(k)^y.i(k);return new o(E,this.h^y.h)};function V(y){for(var g=y.g.length+1,E=[],k=0;k<g;k++)E[k]=y.i(k)<<1|y.i(k-1)>>>31;return new o(E,y.h)}function F(y,g){var E=g>>5;g%=32;for(var k=y.g.length-E,x=[],N=0;N<k;N++)x[N]=0<g?y.i(N+E)>>>g|y.i(N+E+1)<<32-g:y.i(N+E);return new o(x,y.h)}r.prototype.digest=r.prototype.v,r.prototype.reset=r.prototype.s,r.prototype.update=r.prototype.u,XT=r,o.prototype.add=o.prototype.add,o.prototype.multiply=o.prototype.j,o.prototype.modulo=o.prototype.A,o.prototype.compare=o.prototype.l,o.prototype.toNumber=o.prototype.m,o.prototype.toString=o.prototype.toString,o.prototype.getBits=o.prototype.i,o.fromNumber=c,o.fromString=d,Vi=o}).apply(typeof Sv<"u"?Sv:typeof self<"u"?self:typeof window<"u"?window:{});var fu=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};/** @license
Copyright The Closure Library Authors.
SPDX-License-Identifier: Apache-2.0
*/var JT,aa,ZT,Lu,ep,eI,tI,nI;(function(){var t,e=typeof Object.defineProperties=="function"?Object.defineProperty:function(l,h,p){return l==Array.prototype||l==Object.prototype||(l[h]=p.value),l};function n(l){l=[typeof globalThis=="object"&&globalThis,l,typeof window=="object"&&window,typeof self=="object"&&self,typeof fu=="object"&&fu];for(var h=0;h<l.length;++h){var p=l[h];if(p&&p.Math==Math)return p}throw Error("Cannot find global object")}var r=n(this);function i(l,h){if(h)e:{var p=r;l=l.split(".");for(var _=0;_<l.length-1;_++){var D=l[_];if(!(D in p))break e;p=p[D]}l=l[l.length-1],_=p[l],h=h(_),h!=_&&h!=null&&e(p,l,{configurable:!0,writable:!0,value:h})}}function s(l,h){l instanceof String&&(l+="");var p=0,_=!1,D={next:function(){if(!_&&p<l.length){var L=p++;return{value:h(L,l[L]),done:!1}}return _=!0,{done:!0,value:void 0}}};return D[Symbol.iterator]=function(){return D},D}i("Array.prototype.values",function(l){return l||function(){return s(this,function(h,p){return p})}});/** @license

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/var o=o||{},a=this||self;function u(l){var h=typeof l;return h=h!="object"?h:l?Array.isArray(l)?"array":h:"null",h=="array"||h=="object"&&typeof l.length=="number"}function c(l){var h=typeof l;return h=="object"&&l!=null||h=="function"}function d(l,h,p){return l.call.apply(l.bind,arguments)}function f(l,h,p){if(!l)throw Error();if(2<arguments.length){var _=Array.prototype.slice.call(arguments,2);return function(){var D=Array.prototype.slice.call(arguments);return Array.prototype.unshift.apply(D,_),l.apply(h,D)}}return function(){return l.apply(h,arguments)}}function m(l,h,p){return m=Function.prototype.bind&&Function.prototype.bind.toString().indexOf("native code")!=-1?d:f,m.apply(null,arguments)}function w(l,h){var p=Array.prototype.slice.call(arguments,1);return function(){var _=p.slice();return _.push.apply(_,arguments),l.apply(this,_)}}function I(l,h){function p(){}p.prototype=h.prototype,l.aa=h.prototype,l.prototype=new p,l.prototype.constructor=l,l.Qb=function(_,D,L){for(var $=Array(arguments.length-2),Pe=2;Pe<arguments.length;Pe++)$[Pe-2]=arguments[Pe];return h.prototype[D].apply(_,$)}}function P(l){const h=l.length;if(0<h){const p=Array(h);for(let _=0;_<h;_++)p[_]=l[_];return p}return[]}function O(l,h){for(let p=1;p<arguments.length;p++){const _=arguments[p];if(u(_)){const D=l.length||0,L=_.length||0;l.length=D+L;for(let $=0;$<L;$++)l[D+$]=_[$]}else l.push(_)}}class C{constructor(h,p){this.i=h,this.j=p,this.h=0,this.g=null}get(){let h;return 0<this.h?(this.h--,h=this.g,this.g=h.next,h.next=null):h=this.i(),h}}function T(l){return/^[\s\xa0]*$/.test(l)}function S(){var l=a.navigator;return l&&(l=l.userAgent)?l:""}function M(l){return M[" "](l),l}M[" "]=function(){};var V=S().indexOf("Gecko")!=-1&&!(S().toLowerCase().indexOf("webkit")!=-1&&S().indexOf("Edge")==-1)&&!(S().indexOf("Trident")!=-1||S().indexOf("MSIE")!=-1)&&S().indexOf("Edge")==-1;function F(l,h,p){for(const _ in l)h.call(p,l[_],_,l)}function y(l,h){for(const p in l)h.call(void 0,l[p],p,l)}function g(l){const h={};for(const p in l)h[p]=l[p];return h}const E="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function k(l,h){let p,_;for(let D=1;D<arguments.length;D++){_=arguments[D];for(p in _)l[p]=_[p];for(let L=0;L<E.length;L++)p=E[L],Object.prototype.hasOwnProperty.call(_,p)&&(l[p]=_[p])}}function x(l){var h=1;l=l.split(":");const p=[];for(;0<h&&l.length;)p.push(l.shift()),h--;return l.length&&p.push(l.join(":")),p}function N(l){a.setTimeout(()=>{throw l},0)}function R(){var l=X;let h=null;return l.g&&(h=l.g,l.g=l.g.next,l.g||(l.h=null),h.next=null),h}class Ye{constructor(){this.h=this.g=null}add(h,p){const _=ct.get();_.set(h,p),this.h?this.h.next=_:this.g=_,this.h=_}}var ct=new C(()=>new ve,l=>l.reset());class ve{constructor(){this.next=this.g=this.h=null}set(h,p){this.h=h,this.g=p,this.next=null}reset(){this.next=this.g=this.h=null}}let et,W=!1,X=new Ye,b=()=>{const l=a.Promise.resolve(void 0);et=()=>{l.then(A)}};var A=()=>{for(var l;l=R();){try{l.h.call(l.g)}catch(p){N(p)}var h=ct;h.j(l),100>h.h&&(h.h++,l.next=h.g,h.g=l)}W=!1};function B(){this.s=this.s,this.C=this.C}B.prototype.s=!1,B.prototype.ma=function(){this.s||(this.s=!0,this.N())},B.prototype.N=function(){if(this.C)for(;this.C.length;)this.C.shift()()};function q(l,h){this.type=l,this.g=this.target=h,this.defaultPrevented=!1}q.prototype.h=function(){this.defaultPrevented=!0};var J=function(){if(!a.addEventListener||!Object.defineProperty)return!1;var l=!1,h=Object.defineProperty({},"passive",{get:function(){l=!0}});try{const p=()=>{};a.addEventListener("test",p,h),a.removeEventListener("test",p,h)}catch{}return l}();function ee(l,h){if(q.call(this,l?l.type:""),this.relatedTarget=this.g=this.target=null,this.button=this.screenY=this.screenX=this.clientY=this.clientX=0,this.key="",this.metaKey=this.shiftKey=this.altKey=this.ctrlKey=!1,this.state=null,this.pointerId=0,this.pointerType="",this.i=null,l){var p=this.type=l.type,_=l.changedTouches&&l.changedTouches.length?l.changedTouches[0]:null;if(this.target=l.target||l.srcElement,this.g=h,h=l.relatedTarget){if(V){e:{try{M(h.nodeName);var D=!0;break e}catch{}D=!1}D||(h=null)}}else p=="mouseover"?h=l.fromElement:p=="mouseout"&&(h=l.toElement);this.relatedTarget=h,_?(this.clientX=_.clientX!==void 0?_.clientX:_.pageX,this.clientY=_.clientY!==void 0?_.clientY:_.pageY,this.screenX=_.screenX||0,this.screenY=_.screenY||0):(this.clientX=l.clientX!==void 0?l.clientX:l.pageX,this.clientY=l.clientY!==void 0?l.clientY:l.pageY,this.screenX=l.screenX||0,this.screenY=l.screenY||0),this.button=l.button,this.key=l.key||"",this.ctrlKey=l.ctrlKey,this.altKey=l.altKey,this.shiftKey=l.shiftKey,this.metaKey=l.metaKey,this.pointerId=l.pointerId||0,this.pointerType=typeof l.pointerType=="string"?l.pointerType:te[l.pointerType]||"",this.state=l.state,this.i=l,l.defaultPrevented&&ee.aa.h.call(this)}}I(ee,q);var te={2:"touch",3:"pen",4:"mouse"};ee.prototype.h=function(){ee.aa.h.call(this);var l=this.i;l.preventDefault?l.preventDefault():l.returnValue=!1};var Q="closure_listenable_"+(1e6*Math.random()|0),ae=0;function Ce(l,h,p,_,D){this.listener=l,this.proxy=null,this.src=h,this.type=p,this.capture=!!_,this.ha=D,this.key=++ae,this.da=this.fa=!1}function xe(l){l.da=!0,l.listener=null,l.proxy=null,l.src=null,l.ha=null}function Ee(l){this.src=l,this.g={},this.h=0}Ee.prototype.add=function(l,h,p,_,D){var L=l.toString();l=this.g[L],l||(l=this.g[L]=[],this.h++);var $=Xe(l,h,_,D);return-1<$?(h=l[$],p||(h.fa=!1)):(h=new Ce(h,this.src,L,!!_,D),h.fa=p,l.push(h)),h};function Ne(l,h){var p=h.type;if(p in l.g){var _=l.g[p],D=Array.prototype.indexOf.call(_,h,void 0),L;(L=0<=D)&&Array.prototype.splice.call(_,D,1),L&&(xe(h),l.g[p].length==0&&(delete l.g[p],l.h--))}}function Xe(l,h,p,_){for(var D=0;D<l.length;++D){var L=l[D];if(!L.da&&L.listener==h&&L.capture==!!p&&L.ha==_)return D}return-1}var le="closure_lm_"+(1e6*Math.random()|0),ht={};function qt(l,h,p,_,D){if(Array.isArray(h)){for(var L=0;L<h.length;L++)qt(l,h[L],p,_,D);return null}return p=Ol(p),l&&l[Q]?l.K(h,p,c(_)?!!_.capture:!1,D):tn(l,h,p,!1,_,D)}function tn(l,h,p,_,D,L){if(!h)throw Error("Invalid event type");var $=c(D)?!!D.capture:!!D,Pe=ko(l);if(Pe||(l[le]=Pe=new Ee(l)),p=Pe.add(h,p,_,$,L),p.proxy)return p;if(_=kn(),p.proxy=_,_.src=l,_.listener=p,l.addEventListener)J||(D=$),D===void 0&&(D=!1),l.addEventListener(h.toString(),_,D);else if(l.attachEvent)l.attachEvent(Nl(h.toString()),_);else if(l.addListener&&l.removeListener)l.addListener(_);else throw Error("addEventListener and attachEvent are unavailable.");return p}function kn(){function l(p){return h.call(l.src,l.listener,p)}const h=Vh;return l}function Un(l,h,p,_,D){if(Array.isArray(h))for(var L=0;L<h.length;L++)Un(l,h[L],p,_,D);else _=c(_)?!!_.capture:!!_,p=Ol(p),l&&l[Q]?(l=l.i,h=String(h).toString(),h in l.g&&(L=l.g[h],p=Xe(L,p,_,D),-1<p&&(xe(L[p]),Array.prototype.splice.call(L,p,1),L.length==0&&(delete l.g[h],l.h--)))):l&&(l=ko(l))&&(h=l.g[h.toString()],l=-1,h&&(l=Xe(h,p,_,D)),(p=-1<l?h[l]:null)&&Ht(p))}function Ht(l){if(typeof l!="number"&&l&&!l.da){var h=l.src;if(h&&h[Q])Ne(h.i,l);else{var p=l.type,_=l.proxy;h.removeEventListener?h.removeEventListener(p,_,l.capture):h.detachEvent?h.detachEvent(Nl(p),_):h.addListener&&h.removeListener&&h.removeListener(_),(p=ko(h))?(Ne(p,l),p.h==0&&(p.src=null,h[le]=null)):xe(l)}}}function Nl(l){return l in ht?ht[l]:ht[l]="on"+l}function Vh(l,h){if(l.da)l=!0;else{h=new ee(h,this);var p=l.listener,_=l.ha||l.src;l.fa&&Ht(l),l=p.call(_,h)}return l}function ko(l){return l=l[le],l instanceof Ee?l:null}var ls="__closure_events_fn_"+(1e9*Math.random()>>>0);function Ol(l){return typeof l=="function"?l:(l[ls]||(l[ls]=function(h){return l.handleEvent(h)}),l[ls])}function st(){B.call(this),this.i=new Ee(this),this.M=this,this.F=null}I(st,B),st.prototype[Q]=!0,st.prototype.removeEventListener=function(l,h,p,_){Un(this,l,h,p,_)};function _t(l,h){var p,_=l.F;if(_)for(p=[];_;_=_.F)p.push(_);if(l=l.M,_=h.type||h,typeof h=="string")h=new q(h,l);else if(h instanceof q)h.target=h.target||l;else{var D=h;h=new q(_,l),k(h,D)}if(D=!0,p)for(var L=p.length-1;0<=L;L--){var $=h.g=p[L];D=us($,_,!0,h)&&D}if($=h.g=l,D=us($,_,!0,h)&&D,D=us($,_,!1,h)&&D,p)for(L=0;L<p.length;L++)$=h.g=p[L],D=us($,_,!1,h)&&D}st.prototype.N=function(){if(st.aa.N.call(this),this.i){var l=this.i,h;for(h in l.g){for(var p=l.g[h],_=0;_<p.length;_++)xe(p[_]);delete l.g[h],l.h--}}this.F=null},st.prototype.K=function(l,h,p,_){return this.i.add(String(l),h,!1,p,_)},st.prototype.L=function(l,h,p,_){return this.i.add(String(l),h,!0,p,_)};function us(l,h,p,_){if(h=l.i.g[String(h)],!h)return!0;h=h.concat();for(var D=!0,L=0;L<h.length;++L){var $=h[L];if($&&!$.da&&$.capture==p){var Pe=$.listener,yt=$.ha||$.src;$.fa&&Ne(l.i,$),D=Pe.call(yt,_)!==!1&&D}}return D&&!_.defaultPrevented}function Co(l,h,p){if(typeof l=="function")p&&(l=m(l,p));else if(l&&typeof l.handleEvent=="function")l=m(l.handleEvent,l);else throw Error("Invalid listener argument");return 2147483647<Number(h)?-1:a.setTimeout(l,h||0)}function Ro(l){l.g=Co(()=>{l.g=null,l.i&&(l.i=!1,Ro(l))},l.l);const h=l.h;l.h=null,l.m.apply(null,h)}class Ao extends B{constructor(h,p){super(),this.m=h,this.l=p,this.h=null,this.i=!1,this.g=null}j(h){this.h=arguments,this.g?this.i=!0:Ro(this)}N(){super.N(),this.g&&(a.clearTimeout(this.g),this.g=null,this.i=!1,this.h=null)}}function vi(l){B.call(this),this.h=l,this.g={}}I(vi,B);var Dl=[];function u_(l){F(l.g,function(h,p){this.g.hasOwnProperty(p)&&Ht(h)},l),l.g={}}vi.prototype.N=function(){vi.aa.N.call(this),u_(this)},vi.prototype.handleEvent=function(){throw Error("EventHandler.handleEvent not implemented")};var Fh=a.JSON.stringify,z1=a.JSON.parse,B1=class{stringify(l){return a.JSON.stringify(l,void 0)}parse(l){return a.JSON.parse(l,void 0)}};function Uh(){}Uh.prototype.h=null;function c_(l){return l.h||(l.h=l.i())}function h_(){}var xo={OPEN:"a",kb:"b",Ja:"c",wb:"d"};function jh(){q.call(this,"d")}I(jh,q);function zh(){q.call(this,"c")}I(zh,q);var wi={},d_=null;function Ml(){return d_=d_||new st}wi.La="serverreachability";function f_(l){q.call(this,wi.La,l)}I(f_,q);function Po(l){const h=Ml();_t(h,new f_(h))}wi.STAT_EVENT="statevent";function p_(l,h){q.call(this,wi.STAT_EVENT,l),this.stat=h}I(p_,q);function Ut(l){const h=Ml();_t(h,new p_(h,l))}wi.Ma="timingevent";function m_(l,h){q.call(this,wi.Ma,l),this.size=h}I(m_,q);function bo(l,h){if(typeof l!="function")throw Error("Fn must not be null and must be a function");return a.setTimeout(function(){l()},h)}function No(){this.g=!0}No.prototype.xa=function(){this.g=!1};function $1(l,h,p,_,D,L){l.info(function(){if(l.g)if(L)for(var $="",Pe=L.split("&"),yt=0;yt<Pe.length;yt++){var _e=Pe[yt].split("=");if(1<_e.length){var Rt=_e[0];_e=_e[1];var At=Rt.split("_");$=2<=At.length&&At[1]=="type"?$+(Rt+"="+_e+"&"):$+(Rt+"=redacted&")}}else $=null;else $=L;return"XMLHTTP REQ ("+_+") [attempt "+D+"]: "+h+`
`+p+`
`+$})}function W1(l,h,p,_,D,L,$){l.info(function(){return"XMLHTTP RESP ("+_+") [ attempt "+D+"]: "+h+`
`+p+`
`+L+" "+$})}function cs(l,h,p,_){l.info(function(){return"XMLHTTP TEXT ("+h+"): "+H1(l,p)+(_?" "+_:"")})}function q1(l,h){l.info(function(){return"TIMEOUT: "+h})}No.prototype.info=function(){};function H1(l,h){if(!l.g)return h;if(!h)return null;try{var p=JSON.parse(h);if(p){for(l=0;l<p.length;l++)if(Array.isArray(p[l])){var _=p[l];if(!(2>_.length)){var D=_[1];if(Array.isArray(D)&&!(1>D.length)){var L=D[0];if(L!="noop"&&L!="stop"&&L!="close")for(var $=1;$<D.length;$++)D[$]=""}}}}return Fh(p)}catch{return h}}var Ll={NO_ERROR:0,gb:1,tb:2,sb:3,nb:4,rb:5,ub:6,Ia:7,TIMEOUT:8,xb:9},g_={lb:"complete",Hb:"success",Ja:"error",Ia:"abort",zb:"ready",Ab:"readystatechange",TIMEOUT:"timeout",vb:"incrementaldata",yb:"progress",ob:"downloadprogress",Pb:"uploadprogress"},Bh;function Vl(){}I(Vl,Uh),Vl.prototype.g=function(){return new XMLHttpRequest},Vl.prototype.i=function(){return{}},Bh=new Vl;function xr(l,h,p,_){this.j=l,this.i=h,this.l=p,this.R=_||1,this.U=new vi(this),this.I=45e3,this.H=null,this.o=!1,this.m=this.A=this.v=this.L=this.F=this.S=this.B=null,this.D=[],this.g=null,this.C=0,this.s=this.u=null,this.X=-1,this.J=!1,this.O=0,this.M=null,this.W=this.K=this.T=this.P=!1,this.h=new __}function __(){this.i=null,this.g="",this.h=!1}var y_={},$h={};function Wh(l,h,p){l.L=1,l.v=zl(er(h)),l.m=p,l.P=!0,v_(l,null)}function v_(l,h){l.F=Date.now(),Fl(l),l.A=er(l.v);var p=l.A,_=l.R;Array.isArray(_)||(_=[String(_)]),O_(p.i,"t",_),l.C=0,p=l.j.J,l.h=new __,l.g=X_(l.j,p?h:null,!l.m),0<l.O&&(l.M=new Ao(m(l.Y,l,l.g),l.O)),h=l.U,p=l.g,_=l.ca;var D="readystatechange";Array.isArray(D)||(D&&(Dl[0]=D.toString()),D=Dl);for(var L=0;L<D.length;L++){var $=qt(p,D[L],_||h.handleEvent,!1,h.h||h);if(!$)break;h.g[$.key]=$}h=l.H?g(l.H):{},l.m?(l.u||(l.u="POST"),h["Content-Type"]="application/x-www-form-urlencoded",l.g.ea(l.A,l.u,l.m,h)):(l.u="GET",l.g.ea(l.A,l.u,null,h)),Po(),$1(l.i,l.u,l.A,l.l,l.R,l.m)}xr.prototype.ca=function(l){l=l.target;const h=this.M;h&&tr(l)==3?h.j():this.Y(l)},xr.prototype.Y=function(l){try{if(l==this.g)e:{const At=tr(this.g);var h=this.g.Ba();const fs=this.g.Z();if(!(3>At)&&(At!=3||this.g&&(this.h.h||this.g.oa()||j_(this.g)))){this.J||At!=4||h==7||(h==8||0>=fs?Po(3):Po(2)),qh(this);var p=this.g.Z();this.X=p;t:if(w_(this)){var _=j_(this.g);l="";var D=_.length,L=tr(this.g)==4;if(!this.h.i){if(typeof TextDecoder>"u"){Ei(this),Oo(this);var $="";break t}this.h.i=new a.TextDecoder}for(h=0;h<D;h++)this.h.h=!0,l+=this.h.i.decode(_[h],{stream:!(L&&h==D-1)});_.length=0,this.h.g+=l,this.C=0,$=this.h.g}else $=this.g.oa();if(this.o=p==200,W1(this.i,this.u,this.A,this.l,this.R,At,p),this.o){if(this.T&&!this.K){t:{if(this.g){var Pe,yt=this.g;if((Pe=yt.g?yt.g.getResponseHeader("X-HTTP-Initial-Response"):null)&&!T(Pe)){var _e=Pe;break t}}_e=null}if(p=_e)cs(this.i,this.l,p,"Initial handshake response via X-HTTP-Initial-Response"),this.K=!0,Hh(this,p);else{this.o=!1,this.s=3,Ut(12),Ei(this),Oo(this);break e}}if(this.P){p=!0;let Cn;for(;!this.J&&this.C<$.length;)if(Cn=G1(this,$),Cn==$h){At==4&&(this.s=4,Ut(14),p=!1),cs(this.i,this.l,null,"[Incomplete Response]");break}else if(Cn==y_){this.s=4,Ut(15),cs(this.i,this.l,$,"[Invalid Chunk]"),p=!1;break}else cs(this.i,this.l,Cn,null),Hh(this,Cn);if(w_(this)&&this.C!=0&&(this.h.g=this.h.g.slice(this.C),this.C=0),At!=4||$.length!=0||this.h.h||(this.s=1,Ut(16),p=!1),this.o=this.o&&p,!p)cs(this.i,this.l,$,"[Invalid Chunked Response]"),Ei(this),Oo(this);else if(0<$.length&&!this.W){this.W=!0;var Rt=this.j;Rt.g==this&&Rt.ba&&!Rt.M&&(Rt.j.info("Great, no buffering proxy detected. Bytes received: "+$.length),Jh(Rt),Rt.M=!0,Ut(11))}}else cs(this.i,this.l,$,null),Hh(this,$);At==4&&Ei(this),this.o&&!this.J&&(At==4?G_(this.j,this):(this.o=!1,Fl(this)))}else cC(this.g),p==400&&0<$.indexOf("Unknown SID")?(this.s=3,Ut(12)):(this.s=0,Ut(13)),Ei(this),Oo(this)}}}catch{}finally{}};function w_(l){return l.g?l.u=="GET"&&l.L!=2&&l.j.Ca:!1}function G1(l,h){var p=l.C,_=h.indexOf(`
`,p);return _==-1?$h:(p=Number(h.substring(p,_)),isNaN(p)?y_:(_+=1,_+p>h.length?$h:(h=h.slice(_,_+p),l.C=_+p,h)))}xr.prototype.cancel=function(){this.J=!0,Ei(this)};function Fl(l){l.S=Date.now()+l.I,E_(l,l.I)}function E_(l,h){if(l.B!=null)throw Error("WatchDog timer not null");l.B=bo(m(l.ba,l),h)}function qh(l){l.B&&(a.clearTimeout(l.B),l.B=null)}xr.prototype.ba=function(){this.B=null;const l=Date.now();0<=l-this.S?(q1(this.i,this.A),this.L!=2&&(Po(),Ut(17)),Ei(this),this.s=2,Oo(this)):E_(this,this.S-l)};function Oo(l){l.j.G==0||l.J||G_(l.j,l)}function Ei(l){qh(l);var h=l.M;h&&typeof h.ma=="function"&&h.ma(),l.M=null,u_(l.U),l.g&&(h=l.g,l.g=null,h.abort(),h.ma())}function Hh(l,h){try{var p=l.j;if(p.G!=0&&(p.g==l||Gh(p.h,l))){if(!l.K&&Gh(p.h,l)&&p.G==3){try{var _=p.Da.g.parse(h)}catch{_=null}if(Array.isArray(_)&&_.length==3){var D=_;if(D[0]==0){e:if(!p.u){if(p.g)if(p.g.F+3e3<l.F)Gl(p),ql(p);else break e;Xh(p),Ut(18)}}else p.za=D[1],0<p.za-p.T&&37500>D[2]&&p.F&&p.v==0&&!p.C&&(p.C=bo(m(p.Za,p),6e3));if(1>=S_(p.h)&&p.ca){try{p.ca()}catch{}p.ca=void 0}}else Ii(p,11)}else if((l.K||p.g==l)&&Gl(p),!T(h))for(D=p.Da.g.parse(h),h=0;h<D.length;h++){let _e=D[h];if(p.T=_e[0],_e=_e[1],p.G==2)if(_e[0]=="c"){p.K=_e[1],p.ia=_e[2];const Rt=_e[3];Rt!=null&&(p.la=Rt,p.j.info("VER="+p.la));const At=_e[4];At!=null&&(p.Aa=At,p.j.info("SVER="+p.Aa));const fs=_e[5];fs!=null&&typeof fs=="number"&&0<fs&&(_=1.5*fs,p.L=_,p.j.info("backChannelRequestTimeoutMs_="+_)),_=p;const Cn=l.g;if(Cn){const Ql=Cn.g?Cn.g.getResponseHeader("X-Client-Wire-Protocol"):null;if(Ql){var L=_.h;L.g||Ql.indexOf("spdy")==-1&&Ql.indexOf("quic")==-1&&Ql.indexOf("h2")==-1||(L.j=L.l,L.g=new Set,L.h&&(Kh(L,L.h),L.h=null))}if(_.D){const Zh=Cn.g?Cn.g.getResponseHeader("X-HTTP-Session-Id"):null;Zh&&(_.ya=Zh,De(_.I,_.D,Zh))}}p.G=3,p.l&&p.l.ua(),p.ba&&(p.R=Date.now()-l.F,p.j.info("Handshake RTT: "+p.R+"ms")),_=p;var $=l;if(_.qa=Y_(_,_.J?_.ia:null,_.W),$.K){k_(_.h,$);var Pe=$,yt=_.L;yt&&(Pe.I=yt),Pe.B&&(qh(Pe),Fl(Pe)),_.g=$}else q_(_);0<p.i.length&&Hl(p)}else _e[0]!="stop"&&_e[0]!="close"||Ii(p,7);else p.G==3&&(_e[0]=="stop"||_e[0]=="close"?_e[0]=="stop"?Ii(p,7):Yh(p):_e[0]!="noop"&&p.l&&p.l.ta(_e),p.v=0)}}Po(4)}catch{}}var K1=class{constructor(l,h){this.g=l,this.map=h}};function T_(l){this.l=l||10,a.PerformanceNavigationTiming?(l=a.performance.getEntriesByType("navigation"),l=0<l.length&&(l[0].nextHopProtocol=="hq"||l[0].nextHopProtocol=="h2")):l=!!(a.chrome&&a.chrome.loadTimes&&a.chrome.loadTimes()&&a.chrome.loadTimes().wasFetchedViaSpdy),this.j=l?this.l:1,this.g=null,1<this.j&&(this.g=new Set),this.h=null,this.i=[]}function I_(l){return l.h?!0:l.g?l.g.size>=l.j:!1}function S_(l){return l.h?1:l.g?l.g.size:0}function Gh(l,h){return l.h?l.h==h:l.g?l.g.has(h):!1}function Kh(l,h){l.g?l.g.add(h):l.h=h}function k_(l,h){l.h&&l.h==h?l.h=null:l.g&&l.g.has(h)&&l.g.delete(h)}T_.prototype.cancel=function(){if(this.i=C_(this),this.h)this.h.cancel(),this.h=null;else if(this.g&&this.g.size!==0){for(const l of this.g.values())l.cancel();this.g.clear()}};function C_(l){if(l.h!=null)return l.i.concat(l.h.D);if(l.g!=null&&l.g.size!==0){let h=l.i;for(const p of l.g.values())h=h.concat(p.D);return h}return P(l.i)}function Q1(l){if(l.V&&typeof l.V=="function")return l.V();if(typeof Map<"u"&&l instanceof Map||typeof Set<"u"&&l instanceof Set)return Array.from(l.values());if(typeof l=="string")return l.split("");if(u(l)){for(var h=[],p=l.length,_=0;_<p;_++)h.push(l[_]);return h}h=[],p=0;for(_ in l)h[p++]=l[_];return h}function Y1(l){if(l.na&&typeof l.na=="function")return l.na();if(!l.V||typeof l.V!="function"){if(typeof Map<"u"&&l instanceof Map)return Array.from(l.keys());if(!(typeof Set<"u"&&l instanceof Set)){if(u(l)||typeof l=="string"){var h=[];l=l.length;for(var p=0;p<l;p++)h.push(p);return h}h=[],p=0;for(const _ in l)h[p++]=_;return h}}}function R_(l,h){if(l.forEach&&typeof l.forEach=="function")l.forEach(h,void 0);else if(u(l)||typeof l=="string")Array.prototype.forEach.call(l,h,void 0);else for(var p=Y1(l),_=Q1(l),D=_.length,L=0;L<D;L++)h.call(void 0,_[L],p&&p[L],l)}var A_=RegExp("^(?:([^:/?#.]+):)?(?://(?:([^\\\\/?#]*)@)?([^\\\\/?#]*?)(?::([0-9]+))?(?=[\\\\/?#]|$))?([^?#]+)?(?:\\?([^#]*))?(?:#([\\s\\S]*))?$");function X1(l,h){if(l){l=l.split("&");for(var p=0;p<l.length;p++){var _=l[p].indexOf("="),D=null;if(0<=_){var L=l[p].substring(0,_);D=l[p].substring(_+1)}else L=l[p];h(L,D?decodeURIComponent(D.replace(/\+/g," ")):"")}}}function Ti(l){if(this.g=this.o=this.j="",this.s=null,this.m=this.l="",this.h=!1,l instanceof Ti){this.h=l.h,Ul(this,l.j),this.o=l.o,this.g=l.g,jl(this,l.s),this.l=l.l;var h=l.i,p=new Lo;p.i=h.i,h.g&&(p.g=new Map(h.g),p.h=h.h),x_(this,p),this.m=l.m}else l&&(h=String(l).match(A_))?(this.h=!1,Ul(this,h[1]||"",!0),this.o=Do(h[2]||""),this.g=Do(h[3]||"",!0),jl(this,h[4]),this.l=Do(h[5]||"",!0),x_(this,h[6]||"",!0),this.m=Do(h[7]||"")):(this.h=!1,this.i=new Lo(null,this.h))}Ti.prototype.toString=function(){var l=[],h=this.j;h&&l.push(Mo(h,P_,!0),":");var p=this.g;return(p||h=="file")&&(l.push("//"),(h=this.o)&&l.push(Mo(h,P_,!0),"@"),l.push(encodeURIComponent(String(p)).replace(/%25([0-9a-fA-F]{2})/g,"%$1")),p=this.s,p!=null&&l.push(":",String(p))),(p=this.l)&&(this.g&&p.charAt(0)!="/"&&l.push("/"),l.push(Mo(p,p.charAt(0)=="/"?eC:Z1,!0))),(p=this.i.toString())&&l.push("?",p),(p=this.m)&&l.push("#",Mo(p,nC)),l.join("")};function er(l){return new Ti(l)}function Ul(l,h,p){l.j=p?Do(h,!0):h,l.j&&(l.j=l.j.replace(/:$/,""))}function jl(l,h){if(h){if(h=Number(h),isNaN(h)||0>h)throw Error("Bad port number "+h);l.s=h}else l.s=null}function x_(l,h,p){h instanceof Lo?(l.i=h,rC(l.i,l.h)):(p||(h=Mo(h,tC)),l.i=new Lo(h,l.h))}function De(l,h,p){l.i.set(h,p)}function zl(l){return De(l,"zx",Math.floor(2147483648*Math.random()).toString(36)+Math.abs(Math.floor(2147483648*Math.random())^Date.now()).toString(36)),l}function Do(l,h){return l?h?decodeURI(l.replace(/%25/g,"%2525")):decodeURIComponent(l):""}function Mo(l,h,p){return typeof l=="string"?(l=encodeURI(l).replace(h,J1),p&&(l=l.replace(/%25([0-9a-fA-F]{2})/g,"%$1")),l):null}function J1(l){return l=l.charCodeAt(0),"%"+(l>>4&15).toString(16)+(l&15).toString(16)}var P_=/[#\/\?@]/g,Z1=/[#\?:]/g,eC=/[#\?]/g,tC=/[#\?@]/g,nC=/#/g;function Lo(l,h){this.h=this.g=null,this.i=l||null,this.j=!!h}function Pr(l){l.g||(l.g=new Map,l.h=0,l.i&&X1(l.i,function(h,p){l.add(decodeURIComponent(h.replace(/\+/g," ")),p)}))}t=Lo.prototype,t.add=function(l,h){Pr(this),this.i=null,l=hs(this,l);var p=this.g.get(l);return p||this.g.set(l,p=[]),p.push(h),this.h+=1,this};function b_(l,h){Pr(l),h=hs(l,h),l.g.has(h)&&(l.i=null,l.h-=l.g.get(h).length,l.g.delete(h))}function N_(l,h){return Pr(l),h=hs(l,h),l.g.has(h)}t.forEach=function(l,h){Pr(this),this.g.forEach(function(p,_){p.forEach(function(D){l.call(h,D,_,this)},this)},this)},t.na=function(){Pr(this);const l=Array.from(this.g.values()),h=Array.from(this.g.keys()),p=[];for(let _=0;_<h.length;_++){const D=l[_];for(let L=0;L<D.length;L++)p.push(h[_])}return p},t.V=function(l){Pr(this);let h=[];if(typeof l=="string")N_(this,l)&&(h=h.concat(this.g.get(hs(this,l))));else{l=Array.from(this.g.values());for(let p=0;p<l.length;p++)h=h.concat(l[p])}return h},t.set=function(l,h){return Pr(this),this.i=null,l=hs(this,l),N_(this,l)&&(this.h-=this.g.get(l).length),this.g.set(l,[h]),this.h+=1,this},t.get=function(l,h){return l?(l=this.V(l),0<l.length?String(l[0]):h):h};function O_(l,h,p){b_(l,h),0<p.length&&(l.i=null,l.g.set(hs(l,h),P(p)),l.h+=p.length)}t.toString=function(){if(this.i)return this.i;if(!this.g)return"";const l=[],h=Array.from(this.g.keys());for(var p=0;p<h.length;p++){var _=h[p];const L=encodeURIComponent(String(_)),$=this.V(_);for(_=0;_<$.length;_++){var D=L;$[_]!==""&&(D+="="+encodeURIComponent(String($[_]))),l.push(D)}}return this.i=l.join("&")};function hs(l,h){return h=String(h),l.j&&(h=h.toLowerCase()),h}function rC(l,h){h&&!l.j&&(Pr(l),l.i=null,l.g.forEach(function(p,_){var D=_.toLowerCase();_!=D&&(b_(this,_),O_(this,D,p))},l)),l.j=h}function iC(l,h){const p=new No;if(a.Image){const _=new Image;_.onload=w(br,p,"TestLoadImage: loaded",!0,h,_),_.onerror=w(br,p,"TestLoadImage: error",!1,h,_),_.onabort=w(br,p,"TestLoadImage: abort",!1,h,_),_.ontimeout=w(br,p,"TestLoadImage: timeout",!1,h,_),a.setTimeout(function(){_.ontimeout&&_.ontimeout()},1e4),_.src=l}else h(!1)}function sC(l,h){const p=new No,_=new AbortController,D=setTimeout(()=>{_.abort(),br(p,"TestPingServer: timeout",!1,h)},1e4);fetch(l,{signal:_.signal}).then(L=>{clearTimeout(D),L.ok?br(p,"TestPingServer: ok",!0,h):br(p,"TestPingServer: server error",!1,h)}).catch(()=>{clearTimeout(D),br(p,"TestPingServer: error",!1,h)})}function br(l,h,p,_,D){try{D&&(D.onload=null,D.onerror=null,D.onabort=null,D.ontimeout=null),_(p)}catch{}}function oC(){this.g=new B1}function aC(l,h,p){const _=p||"";try{R_(l,function(D,L){let $=D;c(D)&&($=Fh(D)),h.push(_+L+"="+encodeURIComponent($))})}catch(D){throw h.push(_+"type="+encodeURIComponent("_badmap")),D}}function Bl(l){this.l=l.Ub||null,this.j=l.eb||!1}I(Bl,Uh),Bl.prototype.g=function(){return new $l(this.l,this.j)},Bl.prototype.i=function(l){return function(){return l}}({});function $l(l,h){st.call(this),this.D=l,this.o=h,this.m=void 0,this.status=this.readyState=0,this.responseType=this.responseText=this.response=this.statusText="",this.onreadystatechange=null,this.u=new Headers,this.h=null,this.B="GET",this.A="",this.g=!1,this.v=this.j=this.l=null}I($l,st),t=$l.prototype,t.open=function(l,h){if(this.readyState!=0)throw this.abort(),Error("Error reopening a connection");this.B=l,this.A=h,this.readyState=1,Fo(this)},t.send=function(l){if(this.readyState!=1)throw this.abort(),Error("need to call open() first. ");this.g=!0;const h={headers:this.u,method:this.B,credentials:this.m,cache:void 0};l&&(h.body=l),(this.D||a).fetch(new Request(this.A,h)).then(this.Sa.bind(this),this.ga.bind(this))},t.abort=function(){this.response=this.responseText="",this.u=new Headers,this.status=0,this.j&&this.j.cancel("Request was aborted.").catch(()=>{}),1<=this.readyState&&this.g&&this.readyState!=4&&(this.g=!1,Vo(this)),this.readyState=0},t.Sa=function(l){if(this.g&&(this.l=l,this.h||(this.status=this.l.status,this.statusText=this.l.statusText,this.h=l.headers,this.readyState=2,Fo(this)),this.g&&(this.readyState=3,Fo(this),this.g)))if(this.responseType==="arraybuffer")l.arrayBuffer().then(this.Qa.bind(this),this.ga.bind(this));else if(typeof a.ReadableStream<"u"&&"body"in l){if(this.j=l.body.getReader(),this.o){if(this.responseType)throw Error('responseType must be empty for "streamBinaryChunks" mode responses.');this.response=[]}else this.response=this.responseText="",this.v=new TextDecoder;D_(this)}else l.text().then(this.Ra.bind(this),this.ga.bind(this))};function D_(l){l.j.read().then(l.Pa.bind(l)).catch(l.ga.bind(l))}t.Pa=function(l){if(this.g){if(this.o&&l.value)this.response.push(l.value);else if(!this.o){var h=l.value?l.value:new Uint8Array(0);(h=this.v.decode(h,{stream:!l.done}))&&(this.response=this.responseText+=h)}l.done?Vo(this):Fo(this),this.readyState==3&&D_(this)}},t.Ra=function(l){this.g&&(this.response=this.responseText=l,Vo(this))},t.Qa=function(l){this.g&&(this.response=l,Vo(this))},t.ga=function(){this.g&&Vo(this)};function Vo(l){l.readyState=4,l.l=null,l.j=null,l.v=null,Fo(l)}t.setRequestHeader=function(l,h){this.u.append(l,h)},t.getResponseHeader=function(l){return this.h&&this.h.get(l.toLowerCase())||""},t.getAllResponseHeaders=function(){if(!this.h)return"";const l=[],h=this.h.entries();for(var p=h.next();!p.done;)p=p.value,l.push(p[0]+": "+p[1]),p=h.next();return l.join(`\r
`)};function Fo(l){l.onreadystatechange&&l.onreadystatechange.call(l)}Object.defineProperty($l.prototype,"withCredentials",{get:function(){return this.m==="include"},set:function(l){this.m=l?"include":"same-origin"}});function M_(l){let h="";return F(l,function(p,_){h+=_,h+=":",h+=p,h+=`\r
`}),h}function Qh(l,h,p){e:{for(_ in p){var _=!1;break e}_=!0}_||(p=M_(p),typeof l=="string"?p!=null&&encodeURIComponent(String(p)):De(l,h,p))}function Ge(l){st.call(this),this.headers=new Map,this.o=l||null,this.h=!1,this.v=this.g=null,this.D="",this.m=0,this.l="",this.j=this.B=this.u=this.A=!1,this.I=null,this.H="",this.J=!1}I(Ge,st);var lC=/^https?$/i,uC=["POST","PUT"];t=Ge.prototype,t.Ha=function(l){this.J=l},t.ea=function(l,h,p,_){if(this.g)throw Error("[goog.net.XhrIo] Object is active with another request="+this.D+"; newUri="+l);h=h?h.toUpperCase():"GET",this.D=l,this.l="",this.m=0,this.A=!1,this.h=!0,this.g=this.o?this.o.g():Bh.g(),this.v=this.o?c_(this.o):c_(Bh),this.g.onreadystatechange=m(this.Ea,this);try{this.B=!0,this.g.open(h,String(l),!0),this.B=!1}catch(L){L_(this,L);return}if(l=p||"",p=new Map(this.headers),_)if(Object.getPrototypeOf(_)===Object.prototype)for(var D in _)p.set(D,_[D]);else if(typeof _.keys=="function"&&typeof _.get=="function")for(const L of _.keys())p.set(L,_.get(L));else throw Error("Unknown input type for opt_headers: "+String(_));_=Array.from(p.keys()).find(L=>L.toLowerCase()=="content-type"),D=a.FormData&&l instanceof a.FormData,!(0<=Array.prototype.indexOf.call(uC,h,void 0))||_||D||p.set("Content-Type","application/x-www-form-urlencoded;charset=utf-8");for(const[L,$]of p)this.g.setRequestHeader(L,$);this.H&&(this.g.responseType=this.H),"withCredentials"in this.g&&this.g.withCredentials!==this.J&&(this.g.withCredentials=this.J);try{U_(this),this.u=!0,this.g.send(l),this.u=!1}catch(L){L_(this,L)}};function L_(l,h){l.h=!1,l.g&&(l.j=!0,l.g.abort(),l.j=!1),l.l=h,l.m=5,V_(l),Wl(l)}function V_(l){l.A||(l.A=!0,_t(l,"complete"),_t(l,"error"))}t.abort=function(l){this.g&&this.h&&(this.h=!1,this.j=!0,this.g.abort(),this.j=!1,this.m=l||7,_t(this,"complete"),_t(this,"abort"),Wl(this))},t.N=function(){this.g&&(this.h&&(this.h=!1,this.j=!0,this.g.abort(),this.j=!1),Wl(this,!0)),Ge.aa.N.call(this)},t.Ea=function(){this.s||(this.B||this.u||this.j?F_(this):this.bb())},t.bb=function(){F_(this)};function F_(l){if(l.h&&typeof o<"u"&&(!l.v[1]||tr(l)!=4||l.Z()!=2)){if(l.u&&tr(l)==4)Co(l.Ea,0,l);else if(_t(l,"readystatechange"),tr(l)==4){l.h=!1;try{const $=l.Z();e:switch($){case 200:case 201:case 202:case 204:case 206:case 304:case 1223:var h=!0;break e;default:h=!1}var p;if(!(p=h)){var _;if(_=$===0){var D=String(l.D).match(A_)[1]||null;!D&&a.self&&a.self.location&&(D=a.self.location.protocol.slice(0,-1)),_=!lC.test(D?D.toLowerCase():"")}p=_}if(p)_t(l,"complete"),_t(l,"success");else{l.m=6;try{var L=2<tr(l)?l.g.statusText:""}catch{L=""}l.l=L+" ["+l.Z()+"]",V_(l)}}finally{Wl(l)}}}}function Wl(l,h){if(l.g){U_(l);const p=l.g,_=l.v[0]?()=>{}:null;l.g=null,l.v=null,h||_t(l,"ready");try{p.onreadystatechange=_}catch{}}}function U_(l){l.I&&(a.clearTimeout(l.I),l.I=null)}t.isActive=function(){return!!this.g};function tr(l){return l.g?l.g.readyState:0}t.Z=function(){try{return 2<tr(this)?this.g.status:-1}catch{return-1}},t.oa=function(){try{return this.g?this.g.responseText:""}catch{return""}},t.Oa=function(l){if(this.g){var h=this.g.responseText;return l&&h.indexOf(l)==0&&(h=h.substring(l.length)),z1(h)}};function j_(l){try{if(!l.g)return null;if("response"in l.g)return l.g.response;switch(l.H){case"":case"text":return l.g.responseText;case"arraybuffer":if("mozResponseArrayBuffer"in l.g)return l.g.mozResponseArrayBuffer}return null}catch{return null}}function cC(l){const h={};l=(l.g&&2<=tr(l)&&l.g.getAllResponseHeaders()||"").split(`\r
`);for(let _=0;_<l.length;_++){if(T(l[_]))continue;var p=x(l[_]);const D=p[0];if(p=p[1],typeof p!="string")continue;p=p.trim();const L=h[D]||[];h[D]=L,L.push(p)}y(h,function(_){return _.join(", ")})}t.Ba=function(){return this.m},t.Ka=function(){return typeof this.l=="string"?this.l:String(this.l)};function Uo(l,h,p){return p&&p.internalChannelParams&&p.internalChannelParams[l]||h}function z_(l){this.Aa=0,this.i=[],this.j=new No,this.ia=this.qa=this.I=this.W=this.g=this.ya=this.D=this.H=this.m=this.S=this.o=null,this.Ya=this.U=0,this.Va=Uo("failFast",!1,l),this.F=this.C=this.u=this.s=this.l=null,this.X=!0,this.za=this.T=-1,this.Y=this.v=this.B=0,this.Ta=Uo("baseRetryDelayMs",5e3,l),this.cb=Uo("retryDelaySeedMs",1e4,l),this.Wa=Uo("forwardChannelMaxRetries",2,l),this.wa=Uo("forwardChannelRequestTimeoutMs",2e4,l),this.pa=l&&l.xmlHttpFactory||void 0,this.Xa=l&&l.Tb||void 0,this.Ca=l&&l.useFetchStreams||!1,this.L=void 0,this.J=l&&l.supportsCrossDomainXhr||!1,this.K="",this.h=new T_(l&&l.concurrentRequestLimit),this.Da=new oC,this.P=l&&l.fastHandshake||!1,this.O=l&&l.encodeInitMessageHeaders||!1,this.P&&this.O&&(this.O=!1),this.Ua=l&&l.Rb||!1,l&&l.xa&&this.j.xa(),l&&l.forceLongPolling&&(this.X=!1),this.ba=!this.P&&this.X&&l&&l.detectBufferingProxy||!1,this.ja=void 0,l&&l.longPollingTimeout&&0<l.longPollingTimeout&&(this.ja=l.longPollingTimeout),this.ca=void 0,this.R=0,this.M=!1,this.ka=this.A=null}t=z_.prototype,t.la=8,t.G=1,t.connect=function(l,h,p,_){Ut(0),this.W=l,this.H=h||{},p&&_!==void 0&&(this.H.OSID=p,this.H.OAID=_),this.F=this.X,this.I=Y_(this,null,this.W),Hl(this)};function Yh(l){if(B_(l),l.G==3){var h=l.U++,p=er(l.I);if(De(p,"SID",l.K),De(p,"RID",h),De(p,"TYPE","terminate"),jo(l,p),h=new xr(l,l.j,h),h.L=2,h.v=zl(er(p)),p=!1,a.navigator&&a.navigator.sendBeacon)try{p=a.navigator.sendBeacon(h.v.toString(),"")}catch{}!p&&a.Image&&(new Image().src=h.v,p=!0),p||(h.g=X_(h.j,null),h.g.ea(h.v)),h.F=Date.now(),Fl(h)}Q_(l)}function ql(l){l.g&&(Jh(l),l.g.cancel(),l.g=null)}function B_(l){ql(l),l.u&&(a.clearTimeout(l.u),l.u=null),Gl(l),l.h.cancel(),l.s&&(typeof l.s=="number"&&a.clearTimeout(l.s),l.s=null)}function Hl(l){if(!I_(l.h)&&!l.s){l.s=!0;var h=l.Ga;et||b(),W||(et(),W=!0),X.add(h,l),l.B=0}}function hC(l,h){return S_(l.h)>=l.h.j-(l.s?1:0)?!1:l.s?(l.i=h.D.concat(l.i),!0):l.G==1||l.G==2||l.B>=(l.Va?0:l.Wa)?!1:(l.s=bo(m(l.Ga,l,h),K_(l,l.B)),l.B++,!0)}t.Ga=function(l){if(this.s)if(this.s=null,this.G==1){if(!l){this.U=Math.floor(1e5*Math.random()),l=this.U++;const D=new xr(this,this.j,l);let L=this.o;if(this.S&&(L?(L=g(L),k(L,this.S)):L=this.S),this.m!==null||this.O||(D.H=L,L=null),this.P)e:{for(var h=0,p=0;p<this.i.length;p++){t:{var _=this.i[p];if("__data__"in _.map&&(_=_.map.__data__,typeof _=="string")){_=_.length;break t}_=void 0}if(_===void 0)break;if(h+=_,4096<h){h=p;break e}if(h===4096||p===this.i.length-1){h=p+1;break e}}h=1e3}else h=1e3;h=W_(this,D,h),p=er(this.I),De(p,"RID",l),De(p,"CVER",22),this.D&&De(p,"X-HTTP-Session-Id",this.D),jo(this,p),L&&(this.O?h="headers="+encodeURIComponent(String(M_(L)))+"&"+h:this.m&&Qh(p,this.m,L)),Kh(this.h,D),this.Ua&&De(p,"TYPE","init"),this.P?(De(p,"$req",h),De(p,"SID","null"),D.T=!0,Wh(D,p,null)):Wh(D,p,h),this.G=2}}else this.G==3&&(l?$_(this,l):this.i.length==0||I_(this.h)||$_(this))};function $_(l,h){var p;h?p=h.l:p=l.U++;const _=er(l.I);De(_,"SID",l.K),De(_,"RID",p),De(_,"AID",l.T),jo(l,_),l.m&&l.o&&Qh(_,l.m,l.o),p=new xr(l,l.j,p,l.B+1),l.m===null&&(p.H=l.o),h&&(l.i=h.D.concat(l.i)),h=W_(l,p,1e3),p.I=Math.round(.5*l.wa)+Math.round(.5*l.wa*Math.random()),Kh(l.h,p),Wh(p,_,h)}function jo(l,h){l.H&&F(l.H,function(p,_){De(h,_,p)}),l.l&&R_({},function(p,_){De(h,_,p)})}function W_(l,h,p){p=Math.min(l.i.length,p);var _=l.l?m(l.l.Na,l.l,l):null;e:{var D=l.i;let L=-1;for(;;){const $=["count="+p];L==-1?0<p?(L=D[0].g,$.push("ofs="+L)):L=0:$.push("ofs="+L);let Pe=!0;for(let yt=0;yt<p;yt++){let _e=D[yt].g;const Rt=D[yt].map;if(_e-=L,0>_e)L=Math.max(0,D[yt].g-100),Pe=!1;else try{aC(Rt,$,"req"+_e+"_")}catch{_&&_(Rt)}}if(Pe){_=$.join("&");break e}}}return l=l.i.splice(0,p),h.D=l,_}function q_(l){if(!l.g&&!l.u){l.Y=1;var h=l.Fa;et||b(),W||(et(),W=!0),X.add(h,l),l.v=0}}function Xh(l){return l.g||l.u||3<=l.v?!1:(l.Y++,l.u=bo(m(l.Fa,l),K_(l,l.v)),l.v++,!0)}t.Fa=function(){if(this.u=null,H_(this),this.ba&&!(this.M||this.g==null||0>=this.R)){var l=2*this.R;this.j.info("BP detection timer enabled: "+l),this.A=bo(m(this.ab,this),l)}},t.ab=function(){this.A&&(this.A=null,this.j.info("BP detection timeout reached."),this.j.info("Buffering proxy detected and switch to long-polling!"),this.F=!1,this.M=!0,Ut(10),ql(this),H_(this))};function Jh(l){l.A!=null&&(a.clearTimeout(l.A),l.A=null)}function H_(l){l.g=new xr(l,l.j,"rpc",l.Y),l.m===null&&(l.g.H=l.o),l.g.O=0;var h=er(l.qa);De(h,"RID","rpc"),De(h,"SID",l.K),De(h,"AID",l.T),De(h,"CI",l.F?"0":"1"),!l.F&&l.ja&&De(h,"TO",l.ja),De(h,"TYPE","xmlhttp"),jo(l,h),l.m&&l.o&&Qh(h,l.m,l.o),l.L&&(l.g.I=l.L);var p=l.g;l=l.ia,p.L=1,p.v=zl(er(h)),p.m=null,p.P=!0,v_(p,l)}t.Za=function(){this.C!=null&&(this.C=null,ql(this),Xh(this),Ut(19))};function Gl(l){l.C!=null&&(a.clearTimeout(l.C),l.C=null)}function G_(l,h){var p=null;if(l.g==h){Gl(l),Jh(l),l.g=null;var _=2}else if(Gh(l.h,h))p=h.D,k_(l.h,h),_=1;else return;if(l.G!=0){if(h.o)if(_==1){p=h.m?h.m.length:0,h=Date.now()-h.F;var D=l.B;_=Ml(),_t(_,new m_(_,p)),Hl(l)}else q_(l);else if(D=h.s,D==3||D==0&&0<h.X||!(_==1&&hC(l,h)||_==2&&Xh(l)))switch(p&&0<p.length&&(h=l.h,h.i=h.i.concat(p)),D){case 1:Ii(l,5);break;case 4:Ii(l,10);break;case 3:Ii(l,6);break;default:Ii(l,2)}}}function K_(l,h){let p=l.Ta+Math.floor(Math.random()*l.cb);return l.isActive()||(p*=2),p*h}function Ii(l,h){if(l.j.info("Error code "+h),h==2){var p=m(l.fb,l),_=l.Xa;const D=!_;_=new Ti(_||"//www.google.com/images/cleardot.gif"),a.location&&a.location.protocol=="http"||Ul(_,"https"),zl(_),D?iC(_.toString(),p):sC(_.toString(),p)}else Ut(2);l.G=0,l.l&&l.l.sa(h),Q_(l),B_(l)}t.fb=function(l){l?(this.j.info("Successfully pinged google.com"),Ut(2)):(this.j.info("Failed to ping google.com"),Ut(1))};function Q_(l){if(l.G=0,l.ka=[],l.l){const h=C_(l.h);(h.length!=0||l.i.length!=0)&&(O(l.ka,h),O(l.ka,l.i),l.h.i.length=0,P(l.i),l.i.length=0),l.l.ra()}}function Y_(l,h,p){var _=p instanceof Ti?er(p):new Ti(p);if(_.g!="")h&&(_.g=h+"."+_.g),jl(_,_.s);else{var D=a.location;_=D.protocol,h=h?h+"."+D.hostname:D.hostname,D=+D.port;var L=new Ti(null);_&&Ul(L,_),h&&(L.g=h),D&&jl(L,D),p&&(L.l=p),_=L}return p=l.D,h=l.ya,p&&h&&De(_,p,h),De(_,"VER",l.la),jo(l,_),_}function X_(l,h,p){if(h&&!l.J)throw Error("Can't create secondary domain capable XhrIo object.");return h=l.Ca&&!l.pa?new Ge(new Bl({eb:p})):new Ge(l.pa),h.Ha(l.J),h}t.isActive=function(){return!!this.l&&this.l.isActive(this)};function J_(){}t=J_.prototype,t.ua=function(){},t.ta=function(){},t.sa=function(){},t.ra=function(){},t.isActive=function(){return!0},t.Na=function(){};function Kl(){}Kl.prototype.g=function(l,h){return new nn(l,h)};function nn(l,h){st.call(this),this.g=new z_(h),this.l=l,this.h=h&&h.messageUrlParams||null,l=h&&h.messageHeaders||null,h&&h.clientProtocolHeaderRequired&&(l?l["X-Client-Protocol"]="webchannel":l={"X-Client-Protocol":"webchannel"}),this.g.o=l,l=h&&h.initMessageHeaders||null,h&&h.messageContentType&&(l?l["X-WebChannel-Content-Type"]=h.messageContentType:l={"X-WebChannel-Content-Type":h.messageContentType}),h&&h.va&&(l?l["X-WebChannel-Client-Profile"]=h.va:l={"X-WebChannel-Client-Profile":h.va}),this.g.S=l,(l=h&&h.Sb)&&!T(l)&&(this.g.m=l),this.v=h&&h.supportsCrossDomainXhr||!1,this.u=h&&h.sendRawJson||!1,(h=h&&h.httpSessionIdParam)&&!T(h)&&(this.g.D=h,l=this.h,l!==null&&h in l&&(l=this.h,h in l&&delete l[h])),this.j=new ds(this)}I(nn,st),nn.prototype.m=function(){this.g.l=this.j,this.v&&(this.g.J=!0),this.g.connect(this.l,this.h||void 0)},nn.prototype.close=function(){Yh(this.g)},nn.prototype.o=function(l){var h=this.g;if(typeof l=="string"){var p={};p.__data__=l,l=p}else this.u&&(p={},p.__data__=Fh(l),l=p);h.i.push(new K1(h.Ya++,l)),h.G==3&&Hl(h)},nn.prototype.N=function(){this.g.l=null,delete this.j,Yh(this.g),delete this.g,nn.aa.N.call(this)};function Z_(l){jh.call(this),l.__headers__&&(this.headers=l.__headers__,this.statusCode=l.__status__,delete l.__headers__,delete l.__status__);var h=l.__sm__;if(h){e:{for(const p in h){l=p;break e}l=void 0}(this.i=l)&&(l=this.i,h=h!==null&&l in h?h[l]:void 0),this.data=h}else this.data=l}I(Z_,jh);function ey(){zh.call(this),this.status=1}I(ey,zh);function ds(l){this.g=l}I(ds,J_),ds.prototype.ua=function(){_t(this.g,"a")},ds.prototype.ta=function(l){_t(this.g,new Z_(l))},ds.prototype.sa=function(l){_t(this.g,new ey)},ds.prototype.ra=function(){_t(this.g,"b")},Kl.prototype.createWebChannel=Kl.prototype.g,nn.prototype.send=nn.prototype.o,nn.prototype.open=nn.prototype.m,nn.prototype.close=nn.prototype.close,nI=function(){return new Kl},tI=function(){return Ml()},eI=wi,ep={mb:0,pb:1,qb:2,Jb:3,Ob:4,Lb:5,Mb:6,Kb:7,Ib:8,Nb:9,PROXY:10,NOPROXY:11,Gb:12,Cb:13,Db:14,Bb:15,Eb:16,Fb:17,ib:18,hb:19,jb:20},Ll.NO_ERROR=0,Ll.TIMEOUT=8,Ll.HTTP_ERROR=6,Lu=Ll,g_.COMPLETE="complete",ZT=g_,h_.EventType=xo,xo.OPEN="a",xo.CLOSE="b",xo.ERROR="c",xo.MESSAGE="d",st.prototype.listen=st.prototype.K,aa=h_,Ge.prototype.listenOnce=Ge.prototype.L,Ge.prototype.getLastError=Ge.prototype.Ka,Ge.prototype.getLastErrorCode=Ge.prototype.Ba,Ge.prototype.getStatus=Ge.prototype.Z,Ge.prototype.getResponseJson=Ge.prototype.Oa,Ge.prototype.getResponseText=Ge.prototype.oa,Ge.prototype.send=Ge.prototype.ea,Ge.prototype.setWithCredentials=Ge.prototype.Ha,JT=Ge}).apply(typeof fu<"u"?fu:typeof self<"u"?self:typeof window<"u"?window:{});const kv="@firebase/firestore";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Nt{constructor(e){this.uid=e}isAuthenticated(){return this.uid!=null}toKey(){return this.isAuthenticated()?"uid:"+this.uid:"anonymous-user"}isEqual(e){return e.uid===this.uid}}Nt.UNAUTHENTICATED=new Nt(null),Nt.GOOGLE_CREDENTIALS=new Nt("google-credentials-uid"),Nt.FIRST_PARTY=new Nt("first-party-uid"),Nt.MOCK_USER=new Nt("mock-user");/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let mo="10.14.0";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Wi=new ch("@firebase/firestore");function Qo(){return Wi.logLevel}function Y(t,...e){if(Wi.logLevel<=ce.DEBUG){const n=e.map(Lm);Wi.debug(`Firestore (${mo}): ${t}`,...n)}}function Er(t,...e){if(Wi.logLevel<=ce.ERROR){const n=e.map(Lm);Wi.error(`Firestore (${mo}): ${t}`,...n)}}function eo(t,...e){if(Wi.logLevel<=ce.WARN){const n=e.map(Lm);Wi.warn(`Firestore (${mo}): ${t}`,...n)}}function Lm(t){if(typeof t=="string")return t;try{/**
* @license
* Copyright 2020 Google LLC
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/return function(n){return JSON.stringify(n)}(t)}catch{return t}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function re(t="Unexpected state"){const e=`FIRESTORE (${mo}) INTERNAL ASSERTION FAILED: `+t;throw Er(e),new Error(e)}function Se(t,e){t||re()}function se(t,e){return t}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const U={OK:"ok",CANCELLED:"cancelled",UNKNOWN:"unknown",INVALID_ARGUMENT:"invalid-argument",DEADLINE_EXCEEDED:"deadline-exceeded",NOT_FOUND:"not-found",ALREADY_EXISTS:"already-exists",PERMISSION_DENIED:"permission-denied",UNAUTHENTICATED:"unauthenticated",RESOURCE_EXHAUSTED:"resource-exhausted",FAILED_PRECONDITION:"failed-precondition",ABORTED:"aborted",OUT_OF_RANGE:"out-of-range",UNIMPLEMENTED:"unimplemented",INTERNAL:"internal",UNAVAILABLE:"unavailable",DATA_LOSS:"data-loss"};class K extends Zn{constructor(e,n){super(e,n),this.code=e,this.message=n,this.toString=()=>`${this.name}: [code=${this.code}]: ${this.message}`}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ni{constructor(){this.promise=new Promise((e,n)=>{this.resolve=e,this.reject=n})}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class rI{constructor(e,n){this.user=n,this.type="OAuth",this.headers=new Map,this.headers.set("Authorization",`Bearer ${e}`)}}class HP{getToken(){return Promise.resolve(null)}invalidateToken(){}start(e,n){e.enqueueRetryable(()=>n(Nt.UNAUTHENTICATED))}shutdown(){}}class GP{constructor(e){this.token=e,this.changeListener=null}getToken(){return Promise.resolve(this.token)}invalidateToken(){}start(e,n){this.changeListener=n,e.enqueueRetryable(()=>n(this.token.user))}shutdown(){this.changeListener=null}}class KP{constructor(e){this.t=e,this.currentUser=Nt.UNAUTHENTICATED,this.i=0,this.forceRefresh=!1,this.auth=null}start(e,n){Se(this.o===void 0);let r=this.i;const i=u=>this.i!==r?(r=this.i,n(u)):Promise.resolve();let s=new ni;this.o=()=>{this.i++,this.currentUser=this.u(),s.resolve(),s=new ni,e.enqueueRetryable(()=>i(this.currentUser))};const o=()=>{const u=s;e.enqueueRetryable(async()=>{await u.promise,await i(this.currentUser)})},a=u=>{Y("FirebaseAuthCredentialsProvider","Auth detected"),this.auth=u,this.o&&(this.auth.addAuthTokenListener(this.o),o())};this.t.onInit(u=>a(u)),setTimeout(()=>{if(!this.auth){const u=this.t.getImmediate({optional:!0});u?a(u):(Y("FirebaseAuthCredentialsProvider","Auth not yet detected"),s.resolve(),s=new ni)}},0),o()}getToken(){const e=this.i,n=this.forceRefresh;return this.forceRefresh=!1,this.auth?this.auth.getToken(n).then(r=>this.i!==e?(Y("FirebaseAuthCredentialsProvider","getToken aborted due to token change."),this.getToken()):r?(Se(typeof r.accessToken=="string"),new rI(r.accessToken,this.currentUser)):null):Promise.resolve(null)}invalidateToken(){this.forceRefresh=!0}shutdown(){this.auth&&this.o&&this.auth.removeAuthTokenListener(this.o),this.o=void 0}u(){const e=this.auth&&this.auth.getUid();return Se(e===null||typeof e=="string"),new Nt(e)}}class QP{constructor(e,n,r){this.l=e,this.h=n,this.P=r,this.type="FirstParty",this.user=Nt.FIRST_PARTY,this.I=new Map}T(){return this.P?this.P():null}get headers(){this.I.set("X-Goog-AuthUser",this.l);const e=this.T();return e&&this.I.set("Authorization",e),this.h&&this.I.set("X-Goog-Iam-Authorization-Token",this.h),this.I}}class YP{constructor(e,n,r){this.l=e,this.h=n,this.P=r}getToken(){return Promise.resolve(new QP(this.l,this.h,this.P))}start(e,n){e.enqueueRetryable(()=>n(Nt.FIRST_PARTY))}shutdown(){}invalidateToken(){}}class XP{constructor(e){this.value=e,this.type="AppCheck",this.headers=new Map,e&&e.length>0&&this.headers.set("x-firebase-appcheck",this.value)}}class JP{constructor(e){this.A=e,this.forceRefresh=!1,this.appCheck=null,this.R=null}start(e,n){Se(this.o===void 0);const r=s=>{s.error!=null&&Y("FirebaseAppCheckTokenProvider",`Error getting App Check token; using placeholder token instead. Error: ${s.error.message}`);const o=s.token!==this.R;return this.R=s.token,Y("FirebaseAppCheckTokenProvider",`Received ${o?"new":"existing"} token.`),o?n(s.token):Promise.resolve()};this.o=s=>{e.enqueueRetryable(()=>r(s))};const i=s=>{Y("FirebaseAppCheckTokenProvider","AppCheck detected"),this.appCheck=s,this.o&&this.appCheck.addTokenListener(this.o)};this.A.onInit(s=>i(s)),setTimeout(()=>{if(!this.appCheck){const s=this.A.getImmediate({optional:!0});s?i(s):Y("FirebaseAppCheckTokenProvider","AppCheck not yet detected")}},0)}getToken(){const e=this.forceRefresh;return this.forceRefresh=!1,this.appCheck?this.appCheck.getToken(e).then(n=>n?(Se(typeof n.token=="string"),this.R=n.token,new XP(n.token)):null):Promise.resolve(null)}invalidateToken(){this.forceRefresh=!0}shutdown(){this.appCheck&&this.o&&this.appCheck.removeTokenListener(this.o),this.o=void 0}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function ZP(t){const e=typeof self<"u"&&(self.crypto||self.msCrypto),n=new Uint8Array(t);if(e&&typeof e.getRandomValues=="function")e.getRandomValues(n);else for(let r=0;r<t;r++)n[r]=Math.floor(256*Math.random());return n}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class iI{static newId(){const e="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",n=Math.floor(256/e.length)*e.length;let r="";for(;r.length<20;){const i=ZP(40);for(let s=0;s<i.length;++s)r.length<20&&i[s]<n&&(r+=e.charAt(i[s]%e.length))}return r}}function ye(t,e){return t<e?-1:t>e?1:0}function to(t,e,n){return t.length===e.length&&t.every((r,i)=>n(r,e[i]))}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ut{constructor(e,n){if(this.seconds=e,this.nanoseconds=n,n<0)throw new K(U.INVALID_ARGUMENT,"Timestamp nanoseconds out of range: "+n);if(n>=1e9)throw new K(U.INVALID_ARGUMENT,"Timestamp nanoseconds out of range: "+n);if(e<-62135596800)throw new K(U.INVALID_ARGUMENT,"Timestamp seconds out of range: "+e);if(e>=253402300800)throw new K(U.INVALID_ARGUMENT,"Timestamp seconds out of range: "+e)}static now(){return ut.fromMillis(Date.now())}static fromDate(e){return ut.fromMillis(e.getTime())}static fromMillis(e){const n=Math.floor(e/1e3),r=Math.floor(1e6*(e-1e3*n));return new ut(n,r)}toDate(){return new Date(this.toMillis())}toMillis(){return 1e3*this.seconds+this.nanoseconds/1e6}_compareTo(e){return this.seconds===e.seconds?ye(this.nanoseconds,e.nanoseconds):ye(this.seconds,e.seconds)}isEqual(e){return e.seconds===this.seconds&&e.nanoseconds===this.nanoseconds}toString(){return"Timestamp(seconds="+this.seconds+", nanoseconds="+this.nanoseconds+")"}toJSON(){return{seconds:this.seconds,nanoseconds:this.nanoseconds}}valueOf(){const e=this.seconds- -62135596800;return String(e).padStart(12,"0")+"."+String(this.nanoseconds).padStart(9,"0")}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ie{constructor(e){this.timestamp=e}static fromTimestamp(e){return new ie(e)}static min(){return new ie(new ut(0,0))}static max(){return new ie(new ut(253402300799,999999999))}compareTo(e){return this.timestamp._compareTo(e.timestamp)}isEqual(e){return this.timestamp.isEqual(e.timestamp)}toMicroseconds(){return 1e6*this.timestamp.seconds+this.timestamp.nanoseconds/1e3}toString(){return"SnapshotVersion("+this.timestamp.toString()+")"}toTimestamp(){return this.timestamp}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Xa{constructor(e,n,r){n===void 0?n=0:n>e.length&&re(),r===void 0?r=e.length-n:r>e.length-n&&re(),this.segments=e,this.offset=n,this.len=r}get length(){return this.len}isEqual(e){return Xa.comparator(this,e)===0}child(e){const n=this.segments.slice(this.offset,this.limit());return e instanceof Xa?e.forEach(r=>{n.push(r)}):n.push(e),this.construct(n)}limit(){return this.offset+this.length}popFirst(e){return e=e===void 0?1:e,this.construct(this.segments,this.offset+e,this.length-e)}popLast(){return this.construct(this.segments,this.offset,this.length-1)}firstSegment(){return this.segments[this.offset]}lastSegment(){return this.get(this.length-1)}get(e){return this.segments[this.offset+e]}isEmpty(){return this.length===0}isPrefixOf(e){if(e.length<this.length)return!1;for(let n=0;n<this.length;n++)if(this.get(n)!==e.get(n))return!1;return!0}isImmediateParentOf(e){if(this.length+1!==e.length)return!1;for(let n=0;n<this.length;n++)if(this.get(n)!==e.get(n))return!1;return!0}forEach(e){for(let n=this.offset,r=this.limit();n<r;n++)e(this.segments[n])}toArray(){return this.segments.slice(this.offset,this.limit())}static comparator(e,n){const r=Math.min(e.length,n.length);for(let i=0;i<r;i++){const s=e.get(i),o=n.get(i);if(s<o)return-1;if(s>o)return 1}return e.length<n.length?-1:e.length>n.length?1:0}}class Fe extends Xa{construct(e,n,r){return new Fe(e,n,r)}canonicalString(){return this.toArray().join("/")}toString(){return this.canonicalString()}toUriEncodedString(){return this.toArray().map(encodeURIComponent).join("/")}static fromString(...e){const n=[];for(const r of e){if(r.indexOf("//")>=0)throw new K(U.INVALID_ARGUMENT,`Invalid segment (${r}). Paths must not contain // in them.`);n.push(...r.split("/").filter(i=>i.length>0))}return new Fe(n)}static emptyPath(){return new Fe([])}}const eb=/^[_a-zA-Z][_a-zA-Z0-9]*$/;class Tt extends Xa{construct(e,n,r){return new Tt(e,n,r)}static isValidIdentifier(e){return eb.test(e)}canonicalString(){return this.toArray().map(e=>(e=e.replace(/\\/g,"\\\\").replace(/`/g,"\\`"),Tt.isValidIdentifier(e)||(e="`"+e+"`"),e)).join(".")}toString(){return this.canonicalString()}isKeyField(){return this.length===1&&this.get(0)==="__name__"}static keyField(){return new Tt(["__name__"])}static fromServerFormat(e){const n=[];let r="",i=0;const s=()=>{if(r.length===0)throw new K(U.INVALID_ARGUMENT,`Invalid field path (${e}). Paths must not be empty, begin with '.', end with '.', or contain '..'`);n.push(r),r=""};let o=!1;for(;i<e.length;){const a=e[i];if(a==="\\"){if(i+1===e.length)throw new K(U.INVALID_ARGUMENT,"Path has trailing escape character: "+e);const u=e[i+1];if(u!=="\\"&&u!=="."&&u!=="`")throw new K(U.INVALID_ARGUMENT,"Path has invalid escape sequence: "+e);r+=u,i+=2}else a==="`"?(o=!o,i++):a!=="."||o?(r+=a,i++):(s(),i++)}if(s(),o)throw new K(U.INVALID_ARGUMENT,"Unterminated ` in path: "+e);return new Tt(n)}static emptyPath(){return new Tt([])}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Z{constructor(e){this.path=e}static fromPath(e){return new Z(Fe.fromString(e))}static fromName(e){return new Z(Fe.fromString(e).popFirst(5))}static empty(){return new Z(Fe.emptyPath())}get collectionGroup(){return this.path.popLast().lastSegment()}hasCollectionId(e){return this.path.length>=2&&this.path.get(this.path.length-2)===e}getCollectionGroup(){return this.path.get(this.path.length-2)}getCollectionPath(){return this.path.popLast()}isEqual(e){return e!==null&&Fe.comparator(this.path,e.path)===0}toString(){return this.path.toString()}static comparator(e,n){return Fe.comparator(e.path,n.path)}static isDocumentKey(e){return e.length%2==0}static fromSegments(e){return new Z(new Fe(e.slice()))}}function tb(t,e){const n=t.toTimestamp().seconds,r=t.toTimestamp().nanoseconds+1,i=ie.fromTimestamp(r===1e9?new ut(n+1,0):new ut(n,r));return new ci(i,Z.empty(),e)}function nb(t){return new ci(t.readTime,t.key,-1)}class ci{constructor(e,n,r){this.readTime=e,this.documentKey=n,this.largestBatchId=r}static min(){return new ci(ie.min(),Z.empty(),-1)}static max(){return new ci(ie.max(),Z.empty(),-1)}}function rb(t,e){let n=t.readTime.compareTo(e.readTime);return n!==0?n:(n=Z.comparator(t.documentKey,e.documentKey),n!==0?n:ye(t.largestBatchId,e.largestBatchId))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const ib="The current tab is not in the required state to perform this operation. It might be necessary to refresh the browser tab.";class sb{constructor(){this.onCommittedListeners=[]}addOnCommittedListener(e){this.onCommittedListeners.push(e)}raiseOnCommittedEvent(){this.onCommittedListeners.forEach(e=>e())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function gl(t){if(t.code!==U.FAILED_PRECONDITION||t.message!==ib)throw t;Y("LocalStore","Unexpectedly lost primary lease")}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class j{constructor(e){this.nextCallback=null,this.catchCallback=null,this.result=void 0,this.error=void 0,this.isDone=!1,this.callbackAttached=!1,e(n=>{this.isDone=!0,this.result=n,this.nextCallback&&this.nextCallback(n)},n=>{this.isDone=!0,this.error=n,this.catchCallback&&this.catchCallback(n)})}catch(e){return this.next(void 0,e)}next(e,n){return this.callbackAttached&&re(),this.callbackAttached=!0,this.isDone?this.error?this.wrapFailure(n,this.error):this.wrapSuccess(e,this.result):new j((r,i)=>{this.nextCallback=s=>{this.wrapSuccess(e,s).next(r,i)},this.catchCallback=s=>{this.wrapFailure(n,s).next(r,i)}})}toPromise(){return new Promise((e,n)=>{this.next(e,n)})}wrapUserFunction(e){try{const n=e();return n instanceof j?n:j.resolve(n)}catch(n){return j.reject(n)}}wrapSuccess(e,n){return e?this.wrapUserFunction(()=>e(n)):j.resolve(n)}wrapFailure(e,n){return e?this.wrapUserFunction(()=>e(n)):j.reject(n)}static resolve(e){return new j((n,r)=>{n(e)})}static reject(e){return new j((n,r)=>{r(e)})}static waitFor(e){return new j((n,r)=>{let i=0,s=0,o=!1;e.forEach(a=>{++i,a.next(()=>{++s,o&&s===i&&n()},u=>r(u))}),o=!0,s===i&&n()})}static or(e){let n=j.resolve(!1);for(const r of e)n=n.next(i=>i?j.resolve(i):r());return n}static forEach(e,n){const r=[];return e.forEach((i,s)=>{r.push(n.call(this,i,s))}),this.waitFor(r)}static mapArray(e,n){return new j((r,i)=>{const s=e.length,o=new Array(s);let a=0;for(let u=0;u<s;u++){const c=u;n(e[c]).next(d=>{o[c]=d,++a,a===s&&r(o)},d=>i(d))}})}static doWhile(e,n){return new j((r,i)=>{const s=()=>{e()===!0?n().next(()=>{s()},i):r()};s()})}}function ob(t){const e=t.match(/Android ([\d.]+)/i),n=e?e[1].split(".").slice(0,2).join("."):"-1";return Number(n)}function _l(t){return t.name==="IndexedDbTransactionError"}/**
 * @license
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Vm{constructor(e,n){this.previousValue=e,n&&(n.sequenceNumberHandler=r=>this.ie(r),this.se=r=>n.writeSequenceNumber(r))}ie(e){return this.previousValue=Math.max(e,this.previousValue),this.previousValue}next(){const e=++this.previousValue;return this.se&&this.se(e),e}}Vm.oe=-1;function dh(t){return t==null}function Ec(t){return t===0&&1/t==-1/0}function ab(t){return typeof t=="number"&&Number.isInteger(t)&&!Ec(t)&&t<=Number.MAX_SAFE_INTEGER&&t>=Number.MIN_SAFE_INTEGER}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Cv(t){let e=0;for(const n in t)Object.prototype.hasOwnProperty.call(t,n)&&e++;return e}function go(t,e){for(const n in t)Object.prototype.hasOwnProperty.call(t,n)&&e(n,t[n])}function sI(t){for(const e in t)if(Object.prototype.hasOwnProperty.call(t,e))return!1;return!0}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let it=class tp{constructor(e,n){this.comparator=e,this.root=n||ri.EMPTY}insert(e,n){return new tp(this.comparator,this.root.insert(e,n,this.comparator).copy(null,null,ri.BLACK,null,null))}remove(e){return new tp(this.comparator,this.root.remove(e,this.comparator).copy(null,null,ri.BLACK,null,null))}get(e){let n=this.root;for(;!n.isEmpty();){const r=this.comparator(e,n.key);if(r===0)return n.value;r<0?n=n.left:r>0&&(n=n.right)}return null}indexOf(e){let n=0,r=this.root;for(;!r.isEmpty();){const i=this.comparator(e,r.key);if(i===0)return n+r.left.size;i<0?r=r.left:(n+=r.left.size+1,r=r.right)}return-1}isEmpty(){return this.root.isEmpty()}get size(){return this.root.size}minKey(){return this.root.minKey()}maxKey(){return this.root.maxKey()}inorderTraversal(e){return this.root.inorderTraversal(e)}forEach(e){this.inorderTraversal((n,r)=>(e(n,r),!1))}toString(){const e=[];return this.inorderTraversal((n,r)=>(e.push(`${n}:${r}`),!1)),`{${e.join(", ")}}`}reverseTraversal(e){return this.root.reverseTraversal(e)}getIterator(){return new pu(this.root,null,this.comparator,!1)}getIteratorFrom(e){return new pu(this.root,e,this.comparator,!1)}getReverseIterator(){return new pu(this.root,null,this.comparator,!0)}getReverseIteratorFrom(e){return new pu(this.root,e,this.comparator,!0)}},pu=class{constructor(e,n,r,i){this.isReverse=i,this.nodeStack=[];let s=1;for(;!e.isEmpty();)if(s=n?r(e.key,n):1,n&&i&&(s*=-1),s<0)e=this.isReverse?e.left:e.right;else{if(s===0){this.nodeStack.push(e);break}this.nodeStack.push(e),e=this.isReverse?e.right:e.left}}getNext(){let e=this.nodeStack.pop();const n={key:e.key,value:e.value};if(this.isReverse)for(e=e.left;!e.isEmpty();)this.nodeStack.push(e),e=e.right;else for(e=e.right;!e.isEmpty();)this.nodeStack.push(e),e=e.left;return n}hasNext(){return this.nodeStack.length>0}peek(){if(this.nodeStack.length===0)return null;const e=this.nodeStack[this.nodeStack.length-1];return{key:e.key,value:e.value}}},ri=class nr{constructor(e,n,r,i,s){this.key=e,this.value=n,this.color=r??nr.RED,this.left=i??nr.EMPTY,this.right=s??nr.EMPTY,this.size=this.left.size+1+this.right.size}copy(e,n,r,i,s){return new nr(e??this.key,n??this.value,r??this.color,i??this.left,s??this.right)}isEmpty(){return!1}inorderTraversal(e){return this.left.inorderTraversal(e)||e(this.key,this.value)||this.right.inorderTraversal(e)}reverseTraversal(e){return this.right.reverseTraversal(e)||e(this.key,this.value)||this.left.reverseTraversal(e)}min(){return this.left.isEmpty()?this:this.left.min()}minKey(){return this.min().key}maxKey(){return this.right.isEmpty()?this.key:this.right.maxKey()}insert(e,n,r){let i=this;const s=r(e,i.key);return i=s<0?i.copy(null,null,null,i.left.insert(e,n,r),null):s===0?i.copy(null,n,null,null,null):i.copy(null,null,null,null,i.right.insert(e,n,r)),i.fixUp()}removeMin(){if(this.left.isEmpty())return nr.EMPTY;let e=this;return e.left.isRed()||e.left.left.isRed()||(e=e.moveRedLeft()),e=e.copy(null,null,null,e.left.removeMin(),null),e.fixUp()}remove(e,n){let r,i=this;if(n(e,i.key)<0)i.left.isEmpty()||i.left.isRed()||i.left.left.isRed()||(i=i.moveRedLeft()),i=i.copy(null,null,null,i.left.remove(e,n),null);else{if(i.left.isRed()&&(i=i.rotateRight()),i.right.isEmpty()||i.right.isRed()||i.right.left.isRed()||(i=i.moveRedRight()),n(e,i.key)===0){if(i.right.isEmpty())return nr.EMPTY;r=i.right.min(),i=i.copy(r.key,r.value,null,null,i.right.removeMin())}i=i.copy(null,null,null,null,i.right.remove(e,n))}return i.fixUp()}isRed(){return this.color}fixUp(){let e=this;return e.right.isRed()&&!e.left.isRed()&&(e=e.rotateLeft()),e.left.isRed()&&e.left.left.isRed()&&(e=e.rotateRight()),e.left.isRed()&&e.right.isRed()&&(e=e.colorFlip()),e}moveRedLeft(){let e=this.colorFlip();return e.right.left.isRed()&&(e=e.copy(null,null,null,null,e.right.rotateRight()),e=e.rotateLeft(),e=e.colorFlip()),e}moveRedRight(){let e=this.colorFlip();return e.left.left.isRed()&&(e=e.rotateRight(),e=e.colorFlip()),e}rotateLeft(){const e=this.copy(null,null,nr.RED,null,this.right.left);return this.right.copy(null,null,this.color,e,null)}rotateRight(){const e=this.copy(null,null,nr.RED,this.left.right,null);return this.left.copy(null,null,this.color,null,e)}colorFlip(){const e=this.left.copy(null,null,!this.left.color,null,null),n=this.right.copy(null,null,!this.right.color,null,null);return this.copy(null,null,!this.color,e,n)}checkMaxDepth(){const e=this.check();return Math.pow(2,e)<=this.size+1}check(){if(this.isRed()&&this.left.isRed()||this.right.isRed())throw re();const e=this.left.check();if(e!==this.right.check())throw re();return e+(this.isRed()?0:1)}};ri.EMPTY=null,ri.RED=!0,ri.BLACK=!1;ri.EMPTY=new class{constructor(){this.size=0}get key(){throw re()}get value(){throw re()}get color(){throw re()}get left(){throw re()}get right(){throw re()}copy(e,n,r,i,s){return this}insert(e,n,r){return new ri(e,n)}remove(e,n){return this}isEmpty(){return!0}inorderTraversal(e){return!1}reverseTraversal(e){return!1}minKey(){return null}maxKey(){return null}isRed(){return!1}checkMaxDepth(){return!0}check(){return 0}};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class St{constructor(e){this.comparator=e,this.data=new it(this.comparator)}has(e){return this.data.get(e)!==null}first(){return this.data.minKey()}last(){return this.data.maxKey()}get size(){return this.data.size}indexOf(e){return this.data.indexOf(e)}forEach(e){this.data.inorderTraversal((n,r)=>(e(n),!1))}forEachInRange(e,n){const r=this.data.getIteratorFrom(e[0]);for(;r.hasNext();){const i=r.getNext();if(this.comparator(i.key,e[1])>=0)return;n(i.key)}}forEachWhile(e,n){let r;for(r=n!==void 0?this.data.getIteratorFrom(n):this.data.getIterator();r.hasNext();)if(!e(r.getNext().key))return}firstAfterOrEqual(e){const n=this.data.getIteratorFrom(e);return n.hasNext()?n.getNext().key:null}getIterator(){return new Rv(this.data.getIterator())}getIteratorFrom(e){return new Rv(this.data.getIteratorFrom(e))}add(e){return this.copy(this.data.remove(e).insert(e,!0))}delete(e){return this.has(e)?this.copy(this.data.remove(e)):this}isEmpty(){return this.data.isEmpty()}unionWith(e){let n=this;return n.size<e.size&&(n=e,e=this),e.forEach(r=>{n=n.add(r)}),n}isEqual(e){if(!(e instanceof St)||this.size!==e.size)return!1;const n=this.data.getIterator(),r=e.data.getIterator();for(;n.hasNext();){const i=n.getNext().key,s=r.getNext().key;if(this.comparator(i,s)!==0)return!1}return!0}toArray(){const e=[];return this.forEach(n=>{e.push(n)}),e}toString(){const e=[];return this.forEach(n=>e.push(n)),"SortedSet("+e.toString()+")"}copy(e){const n=new St(this.comparator);return n.data=e,n}}class Rv{constructor(e){this.iter=e}getNext(){return this.iter.getNext().key}hasNext(){return this.iter.hasNext()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Nn{constructor(e){this.fields=e,e.sort(Tt.comparator)}static empty(){return new Nn([])}unionWith(e){let n=new St(Tt.comparator);for(const r of this.fields)n=n.add(r);for(const r of e)n=n.add(r);return new Nn(n.toArray())}covers(e){for(const n of this.fields)if(n.isPrefixOf(e))return!0;return!1}isEqual(e){return to(this.fields,e.fields,(n,r)=>n.isEqual(r))}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class oI extends Error{constructor(){super(...arguments),this.name="Base64DecodeError"}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ct{constructor(e){this.binaryString=e}static fromBase64String(e){const n=function(i){try{return atob(i)}catch(s){throw typeof DOMException<"u"&&s instanceof DOMException?new oI("Invalid base64 string: "+s):s}}(e);return new Ct(n)}static fromUint8Array(e){const n=function(i){let s="";for(let o=0;o<i.length;++o)s+=String.fromCharCode(i[o]);return s}(e);return new Ct(n)}[Symbol.iterator](){let e=0;return{next:()=>e<this.binaryString.length?{value:this.binaryString.charCodeAt(e++),done:!1}:{value:void 0,done:!0}}}toBase64(){return function(n){return btoa(n)}(this.binaryString)}toUint8Array(){return function(n){const r=new Uint8Array(n.length);for(let i=0;i<n.length;i++)r[i]=n.charCodeAt(i);return r}(this.binaryString)}approximateByteSize(){return 2*this.binaryString.length}compareTo(e){return ye(this.binaryString,e.binaryString)}isEqual(e){return this.binaryString===e.binaryString}}Ct.EMPTY_BYTE_STRING=new Ct("");const lb=new RegExp(/^\d{4}-\d\d-\d\dT\d\d:\d\d:\d\d(?:\.(\d+))?Z$/);function hi(t){if(Se(!!t),typeof t=="string"){let e=0;const n=lb.exec(t);if(Se(!!n),n[1]){let i=n[1];i=(i+"000000000").substr(0,9),e=Number(i)}const r=new Date(t);return{seconds:Math.floor(r.getTime()/1e3),nanos:e}}return{seconds:Je(t.seconds),nanos:Je(t.nanos)}}function Je(t){return typeof t=="number"?t:typeof t=="string"?Number(t):0}function qi(t){return typeof t=="string"?Ct.fromBase64String(t):Ct.fromUint8Array(t)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Fm(t){var e,n;return((n=(((e=t==null?void 0:t.mapValue)===null||e===void 0?void 0:e.fields)||{}).__type__)===null||n===void 0?void 0:n.stringValue)==="server_timestamp"}function Um(t){const e=t.mapValue.fields.__previous_value__;return Fm(e)?Um(e):e}function Ja(t){const e=hi(t.mapValue.fields.__local_write_time__.timestampValue);return new ut(e.seconds,e.nanos)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ub{constructor(e,n,r,i,s,o,a,u,c){this.databaseId=e,this.appId=n,this.persistenceKey=r,this.host=i,this.ssl=s,this.forceLongPolling=o,this.autoDetectLongPolling=a,this.longPollingOptions=u,this.useFetchStreams=c}}class Za{constructor(e,n){this.projectId=e,this.database=n||"(default)"}static empty(){return new Za("","")}get isDefaultDatabase(){return this.database==="(default)"}isEqual(e){return e instanceof Za&&e.projectId===this.projectId&&e.database===this.database}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const mu={mapValue:{}};function Hi(t){return"nullValue"in t?0:"booleanValue"in t?1:"integerValue"in t||"doubleValue"in t?2:"timestampValue"in t?3:"stringValue"in t?5:"bytesValue"in t?6:"referenceValue"in t?7:"geoPointValue"in t?8:"arrayValue"in t?9:"mapValue"in t?Fm(t)?4:hb(t)?9007199254740991:cb(t)?10:11:re()}function Jn(t,e){if(t===e)return!0;const n=Hi(t);if(n!==Hi(e))return!1;switch(n){case 0:case 9007199254740991:return!0;case 1:return t.booleanValue===e.booleanValue;case 4:return Ja(t).isEqual(Ja(e));case 3:return function(i,s){if(typeof i.timestampValue=="string"&&typeof s.timestampValue=="string"&&i.timestampValue.length===s.timestampValue.length)return i.timestampValue===s.timestampValue;const o=hi(i.timestampValue),a=hi(s.timestampValue);return o.seconds===a.seconds&&o.nanos===a.nanos}(t,e);case 5:return t.stringValue===e.stringValue;case 6:return function(i,s){return qi(i.bytesValue).isEqual(qi(s.bytesValue))}(t,e);case 7:return t.referenceValue===e.referenceValue;case 8:return function(i,s){return Je(i.geoPointValue.latitude)===Je(s.geoPointValue.latitude)&&Je(i.geoPointValue.longitude)===Je(s.geoPointValue.longitude)}(t,e);case 2:return function(i,s){if("integerValue"in i&&"integerValue"in s)return Je(i.integerValue)===Je(s.integerValue);if("doubleValue"in i&&"doubleValue"in s){const o=Je(i.doubleValue),a=Je(s.doubleValue);return o===a?Ec(o)===Ec(a):isNaN(o)&&isNaN(a)}return!1}(t,e);case 9:return to(t.arrayValue.values||[],e.arrayValue.values||[],Jn);case 10:case 11:return function(i,s){const o=i.mapValue.fields||{},a=s.mapValue.fields||{};if(Cv(o)!==Cv(a))return!1;for(const u in o)if(o.hasOwnProperty(u)&&(a[u]===void 0||!Jn(o[u],a[u])))return!1;return!0}(t,e);default:return re()}}function el(t,e){return(t.values||[]).find(n=>Jn(n,e))!==void 0}function no(t,e){if(t===e)return 0;const n=Hi(t),r=Hi(e);if(n!==r)return ye(n,r);switch(n){case 0:case 9007199254740991:return 0;case 1:return ye(t.booleanValue,e.booleanValue);case 2:return function(s,o){const a=Je(s.integerValue||s.doubleValue),u=Je(o.integerValue||o.doubleValue);return a<u?-1:a>u?1:a===u?0:isNaN(a)?isNaN(u)?0:-1:1}(t,e);case 3:return Av(t.timestampValue,e.timestampValue);case 4:return Av(Ja(t),Ja(e));case 5:return ye(t.stringValue,e.stringValue);case 6:return function(s,o){const a=qi(s),u=qi(o);return a.compareTo(u)}(t.bytesValue,e.bytesValue);case 7:return function(s,o){const a=s.split("/"),u=o.split("/");for(let c=0;c<a.length&&c<u.length;c++){const d=ye(a[c],u[c]);if(d!==0)return d}return ye(a.length,u.length)}(t.referenceValue,e.referenceValue);case 8:return function(s,o){const a=ye(Je(s.latitude),Je(o.latitude));return a!==0?a:ye(Je(s.longitude),Je(o.longitude))}(t.geoPointValue,e.geoPointValue);case 9:return xv(t.arrayValue,e.arrayValue);case 10:return function(s,o){var a,u,c,d;const f=s.fields||{},m=o.fields||{},w=(a=f.value)===null||a===void 0?void 0:a.arrayValue,I=(u=m.value)===null||u===void 0?void 0:u.arrayValue,P=ye(((c=w==null?void 0:w.values)===null||c===void 0?void 0:c.length)||0,((d=I==null?void 0:I.values)===null||d===void 0?void 0:d.length)||0);return P!==0?P:xv(w,I)}(t.mapValue,e.mapValue);case 11:return function(s,o){if(s===mu.mapValue&&o===mu.mapValue)return 0;if(s===mu.mapValue)return 1;if(o===mu.mapValue)return-1;const a=s.fields||{},u=Object.keys(a),c=o.fields||{},d=Object.keys(c);u.sort(),d.sort();for(let f=0;f<u.length&&f<d.length;++f){const m=ye(u[f],d[f]);if(m!==0)return m;const w=no(a[u[f]],c[d[f]]);if(w!==0)return w}return ye(u.length,d.length)}(t.mapValue,e.mapValue);default:throw re()}}function Av(t,e){if(typeof t=="string"&&typeof e=="string"&&t.length===e.length)return ye(t,e);const n=hi(t),r=hi(e),i=ye(n.seconds,r.seconds);return i!==0?i:ye(n.nanos,r.nanos)}function xv(t,e){const n=t.values||[],r=e.values||[];for(let i=0;i<n.length&&i<r.length;++i){const s=no(n[i],r[i]);if(s)return s}return ye(n.length,r.length)}function ro(t){return np(t)}function np(t){return"nullValue"in t?"null":"booleanValue"in t?""+t.booleanValue:"integerValue"in t?""+t.integerValue:"doubleValue"in t?""+t.doubleValue:"timestampValue"in t?function(n){const r=hi(n);return`time(${r.seconds},${r.nanos})`}(t.timestampValue):"stringValue"in t?t.stringValue:"bytesValue"in t?function(n){return qi(n).toBase64()}(t.bytesValue):"referenceValue"in t?function(n){return Z.fromName(n).toString()}(t.referenceValue):"geoPointValue"in t?function(n){return`geo(${n.latitude},${n.longitude})`}(t.geoPointValue):"arrayValue"in t?function(n){let r="[",i=!0;for(const s of n.values||[])i?i=!1:r+=",",r+=np(s);return r+"]"}(t.arrayValue):"mapValue"in t?function(n){const r=Object.keys(n.fields||{}).sort();let i="{",s=!0;for(const o of r)s?s=!1:i+=",",i+=`${o}:${np(n.fields[o])}`;return i+"}"}(t.mapValue):re()}function Pv(t,e){return{referenceValue:`projects/${t.projectId}/databases/${t.database}/documents/${e.path.canonicalString()}`}}function rp(t){return!!t&&"integerValue"in t}function jm(t){return!!t&&"arrayValue"in t}function bv(t){return!!t&&"nullValue"in t}function Nv(t){return!!t&&"doubleValue"in t&&isNaN(Number(t.doubleValue))}function Vu(t){return!!t&&"mapValue"in t}function cb(t){var e,n;return((n=(((e=t==null?void 0:t.mapValue)===null||e===void 0?void 0:e.fields)||{}).__type__)===null||n===void 0?void 0:n.stringValue)==="__vector__"}function va(t){if(t.geoPointValue)return{geoPointValue:Object.assign({},t.geoPointValue)};if(t.timestampValue&&typeof t.timestampValue=="object")return{timestampValue:Object.assign({},t.timestampValue)};if(t.mapValue){const e={mapValue:{fields:{}}};return go(t.mapValue.fields,(n,r)=>e.mapValue.fields[n]=va(r)),e}if(t.arrayValue){const e={arrayValue:{values:[]}};for(let n=0;n<(t.arrayValue.values||[]).length;++n)e.arrayValue.values[n]=va(t.arrayValue.values[n]);return e}return Object.assign({},t)}function hb(t){return(((t.mapValue||{}).fields||{}).__type__||{}).stringValue==="__max__"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class pn{constructor(e){this.value=e}static empty(){return new pn({mapValue:{}})}field(e){if(e.isEmpty())return this.value;{let n=this.value;for(let r=0;r<e.length-1;++r)if(n=(n.mapValue.fields||{})[e.get(r)],!Vu(n))return null;return n=(n.mapValue.fields||{})[e.lastSegment()],n||null}}set(e,n){this.getFieldsMap(e.popLast())[e.lastSegment()]=va(n)}setAll(e){let n=Tt.emptyPath(),r={},i=[];e.forEach((o,a)=>{if(!n.isImmediateParentOf(a)){const u=this.getFieldsMap(n);this.applyChanges(u,r,i),r={},i=[],n=a.popLast()}o?r[a.lastSegment()]=va(o):i.push(a.lastSegment())});const s=this.getFieldsMap(n);this.applyChanges(s,r,i)}delete(e){const n=this.field(e.popLast());Vu(n)&&n.mapValue.fields&&delete n.mapValue.fields[e.lastSegment()]}isEqual(e){return Jn(this.value,e.value)}getFieldsMap(e){let n=this.value;n.mapValue.fields||(n.mapValue={fields:{}});for(let r=0;r<e.length;++r){let i=n.mapValue.fields[e.get(r)];Vu(i)&&i.mapValue.fields||(i={mapValue:{fields:{}}},n.mapValue.fields[e.get(r)]=i),n=i}return n.mapValue.fields}applyChanges(e,n,r){go(n,(i,s)=>e[i]=s);for(const i of r)delete e[i]}clone(){return new pn(va(this.value))}}function aI(t){const e=[];return go(t.fields,(n,r)=>{const i=new Tt([n]);if(Vu(r)){const s=aI(r.mapValue).fields;if(s.length===0)e.push(i);else for(const o of s)e.push(i.child(o))}else e.push(i)}),new Nn(e)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Dt{constructor(e,n,r,i,s,o,a){this.key=e,this.documentType=n,this.version=r,this.readTime=i,this.createTime=s,this.data=o,this.documentState=a}static newInvalidDocument(e){return new Dt(e,0,ie.min(),ie.min(),ie.min(),pn.empty(),0)}static newFoundDocument(e,n,r,i){return new Dt(e,1,n,ie.min(),r,i,0)}static newNoDocument(e,n){return new Dt(e,2,n,ie.min(),ie.min(),pn.empty(),0)}static newUnknownDocument(e,n){return new Dt(e,3,n,ie.min(),ie.min(),pn.empty(),2)}convertToFoundDocument(e,n){return!this.createTime.isEqual(ie.min())||this.documentType!==2&&this.documentType!==0||(this.createTime=e),this.version=e,this.documentType=1,this.data=n,this.documentState=0,this}convertToNoDocument(e){return this.version=e,this.documentType=2,this.data=pn.empty(),this.documentState=0,this}convertToUnknownDocument(e){return this.version=e,this.documentType=3,this.data=pn.empty(),this.documentState=2,this}setHasCommittedMutations(){return this.documentState=2,this}setHasLocalMutations(){return this.documentState=1,this.version=ie.min(),this}setReadTime(e){return this.readTime=e,this}get hasLocalMutations(){return this.documentState===1}get hasCommittedMutations(){return this.documentState===2}get hasPendingWrites(){return this.hasLocalMutations||this.hasCommittedMutations}isValidDocument(){return this.documentType!==0}isFoundDocument(){return this.documentType===1}isNoDocument(){return this.documentType===2}isUnknownDocument(){return this.documentType===3}isEqual(e){return e instanceof Dt&&this.key.isEqual(e.key)&&this.version.isEqual(e.version)&&this.documentType===e.documentType&&this.documentState===e.documentState&&this.data.isEqual(e.data)}mutableCopy(){return new Dt(this.key,this.documentType,this.version,this.readTime,this.createTime,this.data.clone(),this.documentState)}toString(){return`Document(${this.key}, ${this.version}, ${JSON.stringify(this.data.value)}, {createTime: ${this.createTime}}), {documentType: ${this.documentType}}), {documentState: ${this.documentState}})`}}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Tc{constructor(e,n){this.position=e,this.inclusive=n}}function Ov(t,e,n){let r=0;for(let i=0;i<t.position.length;i++){const s=e[i],o=t.position[i];if(s.field.isKeyField()?r=Z.comparator(Z.fromName(o.referenceValue),n.key):r=no(o,n.data.field(s.field)),s.dir==="desc"&&(r*=-1),r!==0)break}return r}function Dv(t,e){if(t===null)return e===null;if(e===null||t.inclusive!==e.inclusive||t.position.length!==e.position.length)return!1;for(let n=0;n<t.position.length;n++)if(!Jn(t.position[n],e.position[n]))return!1;return!0}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class tl{constructor(e,n="asc"){this.field=e,this.dir=n}}function db(t,e){return t.dir===e.dir&&t.field.isEqual(e.field)}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class lI{}class rt extends lI{constructor(e,n,r){super(),this.field=e,this.op=n,this.value=r}static create(e,n,r){return e.isKeyField()?n==="in"||n==="not-in"?this.createKeyFieldInFilter(e,n,r):new pb(e,n,r):n==="array-contains"?new _b(e,r):n==="in"?new yb(e,r):n==="not-in"?new vb(e,r):n==="array-contains-any"?new wb(e,r):new rt(e,n,r)}static createKeyFieldInFilter(e,n,r){return n==="in"?new mb(e,r):new gb(e,r)}matches(e){const n=e.data.field(this.field);return this.op==="!="?n!==null&&this.matchesComparison(no(n,this.value)):n!==null&&Hi(this.value)===Hi(n)&&this.matchesComparison(no(n,this.value))}matchesComparison(e){switch(this.op){case"<":return e<0;case"<=":return e<=0;case"==":return e===0;case"!=":return e!==0;case">":return e>0;case">=":return e>=0;default:return re()}}isInequality(){return["<","<=",">",">=","!=","not-in"].indexOf(this.op)>=0}getFlattenedFilters(){return[this]}getFilters(){return[this]}}class Fn extends lI{constructor(e,n){super(),this.filters=e,this.op=n,this.ae=null}static create(e,n){return new Fn(e,n)}matches(e){return uI(this)?this.filters.find(n=>!n.matches(e))===void 0:this.filters.find(n=>n.matches(e))!==void 0}getFlattenedFilters(){return this.ae!==null||(this.ae=this.filters.reduce((e,n)=>e.concat(n.getFlattenedFilters()),[])),this.ae}getFilters(){return Object.assign([],this.filters)}}function uI(t){return t.op==="and"}function cI(t){return fb(t)&&uI(t)}function fb(t){for(const e of t.filters)if(e instanceof Fn)return!1;return!0}function ip(t){if(t instanceof rt)return t.field.canonicalString()+t.op.toString()+ro(t.value);if(cI(t))return t.filters.map(e=>ip(e)).join(",");{const e=t.filters.map(n=>ip(n)).join(",");return`${t.op}(${e})`}}function hI(t,e){return t instanceof rt?function(r,i){return i instanceof rt&&r.op===i.op&&r.field.isEqual(i.field)&&Jn(r.value,i.value)}(t,e):t instanceof Fn?function(r,i){return i instanceof Fn&&r.op===i.op&&r.filters.length===i.filters.length?r.filters.reduce((s,o,a)=>s&&hI(o,i.filters[a]),!0):!1}(t,e):void re()}function dI(t){return t instanceof rt?function(n){return`${n.field.canonicalString()} ${n.op} ${ro(n.value)}`}(t):t instanceof Fn?function(n){return n.op.toString()+" {"+n.getFilters().map(dI).join(" ,")+"}"}(t):"Filter"}class pb extends rt{constructor(e,n,r){super(e,n,r),this.key=Z.fromName(r.referenceValue)}matches(e){const n=Z.comparator(e.key,this.key);return this.matchesComparison(n)}}class mb extends rt{constructor(e,n){super(e,"in",n),this.keys=fI("in",n)}matches(e){return this.keys.some(n=>n.isEqual(e.key))}}class gb extends rt{constructor(e,n){super(e,"not-in",n),this.keys=fI("not-in",n)}matches(e){return!this.keys.some(n=>n.isEqual(e.key))}}function fI(t,e){var n;return(((n=e.arrayValue)===null||n===void 0?void 0:n.values)||[]).map(r=>Z.fromName(r.referenceValue))}class _b extends rt{constructor(e,n){super(e,"array-contains",n)}matches(e){const n=e.data.field(this.field);return jm(n)&&el(n.arrayValue,this.value)}}class yb extends rt{constructor(e,n){super(e,"in",n)}matches(e){const n=e.data.field(this.field);return n!==null&&el(this.value.arrayValue,n)}}class vb extends rt{constructor(e,n){super(e,"not-in",n)}matches(e){if(el(this.value.arrayValue,{nullValue:"NULL_VALUE"}))return!1;const n=e.data.field(this.field);return n!==null&&!el(this.value.arrayValue,n)}}class wb extends rt{constructor(e,n){super(e,"array-contains-any",n)}matches(e){const n=e.data.field(this.field);return!(!jm(n)||!n.arrayValue.values)&&n.arrayValue.values.some(r=>el(this.value.arrayValue,r))}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Eb{constructor(e,n=null,r=[],i=[],s=null,o=null,a=null){this.path=e,this.collectionGroup=n,this.orderBy=r,this.filters=i,this.limit=s,this.startAt=o,this.endAt=a,this.ue=null}}function Mv(t,e=null,n=[],r=[],i=null,s=null,o=null){return new Eb(t,e,n,r,i,s,o)}function zm(t){const e=se(t);if(e.ue===null){let n=e.path.canonicalString();e.collectionGroup!==null&&(n+="|cg:"+e.collectionGroup),n+="|f:",n+=e.filters.map(r=>ip(r)).join(","),n+="|ob:",n+=e.orderBy.map(r=>function(s){return s.field.canonicalString()+s.dir}(r)).join(","),dh(e.limit)||(n+="|l:",n+=e.limit),e.startAt&&(n+="|lb:",n+=e.startAt.inclusive?"b:":"a:",n+=e.startAt.position.map(r=>ro(r)).join(",")),e.endAt&&(n+="|ub:",n+=e.endAt.inclusive?"a:":"b:",n+=e.endAt.position.map(r=>ro(r)).join(",")),e.ue=n}return e.ue}function Bm(t,e){if(t.limit!==e.limit||t.orderBy.length!==e.orderBy.length)return!1;for(let n=0;n<t.orderBy.length;n++)if(!db(t.orderBy[n],e.orderBy[n]))return!1;if(t.filters.length!==e.filters.length)return!1;for(let n=0;n<t.filters.length;n++)if(!hI(t.filters[n],e.filters[n]))return!1;return t.collectionGroup===e.collectionGroup&&!!t.path.isEqual(e.path)&&!!Dv(t.startAt,e.startAt)&&Dv(t.endAt,e.endAt)}function sp(t){return Z.isDocumentKey(t.path)&&t.collectionGroup===null&&t.filters.length===0}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class _o{constructor(e,n=null,r=[],i=[],s=null,o="F",a=null,u=null){this.path=e,this.collectionGroup=n,this.explicitOrderBy=r,this.filters=i,this.limit=s,this.limitType=o,this.startAt=a,this.endAt=u,this.ce=null,this.le=null,this.he=null,this.startAt,this.endAt}}function Tb(t,e,n,r,i,s,o,a){return new _o(t,e,n,r,i,s,o,a)}function pI(t){return new _o(t)}function Lv(t){return t.filters.length===0&&t.limit===null&&t.startAt==null&&t.endAt==null&&(t.explicitOrderBy.length===0||t.explicitOrderBy.length===1&&t.explicitOrderBy[0].field.isKeyField())}function mI(t){return t.collectionGroup!==null}function wa(t){const e=se(t);if(e.ce===null){e.ce=[];const n=new Set;for(const s of e.explicitOrderBy)e.ce.push(s),n.add(s.field.canonicalString());const r=e.explicitOrderBy.length>0?e.explicitOrderBy[e.explicitOrderBy.length-1].dir:"asc";(function(o){let a=new St(Tt.comparator);return o.filters.forEach(u=>{u.getFlattenedFilters().forEach(c=>{c.isInequality()&&(a=a.add(c.field))})}),a})(e).forEach(s=>{n.has(s.canonicalString())||s.isKeyField()||e.ce.push(new tl(s,r))}),n.has(Tt.keyField().canonicalString())||e.ce.push(new tl(Tt.keyField(),r))}return e.ce}function Gn(t){const e=se(t);return e.le||(e.le=Ib(e,wa(t))),e.le}function Ib(t,e){if(t.limitType==="F")return Mv(t.path,t.collectionGroup,e,t.filters,t.limit,t.startAt,t.endAt);{e=e.map(i=>{const s=i.dir==="desc"?"asc":"desc";return new tl(i.field,s)});const n=t.endAt?new Tc(t.endAt.position,t.endAt.inclusive):null,r=t.startAt?new Tc(t.startAt.position,t.startAt.inclusive):null;return Mv(t.path,t.collectionGroup,e,t.filters,t.limit,n,r)}}function op(t,e){const n=t.filters.concat([e]);return new _o(t.path,t.collectionGroup,t.explicitOrderBy.slice(),n,t.limit,t.limitType,t.startAt,t.endAt)}function ap(t,e,n){return new _o(t.path,t.collectionGroup,t.explicitOrderBy.slice(),t.filters.slice(),e,n,t.startAt,t.endAt)}function fh(t,e){return Bm(Gn(t),Gn(e))&&t.limitType===e.limitType}function gI(t){return`${zm(Gn(t))}|lt:${t.limitType}`}function _s(t){return`Query(target=${function(n){let r=n.path.canonicalString();return n.collectionGroup!==null&&(r+=" collectionGroup="+n.collectionGroup),n.filters.length>0&&(r+=`, filters: [${n.filters.map(i=>dI(i)).join(", ")}]`),dh(n.limit)||(r+=", limit: "+n.limit),n.orderBy.length>0&&(r+=`, orderBy: [${n.orderBy.map(i=>function(o){return`${o.field.canonicalString()} (${o.dir})`}(i)).join(", ")}]`),n.startAt&&(r+=", startAt: ",r+=n.startAt.inclusive?"b:":"a:",r+=n.startAt.position.map(i=>ro(i)).join(",")),n.endAt&&(r+=", endAt: ",r+=n.endAt.inclusive?"a:":"b:",r+=n.endAt.position.map(i=>ro(i)).join(",")),`Target(${r})`}(Gn(t))}; limitType=${t.limitType})`}function ph(t,e){return e.isFoundDocument()&&function(r,i){const s=i.key.path;return r.collectionGroup!==null?i.key.hasCollectionId(r.collectionGroup)&&r.path.isPrefixOf(s):Z.isDocumentKey(r.path)?r.path.isEqual(s):r.path.isImmediateParentOf(s)}(t,e)&&function(r,i){for(const s of wa(r))if(!s.field.isKeyField()&&i.data.field(s.field)===null)return!1;return!0}(t,e)&&function(r,i){for(const s of r.filters)if(!s.matches(i))return!1;return!0}(t,e)&&function(r,i){return!(r.startAt&&!function(o,a,u){const c=Ov(o,a,u);return o.inclusive?c<=0:c<0}(r.startAt,wa(r),i)||r.endAt&&!function(o,a,u){const c=Ov(o,a,u);return o.inclusive?c>=0:c>0}(r.endAt,wa(r),i))}(t,e)}function Sb(t){return t.collectionGroup||(t.path.length%2==1?t.path.lastSegment():t.path.get(t.path.length-2))}function _I(t){return(e,n)=>{let r=!1;for(const i of wa(t)){const s=kb(i,e,n);if(s!==0)return s;r=r||i.field.isKeyField()}return 0}}function kb(t,e,n){const r=t.field.isKeyField()?Z.comparator(e.key,n.key):function(s,o,a){const u=o.data.field(s),c=a.data.field(s);return u!==null&&c!==null?no(u,c):re()}(t.field,e,n);switch(t.dir){case"asc":return r;case"desc":return-1*r;default:return re()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class yo{constructor(e,n){this.mapKeyFn=e,this.equalsFn=n,this.inner={},this.innerSize=0}get(e){const n=this.mapKeyFn(e),r=this.inner[n];if(r!==void 0){for(const[i,s]of r)if(this.equalsFn(i,e))return s}}has(e){return this.get(e)!==void 0}set(e,n){const r=this.mapKeyFn(e),i=this.inner[r];if(i===void 0)return this.inner[r]=[[e,n]],void this.innerSize++;for(let s=0;s<i.length;s++)if(this.equalsFn(i[s][0],e))return void(i[s]=[e,n]);i.push([e,n]),this.innerSize++}delete(e){const n=this.mapKeyFn(e),r=this.inner[n];if(r===void 0)return!1;for(let i=0;i<r.length;i++)if(this.equalsFn(r[i][0],e))return r.length===1?delete this.inner[n]:r.splice(i,1),this.innerSize--,!0;return!1}forEach(e){go(this.inner,(n,r)=>{for(const[i,s]of r)e(i,s)})}isEmpty(){return sI(this.inner)}size(){return this.innerSize}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Cb=new it(Z.comparator);function Tr(){return Cb}const yI=new it(Z.comparator);function la(...t){let e=yI;for(const n of t)e=e.insert(n.key,n);return e}function vI(t){let e=yI;return t.forEach((n,r)=>e=e.insert(n,r.overlayedDocument)),e}function Ni(){return Ea()}function wI(){return Ea()}function Ea(){return new yo(t=>t.toString(),(t,e)=>t.isEqual(e))}const Rb=new it(Z.comparator),Ab=new St(Z.comparator);function de(...t){let e=Ab;for(const n of t)e=e.add(n);return e}const xb=new St(ye);function Pb(){return xb}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function $m(t,e){if(t.useProto3Json){if(isNaN(e))return{doubleValue:"NaN"};if(e===1/0)return{doubleValue:"Infinity"};if(e===-1/0)return{doubleValue:"-Infinity"}}return{doubleValue:Ec(e)?"-0":e}}function EI(t){return{integerValue:""+t}}function bb(t,e){return ab(e)?EI(e):$m(t,e)}/**
 * @license
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class mh{constructor(){this._=void 0}}function Nb(t,e,n){return t instanceof nl?function(i,s){const o={fields:{__type__:{stringValue:"server_timestamp"},__local_write_time__:{timestampValue:{seconds:i.seconds,nanos:i.nanoseconds}}}};return s&&Fm(s)&&(s=Um(s)),s&&(o.fields.__previous_value__=s),{mapValue:o}}(n,e):t instanceof rl?II(t,e):t instanceof il?SI(t,e):function(i,s){const o=TI(i,s),a=Vv(o)+Vv(i.Pe);return rp(o)&&rp(i.Pe)?EI(a):$m(i.serializer,a)}(t,e)}function Ob(t,e,n){return t instanceof rl?II(t,e):t instanceof il?SI(t,e):n}function TI(t,e){return t instanceof Ic?function(r){return rp(r)||function(s){return!!s&&"doubleValue"in s}(r)}(e)?e:{integerValue:0}:null}class nl extends mh{}class rl extends mh{constructor(e){super(),this.elements=e}}function II(t,e){const n=kI(e);for(const r of t.elements)n.some(i=>Jn(i,r))||n.push(r);return{arrayValue:{values:n}}}class il extends mh{constructor(e){super(),this.elements=e}}function SI(t,e){let n=kI(e);for(const r of t.elements)n=n.filter(i=>!Jn(i,r));return{arrayValue:{values:n}}}class Ic extends mh{constructor(e,n){super(),this.serializer=e,this.Pe=n}}function Vv(t){return Je(t.integerValue||t.doubleValue)}function kI(t){return jm(t)&&t.arrayValue.values?t.arrayValue.values.slice():[]}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Db{constructor(e,n){this.field=e,this.transform=n}}function Mb(t,e){return t.field.isEqual(e.field)&&function(r,i){return r instanceof rl&&i instanceof rl||r instanceof il&&i instanceof il?to(r.elements,i.elements,Jn):r instanceof Ic&&i instanceof Ic?Jn(r.Pe,i.Pe):r instanceof nl&&i instanceof nl}(t.transform,e.transform)}class Lb{constructor(e,n){this.version=e,this.transformResults=n}}class Kn{constructor(e,n){this.updateTime=e,this.exists=n}static none(){return new Kn}static exists(e){return new Kn(void 0,e)}static updateTime(e){return new Kn(e)}get isNone(){return this.updateTime===void 0&&this.exists===void 0}isEqual(e){return this.exists===e.exists&&(this.updateTime?!!e.updateTime&&this.updateTime.isEqual(e.updateTime):!e.updateTime)}}function Fu(t,e){return t.updateTime!==void 0?e.isFoundDocument()&&e.version.isEqual(t.updateTime):t.exists===void 0||t.exists===e.isFoundDocument()}class gh{}function CI(t,e){if(!t.hasLocalMutations||e&&e.fields.length===0)return null;if(e===null)return t.isNoDocument()?new Wm(t.key,Kn.none()):new yl(t.key,t.data,Kn.none());{const n=t.data,r=pn.empty();let i=new St(Tt.comparator);for(let s of e.fields)if(!i.has(s)){let o=n.field(s);o===null&&s.length>1&&(s=s.popLast(),o=n.field(s)),o===null?r.delete(s):r.set(s,o),i=i.add(s)}return new ts(t.key,r,new Nn(i.toArray()),Kn.none())}}function Vb(t,e,n){t instanceof yl?function(i,s,o){const a=i.value.clone(),u=Uv(i.fieldTransforms,s,o.transformResults);a.setAll(u),s.convertToFoundDocument(o.version,a).setHasCommittedMutations()}(t,e,n):t instanceof ts?function(i,s,o){if(!Fu(i.precondition,s))return void s.convertToUnknownDocument(o.version);const a=Uv(i.fieldTransforms,s,o.transformResults),u=s.data;u.setAll(RI(i)),u.setAll(a),s.convertToFoundDocument(o.version,u).setHasCommittedMutations()}(t,e,n):function(i,s,o){s.convertToNoDocument(o.version).setHasCommittedMutations()}(0,e,n)}function Ta(t,e,n,r){return t instanceof yl?function(s,o,a,u){if(!Fu(s.precondition,o))return a;const c=s.value.clone(),d=jv(s.fieldTransforms,u,o);return c.setAll(d),o.convertToFoundDocument(o.version,c).setHasLocalMutations(),null}(t,e,n,r):t instanceof ts?function(s,o,a,u){if(!Fu(s.precondition,o))return a;const c=jv(s.fieldTransforms,u,o),d=o.data;return d.setAll(RI(s)),d.setAll(c),o.convertToFoundDocument(o.version,d).setHasLocalMutations(),a===null?null:a.unionWith(s.fieldMask.fields).unionWith(s.fieldTransforms.map(f=>f.field))}(t,e,n,r):function(s,o,a){return Fu(s.precondition,o)?(o.convertToNoDocument(o.version).setHasLocalMutations(),null):a}(t,e,n)}function Fb(t,e){let n=null;for(const r of t.fieldTransforms){const i=e.data.field(r.field),s=TI(r.transform,i||null);s!=null&&(n===null&&(n=pn.empty()),n.set(r.field,s))}return n||null}function Fv(t,e){return t.type===e.type&&!!t.key.isEqual(e.key)&&!!t.precondition.isEqual(e.precondition)&&!!function(r,i){return r===void 0&&i===void 0||!(!r||!i)&&to(r,i,(s,o)=>Mb(s,o))}(t.fieldTransforms,e.fieldTransforms)&&(t.type===0?t.value.isEqual(e.value):t.type!==1||t.data.isEqual(e.data)&&t.fieldMask.isEqual(e.fieldMask))}class yl extends gh{constructor(e,n,r,i=[]){super(),this.key=e,this.value=n,this.precondition=r,this.fieldTransforms=i,this.type=0}getFieldMask(){return null}}class ts extends gh{constructor(e,n,r,i,s=[]){super(),this.key=e,this.data=n,this.fieldMask=r,this.precondition=i,this.fieldTransforms=s,this.type=1}getFieldMask(){return this.fieldMask}}function RI(t){const e=new Map;return t.fieldMask.fields.forEach(n=>{if(!n.isEmpty()){const r=t.data.field(n);e.set(n,r)}}),e}function Uv(t,e,n){const r=new Map;Se(t.length===n.length);for(let i=0;i<n.length;i++){const s=t[i],o=s.transform,a=e.data.field(s.field);r.set(s.field,Ob(o,a,n[i]))}return r}function jv(t,e,n){const r=new Map;for(const i of t){const s=i.transform,o=n.data.field(i.field);r.set(i.field,Nb(s,o,e))}return r}class Wm extends gh{constructor(e,n){super(),this.key=e,this.precondition=n,this.type=2,this.fieldTransforms=[]}getFieldMask(){return null}}class Ub extends gh{constructor(e,n){super(),this.key=e,this.precondition=n,this.type=3,this.fieldTransforms=[]}getFieldMask(){return null}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jb{constructor(e,n,r,i){this.batchId=e,this.localWriteTime=n,this.baseMutations=r,this.mutations=i}applyToRemoteDocument(e,n){const r=n.mutationResults;for(let i=0;i<this.mutations.length;i++){const s=this.mutations[i];s.key.isEqual(e.key)&&Vb(s,e,r[i])}}applyToLocalView(e,n){for(const r of this.baseMutations)r.key.isEqual(e.key)&&(n=Ta(r,e,n,this.localWriteTime));for(const r of this.mutations)r.key.isEqual(e.key)&&(n=Ta(r,e,n,this.localWriteTime));return n}applyToLocalDocumentSet(e,n){const r=wI();return this.mutations.forEach(i=>{const s=e.get(i.key),o=s.overlayedDocument;let a=this.applyToLocalView(o,s.mutatedFields);a=n.has(i.key)?null:a;const u=CI(o,a);u!==null&&r.set(i.key,u),o.isValidDocument()||o.convertToNoDocument(ie.min())}),r}keys(){return this.mutations.reduce((e,n)=>e.add(n.key),de())}isEqual(e){return this.batchId===e.batchId&&to(this.mutations,e.mutations,(n,r)=>Fv(n,r))&&to(this.baseMutations,e.baseMutations,(n,r)=>Fv(n,r))}}class qm{constructor(e,n,r,i){this.batch=e,this.commitVersion=n,this.mutationResults=r,this.docVersions=i}static from(e,n,r){Se(e.mutations.length===r.length);let i=function(){return Rb}();const s=e.mutations;for(let o=0;o<s.length;o++)i=i.insert(s[o].key,r[o].version);return new qm(e,n,r,i)}}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zb{constructor(e,n){this.largestBatchId=e,this.mutation=n}getKey(){return this.mutation.key}isEqual(e){return e!==null&&this.mutation===e.mutation}toString(){return`Overlay{
      largestBatchId: ${this.largestBatchId},
      mutation: ${this.mutation.toString()}
    }`}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Bb{constructor(e,n){this.count=e,this.unchangedNames=n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */var tt,pe;function $b(t){switch(t){default:return re();case U.CANCELLED:case U.UNKNOWN:case U.DEADLINE_EXCEEDED:case U.RESOURCE_EXHAUSTED:case U.INTERNAL:case U.UNAVAILABLE:case U.UNAUTHENTICATED:return!1;case U.INVALID_ARGUMENT:case U.NOT_FOUND:case U.ALREADY_EXISTS:case U.PERMISSION_DENIED:case U.FAILED_PRECONDITION:case U.ABORTED:case U.OUT_OF_RANGE:case U.UNIMPLEMENTED:case U.DATA_LOSS:return!0}}function AI(t){if(t===void 0)return Er("GRPC error has no .code"),U.UNKNOWN;switch(t){case tt.OK:return U.OK;case tt.CANCELLED:return U.CANCELLED;case tt.UNKNOWN:return U.UNKNOWN;case tt.DEADLINE_EXCEEDED:return U.DEADLINE_EXCEEDED;case tt.RESOURCE_EXHAUSTED:return U.RESOURCE_EXHAUSTED;case tt.INTERNAL:return U.INTERNAL;case tt.UNAVAILABLE:return U.UNAVAILABLE;case tt.UNAUTHENTICATED:return U.UNAUTHENTICATED;case tt.INVALID_ARGUMENT:return U.INVALID_ARGUMENT;case tt.NOT_FOUND:return U.NOT_FOUND;case tt.ALREADY_EXISTS:return U.ALREADY_EXISTS;case tt.PERMISSION_DENIED:return U.PERMISSION_DENIED;case tt.FAILED_PRECONDITION:return U.FAILED_PRECONDITION;case tt.ABORTED:return U.ABORTED;case tt.OUT_OF_RANGE:return U.OUT_OF_RANGE;case tt.UNIMPLEMENTED:return U.UNIMPLEMENTED;case tt.DATA_LOSS:return U.DATA_LOSS;default:return re()}}(pe=tt||(tt={}))[pe.OK=0]="OK",pe[pe.CANCELLED=1]="CANCELLED",pe[pe.UNKNOWN=2]="UNKNOWN",pe[pe.INVALID_ARGUMENT=3]="INVALID_ARGUMENT",pe[pe.DEADLINE_EXCEEDED=4]="DEADLINE_EXCEEDED",pe[pe.NOT_FOUND=5]="NOT_FOUND",pe[pe.ALREADY_EXISTS=6]="ALREADY_EXISTS",pe[pe.PERMISSION_DENIED=7]="PERMISSION_DENIED",pe[pe.UNAUTHENTICATED=16]="UNAUTHENTICATED",pe[pe.RESOURCE_EXHAUSTED=8]="RESOURCE_EXHAUSTED",pe[pe.FAILED_PRECONDITION=9]="FAILED_PRECONDITION",pe[pe.ABORTED=10]="ABORTED",pe[pe.OUT_OF_RANGE=11]="OUT_OF_RANGE",pe[pe.UNIMPLEMENTED=12]="UNIMPLEMENTED",pe[pe.INTERNAL=13]="INTERNAL",pe[pe.UNAVAILABLE=14]="UNAVAILABLE",pe[pe.DATA_LOSS=15]="DATA_LOSS";/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Wb(){return new TextEncoder}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const qb=new Vi([4294967295,4294967295],0);function zv(t){const e=Wb().encode(t),n=new XT;return n.update(e),new Uint8Array(n.digest())}function Bv(t){const e=new DataView(t.buffer),n=e.getUint32(0,!0),r=e.getUint32(4,!0),i=e.getUint32(8,!0),s=e.getUint32(12,!0);return[new Vi([n,r],0),new Vi([i,s],0)]}class Hm{constructor(e,n,r){if(this.bitmap=e,this.padding=n,this.hashCount=r,n<0||n>=8)throw new ua(`Invalid padding: ${n}`);if(r<0)throw new ua(`Invalid hash count: ${r}`);if(e.length>0&&this.hashCount===0)throw new ua(`Invalid hash count: ${r}`);if(e.length===0&&n!==0)throw new ua(`Invalid padding when bitmap length is 0: ${n}`);this.Ie=8*e.length-n,this.Te=Vi.fromNumber(this.Ie)}Ee(e,n,r){let i=e.add(n.multiply(Vi.fromNumber(r)));return i.compare(qb)===1&&(i=new Vi([i.getBits(0),i.getBits(1)],0)),i.modulo(this.Te).toNumber()}de(e){return(this.bitmap[Math.floor(e/8)]&1<<e%8)!=0}mightContain(e){if(this.Ie===0)return!1;const n=zv(e),[r,i]=Bv(n);for(let s=0;s<this.hashCount;s++){const o=this.Ee(r,i,s);if(!this.de(o))return!1}return!0}static create(e,n,r){const i=e%8==0?0:8-e%8,s=new Uint8Array(Math.ceil(e/8)),o=new Hm(s,i,n);return r.forEach(a=>o.insert(a)),o}insert(e){if(this.Ie===0)return;const n=zv(e),[r,i]=Bv(n);for(let s=0;s<this.hashCount;s++){const o=this.Ee(r,i,s);this.Ae(o)}}Ae(e){const n=Math.floor(e/8),r=e%8;this.bitmap[n]|=1<<r}}class ua extends Error{constructor(){super(...arguments),this.name="BloomFilterError"}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class _h{constructor(e,n,r,i,s){this.snapshotVersion=e,this.targetChanges=n,this.targetMismatches=r,this.documentUpdates=i,this.resolvedLimboDocuments=s}static createSynthesizedRemoteEventForCurrentChange(e,n,r){const i=new Map;return i.set(e,vl.createSynthesizedTargetChangeForCurrentChange(e,n,r)),new _h(ie.min(),i,new it(ye),Tr(),de())}}class vl{constructor(e,n,r,i,s){this.resumeToken=e,this.current=n,this.addedDocuments=r,this.modifiedDocuments=i,this.removedDocuments=s}static createSynthesizedTargetChangeForCurrentChange(e,n,r){return new vl(r,n,de(),de(),de())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Uu{constructor(e,n,r,i){this.Re=e,this.removedTargetIds=n,this.key=r,this.Ve=i}}class xI{constructor(e,n){this.targetId=e,this.me=n}}class PI{constructor(e,n,r=Ct.EMPTY_BYTE_STRING,i=null){this.state=e,this.targetIds=n,this.resumeToken=r,this.cause=i}}class $v{constructor(){this.fe=0,this.ge=qv(),this.pe=Ct.EMPTY_BYTE_STRING,this.ye=!1,this.we=!0}get current(){return this.ye}get resumeToken(){return this.pe}get Se(){return this.fe!==0}get be(){return this.we}De(e){e.approximateByteSize()>0&&(this.we=!0,this.pe=e)}ve(){let e=de(),n=de(),r=de();return this.ge.forEach((i,s)=>{switch(s){case 0:e=e.add(i);break;case 2:n=n.add(i);break;case 1:r=r.add(i);break;default:re()}}),new vl(this.pe,this.ye,e,n,r)}Ce(){this.we=!1,this.ge=qv()}Fe(e,n){this.we=!0,this.ge=this.ge.insert(e,n)}Me(e){this.we=!0,this.ge=this.ge.remove(e)}xe(){this.fe+=1}Oe(){this.fe-=1,Se(this.fe>=0)}Ne(){this.we=!0,this.ye=!0}}class Hb{constructor(e){this.Le=e,this.Be=new Map,this.ke=Tr(),this.qe=Wv(),this.Qe=new it(ye)}Ke(e){for(const n of e.Re)e.Ve&&e.Ve.isFoundDocument()?this.$e(n,e.Ve):this.Ue(n,e.key,e.Ve);for(const n of e.removedTargetIds)this.Ue(n,e.key,e.Ve)}We(e){this.forEachTarget(e,n=>{const r=this.Ge(n);switch(e.state){case 0:this.ze(n)&&r.De(e.resumeToken);break;case 1:r.Oe(),r.Se||r.Ce(),r.De(e.resumeToken);break;case 2:r.Oe(),r.Se||this.removeTarget(n);break;case 3:this.ze(n)&&(r.Ne(),r.De(e.resumeToken));break;case 4:this.ze(n)&&(this.je(n),r.De(e.resumeToken));break;default:re()}})}forEachTarget(e,n){e.targetIds.length>0?e.targetIds.forEach(n):this.Be.forEach((r,i)=>{this.ze(i)&&n(i)})}He(e){const n=e.targetId,r=e.me.count,i=this.Je(n);if(i){const s=i.target;if(sp(s))if(r===0){const o=new Z(s.path);this.Ue(n,o,Dt.newNoDocument(o,ie.min()))}else Se(r===1);else{const o=this.Ye(n);if(o!==r){const a=this.Ze(e),u=a?this.Xe(a,e,o):1;if(u!==0){this.je(n);const c=u===2?"TargetPurposeExistenceFilterMismatchBloom":"TargetPurposeExistenceFilterMismatch";this.Qe=this.Qe.insert(n,c)}}}}}Ze(e){const n=e.me.unchangedNames;if(!n||!n.bits)return null;const{bits:{bitmap:r="",padding:i=0},hashCount:s=0}=n;let o,a;try{o=qi(r).toUint8Array()}catch(u){if(u instanceof oI)return eo("Decoding the base64 bloom filter in existence filter failed ("+u.message+"); ignoring the bloom filter and falling back to full re-query."),null;throw u}try{a=new Hm(o,i,s)}catch(u){return eo(u instanceof ua?"BloomFilter error: ":"Applying bloom filter failed: ",u),null}return a.Ie===0?null:a}Xe(e,n,r){return n.me.count===r-this.nt(e,n.targetId)?0:2}nt(e,n){const r=this.Le.getRemoteKeysForTarget(n);let i=0;return r.forEach(s=>{const o=this.Le.tt(),a=`projects/${o.projectId}/databases/${o.database}/documents/${s.path.canonicalString()}`;e.mightContain(a)||(this.Ue(n,s,null),i++)}),i}rt(e){const n=new Map;this.Be.forEach((s,o)=>{const a=this.Je(o);if(a){if(s.current&&sp(a.target)){const u=new Z(a.target.path);this.ke.get(u)!==null||this.it(o,u)||this.Ue(o,u,Dt.newNoDocument(u,e))}s.be&&(n.set(o,s.ve()),s.Ce())}});let r=de();this.qe.forEach((s,o)=>{let a=!0;o.forEachWhile(u=>{const c=this.Je(u);return!c||c.purpose==="TargetPurposeLimboResolution"||(a=!1,!1)}),a&&(r=r.add(s))}),this.ke.forEach((s,o)=>o.setReadTime(e));const i=new _h(e,n,this.Qe,this.ke,r);return this.ke=Tr(),this.qe=Wv(),this.Qe=new it(ye),i}$e(e,n){if(!this.ze(e))return;const r=this.it(e,n.key)?2:0;this.Ge(e).Fe(n.key,r),this.ke=this.ke.insert(n.key,n),this.qe=this.qe.insert(n.key,this.st(n.key).add(e))}Ue(e,n,r){if(!this.ze(e))return;const i=this.Ge(e);this.it(e,n)?i.Fe(n,1):i.Me(n),this.qe=this.qe.insert(n,this.st(n).delete(e)),r&&(this.ke=this.ke.insert(n,r))}removeTarget(e){this.Be.delete(e)}Ye(e){const n=this.Ge(e).ve();return this.Le.getRemoteKeysForTarget(e).size+n.addedDocuments.size-n.removedDocuments.size}xe(e){this.Ge(e).xe()}Ge(e){let n=this.Be.get(e);return n||(n=new $v,this.Be.set(e,n)),n}st(e){let n=this.qe.get(e);return n||(n=new St(ye),this.qe=this.qe.insert(e,n)),n}ze(e){const n=this.Je(e)!==null;return n||Y("WatchChangeAggregator","Detected inactive target",e),n}Je(e){const n=this.Be.get(e);return n&&n.Se?null:this.Le.ot(e)}je(e){this.Be.set(e,new $v),this.Le.getRemoteKeysForTarget(e).forEach(n=>{this.Ue(e,n,null)})}it(e,n){return this.Le.getRemoteKeysForTarget(e).has(n)}}function Wv(){return new it(Z.comparator)}function qv(){return new it(Z.comparator)}const Gb={asc:"ASCENDING",desc:"DESCENDING"},Kb={"<":"LESS_THAN","<=":"LESS_THAN_OR_EQUAL",">":"GREATER_THAN",">=":"GREATER_THAN_OR_EQUAL","==":"EQUAL","!=":"NOT_EQUAL","array-contains":"ARRAY_CONTAINS",in:"IN","not-in":"NOT_IN","array-contains-any":"ARRAY_CONTAINS_ANY"},Qb={and:"AND",or:"OR"};class Yb{constructor(e,n){this.databaseId=e,this.useProto3Json=n}}function lp(t,e){return t.useProto3Json||dh(e)?e:{value:e}}function Sc(t,e){return t.useProto3Json?`${new Date(1e3*e.seconds).toISOString().replace(/\.\d*/,"").replace("Z","")}.${("000000000"+e.nanoseconds).slice(-9)}Z`:{seconds:""+e.seconds,nanos:e.nanoseconds}}function bI(t,e){return t.useProto3Json?e.toBase64():e.toUint8Array()}function Xb(t,e){return Sc(t,e.toTimestamp())}function Qn(t){return Se(!!t),ie.fromTimestamp(function(n){const r=hi(n);return new ut(r.seconds,r.nanos)}(t))}function Gm(t,e){return up(t,e).canonicalString()}function up(t,e){const n=function(i){return new Fe(["projects",i.projectId,"databases",i.database])}(t).child("documents");return e===void 0?n:n.child(e)}function NI(t){const e=Fe.fromString(t);return Se(VI(e)),e}function cp(t,e){return Gm(t.databaseId,e.path)}function bd(t,e){const n=NI(e);if(n.get(1)!==t.databaseId.projectId)throw new K(U.INVALID_ARGUMENT,"Tried to deserialize key from different project: "+n.get(1)+" vs "+t.databaseId.projectId);if(n.get(3)!==t.databaseId.database)throw new K(U.INVALID_ARGUMENT,"Tried to deserialize key from different database: "+n.get(3)+" vs "+t.databaseId.database);return new Z(DI(n))}function OI(t,e){return Gm(t.databaseId,e)}function Jb(t){const e=NI(t);return e.length===4?Fe.emptyPath():DI(e)}function hp(t){return new Fe(["projects",t.databaseId.projectId,"databases",t.databaseId.database]).canonicalString()}function DI(t){return Se(t.length>4&&t.get(4)==="documents"),t.popFirst(5)}function Hv(t,e,n){return{name:cp(t,e),fields:n.value.mapValue.fields}}function Zb(t,e){let n;if("targetChange"in e){e.targetChange;const r=function(c){return c==="NO_CHANGE"?0:c==="ADD"?1:c==="REMOVE"?2:c==="CURRENT"?3:c==="RESET"?4:re()}(e.targetChange.targetChangeType||"NO_CHANGE"),i=e.targetChange.targetIds||[],s=function(c,d){return c.useProto3Json?(Se(d===void 0||typeof d=="string"),Ct.fromBase64String(d||"")):(Se(d===void 0||d instanceof Buffer||d instanceof Uint8Array),Ct.fromUint8Array(d||new Uint8Array))}(t,e.targetChange.resumeToken),o=e.targetChange.cause,a=o&&function(c){const d=c.code===void 0?U.UNKNOWN:AI(c.code);return new K(d,c.message||"")}(o);n=new PI(r,i,s,a||null)}else if("documentChange"in e){e.documentChange;const r=e.documentChange;r.document,r.document.name,r.document.updateTime;const i=bd(t,r.document.name),s=Qn(r.document.updateTime),o=r.document.createTime?Qn(r.document.createTime):ie.min(),a=new pn({mapValue:{fields:r.document.fields}}),u=Dt.newFoundDocument(i,s,o,a),c=r.targetIds||[],d=r.removedTargetIds||[];n=new Uu(c,d,u.key,u)}else if("documentDelete"in e){e.documentDelete;const r=e.documentDelete;r.document;const i=bd(t,r.document),s=r.readTime?Qn(r.readTime):ie.min(),o=Dt.newNoDocument(i,s),a=r.removedTargetIds||[];n=new Uu([],a,o.key,o)}else if("documentRemove"in e){e.documentRemove;const r=e.documentRemove;r.document;const i=bd(t,r.document),s=r.removedTargetIds||[];n=new Uu([],s,i,null)}else{if(!("filter"in e))return re();{e.filter;const r=e.filter;r.targetId;const{count:i=0,unchangedNames:s}=r,o=new Bb(i,s),a=r.targetId;n=new xI(a,o)}}return n}function eN(t,e){let n;if(e instanceof yl)n={update:Hv(t,e.key,e.value)};else if(e instanceof Wm)n={delete:cp(t,e.key)};else if(e instanceof ts)n={update:Hv(t,e.key,e.data),updateMask:uN(e.fieldMask)};else{if(!(e instanceof Ub))return re();n={verify:cp(t,e.key)}}return e.fieldTransforms.length>0&&(n.updateTransforms=e.fieldTransforms.map(r=>function(s,o){const a=o.transform;if(a instanceof nl)return{fieldPath:o.field.canonicalString(),setToServerValue:"REQUEST_TIME"};if(a instanceof rl)return{fieldPath:o.field.canonicalString(),appendMissingElements:{values:a.elements}};if(a instanceof il)return{fieldPath:o.field.canonicalString(),removeAllFromArray:{values:a.elements}};if(a instanceof Ic)return{fieldPath:o.field.canonicalString(),increment:a.Pe};throw re()}(0,r))),e.precondition.isNone||(n.currentDocument=function(i,s){return s.updateTime!==void 0?{updateTime:Xb(i,s.updateTime)}:s.exists!==void 0?{exists:s.exists}:re()}(t,e.precondition)),n}function tN(t,e){return t&&t.length>0?(Se(e!==void 0),t.map(n=>function(i,s){let o=i.updateTime?Qn(i.updateTime):Qn(s);return o.isEqual(ie.min())&&(o=Qn(s)),new Lb(o,i.transformResults||[])}(n,e))):[]}function nN(t,e){return{documents:[OI(t,e.path)]}}function rN(t,e){const n={structuredQuery:{}},r=e.path;let i;e.collectionGroup!==null?(i=r,n.structuredQuery.from=[{collectionId:e.collectionGroup,allDescendants:!0}]):(i=r.popLast(),n.structuredQuery.from=[{collectionId:r.lastSegment()}]),n.parent=OI(t,i);const s=function(c){if(c.length!==0)return LI(Fn.create(c,"and"))}(e.filters);s&&(n.structuredQuery.where=s);const o=function(c){if(c.length!==0)return c.map(d=>function(m){return{field:ys(m.field),direction:oN(m.dir)}}(d))}(e.orderBy);o&&(n.structuredQuery.orderBy=o);const a=lp(t,e.limit);return a!==null&&(n.structuredQuery.limit=a),e.startAt&&(n.structuredQuery.startAt=function(c){return{before:c.inclusive,values:c.position}}(e.startAt)),e.endAt&&(n.structuredQuery.endAt=function(c){return{before:!c.inclusive,values:c.position}}(e.endAt)),{_t:n,parent:i}}function iN(t){let e=Jb(t.parent);const n=t.structuredQuery,r=n.from?n.from.length:0;let i=null;if(r>0){Se(r===1);const d=n.from[0];d.allDescendants?i=d.collectionId:e=e.child(d.collectionId)}let s=[];n.where&&(s=function(f){const m=MI(f);return m instanceof Fn&&cI(m)?m.getFilters():[m]}(n.where));let o=[];n.orderBy&&(o=function(f){return f.map(m=>function(I){return new tl(vs(I.field),function(O){switch(O){case"ASCENDING":return"asc";case"DESCENDING":return"desc";default:return}}(I.direction))}(m))}(n.orderBy));let a=null;n.limit&&(a=function(f){let m;return m=typeof f=="object"?f.value:f,dh(m)?null:m}(n.limit));let u=null;n.startAt&&(u=function(f){const m=!!f.before,w=f.values||[];return new Tc(w,m)}(n.startAt));let c=null;return n.endAt&&(c=function(f){const m=!f.before,w=f.values||[];return new Tc(w,m)}(n.endAt)),Tb(e,i,o,s,a,"F",u,c)}function sN(t,e){const n=function(i){switch(i){case"TargetPurposeListen":return null;case"TargetPurposeExistenceFilterMismatch":return"existence-filter-mismatch";case"TargetPurposeExistenceFilterMismatchBloom":return"existence-filter-mismatch-bloom";case"TargetPurposeLimboResolution":return"limbo-document";default:return re()}}(e.purpose);return n==null?null:{"goog-listen-tags":n}}function MI(t){return t.unaryFilter!==void 0?function(n){switch(n.unaryFilter.op){case"IS_NAN":const r=vs(n.unaryFilter.field);return rt.create(r,"==",{doubleValue:NaN});case"IS_NULL":const i=vs(n.unaryFilter.field);return rt.create(i,"==",{nullValue:"NULL_VALUE"});case"IS_NOT_NAN":const s=vs(n.unaryFilter.field);return rt.create(s,"!=",{doubleValue:NaN});case"IS_NOT_NULL":const o=vs(n.unaryFilter.field);return rt.create(o,"!=",{nullValue:"NULL_VALUE"});default:return re()}}(t):t.fieldFilter!==void 0?function(n){return rt.create(vs(n.fieldFilter.field),function(i){switch(i){case"EQUAL":return"==";case"NOT_EQUAL":return"!=";case"GREATER_THAN":return">";case"GREATER_THAN_OR_EQUAL":return">=";case"LESS_THAN":return"<";case"LESS_THAN_OR_EQUAL":return"<=";case"ARRAY_CONTAINS":return"array-contains";case"IN":return"in";case"NOT_IN":return"not-in";case"ARRAY_CONTAINS_ANY":return"array-contains-any";default:return re()}}(n.fieldFilter.op),n.fieldFilter.value)}(t):t.compositeFilter!==void 0?function(n){return Fn.create(n.compositeFilter.filters.map(r=>MI(r)),function(i){switch(i){case"AND":return"and";case"OR":return"or";default:return re()}}(n.compositeFilter.op))}(t):re()}function oN(t){return Gb[t]}function aN(t){return Kb[t]}function lN(t){return Qb[t]}function ys(t){return{fieldPath:t.canonicalString()}}function vs(t){return Tt.fromServerFormat(t.fieldPath)}function LI(t){return t instanceof rt?function(n){if(n.op==="=="){if(Nv(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NAN"}};if(bv(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NULL"}}}else if(n.op==="!="){if(Nv(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NOT_NAN"}};if(bv(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NOT_NULL"}}}return{fieldFilter:{field:ys(n.field),op:aN(n.op),value:n.value}}}(t):t instanceof Fn?function(n){const r=n.getFilters().map(i=>LI(i));return r.length===1?r[0]:{compositeFilter:{op:lN(n.op),filters:r}}}(t):re()}function uN(t){const e=[];return t.fields.forEach(n=>e.push(n.canonicalString())),{fieldPaths:e}}function VI(t){return t.length>=4&&t.get(0)==="projects"&&t.get(2)==="databases"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class qr{constructor(e,n,r,i,s=ie.min(),o=ie.min(),a=Ct.EMPTY_BYTE_STRING,u=null){this.target=e,this.targetId=n,this.purpose=r,this.sequenceNumber=i,this.snapshotVersion=s,this.lastLimboFreeSnapshotVersion=o,this.resumeToken=a,this.expectedCount=u}withSequenceNumber(e){return new qr(this.target,this.targetId,this.purpose,e,this.snapshotVersion,this.lastLimboFreeSnapshotVersion,this.resumeToken,this.expectedCount)}withResumeToken(e,n){return new qr(this.target,this.targetId,this.purpose,this.sequenceNumber,n,this.lastLimboFreeSnapshotVersion,e,null)}withExpectedCount(e){return new qr(this.target,this.targetId,this.purpose,this.sequenceNumber,this.snapshotVersion,this.lastLimboFreeSnapshotVersion,this.resumeToken,e)}withLastLimboFreeSnapshotVersion(e){return new qr(this.target,this.targetId,this.purpose,this.sequenceNumber,this.snapshotVersion,e,this.resumeToken,this.expectedCount)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class cN{constructor(e){this.ct=e}}function hN(t){const e=iN({parent:t.parent,structuredQuery:t.structuredQuery});return t.limitType==="LAST"?ap(e,e.limit,"L"):e}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class dN{constructor(){this.un=new fN}addToCollectionParentIndex(e,n){return this.un.add(n),j.resolve()}getCollectionParents(e,n){return j.resolve(this.un.getEntries(n))}addFieldIndex(e,n){return j.resolve()}deleteFieldIndex(e,n){return j.resolve()}deleteAllFieldIndexes(e){return j.resolve()}createTargetIndexes(e,n){return j.resolve()}getDocumentsMatchingTarget(e,n){return j.resolve(null)}getIndexType(e,n){return j.resolve(0)}getFieldIndexes(e,n){return j.resolve([])}getNextCollectionGroupToUpdate(e){return j.resolve(null)}getMinOffset(e,n){return j.resolve(ci.min())}getMinOffsetFromCollectionGroup(e,n){return j.resolve(ci.min())}updateCollectionGroup(e,n,r){return j.resolve()}updateIndexEntries(e,n){return j.resolve()}}class fN{constructor(){this.index={}}add(e){const n=e.lastSegment(),r=e.popLast(),i=this.index[n]||new St(Fe.comparator),s=!i.has(r);return this.index[n]=i.add(r),s}has(e){const n=e.lastSegment(),r=e.popLast(),i=this.index[n];return i&&i.has(r)}getEntries(e){return(this.index[e]||new St(Fe.comparator)).toArray()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class io{constructor(e){this.Ln=e}next(){return this.Ln+=2,this.Ln}static Bn(){return new io(0)}static kn(){return new io(-1)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class pN{constructor(){this.changes=new yo(e=>e.toString(),(e,n)=>e.isEqual(n)),this.changesApplied=!1}addEntry(e){this.assertNotApplied(),this.changes.set(e.key,e)}removeEntry(e,n){this.assertNotApplied(),this.changes.set(e,Dt.newInvalidDocument(e).setReadTime(n))}getEntry(e,n){this.assertNotApplied();const r=this.changes.get(n);return r!==void 0?j.resolve(r):this.getFromCache(e,n)}getEntries(e,n){return this.getAllFromCache(e,n)}apply(e){return this.assertNotApplied(),this.changesApplied=!0,this.applyChanges(e)}assertNotApplied(){}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *//**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class mN{constructor(e,n){this.overlayedDocument=e,this.mutatedFields=n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class gN{constructor(e,n,r,i){this.remoteDocumentCache=e,this.mutationQueue=n,this.documentOverlayCache=r,this.indexManager=i}getDocument(e,n){let r=null;return this.documentOverlayCache.getOverlay(e,n).next(i=>(r=i,this.remoteDocumentCache.getEntry(e,n))).next(i=>(r!==null&&Ta(r.mutation,i,Nn.empty(),ut.now()),i))}getDocuments(e,n){return this.remoteDocumentCache.getEntries(e,n).next(r=>this.getLocalViewOfDocuments(e,r,de()).next(()=>r))}getLocalViewOfDocuments(e,n,r=de()){const i=Ni();return this.populateOverlays(e,i,n).next(()=>this.computeViews(e,n,i,r).next(s=>{let o=la();return s.forEach((a,u)=>{o=o.insert(a,u.overlayedDocument)}),o}))}getOverlayedDocuments(e,n){const r=Ni();return this.populateOverlays(e,r,n).next(()=>this.computeViews(e,n,r,de()))}populateOverlays(e,n,r){const i=[];return r.forEach(s=>{n.has(s)||i.push(s)}),this.documentOverlayCache.getOverlays(e,i).next(s=>{s.forEach((o,a)=>{n.set(o,a)})})}computeViews(e,n,r,i){let s=Tr();const o=Ea(),a=function(){return Ea()}();return n.forEach((u,c)=>{const d=r.get(c.key);i.has(c.key)&&(d===void 0||d.mutation instanceof ts)?s=s.insert(c.key,c):d!==void 0?(o.set(c.key,d.mutation.getFieldMask()),Ta(d.mutation,c,d.mutation.getFieldMask(),ut.now())):o.set(c.key,Nn.empty())}),this.recalculateAndSaveOverlays(e,s).next(u=>(u.forEach((c,d)=>o.set(c,d)),n.forEach((c,d)=>{var f;return a.set(c,new mN(d,(f=o.get(c))!==null&&f!==void 0?f:null))}),a))}recalculateAndSaveOverlays(e,n){const r=Ea();let i=new it((o,a)=>o-a),s=de();return this.mutationQueue.getAllMutationBatchesAffectingDocumentKeys(e,n).next(o=>{for(const a of o)a.keys().forEach(u=>{const c=n.get(u);if(c===null)return;let d=r.get(u)||Nn.empty();d=a.applyToLocalView(c,d),r.set(u,d);const f=(i.get(a.batchId)||de()).add(u);i=i.insert(a.batchId,f)})}).next(()=>{const o=[],a=i.getReverseIterator();for(;a.hasNext();){const u=a.getNext(),c=u.key,d=u.value,f=wI();d.forEach(m=>{if(!s.has(m)){const w=CI(n.get(m),r.get(m));w!==null&&f.set(m,w),s=s.add(m)}}),o.push(this.documentOverlayCache.saveOverlays(e,c,f))}return j.waitFor(o)}).next(()=>r)}recalculateAndSaveOverlaysForDocumentKeys(e,n){return this.remoteDocumentCache.getEntries(e,n).next(r=>this.recalculateAndSaveOverlays(e,r))}getDocumentsMatchingQuery(e,n,r,i){return function(o){return Z.isDocumentKey(o.path)&&o.collectionGroup===null&&o.filters.length===0}(n)?this.getDocumentsMatchingDocumentQuery(e,n.path):mI(n)?this.getDocumentsMatchingCollectionGroupQuery(e,n,r,i):this.getDocumentsMatchingCollectionQuery(e,n,r,i)}getNextDocuments(e,n,r,i){return this.remoteDocumentCache.getAllFromCollectionGroup(e,n,r,i).next(s=>{const o=i-s.size>0?this.documentOverlayCache.getOverlaysForCollectionGroup(e,n,r.largestBatchId,i-s.size):j.resolve(Ni());let a=-1,u=s;return o.next(c=>j.forEach(c,(d,f)=>(a<f.largestBatchId&&(a=f.largestBatchId),s.get(d)?j.resolve():this.remoteDocumentCache.getEntry(e,d).next(m=>{u=u.insert(d,m)}))).next(()=>this.populateOverlays(e,c,s)).next(()=>this.computeViews(e,u,c,de())).next(d=>({batchId:a,changes:vI(d)})))})}getDocumentsMatchingDocumentQuery(e,n){return this.getDocument(e,new Z(n)).next(r=>{let i=la();return r.isFoundDocument()&&(i=i.insert(r.key,r)),i})}getDocumentsMatchingCollectionGroupQuery(e,n,r,i){const s=n.collectionGroup;let o=la();return this.indexManager.getCollectionParents(e,s).next(a=>j.forEach(a,u=>{const c=function(f,m){return new _o(m,null,f.explicitOrderBy.slice(),f.filters.slice(),f.limit,f.limitType,f.startAt,f.endAt)}(n,u.child(s));return this.getDocumentsMatchingCollectionQuery(e,c,r,i).next(d=>{d.forEach((f,m)=>{o=o.insert(f,m)})})}).next(()=>o))}getDocumentsMatchingCollectionQuery(e,n,r,i){let s;return this.documentOverlayCache.getOverlaysForCollection(e,n.path,r.largestBatchId).next(o=>(s=o,this.remoteDocumentCache.getDocumentsMatchingQuery(e,n,r,s,i))).next(o=>{s.forEach((u,c)=>{const d=c.getKey();o.get(d)===null&&(o=o.insert(d,Dt.newInvalidDocument(d)))});let a=la();return o.forEach((u,c)=>{const d=s.get(u);d!==void 0&&Ta(d.mutation,c,Nn.empty(),ut.now()),ph(n,c)&&(a=a.insert(u,c))}),a})}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class _N{constructor(e){this.serializer=e,this.hr=new Map,this.Pr=new Map}getBundleMetadata(e,n){return j.resolve(this.hr.get(n))}saveBundleMetadata(e,n){return this.hr.set(n.id,function(i){return{id:i.id,version:i.version,createTime:Qn(i.createTime)}}(n)),j.resolve()}getNamedQuery(e,n){return j.resolve(this.Pr.get(n))}saveNamedQuery(e,n){return this.Pr.set(n.name,function(i){return{name:i.name,query:hN(i.bundledQuery),readTime:Qn(i.readTime)}}(n)),j.resolve()}}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class yN{constructor(){this.overlays=new it(Z.comparator),this.Ir=new Map}getOverlay(e,n){return j.resolve(this.overlays.get(n))}getOverlays(e,n){const r=Ni();return j.forEach(n,i=>this.getOverlay(e,i).next(s=>{s!==null&&r.set(i,s)})).next(()=>r)}saveOverlays(e,n,r){return r.forEach((i,s)=>{this.ht(e,n,s)}),j.resolve()}removeOverlaysForBatchId(e,n,r){const i=this.Ir.get(r);return i!==void 0&&(i.forEach(s=>this.overlays=this.overlays.remove(s)),this.Ir.delete(r)),j.resolve()}getOverlaysForCollection(e,n,r){const i=Ni(),s=n.length+1,o=new Z(n.child("")),a=this.overlays.getIteratorFrom(o);for(;a.hasNext();){const u=a.getNext().value,c=u.getKey();if(!n.isPrefixOf(c.path))break;c.path.length===s&&u.largestBatchId>r&&i.set(u.getKey(),u)}return j.resolve(i)}getOverlaysForCollectionGroup(e,n,r,i){let s=new it((c,d)=>c-d);const o=this.overlays.getIterator();for(;o.hasNext();){const c=o.getNext().value;if(c.getKey().getCollectionGroup()===n&&c.largestBatchId>r){let d=s.get(c.largestBatchId);d===null&&(d=Ni(),s=s.insert(c.largestBatchId,d)),d.set(c.getKey(),c)}}const a=Ni(),u=s.getIterator();for(;u.hasNext()&&(u.getNext().value.forEach((c,d)=>a.set(c,d)),!(a.size()>=i)););return j.resolve(a)}ht(e,n,r){const i=this.overlays.get(r.key);if(i!==null){const o=this.Ir.get(i.largestBatchId).delete(r.key);this.Ir.set(i.largestBatchId,o)}this.overlays=this.overlays.insert(r.key,new zb(n,r));let s=this.Ir.get(n);s===void 0&&(s=de(),this.Ir.set(n,s)),this.Ir.set(n,s.add(r.key))}}/**
 * @license
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class vN{constructor(){this.sessionToken=Ct.EMPTY_BYTE_STRING}getSessionToken(e){return j.resolve(this.sessionToken)}setSessionToken(e,n){return this.sessionToken=n,j.resolve()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Km{constructor(){this.Tr=new St(ft.Er),this.dr=new St(ft.Ar)}isEmpty(){return this.Tr.isEmpty()}addReference(e,n){const r=new ft(e,n);this.Tr=this.Tr.add(r),this.dr=this.dr.add(r)}Rr(e,n){e.forEach(r=>this.addReference(r,n))}removeReference(e,n){this.Vr(new ft(e,n))}mr(e,n){e.forEach(r=>this.removeReference(r,n))}gr(e){const n=new Z(new Fe([])),r=new ft(n,e),i=new ft(n,e+1),s=[];return this.dr.forEachInRange([r,i],o=>{this.Vr(o),s.push(o.key)}),s}pr(){this.Tr.forEach(e=>this.Vr(e))}Vr(e){this.Tr=this.Tr.delete(e),this.dr=this.dr.delete(e)}yr(e){const n=new Z(new Fe([])),r=new ft(n,e),i=new ft(n,e+1);let s=de();return this.dr.forEachInRange([r,i],o=>{s=s.add(o.key)}),s}containsKey(e){const n=new ft(e,0),r=this.Tr.firstAfterOrEqual(n);return r!==null&&e.isEqual(r.key)}}class ft{constructor(e,n){this.key=e,this.wr=n}static Er(e,n){return Z.comparator(e.key,n.key)||ye(e.wr,n.wr)}static Ar(e,n){return ye(e.wr,n.wr)||Z.comparator(e.key,n.key)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class wN{constructor(e,n){this.indexManager=e,this.referenceDelegate=n,this.mutationQueue=[],this.Sr=1,this.br=new St(ft.Er)}checkEmpty(e){return j.resolve(this.mutationQueue.length===0)}addMutationBatch(e,n,r,i){const s=this.Sr;this.Sr++,this.mutationQueue.length>0&&this.mutationQueue[this.mutationQueue.length-1];const o=new jb(s,n,r,i);this.mutationQueue.push(o);for(const a of i)this.br=this.br.add(new ft(a.key,s)),this.indexManager.addToCollectionParentIndex(e,a.key.path.popLast());return j.resolve(o)}lookupMutationBatch(e,n){return j.resolve(this.Dr(n))}getNextMutationBatchAfterBatchId(e,n){const r=n+1,i=this.vr(r),s=i<0?0:i;return j.resolve(this.mutationQueue.length>s?this.mutationQueue[s]:null)}getHighestUnacknowledgedBatchId(){return j.resolve(this.mutationQueue.length===0?-1:this.Sr-1)}getAllMutationBatches(e){return j.resolve(this.mutationQueue.slice())}getAllMutationBatchesAffectingDocumentKey(e,n){const r=new ft(n,0),i=new ft(n,Number.POSITIVE_INFINITY),s=[];return this.br.forEachInRange([r,i],o=>{const a=this.Dr(o.wr);s.push(a)}),j.resolve(s)}getAllMutationBatchesAffectingDocumentKeys(e,n){let r=new St(ye);return n.forEach(i=>{const s=new ft(i,0),o=new ft(i,Number.POSITIVE_INFINITY);this.br.forEachInRange([s,o],a=>{r=r.add(a.wr)})}),j.resolve(this.Cr(r))}getAllMutationBatchesAffectingQuery(e,n){const r=n.path,i=r.length+1;let s=r;Z.isDocumentKey(s)||(s=s.child(""));const o=new ft(new Z(s),0);let a=new St(ye);return this.br.forEachWhile(u=>{const c=u.key.path;return!!r.isPrefixOf(c)&&(c.length===i&&(a=a.add(u.wr)),!0)},o),j.resolve(this.Cr(a))}Cr(e){const n=[];return e.forEach(r=>{const i=this.Dr(r);i!==null&&n.push(i)}),n}removeMutationBatch(e,n){Se(this.Fr(n.batchId,"removed")===0),this.mutationQueue.shift();let r=this.br;return j.forEach(n.mutations,i=>{const s=new ft(i.key,n.batchId);return r=r.delete(s),this.referenceDelegate.markPotentiallyOrphaned(e,i.key)}).next(()=>{this.br=r})}On(e){}containsKey(e,n){const r=new ft(n,0),i=this.br.firstAfterOrEqual(r);return j.resolve(n.isEqual(i&&i.key))}performConsistencyCheck(e){return this.mutationQueue.length,j.resolve()}Fr(e,n){return this.vr(e)}vr(e){return this.mutationQueue.length===0?0:e-this.mutationQueue[0].batchId}Dr(e){const n=this.vr(e);return n<0||n>=this.mutationQueue.length?null:this.mutationQueue[n]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class EN{constructor(e){this.Mr=e,this.docs=function(){return new it(Z.comparator)}(),this.size=0}setIndexManager(e){this.indexManager=e}addEntry(e,n){const r=n.key,i=this.docs.get(r),s=i?i.size:0,o=this.Mr(n);return this.docs=this.docs.insert(r,{document:n.mutableCopy(),size:o}),this.size+=o-s,this.indexManager.addToCollectionParentIndex(e,r.path.popLast())}removeEntry(e){const n=this.docs.get(e);n&&(this.docs=this.docs.remove(e),this.size-=n.size)}getEntry(e,n){const r=this.docs.get(n);return j.resolve(r?r.document.mutableCopy():Dt.newInvalidDocument(n))}getEntries(e,n){let r=Tr();return n.forEach(i=>{const s=this.docs.get(i);r=r.insert(i,s?s.document.mutableCopy():Dt.newInvalidDocument(i))}),j.resolve(r)}getDocumentsMatchingQuery(e,n,r,i){let s=Tr();const o=n.path,a=new Z(o.child("")),u=this.docs.getIteratorFrom(a);for(;u.hasNext();){const{key:c,value:{document:d}}=u.getNext();if(!o.isPrefixOf(c.path))break;c.path.length>o.length+1||rb(nb(d),r)<=0||(i.has(d.key)||ph(n,d))&&(s=s.insert(d.key,d.mutableCopy()))}return j.resolve(s)}getAllFromCollectionGroup(e,n,r,i){re()}Or(e,n){return j.forEach(this.docs,r=>n(r))}newChangeBuffer(e){return new TN(this)}getSize(e){return j.resolve(this.size)}}class TN extends pN{constructor(e){super(),this.cr=e}applyChanges(e){const n=[];return this.changes.forEach((r,i)=>{i.isValidDocument()?n.push(this.cr.addEntry(e,i)):this.cr.removeEntry(r)}),j.waitFor(n)}getFromCache(e,n){return this.cr.getEntry(e,n)}getAllFromCache(e,n){return this.cr.getEntries(e,n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class IN{constructor(e){this.persistence=e,this.Nr=new yo(n=>zm(n),Bm),this.lastRemoteSnapshotVersion=ie.min(),this.highestTargetId=0,this.Lr=0,this.Br=new Km,this.targetCount=0,this.kr=io.Bn()}forEachTarget(e,n){return this.Nr.forEach((r,i)=>n(i)),j.resolve()}getLastRemoteSnapshotVersion(e){return j.resolve(this.lastRemoteSnapshotVersion)}getHighestSequenceNumber(e){return j.resolve(this.Lr)}allocateTargetId(e){return this.highestTargetId=this.kr.next(),j.resolve(this.highestTargetId)}setTargetsMetadata(e,n,r){return r&&(this.lastRemoteSnapshotVersion=r),n>this.Lr&&(this.Lr=n),j.resolve()}Kn(e){this.Nr.set(e.target,e);const n=e.targetId;n>this.highestTargetId&&(this.kr=new io(n),this.highestTargetId=n),e.sequenceNumber>this.Lr&&(this.Lr=e.sequenceNumber)}addTargetData(e,n){return this.Kn(n),this.targetCount+=1,j.resolve()}updateTargetData(e,n){return this.Kn(n),j.resolve()}removeTargetData(e,n){return this.Nr.delete(n.target),this.Br.gr(n.targetId),this.targetCount-=1,j.resolve()}removeTargets(e,n,r){let i=0;const s=[];return this.Nr.forEach((o,a)=>{a.sequenceNumber<=n&&r.get(a.targetId)===null&&(this.Nr.delete(o),s.push(this.removeMatchingKeysForTargetId(e,a.targetId)),i++)}),j.waitFor(s).next(()=>i)}getTargetCount(e){return j.resolve(this.targetCount)}getTargetData(e,n){const r=this.Nr.get(n)||null;return j.resolve(r)}addMatchingKeys(e,n,r){return this.Br.Rr(n,r),j.resolve()}removeMatchingKeys(e,n,r){this.Br.mr(n,r);const i=this.persistence.referenceDelegate,s=[];return i&&n.forEach(o=>{s.push(i.markPotentiallyOrphaned(e,o))}),j.waitFor(s)}removeMatchingKeysForTargetId(e,n){return this.Br.gr(n),j.resolve()}getMatchingKeysForTargetId(e,n){const r=this.Br.yr(n);return j.resolve(r)}containsKey(e,n){return j.resolve(this.Br.containsKey(n))}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class SN{constructor(e,n){this.qr={},this.overlays={},this.Qr=new Vm(0),this.Kr=!1,this.Kr=!0,this.$r=new vN,this.referenceDelegate=e(this),this.Ur=new IN(this),this.indexManager=new dN,this.remoteDocumentCache=function(i){return new EN(i)}(r=>this.referenceDelegate.Wr(r)),this.serializer=new cN(n),this.Gr=new _N(this.serializer)}start(){return Promise.resolve()}shutdown(){return this.Kr=!1,Promise.resolve()}get started(){return this.Kr}setDatabaseDeletedListener(){}setNetworkEnabled(){}getIndexManager(e){return this.indexManager}getDocumentOverlayCache(e){let n=this.overlays[e.toKey()];return n||(n=new yN,this.overlays[e.toKey()]=n),n}getMutationQueue(e,n){let r=this.qr[e.toKey()];return r||(r=new wN(n,this.referenceDelegate),this.qr[e.toKey()]=r),r}getGlobalsCache(){return this.$r}getTargetCache(){return this.Ur}getRemoteDocumentCache(){return this.remoteDocumentCache}getBundleCache(){return this.Gr}runTransaction(e,n,r){Y("MemoryPersistence","Starting transaction:",e);const i=new kN(this.Qr.next());return this.referenceDelegate.zr(),r(i).next(s=>this.referenceDelegate.jr(i).next(()=>s)).toPromise().then(s=>(i.raiseOnCommittedEvent(),s))}Hr(e,n){return j.or(Object.values(this.qr).map(r=>()=>r.containsKey(e,n)))}}class kN extends sb{constructor(e){super(),this.currentSequenceNumber=e}}class Qm{constructor(e){this.persistence=e,this.Jr=new Km,this.Yr=null}static Zr(e){return new Qm(e)}get Xr(){if(this.Yr)return this.Yr;throw re()}addReference(e,n,r){return this.Jr.addReference(r,n),this.Xr.delete(r.toString()),j.resolve()}removeReference(e,n,r){return this.Jr.removeReference(r,n),this.Xr.add(r.toString()),j.resolve()}markPotentiallyOrphaned(e,n){return this.Xr.add(n.toString()),j.resolve()}removeTarget(e,n){this.Jr.gr(n.targetId).forEach(i=>this.Xr.add(i.toString()));const r=this.persistence.getTargetCache();return r.getMatchingKeysForTargetId(e,n.targetId).next(i=>{i.forEach(s=>this.Xr.add(s.toString()))}).next(()=>r.removeTargetData(e,n))}zr(){this.Yr=new Set}jr(e){const n=this.persistence.getRemoteDocumentCache().newChangeBuffer();return j.forEach(this.Xr,r=>{const i=Z.fromPath(r);return this.ei(e,i).next(s=>{s||n.removeEntry(i,ie.min())})}).next(()=>(this.Yr=null,n.apply(e)))}updateLimboDocument(e,n){return this.ei(e,n).next(r=>{r?this.Xr.delete(n.toString()):this.Xr.add(n.toString())})}Wr(e){return 0}ei(e,n){return j.or([()=>j.resolve(this.Jr.containsKey(n)),()=>this.persistence.getTargetCache().containsKey(e,n),()=>this.persistence.Hr(e,n)])}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ym{constructor(e,n,r,i){this.targetId=e,this.fromCache=n,this.$i=r,this.Ui=i}static Wi(e,n){let r=de(),i=de();for(const s of n.docChanges)switch(s.type){case 0:r=r.add(s.doc.key);break;case 1:i=i.add(s.doc.key)}return new Ym(e,n.fromCache,r,i)}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class CN{constructor(){this._documentReadCount=0}get documentReadCount(){return this._documentReadCount}incrementDocumentReadCount(e){this._documentReadCount+=e}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class RN{constructor(){this.Gi=!1,this.zi=!1,this.ji=100,this.Hi=function(){return Sx()?8:ob(Ft())>0?6:4}()}initialize(e,n){this.Ji=e,this.indexManager=n,this.Gi=!0}getDocumentsMatchingQuery(e,n,r,i){const s={result:null};return this.Yi(e,n).next(o=>{s.result=o}).next(()=>{if(!s.result)return this.Zi(e,n,i,r).next(o=>{s.result=o})}).next(()=>{if(s.result)return;const o=new CN;return this.Xi(e,n,o).next(a=>{if(s.result=a,this.zi)return this.es(e,n,o,a.size)})}).next(()=>s.result)}es(e,n,r,i){return r.documentReadCount<this.ji?(Qo()<=ce.DEBUG&&Y("QueryEngine","SDK will not create cache indexes for query:",_s(n),"since it only creates cache indexes for collection contains","more than or equal to",this.ji,"documents"),j.resolve()):(Qo()<=ce.DEBUG&&Y("QueryEngine","Query:",_s(n),"scans",r.documentReadCount,"local documents and returns",i,"documents as results."),r.documentReadCount>this.Hi*i?(Qo()<=ce.DEBUG&&Y("QueryEngine","The SDK decides to create cache indexes for query:",_s(n),"as using cache indexes may help improve performance."),this.indexManager.createTargetIndexes(e,Gn(n))):j.resolve())}Yi(e,n){if(Lv(n))return j.resolve(null);let r=Gn(n);return this.indexManager.getIndexType(e,r).next(i=>i===0?null:(n.limit!==null&&i===1&&(n=ap(n,null,"F"),r=Gn(n)),this.indexManager.getDocumentsMatchingTarget(e,r).next(s=>{const o=de(...s);return this.Ji.getDocuments(e,o).next(a=>this.indexManager.getMinOffset(e,r).next(u=>{const c=this.ts(n,a);return this.ns(n,c,o,u.readTime)?this.Yi(e,ap(n,null,"F")):this.rs(e,c,n,u)}))})))}Zi(e,n,r,i){return Lv(n)||i.isEqual(ie.min())?j.resolve(null):this.Ji.getDocuments(e,r).next(s=>{const o=this.ts(n,s);return this.ns(n,o,r,i)?j.resolve(null):(Qo()<=ce.DEBUG&&Y("QueryEngine","Re-using previous result from %s to execute query: %s",i.toString(),_s(n)),this.rs(e,o,n,tb(i,-1)).next(a=>a))})}ts(e,n){let r=new St(_I(e));return n.forEach((i,s)=>{ph(e,s)&&(r=r.add(s))}),r}ns(e,n,r,i){if(e.limit===null)return!1;if(r.size!==n.size)return!0;const s=e.limitType==="F"?n.last():n.first();return!!s&&(s.hasPendingWrites||s.version.compareTo(i)>0)}Xi(e,n,r){return Qo()<=ce.DEBUG&&Y("QueryEngine","Using full collection scan to execute query:",_s(n)),this.Ji.getDocumentsMatchingQuery(e,n,ci.min(),r)}rs(e,n,r,i){return this.Ji.getDocumentsMatchingQuery(e,r,i).next(s=>(n.forEach(o=>{s=s.insert(o.key,o)}),s))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class AN{constructor(e,n,r,i){this.persistence=e,this.ss=n,this.serializer=i,this.os=new it(ye),this._s=new yo(s=>zm(s),Bm),this.us=new Map,this.cs=e.getRemoteDocumentCache(),this.Ur=e.getTargetCache(),this.Gr=e.getBundleCache(),this.ls(r)}ls(e){this.documentOverlayCache=this.persistence.getDocumentOverlayCache(e),this.indexManager=this.persistence.getIndexManager(e),this.mutationQueue=this.persistence.getMutationQueue(e,this.indexManager),this.localDocuments=new gN(this.cs,this.mutationQueue,this.documentOverlayCache,this.indexManager),this.cs.setIndexManager(this.indexManager),this.ss.initialize(this.localDocuments,this.indexManager)}collectGarbage(e){return this.persistence.runTransaction("Collect garbage","readwrite-primary",n=>e.collect(n,this.os))}}function xN(t,e,n,r){return new AN(t,e,n,r)}async function FI(t,e){const n=se(t);return await n.persistence.runTransaction("Handle user change","readonly",r=>{let i;return n.mutationQueue.getAllMutationBatches(r).next(s=>(i=s,n.ls(e),n.mutationQueue.getAllMutationBatches(r))).next(s=>{const o=[],a=[];let u=de();for(const c of i){o.push(c.batchId);for(const d of c.mutations)u=u.add(d.key)}for(const c of s){a.push(c.batchId);for(const d of c.mutations)u=u.add(d.key)}return n.localDocuments.getDocuments(r,u).next(c=>({hs:c,removedBatchIds:o,addedBatchIds:a}))})})}function PN(t,e){const n=se(t);return n.persistence.runTransaction("Acknowledge batch","readwrite-primary",r=>{const i=e.batch.keys(),s=n.cs.newChangeBuffer({trackRemovals:!0});return function(a,u,c,d){const f=c.batch,m=f.keys();let w=j.resolve();return m.forEach(I=>{w=w.next(()=>d.getEntry(u,I)).next(P=>{const O=c.docVersions.get(I);Se(O!==null),P.version.compareTo(O)<0&&(f.applyToRemoteDocument(P,c),P.isValidDocument()&&(P.setReadTime(c.commitVersion),d.addEntry(P)))})}),w.next(()=>a.mutationQueue.removeMutationBatch(u,f))}(n,r,e,s).next(()=>s.apply(r)).next(()=>n.mutationQueue.performConsistencyCheck(r)).next(()=>n.documentOverlayCache.removeOverlaysForBatchId(r,i,e.batch.batchId)).next(()=>n.localDocuments.recalculateAndSaveOverlaysForDocumentKeys(r,function(a){let u=de();for(let c=0;c<a.mutationResults.length;++c)a.mutationResults[c].transformResults.length>0&&(u=u.add(a.batch.mutations[c].key));return u}(e))).next(()=>n.localDocuments.getDocuments(r,i))})}function UI(t){const e=se(t);return e.persistence.runTransaction("Get last remote snapshot version","readonly",n=>e.Ur.getLastRemoteSnapshotVersion(n))}function bN(t,e){const n=se(t),r=e.snapshotVersion;let i=n.os;return n.persistence.runTransaction("Apply remote event","readwrite-primary",s=>{const o=n.cs.newChangeBuffer({trackRemovals:!0});i=n.os;const a=[];e.targetChanges.forEach((d,f)=>{const m=i.get(f);if(!m)return;a.push(n.Ur.removeMatchingKeys(s,d.removedDocuments,f).next(()=>n.Ur.addMatchingKeys(s,d.addedDocuments,f)));let w=m.withSequenceNumber(s.currentSequenceNumber);e.targetMismatches.get(f)!==null?w=w.withResumeToken(Ct.EMPTY_BYTE_STRING,ie.min()).withLastLimboFreeSnapshotVersion(ie.min()):d.resumeToken.approximateByteSize()>0&&(w=w.withResumeToken(d.resumeToken,r)),i=i.insert(f,w),function(P,O,C){return P.resumeToken.approximateByteSize()===0||O.snapshotVersion.toMicroseconds()-P.snapshotVersion.toMicroseconds()>=3e8?!0:C.addedDocuments.size+C.modifiedDocuments.size+C.removedDocuments.size>0}(m,w,d)&&a.push(n.Ur.updateTargetData(s,w))});let u=Tr(),c=de();if(e.documentUpdates.forEach(d=>{e.resolvedLimboDocuments.has(d)&&a.push(n.persistence.referenceDelegate.updateLimboDocument(s,d))}),a.push(NN(s,o,e.documentUpdates).next(d=>{u=d.Ps,c=d.Is})),!r.isEqual(ie.min())){const d=n.Ur.getLastRemoteSnapshotVersion(s).next(f=>n.Ur.setTargetsMetadata(s,s.currentSequenceNumber,r));a.push(d)}return j.waitFor(a).next(()=>o.apply(s)).next(()=>n.localDocuments.getLocalViewOfDocuments(s,u,c)).next(()=>u)}).then(s=>(n.os=i,s))}function NN(t,e,n){let r=de(),i=de();return n.forEach(s=>r=r.add(s)),e.getEntries(t,r).next(s=>{let o=Tr();return n.forEach((a,u)=>{const c=s.get(a);u.isFoundDocument()!==c.isFoundDocument()&&(i=i.add(a)),u.isNoDocument()&&u.version.isEqual(ie.min())?(e.removeEntry(a,u.readTime),o=o.insert(a,u)):!c.isValidDocument()||u.version.compareTo(c.version)>0||u.version.compareTo(c.version)===0&&c.hasPendingWrites?(e.addEntry(u),o=o.insert(a,u)):Y("LocalStore","Ignoring outdated watch update for ",a,". Current version:",c.version," Watch version:",u.version)}),{Ps:o,Is:i}})}function ON(t,e){const n=se(t);return n.persistence.runTransaction("Get next mutation batch","readonly",r=>(e===void 0&&(e=-1),n.mutationQueue.getNextMutationBatchAfterBatchId(r,e)))}function DN(t,e){const n=se(t);return n.persistence.runTransaction("Allocate target","readwrite",r=>{let i;return n.Ur.getTargetData(r,e).next(s=>s?(i=s,j.resolve(i)):n.Ur.allocateTargetId(r).next(o=>(i=new qr(e,o,"TargetPurposeListen",r.currentSequenceNumber),n.Ur.addTargetData(r,i).next(()=>i))))}).then(r=>{const i=n.os.get(r.targetId);return(i===null||r.snapshotVersion.compareTo(i.snapshotVersion)>0)&&(n.os=n.os.insert(r.targetId,r),n._s.set(e,r.targetId)),r})}async function dp(t,e,n){const r=se(t),i=r.os.get(e),s=n?"readwrite":"readwrite-primary";try{n||await r.persistence.runTransaction("Release target",s,o=>r.persistence.referenceDelegate.removeTarget(o,i))}catch(o){if(!_l(o))throw o;Y("LocalStore",`Failed to update sequence numbers for target ${e}: ${o}`)}r.os=r.os.remove(e),r._s.delete(i.target)}function Gv(t,e,n){const r=se(t);let i=ie.min(),s=de();return r.persistence.runTransaction("Execute query","readwrite",o=>function(u,c,d){const f=se(u),m=f._s.get(d);return m!==void 0?j.resolve(f.os.get(m)):f.Ur.getTargetData(c,d)}(r,o,Gn(e)).next(a=>{if(a)return i=a.lastLimboFreeSnapshotVersion,r.Ur.getMatchingKeysForTargetId(o,a.targetId).next(u=>{s=u})}).next(()=>r.ss.getDocumentsMatchingQuery(o,e,n?i:ie.min(),n?s:de())).next(a=>(MN(r,Sb(e),a),{documents:a,Ts:s})))}function MN(t,e,n){let r=t.us.get(e)||ie.min();n.forEach((i,s)=>{s.readTime.compareTo(r)>0&&(r=s.readTime)}),t.us.set(e,r)}class Kv{constructor(){this.activeTargetIds=Pb()}fs(e){this.activeTargetIds=this.activeTargetIds.add(e)}gs(e){this.activeTargetIds=this.activeTargetIds.delete(e)}Vs(){const e={activeTargetIds:this.activeTargetIds.toArray(),updateTimeMs:Date.now()};return JSON.stringify(e)}}class LN{constructor(){this.so=new Kv,this.oo={},this.onlineStateHandler=null,this.sequenceNumberHandler=null}addPendingMutation(e){}updateMutationState(e,n,r){}addLocalQueryTarget(e,n=!0){return n&&this.so.fs(e),this.oo[e]||"not-current"}updateQueryState(e,n,r){this.oo[e]=n}removeLocalQueryTarget(e){this.so.gs(e)}isLocalQueryTarget(e){return this.so.activeTargetIds.has(e)}clearQueryState(e){delete this.oo[e]}getAllActiveQueryTargets(){return this.so.activeTargetIds}isActiveQueryTarget(e){return this.so.activeTargetIds.has(e)}start(){return this.so=new Kv,Promise.resolve()}handleUserChange(e,n,r){}setOnlineState(e){}shutdown(){}writeSequenceNumber(e){}notifyBundleLoaded(e){}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class VN{_o(e){}shutdown(){}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Qv{constructor(){this.ao=()=>this.uo(),this.co=()=>this.lo(),this.ho=[],this.Po()}_o(e){this.ho.push(e)}shutdown(){window.removeEventListener("online",this.ao),window.removeEventListener("offline",this.co)}Po(){window.addEventListener("online",this.ao),window.addEventListener("offline",this.co)}uo(){Y("ConnectivityMonitor","Network connectivity changed: AVAILABLE");for(const e of this.ho)e(0)}lo(){Y("ConnectivityMonitor","Network connectivity changed: UNAVAILABLE");for(const e of this.ho)e(1)}static D(){return typeof window<"u"&&window.addEventListener!==void 0&&window.removeEventListener!==void 0}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let gu=null;function Nd(){return gu===null?gu=function(){return 268435456+Math.round(2147483648*Math.random())}():gu++,"0x"+gu.toString(16)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const FN={BatchGetDocuments:"batchGet",Commit:"commit",RunQuery:"runQuery",RunAggregationQuery:"runAggregationQuery"};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class UN{constructor(e){this.Io=e.Io,this.To=e.To}Eo(e){this.Ao=e}Ro(e){this.Vo=e}mo(e){this.fo=e}onMessage(e){this.po=e}close(){this.To()}send(e){this.Io(e)}yo(){this.Ao()}wo(){this.Vo()}So(e){this.fo(e)}bo(e){this.po(e)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const bt="WebChannelConnection";class jN extends class{constructor(n){this.databaseInfo=n,this.databaseId=n.databaseId;const r=n.ssl?"https":"http",i=encodeURIComponent(this.databaseId.projectId),s=encodeURIComponent(this.databaseId.database);this.Do=r+"://"+n.host,this.vo=`projects/${i}/databases/${s}`,this.Co=this.databaseId.database==="(default)"?`project_id=${i}`:`project_id=${i}&database_id=${s}`}get Fo(){return!1}Mo(n,r,i,s,o){const a=Nd(),u=this.xo(n,r.toUriEncodedString());Y("RestConnection",`Sending RPC '${n}' ${a}:`,u,i);const c={"google-cloud-resource-prefix":this.vo,"x-goog-request-params":this.Co};return this.Oo(c,s,o),this.No(n,u,c,i).then(d=>(Y("RestConnection",`Received RPC '${n}' ${a}: `,d),d),d=>{throw eo("RestConnection",`RPC '${n}' ${a} failed with error: `,d,"url: ",u,"request:",i),d})}Lo(n,r,i,s,o,a){return this.Mo(n,r,i,s,o)}Oo(n,r,i){n["X-Goog-Api-Client"]=function(){return"gl-js/ fire/"+mo}(),n["Content-Type"]="text/plain",this.databaseInfo.appId&&(n["X-Firebase-GMPID"]=this.databaseInfo.appId),r&&r.headers.forEach((s,o)=>n[o]=s),i&&i.headers.forEach((s,o)=>n[o]=s)}xo(n,r){const i=FN[n];return`${this.Do}/v1/${r}:${i}`}terminate(){}}{constructor(e){super(e),this.forceLongPolling=e.forceLongPolling,this.autoDetectLongPolling=e.autoDetectLongPolling,this.useFetchStreams=e.useFetchStreams,this.longPollingOptions=e.longPollingOptions}No(e,n,r,i){const s=Nd();return new Promise((o,a)=>{const u=new JT;u.setWithCredentials(!0),u.listenOnce(ZT.COMPLETE,()=>{try{switch(u.getLastErrorCode()){case Lu.NO_ERROR:const d=u.getResponseJson();Y(bt,`XHR for RPC '${e}' ${s} received:`,JSON.stringify(d)),o(d);break;case Lu.TIMEOUT:Y(bt,`RPC '${e}' ${s} timed out`),a(new K(U.DEADLINE_EXCEEDED,"Request time out"));break;case Lu.HTTP_ERROR:const f=u.getStatus();if(Y(bt,`RPC '${e}' ${s} failed with status:`,f,"response text:",u.getResponseText()),f>0){let m=u.getResponseJson();Array.isArray(m)&&(m=m[0]);const w=m==null?void 0:m.error;if(w&&w.status&&w.message){const I=function(O){const C=O.toLowerCase().replace(/_/g,"-");return Object.values(U).indexOf(C)>=0?C:U.UNKNOWN}(w.status);a(new K(I,w.message))}else a(new K(U.UNKNOWN,"Server responded with status "+u.getStatus()))}else a(new K(U.UNAVAILABLE,"Connection failed."));break;default:re()}}finally{Y(bt,`RPC '${e}' ${s} completed.`)}});const c=JSON.stringify(i);Y(bt,`RPC '${e}' ${s} sending request:`,i),u.send(n,"POST",c,r,15)})}Bo(e,n,r){const i=Nd(),s=[this.Do,"/","google.firestore.v1.Firestore","/",e,"/channel"],o=nI(),a=tI(),u={httpSessionIdParam:"gsessionid",initMessageHeaders:{},messageUrlParams:{database:`projects/${this.databaseId.projectId}/databases/${this.databaseId.database}`},sendRawJson:!0,supportsCrossDomainXhr:!0,internalChannelParams:{forwardChannelRequestTimeoutMs:6e5},forceLongPolling:this.forceLongPolling,detectBufferingProxy:this.autoDetectLongPolling},c=this.longPollingOptions.timeoutSeconds;c!==void 0&&(u.longPollingTimeout=Math.round(1e3*c)),this.useFetchStreams&&(u.useFetchStreams=!0),this.Oo(u.initMessageHeaders,n,r),u.encodeInitMessageHeaders=!0;const d=s.join("");Y(bt,`Creating RPC '${e}' stream ${i}: ${d}`,u);const f=o.createWebChannel(d,u);let m=!1,w=!1;const I=new UN({Io:O=>{w?Y(bt,`Not sending because RPC '${e}' stream ${i} is closed:`,O):(m||(Y(bt,`Opening RPC '${e}' stream ${i} transport.`),f.open(),m=!0),Y(bt,`RPC '${e}' stream ${i} sending:`,O),f.send(O))},To:()=>f.close()}),P=(O,C,T)=>{O.listen(C,S=>{try{T(S)}catch(M){setTimeout(()=>{throw M},0)}})};return P(f,aa.EventType.OPEN,()=>{w||(Y(bt,`RPC '${e}' stream ${i} transport opened.`),I.yo())}),P(f,aa.EventType.CLOSE,()=>{w||(w=!0,Y(bt,`RPC '${e}' stream ${i} transport closed`),I.So())}),P(f,aa.EventType.ERROR,O=>{w||(w=!0,eo(bt,`RPC '${e}' stream ${i} transport errored:`,O),I.So(new K(U.UNAVAILABLE,"The operation could not be completed")))}),P(f,aa.EventType.MESSAGE,O=>{var C;if(!w){const T=O.data[0];Se(!!T);const S=T,M=S.error||((C=S[0])===null||C===void 0?void 0:C.error);if(M){Y(bt,`RPC '${e}' stream ${i} received error:`,M);const V=M.status;let F=function(E){const k=tt[E];if(k!==void 0)return AI(k)}(V),y=M.message;F===void 0&&(F=U.INTERNAL,y="Unknown error status: "+V+" with message "+M.message),w=!0,I.So(new K(F,y)),f.close()}else Y(bt,`RPC '${e}' stream ${i} received:`,T),I.bo(T)}}),P(a,eI.STAT_EVENT,O=>{O.stat===ep.PROXY?Y(bt,`RPC '${e}' stream ${i} detected buffering proxy`):O.stat===ep.NOPROXY&&Y(bt,`RPC '${e}' stream ${i} detected no buffering proxy`)}),setTimeout(()=>{I.wo()},0),I}}function Od(){return typeof document<"u"?document:null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function yh(t){return new Yb(t,!0)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jI{constructor(e,n,r=1e3,i=1.5,s=6e4){this.ui=e,this.timerId=n,this.ko=r,this.qo=i,this.Qo=s,this.Ko=0,this.$o=null,this.Uo=Date.now(),this.reset()}reset(){this.Ko=0}Wo(){this.Ko=this.Qo}Go(e){this.cancel();const n=Math.floor(this.Ko+this.zo()),r=Math.max(0,Date.now()-this.Uo),i=Math.max(0,n-r);i>0&&Y("ExponentialBackoff",`Backing off for ${i} ms (base delay: ${this.Ko} ms, delay with jitter: ${n} ms, last attempt: ${r} ms ago)`),this.$o=this.ui.enqueueAfterDelay(this.timerId,i,()=>(this.Uo=Date.now(),e())),this.Ko*=this.qo,this.Ko<this.ko&&(this.Ko=this.ko),this.Ko>this.Qo&&(this.Ko=this.Qo)}jo(){this.$o!==null&&(this.$o.skipDelay(),this.$o=null)}cancel(){this.$o!==null&&(this.$o.cancel(),this.$o=null)}zo(){return(Math.random()-.5)*this.Ko}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zI{constructor(e,n,r,i,s,o,a,u){this.ui=e,this.Ho=r,this.Jo=i,this.connection=s,this.authCredentialsProvider=o,this.appCheckCredentialsProvider=a,this.listener=u,this.state=0,this.Yo=0,this.Zo=null,this.Xo=null,this.stream=null,this.e_=0,this.t_=new jI(e,n)}n_(){return this.state===1||this.state===5||this.r_()}r_(){return this.state===2||this.state===3}start(){this.e_=0,this.state!==4?this.auth():this.i_()}async stop(){this.n_()&&await this.close(0)}s_(){this.state=0,this.t_.reset()}o_(){this.r_()&&this.Zo===null&&(this.Zo=this.ui.enqueueAfterDelay(this.Ho,6e4,()=>this.__()))}a_(e){this.u_(),this.stream.send(e)}async __(){if(this.r_())return this.close(0)}u_(){this.Zo&&(this.Zo.cancel(),this.Zo=null)}c_(){this.Xo&&(this.Xo.cancel(),this.Xo=null)}async close(e,n){this.u_(),this.c_(),this.t_.cancel(),this.Yo++,e!==4?this.t_.reset():n&&n.code===U.RESOURCE_EXHAUSTED?(Er(n.toString()),Er("Using maximum backoff delay to prevent overloading the backend."),this.t_.Wo()):n&&n.code===U.UNAUTHENTICATED&&this.state!==3&&(this.authCredentialsProvider.invalidateToken(),this.appCheckCredentialsProvider.invalidateToken()),this.stream!==null&&(this.l_(),this.stream.close(),this.stream=null),this.state=e,await this.listener.mo(n)}l_(){}auth(){this.state=1;const e=this.h_(this.Yo),n=this.Yo;Promise.all([this.authCredentialsProvider.getToken(),this.appCheckCredentialsProvider.getToken()]).then(([r,i])=>{this.Yo===n&&this.P_(r,i)},r=>{e(()=>{const i=new K(U.UNKNOWN,"Fetching auth token failed: "+r.message);return this.I_(i)})})}P_(e,n){const r=this.h_(this.Yo);this.stream=this.T_(e,n),this.stream.Eo(()=>{r(()=>this.listener.Eo())}),this.stream.Ro(()=>{r(()=>(this.state=2,this.Xo=this.ui.enqueueAfterDelay(this.Jo,1e4,()=>(this.r_()&&(this.state=3),Promise.resolve())),this.listener.Ro()))}),this.stream.mo(i=>{r(()=>this.I_(i))}),this.stream.onMessage(i=>{r(()=>++this.e_==1?this.E_(i):this.onNext(i))})}i_(){this.state=5,this.t_.Go(async()=>{this.state=0,this.start()})}I_(e){return Y("PersistentStream",`close with error: ${e}`),this.stream=null,this.close(4,e)}h_(e){return n=>{this.ui.enqueueAndForget(()=>this.Yo===e?n():(Y("PersistentStream","stream callback skipped by getCloseGuardedDispatcher."),Promise.resolve()))}}}class zN extends zI{constructor(e,n,r,i,s,o){super(e,"listen_stream_connection_backoff","listen_stream_idle","health_check_timeout",n,r,i,o),this.serializer=s}T_(e,n){return this.connection.Bo("Listen",e,n)}E_(e){return this.onNext(e)}onNext(e){this.t_.reset();const n=Zb(this.serializer,e),r=function(s){if(!("targetChange"in s))return ie.min();const o=s.targetChange;return o.targetIds&&o.targetIds.length?ie.min():o.readTime?Qn(o.readTime):ie.min()}(e);return this.listener.d_(n,r)}A_(e){const n={};n.database=hp(this.serializer),n.addTarget=function(s,o){let a;const u=o.target;if(a=sp(u)?{documents:nN(s,u)}:{query:rN(s,u)._t},a.targetId=o.targetId,o.resumeToken.approximateByteSize()>0){a.resumeToken=bI(s,o.resumeToken);const c=lp(s,o.expectedCount);c!==null&&(a.expectedCount=c)}else if(o.snapshotVersion.compareTo(ie.min())>0){a.readTime=Sc(s,o.snapshotVersion.toTimestamp());const c=lp(s,o.expectedCount);c!==null&&(a.expectedCount=c)}return a}(this.serializer,e);const r=sN(this.serializer,e);r&&(n.labels=r),this.a_(n)}R_(e){const n={};n.database=hp(this.serializer),n.removeTarget=e,this.a_(n)}}class BN extends zI{constructor(e,n,r,i,s,o){super(e,"write_stream_connection_backoff","write_stream_idle","health_check_timeout",n,r,i,o),this.serializer=s}get V_(){return this.e_>0}start(){this.lastStreamToken=void 0,super.start()}l_(){this.V_&&this.m_([])}T_(e,n){return this.connection.Bo("Write",e,n)}E_(e){return Se(!!e.streamToken),this.lastStreamToken=e.streamToken,Se(!e.writeResults||e.writeResults.length===0),this.listener.f_()}onNext(e){Se(!!e.streamToken),this.lastStreamToken=e.streamToken,this.t_.reset();const n=tN(e.writeResults,e.commitTime),r=Qn(e.commitTime);return this.listener.g_(r,n)}p_(){const e={};e.database=hp(this.serializer),this.a_(e)}m_(e){const n={streamToken:this.lastStreamToken,writes:e.map(r=>eN(this.serializer,r))};this.a_(n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class $N extends class{}{constructor(e,n,r,i){super(),this.authCredentials=e,this.appCheckCredentials=n,this.connection=r,this.serializer=i,this.y_=!1}w_(){if(this.y_)throw new K(U.FAILED_PRECONDITION,"The client has already been terminated.")}Mo(e,n,r,i){return this.w_(),Promise.all([this.authCredentials.getToken(),this.appCheckCredentials.getToken()]).then(([s,o])=>this.connection.Mo(e,up(n,r),i,s,o)).catch(s=>{throw s.name==="FirebaseError"?(s.code===U.UNAUTHENTICATED&&(this.authCredentials.invalidateToken(),this.appCheckCredentials.invalidateToken()),s):new K(U.UNKNOWN,s.toString())})}Lo(e,n,r,i,s){return this.w_(),Promise.all([this.authCredentials.getToken(),this.appCheckCredentials.getToken()]).then(([o,a])=>this.connection.Lo(e,up(n,r),i,o,a,s)).catch(o=>{throw o.name==="FirebaseError"?(o.code===U.UNAUTHENTICATED&&(this.authCredentials.invalidateToken(),this.appCheckCredentials.invalidateToken()),o):new K(U.UNKNOWN,o.toString())})}terminate(){this.y_=!0,this.connection.terminate()}}class WN{constructor(e,n){this.asyncQueue=e,this.onlineStateHandler=n,this.state="Unknown",this.S_=0,this.b_=null,this.D_=!0}v_(){this.S_===0&&(this.C_("Unknown"),this.b_=this.asyncQueue.enqueueAfterDelay("online_state_timeout",1e4,()=>(this.b_=null,this.F_("Backend didn't respond within 10 seconds."),this.C_("Offline"),Promise.resolve())))}M_(e){this.state==="Online"?this.C_("Unknown"):(this.S_++,this.S_>=1&&(this.x_(),this.F_(`Connection failed 1 times. Most recent error: ${e.toString()}`),this.C_("Offline")))}set(e){this.x_(),this.S_=0,e==="Online"&&(this.D_=!1),this.C_(e)}C_(e){e!==this.state&&(this.state=e,this.onlineStateHandler(e))}F_(e){const n=`Could not reach Cloud Firestore backend. ${e}
This typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.`;this.D_?(Er(n),this.D_=!1):Y("OnlineStateTracker",n)}x_(){this.b_!==null&&(this.b_.cancel(),this.b_=null)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class qN{constructor(e,n,r,i,s){this.localStore=e,this.datastore=n,this.asyncQueue=r,this.remoteSyncer={},this.O_=[],this.N_=new Map,this.L_=new Set,this.B_=[],this.k_=s,this.k_._o(o=>{r.enqueueAndForget(async()=>{ns(this)&&(Y("RemoteStore","Restarting streams for network reachability change."),await async function(u){const c=se(u);c.L_.add(4),await wl(c),c.q_.set("Unknown"),c.L_.delete(4),await vh(c)}(this))})}),this.q_=new WN(r,i)}}async function vh(t){if(ns(t))for(const e of t.B_)await e(!0)}async function wl(t){for(const e of t.B_)await e(!1)}function BI(t,e){const n=se(t);n.N_.has(e.targetId)||(n.N_.set(e.targetId,e),eg(n)?Zm(n):vo(n).r_()&&Jm(n,e))}function Xm(t,e){const n=se(t),r=vo(n);n.N_.delete(e),r.r_()&&$I(n,e),n.N_.size===0&&(r.r_()?r.o_():ns(n)&&n.q_.set("Unknown"))}function Jm(t,e){if(t.Q_.xe(e.targetId),e.resumeToken.approximateByteSize()>0||e.snapshotVersion.compareTo(ie.min())>0){const n=t.remoteSyncer.getRemoteKeysForTarget(e.targetId).size;e=e.withExpectedCount(n)}vo(t).A_(e)}function $I(t,e){t.Q_.xe(e),vo(t).R_(e)}function Zm(t){t.Q_=new Hb({getRemoteKeysForTarget:e=>t.remoteSyncer.getRemoteKeysForTarget(e),ot:e=>t.N_.get(e)||null,tt:()=>t.datastore.serializer.databaseId}),vo(t).start(),t.q_.v_()}function eg(t){return ns(t)&&!vo(t).n_()&&t.N_.size>0}function ns(t){return se(t).L_.size===0}function WI(t){t.Q_=void 0}async function HN(t){t.q_.set("Online")}async function GN(t){t.N_.forEach((e,n)=>{Jm(t,e)})}async function KN(t,e){WI(t),eg(t)?(t.q_.M_(e),Zm(t)):t.q_.set("Unknown")}async function QN(t,e,n){if(t.q_.set("Online"),e instanceof PI&&e.state===2&&e.cause)try{await async function(i,s){const o=s.cause;for(const a of s.targetIds)i.N_.has(a)&&(await i.remoteSyncer.rejectListen(a,o),i.N_.delete(a),i.Q_.removeTarget(a))}(t,e)}catch(r){Y("RemoteStore","Failed to remove targets %s: %s ",e.targetIds.join(","),r),await kc(t,r)}else if(e instanceof Uu?t.Q_.Ke(e):e instanceof xI?t.Q_.He(e):t.Q_.We(e),!n.isEqual(ie.min()))try{const r=await UI(t.localStore);n.compareTo(r)>=0&&await function(s,o){const a=s.Q_.rt(o);return a.targetChanges.forEach((u,c)=>{if(u.resumeToken.approximateByteSize()>0){const d=s.N_.get(c);d&&s.N_.set(c,d.withResumeToken(u.resumeToken,o))}}),a.targetMismatches.forEach((u,c)=>{const d=s.N_.get(u);if(!d)return;s.N_.set(u,d.withResumeToken(Ct.EMPTY_BYTE_STRING,d.snapshotVersion)),$I(s,u);const f=new qr(d.target,u,c,d.sequenceNumber);Jm(s,f)}),s.remoteSyncer.applyRemoteEvent(a)}(t,n)}catch(r){Y("RemoteStore","Failed to raise snapshot:",r),await kc(t,r)}}async function kc(t,e,n){if(!_l(e))throw e;t.L_.add(1),await wl(t),t.q_.set("Offline"),n||(n=()=>UI(t.localStore)),t.asyncQueue.enqueueRetryable(async()=>{Y("RemoteStore","Retrying IndexedDB access"),await n(),t.L_.delete(1),await vh(t)})}function qI(t,e){return e().catch(n=>kc(t,n,e))}async function wh(t){const e=se(t),n=di(e);let r=e.O_.length>0?e.O_[e.O_.length-1].batchId:-1;for(;YN(e);)try{const i=await ON(e.localStore,r);if(i===null){e.O_.length===0&&n.o_();break}r=i.batchId,XN(e,i)}catch(i){await kc(e,i)}HI(e)&&GI(e)}function YN(t){return ns(t)&&t.O_.length<10}function XN(t,e){t.O_.push(e);const n=di(t);n.r_()&&n.V_&&n.m_(e.mutations)}function HI(t){return ns(t)&&!di(t).n_()&&t.O_.length>0}function GI(t){di(t).start()}async function JN(t){di(t).p_()}async function ZN(t){const e=di(t);for(const n of t.O_)e.m_(n.mutations)}async function e2(t,e,n){const r=t.O_.shift(),i=qm.from(r,e,n);await qI(t,()=>t.remoteSyncer.applySuccessfulWrite(i)),await wh(t)}async function t2(t,e){e&&di(t).V_&&await async function(r,i){if(function(o){return $b(o)&&o!==U.ABORTED}(i.code)){const s=r.O_.shift();di(r).s_(),await qI(r,()=>r.remoteSyncer.rejectFailedWrite(s.batchId,i)),await wh(r)}}(t,e),HI(t)&&GI(t)}async function Yv(t,e){const n=se(t);n.asyncQueue.verifyOperationInProgress(),Y("RemoteStore","RemoteStore received new credentials");const r=ns(n);n.L_.add(3),await wl(n),r&&n.q_.set("Unknown"),await n.remoteSyncer.handleCredentialChange(e),n.L_.delete(3),await vh(n)}async function n2(t,e){const n=se(t);e?(n.L_.delete(2),await vh(n)):e||(n.L_.add(2),await wl(n),n.q_.set("Unknown"))}function vo(t){return t.K_||(t.K_=function(n,r,i){const s=se(n);return s.w_(),new zN(r,s.connection,s.authCredentials,s.appCheckCredentials,s.serializer,i)}(t.datastore,t.asyncQueue,{Eo:HN.bind(null,t),Ro:GN.bind(null,t),mo:KN.bind(null,t),d_:QN.bind(null,t)}),t.B_.push(async e=>{e?(t.K_.s_(),eg(t)?Zm(t):t.q_.set("Unknown")):(await t.K_.stop(),WI(t))})),t.K_}function di(t){return t.U_||(t.U_=function(n,r,i){const s=se(n);return s.w_(),new BN(r,s.connection,s.authCredentials,s.appCheckCredentials,s.serializer,i)}(t.datastore,t.asyncQueue,{Eo:()=>Promise.resolve(),Ro:JN.bind(null,t),mo:t2.bind(null,t),f_:ZN.bind(null,t),g_:e2.bind(null,t)}),t.B_.push(async e=>{e?(t.U_.s_(),await wh(t)):(await t.U_.stop(),t.O_.length>0&&(Y("RemoteStore",`Stopping write stream with ${t.O_.length} pending writes`),t.O_=[]))})),t.U_}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class tg{constructor(e,n,r,i,s){this.asyncQueue=e,this.timerId=n,this.targetTimeMs=r,this.op=i,this.removalCallback=s,this.deferred=new ni,this.then=this.deferred.promise.then.bind(this.deferred.promise),this.deferred.promise.catch(o=>{})}get promise(){return this.deferred.promise}static createAndSchedule(e,n,r,i,s){const o=Date.now()+r,a=new tg(e,n,o,i,s);return a.start(r),a}start(e){this.timerHandle=setTimeout(()=>this.handleDelayElapsed(),e)}skipDelay(){return this.handleDelayElapsed()}cancel(e){this.timerHandle!==null&&(this.clearTimeout(),this.deferred.reject(new K(U.CANCELLED,"Operation cancelled"+(e?": "+e:""))))}handleDelayElapsed(){this.asyncQueue.enqueueAndForget(()=>this.timerHandle!==null?(this.clearTimeout(),this.op().then(e=>this.deferred.resolve(e))):Promise.resolve())}clearTimeout(){this.timerHandle!==null&&(this.removalCallback(this),clearTimeout(this.timerHandle),this.timerHandle=null)}}function ng(t,e){if(Er("AsyncQueue",`${e}: ${t}`),_l(t))return new K(U.UNAVAILABLE,`${e}: ${t}`);throw t}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class js{constructor(e){this.comparator=e?(n,r)=>e(n,r)||Z.comparator(n.key,r.key):(n,r)=>Z.comparator(n.key,r.key),this.keyedMap=la(),this.sortedSet=new it(this.comparator)}static emptySet(e){return new js(e.comparator)}has(e){return this.keyedMap.get(e)!=null}get(e){return this.keyedMap.get(e)}first(){return this.sortedSet.minKey()}last(){return this.sortedSet.maxKey()}isEmpty(){return this.sortedSet.isEmpty()}indexOf(e){const n=this.keyedMap.get(e);return n?this.sortedSet.indexOf(n):-1}get size(){return this.sortedSet.size}forEach(e){this.sortedSet.inorderTraversal((n,r)=>(e(n),!1))}add(e){const n=this.delete(e.key);return n.copy(n.keyedMap.insert(e.key,e),n.sortedSet.insert(e,null))}delete(e){const n=this.get(e);return n?this.copy(this.keyedMap.remove(e),this.sortedSet.remove(n)):this}isEqual(e){if(!(e instanceof js)||this.size!==e.size)return!1;const n=this.sortedSet.getIterator(),r=e.sortedSet.getIterator();for(;n.hasNext();){const i=n.getNext().key,s=r.getNext().key;if(!i.isEqual(s))return!1}return!0}toString(){const e=[];return this.forEach(n=>{e.push(n.toString())}),e.length===0?"DocumentSet ()":`DocumentSet (
  `+e.join(`  
`)+`
)`}copy(e,n){const r=new js;return r.comparator=this.comparator,r.keyedMap=e,r.sortedSet=n,r}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Xv{constructor(){this.W_=new it(Z.comparator)}track(e){const n=e.doc.key,r=this.W_.get(n);r?e.type!==0&&r.type===3?this.W_=this.W_.insert(n,e):e.type===3&&r.type!==1?this.W_=this.W_.insert(n,{type:r.type,doc:e.doc}):e.type===2&&r.type===2?this.W_=this.W_.insert(n,{type:2,doc:e.doc}):e.type===2&&r.type===0?this.W_=this.W_.insert(n,{type:0,doc:e.doc}):e.type===1&&r.type===0?this.W_=this.W_.remove(n):e.type===1&&r.type===2?this.W_=this.W_.insert(n,{type:1,doc:r.doc}):e.type===0&&r.type===1?this.W_=this.W_.insert(n,{type:2,doc:e.doc}):re():this.W_=this.W_.insert(n,e)}G_(){const e=[];return this.W_.inorderTraversal((n,r)=>{e.push(r)}),e}}class so{constructor(e,n,r,i,s,o,a,u,c){this.query=e,this.docs=n,this.oldDocs=r,this.docChanges=i,this.mutatedKeys=s,this.fromCache=o,this.syncStateChanged=a,this.excludesMetadataChanges=u,this.hasCachedResults=c}static fromInitialDocuments(e,n,r,i,s){const o=[];return n.forEach(a=>{o.push({type:0,doc:a})}),new so(e,n,js.emptySet(n),o,r,i,!0,!1,s)}get hasPendingWrites(){return!this.mutatedKeys.isEmpty()}isEqual(e){if(!(this.fromCache===e.fromCache&&this.hasCachedResults===e.hasCachedResults&&this.syncStateChanged===e.syncStateChanged&&this.mutatedKeys.isEqual(e.mutatedKeys)&&fh(this.query,e.query)&&this.docs.isEqual(e.docs)&&this.oldDocs.isEqual(e.oldDocs)))return!1;const n=this.docChanges,r=e.docChanges;if(n.length!==r.length)return!1;for(let i=0;i<n.length;i++)if(n[i].type!==r[i].type||!n[i].doc.isEqual(r[i].doc))return!1;return!0}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class r2{constructor(){this.z_=void 0,this.j_=[]}H_(){return this.j_.some(e=>e.J_())}}class i2{constructor(){this.queries=Jv(),this.onlineState="Unknown",this.Y_=new Set}terminate(){(function(n,r){const i=se(n),s=i.queries;i.queries=Jv(),s.forEach((o,a)=>{for(const u of a.j_)u.onError(r)})})(this,new K(U.ABORTED,"Firestore shutting down"))}}function Jv(){return new yo(t=>gI(t),fh)}async function s2(t,e){const n=se(t);let r=3;const i=e.query;let s=n.queries.get(i);s?!s.H_()&&e.J_()&&(r=2):(s=new r2,r=e.J_()?0:1);try{switch(r){case 0:s.z_=await n.onListen(i,!0);break;case 1:s.z_=await n.onListen(i,!1);break;case 2:await n.onFirstRemoteStoreListen(i)}}catch(o){const a=ng(o,`Initialization of query '${_s(e.query)}' failed`);return void e.onError(a)}n.queries.set(i,s),s.j_.push(e),e.Z_(n.onlineState),s.z_&&e.X_(s.z_)&&rg(n)}async function o2(t,e){const n=se(t),r=e.query;let i=3;const s=n.queries.get(r);if(s){const o=s.j_.indexOf(e);o>=0&&(s.j_.splice(o,1),s.j_.length===0?i=e.J_()?0:1:!s.H_()&&e.J_()&&(i=2))}switch(i){case 0:return n.queries.delete(r),n.onUnlisten(r,!0);case 1:return n.queries.delete(r),n.onUnlisten(r,!1);case 2:return n.onLastRemoteStoreUnlisten(r);default:return}}function a2(t,e){const n=se(t);let r=!1;for(const i of e){const s=i.query,o=n.queries.get(s);if(o){for(const a of o.j_)a.X_(i)&&(r=!0);o.z_=i}}r&&rg(n)}function l2(t,e,n){const r=se(t),i=r.queries.get(e);if(i)for(const s of i.j_)s.onError(n);r.queries.delete(e)}function rg(t){t.Y_.forEach(e=>{e.next()})}var fp,Zv;(Zv=fp||(fp={})).ea="default",Zv.Cache="cache";class u2{constructor(e,n,r){this.query=e,this.ta=n,this.na=!1,this.ra=null,this.onlineState="Unknown",this.options=r||{}}X_(e){if(!this.options.includeMetadataChanges){const r=[];for(const i of e.docChanges)i.type!==3&&r.push(i);e=new so(e.query,e.docs,e.oldDocs,r,e.mutatedKeys,e.fromCache,e.syncStateChanged,!0,e.hasCachedResults)}let n=!1;return this.na?this.ia(e)&&(this.ta.next(e),n=!0):this.sa(e,this.onlineState)&&(this.oa(e),n=!0),this.ra=e,n}onError(e){this.ta.error(e)}Z_(e){this.onlineState=e;let n=!1;return this.ra&&!this.na&&this.sa(this.ra,e)&&(this.oa(this.ra),n=!0),n}sa(e,n){if(!e.fromCache||!this.J_())return!0;const r=n!=="Offline";return(!this.options._a||!r)&&(!e.docs.isEmpty()||e.hasCachedResults||n==="Offline")}ia(e){if(e.docChanges.length>0)return!0;const n=this.ra&&this.ra.hasPendingWrites!==e.hasPendingWrites;return!(!e.syncStateChanged&&!n)&&this.options.includeMetadataChanges===!0}oa(e){e=so.fromInitialDocuments(e.query,e.docs,e.mutatedKeys,e.fromCache,e.hasCachedResults),this.na=!0,this.ta.next(e)}J_(){return this.options.source!==fp.Cache}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class KI{constructor(e){this.key=e}}class QI{constructor(e){this.key=e}}class c2{constructor(e,n){this.query=e,this.Ta=n,this.Ea=null,this.hasCachedResults=!1,this.current=!1,this.da=de(),this.mutatedKeys=de(),this.Aa=_I(e),this.Ra=new js(this.Aa)}get Va(){return this.Ta}ma(e,n){const r=n?n.fa:new Xv,i=n?n.Ra:this.Ra;let s=n?n.mutatedKeys:this.mutatedKeys,o=i,a=!1;const u=this.query.limitType==="F"&&i.size===this.query.limit?i.last():null,c=this.query.limitType==="L"&&i.size===this.query.limit?i.first():null;if(e.inorderTraversal((d,f)=>{const m=i.get(d),w=ph(this.query,f)?f:null,I=!!m&&this.mutatedKeys.has(m.key),P=!!w&&(w.hasLocalMutations||this.mutatedKeys.has(w.key)&&w.hasCommittedMutations);let O=!1;m&&w?m.data.isEqual(w.data)?I!==P&&(r.track({type:3,doc:w}),O=!0):this.ga(m,w)||(r.track({type:2,doc:w}),O=!0,(u&&this.Aa(w,u)>0||c&&this.Aa(w,c)<0)&&(a=!0)):!m&&w?(r.track({type:0,doc:w}),O=!0):m&&!w&&(r.track({type:1,doc:m}),O=!0,(u||c)&&(a=!0)),O&&(w?(o=o.add(w),s=P?s.add(d):s.delete(d)):(o=o.delete(d),s=s.delete(d)))}),this.query.limit!==null)for(;o.size>this.query.limit;){const d=this.query.limitType==="F"?o.last():o.first();o=o.delete(d.key),s=s.delete(d.key),r.track({type:1,doc:d})}return{Ra:o,fa:r,ns:a,mutatedKeys:s}}ga(e,n){return e.hasLocalMutations&&n.hasCommittedMutations&&!n.hasLocalMutations}applyChanges(e,n,r,i){const s=this.Ra;this.Ra=e.Ra,this.mutatedKeys=e.mutatedKeys;const o=e.fa.G_();o.sort((d,f)=>function(w,I){const P=O=>{switch(O){case 0:return 1;case 2:case 3:return 2;case 1:return 0;default:return re()}};return P(w)-P(I)}(d.type,f.type)||this.Aa(d.doc,f.doc)),this.pa(r),i=i!=null&&i;const a=n&&!i?this.ya():[],u=this.da.size===0&&this.current&&!i?1:0,c=u!==this.Ea;return this.Ea=u,o.length!==0||c?{snapshot:new so(this.query,e.Ra,s,o,e.mutatedKeys,u===0,c,!1,!!r&&r.resumeToken.approximateByteSize()>0),wa:a}:{wa:a}}Z_(e){return this.current&&e==="Offline"?(this.current=!1,this.applyChanges({Ra:this.Ra,fa:new Xv,mutatedKeys:this.mutatedKeys,ns:!1},!1)):{wa:[]}}Sa(e){return!this.Ta.has(e)&&!!this.Ra.has(e)&&!this.Ra.get(e).hasLocalMutations}pa(e){e&&(e.addedDocuments.forEach(n=>this.Ta=this.Ta.add(n)),e.modifiedDocuments.forEach(n=>{}),e.removedDocuments.forEach(n=>this.Ta=this.Ta.delete(n)),this.current=e.current)}ya(){if(!this.current)return[];const e=this.da;this.da=de(),this.Ra.forEach(r=>{this.Sa(r.key)&&(this.da=this.da.add(r.key))});const n=[];return e.forEach(r=>{this.da.has(r)||n.push(new QI(r))}),this.da.forEach(r=>{e.has(r)||n.push(new KI(r))}),n}ba(e){this.Ta=e.Ts,this.da=de();const n=this.ma(e.documents);return this.applyChanges(n,!0)}Da(){return so.fromInitialDocuments(this.query,this.Ra,this.mutatedKeys,this.Ea===0,this.hasCachedResults)}}class h2{constructor(e,n,r){this.query=e,this.targetId=n,this.view=r}}class d2{constructor(e){this.key=e,this.va=!1}}class f2{constructor(e,n,r,i,s,o){this.localStore=e,this.remoteStore=n,this.eventManager=r,this.sharedClientState=i,this.currentUser=s,this.maxConcurrentLimboResolutions=o,this.Ca={},this.Fa=new yo(a=>gI(a),fh),this.Ma=new Map,this.xa=new Set,this.Oa=new it(Z.comparator),this.Na=new Map,this.La=new Km,this.Ba={},this.ka=new Map,this.qa=io.kn(),this.onlineState="Unknown",this.Qa=void 0}get isPrimaryClient(){return this.Qa===!0}}async function p2(t,e,n=!0){const r=tS(t);let i;const s=r.Fa.get(e);return s?(r.sharedClientState.addLocalQueryTarget(s.targetId),i=s.view.Da()):i=await YI(r,e,n,!0),i}async function m2(t,e){const n=tS(t);await YI(n,e,!0,!1)}async function YI(t,e,n,r){const i=await DN(t.localStore,Gn(e)),s=i.targetId,o=t.sharedClientState.addLocalQueryTarget(s,n);let a;return r&&(a=await g2(t,e,s,o==="current",i.resumeToken)),t.isPrimaryClient&&n&&BI(t.remoteStore,i),a}async function g2(t,e,n,r,i){t.Ka=(f,m,w)=>async function(P,O,C,T){let S=O.view.ma(C);S.ns&&(S=await Gv(P.localStore,O.query,!1).then(({documents:y})=>O.view.ma(y,S)));const M=T&&T.targetChanges.get(O.targetId),V=T&&T.targetMismatches.get(O.targetId)!=null,F=O.view.applyChanges(S,P.isPrimaryClient,M,V);return tw(P,O.targetId,F.wa),F.snapshot}(t,f,m,w);const s=await Gv(t.localStore,e,!0),o=new c2(e,s.Ts),a=o.ma(s.documents),u=vl.createSynthesizedTargetChangeForCurrentChange(n,r&&t.onlineState!=="Offline",i),c=o.applyChanges(a,t.isPrimaryClient,u);tw(t,n,c.wa);const d=new h2(e,n,o);return t.Fa.set(e,d),t.Ma.has(n)?t.Ma.get(n).push(e):t.Ma.set(n,[e]),c.snapshot}async function _2(t,e,n){const r=se(t),i=r.Fa.get(e),s=r.Ma.get(i.targetId);if(s.length>1)return r.Ma.set(i.targetId,s.filter(o=>!fh(o,e))),void r.Fa.delete(e);r.isPrimaryClient?(r.sharedClientState.removeLocalQueryTarget(i.targetId),r.sharedClientState.isActiveQueryTarget(i.targetId)||await dp(r.localStore,i.targetId,!1).then(()=>{r.sharedClientState.clearQueryState(i.targetId),n&&Xm(r.remoteStore,i.targetId),pp(r,i.targetId)}).catch(gl)):(pp(r,i.targetId),await dp(r.localStore,i.targetId,!0))}async function y2(t,e){const n=se(t),r=n.Fa.get(e),i=n.Ma.get(r.targetId);n.isPrimaryClient&&i.length===1&&(n.sharedClientState.removeLocalQueryTarget(r.targetId),Xm(n.remoteStore,r.targetId))}async function v2(t,e,n){const r=C2(t);try{const i=await function(o,a){const u=se(o),c=ut.now(),d=a.reduce((w,I)=>w.add(I.key),de());let f,m;return u.persistence.runTransaction("Locally write mutations","readwrite",w=>{let I=Tr(),P=de();return u.cs.getEntries(w,d).next(O=>{I=O,I.forEach((C,T)=>{T.isValidDocument()||(P=P.add(C))})}).next(()=>u.localDocuments.getOverlayedDocuments(w,I)).next(O=>{f=O;const C=[];for(const T of a){const S=Fb(T,f.get(T.key).overlayedDocument);S!=null&&C.push(new ts(T.key,S,aI(S.value.mapValue),Kn.exists(!0)))}return u.mutationQueue.addMutationBatch(w,c,C,a)}).next(O=>{m=O;const C=O.applyToLocalDocumentSet(f,P);return u.documentOverlayCache.saveOverlays(w,O.batchId,C)})}).then(()=>({batchId:m.batchId,changes:vI(f)}))}(r.localStore,e);r.sharedClientState.addPendingMutation(i.batchId),function(o,a,u){let c=o.Ba[o.currentUser.toKey()];c||(c=new it(ye)),c=c.insert(a,u),o.Ba[o.currentUser.toKey()]=c}(r,i.batchId,n),await El(r,i.changes),await wh(r.remoteStore)}catch(i){const s=ng(i,"Failed to persist write");n.reject(s)}}async function XI(t,e){const n=se(t);try{const r=await bN(n.localStore,e);e.targetChanges.forEach((i,s)=>{const o=n.Na.get(s);o&&(Se(i.addedDocuments.size+i.modifiedDocuments.size+i.removedDocuments.size<=1),i.addedDocuments.size>0?o.va=!0:i.modifiedDocuments.size>0?Se(o.va):i.removedDocuments.size>0&&(Se(o.va),o.va=!1))}),await El(n,r,e)}catch(r){await gl(r)}}function ew(t,e,n){const r=se(t);if(r.isPrimaryClient&&n===0||!r.isPrimaryClient&&n===1){const i=[];r.Fa.forEach((s,o)=>{const a=o.view.Z_(e);a.snapshot&&i.push(a.snapshot)}),function(o,a){const u=se(o);u.onlineState=a;let c=!1;u.queries.forEach((d,f)=>{for(const m of f.j_)m.Z_(a)&&(c=!0)}),c&&rg(u)}(r.eventManager,e),i.length&&r.Ca.d_(i),r.onlineState=e,r.isPrimaryClient&&r.sharedClientState.setOnlineState(e)}}async function w2(t,e,n){const r=se(t);r.sharedClientState.updateQueryState(e,"rejected",n);const i=r.Na.get(e),s=i&&i.key;if(s){let o=new it(Z.comparator);o=o.insert(s,Dt.newNoDocument(s,ie.min()));const a=de().add(s),u=new _h(ie.min(),new Map,new it(ye),o,a);await XI(r,u),r.Oa=r.Oa.remove(s),r.Na.delete(e),ig(r)}else await dp(r.localStore,e,!1).then(()=>pp(r,e,n)).catch(gl)}async function E2(t,e){const n=se(t),r=e.batch.batchId;try{const i=await PN(n.localStore,e);ZI(n,r,null),JI(n,r),n.sharedClientState.updateMutationState(r,"acknowledged"),await El(n,i)}catch(i){await gl(i)}}async function T2(t,e,n){const r=se(t);try{const i=await function(o,a){const u=se(o);return u.persistence.runTransaction("Reject batch","readwrite-primary",c=>{let d;return u.mutationQueue.lookupMutationBatch(c,a).next(f=>(Se(f!==null),d=f.keys(),u.mutationQueue.removeMutationBatch(c,f))).next(()=>u.mutationQueue.performConsistencyCheck(c)).next(()=>u.documentOverlayCache.removeOverlaysForBatchId(c,d,a)).next(()=>u.localDocuments.recalculateAndSaveOverlaysForDocumentKeys(c,d)).next(()=>u.localDocuments.getDocuments(c,d))})}(r.localStore,e);ZI(r,e,n),JI(r,e),r.sharedClientState.updateMutationState(e,"rejected",n),await El(r,i)}catch(i){await gl(i)}}function JI(t,e){(t.ka.get(e)||[]).forEach(n=>{n.resolve()}),t.ka.delete(e)}function ZI(t,e,n){const r=se(t);let i=r.Ba[r.currentUser.toKey()];if(i){const s=i.get(e);s&&(n?s.reject(n):s.resolve(),i=i.remove(e)),r.Ba[r.currentUser.toKey()]=i}}function pp(t,e,n=null){t.sharedClientState.removeLocalQueryTarget(e);for(const r of t.Ma.get(e))t.Fa.delete(r),n&&t.Ca.$a(r,n);t.Ma.delete(e),t.isPrimaryClient&&t.La.gr(e).forEach(r=>{t.La.containsKey(r)||eS(t,r)})}function eS(t,e){t.xa.delete(e.path.canonicalString());const n=t.Oa.get(e);n!==null&&(Xm(t.remoteStore,n),t.Oa=t.Oa.remove(e),t.Na.delete(n),ig(t))}function tw(t,e,n){for(const r of n)r instanceof KI?(t.La.addReference(r.key,e),I2(t,r)):r instanceof QI?(Y("SyncEngine","Document no longer in limbo: "+r.key),t.La.removeReference(r.key,e),t.La.containsKey(r.key)||eS(t,r.key)):re()}function I2(t,e){const n=e.key,r=n.path.canonicalString();t.Oa.get(n)||t.xa.has(r)||(Y("SyncEngine","New document in limbo: "+n),t.xa.add(r),ig(t))}function ig(t){for(;t.xa.size>0&&t.Oa.size<t.maxConcurrentLimboResolutions;){const e=t.xa.values().next().value;t.xa.delete(e);const n=new Z(Fe.fromString(e)),r=t.qa.next();t.Na.set(r,new d2(n)),t.Oa=t.Oa.insert(n,r),BI(t.remoteStore,new qr(Gn(pI(n.path)),r,"TargetPurposeLimboResolution",Vm.oe))}}async function El(t,e,n){const r=se(t),i=[],s=[],o=[];r.Fa.isEmpty()||(r.Fa.forEach((a,u)=>{o.push(r.Ka(u,e,n).then(c=>{var d;if((c||n)&&r.isPrimaryClient){const f=c?!c.fromCache:(d=n==null?void 0:n.targetChanges.get(u.targetId))===null||d===void 0?void 0:d.current;r.sharedClientState.updateQueryState(u.targetId,f?"current":"not-current")}if(c){i.push(c);const f=Ym.Wi(u.targetId,c);s.push(f)}}))}),await Promise.all(o),r.Ca.d_(i),await async function(u,c){const d=se(u);try{await d.persistence.runTransaction("notifyLocalViewChanges","readwrite",f=>j.forEach(c,m=>j.forEach(m.$i,w=>d.persistence.referenceDelegate.addReference(f,m.targetId,w)).next(()=>j.forEach(m.Ui,w=>d.persistence.referenceDelegate.removeReference(f,m.targetId,w)))))}catch(f){if(!_l(f))throw f;Y("LocalStore","Failed to update sequence numbers: "+f)}for(const f of c){const m=f.targetId;if(!f.fromCache){const w=d.os.get(m),I=w.snapshotVersion,P=w.withLastLimboFreeSnapshotVersion(I);d.os=d.os.insert(m,P)}}}(r.localStore,s))}async function S2(t,e){const n=se(t);if(!n.currentUser.isEqual(e)){Y("SyncEngine","User change. New user:",e.toKey());const r=await FI(n.localStore,e);n.currentUser=e,function(s,o){s.ka.forEach(a=>{a.forEach(u=>{u.reject(new K(U.CANCELLED,o))})}),s.ka.clear()}(n,"'waitForPendingWrites' promise is rejected due to a user change."),n.sharedClientState.handleUserChange(e,r.removedBatchIds,r.addedBatchIds),await El(n,r.hs)}}function k2(t,e){const n=se(t),r=n.Na.get(e);if(r&&r.va)return de().add(r.key);{let i=de();const s=n.Ma.get(e);if(!s)return i;for(const o of s){const a=n.Fa.get(o);i=i.unionWith(a.view.Va)}return i}}function tS(t){const e=se(t);return e.remoteStore.remoteSyncer.applyRemoteEvent=XI.bind(null,e),e.remoteStore.remoteSyncer.getRemoteKeysForTarget=k2.bind(null,e),e.remoteStore.remoteSyncer.rejectListen=w2.bind(null,e),e.Ca.d_=a2.bind(null,e.eventManager),e.Ca.$a=l2.bind(null,e.eventManager),e}function C2(t){const e=se(t);return e.remoteStore.remoteSyncer.applySuccessfulWrite=E2.bind(null,e),e.remoteStore.remoteSyncer.rejectFailedWrite=T2.bind(null,e),e}class Cc{constructor(){this.kind="memory",this.synchronizeTabs=!1}async initialize(e){this.serializer=yh(e.databaseInfo.databaseId),this.sharedClientState=this.Wa(e),this.persistence=this.Ga(e),await this.persistence.start(),this.localStore=this.za(e),this.gcScheduler=this.ja(e,this.localStore),this.indexBackfillerScheduler=this.Ha(e,this.localStore)}ja(e,n){return null}Ha(e,n){return null}za(e){return xN(this.persistence,new RN,e.initialUser,this.serializer)}Ga(e){return new SN(Qm.Zr,this.serializer)}Wa(e){return new LN}async terminate(){var e,n;(e=this.gcScheduler)===null||e===void 0||e.stop(),(n=this.indexBackfillerScheduler)===null||n===void 0||n.stop(),this.sharedClientState.shutdown(),await this.persistence.shutdown()}}Cc.provider={build:()=>new Cc};class mp{async initialize(e,n){this.localStore||(this.localStore=e.localStore,this.sharedClientState=e.sharedClientState,this.datastore=this.createDatastore(n),this.remoteStore=this.createRemoteStore(n),this.eventManager=this.createEventManager(n),this.syncEngine=this.createSyncEngine(n,!e.synchronizeTabs),this.sharedClientState.onlineStateHandler=r=>ew(this.syncEngine,r,1),this.remoteStore.remoteSyncer.handleCredentialChange=S2.bind(null,this.syncEngine),await n2(this.remoteStore,this.syncEngine.isPrimaryClient))}createEventManager(e){return function(){return new i2}()}createDatastore(e){const n=yh(e.databaseInfo.databaseId),r=function(s){return new jN(s)}(e.databaseInfo);return function(s,o,a,u){return new $N(s,o,a,u)}(e.authCredentials,e.appCheckCredentials,r,n)}createRemoteStore(e){return function(r,i,s,o,a){return new qN(r,i,s,o,a)}(this.localStore,this.datastore,e.asyncQueue,n=>ew(this.syncEngine,n,0),function(){return Qv.D()?new Qv:new VN}())}createSyncEngine(e,n){return function(i,s,o,a,u,c,d){const f=new f2(i,s,o,a,u,c);return d&&(f.Qa=!0),f}(this.localStore,this.remoteStore,this.eventManager,this.sharedClientState,e.initialUser,e.maxConcurrentLimboResolutions,n)}async terminate(){var e,n;await async function(i){const s=se(i);Y("RemoteStore","RemoteStore shutting down."),s.L_.add(5),await wl(s),s.k_.shutdown(),s.q_.set("Unknown")}(this.remoteStore),(e=this.datastore)===null||e===void 0||e.terminate(),(n=this.eventManager)===null||n===void 0||n.terminate()}}mp.provider={build:()=>new mp};/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *//**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class R2{constructor(e){this.observer=e,this.muted=!1}next(e){this.muted||this.observer.next&&this.Ya(this.observer.next,e)}error(e){this.muted||(this.observer.error?this.Ya(this.observer.error,e):Er("Uncaught Error in snapshot listener:",e.toString()))}Za(){this.muted=!0}Ya(e,n){setTimeout(()=>{this.muted||e(n)},0)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class A2{constructor(e,n,r,i,s){this.authCredentials=e,this.appCheckCredentials=n,this.asyncQueue=r,this.databaseInfo=i,this.user=Nt.UNAUTHENTICATED,this.clientId=iI.newId(),this.authCredentialListener=()=>Promise.resolve(),this.appCheckCredentialListener=()=>Promise.resolve(),this._uninitializedComponentsProvider=s,this.authCredentials.start(r,async o=>{Y("FirestoreClient","Received user=",o.uid),await this.authCredentialListener(o),this.user=o}),this.appCheckCredentials.start(r,o=>(Y("FirestoreClient","Received new app check token=",o),this.appCheckCredentialListener(o,this.user)))}get configuration(){return{asyncQueue:this.asyncQueue,databaseInfo:this.databaseInfo,clientId:this.clientId,authCredentials:this.authCredentials,appCheckCredentials:this.appCheckCredentials,initialUser:this.user,maxConcurrentLimboResolutions:100}}setCredentialChangeListener(e){this.authCredentialListener=e}setAppCheckTokenChangeListener(e){this.appCheckCredentialListener=e}terminate(){this.asyncQueue.enterRestrictedMode();const e=new ni;return this.asyncQueue.enqueueAndForgetEvenWhileRestricted(async()=>{try{this._onlineComponents&&await this._onlineComponents.terminate(),this._offlineComponents&&await this._offlineComponents.terminate(),this.authCredentials.shutdown(),this.appCheckCredentials.shutdown(),e.resolve()}catch(n){const r=ng(n,"Failed to shutdown persistence");e.reject(r)}}),e.promise}}async function Dd(t,e){t.asyncQueue.verifyOperationInProgress(),Y("FirestoreClient","Initializing OfflineComponentProvider");const n=t.configuration;await e.initialize(n);let r=n.initialUser;t.setCredentialChangeListener(async i=>{r.isEqual(i)||(await FI(e.localStore,i),r=i)}),e.persistence.setDatabaseDeletedListener(()=>t.terminate()),t._offlineComponents=e}async function nw(t,e){t.asyncQueue.verifyOperationInProgress();const n=await x2(t);Y("FirestoreClient","Initializing OnlineComponentProvider"),await e.initialize(n,t.configuration),t.setCredentialChangeListener(r=>Yv(e.remoteStore,r)),t.setAppCheckTokenChangeListener((r,i)=>Yv(e.remoteStore,i)),t._onlineComponents=e}async function x2(t){if(!t._offlineComponents)if(t._uninitializedComponentsProvider){Y("FirestoreClient","Using user provided OfflineComponentProvider");try{await Dd(t,t._uninitializedComponentsProvider._offline)}catch(e){const n=e;if(!function(i){return i.name==="FirebaseError"?i.code===U.FAILED_PRECONDITION||i.code===U.UNIMPLEMENTED:!(typeof DOMException<"u"&&i instanceof DOMException)||i.code===22||i.code===20||i.code===11}(n))throw n;eo("Error using user provided cache. Falling back to memory cache: "+n),await Dd(t,new Cc)}}else Y("FirestoreClient","Using default OfflineComponentProvider"),await Dd(t,new Cc);return t._offlineComponents}async function nS(t){return t._onlineComponents||(t._uninitializedComponentsProvider?(Y("FirestoreClient","Using user provided OnlineComponentProvider"),await nw(t,t._uninitializedComponentsProvider._online)):(Y("FirestoreClient","Using default OnlineComponentProvider"),await nw(t,new mp))),t._onlineComponents}function P2(t){return nS(t).then(e=>e.syncEngine)}async function b2(t){const e=await nS(t),n=e.eventManager;return n.onListen=p2.bind(null,e.syncEngine),n.onUnlisten=_2.bind(null,e.syncEngine),n.onFirstRemoteStoreListen=m2.bind(null,e.syncEngine),n.onLastRemoteStoreUnlisten=y2.bind(null,e.syncEngine),n}function N2(t,e,n={}){const r=new ni;return t.asyncQueue.enqueueAndForget(async()=>function(s,o,a,u,c){const d=new R2({next:m=>{d.Za(),o.enqueueAndForget(()=>o2(s,f)),m.fromCache&&u.source==="server"?c.reject(new K(U.UNAVAILABLE,'Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to "server" to retrieve the cached documents.)')):c.resolve(m)},error:m=>c.reject(m)}),f=new u2(a,d,{includeMetadataChanges:!0,_a:!0});return s2(s,f)}(await b2(t),t.asyncQueue,e,n,r)),r.promise}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function rS(t){const e={};return t.timeoutSeconds!==void 0&&(e.timeoutSeconds=t.timeoutSeconds),e}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const rw=new Map;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function iS(t,e,n){if(!n)throw new K(U.INVALID_ARGUMENT,`Function ${t}() cannot be called with an empty ${e}.`)}function O2(t,e,n,r){if(e===!0&&r===!0)throw new K(U.INVALID_ARGUMENT,`${t} and ${n} cannot be used together.`)}function iw(t){if(!Z.isDocumentKey(t))throw new K(U.INVALID_ARGUMENT,`Invalid document reference. Document references must have an even number of segments, but ${t} has ${t.length}.`)}function sw(t){if(Z.isDocumentKey(t))throw new K(U.INVALID_ARGUMENT,`Invalid collection reference. Collection references must have an odd number of segments, but ${t} has ${t.length}.`)}function Eh(t){if(t===void 0)return"undefined";if(t===null)return"null";if(typeof t=="string")return t.length>20&&(t=`${t.substring(0,20)}...`),JSON.stringify(t);if(typeof t=="number"||typeof t=="boolean")return""+t;if(typeof t=="object"){if(t instanceof Array)return"an array";{const e=function(r){return r.constructor?r.constructor.name:null}(t);return e?`a custom ${e} object`:"an object"}}return typeof t=="function"?"a function":re()}function sl(t,e){if("_delegate"in t&&(t=t._delegate),!(t instanceof e)){if(e.name===t.constructor.name)throw new K(U.INVALID_ARGUMENT,"Type does not match the expected instance. Did you pass a reference from a different Firestore SDK?");{const n=Eh(t);throw new K(U.INVALID_ARGUMENT,`Expected type '${e.name}', but it was: ${n}`)}}return t}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ow{constructor(e){var n,r;if(e.host===void 0){if(e.ssl!==void 0)throw new K(U.INVALID_ARGUMENT,"Can't provide ssl option if host option is not set");this.host="firestore.googleapis.com",this.ssl=!0}else this.host=e.host,this.ssl=(n=e.ssl)===null||n===void 0||n;if(this.credentials=e.credentials,this.ignoreUndefinedProperties=!!e.ignoreUndefinedProperties,this.localCache=e.localCache,e.cacheSizeBytes===void 0)this.cacheSizeBytes=41943040;else{if(e.cacheSizeBytes!==-1&&e.cacheSizeBytes<1048576)throw new K(U.INVALID_ARGUMENT,"cacheSizeBytes must be at least 1048576");this.cacheSizeBytes=e.cacheSizeBytes}O2("experimentalForceLongPolling",e.experimentalForceLongPolling,"experimentalAutoDetectLongPolling",e.experimentalAutoDetectLongPolling),this.experimentalForceLongPolling=!!e.experimentalForceLongPolling,this.experimentalForceLongPolling?this.experimentalAutoDetectLongPolling=!1:e.experimentalAutoDetectLongPolling===void 0?this.experimentalAutoDetectLongPolling=!0:this.experimentalAutoDetectLongPolling=!!e.experimentalAutoDetectLongPolling,this.experimentalLongPollingOptions=rS((r=e.experimentalLongPollingOptions)!==null&&r!==void 0?r:{}),function(s){if(s.timeoutSeconds!==void 0){if(isNaN(s.timeoutSeconds))throw new K(U.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (must not be NaN)`);if(s.timeoutSeconds<5)throw new K(U.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (minimum allowed value is 5)`);if(s.timeoutSeconds>30)throw new K(U.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (maximum allowed value is 30)`)}}(this.experimentalLongPollingOptions),this.useFetchStreams=!!e.useFetchStreams}isEqual(e){return this.host===e.host&&this.ssl===e.ssl&&this.credentials===e.credentials&&this.cacheSizeBytes===e.cacheSizeBytes&&this.experimentalForceLongPolling===e.experimentalForceLongPolling&&this.experimentalAutoDetectLongPolling===e.experimentalAutoDetectLongPolling&&function(r,i){return r.timeoutSeconds===i.timeoutSeconds}(this.experimentalLongPollingOptions,e.experimentalLongPollingOptions)&&this.ignoreUndefinedProperties===e.ignoreUndefinedProperties&&this.useFetchStreams===e.useFetchStreams}}class Th{constructor(e,n,r,i){this._authCredentials=e,this._appCheckCredentials=n,this._databaseId=r,this._app=i,this.type="firestore-lite",this._persistenceKey="(lite)",this._settings=new ow({}),this._settingsFrozen=!1,this._terminateTask="notTerminated"}get app(){if(!this._app)throw new K(U.FAILED_PRECONDITION,"Firestore was not initialized using the Firebase SDK. 'app' is not available");return this._app}get _initialized(){return this._settingsFrozen}get _terminated(){return this._terminateTask!=="notTerminated"}_setSettings(e){if(this._settingsFrozen)throw new K(U.FAILED_PRECONDITION,"Firestore has already been started and its settings can no longer be changed. You can only modify settings before calling any other methods on a Firestore object.");this._settings=new ow(e),e.credentials!==void 0&&(this._authCredentials=function(r){if(!r)return new HP;switch(r.type){case"firstParty":return new YP(r.sessionIndex||"0",r.iamToken||null,r.authTokenFactory||null);case"provider":return r.client;default:throw new K(U.INVALID_ARGUMENT,"makeAuthCredentialsProvider failed due to invalid credential type")}}(e.credentials))}_getSettings(){return this._settings}_freezeSettings(){return this._settingsFrozen=!0,this._settings}_delete(){return this._terminateTask==="notTerminated"&&(this._terminateTask=this._terminate()),this._terminateTask}async _restart(){this._terminateTask==="notTerminated"?await this._terminate():this._terminateTask="notTerminated"}toJSON(){return{app:this._app,databaseId:this._databaseId,settings:this._settings}}_terminate(){return function(n){const r=rw.get(n);r&&(Y("ComponentProvider","Removing Datastore"),rw.delete(n),r.terminate())}(this),Promise.resolve()}}function D2(t,e,n,r={}){var i;const s=(t=sl(t,Th))._getSettings(),o=`${e}:${n}`;if(s.host!=="firestore.googleapis.com"&&s.host!==o&&eo("Host has been set in both settings() and connectFirestoreEmulator(), emulator host will be used."),t._setSettings(Object.assign(Object.assign({},s),{host:o,ssl:!1})),r.mockUserToken){let a,u;if(typeof r.mockUserToken=="string")a=r.mockUserToken,u=Nt.MOCK_USER;else{a=Nm(r.mockUserToken,(i=t._app)===null||i===void 0?void 0:i.options.projectId);const c=r.mockUserToken.sub||r.mockUserToken.user_id;if(!c)throw new K(U.INVALID_ARGUMENT,"mockUserToken must contain 'sub' or 'user_id' field!");u=new Nt(c)}t._authCredentials=new GP(new rI(a,u))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class rs{constructor(e,n,r){this.converter=n,this._query=r,this.type="query",this.firestore=e}withConverter(e){return new rs(this.firestore,e,this._query)}}class En{constructor(e,n,r){this.converter=n,this._key=r,this.type="document",this.firestore=e}get _path(){return this._key.path}get id(){return this._key.path.lastSegment()}get path(){return this._key.path.canonicalString()}get parent(){return new ii(this.firestore,this.converter,this._key.path.popLast())}withConverter(e){return new En(this.firestore,e,this._key)}}class ii extends rs{constructor(e,n,r){super(e,n,pI(r)),this._path=r,this.type="collection"}get id(){return this._query.path.lastSegment()}get path(){return this._query.path.canonicalString()}get parent(){const e=this._path.popLast();return e.isEmpty()?null:new En(this.firestore,null,new Z(e))}withConverter(e){return new ii(this.firestore,e,this._path)}}function aw(t,e,...n){if(t=Qe(t),iS("collection","path",e),t instanceof Th){const r=Fe.fromString(e,...n);return sw(r),new ii(t,null,r)}{if(!(t instanceof En||t instanceof ii))throw new K(U.INVALID_ARGUMENT,"Expected first argument to collection() to be a CollectionReference, a DocumentReference or FirebaseFirestore");const r=t._path.child(Fe.fromString(e,...n));return sw(r),new ii(t.firestore,null,r)}}function sS(t,e,...n){if(t=Qe(t),arguments.length===1&&(e=iI.newId()),iS("doc","path",e),t instanceof Th){const r=Fe.fromString(e,...n);return iw(r),new En(t,null,new Z(r))}{if(!(t instanceof En||t instanceof ii))throw new K(U.INVALID_ARGUMENT,"Expected first argument to collection() to be a CollectionReference, a DocumentReference or FirebaseFirestore");const r=t._path.child(Fe.fromString(e,...n));return iw(r),new En(t.firestore,t instanceof ii?t.converter:null,new Z(r))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class lw{constructor(e=Promise.resolve()){this.Pu=[],this.Iu=!1,this.Tu=[],this.Eu=null,this.du=!1,this.Au=!1,this.Ru=[],this.t_=new jI(this,"async_queue_retry"),this.Vu=()=>{const r=Od();r&&Y("AsyncQueue","Visibility state changed to "+r.visibilityState),this.t_.jo()},this.mu=e;const n=Od();n&&typeof n.addEventListener=="function"&&n.addEventListener("visibilitychange",this.Vu)}get isShuttingDown(){return this.Iu}enqueueAndForget(e){this.enqueue(e)}enqueueAndForgetEvenWhileRestricted(e){this.fu(),this.gu(e)}enterRestrictedMode(e){if(!this.Iu){this.Iu=!0,this.Au=e||!1;const n=Od();n&&typeof n.removeEventListener=="function"&&n.removeEventListener("visibilitychange",this.Vu)}}enqueue(e){if(this.fu(),this.Iu)return new Promise(()=>{});const n=new ni;return this.gu(()=>this.Iu&&this.Au?Promise.resolve():(e().then(n.resolve,n.reject),n.promise)).then(()=>n.promise)}enqueueRetryable(e){this.enqueueAndForget(()=>(this.Pu.push(e),this.pu()))}async pu(){if(this.Pu.length!==0){try{await this.Pu[0](),this.Pu.shift(),this.t_.reset()}catch(e){if(!_l(e))throw e;Y("AsyncQueue","Operation failed with retryable error: "+e)}this.Pu.length>0&&this.t_.Go(()=>this.pu())}}gu(e){const n=this.mu.then(()=>(this.du=!0,e().catch(r=>{this.Eu=r,this.du=!1;const i=function(o){let a=o.message||"";return o.stack&&(a=o.stack.includes(o.message)?o.stack:o.message+`
`+o.stack),a}(r);throw Er("INTERNAL UNHANDLED ERROR: ",i),r}).then(r=>(this.du=!1,r))));return this.mu=n,n}enqueueAfterDelay(e,n,r){this.fu(),this.Ru.indexOf(e)>-1&&(n=0);const i=tg.createAndSchedule(this,e,n,r,s=>this.yu(s));return this.Tu.push(i),i}fu(){this.Eu&&re()}verifyOperationInProgress(){}async wu(){let e;do e=this.mu,await e;while(e!==this.mu)}Su(e){for(const n of this.Tu)if(n.timerId===e)return!0;return!1}bu(e){return this.wu().then(()=>{this.Tu.sort((n,r)=>n.targetTimeMs-r.targetTimeMs);for(const n of this.Tu)if(n.skipDelay(),e!=="all"&&n.timerId===e)break;return this.wu()})}Du(e){this.Ru.push(e)}yu(e){const n=this.Tu.indexOf(e);this.Tu.splice(n,1)}}class Ih extends Th{constructor(e,n,r,i){super(e,n,r,i),this.type="firestore",this._queue=new lw,this._persistenceKey=(i==null?void 0:i.name)||"[DEFAULT]"}async _terminate(){if(this._firestoreClient){const e=this._firestoreClient.terminate();this._queue=new lw(e),this._firestoreClient=void 0,await e}}}function M2(t,e){const n=typeof t=="object"?t:hh(),r=typeof t=="string"?t:"(default)",i=ml(n,"firestore").getImmediate({identifier:r});if(!i._initialized){const s=bm("firestore");s&&D2(i,...s)}return i}function oS(t){if(t._terminated)throw new K(U.FAILED_PRECONDITION,"The client has already been terminated.");return t._firestoreClient||L2(t),t._firestoreClient}function L2(t){var e,n,r;const i=t._freezeSettings(),s=function(a,u,c,d){return new ub(a,u,c,d.host,d.ssl,d.experimentalForceLongPolling,d.experimentalAutoDetectLongPolling,rS(d.experimentalLongPollingOptions),d.useFetchStreams)}(t._databaseId,((e=t._app)===null||e===void 0?void 0:e.options.appId)||"",t._persistenceKey,i);t._componentsProvider||!((n=i.localCache)===null||n===void 0)&&n._offlineComponentProvider&&(!((r=i.localCache)===null||r===void 0)&&r._onlineComponentProvider)&&(t._componentsProvider={_offline:i.localCache._offlineComponentProvider,_online:i.localCache._onlineComponentProvider}),t._firestoreClient=new A2(t._authCredentials,t._appCheckCredentials,t._queue,s,t._componentsProvider&&function(a){const u=a==null?void 0:a._online.build();return{_offline:a==null?void 0:a._offline.build(u),_online:u}}(t._componentsProvider))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class oo{constructor(e){this._byteString=e}static fromBase64String(e){try{return new oo(Ct.fromBase64String(e))}catch(n){throw new K(U.INVALID_ARGUMENT,"Failed to construct data from Base64 string: "+n)}}static fromUint8Array(e){return new oo(Ct.fromUint8Array(e))}toBase64(){return this._byteString.toBase64()}toUint8Array(){return this._byteString.toUint8Array()}toString(){return"Bytes(base64: "+this.toBase64()+")"}isEqual(e){return this._byteString.isEqual(e._byteString)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class sg{constructor(...e){for(let n=0;n<e.length;++n)if(e[n].length===0)throw new K(U.INVALID_ARGUMENT,"Invalid field name at argument $(i + 1). Field names must not be empty.");this._internalPath=new Tt(e)}isEqual(e){return this._internalPath.isEqual(e._internalPath)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class og{constructor(e){this._methodName=e}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ag{constructor(e,n){if(!isFinite(e)||e<-90||e>90)throw new K(U.INVALID_ARGUMENT,"Latitude must be a number between -90 and 90, but was: "+e);if(!isFinite(n)||n<-180||n>180)throw new K(U.INVALID_ARGUMENT,"Longitude must be a number between -180 and 180, but was: "+n);this._lat=e,this._long=n}get latitude(){return this._lat}get longitude(){return this._long}isEqual(e){return this._lat===e._lat&&this._long===e._long}toJSON(){return{latitude:this._lat,longitude:this._long}}_compareTo(e){return ye(this._lat,e._lat)||ye(this._long,e._long)}}/**
 * @license
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class lg{constructor(e){this._values=(e||[]).map(n=>n)}toArray(){return this._values.map(e=>e)}isEqual(e){return function(r,i){if(r.length!==i.length)return!1;for(let s=0;s<r.length;++s)if(r[s]!==i[s])return!1;return!0}(this._values,e._values)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const V2=/^__.*__$/;class F2{constructor(e,n,r){this.data=e,this.fieldMask=n,this.fieldTransforms=r}toMutation(e,n){return this.fieldMask!==null?new ts(e,this.data,this.fieldMask,n,this.fieldTransforms):new yl(e,this.data,n,this.fieldTransforms)}}function aS(t){switch(t){case 0:case 2:case 1:return!0;case 3:case 4:return!1;default:throw re()}}class ug{constructor(e,n,r,i,s,o){this.settings=e,this.databaseId=n,this.serializer=r,this.ignoreUndefinedProperties=i,s===void 0&&this.vu(),this.fieldTransforms=s||[],this.fieldMask=o||[]}get path(){return this.settings.path}get Cu(){return this.settings.Cu}Fu(e){return new ug(Object.assign(Object.assign({},this.settings),e),this.databaseId,this.serializer,this.ignoreUndefinedProperties,this.fieldTransforms,this.fieldMask)}Mu(e){var n;const r=(n=this.path)===null||n===void 0?void 0:n.child(e),i=this.Fu({path:r,xu:!1});return i.Ou(e),i}Nu(e){var n;const r=(n=this.path)===null||n===void 0?void 0:n.child(e),i=this.Fu({path:r,xu:!1});return i.vu(),i}Lu(e){return this.Fu({path:void 0,xu:!0})}Bu(e){return Rc(e,this.settings.methodName,this.settings.ku||!1,this.path,this.settings.qu)}contains(e){return this.fieldMask.find(n=>e.isPrefixOf(n))!==void 0||this.fieldTransforms.find(n=>e.isPrefixOf(n.field))!==void 0}vu(){if(this.path)for(let e=0;e<this.path.length;e++)this.Ou(this.path.get(e))}Ou(e){if(e.length===0)throw this.Bu("Document fields must not be empty");if(aS(this.Cu)&&V2.test(e))throw this.Bu('Document fields cannot begin and end with "__"')}}class U2{constructor(e,n,r){this.databaseId=e,this.ignoreUndefinedProperties=n,this.serializer=r||yh(e)}Qu(e,n,r,i=!1){return new ug({Cu:e,methodName:n,qu:r,path:Tt.emptyPath(),xu:!1,ku:i},this.databaseId,this.serializer,this.ignoreUndefinedProperties)}}function lS(t){const e=t._freezeSettings(),n=yh(t._databaseId);return new U2(t._databaseId,!!e.ignoreUndefinedProperties,n)}function j2(t,e,n,r,i,s={}){const o=t.Qu(s.merge||s.mergeFields?2:0,e,n,i);hS("Data must be an object, but it was:",o,r);const a=uS(r,o);let u,c;if(s.merge)u=new Nn(o.fieldMask),c=o.fieldTransforms;else if(s.mergeFields){const d=[];for(const f of s.mergeFields){const m=B2(e,f,n);if(!o.contains(m))throw new K(U.INVALID_ARGUMENT,`Field '${m}' is specified in your field mask but missing from your input data.`);W2(d,m)||d.push(m)}u=new Nn(d),c=o.fieldTransforms.filter(f=>u.covers(f.field))}else u=null,c=o.fieldTransforms;return new F2(new pn(a),u,c)}class cg extends og{_toFieldTransform(e){return new Db(e.path,new nl)}isEqual(e){return e instanceof cg}}function z2(t,e,n,r=!1){return hg(n,t.Qu(r?4:3,e))}function hg(t,e){if(cS(t=Qe(t)))return hS("Unsupported field value:",e,t),uS(t,e);if(t instanceof og)return function(r,i){if(!aS(i.Cu))throw i.Bu(`${r._methodName}() can only be used with update() and set()`);if(!i.path)throw i.Bu(`${r._methodName}() is not currently supported inside arrays`);const s=r._toFieldTransform(i);s&&i.fieldTransforms.push(s)}(t,e),null;if(t===void 0&&e.ignoreUndefinedProperties)return null;if(e.path&&e.fieldMask.push(e.path),t instanceof Array){if(e.settings.xu&&e.Cu!==4)throw e.Bu("Nested arrays are not supported");return function(r,i){const s=[];let o=0;for(const a of r){let u=hg(a,i.Lu(o));u==null&&(u={nullValue:"NULL_VALUE"}),s.push(u),o++}return{arrayValue:{values:s}}}(t,e)}return function(r,i){if((r=Qe(r))===null)return{nullValue:"NULL_VALUE"};if(typeof r=="number")return bb(i.serializer,r);if(typeof r=="boolean")return{booleanValue:r};if(typeof r=="string")return{stringValue:r};if(r instanceof Date){const s=ut.fromDate(r);return{timestampValue:Sc(i.serializer,s)}}if(r instanceof ut){const s=new ut(r.seconds,1e3*Math.floor(r.nanoseconds/1e3));return{timestampValue:Sc(i.serializer,s)}}if(r instanceof ag)return{geoPointValue:{latitude:r.latitude,longitude:r.longitude}};if(r instanceof oo)return{bytesValue:bI(i.serializer,r._byteString)};if(r instanceof En){const s=i.databaseId,o=r.firestore._databaseId;if(!o.isEqual(s))throw i.Bu(`Document reference is for database ${o.projectId}/${o.database} but should be for database ${s.projectId}/${s.database}`);return{referenceValue:Gm(r.firestore._databaseId||i.databaseId,r._key.path)}}if(r instanceof lg)return function(o,a){return{mapValue:{fields:{__type__:{stringValue:"__vector__"},value:{arrayValue:{values:o.toArray().map(u=>{if(typeof u!="number")throw a.Bu("VectorValues must only contain numeric values.");return $m(a.serializer,u)})}}}}}}(r,i);throw i.Bu(`Unsupported field value: ${Eh(r)}`)}(t,e)}function uS(t,e){const n={};return sI(t)?e.path&&e.path.length>0&&e.fieldMask.push(e.path):go(t,(r,i)=>{const s=hg(i,e.Mu(r));s!=null&&(n[r]=s)}),{mapValue:{fields:n}}}function cS(t){return!(typeof t!="object"||t===null||t instanceof Array||t instanceof Date||t instanceof ut||t instanceof ag||t instanceof oo||t instanceof En||t instanceof og||t instanceof lg)}function hS(t,e,n){if(!cS(n)||!function(i){return typeof i=="object"&&i!==null&&(Object.getPrototypeOf(i)===Object.prototype||Object.getPrototypeOf(i)===null)}(n)){const r=Eh(n);throw r==="an object"?e.Bu(t+" a custom object"):e.Bu(t+" "+r)}}function B2(t,e,n){if((e=Qe(e))instanceof sg)return e._internalPath;if(typeof e=="string")return dS(t,e);throw Rc("Field path arguments must be of type string or ",t,!1,void 0,n)}const $2=new RegExp("[~\\*/\\[\\]]");function dS(t,e,n){if(e.search($2)>=0)throw Rc(`Invalid field path (${e}). Paths must not contain '~', '*', '/', '[', or ']'`,t,!1,void 0,n);try{return new sg(...e.split("."))._internalPath}catch{throw Rc(`Invalid field path (${e}). Paths must not be empty, begin with '.', end with '.', or contain '..'`,t,!1,void 0,n)}}function Rc(t,e,n,r,i){const s=r&&!r.isEmpty(),o=i!==void 0;let a=`Function ${e}() called with invalid data`;n&&(a+=" (via `toFirestore()`)"),a+=". ";let u="";return(s||o)&&(u+=" (found",s&&(u+=` in field ${r}`),o&&(u+=` in document ${i}`),u+=")"),new K(U.INVALID_ARGUMENT,a+t+u)}function W2(t,e){return t.some(n=>n.isEqual(e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class fS{constructor(e,n,r,i,s){this._firestore=e,this._userDataWriter=n,this._key=r,this._document=i,this._converter=s}get id(){return this._key.path.lastSegment()}get ref(){return new En(this._firestore,this._converter,this._key)}exists(){return this._document!==null}data(){if(this._document){if(this._converter){const e=new q2(this._firestore,this._userDataWriter,this._key,this._document,null);return this._converter.fromFirestore(e)}return this._userDataWriter.convertValue(this._document.data.value)}}get(e){if(this._document){const n=this._document.data.field(dg("DocumentSnapshot.get",e));if(n!==null)return this._userDataWriter.convertValue(n)}}}class q2 extends fS{data(){return super.data()}}function dg(t,e){return typeof e=="string"?dS(t,e):e instanceof sg?e._internalPath:e._delegate._internalPath}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function H2(t){if(t.limitType==="L"&&t.explicitOrderBy.length===0)throw new K(U.UNIMPLEMENTED,"limitToLast() queries require specifying at least one orderBy() clause")}class fg{}class pS extends fg{}function G2(t,e,...n){let r=[];e instanceof fg&&r.push(e),r=r.concat(n),function(s){const o=s.filter(u=>u instanceof mg).length,a=s.filter(u=>u instanceof pg).length;if(o>1||o>0&&a>0)throw new K(U.INVALID_ARGUMENT,"InvalidQuery. When using composite filters, you cannot use more than one filter at the top level. Consider nesting the multiple filters within an `and(...)` statement. For example: change `query(query, where(...), or(...))` to `query(query, and(where(...), or(...)))`.")}(r);for(const i of r)t=i._apply(t);return t}class pg extends pS{constructor(e,n,r){super(),this._field=e,this._op=n,this._value=r,this.type="where"}static _create(e,n,r){return new pg(e,n,r)}_apply(e){const n=this._parse(e);return mS(e._query,n),new rs(e.firestore,e.converter,op(e._query,n))}_parse(e){const n=lS(e.firestore);return function(s,o,a,u,c,d,f){let m;if(c.isKeyField()){if(d==="array-contains"||d==="array-contains-any")throw new K(U.INVALID_ARGUMENT,`Invalid Query. You can't perform '${d}' queries on documentId().`);if(d==="in"||d==="not-in"){cw(f,d);const w=[];for(const I of f)w.push(uw(u,s,I));m={arrayValue:{values:w}}}else m=uw(u,s,f)}else d!=="in"&&d!=="not-in"&&d!=="array-contains-any"||cw(f,d),m=z2(a,o,f,d==="in"||d==="not-in");return rt.create(c,d,m)}(e._query,"where",n,e.firestore._databaseId,this._field,this._op,this._value)}}class mg extends fg{constructor(e,n){super(),this.type=e,this._queryConstraints=n}static _create(e,n){return new mg(e,n)}_parse(e){const n=this._queryConstraints.map(r=>r._parse(e)).filter(r=>r.getFilters().length>0);return n.length===1?n[0]:Fn.create(n,this._getOperator())}_apply(e){const n=this._parse(e);return n.getFilters().length===0?e:(function(i,s){let o=i;const a=s.getFlattenedFilters();for(const u of a)mS(o,u),o=op(o,u)}(e._query,n),new rs(e.firestore,e.converter,op(e._query,n)))}_getQueryConstraints(){return this._queryConstraints}_getOperator(){return this.type==="and"?"and":"or"}}class gg extends pS{constructor(e,n){super(),this._field=e,this._direction=n,this.type="orderBy"}static _create(e,n){return new gg(e,n)}_apply(e){const n=function(i,s,o){if(i.startAt!==null)throw new K(U.INVALID_ARGUMENT,"Invalid query. You must not call startAt() or startAfter() before calling orderBy().");if(i.endAt!==null)throw new K(U.INVALID_ARGUMENT,"Invalid query. You must not call endAt() or endBefore() before calling orderBy().");return new tl(s,o)}(e._query,this._field,this._direction);return new rs(e.firestore,e.converter,function(i,s){const o=i.explicitOrderBy.concat([s]);return new _o(i.path,i.collectionGroup,o,i.filters.slice(),i.limit,i.limitType,i.startAt,i.endAt)}(e._query,n))}}function K2(t,e="asc"){const n=e,r=dg("orderBy",t);return gg._create(r,n)}function uw(t,e,n){if(typeof(n=Qe(n))=="string"){if(n==="")throw new K(U.INVALID_ARGUMENT,"Invalid query. When querying with documentId(), you must provide a valid document ID, but it was an empty string.");if(!mI(e)&&n.indexOf("/")!==-1)throw new K(U.INVALID_ARGUMENT,`Invalid query. When querying a collection by documentId(), you must provide a plain document ID, but '${n}' contains a '/' character.`);const r=e.path.child(Fe.fromString(n));if(!Z.isDocumentKey(r))throw new K(U.INVALID_ARGUMENT,`Invalid query. When querying a collection group by documentId(), the value provided must result in a valid document path, but '${r}' is not because it has an odd number of segments (${r.length}).`);return Pv(t,new Z(r))}if(n instanceof En)return Pv(t,n._key);throw new K(U.INVALID_ARGUMENT,`Invalid query. When querying with documentId(), you must provide a valid string or a DocumentReference, but it was: ${Eh(n)}.`)}function cw(t,e){if(!Array.isArray(t)||t.length===0)throw new K(U.INVALID_ARGUMENT,`Invalid Query. A non-empty array is required for '${e.toString()}' filters.`)}function mS(t,e){const n=function(i,s){for(const o of i)for(const a of o.getFlattenedFilters())if(s.indexOf(a.op)>=0)return a.op;return null}(t.filters,function(i){switch(i){case"!=":return["!=","not-in"];case"array-contains-any":case"in":return["not-in"];case"not-in":return["array-contains-any","in","not-in","!="];default:return[]}}(e.op));if(n!==null)throw n===e.op?new K(U.INVALID_ARGUMENT,`Invalid query. You cannot use more than one '${e.op.toString()}' filter.`):new K(U.INVALID_ARGUMENT,`Invalid query. You cannot use '${e.op.toString()}' filters with '${n.toString()}' filters.`)}class Q2{convertValue(e,n="none"){switch(Hi(e)){case 0:return null;case 1:return e.booleanValue;case 2:return Je(e.integerValue||e.doubleValue);case 3:return this.convertTimestamp(e.timestampValue);case 4:return this.convertServerTimestamp(e,n);case 5:return e.stringValue;case 6:return this.convertBytes(qi(e.bytesValue));case 7:return this.convertReference(e.referenceValue);case 8:return this.convertGeoPoint(e.geoPointValue);case 9:return this.convertArray(e.arrayValue,n);case 11:return this.convertObject(e.mapValue,n);case 10:return this.convertVectorValue(e.mapValue);default:throw re()}}convertObject(e,n){return this.convertObjectMap(e.fields,n)}convertObjectMap(e,n="none"){const r={};return go(e,(i,s)=>{r[i]=this.convertValue(s,n)}),r}convertVectorValue(e){var n,r,i;const s=(i=(r=(n=e.fields)===null||n===void 0?void 0:n.value.arrayValue)===null||r===void 0?void 0:r.values)===null||i===void 0?void 0:i.map(o=>Je(o.doubleValue));return new lg(s)}convertGeoPoint(e){return new ag(Je(e.latitude),Je(e.longitude))}convertArray(e,n){return(e.values||[]).map(r=>this.convertValue(r,n))}convertServerTimestamp(e,n){switch(n){case"previous":const r=Um(e);return r==null?null:this.convertValue(r,n);case"estimate":return this.convertTimestamp(Ja(e));default:return null}}convertTimestamp(e){const n=hi(e);return new ut(n.seconds,n.nanos)}convertDocumentKey(e,n){const r=Fe.fromString(e);Se(VI(r));const i=new Za(r.get(1),r.get(3)),s=new Z(r.popFirst(5));return i.isEqual(n)||Er(`Document ${s} contains a document reference within a different database (${i.projectId}/${i.database}) which is not supported. It will be treated as a reference in the current database (${n.projectId}/${n.database}) instead.`),s}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Y2(t,e,n){let r;return r=t?t.toFirestore(e):e,r}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class _u{constructor(e,n){this.hasPendingWrites=e,this.fromCache=n}isEqual(e){return this.hasPendingWrites===e.hasPendingWrites&&this.fromCache===e.fromCache}}class X2 extends fS{constructor(e,n,r,i,s,o){super(e,n,r,i,o),this._firestore=e,this._firestoreImpl=e,this.metadata=s}exists(){return super.exists()}data(e={}){if(this._document){if(this._converter){const n=new ju(this._firestore,this._userDataWriter,this._key,this._document,this.metadata,null);return this._converter.fromFirestore(n,e)}return this._userDataWriter.convertValue(this._document.data.value,e.serverTimestamps)}}get(e,n={}){if(this._document){const r=this._document.data.field(dg("DocumentSnapshot.get",e));if(r!==null)return this._userDataWriter.convertValue(r,n.serverTimestamps)}}}class ju extends X2{data(e={}){return super.data(e)}}class J2{constructor(e,n,r,i){this._firestore=e,this._userDataWriter=n,this._snapshot=i,this.metadata=new _u(i.hasPendingWrites,i.fromCache),this.query=r}get docs(){const e=[];return this.forEach(n=>e.push(n)),e}get size(){return this._snapshot.docs.size}get empty(){return this.size===0}forEach(e,n){this._snapshot.docs.forEach(r=>{e.call(n,new ju(this._firestore,this._userDataWriter,r.key,r,new _u(this._snapshot.mutatedKeys.has(r.key),this._snapshot.fromCache),this.query.converter))})}docChanges(e={}){const n=!!e.includeMetadataChanges;if(n&&this._snapshot.excludesMetadataChanges)throw new K(U.INVALID_ARGUMENT,"To include metadata changes with your document changes, you must also pass { includeMetadataChanges:true } to onSnapshot().");return this._cachedChanges&&this._cachedChangesIncludeMetadataChanges===n||(this._cachedChanges=function(i,s){if(i._snapshot.oldDocs.isEmpty()){let o=0;return i._snapshot.docChanges.map(a=>{const u=new ju(i._firestore,i._userDataWriter,a.doc.key,a.doc,new _u(i._snapshot.mutatedKeys.has(a.doc.key),i._snapshot.fromCache),i.query.converter);return a.doc,{type:"added",doc:u,oldIndex:-1,newIndex:o++}})}{let o=i._snapshot.oldDocs;return i._snapshot.docChanges.filter(a=>s||a.type!==3).map(a=>{const u=new ju(i._firestore,i._userDataWriter,a.doc.key,a.doc,new _u(i._snapshot.mutatedKeys.has(a.doc.key),i._snapshot.fromCache),i.query.converter);let c=-1,d=-1;return a.type!==0&&(c=o.indexOf(a.doc.key),o=o.delete(a.doc.key)),a.type!==1&&(o=o.add(a.doc),d=o.indexOf(a.doc.key)),{type:Z2(a.type),doc:u,oldIndex:c,newIndex:d}})}}(this,n),this._cachedChangesIncludeMetadataChanges=n),this._cachedChanges}}function Z2(t){switch(t){case 0:return"added";case 2:case 3:return"modified";case 1:return"removed";default:return re()}}class eO extends Q2{constructor(e){super(),this.firestore=e}convertBytes(e){return new oo(e)}convertReference(e){const n=this.convertDocumentKey(e,this.firestore._databaseId);return new En(this.firestore,null,n)}}function tO(t){t=sl(t,rs);const e=sl(t.firestore,Ih),n=oS(e),r=new eO(e);return H2(t._query),N2(n,t._query).then(i=>new J2(e,r,t,i))}function nO(t){return gS(sl(t.firestore,Ih),[new Wm(t._key,Kn.none())])}function rO(t,e){const n=sl(t.firestore,Ih),r=sS(t),i=Y2(t.converter,e);return gS(n,[j2(lS(t.firestore),"addDoc",r._key,i,t.converter!==null,{}).toMutation(r._key,Kn.exists(!1))]).then(()=>r)}function gS(t,e){return function(r,i){const s=new ni;return r.asyncQueue.enqueueAndForget(async()=>v2(await P2(r),i,s)),s.promise}(oS(t),e)}function iO(){return new cg("serverTimestamp")}(function(e,n=!0){(function(i){mo=i})(yi),ui(new vr("firestore",(r,{instanceIdentifier:i,options:s})=>{const o=r.getProvider("app").getImmediate(),a=new Ih(new KP(r.getProvider("auth-internal")),new JP(r.getProvider("app-check-internal")),function(c,d){if(!Object.prototype.hasOwnProperty.apply(c.options,["projectId"]))throw new K(U.INVALID_ARGUMENT,'"projectId" not provided in firebase.initializeApp.');return new Za(c.options.projectId,d)}(o,i),o);return s=Object.assign({useFetchStreams:n},s),a._setSettings(s),a},"PUBLIC").setMultipleInstances(!0)),wn(kv,"4.7.3",e),wn(kv,"4.7.3","esm2017")})();/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const _S="firebasestorage.googleapis.com",yS="storageBucket",sO=2*60*1e3,oO=10*60*1e3,aO=1e3;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class He extends Zn{constructor(e,n,r=0){super(Md(e),`Firebase Storage: ${n} (${Md(e)})`),this.status_=r,this.customData={serverResponse:null},this._baseMessage=this.message,Object.setPrototypeOf(this,He.prototype)}get status(){return this.status_}set status(e){this.status_=e}_codeEquals(e){return Md(e)===this.code}get serverResponse(){return this.customData.serverResponse}set serverResponse(e){this.customData.serverResponse=e,this.customData.serverResponse?this.message=`${this._baseMessage}
${this.customData.serverResponse}`:this.message=this._baseMessage}}var je;(function(t){t.UNKNOWN="unknown",t.OBJECT_NOT_FOUND="object-not-found",t.BUCKET_NOT_FOUND="bucket-not-found",t.PROJECT_NOT_FOUND="project-not-found",t.QUOTA_EXCEEDED="quota-exceeded",t.UNAUTHENTICATED="unauthenticated",t.UNAUTHORIZED="unauthorized",t.UNAUTHORIZED_APP="unauthorized-app",t.RETRY_LIMIT_EXCEEDED="retry-limit-exceeded",t.INVALID_CHECKSUM="invalid-checksum",t.CANCELED="canceled",t.INVALID_EVENT_NAME="invalid-event-name",t.INVALID_URL="invalid-url",t.INVALID_DEFAULT_BUCKET="invalid-default-bucket",t.NO_DEFAULT_BUCKET="no-default-bucket",t.CANNOT_SLICE_BLOB="cannot-slice-blob",t.SERVER_FILE_WRONG_SIZE="server-file-wrong-size",t.NO_DOWNLOAD_URL="no-download-url",t.INVALID_ARGUMENT="invalid-argument",t.INVALID_ARGUMENT_COUNT="invalid-argument-count",t.APP_DELETED="app-deleted",t.INVALID_ROOT_OPERATION="invalid-root-operation",t.INVALID_FORMAT="invalid-format",t.INTERNAL_ERROR="internal-error",t.UNSUPPORTED_ENVIRONMENT="unsupported-environment"})(je||(je={}));function Md(t){return"storage/"+t}function _g(){const t="An unknown error occurred, please check the error payload for server response.";return new He(je.UNKNOWN,t)}function lO(t){return new He(je.OBJECT_NOT_FOUND,"Object '"+t+"' does not exist.")}function uO(t){return new He(je.QUOTA_EXCEEDED,"Quota for bucket '"+t+"' exceeded, please view quota on https://firebase.google.com/pricing/.")}function cO(){const t="User is not authenticated, please authenticate using Firebase Authentication and try again.";return new He(je.UNAUTHENTICATED,t)}function hO(){return new He(je.UNAUTHORIZED_APP,"This app does not have permission to access Firebase Storage on this project.")}function dO(t){return new He(je.UNAUTHORIZED,"User does not have permission to access '"+t+"'.")}function vS(){return new He(je.RETRY_LIMIT_EXCEEDED,"Max retry time for operation exceeded, please try again.")}function wS(){return new He(je.CANCELED,"User canceled the upload/download.")}function fO(t){return new He(je.INVALID_URL,"Invalid URL '"+t+"'.")}function pO(t){return new He(je.INVALID_DEFAULT_BUCKET,"Invalid default bucket '"+t+"'.")}function mO(){return new He(je.NO_DEFAULT_BUCKET,"No default bucket found. Did you set the '"+yS+"' property when initializing the app?")}function ES(){return new He(je.CANNOT_SLICE_BLOB,"Cannot slice blob for upload. Please retry the upload.")}function gO(){return new He(je.SERVER_FILE_WRONG_SIZE,"Server recorded incorrect upload file size, please retry the upload.")}function _O(){return new He(je.NO_DOWNLOAD_URL,"The given file does not have any download URLs.")}function yO(t){return new He(je.UNSUPPORTED_ENVIRONMENT,`${t} is missing. Make sure to install the required polyfills. See https://firebase.google.com/docs/web/environments-js-sdk#polyfills for more information.`)}function gp(t){return new He(je.INVALID_ARGUMENT,t)}function TS(){return new He(je.APP_DELETED,"The Firebase app was deleted.")}function vO(t){return new He(je.INVALID_ROOT_OPERATION,"The operation '"+t+"' cannot be performed on a root reference, create a non-root reference using child, such as .child('file.png').")}function Ia(t,e){return new He(je.INVALID_FORMAT,"String does not match format '"+t+"': "+e)}function Yo(t){throw new He(je.INTERNAL_ERROR,"Internal error: "+t)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class an{constructor(e,n){this.bucket=e,this.path_=n}get path(){return this.path_}get isRoot(){return this.path.length===0}fullServerUrl(){const e=encodeURIComponent;return"/b/"+e(this.bucket)+"/o/"+e(this.path)}bucketOnlyServerUrl(){return"/b/"+encodeURIComponent(this.bucket)+"/o"}static makeFromBucketSpec(e,n){let r;try{r=an.makeFromUrl(e,n)}catch{return new an(e,"")}if(r.path==="")return r;throw pO(e)}static makeFromUrl(e,n){let r=null;const i="([A-Za-z0-9.\\-_]+)";function s(M){M.path.charAt(M.path.length-1)==="/"&&(M.path_=M.path_.slice(0,-1))}const o="(/(.*))?$",a=new RegExp("^gs://"+i+o,"i"),u={bucket:1,path:3};function c(M){M.path_=decodeURIComponent(M.path)}const d="v[A-Za-z0-9_]+",f=n.replace(/[.]/g,"\\."),m="(/([^?#]*).*)?$",w=new RegExp(`^https?://${f}/${d}/b/${i}/o${m}`,"i"),I={bucket:1,path:3},P=n===_S?"(?:storage.googleapis.com|storage.cloud.google.com)":n,O="([^?#]*)",C=new RegExp(`^https?://${P}/${i}/${O}`,"i"),S=[{regex:a,indices:u,postModify:s},{regex:w,indices:I,postModify:c},{regex:C,indices:{bucket:1,path:2},postModify:c}];for(let M=0;M<S.length;M++){const V=S[M],F=V.regex.exec(e);if(F){const y=F[V.indices.bucket];let g=F[V.indices.path];g||(g=""),r=new an(y,g),V.postModify(r);break}}if(r==null)throw fO(e);return r}}class wO{constructor(e){this.promise_=Promise.reject(e)}getPromise(){return this.promise_}cancel(e=!1){}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function EO(t,e,n){let r=1,i=null,s=null,o=!1,a=0;function u(){return a===2}let c=!1;function d(...O){c||(c=!0,e.apply(null,O))}function f(O){i=setTimeout(()=>{i=null,t(w,u())},O)}function m(){s&&clearTimeout(s)}function w(O,...C){if(c){m();return}if(O){m(),d.call(null,O,...C);return}if(u()||o){m(),d.call(null,O,...C);return}r<64&&(r*=2);let S;a===1?(a=2,S=0):S=(r+Math.random())*1e3,f(S)}let I=!1;function P(O){I||(I=!0,m(),!c&&(i!==null?(O||(a=2),clearTimeout(i),f(0)):O||(a=1)))}return f(0),s=setTimeout(()=>{o=!0,P(!0)},n),P}function TO(t){t(!1)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function IO(t){return t!==void 0}function SO(t){return typeof t=="function"}function kO(t){return typeof t=="object"&&!Array.isArray(t)}function Sh(t){return typeof t=="string"||t instanceof String}function hw(t){return yg()&&t instanceof Blob}function yg(){return typeof Blob<"u"}function dw(t,e,n,r){if(r<e)throw gp(`Invalid value for '${t}'. Expected ${e} or greater.`);if(r>n)throw gp(`Invalid value for '${t}'. Expected ${n} or less.`)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function wo(t,e,n){let r=e;return n==null&&(r=`https://${e}`),`${n}://${r}/v0${t}`}function IS(t){const e=encodeURIComponent;let n="?";for(const r in t)if(t.hasOwnProperty(r)){const i=e(r)+"="+e(t[r]);n=n+i+"&"}return n=n.slice(0,-1),n}var Fi;(function(t){t[t.NO_ERROR=0]="NO_ERROR",t[t.NETWORK_ERROR=1]="NETWORK_ERROR",t[t.ABORT=2]="ABORT"})(Fi||(Fi={}));/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function SS(t,e){const n=t>=500&&t<600,i=[408,429].indexOf(t)!==-1,s=e.indexOf(t)!==-1;return n||i||s}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class CO{constructor(e,n,r,i,s,o,a,u,c,d,f,m=!0){this.url_=e,this.method_=n,this.headers_=r,this.body_=i,this.successCodes_=s,this.additionalRetryCodes_=o,this.callback_=a,this.errorCallback_=u,this.timeout_=c,this.progressCallback_=d,this.connectionFactory_=f,this.retry=m,this.pendingConnection_=null,this.backoffId_=null,this.canceled_=!1,this.appDelete_=!1,this.promise_=new Promise((w,I)=>{this.resolve_=w,this.reject_=I,this.start_()})}start_(){const e=(r,i)=>{if(i){r(!1,new yu(!1,null,!0));return}const s=this.connectionFactory_();this.pendingConnection_=s;const o=a=>{const u=a.loaded,c=a.lengthComputable?a.total:-1;this.progressCallback_!==null&&this.progressCallback_(u,c)};this.progressCallback_!==null&&s.addUploadProgressListener(o),s.send(this.url_,this.method_,this.body_,this.headers_).then(()=>{this.progressCallback_!==null&&s.removeUploadProgressListener(o),this.pendingConnection_=null;const a=s.getErrorCode()===Fi.NO_ERROR,u=s.getStatus();if(!a||SS(u,this.additionalRetryCodes_)&&this.retry){const d=s.getErrorCode()===Fi.ABORT;r(!1,new yu(!1,null,d));return}const c=this.successCodes_.indexOf(u)!==-1;r(!0,new yu(c,s))})},n=(r,i)=>{const s=this.resolve_,o=this.reject_,a=i.connection;if(i.wasSuccessCode)try{const u=this.callback_(a,a.getResponse());IO(u)?s(u):s()}catch(u){o(u)}else if(a!==null){const u=_g();u.serverResponse=a.getErrorText(),this.errorCallback_?o(this.errorCallback_(a,u)):o(u)}else if(i.canceled){const u=this.appDelete_?TS():wS();o(u)}else{const u=vS();o(u)}};this.canceled_?n(!1,new yu(!1,null,!0)):this.backoffId_=EO(e,n,this.timeout_)}getPromise(){return this.promise_}cancel(e){this.canceled_=!0,this.appDelete_=e||!1,this.backoffId_!==null&&TO(this.backoffId_),this.pendingConnection_!==null&&this.pendingConnection_.abort()}}class yu{constructor(e,n,r){this.wasSuccessCode=e,this.connection=n,this.canceled=!!r}}function RO(t,e){e!==null&&e.length>0&&(t.Authorization="Firebase "+e)}function AO(t,e){t["X-Firebase-Storage-Version"]="webjs/"+(e??"AppManager")}function xO(t,e){e&&(t["X-Firebase-GMPID"]=e)}function PO(t,e){e!==null&&(t["X-Firebase-AppCheck"]=e)}function bO(t,e,n,r,i,s,o=!0){const a=IS(t.urlParams),u=t.url+a,c=Object.assign({},t.headers);return xO(c,e),RO(c,n),AO(c,s),PO(c,r),new CO(u,t.method,c,t.body,t.successCodes,t.additionalRetryCodes,t.handler,t.errorHandler,t.timeout,t.progressCallback,i,o)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function NO(){return typeof BlobBuilder<"u"?BlobBuilder:typeof WebKitBlobBuilder<"u"?WebKitBlobBuilder:void 0}function OO(...t){const e=NO();if(e!==void 0){const n=new e;for(let r=0;r<t.length;r++)n.append(t[r]);return n.getBlob()}else{if(yg())return new Blob(t);throw new He(je.UNSUPPORTED_ENVIRONMENT,"This browser doesn't seem to support creating Blobs")}}function DO(t,e,n){return t.webkitSlice?t.webkitSlice(e,n):t.mozSlice?t.mozSlice(e,n):t.slice?t.slice(e,n):null}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function MO(t){if(typeof atob>"u")throw yO("base-64");return atob(t)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const $n={RAW:"raw",BASE64:"base64",BASE64URL:"base64url",DATA_URL:"data_url"};class Ld{constructor(e,n){this.data=e,this.contentType=n||null}}function LO(t,e){switch(t){case $n.RAW:return new Ld(kS(e));case $n.BASE64:case $n.BASE64URL:return new Ld(CS(t,e));case $n.DATA_URL:return new Ld(FO(e),UO(e))}throw _g()}function kS(t){const e=[];for(let n=0;n<t.length;n++){let r=t.charCodeAt(n);if(r<=127)e.push(r);else if(r<=2047)e.push(192|r>>6,128|r&63);else if((r&64512)===55296)if(!(n<t.length-1&&(t.charCodeAt(n+1)&64512)===56320))e.push(239,191,189);else{const s=r,o=t.charCodeAt(++n);r=65536|(s&1023)<<10|o&1023,e.push(240|r>>18,128|r>>12&63,128|r>>6&63,128|r&63)}else(r&64512)===56320?e.push(239,191,189):e.push(224|r>>12,128|r>>6&63,128|r&63)}return new Uint8Array(e)}function VO(t){let e;try{e=decodeURIComponent(t)}catch{throw Ia($n.DATA_URL,"Malformed data URL.")}return kS(e)}function CS(t,e){switch(t){case $n.BASE64:{const i=e.indexOf("-")!==-1,s=e.indexOf("_")!==-1;if(i||s)throw Ia(t,"Invalid character '"+(i?"-":"_")+"' found: is it base64url encoded?");break}case $n.BASE64URL:{const i=e.indexOf("+")!==-1,s=e.indexOf("/")!==-1;if(i||s)throw Ia(t,"Invalid character '"+(i?"+":"/")+"' found: is it base64 encoded?");e=e.replace(/-/g,"+").replace(/_/g,"/");break}}let n;try{n=MO(e)}catch(i){throw i.message.includes("polyfill")?i:Ia(t,"Invalid character found")}const r=new Uint8Array(n.length);for(let i=0;i<n.length;i++)r[i]=n.charCodeAt(i);return r}class RS{constructor(e){this.base64=!1,this.contentType=null;const n=e.match(/^data:([^,]+)?,/);if(n===null)throw Ia($n.DATA_URL,"Must be formatted 'data:[<mediatype>][;base64],<data>");const r=n[1]||null;r!=null&&(this.base64=jO(r,";base64"),this.contentType=this.base64?r.substring(0,r.length-7):r),this.rest=e.substring(e.indexOf(",")+1)}}function FO(t){const e=new RS(t);return e.base64?CS($n.BASE64,e.rest):VO(e.rest)}function UO(t){return new RS(t).contentType}function jO(t,e){return t.length>=e.length?t.substring(t.length-e.length)===e:!1}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Fr{constructor(e,n){let r=0,i="";hw(e)?(this.data_=e,r=e.size,i=e.type):e instanceof ArrayBuffer?(n?this.data_=new Uint8Array(e):(this.data_=new Uint8Array(e.byteLength),this.data_.set(new Uint8Array(e))),r=this.data_.length):e instanceof Uint8Array&&(n?this.data_=e:(this.data_=new Uint8Array(e.length),this.data_.set(e)),r=e.length),this.size_=r,this.type_=i}size(){return this.size_}type(){return this.type_}slice(e,n){if(hw(this.data_)){const r=this.data_,i=DO(r,e,n);return i===null?null:new Fr(i)}else{const r=new Uint8Array(this.data_.buffer,e,n-e);return new Fr(r,!0)}}static getBlob(...e){if(yg()){const n=e.map(r=>r instanceof Fr?r.data_:r);return new Fr(OO.apply(null,n))}else{const n=e.map(o=>Sh(o)?LO($n.RAW,o).data:o.data_);let r=0;n.forEach(o=>{r+=o.byteLength});const i=new Uint8Array(r);let s=0;return n.forEach(o=>{for(let a=0;a<o.length;a++)i[s++]=o[a]}),new Fr(i,!0)}}uploadData(){return this.data_}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function AS(t){let e;try{e=JSON.parse(t)}catch{return null}return kO(e)?e:null}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function zO(t){if(t.length===0)return null;const e=t.lastIndexOf("/");return e===-1?"":t.slice(0,e)}function BO(t,e){const n=e.split("/").filter(r=>r.length>0).join("/");return t.length===0?n:t+"/"+n}function xS(t){const e=t.lastIndexOf("/",t.length-2);return e===-1?t:t.slice(e+1)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function $O(t,e){return e}class jt{constructor(e,n,r,i){this.server=e,this.local=n||e,this.writable=!!r,this.xform=i||$O}}let vu=null;function WO(t){return!Sh(t)||t.length<2?t:xS(t)}function PS(){if(vu)return vu;const t=[];t.push(new jt("bucket")),t.push(new jt("generation")),t.push(new jt("metageneration")),t.push(new jt("name","fullPath",!0));function e(s,o){return WO(o)}const n=new jt("name");n.xform=e,t.push(n);function r(s,o){return o!==void 0?Number(o):o}const i=new jt("size");return i.xform=r,t.push(i),t.push(new jt("timeCreated")),t.push(new jt("updated")),t.push(new jt("md5Hash",null,!0)),t.push(new jt("cacheControl",null,!0)),t.push(new jt("contentDisposition",null,!0)),t.push(new jt("contentEncoding",null,!0)),t.push(new jt("contentLanguage",null,!0)),t.push(new jt("contentType",null,!0)),t.push(new jt("metadata","customMetadata",!0)),vu=t,vu}function qO(t,e){function n(){const r=t.bucket,i=t.fullPath,s=new an(r,i);return e._makeStorageReference(s)}Object.defineProperty(t,"ref",{get:n})}function HO(t,e,n){const r={};r.type="file";const i=n.length;for(let s=0;s<i;s++){const o=n[s];r[o.local]=o.xform(r,e[o.server])}return qO(r,t),r}function bS(t,e,n){const r=AS(e);return r===null?null:HO(t,r,n)}function GO(t,e,n,r){const i=AS(e);if(i===null||!Sh(i.downloadTokens))return null;const s=i.downloadTokens;if(s.length===0)return null;const o=encodeURIComponent;return s.split(",").map(c=>{const d=t.bucket,f=t.fullPath,m="/b/"+o(d)+"/o/"+o(f),w=wo(m,n,r),I=IS({alt:"media",token:c});return w+I})[0]}function NS(t,e){const n={},r=e.length;for(let i=0;i<r;i++){const s=e[i];s.writable&&(n[s.server]=t[s.local])}return JSON.stringify(n)}class is{constructor(e,n,r,i){this.url=e,this.method=n,this.handler=r,this.timeout=i,this.urlParams={},this.headers={},this.body=null,this.errorHandler=null,this.progressCallback=null,this.successCodes=[200],this.additionalRetryCodes=[]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function fr(t){if(!t)throw _g()}function vg(t,e){function n(r,i){const s=bS(t,i,e);return fr(s!==null),s}return n}function KO(t,e){function n(r,i){const s=bS(t,i,e);return fr(s!==null),GO(s,i,t.host,t._protocol)}return n}function Tl(t){function e(n,r){let i;return n.getStatus()===401?n.getErrorText().includes("Firebase App Check token is invalid")?i=hO():i=cO():n.getStatus()===402?i=uO(t.bucket):n.getStatus()===403?i=dO(t.path):i=r,i.status=n.getStatus(),i.serverResponse=r.serverResponse,i}return e}function wg(t){const e=Tl(t);function n(r,i){let s=e(r,i);return r.getStatus()===404&&(s=lO(t.path)),s.serverResponse=i.serverResponse,s}return n}function QO(t,e,n){const r=e.fullServerUrl(),i=wo(r,t.host,t._protocol),s="GET",o=t.maxOperationRetryTime,a=new is(i,s,vg(t,n),o);return a.errorHandler=wg(e),a}function YO(t,e,n){const r=e.fullServerUrl(),i=wo(r,t.host,t._protocol),s="GET",o=t.maxOperationRetryTime,a=new is(i,s,KO(t,n),o);return a.errorHandler=wg(e),a}function XO(t,e){const n=e.fullServerUrl(),r=wo(n,t.host,t._protocol),i="DELETE",s=t.maxOperationRetryTime;function o(u,c){}const a=new is(r,i,o,s);return a.successCodes=[200,204],a.errorHandler=wg(e),a}function JO(t,e){return t&&t.contentType||e&&e.type()||"application/octet-stream"}function OS(t,e,n){const r=Object.assign({},n);return r.fullPath=t.path,r.size=e.size(),r.contentType||(r.contentType=JO(null,e)),r}function ZO(t,e,n,r,i){const s=e.bucketOnlyServerUrl(),o={"X-Goog-Upload-Protocol":"multipart"};function a(){let S="";for(let M=0;M<2;M++)S=S+Math.random().toString().slice(2);return S}const u=a();o["Content-Type"]="multipart/related; boundary="+u;const c=OS(e,r,i),d=NS(c,n),f="--"+u+`\r
Content-Type: application/json; charset=utf-8\r
\r
`+d+`\r
--`+u+`\r
Content-Type: `+c.contentType+`\r
\r
`,m=`\r
--`+u+"--",w=Fr.getBlob(f,r,m);if(w===null)throw ES();const I={name:c.fullPath},P=wo(s,t.host,t._protocol),O="POST",C=t.maxUploadRetryTime,T=new is(P,O,vg(t,n),C);return T.urlParams=I,T.headers=o,T.body=w.uploadData(),T.errorHandler=Tl(e),T}class Ac{constructor(e,n,r,i){this.current=e,this.total=n,this.finalized=!!r,this.metadata=i||null}}function Eg(t,e){let n=null;try{n=t.getResponseHeader("X-Goog-Upload-Status")}catch{fr(!1)}return fr(!!n&&(e||["active"]).indexOf(n)!==-1),n}function eD(t,e,n,r,i){const s=e.bucketOnlyServerUrl(),o=OS(e,r,i),a={name:o.fullPath},u=wo(s,t.host,t._protocol),c="POST",d={"X-Goog-Upload-Protocol":"resumable","X-Goog-Upload-Command":"start","X-Goog-Upload-Header-Content-Length":`${r.size()}`,"X-Goog-Upload-Header-Content-Type":o.contentType,"Content-Type":"application/json; charset=utf-8"},f=NS(o,n),m=t.maxUploadRetryTime;function w(P){Eg(P);let O;try{O=P.getResponseHeader("X-Goog-Upload-URL")}catch{fr(!1)}return fr(Sh(O)),O}const I=new is(u,c,w,m);return I.urlParams=a,I.headers=d,I.body=f,I.errorHandler=Tl(e),I}function tD(t,e,n,r){const i={"X-Goog-Upload-Command":"query"};function s(c){const d=Eg(c,["active","final"]);let f=null;try{f=c.getResponseHeader("X-Goog-Upload-Size-Received")}catch{fr(!1)}f||fr(!1);const m=Number(f);return fr(!isNaN(m)),new Ac(m,r.size(),d==="final")}const o="POST",a=t.maxUploadRetryTime,u=new is(n,o,s,a);return u.headers=i,u.errorHandler=Tl(e),u}const fw=256*1024;function nD(t,e,n,r,i,s,o,a){const u=new Ac(0,0);if(o?(u.current=o.current,u.total=o.total):(u.current=0,u.total=r.size()),r.size()!==u.total)throw gO();const c=u.total-u.current;let d=c;i>0&&(d=Math.min(d,i));const f=u.current,m=f+d;let w="";d===0?w="finalize":c===d?w="upload, finalize":w="upload";const I={"X-Goog-Upload-Command":w,"X-Goog-Upload-Offset":`${u.current}`},P=r.slice(f,m);if(P===null)throw ES();function O(M,V){const F=Eg(M,["active","final"]),y=u.current+d,g=r.size();let E;return F==="final"?E=vg(e,s)(M,V):E=null,new Ac(y,g,F==="final",E)}const C="POST",T=e.maxUploadRetryTime,S=new is(n,C,O,T);return S.headers=I,S.body=P.uploadData(),S.progressCallback=a||null,S.errorHandler=Tl(t),S}const Gt={RUNNING:"running",PAUSED:"paused",SUCCESS:"success",CANCELED:"canceled",ERROR:"error"};function Vd(t){switch(t){case"running":case"pausing":case"canceling":return Gt.RUNNING;case"paused":return Gt.PAUSED;case"success":return Gt.SUCCESS;case"canceled":return Gt.CANCELED;case"error":return Gt.ERROR;default:return Gt.ERROR}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class rD{constructor(e,n,r){if(SO(e)||n!=null||r!=null)this.next=e,this.error=n??void 0,this.complete=r??void 0;else{const s=e;this.next=s.next,this.error=s.error,this.complete=s.complete}}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function ms(t){return(...e)=>{Promise.resolve().then(()=>t(...e))}}class iD{constructor(){this.sent_=!1,this.xhr_=new XMLHttpRequest,this.initXhr(),this.errorCode_=Fi.NO_ERROR,this.sendPromise_=new Promise(e=>{this.xhr_.addEventListener("abort",()=>{this.errorCode_=Fi.ABORT,e()}),this.xhr_.addEventListener("error",()=>{this.errorCode_=Fi.NETWORK_ERROR,e()}),this.xhr_.addEventListener("load",()=>{e()})})}send(e,n,r,i){if(this.sent_)throw Yo("cannot .send() more than once");if(this.sent_=!0,this.xhr_.open(n,e,!0),i!==void 0)for(const s in i)i.hasOwnProperty(s)&&this.xhr_.setRequestHeader(s,i[s].toString());return r!==void 0?this.xhr_.send(r):this.xhr_.send(),this.sendPromise_}getErrorCode(){if(!this.sent_)throw Yo("cannot .getErrorCode() before sending");return this.errorCode_}getStatus(){if(!this.sent_)throw Yo("cannot .getStatus() before sending");try{return this.xhr_.status}catch{return-1}}getResponse(){if(!this.sent_)throw Yo("cannot .getResponse() before sending");return this.xhr_.response}getErrorText(){if(!this.sent_)throw Yo("cannot .getErrorText() before sending");return this.xhr_.statusText}abort(){this.xhr_.abort()}getResponseHeader(e){return this.xhr_.getResponseHeader(e)}addUploadProgressListener(e){this.xhr_.upload!=null&&this.xhr_.upload.addEventListener("progress",e)}removeUploadProgressListener(e){this.xhr_.upload!=null&&this.xhr_.upload.removeEventListener("progress",e)}}class sD extends iD{initXhr(){this.xhr_.responseType="text"}}function Ai(){return new sD}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class oD{constructor(e,n,r=null){this._transferred=0,this._needToFetchStatus=!1,this._needToFetchMetadata=!1,this._observers=[],this._error=void 0,this._uploadUrl=void 0,this._request=void 0,this._chunkMultiplier=1,this._resolve=void 0,this._reject=void 0,this._ref=e,this._blob=n,this._metadata=r,this._mappings=PS(),this._resumable=this._shouldDoResumable(this._blob),this._state="running",this._errorHandler=i=>{if(this._request=void 0,this._chunkMultiplier=1,i._codeEquals(je.CANCELED))this._needToFetchStatus=!0,this.completeTransitions_();else{const s=this.isExponentialBackoffExpired();if(SS(i.status,[]))if(s)i=vS();else{this.sleepTime=Math.max(this.sleepTime*2,aO),this._needToFetchStatus=!0,this.completeTransitions_();return}this._error=i,this._transition("error")}},this._metadataErrorHandler=i=>{this._request=void 0,i._codeEquals(je.CANCELED)?this.completeTransitions_():(this._error=i,this._transition("error"))},this.sleepTime=0,this.maxSleepTime=this._ref.storage.maxUploadRetryTime,this._promise=new Promise((i,s)=>{this._resolve=i,this._reject=s,this._start()}),this._promise.then(null,()=>{})}isExponentialBackoffExpired(){return this.sleepTime>this.maxSleepTime}_makeProgressCallback(){const e=this._transferred;return n=>this._updateProgress(e+n)}_shouldDoResumable(e){return e.size()>256*1024}_start(){this._state==="running"&&this._request===void 0&&(this._resumable?this._uploadUrl===void 0?this._createResumable():this._needToFetchStatus?this._fetchStatus():this._needToFetchMetadata?this._fetchMetadata():this.pendingTimeout=setTimeout(()=>{this.pendingTimeout=void 0,this._continueUpload()},this.sleepTime):this._oneShotUpload())}_resolveToken(e){Promise.all([this._ref.storage._getAuthToken(),this._ref.storage._getAppCheckToken()]).then(([n,r])=>{switch(this._state){case"running":e(n,r);break;case"canceling":this._transition("canceled");break;case"pausing":this._transition("paused");break}})}_createResumable(){this._resolveToken((e,n)=>{const r=eD(this._ref.storage,this._ref._location,this._mappings,this._blob,this._metadata),i=this._ref.storage._makeRequest(r,Ai,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._uploadUrl=s,this._needToFetchStatus=!1,this.completeTransitions_()},this._errorHandler)})}_fetchStatus(){const e=this._uploadUrl;this._resolveToken((n,r)=>{const i=tD(this._ref.storage,this._ref._location,e,this._blob),s=this._ref.storage._makeRequest(i,Ai,n,r);this._request=s,s.getPromise().then(o=>{o=o,this._request=void 0,this._updateProgress(o.current),this._needToFetchStatus=!1,o.finalized&&(this._needToFetchMetadata=!0),this.completeTransitions_()},this._errorHandler)})}_continueUpload(){const e=fw*this._chunkMultiplier,n=new Ac(this._transferred,this._blob.size()),r=this._uploadUrl;this._resolveToken((i,s)=>{let o;try{o=nD(this._ref._location,this._ref.storage,r,this._blob,e,this._mappings,n,this._makeProgressCallback())}catch(u){this._error=u,this._transition("error");return}const a=this._ref.storage._makeRequest(o,Ai,i,s,!1);this._request=a,a.getPromise().then(u=>{this._increaseMultiplier(),this._request=void 0,this._updateProgress(u.current),u.finalized?(this._metadata=u.metadata,this._transition("success")):this.completeTransitions_()},this._errorHandler)})}_increaseMultiplier(){fw*this._chunkMultiplier*2<32*1024*1024&&(this._chunkMultiplier*=2)}_fetchMetadata(){this._resolveToken((e,n)=>{const r=QO(this._ref.storage,this._ref._location,this._mappings),i=this._ref.storage._makeRequest(r,Ai,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._metadata=s,this._transition("success")},this._metadataErrorHandler)})}_oneShotUpload(){this._resolveToken((e,n)=>{const r=ZO(this._ref.storage,this._ref._location,this._mappings,this._blob,this._metadata),i=this._ref.storage._makeRequest(r,Ai,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._metadata=s,this._updateProgress(this._blob.size()),this._transition("success")},this._errorHandler)})}_updateProgress(e){const n=this._transferred;this._transferred=e,this._transferred!==n&&this._notifyObservers()}_transition(e){if(this._state!==e)switch(e){case"canceling":case"pausing":this._state=e,this._request!==void 0?this._request.cancel():this.pendingTimeout&&(clearTimeout(this.pendingTimeout),this.pendingTimeout=void 0,this.completeTransitions_());break;case"running":const n=this._state==="paused";this._state=e,n&&(this._notifyObservers(),this._start());break;case"paused":this._state=e,this._notifyObservers();break;case"canceled":this._error=wS(),this._state=e,this._notifyObservers();break;case"error":this._state=e,this._notifyObservers();break;case"success":this._state=e,this._notifyObservers();break}}completeTransitions_(){switch(this._state){case"pausing":this._transition("paused");break;case"canceling":this._transition("canceled");break;case"running":this._start();break}}get snapshot(){const e=Vd(this._state);return{bytesTransferred:this._transferred,totalBytes:this._blob.size(),state:e,metadata:this._metadata,task:this,ref:this._ref}}on(e,n,r,i){const s=new rD(n||void 0,r||void 0,i||void 0);return this._addObserver(s),()=>{this._removeObserver(s)}}then(e,n){return this._promise.then(e,n)}catch(e){return this.then(null,e)}_addObserver(e){this._observers.push(e),this._notifyObserver(e)}_removeObserver(e){const n=this._observers.indexOf(e);n!==-1&&this._observers.splice(n,1)}_notifyObservers(){this._finishPromise(),this._observers.slice().forEach(n=>{this._notifyObserver(n)})}_finishPromise(){if(this._resolve!==void 0){let e=!0;switch(Vd(this._state)){case Gt.SUCCESS:ms(this._resolve.bind(null,this.snapshot))();break;case Gt.CANCELED:case Gt.ERROR:const n=this._reject;ms(n.bind(null,this._error))();break;default:e=!1;break}e&&(this._resolve=void 0,this._reject=void 0)}}_notifyObserver(e){switch(Vd(this._state)){case Gt.RUNNING:case Gt.PAUSED:e.next&&ms(e.next.bind(e,this.snapshot))();break;case Gt.SUCCESS:e.complete&&ms(e.complete.bind(e))();break;case Gt.CANCELED:case Gt.ERROR:e.error&&ms(e.error.bind(e,this._error))();break;default:e.error&&ms(e.error.bind(e,this._error))()}}resume(){const e=this._state==="paused"||this._state==="pausing";return e&&this._transition("running"),e}pause(){const e=this._state==="running";return e&&this._transition("pausing"),e}cancel(){const e=this._state==="running"||this._state==="pausing";return e&&this._transition("canceling"),e}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Gi{constructor(e,n){this._service=e,n instanceof an?this._location=n:this._location=an.makeFromUrl(n,e.host)}toString(){return"gs://"+this._location.bucket+"/"+this._location.path}_newRef(e,n){return new Gi(e,n)}get root(){const e=new an(this._location.bucket,"");return this._newRef(this._service,e)}get bucket(){return this._location.bucket}get fullPath(){return this._location.path}get name(){return xS(this._location.path)}get storage(){return this._service}get parent(){const e=zO(this._location.path);if(e===null)return null;const n=new an(this._location.bucket,e);return new Gi(this._service,n)}_throwIfRoot(e){if(this._location.path==="")throw vO(e)}}function aD(t,e,n){return t._throwIfRoot("uploadBytesResumable"),new oD(t,new Fr(e),n)}function lD(t){t._throwIfRoot("getDownloadURL");const e=YO(t.storage,t._location,PS());return t.storage.makeRequestWithTokens(e,Ai).then(n=>{if(n===null)throw _O();return n})}function uD(t){t._throwIfRoot("deleteObject");const e=XO(t.storage,t._location);return t.storage.makeRequestWithTokens(e,Ai)}function cD(t,e){const n=BO(t._location.path,e),r=new an(t._location.bucket,n);return new Gi(t.storage,r)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function hD(t){return/^[A-Za-z]+:\/\//.test(t)}function dD(t,e){return new Gi(t,e)}function DS(t,e){if(t instanceof Tg){const n=t;if(n._bucket==null)throw mO();const r=new Gi(n,n._bucket);return e!=null?DS(r,e):r}else return e!==void 0?cD(t,e):t}function fD(t,e){if(e&&hD(e)){if(t instanceof Tg)return dD(t,e);throw gp("To use ref(service, url), the first argument must be a Storage instance.")}else return DS(t,e)}function pw(t,e){const n=e==null?void 0:e[yS];return n==null?null:an.makeFromBucketSpec(n,t)}function pD(t,e,n,r={}){t.host=`${e}:${n}`,t._protocol="http";const{mockUserToken:i}=r;i&&(t._overrideAuthToken=typeof i=="string"?i:Nm(i,t.app.options.projectId))}class Tg{constructor(e,n,r,i,s){this.app=e,this._authProvider=n,this._appCheckProvider=r,this._url=i,this._firebaseVersion=s,this._bucket=null,this._host=_S,this._protocol="https",this._appId=null,this._deleted=!1,this._maxOperationRetryTime=sO,this._maxUploadRetryTime=oO,this._requests=new Set,i!=null?this._bucket=an.makeFromBucketSpec(i,this._host):this._bucket=pw(this._host,this.app.options)}get host(){return this._host}set host(e){this._host=e,this._url!=null?this._bucket=an.makeFromBucketSpec(this._url,e):this._bucket=pw(e,this.app.options)}get maxUploadRetryTime(){return this._maxUploadRetryTime}set maxUploadRetryTime(e){dw("time",0,Number.POSITIVE_INFINITY,e),this._maxUploadRetryTime=e}get maxOperationRetryTime(){return this._maxOperationRetryTime}set maxOperationRetryTime(e){dw("time",0,Number.POSITIVE_INFINITY,e),this._maxOperationRetryTime=e}async _getAuthToken(){if(this._overrideAuthToken)return this._overrideAuthToken;const e=this._authProvider.getImmediate({optional:!0});if(e){const n=await e.getToken();if(n!==null)return n.accessToken}return null}async _getAppCheckToken(){const e=this._appCheckProvider.getImmediate({optional:!0});return e?(await e.getToken()).token:null}_delete(){return this._deleted||(this._deleted=!0,this._requests.forEach(e=>e.cancel()),this._requests.clear()),Promise.resolve()}_makeStorageReference(e){return new Gi(this,e)}_makeRequest(e,n,r,i,s=!0){if(this._deleted)return new wO(TS());{const o=bO(e,this._appId,r,i,n,this._firebaseVersion,s);return this._requests.add(o),o.getPromise().then(()=>this._requests.delete(o),()=>this._requests.delete(o)),o}}async makeRequestWithTokens(e,n){const[r,i]=await Promise.all([this._getAuthToken(),this._getAppCheckToken()]);return this._makeRequest(e,n,r,i).getPromise()}}const mw="@firebase/storage",gw="0.13.2";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const MS="storage";function _w(t,e,n){return t=Qe(t),aD(t,e,n)}function yw(t){return t=Qe(t),lD(t)}function mD(t){return t=Qe(t),uD(t)}function Fd(t,e){return t=Qe(t),fD(t,e)}function gD(t=hh(),e){t=Qe(t);const r=ml(t,MS).getImmediate({identifier:e}),i=bm("storage");return i&&_D(r,...i),r}function _D(t,e,n,r={}){pD(t,e,n,r)}function yD(t,{instanceIdentifier:e}){const n=t.getProvider("app").getImmediate(),r=t.getProvider("auth-internal"),i=t.getProvider("app-check-internal");return new Tg(n,r,i,e,yi)}function vD(){ui(new vr(MS,yD,"PUBLIC").setMultipleInstances(!0)),wn(mw,gw,""),wn(mw,gw,"esm2017")}vD();var vw={};const ww="@firebase/database",Ew="1.0.8";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let LS="";function wD(t){LS=t}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ED{constructor(e){this.domStorage_=e,this.prefix_="firebase:"}set(e,n){n==null?this.domStorage_.removeItem(this.prefixedName_(e)):this.domStorage_.setItem(this.prefixedName_(e),Et(n))}get(e){const n=this.domStorage_.getItem(this.prefixedName_(e));return n==null?null:Qa(n)}remove(e){this.domStorage_.removeItem(this.prefixedName_(e))}prefixedName_(e){return this.prefix_+e}toString(){return this.domStorage_.toString()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class TD{constructor(){this.cache_={},this.isInMemoryStorage=!0}set(e,n){n==null?delete this.cache_[e]:this.cache_[e]=n}get(e){return Ar(this.cache_,e)?this.cache_[e]:null}remove(e){delete this.cache_[e]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const VS=function(t){try{if(typeof window<"u"&&typeof window[t]<"u"){const e=window[t];return e.setItem("firebase:sentinel","cache"),e.removeItem("firebase:sentinel"),new ED(e)}}catch{}return new TD},Oi=VS("localStorage"),ID=VS("sessionStorage");/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const zs=new ch("@firebase/database"),SD=function(){let t=1;return function(){return t++}}(),FS=function(t){const e=Lx(t),n=new Nx;n.update(e);const r=n.digest();return Pm.encodeByteArray(r)},Il=function(...t){let e="";for(let n=0;n<t.length;n++){const r=t[n];Array.isArray(r)||r&&typeof r=="object"&&typeof r.length=="number"?e+=Il.apply(null,r):typeof r=="object"?e+=Et(r):e+=r,e+=" "}return e};let Sa=null,Tw=!0;const kD=function(t,e){H(!0,"Can't turn on custom loggers persistently."),zs.logLevel=ce.VERBOSE,Sa=zs.log.bind(zs)},Mt=function(...t){if(Tw===!0&&(Tw=!1,Sa===null&&ID.get("logging_enabled")===!0&&kD()),Sa){const e=Il.apply(null,t);Sa(e)}},Sl=function(t){return function(...e){Mt(t,...e)}},_p=function(...t){const e="FIREBASE INTERNAL ERROR: "+Il(...t);zs.error(e)},Ir=function(...t){const e=`FIREBASE FATAL ERROR: ${Il(...t)}`;throw zs.error(e),new Error(e)},en=function(...t){const e="FIREBASE WARNING: "+Il(...t);zs.warn(e)},CD=function(){typeof window<"u"&&window.location&&window.location.protocol&&window.location.protocol.indexOf("https:")!==-1&&en("Insecure Firebase access from a secure page. Please use https in calls to new Firebase().")},US=function(t){return typeof t=="number"&&(t!==t||t===Number.POSITIVE_INFINITY||t===Number.NEGATIVE_INFINITY)},RD=function(t){if(document.readyState==="complete")t();else{let e=!1;const n=function(){if(!document.body){setTimeout(n,Math.floor(10));return}e||(e=!0,t())};document.addEventListener?(document.addEventListener("DOMContentLoaded",n,!1),window.addEventListener("load",n,!1)):document.attachEvent&&(document.attachEvent("onreadystatechange",()=>{document.readyState==="complete"&&n()}),window.attachEvent("onload",n))}},ao="[MIN_NAME]",Ki="[MAX_NAME]",Eo=function(t,e){if(t===e)return 0;if(t===ao||e===Ki)return-1;if(e===ao||t===Ki)return 1;{const n=Iw(t),r=Iw(e);return n!==null?r!==null?n-r===0?t.length-e.length:n-r:-1:r!==null?1:t<e?-1:1}},AD=function(t,e){return t===e?0:t<e?-1:1},Xo=function(t,e){if(e&&t in e)return e[t];throw new Error("Missing required key ("+t+") in object: "+Et(e))},Ig=function(t){if(typeof t!="object"||t===null)return Et(t);const e=[];for(const r in t)e.push(r);e.sort();let n="{";for(let r=0;r<e.length;r++)r!==0&&(n+=","),n+=Et(e[r]),n+=":",n+=Ig(t[e[r]]);return n+="}",n},jS=function(t,e){const n=t.length;if(n<=e)return[t];const r=[];for(let i=0;i<n;i+=e)i+e>n?r.push(t.substring(i,n)):r.push(t.substring(i,i+e));return r};function Sn(t,e){for(const n in t)t.hasOwnProperty(n)&&e(n,t[n])}const zS=function(t){H(!US(t),"Invalid JSON number");const e=11,n=52,r=(1<<e-1)-1;let i,s,o,a,u;t===0?(s=0,o=0,i=1/t===-1/0?1:0):(i=t<0,t=Math.abs(t),t>=Math.pow(2,1-r)?(a=Math.min(Math.floor(Math.log(t)/Math.LN2),r),s=a+r,o=Math.round(t*Math.pow(2,n-a)-Math.pow(2,n))):(s=0,o=Math.round(t/Math.pow(2,1-r-n))));const c=[];for(u=n;u;u-=1)c.push(o%2?1:0),o=Math.floor(o/2);for(u=e;u;u-=1)c.push(s%2?1:0),s=Math.floor(s/2);c.push(i?1:0),c.reverse();const d=c.join("");let f="";for(u=0;u<64;u+=8){let m=parseInt(d.substr(u,8),2).toString(16);m.length===1&&(m="0"+m),f=f+m}return f.toLowerCase()},xD=function(){return!!(typeof window=="object"&&window.chrome&&window.chrome.extension&&!/^chrome/.test(window.location.href))},PD=function(){return typeof Windows=="object"&&typeof Windows.UI=="object"},bD=new RegExp("^-?(0*)\\d{1,10}$"),ND=-2147483648,OD=2147483647,Iw=function(t){if(bD.test(t)){const e=Number(t);if(e>=ND&&e<=OD)return e}return null},To=function(t){try{t()}catch(e){setTimeout(()=>{const n=e.stack||"";throw en("Exception was thrown by user callback.",n),e},Math.floor(0))}},DD=function(){return(typeof window=="object"&&window.navigator&&window.navigator.userAgent||"").search(/googlebot|google webmaster tools|bingbot|yahoo! slurp|baiduspider|yandexbot|duckduckbot/i)>=0},ka=function(t,e){const n=setTimeout(t,e);return typeof n=="number"&&typeof Deno<"u"&&Deno.unrefTimer?Deno.unrefTimer(n):typeof n=="object"&&n.unref&&n.unref(),n};/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class MD{constructor(e,n){this.appName_=e,this.appCheckProvider=n,this.appCheck=n==null?void 0:n.getImmediate({optional:!0}),this.appCheck||n==null||n.get().then(r=>this.appCheck=r)}getToken(e){return this.appCheck?this.appCheck.getToken(e):new Promise((n,r)=>{setTimeout(()=>{this.appCheck?this.getToken(e).then(n,r):n(null)},0)})}addTokenChangeListener(e){var n;(n=this.appCheckProvider)===null||n===void 0||n.get().then(r=>r.addTokenListener(e))}notifyForInvalidToken(){en(`Provided AppCheck credentials for the app named "${this.appName_}" are invalid. This usually indicates your app was not initialized correctly.`)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class LD{constructor(e,n,r){this.appName_=e,this.firebaseOptions_=n,this.authProvider_=r,this.auth_=null,this.auth_=r.getImmediate({optional:!0}),this.auth_||r.onInit(i=>this.auth_=i)}getToken(e){return this.auth_?this.auth_.getToken(e).catch(n=>n&&n.code==="auth/token-not-initialized"?(Mt("Got auth/token-not-initialized error.  Treating as null token."),null):Promise.reject(n)):new Promise((n,r)=>{setTimeout(()=>{this.auth_?this.getToken(e).then(n,r):n(null)},0)})}addTokenChangeListener(e){this.auth_?this.auth_.addAuthTokenListener(e):this.authProvider_.get().then(n=>n.addAuthTokenListener(e))}removeTokenChangeListener(e){this.authProvider_.get().then(n=>n.removeAuthTokenListener(e))}notifyForInvalidToken(){let e='Provided authentication credentials for the app named "'+this.appName_+'" are invalid. This usually indicates your app was not initialized correctly. ';"credential"in this.firebaseOptions_?e+='Make sure the "credential" property provided to initializeApp() is authorized to access the specified "databaseURL" and is from the correct project.':"serviceAccount"in this.firebaseOptions_?e+='Make sure the "serviceAccount" property provided to initializeApp() is authorized to access the specified "databaseURL" and is from the correct project.':e+='Make sure the "apiKey" and "databaseURL" properties provided to initializeApp() match the values provided for your app at https://console.firebase.google.com/.',en(e)}}class zu{constructor(e){this.accessToken=e}getToken(e){return Promise.resolve({accessToken:this.accessToken})}addTokenChangeListener(e){e(this.accessToken)}removeTokenChangeListener(e){}notifyForInvalidToken(){}}zu.OWNER="owner";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Sg="5",BS="v",$S="s",WS="r",qS="f",HS=/(console\.firebase|firebase-console-\w+\.corp|firebase\.corp)\.google\.com/,GS="ls",KS="p",yp="ac",QS="websocket",YS="long_polling";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class XS{constructor(e,n,r,i,s=!1,o="",a=!1,u=!1){this.secure=n,this.namespace=r,this.webSocketOnly=i,this.nodeAdmin=s,this.persistenceKey=o,this.includeNamespaceInQueryParams=a,this.isUsingEmulator=u,this._host=e.toLowerCase(),this._domain=this._host.substr(this._host.indexOf(".")+1),this.internalHost=Oi.get("host:"+e)||this._host}isCacheableHost(){return this.internalHost.substr(0,2)==="s-"}isCustomHost(){return this._domain!=="firebaseio.com"&&this._domain!=="firebaseio-demo.com"}get host(){return this._host}set host(e){e!==this.internalHost&&(this.internalHost=e,this.isCacheableHost()&&Oi.set("host:"+this._host,this.internalHost))}toString(){let e=this.toURLString();return this.persistenceKey&&(e+="<"+this.persistenceKey+">"),e}toURLString(){const e=this.secure?"https://":"http://",n=this.includeNamespaceInQueryParams?`?ns=${this.namespace}`:"";return`${e}${this.host}/${n}`}}function VD(t){return t.host!==t.internalHost||t.isCustomHost()||t.includeNamespaceInQueryParams}function JS(t,e,n){H(typeof e=="string","typeof type must == string"),H(typeof n=="object","typeof params must == object");let r;if(e===QS)r=(t.secure?"wss://":"ws://")+t.internalHost+"/.ws?";else if(e===YS)r=(t.secure?"https://":"http://")+t.internalHost+"/.lp?";else throw new Error("Unknown connection type: "+e);VD(t)&&(n.ns=t.namespace);const i=[];return Sn(n,(s,o)=>{i.push(s+"="+o)}),r+i.join("&")}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class FD{constructor(){this.counters_={}}incrementCounter(e,n=1){Ar(this.counters_,e)||(this.counters_[e]=0),this.counters_[e]+=n}get(){return fx(this.counters_)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Ud={},jd={};function kg(t){const e=t.toString();return Ud[e]||(Ud[e]=new FD),Ud[e]}function UD(t,e){const n=t.toString();return jd[n]||(jd[n]=e()),jd[n]}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jD{constructor(e){this.onMessage_=e,this.pendingResponses=[],this.currentResponseNum=0,this.closeAfterResponse=-1,this.onClose=null}closeAfter(e,n){this.closeAfterResponse=e,this.onClose=n,this.closeAfterResponse<this.currentResponseNum&&(this.onClose(),this.onClose=null)}handleResponse(e,n){for(this.pendingResponses[e]=n;this.pendingResponses[this.currentResponseNum];){const r=this.pendingResponses[this.currentResponseNum];delete this.pendingResponses[this.currentResponseNum];for(let i=0;i<r.length;++i)r[i]&&To(()=>{this.onMessage_(r[i])});if(this.currentResponseNum===this.closeAfterResponse){this.onClose&&(this.onClose(),this.onClose=null);break}this.currentResponseNum++}}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Sw="start",zD="close",BD="pLPCommand",$D="pRTLPCB",ZS="id",ek="pw",tk="ser",WD="cb",qD="seg",HD="ts",GD="d",KD="dframe",nk=1870,rk=30,QD=nk-rk,YD=25e3,XD=3e4;class Ns{constructor(e,n,r,i,s,o,a){this.connId=e,this.repoInfo=n,this.applicationId=r,this.appCheckToken=i,this.authToken=s,this.transportSessionId=o,this.lastSessionId=a,this.bytesSent=0,this.bytesReceived=0,this.everConnected_=!1,this.log_=Sl(e),this.stats_=kg(n),this.urlFn=u=>(this.appCheckToken&&(u[yp]=this.appCheckToken),JS(n,YS,u))}open(e,n){this.curSegmentNum=0,this.onDisconnect_=n,this.myPacketOrderer=new jD(e),this.isClosed_=!1,this.connectTimeoutTimer_=setTimeout(()=>{this.log_("Timed out trying to connect."),this.onClosed_(),this.connectTimeoutTimer_=null},Math.floor(XD)),RD(()=>{if(this.isClosed_)return;this.scriptTagHolder=new Cg((...s)=>{const[o,a,u,c,d]=s;if(this.incrementIncomingBytes_(s),!!this.scriptTagHolder)if(this.connectTimeoutTimer_&&(clearTimeout(this.connectTimeoutTimer_),this.connectTimeoutTimer_=null),this.everConnected_=!0,o===Sw)this.id=a,this.password=u;else if(o===zD)a?(this.scriptTagHolder.sendNewPolls=!1,this.myPacketOrderer.closeAfter(a,()=>{this.onClosed_()})):this.onClosed_();else throw new Error("Unrecognized command received: "+o)},(...s)=>{const[o,a]=s;this.incrementIncomingBytes_(s),this.myPacketOrderer.handleResponse(o,a)},()=>{this.onClosed_()},this.urlFn);const r={};r[Sw]="t",r[tk]=Math.floor(Math.random()*1e8),this.scriptTagHolder.uniqueCallbackIdentifier&&(r[WD]=this.scriptTagHolder.uniqueCallbackIdentifier),r[BS]=Sg,this.transportSessionId&&(r[$S]=this.transportSessionId),this.lastSessionId&&(r[GS]=this.lastSessionId),this.applicationId&&(r[KS]=this.applicationId),this.appCheckToken&&(r[yp]=this.appCheckToken),typeof location<"u"&&location.hostname&&HS.test(location.hostname)&&(r[WS]=qS);const i=this.urlFn(r);this.log_("Connecting via long-poll to "+i),this.scriptTagHolder.addTag(i,()=>{})})}start(){this.scriptTagHolder.startLongPoll(this.id,this.password),this.addDisconnectPingFrame(this.id,this.password)}static forceAllow(){Ns.forceAllow_=!0}static forceDisallow(){Ns.forceDisallow_=!0}static isAvailable(){return Ns.forceAllow_?!0:!Ns.forceDisallow_&&typeof document<"u"&&document.createElement!=null&&!xD()&&!PD()}markConnectionHealthy(){}shutdown_(){this.isClosed_=!0,this.scriptTagHolder&&(this.scriptTagHolder.close(),this.scriptTagHolder=null),this.myDisconnFrame&&(document.body.removeChild(this.myDisconnFrame),this.myDisconnFrame=null),this.connectTimeoutTimer_&&(clearTimeout(this.connectTimeoutTimer_),this.connectTimeoutTimer_=null)}onClosed_(){this.isClosed_||(this.log_("Longpoll is closing itself"),this.shutdown_(),this.onDisconnect_&&(this.onDisconnect_(this.everConnected_),this.onDisconnect_=null))}close(){this.isClosed_||(this.log_("Longpoll is being closed."),this.shutdown_())}send(e){const n=Et(e);this.bytesSent+=n.length,this.stats_.incrementCounter("bytes_sent",n.length);const r=UT(n),i=jS(r,QD);for(let s=0;s<i.length;s++)this.scriptTagHolder.enqueueSegment(this.curSegmentNum,i.length,i[s]),this.curSegmentNum++}addDisconnectPingFrame(e,n){this.myDisconnFrame=document.createElement("iframe");const r={};r[KD]="t",r[ZS]=e,r[ek]=n,this.myDisconnFrame.src=this.urlFn(r),this.myDisconnFrame.style.display="none",document.body.appendChild(this.myDisconnFrame)}incrementIncomingBytes_(e){const n=Et(e).length;this.bytesReceived+=n,this.stats_.incrementCounter("bytes_received",n)}}class Cg{constructor(e,n,r,i){this.onDisconnect=r,this.urlFn=i,this.outstandingRequests=new Set,this.pendingSegs=[],this.currentSerial=Math.floor(Math.random()*1e8),this.sendNewPolls=!0;{this.uniqueCallbackIdentifier=SD(),window[BD+this.uniqueCallbackIdentifier]=e,window[$D+this.uniqueCallbackIdentifier]=n,this.myIFrame=Cg.createIFrame_();let s="";this.myIFrame.src&&this.myIFrame.src.substr(0,11)==="javascript:"&&(s='<script>document.domain="'+document.domain+'";<\/script>');const o="<html><body>"+s+"</body></html>";try{this.myIFrame.doc.open(),this.myIFrame.doc.write(o),this.myIFrame.doc.close()}catch(a){Mt("frame writing exception"),a.stack&&Mt(a.stack),Mt(a)}}}static createIFrame_(){const e=document.createElement("iframe");if(e.style.display="none",document.body){document.body.appendChild(e);try{e.contentWindow.document||Mt("No IE domain setting required")}catch{const r=document.domain;e.src="javascript:void((function(){document.open();document.domain='"+r+"';document.close();})())"}}else throw"Document body has not initialized. Wait to initialize Firebase until after the document is ready.";return e.contentDocument?e.doc=e.contentDocument:e.contentWindow?e.doc=e.contentWindow.document:e.document&&(e.doc=e.document),e}close(){this.alive=!1,this.myIFrame&&(this.myIFrame.doc.body.textContent="",setTimeout(()=>{this.myIFrame!==null&&(document.body.removeChild(this.myIFrame),this.myIFrame=null)},Math.floor(0)));const e=this.onDisconnect;e&&(this.onDisconnect=null,e())}startLongPoll(e,n){for(this.myID=e,this.myPW=n,this.alive=!0;this.newRequest_(););}newRequest_(){if(this.alive&&this.sendNewPolls&&this.outstandingRequests.size<(this.pendingSegs.length>0?2:1)){this.currentSerial++;const e={};e[ZS]=this.myID,e[ek]=this.myPW,e[tk]=this.currentSerial;let n=this.urlFn(e),r="",i=0;for(;this.pendingSegs.length>0&&this.pendingSegs[0].d.length+rk+r.length<=nk;){const o=this.pendingSegs.shift();r=r+"&"+qD+i+"="+o.seg+"&"+HD+i+"="+o.ts+"&"+GD+i+"="+o.d,i++}return n=n+r,this.addLongPollTag_(n,this.currentSerial),!0}else return!1}enqueueSegment(e,n,r){this.pendingSegs.push({seg:e,ts:n,d:r}),this.alive&&this.newRequest_()}addLongPollTag_(e,n){this.outstandingRequests.add(n);const r=()=>{this.outstandingRequests.delete(n),this.newRequest_()},i=setTimeout(r,Math.floor(YD)),s=()=>{clearTimeout(i),r()};this.addTag(e,s)}addTag(e,n){setTimeout(()=>{try{if(!this.sendNewPolls)return;const r=this.myIFrame.doc.createElement("script");r.type="text/javascript",r.async=!0,r.src=e,r.onload=r.onreadystatechange=function(){const i=r.readyState;(!i||i==="loaded"||i==="complete")&&(r.onload=r.onreadystatechange=null,r.parentNode&&r.parentNode.removeChild(r),n())},r.onerror=()=>{Mt("Long-poll script failed to load: "+e),this.sendNewPolls=!1,this.close()},this.myIFrame.doc.body.appendChild(r)}catch{}},Math.floor(1))}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const JD=16384,ZD=45e3;let xc=null;typeof MozWebSocket<"u"?xc=MozWebSocket:typeof WebSocket<"u"&&(xc=WebSocket);class bn{constructor(e,n,r,i,s,o,a){this.connId=e,this.applicationId=r,this.appCheckToken=i,this.authToken=s,this.keepaliveTimer=null,this.frames=null,this.totalFrames=0,this.bytesSent=0,this.bytesReceived=0,this.log_=Sl(this.connId),this.stats_=kg(n),this.connURL=bn.connectionURL_(n,o,a,i,r),this.nodeAdmin=n.nodeAdmin}static connectionURL_(e,n,r,i,s){const o={};return o[BS]=Sg,typeof location<"u"&&location.hostname&&HS.test(location.hostname)&&(o[WS]=qS),n&&(o[$S]=n),r&&(o[GS]=r),i&&(o[yp]=i),s&&(o[KS]=s),JS(e,QS,o)}open(e,n){this.onDisconnect=n,this.onMessage=e,this.log_("Websocket connecting to "+this.connURL),this.everConnected_=!1,Oi.set("previous_websocket_failure",!0);try{let r;Ix(),this.mySock=new xc(this.connURL,[],r)}catch(r){this.log_("Error instantiating WebSocket.");const i=r.message||r.data;i&&this.log_(i),this.onClosed_();return}this.mySock.onopen=()=>{this.log_("Websocket connected."),this.everConnected_=!0},this.mySock.onclose=()=>{this.log_("Websocket connection was disconnected."),this.mySock=null,this.onClosed_()},this.mySock.onmessage=r=>{this.handleIncomingFrame(r)},this.mySock.onerror=r=>{this.log_("WebSocket error.  Closing connection.");const i=r.message||r.data;i&&this.log_(i),this.onClosed_()}}start(){}static forceDisallow(){bn.forceDisallow_=!0}static isAvailable(){let e=!1;if(typeof navigator<"u"&&navigator.userAgent){const n=/Android ([0-9]{0,}\.[0-9]{0,})/,r=navigator.userAgent.match(n);r&&r.length>1&&parseFloat(r[1])<4.4&&(e=!0)}return!e&&xc!==null&&!bn.forceDisallow_}static previouslyFailed(){return Oi.isInMemoryStorage||Oi.get("previous_websocket_failure")===!0}markConnectionHealthy(){Oi.remove("previous_websocket_failure")}appendFrame_(e){if(this.frames.push(e),this.frames.length===this.totalFrames){const n=this.frames.join("");this.frames=null;const r=Qa(n);this.onMessage(r)}}handleNewFrameCount_(e){this.totalFrames=e,this.frames=[]}extractFrameCount_(e){if(H(this.frames===null,"We already have a frame buffer"),e.length<=6){const n=Number(e);if(!isNaN(n))return this.handleNewFrameCount_(n),null}return this.handleNewFrameCount_(1),e}handleIncomingFrame(e){if(this.mySock===null)return;const n=e.data;if(this.bytesReceived+=n.length,this.stats_.incrementCounter("bytes_received",n.length),this.resetKeepAlive(),this.frames!==null)this.appendFrame_(n);else{const r=this.extractFrameCount_(n);r!==null&&this.appendFrame_(r)}}send(e){this.resetKeepAlive();const n=Et(e);this.bytesSent+=n.length,this.stats_.incrementCounter("bytes_sent",n.length);const r=jS(n,JD);r.length>1&&this.sendString_(String(r.length));for(let i=0;i<r.length;i++)this.sendString_(r[i])}shutdown_(){this.isClosed_=!0,this.keepaliveTimer&&(clearInterval(this.keepaliveTimer),this.keepaliveTimer=null),this.mySock&&(this.mySock.close(),this.mySock=null)}onClosed_(){this.isClosed_||(this.log_("WebSocket is closing itself"),this.shutdown_(),this.onDisconnect&&(this.onDisconnect(this.everConnected_),this.onDisconnect=null))}close(){this.isClosed_||(this.log_("WebSocket is being closed"),this.shutdown_())}resetKeepAlive(){clearInterval(this.keepaliveTimer),this.keepaliveTimer=setInterval(()=>{this.mySock&&this.sendString_("0"),this.resetKeepAlive()},Math.floor(ZD))}sendString_(e){try{this.mySock.send(e)}catch(n){this.log_("Exception thrown from WebSocket.send():",n.message||n.data,"Closing connection."),setTimeout(this.onClosed_.bind(this),0)}}}bn.responsesRequiredToBeHealthy=2;bn.healthyTimeout=3e4;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ol{constructor(e){this.initTransports_(e)}static get ALL_TRANSPORTS(){return[Ns,bn]}static get IS_TRANSPORT_INITIALIZED(){return this.globalTransportInitialized_}initTransports_(e){const n=bn&&bn.isAvailable();let r=n&&!bn.previouslyFailed();if(e.webSocketOnly&&(n||en("wss:// URL used, but browser isn't known to support websockets.  Trying anyway."),r=!0),r)this.transports_=[bn];else{const i=this.transports_=[];for(const s of ol.ALL_TRANSPORTS)s&&s.isAvailable()&&i.push(s);ol.globalTransportInitialized_=!0}}initialTransport(){if(this.transports_.length>0)return this.transports_[0];throw new Error("No transports available")}upgradeTransport(){return this.transports_.length>1?this.transports_[1]:null}}ol.globalTransportInitialized_=!1;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const eM=6e4,tM=5e3,nM=10*1024,rM=100*1024,zd="t",kw="d",iM="s",Cw="r",sM="e",Rw="o",Aw="a",xw="n",Pw="p",oM="h";class aM{constructor(e,n,r,i,s,o,a,u,c,d){this.id=e,this.repoInfo_=n,this.applicationId_=r,this.appCheckToken_=i,this.authToken_=s,this.onMessage_=o,this.onReady_=a,this.onDisconnect_=u,this.onKill_=c,this.lastSessionId=d,this.connectionCount=0,this.pendingDataMessages=[],this.state_=0,this.log_=Sl("c:"+this.id+":"),this.transportManager_=new ol(n),this.log_("Connection created"),this.start_()}start_(){const e=this.transportManager_.initialTransport();this.conn_=new e(this.nextTransportId_(),this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,null,this.lastSessionId),this.primaryResponsesRequired_=e.responsesRequiredToBeHealthy||0;const n=this.connReceiver_(this.conn_),r=this.disconnReceiver_(this.conn_);this.tx_=this.conn_,this.rx_=this.conn_,this.secondaryConn_=null,this.isHealthy_=!1,setTimeout(()=>{this.conn_&&this.conn_.open(n,r)},Math.floor(0));const i=e.healthyTimeout||0;i>0&&(this.healthyTimeout_=ka(()=>{this.healthyTimeout_=null,this.isHealthy_||(this.conn_&&this.conn_.bytesReceived>rM?(this.log_("Connection exceeded healthy timeout but has received "+this.conn_.bytesReceived+" bytes.  Marking connection healthy."),this.isHealthy_=!0,this.conn_.markConnectionHealthy()):this.conn_&&this.conn_.bytesSent>nM?this.log_("Connection exceeded healthy timeout but has sent "+this.conn_.bytesSent+" bytes.  Leaving connection alive."):(this.log_("Closing unhealthy connection after timeout."),this.close()))},Math.floor(i)))}nextTransportId_(){return"c:"+this.id+":"+this.connectionCount++}disconnReceiver_(e){return n=>{e===this.conn_?this.onConnectionLost_(n):e===this.secondaryConn_?(this.log_("Secondary connection lost."),this.onSecondaryConnectionLost_()):this.log_("closing an old connection")}}connReceiver_(e){return n=>{this.state_!==2&&(e===this.rx_?this.onPrimaryMessageReceived_(n):e===this.secondaryConn_?this.onSecondaryMessageReceived_(n):this.log_("message on old connection"))}}sendRequest(e){const n={t:"d",d:e};this.sendData_(n)}tryCleanupConnection(){this.tx_===this.secondaryConn_&&this.rx_===this.secondaryConn_&&(this.log_("cleaning up and promoting a connection: "+this.secondaryConn_.connId),this.conn_=this.secondaryConn_,this.secondaryConn_=null)}onSecondaryControl_(e){if(zd in e){const n=e[zd];n===Aw?this.upgradeIfSecondaryHealthy_():n===Cw?(this.log_("Got a reset on secondary, closing it"),this.secondaryConn_.close(),(this.tx_===this.secondaryConn_||this.rx_===this.secondaryConn_)&&this.close()):n===Rw&&(this.log_("got pong on secondary."),this.secondaryResponsesRequired_--,this.upgradeIfSecondaryHealthy_())}}onSecondaryMessageReceived_(e){const n=Xo("t",e),r=Xo("d",e);if(n==="c")this.onSecondaryControl_(r);else if(n==="d")this.pendingDataMessages.push(r);else throw new Error("Unknown protocol layer: "+n)}upgradeIfSecondaryHealthy_(){this.secondaryResponsesRequired_<=0?(this.log_("Secondary connection is healthy."),this.isHealthy_=!0,this.secondaryConn_.markConnectionHealthy(),this.proceedWithUpgrade_()):(this.log_("sending ping on secondary."),this.secondaryConn_.send({t:"c",d:{t:Pw,d:{}}}))}proceedWithUpgrade_(){this.secondaryConn_.start(),this.log_("sending client ack on secondary"),this.secondaryConn_.send({t:"c",d:{t:Aw,d:{}}}),this.log_("Ending transmission on primary"),this.conn_.send({t:"c",d:{t:xw,d:{}}}),this.tx_=this.secondaryConn_,this.tryCleanupConnection()}onPrimaryMessageReceived_(e){const n=Xo("t",e),r=Xo("d",e);n==="c"?this.onControl_(r):n==="d"&&this.onDataMessage_(r)}onDataMessage_(e){this.onPrimaryResponse_(),this.onMessage_(e)}onPrimaryResponse_(){this.isHealthy_||(this.primaryResponsesRequired_--,this.primaryResponsesRequired_<=0&&(this.log_("Primary connection is healthy."),this.isHealthy_=!0,this.conn_.markConnectionHealthy()))}onControl_(e){const n=Xo(zd,e);if(kw in e){const r=e[kw];if(n===oM){const i=Object.assign({},r);this.repoInfo_.isUsingEmulator&&(i.h=this.repoInfo_.host),this.onHandshake_(i)}else if(n===xw){this.log_("recvd end transmission on primary"),this.rx_=this.secondaryConn_;for(let i=0;i<this.pendingDataMessages.length;++i)this.onDataMessage_(this.pendingDataMessages[i]);this.pendingDataMessages=[],this.tryCleanupConnection()}else n===iM?this.onConnectionShutdown_(r):n===Cw?this.onReset_(r):n===sM?_p("Server Error: "+r):n===Rw?(this.log_("got pong on primary."),this.onPrimaryResponse_(),this.sendPingOnPrimaryIfNecessary_()):_p("Unknown control packet command: "+n)}}onHandshake_(e){const n=e.ts,r=e.v,i=e.h;this.sessionId=e.s,this.repoInfo_.host=i,this.state_===0&&(this.conn_.start(),this.onConnectionEstablished_(this.conn_,n),Sg!==r&&en("Protocol version mismatch detected"),this.tryStartUpgrade_())}tryStartUpgrade_(){const e=this.transportManager_.upgradeTransport();e&&this.startUpgrade_(e)}startUpgrade_(e){this.secondaryConn_=new e(this.nextTransportId_(),this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,this.sessionId),this.secondaryResponsesRequired_=e.responsesRequiredToBeHealthy||0;const n=this.connReceiver_(this.secondaryConn_),r=this.disconnReceiver_(this.secondaryConn_);this.secondaryConn_.open(n,r),ka(()=>{this.secondaryConn_&&(this.log_("Timed out trying to upgrade."),this.secondaryConn_.close())},Math.floor(eM))}onReset_(e){this.log_("Reset packet received.  New host: "+e),this.repoInfo_.host=e,this.state_===1?this.close():(this.closeConnections_(),this.start_())}onConnectionEstablished_(e,n){this.log_("Realtime connection established."),this.conn_=e,this.state_=1,this.onReady_&&(this.onReady_(n,this.sessionId),this.onReady_=null),this.primaryResponsesRequired_===0?(this.log_("Primary connection is healthy."),this.isHealthy_=!0):ka(()=>{this.sendPingOnPrimaryIfNecessary_()},Math.floor(tM))}sendPingOnPrimaryIfNecessary_(){!this.isHealthy_&&this.state_===1&&(this.log_("sending ping on primary."),this.sendData_({t:"c",d:{t:Pw,d:{}}}))}onSecondaryConnectionLost_(){const e=this.secondaryConn_;this.secondaryConn_=null,(this.tx_===e||this.rx_===e)&&this.close()}onConnectionLost_(e){this.conn_=null,!e&&this.state_===0?(this.log_("Realtime connection failed."),this.repoInfo_.isCacheableHost()&&(Oi.remove("host:"+this.repoInfo_.host),this.repoInfo_.internalHost=this.repoInfo_.host)):this.state_===1&&this.log_("Realtime connection lost."),this.close()}onConnectionShutdown_(e){this.log_("Connection shutdown command received. Shutting down..."),this.onKill_&&(this.onKill_(e),this.onKill_=null),this.onDisconnect_=null,this.close()}sendData_(e){if(this.state_!==1)throw"Connection is not connected";this.tx_.send(e)}close(){this.state_!==2&&(this.log_("Closing realtime connection."),this.state_=2,this.closeConnections_(),this.onDisconnect_&&(this.onDisconnect_(),this.onDisconnect_=null))}closeConnections_(){this.log_("Shutting down all connections"),this.conn_&&(this.conn_.close(),this.conn_=null),this.secondaryConn_&&(this.secondaryConn_.close(),this.secondaryConn_=null),this.healthyTimeout_&&(clearTimeout(this.healthyTimeout_),this.healthyTimeout_=null)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ik{put(e,n,r,i){}merge(e,n,r,i){}refreshAuthToken(e){}refreshAppCheckToken(e){}onDisconnectPut(e,n,r){}onDisconnectMerge(e,n,r){}onDisconnectCancel(e,n){}reportStats(e){}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class sk{constructor(e){this.allowedEvents_=e,this.listeners_={},H(Array.isArray(e)&&e.length>0,"Requires a non-empty array")}trigger(e,...n){if(Array.isArray(this.listeners_[e])){const r=[...this.listeners_[e]];for(let i=0;i<r.length;i++)r[i].callback.apply(r[i].context,n)}}on(e,n,r){this.validateEventType_(e),this.listeners_[e]=this.listeners_[e]||[],this.listeners_[e].push({callback:n,context:r});const i=this.getInitialEvent(e);i&&n.apply(r,i)}off(e,n,r){this.validateEventType_(e);const i=this.listeners_[e]||[];for(let s=0;s<i.length;s++)if(i[s].callback===n&&(!r||r===i[s].context)){i.splice(s,1);return}}validateEventType_(e){H(this.allowedEvents_.find(n=>n===e),"Unknown event: "+e)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Pc extends sk{constructor(){super(["online"]),this.online_=!0,typeof window<"u"&&typeof window.addEventListener<"u"&&!Om()&&(window.addEventListener("online",()=>{this.online_||(this.online_=!0,this.trigger("online",!0))},!1),window.addEventListener("offline",()=>{this.online_&&(this.online_=!1,this.trigger("online",!1))},!1))}static getInstance(){return new Pc}getInitialEvent(e){return H(e==="online","Unknown event type: "+e),[this.online_]}currentlyOnline(){return this.online_}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const bw=32,Nw=768;class ze{constructor(e,n){if(n===void 0){this.pieces_=e.split("/");let r=0;for(let i=0;i<this.pieces_.length;i++)this.pieces_[i].length>0&&(this.pieces_[r]=this.pieces_[i],r++);this.pieces_.length=r,this.pieceNum_=0}else this.pieces_=e,this.pieceNum_=n}toString(){let e="";for(let n=this.pieceNum_;n<this.pieces_.length;n++)this.pieces_[n]!==""&&(e+="/"+this.pieces_[n]);return e||"/"}}function Re(){return new ze("")}function he(t){return t.pieceNum_>=t.pieces_.length?null:t.pieces_[t.pieceNum_]}function fi(t){return t.pieces_.length-t.pieceNum_}function Ve(t){let e=t.pieceNum_;return e<t.pieces_.length&&e++,new ze(t.pieces_,e)}function ok(t){return t.pieceNum_<t.pieces_.length?t.pieces_[t.pieces_.length-1]:null}function lM(t){let e="";for(let n=t.pieceNum_;n<t.pieces_.length;n++)t.pieces_[n]!==""&&(e+="/"+encodeURIComponent(String(t.pieces_[n])));return e||"/"}function ak(t,e=0){return t.pieces_.slice(t.pieceNum_+e)}function lk(t){if(t.pieceNum_>=t.pieces_.length)return null;const e=[];for(let n=t.pieceNum_;n<t.pieces_.length-1;n++)e.push(t.pieces_[n]);return new ze(e,0)}function at(t,e){const n=[];for(let r=t.pieceNum_;r<t.pieces_.length;r++)n.push(t.pieces_[r]);if(e instanceof ze)for(let r=e.pieceNum_;r<e.pieces_.length;r++)n.push(e.pieces_[r]);else{const r=e.split("/");for(let i=0;i<r.length;i++)r[i].length>0&&n.push(r[i])}return new ze(n,0)}function fe(t){return t.pieceNum_>=t.pieces_.length}function gn(t,e){const n=he(t),r=he(e);if(n===null)return e;if(n===r)return gn(Ve(t),Ve(e));throw new Error("INTERNAL ERROR: innerPath ("+e+") is not within outerPath ("+t+")")}function uk(t,e){if(fi(t)!==fi(e))return!1;for(let n=t.pieceNum_,r=e.pieceNum_;n<=t.pieces_.length;n++,r++)if(t.pieces_[n]!==e.pieces_[r])return!1;return!0}function On(t,e){let n=t.pieceNum_,r=e.pieceNum_;if(fi(t)>fi(e))return!1;for(;n<t.pieces_.length;){if(t.pieces_[n]!==e.pieces_[r])return!1;++n,++r}return!0}class uM{constructor(e,n){this.errorPrefix_=n,this.parts_=ak(e,0),this.byteLength_=Math.max(1,this.parts_.length);for(let r=0;r<this.parts_.length;r++)this.byteLength_+=uh(this.parts_[r]);ck(this)}}function cM(t,e){t.parts_.length>0&&(t.byteLength_+=1),t.parts_.push(e),t.byteLength_+=uh(e),ck(t)}function hM(t){const e=t.parts_.pop();t.byteLength_-=uh(e),t.parts_.length>0&&(t.byteLength_-=1)}function ck(t){if(t.byteLength_>Nw)throw new Error(t.errorPrefix_+"has a key path longer than "+Nw+" bytes ("+t.byteLength_+").");if(t.parts_.length>bw)throw new Error(t.errorPrefix_+"path specified exceeds the maximum depth that can be written ("+bw+") or object contains a cycle "+Ri(t))}function Ri(t){return t.parts_.length===0?"":"in property '"+t.parts_.join(".")+"'"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Rg extends sk{constructor(){super(["visible"]);let e,n;typeof document<"u"&&typeof document.addEventListener<"u"&&(typeof document.hidden<"u"?(n="visibilitychange",e="hidden"):typeof document.mozHidden<"u"?(n="mozvisibilitychange",e="mozHidden"):typeof document.msHidden<"u"?(n="msvisibilitychange",e="msHidden"):typeof document.webkitHidden<"u"&&(n="webkitvisibilitychange",e="webkitHidden")),this.visible_=!0,n&&document.addEventListener(n,()=>{const r=!document[e];r!==this.visible_&&(this.visible_=r,this.trigger("visible",r))},!1)}static getInstance(){return new Rg}getInitialEvent(e){return H(e==="visible","Unknown event type: "+e),[this.visible_]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Jo=1e3,dM=60*5*1e3,Ow=30*1e3,fM=1.3,pM=3e4,mM="server_kill",Dw=3;class pr extends ik{constructor(e,n,r,i,s,o,a,u){if(super(),this.repoInfo_=e,this.applicationId_=n,this.onDataUpdate_=r,this.onConnectStatus_=i,this.onServerInfoUpdate_=s,this.authTokenProvider_=o,this.appCheckTokenProvider_=a,this.authOverride_=u,this.id=pr.nextPersistentConnectionId_++,this.log_=Sl("p:"+this.id+":"),this.interruptReasons_={},this.listens=new Map,this.outstandingPuts_=[],this.outstandingGets_=[],this.outstandingPutCount_=0,this.outstandingGetCount_=0,this.onDisconnectRequestQueue_=[],this.connected_=!1,this.reconnectDelay_=Jo,this.maxReconnectDelay_=dM,this.securityDebugCallback_=null,this.lastSessionId=null,this.establishConnectionTimer_=null,this.visible_=!1,this.requestCBHash_={},this.requestNumber_=0,this.realtime_=null,this.authToken_=null,this.appCheckToken_=null,this.forceTokenRefresh_=!1,this.invalidAuthTokenCount_=0,this.invalidAppCheckTokenCount_=0,this.firstConnection_=!0,this.lastConnectionAttemptTime_=null,this.lastConnectionEstablishedTime_=null,u)throw new Error("Auth override specified in options, but not supported on non Node.js platforms");Rg.getInstance().on("visible",this.onVisible_,this),e.host.indexOf("fblocal")===-1&&Pc.getInstance().on("online",this.onOnline_,this)}sendRequest(e,n,r){const i=++this.requestNumber_,s={r:i,a:e,b:n};this.log_(Et(s)),H(this.connected_,"sendRequest call when we're not connected not allowed."),this.realtime_.sendRequest(s),r&&(this.requestCBHash_[i]=r)}get(e){this.initConnection_();const n=new lh,i={action:"g",request:{p:e._path.toString(),q:e._queryObject},onComplete:o=>{const a=o.d;o.s==="ok"?n.resolve(a):n.reject(a)}};this.outstandingGets_.push(i),this.outstandingGetCount_++;const s=this.outstandingGets_.length-1;return this.connected_&&this.sendGet_(s),n.promise}listen(e,n,r,i){this.initConnection_();const s=e._queryIdentifier,o=e._path.toString();this.log_("Listen called for "+o+" "+s),this.listens.has(o)||this.listens.set(o,new Map),H(e._queryParams.isDefault()||!e._queryParams.loadsAllData(),"listen() called for non-default but complete query"),H(!this.listens.get(o).has(s),"listen() called twice for same path/queryId.");const a={onComplete:i,hashFn:n,query:e,tag:r};this.listens.get(o).set(s,a),this.connected_&&this.sendListen_(a)}sendGet_(e){const n=this.outstandingGets_[e];this.sendRequest("g",n.request,r=>{delete this.outstandingGets_[e],this.outstandingGetCount_--,this.outstandingGetCount_===0&&(this.outstandingGets_=[]),n.onComplete&&n.onComplete(r)})}sendListen_(e){const n=e.query,r=n._path.toString(),i=n._queryIdentifier;this.log_("Listen on "+r+" for "+i);const s={p:r},o="q";e.tag&&(s.q=n._queryObject,s.t=e.tag),s.h=e.hashFn(),this.sendRequest(o,s,a=>{const u=a.d,c=a.s;pr.warnOnListenWarnings_(u,n),(this.listens.get(r)&&this.listens.get(r).get(i))===e&&(this.log_("listen response",a),c!=="ok"&&this.removeListen_(r,i),e.onComplete&&e.onComplete(c,u))})}static warnOnListenWarnings_(e,n){if(e&&typeof e=="object"&&Ar(e,"w")){const r=Zs(e,"w");if(Array.isArray(r)&&~r.indexOf("no_index")){const i='".indexOn": "'+n._queryParams.getIndex().toString()+'"',s=n._path.toString();en(`Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding ${i} at ${s} to your security rules for better performance.`)}}}refreshAuthToken(e){this.authToken_=e,this.log_("Auth token refreshed"),this.authToken_?this.tryAuth():this.connected_&&this.sendRequest("unauth",{},()=>{}),this.reduceReconnectDelayIfAdminCredential_(e)}reduceReconnectDelayIfAdminCredential_(e){(e&&e.length===40||bx(e))&&(this.log_("Admin auth credential detected.  Reducing max reconnect time."),this.maxReconnectDelay_=Ow)}refreshAppCheckToken(e){this.appCheckToken_=e,this.log_("App check token refreshed"),this.appCheckToken_?this.tryAppCheck():this.connected_&&this.sendRequest("unappeck",{},()=>{})}tryAuth(){if(this.connected_&&this.authToken_){const e=this.authToken_,n=Px(e)?"auth":"gauth",r={cred:e};this.authOverride_===null?r.noauth=!0:typeof this.authOverride_=="object"&&(r.authvar=this.authOverride_),this.sendRequest(n,r,i=>{const s=i.s,o=i.d||"error";this.authToken_===e&&(s==="ok"?this.invalidAuthTokenCount_=0:this.onAuthRevoked_(s,o))})}}tryAppCheck(){this.connected_&&this.appCheckToken_&&this.sendRequest("appcheck",{token:this.appCheckToken_},e=>{const n=e.s,r=e.d||"error";n==="ok"?this.invalidAppCheckTokenCount_=0:this.onAppCheckRevoked_(n,r)})}unlisten(e,n){const r=e._path.toString(),i=e._queryIdentifier;this.log_("Unlisten called for "+r+" "+i),H(e._queryParams.isDefault()||!e._queryParams.loadsAllData(),"unlisten() called for non-default but complete query"),this.removeListen_(r,i)&&this.connected_&&this.sendUnlisten_(r,i,e._queryObject,n)}sendUnlisten_(e,n,r,i){this.log_("Unlisten on "+e+" for "+n);const s={p:e},o="n";i&&(s.q=r,s.t=i),this.sendRequest(o,s)}onDisconnectPut(e,n,r){this.initConnection_(),this.connected_?this.sendOnDisconnect_("o",e,n,r):this.onDisconnectRequestQueue_.push({pathString:e,action:"o",data:n,onComplete:r})}onDisconnectMerge(e,n,r){this.initConnection_(),this.connected_?this.sendOnDisconnect_("om",e,n,r):this.onDisconnectRequestQueue_.push({pathString:e,action:"om",data:n,onComplete:r})}onDisconnectCancel(e,n){this.initConnection_(),this.connected_?this.sendOnDisconnect_("oc",e,null,n):this.onDisconnectRequestQueue_.push({pathString:e,action:"oc",data:null,onComplete:n})}sendOnDisconnect_(e,n,r,i){const s={p:n,d:r};this.log_("onDisconnect "+e,s),this.sendRequest(e,s,o=>{i&&setTimeout(()=>{i(o.s,o.d)},Math.floor(0))})}put(e,n,r,i){this.putInternal("p",e,n,r,i)}merge(e,n,r,i){this.putInternal("m",e,n,r,i)}putInternal(e,n,r,i,s){this.initConnection_();const o={p:n,d:r};s!==void 0&&(o.h=s),this.outstandingPuts_.push({action:e,request:o,onComplete:i}),this.outstandingPutCount_++;const a=this.outstandingPuts_.length-1;this.connected_?this.sendPut_(a):this.log_("Buffering put: "+n)}sendPut_(e){const n=this.outstandingPuts_[e].action,r=this.outstandingPuts_[e].request,i=this.outstandingPuts_[e].onComplete;this.outstandingPuts_[e].queued=this.connected_,this.sendRequest(n,r,s=>{this.log_(n+" response",s),delete this.outstandingPuts_[e],this.outstandingPutCount_--,this.outstandingPutCount_===0&&(this.outstandingPuts_=[]),i&&i(s.s,s.d)})}reportStats(e){if(this.connected_){const n={c:e};this.log_("reportStats",n),this.sendRequest("s",n,r=>{if(r.s!=="ok"){const s=r.d;this.log_("reportStats","Error sending stats: "+s)}})}}onDataMessage_(e){if("r"in e){this.log_("from server: "+Et(e));const n=e.r,r=this.requestCBHash_[n];r&&(delete this.requestCBHash_[n],r(e.b))}else{if("error"in e)throw"A server-side error has occurred: "+e.error;"a"in e&&this.onDataPush_(e.a,e.b)}}onDataPush_(e,n){this.log_("handleServerMessage",e,n),e==="d"?this.onDataUpdate_(n.p,n.d,!1,n.t):e==="m"?this.onDataUpdate_(n.p,n.d,!0,n.t):e==="c"?this.onListenRevoked_(n.p,n.q):e==="ac"?this.onAuthRevoked_(n.s,n.d):e==="apc"?this.onAppCheckRevoked_(n.s,n.d):e==="sd"?this.onSecurityDebugPacket_(n):_p("Unrecognized action received from server: "+Et(e)+`
Are you using the latest client?`)}onReady_(e,n){this.log_("connection ready"),this.connected_=!0,this.lastConnectionEstablishedTime_=new Date().getTime(),this.handleTimestamp_(e),this.lastSessionId=n,this.firstConnection_&&this.sendConnectStats_(),this.restoreState_(),this.firstConnection_=!1,this.onConnectStatus_(!0)}scheduleConnect_(e){H(!this.realtime_,"Scheduling a connect when we're already connected/ing?"),this.establishConnectionTimer_&&clearTimeout(this.establishConnectionTimer_),this.establishConnectionTimer_=setTimeout(()=>{this.establishConnectionTimer_=null,this.establishConnection_()},Math.floor(e))}initConnection_(){!this.realtime_&&this.firstConnection_&&this.scheduleConnect_(0)}onVisible_(e){e&&!this.visible_&&this.reconnectDelay_===this.maxReconnectDelay_&&(this.log_("Window became visible.  Reducing delay."),this.reconnectDelay_=Jo,this.realtime_||this.scheduleConnect_(0)),this.visible_=e}onOnline_(e){e?(this.log_("Browser went online."),this.reconnectDelay_=Jo,this.realtime_||this.scheduleConnect_(0)):(this.log_("Browser went offline.  Killing connection."),this.realtime_&&this.realtime_.close())}onRealtimeDisconnect_(){if(this.log_("data client disconnected"),this.connected_=!1,this.realtime_=null,this.cancelSentTransactions_(),this.requestCBHash_={},this.shouldReconnect_()){this.visible_?this.lastConnectionEstablishedTime_&&(new Date().getTime()-this.lastConnectionEstablishedTime_>pM&&(this.reconnectDelay_=Jo),this.lastConnectionEstablishedTime_=null):(this.log_("Window isn't visible.  Delaying reconnect."),this.reconnectDelay_=this.maxReconnectDelay_,this.lastConnectionAttemptTime_=new Date().getTime());const e=new Date().getTime()-this.lastConnectionAttemptTime_;let n=Math.max(0,this.reconnectDelay_-e);n=Math.random()*n,this.log_("Trying to reconnect in "+n+"ms"),this.scheduleConnect_(n),this.reconnectDelay_=Math.min(this.maxReconnectDelay_,this.reconnectDelay_*fM)}this.onConnectStatus_(!1)}async establishConnection_(){if(this.shouldReconnect_()){this.log_("Making a connection attempt"),this.lastConnectionAttemptTime_=new Date().getTime(),this.lastConnectionEstablishedTime_=null;const e=this.onDataMessage_.bind(this),n=this.onReady_.bind(this),r=this.onRealtimeDisconnect_.bind(this),i=this.id+":"+pr.nextConnectionId_++,s=this.lastSessionId;let o=!1,a=null;const u=function(){a?a.close():(o=!0,r())},c=function(f){H(a,"sendRequest call when we're not connected not allowed."),a.sendRequest(f)};this.realtime_={close:u,sendRequest:c};const d=this.forceTokenRefresh_;this.forceTokenRefresh_=!1;try{const[f,m]=await Promise.all([this.authTokenProvider_.getToken(d),this.appCheckTokenProvider_.getToken(d)]);o?Mt("getToken() completed but was canceled"):(Mt("getToken() completed. Creating connection."),this.authToken_=f&&f.accessToken,this.appCheckToken_=m&&m.token,a=new aM(i,this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,e,n,r,w=>{en(w+" ("+this.repoInfo_.toString()+")"),this.interrupt(mM)},s))}catch(f){this.log_("Failed to get token: "+f),o||(this.repoInfo_.nodeAdmin&&en(f),u())}}}interrupt(e){Mt("Interrupting connection for reason: "+e),this.interruptReasons_[e]=!0,this.realtime_?this.realtime_.close():(this.establishConnectionTimer_&&(clearTimeout(this.establishConnectionTimer_),this.establishConnectionTimer_=null),this.connected_&&this.onRealtimeDisconnect_())}resume(e){Mt("Resuming connection for reason: "+e),delete this.interruptReasons_[e],Kf(this.interruptReasons_)&&(this.reconnectDelay_=Jo,this.realtime_||this.scheduleConnect_(0))}handleTimestamp_(e){const n=e-new Date().getTime();this.onServerInfoUpdate_({serverTimeOffset:n})}cancelSentTransactions_(){for(let e=0;e<this.outstandingPuts_.length;e++){const n=this.outstandingPuts_[e];n&&"h"in n.request&&n.queued&&(n.onComplete&&n.onComplete("disconnect"),delete this.outstandingPuts_[e],this.outstandingPutCount_--)}this.outstandingPutCount_===0&&(this.outstandingPuts_=[])}onListenRevoked_(e,n){let r;n?r=n.map(s=>Ig(s)).join("$"):r="default";const i=this.removeListen_(e,r);i&&i.onComplete&&i.onComplete("permission_denied")}removeListen_(e,n){const r=new ze(e).toString();let i;if(this.listens.has(r)){const s=this.listens.get(r);i=s.get(n),s.delete(n),s.size===0&&this.listens.delete(r)}else i=void 0;return i}onAuthRevoked_(e,n){Mt("Auth token revoked: "+e+"/"+n),this.authToken_=null,this.forceTokenRefresh_=!0,this.realtime_.close(),(e==="invalid_token"||e==="permission_denied")&&(this.invalidAuthTokenCount_++,this.invalidAuthTokenCount_>=Dw&&(this.reconnectDelay_=Ow,this.authTokenProvider_.notifyForInvalidToken()))}onAppCheckRevoked_(e,n){Mt("App check token revoked: "+e+"/"+n),this.appCheckToken_=null,this.forceTokenRefresh_=!0,(e==="invalid_token"||e==="permission_denied")&&(this.invalidAppCheckTokenCount_++,this.invalidAppCheckTokenCount_>=Dw&&this.appCheckTokenProvider_.notifyForInvalidToken())}onSecurityDebugPacket_(e){this.securityDebugCallback_?this.securityDebugCallback_(e):"msg"in e&&console.log("FIREBASE: "+e.msg.replace(`
`,`
FIREBASE: `))}restoreState_(){this.tryAuth(),this.tryAppCheck();for(const e of this.listens.values())for(const n of e.values())this.sendListen_(n);for(let e=0;e<this.outstandingPuts_.length;e++)this.outstandingPuts_[e]&&this.sendPut_(e);for(;this.onDisconnectRequestQueue_.length;){const e=this.onDisconnectRequestQueue_.shift();this.sendOnDisconnect_(e.action,e.pathString,e.data,e.onComplete)}for(let e=0;e<this.outstandingGets_.length;e++)this.outstandingGets_[e]&&this.sendGet_(e)}sendConnectStats_(){const e={};let n="js";e["sdk."+n+"."+LS.replace(/\./g,"-")]=1,Om()?e["framework.cordova"]=1:WT()&&(e["framework.reactnative"]=1),this.reportStats(e)}shouldReconnect_(){const e=Pc.getInstance().currentlyOnline();return Kf(this.interruptReasons_)&&e}}pr.nextPersistentConnectionId_=0;pr.nextConnectionId_=0;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class me{constructor(e,n){this.name=e,this.node=n}static Wrap(e,n){return new me(e,n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class kh{getCompare(){return this.compare.bind(this)}indexedValueChanged(e,n){const r=new me(ao,e),i=new me(ao,n);return this.compare(r,i)!==0}minPost(){return me.MIN}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let wu;class hk extends kh{static get __EMPTY_NODE(){return wu}static set __EMPTY_NODE(e){wu=e}compare(e,n){return Eo(e.name,n.name)}isDefinedOn(e){throw fo("KeyIndex.isDefinedOn not expected to be called.")}indexedValueChanged(e,n){return!1}minPost(){return me.MIN}maxPost(){return new me(Ki,wu)}makePost(e,n){return H(typeof e=="string","KeyIndex indexValue must always be a string."),new me(e,wu)}toString(){return".key"}}const Bs=new hk;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Eu{constructor(e,n,r,i,s=null){this.isReverse_=i,this.resultGenerator_=s,this.nodeStack_=[];let o=1;for(;!e.isEmpty();)if(e=e,o=n?r(e.key,n):1,i&&(o*=-1),o<0)this.isReverse_?e=e.left:e=e.right;else if(o===0){this.nodeStack_.push(e);break}else this.nodeStack_.push(e),this.isReverse_?e=e.right:e=e.left}getNext(){if(this.nodeStack_.length===0)return null;let e=this.nodeStack_.pop(),n;if(this.resultGenerator_?n=this.resultGenerator_(e.key,e.value):n={key:e.key,value:e.value},this.isReverse_)for(e=e.left;!e.isEmpty();)this.nodeStack_.push(e),e=e.right;else for(e=e.right;!e.isEmpty();)this.nodeStack_.push(e),e=e.left;return n}hasNext(){return this.nodeStack_.length>0}peek(){if(this.nodeStack_.length===0)return null;const e=this.nodeStack_[this.nodeStack_.length-1];return this.resultGenerator_?this.resultGenerator_(e.key,e.value):{key:e.key,value:e.value}}}class mt{constructor(e,n,r,i,s){this.key=e,this.value=n,this.color=r??mt.RED,this.left=i??Yt.EMPTY_NODE,this.right=s??Yt.EMPTY_NODE}copy(e,n,r,i,s){return new mt(e??this.key,n??this.value,r??this.color,i??this.left,s??this.right)}count(){return this.left.count()+1+this.right.count()}isEmpty(){return!1}inorderTraversal(e){return this.left.inorderTraversal(e)||!!e(this.key,this.value)||this.right.inorderTraversal(e)}reverseTraversal(e){return this.right.reverseTraversal(e)||e(this.key,this.value)||this.left.reverseTraversal(e)}min_(){return this.left.isEmpty()?this:this.left.min_()}minKey(){return this.min_().key}maxKey(){return this.right.isEmpty()?this.key:this.right.maxKey()}insert(e,n,r){let i=this;const s=r(e,i.key);return s<0?i=i.copy(null,null,null,i.left.insert(e,n,r),null):s===0?i=i.copy(null,n,null,null,null):i=i.copy(null,null,null,null,i.right.insert(e,n,r)),i.fixUp_()}removeMin_(){if(this.left.isEmpty())return Yt.EMPTY_NODE;let e=this;return!e.left.isRed_()&&!e.left.left.isRed_()&&(e=e.moveRedLeft_()),e=e.copy(null,null,null,e.left.removeMin_(),null),e.fixUp_()}remove(e,n){let r,i;if(r=this,n(e,r.key)<0)!r.left.isEmpty()&&!r.left.isRed_()&&!r.left.left.isRed_()&&(r=r.moveRedLeft_()),r=r.copy(null,null,null,r.left.remove(e,n),null);else{if(r.left.isRed_()&&(r=r.rotateRight_()),!r.right.isEmpty()&&!r.right.isRed_()&&!r.right.left.isRed_()&&(r=r.moveRedRight_()),n(e,r.key)===0){if(r.right.isEmpty())return Yt.EMPTY_NODE;i=r.right.min_(),r=r.copy(i.key,i.value,null,null,r.right.removeMin_())}r=r.copy(null,null,null,null,r.right.remove(e,n))}return r.fixUp_()}isRed_(){return this.color}fixUp_(){let e=this;return e.right.isRed_()&&!e.left.isRed_()&&(e=e.rotateLeft_()),e.left.isRed_()&&e.left.left.isRed_()&&(e=e.rotateRight_()),e.left.isRed_()&&e.right.isRed_()&&(e=e.colorFlip_()),e}moveRedLeft_(){let e=this.colorFlip_();return e.right.left.isRed_()&&(e=e.copy(null,null,null,null,e.right.rotateRight_()),e=e.rotateLeft_(),e=e.colorFlip_()),e}moveRedRight_(){let e=this.colorFlip_();return e.left.left.isRed_()&&(e=e.rotateRight_(),e=e.colorFlip_()),e}rotateLeft_(){const e=this.copy(null,null,mt.RED,null,this.right.left);return this.right.copy(null,null,this.color,e,null)}rotateRight_(){const e=this.copy(null,null,mt.RED,this.left.right,null);return this.left.copy(null,null,this.color,null,e)}colorFlip_(){const e=this.left.copy(null,null,!this.left.color,null,null),n=this.right.copy(null,null,!this.right.color,null,null);return this.copy(null,null,!this.color,e,n)}checkMaxDepth_(){const e=this.check_();return Math.pow(2,e)<=this.count()+1}check_(){if(this.isRed_()&&this.left.isRed_())throw new Error("Red node has red child("+this.key+","+this.value+")");if(this.right.isRed_())throw new Error("Right child of ("+this.key+","+this.value+") is red");const e=this.left.check_();if(e!==this.right.check_())throw new Error("Black depths differ");return e+(this.isRed_()?0:1)}}mt.RED=!0;mt.BLACK=!1;class gM{copy(e,n,r,i,s){return this}insert(e,n,r){return new mt(e,n,null)}remove(e,n){return this}count(){return 0}isEmpty(){return!0}inorderTraversal(e){return!1}reverseTraversal(e){return!1}minKey(){return null}maxKey(){return null}check_(){return 0}isRed_(){return!1}}class Yt{constructor(e,n=Yt.EMPTY_NODE){this.comparator_=e,this.root_=n}insert(e,n){return new Yt(this.comparator_,this.root_.insert(e,n,this.comparator_).copy(null,null,mt.BLACK,null,null))}remove(e){return new Yt(this.comparator_,this.root_.remove(e,this.comparator_).copy(null,null,mt.BLACK,null,null))}get(e){let n,r=this.root_;for(;!r.isEmpty();){if(n=this.comparator_(e,r.key),n===0)return r.value;n<0?r=r.left:n>0&&(r=r.right)}return null}getPredecessorKey(e){let n,r=this.root_,i=null;for(;!r.isEmpty();)if(n=this.comparator_(e,r.key),n===0){if(r.left.isEmpty())return i?i.key:null;for(r=r.left;!r.right.isEmpty();)r=r.right;return r.key}else n<0?r=r.left:n>0&&(i=r,r=r.right);throw new Error("Attempted to find predecessor key for a nonexistent key.  What gives?")}isEmpty(){return this.root_.isEmpty()}count(){return this.root_.count()}minKey(){return this.root_.minKey()}maxKey(){return this.root_.maxKey()}inorderTraversal(e){return this.root_.inorderTraversal(e)}reverseTraversal(e){return this.root_.reverseTraversal(e)}getIterator(e){return new Eu(this.root_,null,this.comparator_,!1,e)}getIteratorFrom(e,n){return new Eu(this.root_,e,this.comparator_,!1,n)}getReverseIteratorFrom(e,n){return new Eu(this.root_,e,this.comparator_,!0,n)}getReverseIterator(e){return new Eu(this.root_,null,this.comparator_,!0,e)}}Yt.EMPTY_NODE=new gM;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function _M(t,e){return Eo(t.name,e.name)}function Ag(t,e){return Eo(t,e)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let vp;function yM(t){vp=t}const dk=function(t){return typeof t=="number"?"number:"+zS(t):"string:"+t},fk=function(t){if(t.isLeafNode()){const e=t.val();H(typeof e=="string"||typeof e=="number"||typeof e=="object"&&Ar(e,".sv"),"Priority must be a string or number.")}else H(t===vp||t.isEmpty(),"priority of unexpected type.");H(t===vp||t.getPriority().isEmpty(),"Priority nodes can't have a priority of their own.")};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Mw;class dt{constructor(e,n=dt.__childrenNodeConstructor.EMPTY_NODE){this.value_=e,this.priorityNode_=n,this.lazyHash_=null,H(this.value_!==void 0&&this.value_!==null,"LeafNode shouldn't be created with null/undefined value."),fk(this.priorityNode_)}static set __childrenNodeConstructor(e){Mw=e}static get __childrenNodeConstructor(){return Mw}isLeafNode(){return!0}getPriority(){return this.priorityNode_}updatePriority(e){return new dt(this.value_,e)}getImmediateChild(e){return e===".priority"?this.priorityNode_:dt.__childrenNodeConstructor.EMPTY_NODE}getChild(e){return fe(e)?this:he(e)===".priority"?this.priorityNode_:dt.__childrenNodeConstructor.EMPTY_NODE}hasChild(){return!1}getPredecessorChildName(e,n){return null}updateImmediateChild(e,n){return e===".priority"?this.updatePriority(n):n.isEmpty()&&e!==".priority"?this:dt.__childrenNodeConstructor.EMPTY_NODE.updateImmediateChild(e,n).updatePriority(this.priorityNode_)}updateChild(e,n){const r=he(e);return r===null?n:n.isEmpty()&&r!==".priority"?this:(H(r!==".priority"||fi(e)===1,".priority must be the last token in a path"),this.updateImmediateChild(r,dt.__childrenNodeConstructor.EMPTY_NODE.updateChild(Ve(e),n)))}isEmpty(){return!1}numChildren(){return 0}forEachChild(e,n){return!1}val(e){return e&&!this.getPriority().isEmpty()?{".value":this.getValue(),".priority":this.getPriority().val()}:this.getValue()}hash(){if(this.lazyHash_===null){let e="";this.priorityNode_.isEmpty()||(e+="priority:"+dk(this.priorityNode_.val())+":");const n=typeof this.value_;e+=n+":",n==="number"?e+=zS(this.value_):e+=this.value_,this.lazyHash_=FS(e)}return this.lazyHash_}getValue(){return this.value_}compareTo(e){return e===dt.__childrenNodeConstructor.EMPTY_NODE?1:e instanceof dt.__childrenNodeConstructor?-1:(H(e.isLeafNode(),"Unknown node type"),this.compareToLeafNode_(e))}compareToLeafNode_(e){const n=typeof e.value_,r=typeof this.value_,i=dt.VALUE_TYPE_ORDER.indexOf(n),s=dt.VALUE_TYPE_ORDER.indexOf(r);return H(i>=0,"Unknown leaf type: "+n),H(s>=0,"Unknown leaf type: "+r),i===s?r==="object"?0:this.value_<e.value_?-1:this.value_===e.value_?0:1:s-i}withIndex(){return this}isIndexed(){return!0}equals(e){if(e===this)return!0;if(e.isLeafNode()){const n=e;return this.value_===n.value_&&this.priorityNode_.equals(n.priorityNode_)}else return!1}}dt.VALUE_TYPE_ORDER=["object","boolean","number","string"];/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let pk,mk;function vM(t){pk=t}function wM(t){mk=t}class EM extends kh{compare(e,n){const r=e.node.getPriority(),i=n.node.getPriority(),s=r.compareTo(i);return s===0?Eo(e.name,n.name):s}isDefinedOn(e){return!e.getPriority().isEmpty()}indexedValueChanged(e,n){return!e.getPriority().equals(n.getPriority())}minPost(){return me.MIN}maxPost(){return new me(Ki,new dt("[PRIORITY-POST]",mk))}makePost(e,n){const r=pk(e);return new me(n,new dt("[PRIORITY-POST]",r))}toString(){return".priority"}}const Lt=new EM;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const TM=Math.log(2);class IM{constructor(e){const n=s=>parseInt(Math.log(s)/TM,10),r=s=>parseInt(Array(s+1).join("1"),2);this.count=n(e+1),this.current_=this.count-1;const i=r(this.count);this.bits_=e+1&i}nextBitIsOne(){const e=!(this.bits_&1<<this.current_);return this.current_--,e}}const bc=function(t,e,n,r){t.sort(e);const i=function(u,c){const d=c-u;let f,m;if(d===0)return null;if(d===1)return f=t[u],m=n?n(f):f,new mt(m,f.node,mt.BLACK,null,null);{const w=parseInt(d/2,10)+u,I=i(u,w),P=i(w+1,c);return f=t[w],m=n?n(f):f,new mt(m,f.node,mt.BLACK,I,P)}},s=function(u){let c=null,d=null,f=t.length;const m=function(I,P){const O=f-I,C=f;f-=I;const T=i(O+1,C),S=t[O],M=n?n(S):S;w(new mt(M,S.node,P,null,T))},w=function(I){c?(c.left=I,c=I):(d=I,c=I)};for(let I=0;I<u.count;++I){const P=u.nextBitIsOne(),O=Math.pow(2,u.count-(I+1));P?m(O,mt.BLACK):(m(O,mt.BLACK),m(O,mt.RED))}return d},o=new IM(t.length),a=s(o);return new Yt(r||e,a)};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Bd;const gs={};class lr{constructor(e,n){this.indexes_=e,this.indexSet_=n}static get Default(){return H(gs&&Lt,"ChildrenNode.ts has not been loaded"),Bd=Bd||new lr({".priority":gs},{".priority":Lt}),Bd}get(e){const n=Zs(this.indexes_,e);if(!n)throw new Error("No index defined for "+e);return n instanceof Yt?n:null}hasIndex(e){return Ar(this.indexSet_,e.toString())}addIndex(e,n){H(e!==Bs,"KeyIndex always exists and isn't meant to be added to the IndexMap.");const r=[];let i=!1;const s=n.getIterator(me.Wrap);let o=s.getNext();for(;o;)i=i||e.isDefinedOn(o.node),r.push(o),o=s.getNext();let a;i?a=bc(r,e.getCompare()):a=gs;const u=e.toString(),c=Object.assign({},this.indexSet_);c[u]=e;const d=Object.assign({},this.indexes_);return d[u]=a,new lr(d,c)}addToIndexes(e,n){const r=yc(this.indexes_,(i,s)=>{const o=Zs(this.indexSet_,s);if(H(o,"Missing index implementation for "+s),i===gs)if(o.isDefinedOn(e.node)){const a=[],u=n.getIterator(me.Wrap);let c=u.getNext();for(;c;)c.name!==e.name&&a.push(c),c=u.getNext();return a.push(e),bc(a,o.getCompare())}else return gs;else{const a=n.get(e.name);let u=i;return a&&(u=u.remove(new me(e.name,a))),u.insert(e,e.node)}});return new lr(r,this.indexSet_)}removeFromIndexes(e,n){const r=yc(this.indexes_,i=>{if(i===gs)return i;{const s=n.get(e.name);return s?i.remove(new me(e.name,s)):i}});return new lr(r,this.indexSet_)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Zo;class Te{constructor(e,n,r){this.children_=e,this.priorityNode_=n,this.indexMap_=r,this.lazyHash_=null,this.priorityNode_&&fk(this.priorityNode_),this.children_.isEmpty()&&H(!this.priorityNode_||this.priorityNode_.isEmpty(),"An empty node cannot have a priority")}static get EMPTY_NODE(){return Zo||(Zo=new Te(new Yt(Ag),null,lr.Default))}isLeafNode(){return!1}getPriority(){return this.priorityNode_||Zo}updatePriority(e){return this.children_.isEmpty()?this:new Te(this.children_,e,this.indexMap_)}getImmediateChild(e){if(e===".priority")return this.getPriority();{const n=this.children_.get(e);return n===null?Zo:n}}getChild(e){const n=he(e);return n===null?this:this.getImmediateChild(n).getChild(Ve(e))}hasChild(e){return this.children_.get(e)!==null}updateImmediateChild(e,n){if(H(n,"We should always be passing snapshot nodes"),e===".priority")return this.updatePriority(n);{const r=new me(e,n);let i,s;n.isEmpty()?(i=this.children_.remove(e),s=this.indexMap_.removeFromIndexes(r,this.children_)):(i=this.children_.insert(e,n),s=this.indexMap_.addToIndexes(r,this.children_));const o=i.isEmpty()?Zo:this.priorityNode_;return new Te(i,o,s)}}updateChild(e,n){const r=he(e);if(r===null)return n;{H(he(e)!==".priority"||fi(e)===1,".priority must be the last token in a path");const i=this.getImmediateChild(r).updateChild(Ve(e),n);return this.updateImmediateChild(r,i)}}isEmpty(){return this.children_.isEmpty()}numChildren(){return this.children_.count()}val(e){if(this.isEmpty())return null;const n={};let r=0,i=0,s=!0;if(this.forEachChild(Lt,(o,a)=>{n[o]=a.val(e),r++,s&&Te.INTEGER_REGEXP_.test(o)?i=Math.max(i,Number(o)):s=!1}),!e&&s&&i<2*r){const o=[];for(const a in n)o[a]=n[a];return o}else return e&&!this.getPriority().isEmpty()&&(n[".priority"]=this.getPriority().val()),n}hash(){if(this.lazyHash_===null){let e="";this.getPriority().isEmpty()||(e+="priority:"+dk(this.getPriority().val())+":"),this.forEachChild(Lt,(n,r)=>{const i=r.hash();i!==""&&(e+=":"+n+":"+i)}),this.lazyHash_=e===""?"":FS(e)}return this.lazyHash_}getPredecessorChildName(e,n,r){const i=this.resolveIndex_(r);if(i){const s=i.getPredecessorKey(new me(e,n));return s?s.name:null}else return this.children_.getPredecessorKey(e)}getFirstChildName(e){const n=this.resolveIndex_(e);if(n){const r=n.minKey();return r&&r.name}else return this.children_.minKey()}getFirstChild(e){const n=this.getFirstChildName(e);return n?new me(n,this.children_.get(n)):null}getLastChildName(e){const n=this.resolveIndex_(e);if(n){const r=n.maxKey();return r&&r.name}else return this.children_.maxKey()}getLastChild(e){const n=this.getLastChildName(e);return n?new me(n,this.children_.get(n)):null}forEachChild(e,n){const r=this.resolveIndex_(e);return r?r.inorderTraversal(i=>n(i.name,i.node)):this.children_.inorderTraversal(n)}getIterator(e){return this.getIteratorFrom(e.minPost(),e)}getIteratorFrom(e,n){const r=this.resolveIndex_(n);if(r)return r.getIteratorFrom(e,i=>i);{const i=this.children_.getIteratorFrom(e.name,me.Wrap);let s=i.peek();for(;s!=null&&n.compare(s,e)<0;)i.getNext(),s=i.peek();return i}}getReverseIterator(e){return this.getReverseIteratorFrom(e.maxPost(),e)}getReverseIteratorFrom(e,n){const r=this.resolveIndex_(n);if(r)return r.getReverseIteratorFrom(e,i=>i);{const i=this.children_.getReverseIteratorFrom(e.name,me.Wrap);let s=i.peek();for(;s!=null&&n.compare(s,e)>0;)i.getNext(),s=i.peek();return i}}compareTo(e){return this.isEmpty()?e.isEmpty()?0:-1:e.isLeafNode()||e.isEmpty()?1:e===kl?-1:0}withIndex(e){if(e===Bs||this.indexMap_.hasIndex(e))return this;{const n=this.indexMap_.addIndex(e,this.children_);return new Te(this.children_,this.priorityNode_,n)}}isIndexed(e){return e===Bs||this.indexMap_.hasIndex(e)}equals(e){if(e===this)return!0;if(e.isLeafNode())return!1;{const n=e;if(this.getPriority().equals(n.getPriority()))if(this.children_.count()===n.children_.count()){const r=this.getIterator(Lt),i=n.getIterator(Lt);let s=r.getNext(),o=i.getNext();for(;s&&o;){if(s.name!==o.name||!s.node.equals(o.node))return!1;s=r.getNext(),o=i.getNext()}return s===null&&o===null}else return!1;else return!1}}resolveIndex_(e){return e===Bs?null:this.indexMap_.get(e.toString())}}Te.INTEGER_REGEXP_=/^(0|[1-9]\d*)$/;class SM extends Te{constructor(){super(new Yt(Ag),Te.EMPTY_NODE,lr.Default)}compareTo(e){return e===this?0:1}equals(e){return e===this}getPriority(){return this}getImmediateChild(e){return Te.EMPTY_NODE}isEmpty(){return!1}}const kl=new SM;Object.defineProperties(me,{MIN:{value:new me(ao,Te.EMPTY_NODE)},MAX:{value:new me(Ki,kl)}});hk.__EMPTY_NODE=Te.EMPTY_NODE;dt.__childrenNodeConstructor=Te;yM(kl);wM(kl);/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const kM=!0;function wt(t,e=null){if(t===null)return Te.EMPTY_NODE;if(typeof t=="object"&&".priority"in t&&(e=t[".priority"]),H(e===null||typeof e=="string"||typeof e=="number"||typeof e=="object"&&".sv"in e,"Invalid priority type found: "+typeof e),typeof t=="object"&&".value"in t&&t[".value"]!==null&&(t=t[".value"]),typeof t!="object"||".sv"in t){const n=t;return new dt(n,wt(e))}if(!(t instanceof Array)&&kM){const n=[];let r=!1;if(Sn(t,(o,a)=>{if(o.substring(0,1)!=="."){const u=wt(a);u.isEmpty()||(r=r||!u.getPriority().isEmpty(),n.push(new me(o,u)))}}),n.length===0)return Te.EMPTY_NODE;const s=bc(n,_M,o=>o.name,Ag);if(r){const o=bc(n,Lt.getCompare());return new Te(s,wt(e),new lr({".priority":o},{".priority":Lt}))}else return new Te(s,wt(e),lr.Default)}else{let n=Te.EMPTY_NODE;return Sn(t,(r,i)=>{if(Ar(t,r)&&r.substring(0,1)!=="."){const s=wt(i);(s.isLeafNode()||!s.isEmpty())&&(n=n.updateImmediateChild(r,s))}}),n.updatePriority(wt(e))}}vM(wt);/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class CM extends kh{constructor(e){super(),this.indexPath_=e,H(!fe(e)&&he(e)!==".priority","Can't create PathIndex with empty path or .priority key")}extractChild(e){return e.getChild(this.indexPath_)}isDefinedOn(e){return!e.getChild(this.indexPath_).isEmpty()}compare(e,n){const r=this.extractChild(e.node),i=this.extractChild(n.node),s=r.compareTo(i);return s===0?Eo(e.name,n.name):s}makePost(e,n){const r=wt(e),i=Te.EMPTY_NODE.updateChild(this.indexPath_,r);return new me(n,i)}maxPost(){const e=Te.EMPTY_NODE.updateChild(this.indexPath_,kl);return new me(Ki,e)}toString(){return ak(this.indexPath_,0).join("/")}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class RM extends kh{compare(e,n){const r=e.node.compareTo(n.node);return r===0?Eo(e.name,n.name):r}isDefinedOn(e){return!0}indexedValueChanged(e,n){return!e.equals(n)}minPost(){return me.MIN}maxPost(){return me.MAX}makePost(e,n){const r=wt(e);return new me(n,r)}toString(){return".value"}}const AM=new RM;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function xM(t){return{type:"value",snapshotNode:t}}function PM(t,e){return{type:"child_added",snapshotNode:e,childName:t}}function bM(t,e){return{type:"child_removed",snapshotNode:e,childName:t}}function Lw(t,e,n){return{type:"child_changed",snapshotNode:e,childName:t,oldSnap:n}}function NM(t,e){return{type:"child_moved",snapshotNode:e,childName:t}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class xg{constructor(){this.limitSet_=!1,this.startSet_=!1,this.startNameSet_=!1,this.startAfterSet_=!1,this.endSet_=!1,this.endNameSet_=!1,this.endBeforeSet_=!1,this.limit_=0,this.viewFrom_="",this.indexStartValue_=null,this.indexStartName_="",this.indexEndValue_=null,this.indexEndName_="",this.index_=Lt}hasStart(){return this.startSet_}isViewFromLeft(){return this.viewFrom_===""?this.startSet_:this.viewFrom_==="l"}getIndexStartValue(){return H(this.startSet_,"Only valid if start has been set"),this.indexStartValue_}getIndexStartName(){return H(this.startSet_,"Only valid if start has been set"),this.startNameSet_?this.indexStartName_:ao}hasEnd(){return this.endSet_}getIndexEndValue(){return H(this.endSet_,"Only valid if end has been set"),this.indexEndValue_}getIndexEndName(){return H(this.endSet_,"Only valid if end has been set"),this.endNameSet_?this.indexEndName_:Ki}hasLimit(){return this.limitSet_}hasAnchoredLimit(){return this.limitSet_&&this.viewFrom_!==""}getLimit(){return H(this.limitSet_,"Only valid if limit has been set"),this.limit_}getIndex(){return this.index_}loadsAllData(){return!(this.startSet_||this.endSet_||this.limitSet_)}isDefault(){return this.loadsAllData()&&this.index_===Lt}copy(){const e=new xg;return e.limitSet_=this.limitSet_,e.limit_=this.limit_,e.startSet_=this.startSet_,e.startAfterSet_=this.startAfterSet_,e.indexStartValue_=this.indexStartValue_,e.startNameSet_=this.startNameSet_,e.indexStartName_=this.indexStartName_,e.endSet_=this.endSet_,e.endBeforeSet_=this.endBeforeSet_,e.indexEndValue_=this.indexEndValue_,e.endNameSet_=this.endNameSet_,e.indexEndName_=this.indexEndName_,e.index_=this.index_,e.viewFrom_=this.viewFrom_,e}}function Vw(t){const e={};if(t.isDefault())return e;let n;if(t.index_===Lt?n="$priority":t.index_===AM?n="$value":t.index_===Bs?n="$key":(H(t.index_ instanceof CM,"Unrecognized index type!"),n=t.index_.toString()),e.orderBy=Et(n),t.startSet_){const r=t.startAfterSet_?"startAfter":"startAt";e[r]=Et(t.indexStartValue_),t.startNameSet_&&(e[r]+=","+Et(t.indexStartName_))}if(t.endSet_){const r=t.endBeforeSet_?"endBefore":"endAt";e[r]=Et(t.indexEndValue_),t.endNameSet_&&(e[r]+=","+Et(t.indexEndName_))}return t.limitSet_&&(t.isViewFromLeft()?e.limitToFirst=t.limit_:e.limitToLast=t.limit_),e}function Fw(t){const e={};if(t.startSet_&&(e.sp=t.indexStartValue_,t.startNameSet_&&(e.sn=t.indexStartName_),e.sin=!t.startAfterSet_),t.endSet_&&(e.ep=t.indexEndValue_,t.endNameSet_&&(e.en=t.indexEndName_),e.ein=!t.endBeforeSet_),t.limitSet_){e.l=t.limit_;let n=t.viewFrom_;n===""&&(t.isViewFromLeft()?n="l":n="r"),e.vf=n}return t.index_!==Lt&&(e.i=t.index_.toString()),e}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Nc extends ik{constructor(e,n,r,i){super(),this.repoInfo_=e,this.onDataUpdate_=n,this.authTokenProvider_=r,this.appCheckTokenProvider_=i,this.log_=Sl("p:rest:"),this.listens_={}}reportStats(e){throw new Error("Method not implemented.")}static getListenId_(e,n){return n!==void 0?"tag$"+n:(H(e._queryParams.isDefault(),"should have a tag if it's not a default query."),e._path.toString())}listen(e,n,r,i){const s=e._path.toString();this.log_("Listen called for "+s+" "+e._queryIdentifier);const o=Nc.getListenId_(e,r),a={};this.listens_[o]=a;const u=Vw(e._queryParams);this.restRequest_(s+".json",u,(c,d)=>{let f=d;if(c===404&&(f=null,c=null),c===null&&this.onDataUpdate_(s,f,!1,r),Zs(this.listens_,o)===a){let m;c?c===401?m="permission_denied":m="rest_error:"+c:m="ok",i(m,null)}})}unlisten(e,n){const r=Nc.getListenId_(e,n);delete this.listens_[r]}get(e){const n=Vw(e._queryParams),r=e._path.toString(),i=new lh;return this.restRequest_(r+".json",n,(s,o)=>{let a=o;s===404&&(a=null,s=null),s===null?(this.onDataUpdate_(r,a,!1,null),i.resolve(a)):i.reject(new Error(a))}),i.promise}refreshAuthToken(e){}restRequest_(e,n={},r){return n.format="export",Promise.all([this.authTokenProvider_.getToken(!1),this.appCheckTokenProvider_.getToken(!1)]).then(([i,s])=>{i&&i.accessToken&&(n.auth=i.accessToken),s&&s.token&&(n.ac=s.token);const o=(this.repoInfo_.secure?"https://":"http://")+this.repoInfo_.host+e+"?ns="+this.repoInfo_.namespace+po(n);this.log_("Sending REST request for "+o);const a=new XMLHttpRequest;a.onreadystatechange=()=>{if(r&&a.readyState===4){this.log_("REST Response for "+o+" received. status:",a.status,"response:",a.responseText);let u=null;if(a.status>=200&&a.status<300){try{u=Qa(a.responseText)}catch{en("Failed to parse JSON response for "+o+": "+a.responseText)}r(null,u)}else a.status!==401&&a.status!==404&&en("Got unsuccessful REST response for "+o+" Status: "+a.status),r(a.status);r=null}},a.open("GET",o,!0),a.send()})}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class OM{constructor(){this.rootNode_=Te.EMPTY_NODE}getNode(e){return this.rootNode_.getChild(e)}updateSnapshot(e,n){this.rootNode_=this.rootNode_.updateChild(e,n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Oc(){return{value:null,children:new Map}}function gk(t,e,n){if(fe(e))t.value=n,t.children.clear();else if(t.value!==null)t.value=t.value.updateChild(e,n);else{const r=he(e);t.children.has(r)||t.children.set(r,Oc());const i=t.children.get(r);e=Ve(e),gk(i,e,n)}}function wp(t,e,n){t.value!==null?n(e,t.value):DM(t,(r,i)=>{const s=new ze(e.toString()+"/"+r);wp(i,s,n)})}function DM(t,e){t.children.forEach((n,r)=>{e(r,n)})}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class MM{constructor(e){this.collection_=e,this.last_=null}get(){const e=this.collection_.get(),n=Object.assign({},e);return this.last_&&Sn(this.last_,(r,i)=>{n[r]=n[r]-i}),this.last_=e,n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Uw=10*1e3,LM=30*1e3,VM=5*60*1e3;class FM{constructor(e,n){this.server_=n,this.statsToReport_={},this.statsListener_=new MM(e);const r=Uw+(LM-Uw)*Math.random();ka(this.reportStats_.bind(this),Math.floor(r))}reportStats_(){const e=this.statsListener_.get(),n={};let r=!1;Sn(e,(i,s)=>{s>0&&Ar(this.statsToReport_,i)&&(n[i]=s,r=!0)}),r&&this.server_.reportStats(n),ka(this.reportStats_.bind(this),Math.floor(Math.random()*2*VM))}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */var Wn;(function(t){t[t.OVERWRITE=0]="OVERWRITE",t[t.MERGE=1]="MERGE",t[t.ACK_USER_WRITE=2]="ACK_USER_WRITE",t[t.LISTEN_COMPLETE=3]="LISTEN_COMPLETE"})(Wn||(Wn={}));function _k(){return{fromUser:!0,fromServer:!1,queryId:null,tagged:!1}}function yk(){return{fromUser:!1,fromServer:!0,queryId:null,tagged:!1}}function vk(t){return{fromUser:!1,fromServer:!0,queryId:t,tagged:!0}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Dc{constructor(e,n,r){this.path=e,this.affectedTree=n,this.revert=r,this.type=Wn.ACK_USER_WRITE,this.source=_k()}operationForChild(e){if(fe(this.path)){if(this.affectedTree.value!=null)return H(this.affectedTree.children.isEmpty(),"affectedTree should not have overlapping affected paths."),this;{const n=this.affectedTree.subtree(new ze(e));return new Dc(Re(),n,this.revert)}}else return H(he(this.path)===e,"operationForChild called for unrelated child."),new Dc(Ve(this.path),this.affectedTree,this.revert)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Qi{constructor(e,n,r){this.source=e,this.path=n,this.snap=r,this.type=Wn.OVERWRITE}operationForChild(e){return fe(this.path)?new Qi(this.source,Re(),this.snap.getImmediateChild(e)):new Qi(this.source,Ve(this.path),this.snap)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class al{constructor(e,n,r){this.source=e,this.path=n,this.children=r,this.type=Wn.MERGE}operationForChild(e){if(fe(this.path)){const n=this.children.subtree(new ze(e));return n.isEmpty()?null:n.value?new Qi(this.source,Re(),n.value):new al(this.source,Re(),n)}else return H(he(this.path)===e,"Can't get a merge for a child not on the path of the operation"),new al(this.source,Ve(this.path),this.children)}toString(){return"Operation("+this.path+": "+this.source.toString()+" merge: "+this.children.toString()+")"}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Pg{constructor(e,n,r){this.node_=e,this.fullyInitialized_=n,this.filtered_=r}isFullyInitialized(){return this.fullyInitialized_}isFiltered(){return this.filtered_}isCompleteForPath(e){if(fe(e))return this.isFullyInitialized()&&!this.filtered_;const n=he(e);return this.isCompleteForChild(n)}isCompleteForChild(e){return this.isFullyInitialized()&&!this.filtered_||this.node_.hasChild(e)}getNode(){return this.node_}}function UM(t,e,n,r){const i=[],s=[];return e.forEach(o=>{o.type==="child_changed"&&t.index_.indexedValueChanged(o.oldSnap,o.snapshotNode)&&s.push(NM(o.childName,o.snapshotNode))}),ea(t,i,"child_removed",e,r,n),ea(t,i,"child_added",e,r,n),ea(t,i,"child_moved",s,r,n),ea(t,i,"child_changed",e,r,n),ea(t,i,"value",e,r,n),i}function ea(t,e,n,r,i,s){const o=r.filter(a=>a.type===n);o.sort((a,u)=>zM(t,a,u)),o.forEach(a=>{const u=jM(t,a,s);i.forEach(c=>{c.respondsTo(a.type)&&e.push(c.createEvent(u,t.query_))})})}function jM(t,e,n){return e.type==="value"||e.type==="child_removed"||(e.prevName=n.getPredecessorChildName(e.childName,e.snapshotNode,t.index_)),e}function zM(t,e,n){if(e.childName==null||n.childName==null)throw fo("Should only compare child_ events.");const r=new me(e.childName,e.snapshotNode),i=new me(n.childName,n.snapshotNode);return t.index_.compare(r,i)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function wk(t,e){return{eventCache:t,serverCache:e}}function Ca(t,e,n,r){return wk(new Pg(e,n,r),t.serverCache)}function Ek(t,e,n,r){return wk(t.eventCache,new Pg(e,n,r))}function Ep(t){return t.eventCache.isFullyInitialized()?t.eventCache.getNode():null}function Yi(t){return t.serverCache.isFullyInitialized()?t.serverCache.getNode():null}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let $d;const BM=()=>($d||($d=new Yt(AD)),$d);class Le{constructor(e,n=BM()){this.value=e,this.children=n}static fromObject(e){let n=new Le(null);return Sn(e,(r,i)=>{n=n.set(new ze(r),i)}),n}isEmpty(){return this.value===null&&this.children.isEmpty()}findRootMostMatchingPathAndValue(e,n){if(this.value!=null&&n(this.value))return{path:Re(),value:this.value};if(fe(e))return null;{const r=he(e),i=this.children.get(r);if(i!==null){const s=i.findRootMostMatchingPathAndValue(Ve(e),n);return s!=null?{path:at(new ze(r),s.path),value:s.value}:null}else return null}}findRootMostValueAndPath(e){return this.findRootMostMatchingPathAndValue(e,()=>!0)}subtree(e){if(fe(e))return this;{const n=he(e),r=this.children.get(n);return r!==null?r.subtree(Ve(e)):new Le(null)}}set(e,n){if(fe(e))return new Le(n,this.children);{const r=he(e),s=(this.children.get(r)||new Le(null)).set(Ve(e),n),o=this.children.insert(r,s);return new Le(this.value,o)}}remove(e){if(fe(e))return this.children.isEmpty()?new Le(null):new Le(null,this.children);{const n=he(e),r=this.children.get(n);if(r){const i=r.remove(Ve(e));let s;return i.isEmpty()?s=this.children.remove(n):s=this.children.insert(n,i),this.value===null&&s.isEmpty()?new Le(null):new Le(this.value,s)}else return this}}get(e){if(fe(e))return this.value;{const n=he(e),r=this.children.get(n);return r?r.get(Ve(e)):null}}setTree(e,n){if(fe(e))return n;{const r=he(e),s=(this.children.get(r)||new Le(null)).setTree(Ve(e),n);let o;return s.isEmpty()?o=this.children.remove(r):o=this.children.insert(r,s),new Le(this.value,o)}}fold(e){return this.fold_(Re(),e)}fold_(e,n){const r={};return this.children.inorderTraversal((i,s)=>{r[i]=s.fold_(at(e,i),n)}),n(e,this.value,r)}findOnPath(e,n){return this.findOnPath_(e,Re(),n)}findOnPath_(e,n,r){const i=this.value?r(n,this.value):!1;if(i)return i;if(fe(e))return null;{const s=he(e),o=this.children.get(s);return o?o.findOnPath_(Ve(e),at(n,s),r):null}}foreachOnPath(e,n){return this.foreachOnPath_(e,Re(),n)}foreachOnPath_(e,n,r){if(fe(e))return this;{this.value&&r(n,this.value);const i=he(e),s=this.children.get(i);return s?s.foreachOnPath_(Ve(e),at(n,i),r):new Le(null)}}foreach(e){this.foreach_(Re(),e)}foreach_(e,n){this.children.inorderTraversal((r,i)=>{i.foreach_(at(e,r),n)}),this.value&&n(e,this.value)}foreachChild(e){this.children.inorderTraversal((n,r)=>{r.value&&e(n,r.value)})}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ln{constructor(e){this.writeTree_=e}static empty(){return new Ln(new Le(null))}}function Ra(t,e,n){if(fe(e))return new Ln(new Le(n));{const r=t.writeTree_.findRootMostValueAndPath(e);if(r!=null){const i=r.path;let s=r.value;const o=gn(i,e);return s=s.updateChild(o,n),new Ln(t.writeTree_.set(i,s))}else{const i=new Le(n),s=t.writeTree_.setTree(e,i);return new Ln(s)}}}function jw(t,e,n){let r=t;return Sn(n,(i,s)=>{r=Ra(r,at(e,i),s)}),r}function zw(t,e){if(fe(e))return Ln.empty();{const n=t.writeTree_.setTree(e,new Le(null));return new Ln(n)}}function Tp(t,e){return ss(t,e)!=null}function ss(t,e){const n=t.writeTree_.findRootMostValueAndPath(e);return n!=null?t.writeTree_.get(n.path).getChild(gn(n.path,e)):null}function Bw(t){const e=[],n=t.writeTree_.value;return n!=null?n.isLeafNode()||n.forEachChild(Lt,(r,i)=>{e.push(new me(r,i))}):t.writeTree_.children.inorderTraversal((r,i)=>{i.value!=null&&e.push(new me(r,i.value))}),e}function si(t,e){if(fe(e))return t;{const n=ss(t,e);return n!=null?new Ln(new Le(n)):new Ln(t.writeTree_.subtree(e))}}function Ip(t){return t.writeTree_.isEmpty()}function lo(t,e){return Tk(Re(),t.writeTree_,e)}function Tk(t,e,n){if(e.value!=null)return n.updateChild(t,e.value);{let r=null;return e.children.inorderTraversal((i,s)=>{i===".priority"?(H(s.value!==null,"Priority writes must always be leaf nodes"),r=s.value):n=Tk(at(t,i),s,n)}),!n.getChild(t).isEmpty()&&r!==null&&(n=n.updateChild(at(t,".priority"),r)),n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Ik(t,e){return Ak(e,t)}function $M(t,e,n,r,i){H(r>t.lastWriteId,"Stacking an older write on top of newer ones"),i===void 0&&(i=!0),t.allWrites.push({path:e,snap:n,writeId:r,visible:i}),i&&(t.visibleWrites=Ra(t.visibleWrites,e,n)),t.lastWriteId=r}function WM(t,e){for(let n=0;n<t.allWrites.length;n++){const r=t.allWrites[n];if(r.writeId===e)return r}return null}function qM(t,e){const n=t.allWrites.findIndex(a=>a.writeId===e);H(n>=0,"removeWrite called with nonexistent writeId.");const r=t.allWrites[n];t.allWrites.splice(n,1);let i=r.visible,s=!1,o=t.allWrites.length-1;for(;i&&o>=0;){const a=t.allWrites[o];a.visible&&(o>=n&&HM(a,r.path)?i=!1:On(r.path,a.path)&&(s=!0)),o--}if(i){if(s)return GM(t),!0;if(r.snap)t.visibleWrites=zw(t.visibleWrites,r.path);else{const a=r.children;Sn(a,u=>{t.visibleWrites=zw(t.visibleWrites,at(r.path,u))})}return!0}else return!1}function HM(t,e){if(t.snap)return On(t.path,e);for(const n in t.children)if(t.children.hasOwnProperty(n)&&On(at(t.path,n),e))return!0;return!1}function GM(t){t.visibleWrites=Sk(t.allWrites,KM,Re()),t.allWrites.length>0?t.lastWriteId=t.allWrites[t.allWrites.length-1].writeId:t.lastWriteId=-1}function KM(t){return t.visible}function Sk(t,e,n){let r=Ln.empty();for(let i=0;i<t.length;++i){const s=t[i];if(e(s)){const o=s.path;let a;if(s.snap)On(n,o)?(a=gn(n,o),r=Ra(r,a,s.snap)):On(o,n)&&(a=gn(o,n),r=Ra(r,Re(),s.snap.getChild(a)));else if(s.children){if(On(n,o))a=gn(n,o),r=jw(r,a,s.children);else if(On(o,n))if(a=gn(o,n),fe(a))r=jw(r,Re(),s.children);else{const u=Zs(s.children,he(a));if(u){const c=u.getChild(Ve(a));r=Ra(r,Re(),c)}}}else throw fo("WriteRecord should have .snap or .children")}}return r}function kk(t,e,n,r,i){if(!r&&!i){const s=ss(t.visibleWrites,e);if(s!=null)return s;{const o=si(t.visibleWrites,e);if(Ip(o))return n;if(n==null&&!Tp(o,Re()))return null;{const a=n||Te.EMPTY_NODE;return lo(o,a)}}}else{const s=si(t.visibleWrites,e);if(!i&&Ip(s))return n;if(!i&&n==null&&!Tp(s,Re()))return null;{const o=function(c){return(c.visible||i)&&(!r||!~r.indexOf(c.writeId))&&(On(c.path,e)||On(e,c.path))},a=Sk(t.allWrites,o,e),u=n||Te.EMPTY_NODE;return lo(a,u)}}}function QM(t,e,n){let r=Te.EMPTY_NODE;const i=ss(t.visibleWrites,e);if(i)return i.isLeafNode()||i.forEachChild(Lt,(s,o)=>{r=r.updateImmediateChild(s,o)}),r;if(n){const s=si(t.visibleWrites,e);return n.forEachChild(Lt,(o,a)=>{const u=lo(si(s,new ze(o)),a);r=r.updateImmediateChild(o,u)}),Bw(s).forEach(o=>{r=r.updateImmediateChild(o.name,o.node)}),r}else{const s=si(t.visibleWrites,e);return Bw(s).forEach(o=>{r=r.updateImmediateChild(o.name,o.node)}),r}}function YM(t,e,n,r,i){H(r||i,"Either existingEventSnap or existingServerSnap must exist");const s=at(e,n);if(Tp(t.visibleWrites,s))return null;{const o=si(t.visibleWrites,s);return Ip(o)?i.getChild(n):lo(o,i.getChild(n))}}function XM(t,e,n,r){const i=at(e,n),s=ss(t.visibleWrites,i);if(s!=null)return s;if(r.isCompleteForChild(n)){const o=si(t.visibleWrites,i);return lo(o,r.getNode().getImmediateChild(n))}else return null}function JM(t,e){return ss(t.visibleWrites,e)}function ZM(t,e,n,r,i,s,o){let a;const u=si(t.visibleWrites,e),c=ss(u,Re());if(c!=null)a=c;else if(n!=null)a=lo(u,n);else return[];if(a=a.withIndex(o),!a.isEmpty()&&!a.isLeafNode()){const d=[],f=o.getCompare(),m=s?a.getReverseIteratorFrom(r,o):a.getIteratorFrom(r,o);let w=m.getNext();for(;w&&d.length<i;)f(w,r)!==0&&d.push(w),w=m.getNext();return d}else return[]}function eL(){return{visibleWrites:Ln.empty(),allWrites:[],lastWriteId:-1}}function Sp(t,e,n,r){return kk(t.writeTree,t.treePath,e,n,r)}function Ck(t,e){return QM(t.writeTree,t.treePath,e)}function $w(t,e,n,r){return YM(t.writeTree,t.treePath,e,n,r)}function Mc(t,e){return JM(t.writeTree,at(t.treePath,e))}function tL(t,e,n,r,i,s){return ZM(t.writeTree,t.treePath,e,n,r,i,s)}function bg(t,e,n){return XM(t.writeTree,t.treePath,e,n)}function Rk(t,e){return Ak(at(t.treePath,e),t.writeTree)}function Ak(t,e){return{treePath:t,writeTree:e}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class nL{constructor(){this.changeMap=new Map}trackChildChange(e){const n=e.type,r=e.childName;H(n==="child_added"||n==="child_changed"||n==="child_removed","Only child changes supported for tracking"),H(r!==".priority","Only non-priority child changes can be tracked.");const i=this.changeMap.get(r);if(i){const s=i.type;if(n==="child_added"&&s==="child_removed")this.changeMap.set(r,Lw(r,e.snapshotNode,i.snapshotNode));else if(n==="child_removed"&&s==="child_added")this.changeMap.delete(r);else if(n==="child_removed"&&s==="child_changed")this.changeMap.set(r,bM(r,i.oldSnap));else if(n==="child_changed"&&s==="child_added")this.changeMap.set(r,PM(r,e.snapshotNode));else if(n==="child_changed"&&s==="child_changed")this.changeMap.set(r,Lw(r,e.snapshotNode,i.oldSnap));else throw fo("Illegal combination of changes: "+e+" occurred after "+i)}else this.changeMap.set(r,e)}getChanges(){return Array.from(this.changeMap.values())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class rL{getCompleteChild(e){return null}getChildAfterChild(e,n,r){return null}}const xk=new rL;class Ng{constructor(e,n,r=null){this.writes_=e,this.viewCache_=n,this.optCompleteServerCache_=r}getCompleteChild(e){const n=this.viewCache_.eventCache;if(n.isCompleteForChild(e))return n.getNode().getImmediateChild(e);{const r=this.optCompleteServerCache_!=null?new Pg(this.optCompleteServerCache_,!0,!1):this.viewCache_.serverCache;return bg(this.writes_,e,r)}}getChildAfterChild(e,n,r){const i=this.optCompleteServerCache_!=null?this.optCompleteServerCache_:Yi(this.viewCache_),s=tL(this.writes_,i,n,1,r,e);return s.length===0?null:s[0]}}function iL(t,e){H(e.eventCache.getNode().isIndexed(t.filter.getIndex()),"Event snap not indexed"),H(e.serverCache.getNode().isIndexed(t.filter.getIndex()),"Server snap not indexed")}function sL(t,e,n,r,i){const s=new nL;let o,a;if(n.type===Wn.OVERWRITE){const c=n;c.source.fromUser?o=kp(t,e,c.path,c.snap,r,i,s):(H(c.source.fromServer,"Unknown source."),a=c.source.tagged||e.serverCache.isFiltered()&&!fe(c.path),o=Lc(t,e,c.path,c.snap,r,i,a,s))}else if(n.type===Wn.MERGE){const c=n;c.source.fromUser?o=aL(t,e,c.path,c.children,r,i,s):(H(c.source.fromServer,"Unknown source."),a=c.source.tagged||e.serverCache.isFiltered(),o=Cp(t,e,c.path,c.children,r,i,a,s))}else if(n.type===Wn.ACK_USER_WRITE){const c=n;c.revert?o=cL(t,e,c.path,r,i,s):o=lL(t,e,c.path,c.affectedTree,r,i,s)}else if(n.type===Wn.LISTEN_COMPLETE)o=uL(t,e,n.path,r,s);else throw fo("Unknown operation type: "+n.type);const u=s.getChanges();return oL(e,o,u),{viewCache:o,changes:u}}function oL(t,e,n){const r=e.eventCache;if(r.isFullyInitialized()){const i=r.getNode().isLeafNode()||r.getNode().isEmpty(),s=Ep(t);(n.length>0||!t.eventCache.isFullyInitialized()||i&&!r.getNode().equals(s)||!r.getNode().getPriority().equals(s.getPriority()))&&n.push(xM(Ep(e)))}}function Pk(t,e,n,r,i,s){const o=e.eventCache;if(Mc(r,n)!=null)return e;{let a,u;if(fe(n))if(H(e.serverCache.isFullyInitialized(),"If change path is empty, we must have complete server data"),e.serverCache.isFiltered()){const c=Yi(e),d=c instanceof Te?c:Te.EMPTY_NODE,f=Ck(r,d);a=t.filter.updateFullNode(e.eventCache.getNode(),f,s)}else{const c=Sp(r,Yi(e));a=t.filter.updateFullNode(e.eventCache.getNode(),c,s)}else{const c=he(n);if(c===".priority"){H(fi(n)===1,"Can't have a priority with additional path components");const d=o.getNode();u=e.serverCache.getNode();const f=$w(r,n,d,u);f!=null?a=t.filter.updatePriority(d,f):a=o.getNode()}else{const d=Ve(n);let f;if(o.isCompleteForChild(c)){u=e.serverCache.getNode();const m=$w(r,n,o.getNode(),u);m!=null?f=o.getNode().getImmediateChild(c).updateChild(d,m):f=o.getNode().getImmediateChild(c)}else f=bg(r,c,e.serverCache);f!=null?a=t.filter.updateChild(o.getNode(),c,f,d,i,s):a=o.getNode()}}return Ca(e,a,o.isFullyInitialized()||fe(n),t.filter.filtersNodes())}}function Lc(t,e,n,r,i,s,o,a){const u=e.serverCache;let c;const d=o?t.filter:t.filter.getIndexedFilter();if(fe(n))c=d.updateFullNode(u.getNode(),r,null);else if(d.filtersNodes()&&!u.isFiltered()){const w=u.getNode().updateChild(n,r);c=d.updateFullNode(u.getNode(),w,null)}else{const w=he(n);if(!u.isCompleteForPath(n)&&fi(n)>1)return e;const I=Ve(n),O=u.getNode().getImmediateChild(w).updateChild(I,r);w===".priority"?c=d.updatePriority(u.getNode(),O):c=d.updateChild(u.getNode(),w,O,I,xk,null)}const f=Ek(e,c,u.isFullyInitialized()||fe(n),d.filtersNodes()),m=new Ng(i,f,s);return Pk(t,f,n,i,m,a)}function kp(t,e,n,r,i,s,o){const a=e.eventCache;let u,c;const d=new Ng(i,e,s);if(fe(n))c=t.filter.updateFullNode(e.eventCache.getNode(),r,o),u=Ca(e,c,!0,t.filter.filtersNodes());else{const f=he(n);if(f===".priority")c=t.filter.updatePriority(e.eventCache.getNode(),r),u=Ca(e,c,a.isFullyInitialized(),a.isFiltered());else{const m=Ve(n),w=a.getNode().getImmediateChild(f);let I;if(fe(m))I=r;else{const P=d.getCompleteChild(f);P!=null?ok(m)===".priority"&&P.getChild(lk(m)).isEmpty()?I=P:I=P.updateChild(m,r):I=Te.EMPTY_NODE}if(w.equals(I))u=e;else{const P=t.filter.updateChild(a.getNode(),f,I,m,d,o);u=Ca(e,P,a.isFullyInitialized(),t.filter.filtersNodes())}}}return u}function Ww(t,e){return t.eventCache.isCompleteForChild(e)}function aL(t,e,n,r,i,s,o){let a=e;return r.foreach((u,c)=>{const d=at(n,u);Ww(e,he(d))&&(a=kp(t,a,d,c,i,s,o))}),r.foreach((u,c)=>{const d=at(n,u);Ww(e,he(d))||(a=kp(t,a,d,c,i,s,o))}),a}function qw(t,e,n){return n.foreach((r,i)=>{e=e.updateChild(r,i)}),e}function Cp(t,e,n,r,i,s,o,a){if(e.serverCache.getNode().isEmpty()&&!e.serverCache.isFullyInitialized())return e;let u=e,c;fe(n)?c=r:c=new Le(null).setTree(n,r);const d=e.serverCache.getNode();return c.children.inorderTraversal((f,m)=>{if(d.hasChild(f)){const w=e.serverCache.getNode().getImmediateChild(f),I=qw(t,w,m);u=Lc(t,u,new ze(f),I,i,s,o,a)}}),c.children.inorderTraversal((f,m)=>{const w=!e.serverCache.isCompleteForChild(f)&&m.value===null;if(!d.hasChild(f)&&!w){const I=e.serverCache.getNode().getImmediateChild(f),P=qw(t,I,m);u=Lc(t,u,new ze(f),P,i,s,o,a)}}),u}function lL(t,e,n,r,i,s,o){if(Mc(i,n)!=null)return e;const a=e.serverCache.isFiltered(),u=e.serverCache;if(r.value!=null){if(fe(n)&&u.isFullyInitialized()||u.isCompleteForPath(n))return Lc(t,e,n,u.getNode().getChild(n),i,s,a,o);if(fe(n)){let c=new Le(null);return u.getNode().forEachChild(Bs,(d,f)=>{c=c.set(new ze(d),f)}),Cp(t,e,n,c,i,s,a,o)}else return e}else{let c=new Le(null);return r.foreach((d,f)=>{const m=at(n,d);u.isCompleteForPath(m)&&(c=c.set(d,u.getNode().getChild(m)))}),Cp(t,e,n,c,i,s,a,o)}}function uL(t,e,n,r,i){const s=e.serverCache,o=Ek(e,s.getNode(),s.isFullyInitialized()||fe(n),s.isFiltered());return Pk(t,o,n,r,xk,i)}function cL(t,e,n,r,i,s){let o;if(Mc(r,n)!=null)return e;{const a=new Ng(r,e,i),u=e.eventCache.getNode();let c;if(fe(n)||he(n)===".priority"){let d;if(e.serverCache.isFullyInitialized())d=Sp(r,Yi(e));else{const f=e.serverCache.getNode();H(f instanceof Te,"serverChildren would be complete if leaf node"),d=Ck(r,f)}d=d,c=t.filter.updateFullNode(u,d,s)}else{const d=he(n);let f=bg(r,d,e.serverCache);f==null&&e.serverCache.isCompleteForChild(d)&&(f=u.getImmediateChild(d)),f!=null?c=t.filter.updateChild(u,d,f,Ve(n),a,s):e.eventCache.getNode().hasChild(d)?c=t.filter.updateChild(u,d,Te.EMPTY_NODE,Ve(n),a,s):c=u,c.isEmpty()&&e.serverCache.isFullyInitialized()&&(o=Sp(r,Yi(e)),o.isLeafNode()&&(c=t.filter.updateFullNode(c,o,s)))}return o=e.serverCache.isFullyInitialized()||Mc(r,Re())!=null,Ca(e,c,o,t.filter.filtersNodes())}}function hL(t,e){const n=Yi(t.viewCache_);return n&&(t.query._queryParams.loadsAllData()||!fe(e)&&!n.getImmediateChild(he(e)).isEmpty())?n.getChild(e):null}function Hw(t,e,n,r){e.type===Wn.MERGE&&e.source.queryId!==null&&(H(Yi(t.viewCache_),"We should always have a full cache before handling merges"),H(Ep(t.viewCache_),"Missing event cache, even though we have a server cache"));const i=t.viewCache_,s=sL(t.processor_,i,e,n,r);return iL(t.processor_,s.viewCache),H(s.viewCache.serverCache.isFullyInitialized()||!i.serverCache.isFullyInitialized(),"Once a server snap is complete, it should never go back"),t.viewCache_=s.viewCache,dL(t,s.changes,s.viewCache.eventCache.getNode())}function dL(t,e,n,r){const i=t.eventRegistrations_;return UM(t.eventGenerator_,e,n,i)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Gw;function fL(t){H(!Gw,"__referenceConstructor has already been defined"),Gw=t}function Og(t,e,n,r){const i=e.source.queryId;if(i!==null){const s=t.views.get(i);return H(s!=null,"SyncTree gave us an op for an invalid query."),Hw(s,e,n,r)}else{let s=[];for(const o of t.views.values())s=s.concat(Hw(o,e,n,r));return s}}function Dg(t,e){let n=null;for(const r of t.views.values())n=n||hL(r,e);return n}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Kw;function pL(t){H(!Kw,"__referenceConstructor has already been defined"),Kw=t}class Qw{constructor(e){this.listenProvider_=e,this.syncPointTree_=new Le(null),this.pendingWriteTree_=eL(),this.tagToQueryMap=new Map,this.queryToTagMap=new Map}}function bk(t,e,n,r,i){return $M(t.pendingWriteTree_,e,n,r,i),i?Rh(t,new Qi(_k(),e,n)):[]}function Di(t,e,n=!1){const r=WM(t.pendingWriteTree_,e);if(qM(t.pendingWriteTree_,e)){let s=new Le(null);return r.snap!=null?s=s.set(Re(),!0):Sn(r.children,o=>{s=s.set(new ze(o),!0)}),Rh(t,new Dc(r.path,s,n))}else return[]}function Ch(t,e,n){return Rh(t,new Qi(yk(),e,n))}function mL(t,e,n){const r=Le.fromObject(n);return Rh(t,new al(yk(),e,r))}function gL(t,e,n,r){const i=Dk(t,r);if(i!=null){const s=Mk(i),o=s.path,a=s.queryId,u=gn(o,e),c=new Qi(vk(a),u,n);return Lk(t,o,c)}else return[]}function _L(t,e,n,r){const i=Dk(t,r);if(i){const s=Mk(i),o=s.path,a=s.queryId,u=gn(o,e),c=Le.fromObject(n),d=new al(vk(a),u,c);return Lk(t,o,d)}else return[]}function Mg(t,e,n){const i=t.pendingWriteTree_,s=t.syncPointTree_.findOnPath(e,(o,a)=>{const u=gn(o,e),c=Dg(a,u);if(c)return c});return kk(i,e,s,n,!0)}function Rh(t,e){return Nk(e,t.syncPointTree_,null,Ik(t.pendingWriteTree_,Re()))}function Nk(t,e,n,r){if(fe(t.path))return Ok(t,e,n,r);{const i=e.get(Re());n==null&&i!=null&&(n=Dg(i,Re()));let s=[];const o=he(t.path),a=t.operationForChild(o),u=e.children.get(o);if(u&&a){const c=n?n.getImmediateChild(o):null,d=Rk(r,o);s=s.concat(Nk(a,u,c,d))}return i&&(s=s.concat(Og(i,t,r,n))),s}}function Ok(t,e,n,r){const i=e.get(Re());n==null&&i!=null&&(n=Dg(i,Re()));let s=[];return e.children.inorderTraversal((o,a)=>{const u=n?n.getImmediateChild(o):null,c=Rk(r,o),d=t.operationForChild(o);d&&(s=s.concat(Ok(d,a,u,c)))}),i&&(s=s.concat(Og(i,t,r,n))),s}function Dk(t,e){return t.tagToQueryMap.get(e)}function Mk(t){const e=t.indexOf("$");return H(e!==-1&&e<t.length-1,"Bad queryKey."),{queryId:t.substr(e+1),path:new ze(t.substr(0,e))}}function Lk(t,e,n){const r=t.syncPointTree_.get(e);H(r,"Missing sync point for query tag that we're tracking");const i=Ik(t.pendingWriteTree_,e);return Og(r,n,i,null)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Lg{constructor(e){this.node_=e}getImmediateChild(e){const n=this.node_.getImmediateChild(e);return new Lg(n)}node(){return this.node_}}class Vg{constructor(e,n){this.syncTree_=e,this.path_=n}getImmediateChild(e){const n=at(this.path_,e);return new Vg(this.syncTree_,n)}node(){return Mg(this.syncTree_,this.path_)}}const yL=function(t){return t=t||{},t.timestamp=t.timestamp||new Date().getTime(),t},Yw=function(t,e,n){if(!t||typeof t!="object")return t;if(H(".sv"in t,"Unexpected leaf node or priority contents"),typeof t[".sv"]=="string")return vL(t[".sv"],e,n);if(typeof t[".sv"]=="object")return wL(t[".sv"],e);H(!1,"Unexpected server value: "+JSON.stringify(t,null,2))},vL=function(t,e,n){switch(t){case"timestamp":return n.timestamp;default:H(!1,"Unexpected server value: "+t)}},wL=function(t,e,n){t.hasOwnProperty("increment")||H(!1,"Unexpected server value: "+JSON.stringify(t,null,2));const r=t.increment;typeof r!="number"&&H(!1,"Unexpected increment value: "+r);const i=e.node();if(H(i!==null&&typeof i<"u","Expected ChildrenNode.EMPTY_NODE for nulls"),!i.isLeafNode())return r;const o=i.getValue();return typeof o!="number"?r:o+r},EL=function(t,e,n,r){return Fg(e,new Vg(n,t),r)},Vk=function(t,e,n){return Fg(t,new Lg(e),n)};function Fg(t,e,n){const r=t.getPriority().val(),i=Yw(r,e.getImmediateChild(".priority"),n);let s;if(t.isLeafNode()){const o=t,a=Yw(o.getValue(),e,n);return a!==o.getValue()||i!==o.getPriority().val()?new dt(a,wt(i)):t}else{const o=t;return s=o,i!==o.getPriority().val()&&(s=s.updatePriority(new dt(i))),o.forEachChild(Lt,(a,u)=>{const c=Fg(u,e.getImmediateChild(a),n);c!==u&&(s=s.updateImmediateChild(a,c))}),s}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ug{constructor(e="",n=null,r={children:{},childCount:0}){this.name=e,this.parent=n,this.node=r}}function jg(t,e){let n=e instanceof ze?e:new ze(e),r=t,i=he(n);for(;i!==null;){const s=Zs(r.node.children,i)||{children:{},childCount:0};r=new Ug(i,r,s),n=Ve(n),i=he(n)}return r}function Io(t){return t.node.value}function Fk(t,e){t.node.value=e,Rp(t)}function Uk(t){return t.node.childCount>0}function TL(t){return Io(t)===void 0&&!Uk(t)}function Ah(t,e){Sn(t.node.children,(n,r)=>{e(new Ug(n,t,r))})}function jk(t,e,n,r){n&&e(t),Ah(t,i=>{jk(i,e,!0)})}function IL(t,e,n){let r=t.parent;for(;r!==null;){if(e(r))return!0;r=r.parent}return!1}function Cl(t){return new ze(t.parent===null?t.name:Cl(t.parent)+"/"+t.name)}function Rp(t){t.parent!==null&&SL(t.parent,t.name,t)}function SL(t,e,n){const r=TL(n),i=Ar(t.node.children,e);r&&i?(delete t.node.children[e],t.node.childCount--,Rp(t)):!r&&!i&&(t.node.children[e]=n.node,t.node.childCount++,Rp(t))}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const kL=/[\[\].#$\/\u0000-\u001F\u007F]/,CL=/[\[\].#$\u0000-\u001F\u007F]/,Wd=10*1024*1024,zk=function(t){return typeof t=="string"&&t.length!==0&&!kL.test(t)},Bk=function(t){return typeof t=="string"&&t.length!==0&&!CL.test(t)},RL=function(t){return t&&(t=t.replace(/^\/*\.info(\/|$)/,"/")),Bk(t)},AL=function(t,e,n,r){zg(Dm(t,"value"),e,n)},zg=function(t,e,n){const r=n instanceof ze?new uM(n,t):n;if(e===void 0)throw new Error(t+"contains undefined "+Ri(r));if(typeof e=="function")throw new Error(t+"contains a function "+Ri(r)+" with contents = "+e.toString());if(US(e))throw new Error(t+"contains "+e.toString()+" "+Ri(r));if(typeof e=="string"&&e.length>Wd/3&&uh(e)>Wd)throw new Error(t+"contains a string greater than "+Wd+" utf8 bytes "+Ri(r)+" ('"+e.substring(0,50)+"...')");if(e&&typeof e=="object"){let i=!1,s=!1;if(Sn(e,(o,a)=>{if(o===".value")i=!0;else if(o!==".priority"&&o!==".sv"&&(s=!0,!zk(o)))throw new Error(t+" contains an invalid key ("+o+") "+Ri(r)+`.  Keys must be non-empty strings and can't contain ".", "#", "$", "/", "[", or "]"`);cM(r,o),zg(t,a,r),hM(r)}),i&&s)throw new Error(t+' contains ".value" child '+Ri(r)+" in addition to actual children.")}},$k=function(t,e,n,r){if(!Bk(n))throw new Error(Dm(t,e)+'was an invalid path = "'+n+`". Paths must be non-empty strings and can't contain ".", "#", "$", "[", or "]"`)},xL=function(t,e,n,r){n&&(n=n.replace(/^\/*\.info(\/|$)/,"/")),$k(t,e,n)},Wk=function(t,e){if(he(e)===".info")throw new Error(t+" failed = Can't modify data under /.info/")},PL=function(t,e){const n=e.path.toString();if(typeof e.repoInfo.host!="string"||e.repoInfo.host.length===0||!zk(e.repoInfo.namespace)&&e.repoInfo.host.split(":")[0]!=="localhost"||n.length!==0&&!RL(n))throw new Error(Dm(t,"url")+`must be a valid firebase URL and the path can't contain ".", "#", "$", "[", or "]".`)};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class bL{constructor(){this.eventLists_=[],this.recursionDepth_=0}}function qk(t,e){let n=null;for(let r=0;r<e.length;r++){const i=e[r],s=i.getPath();n!==null&&!uk(s,n.path)&&(t.eventLists_.push(n),n=null),n===null&&(n={events:[],path:s}),n.events.push(i)}n&&t.eventLists_.push(n)}function Sr(t,e,n){qk(t,n),NL(t,r=>On(r,e)||On(e,r))}function NL(t,e){t.recursionDepth_++;let n=!0;for(let r=0;r<t.eventLists_.length;r++){const i=t.eventLists_[r];if(i){const s=i.path;e(s)?(OL(t.eventLists_[r]),t.eventLists_[r]=null):n=!1}}n&&(t.eventLists_=[]),t.recursionDepth_--}function OL(t){for(let e=0;e<t.events.length;e++){const n=t.events[e];if(n!==null){t.events[e]=null;const r=n.getEventRunner();Sa&&Mt("event: "+n.toString()),To(r)}}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const DL="repo_interrupt",ML=25;class LL{constructor(e,n,r,i){this.repoInfo_=e,this.forceRestClient_=n,this.authTokenProvider_=r,this.appCheckProvider_=i,this.dataUpdateCount=0,this.statsListener_=null,this.eventQueue_=new bL,this.nextWriteId_=1,this.interceptServerDataCallback_=null,this.onDisconnect_=Oc(),this.transactionQueueTree_=new Ug,this.persistentConnection_=null,this.key=this.repoInfo_.toURLString()}toString(){return(this.repoInfo_.secure?"https://":"http://")+this.repoInfo_.host}}function VL(t,e,n){if(t.stats_=kg(t.repoInfo_),t.forceRestClient_||DD())t.server_=new Nc(t.repoInfo_,(r,i,s,o)=>{Xw(t,r,i,s,o)},t.authTokenProvider_,t.appCheckProvider_),setTimeout(()=>Jw(t,!0),0);else{if(typeof n<"u"&&n!==null){if(typeof n!="object")throw new Error("Only objects are supported for option databaseAuthVariableOverride");try{Et(n)}catch(r){throw new Error("Invalid authOverride provided: "+r)}}t.persistentConnection_=new pr(t.repoInfo_,e,(r,i,s,o)=>{Xw(t,r,i,s,o)},r=>{Jw(t,r)},r=>{UL(t,r)},t.authTokenProvider_,t.appCheckProvider_,n),t.server_=t.persistentConnection_}t.authTokenProvider_.addTokenChangeListener(r=>{t.server_.refreshAuthToken(r)}),t.appCheckProvider_.addTokenChangeListener(r=>{t.server_.refreshAppCheckToken(r.token)}),t.statsReporter_=UD(t.repoInfo_,()=>new FM(t.stats_,t.server_)),t.infoData_=new OM,t.infoSyncTree_=new Qw({startListening:(r,i,s,o)=>{let a=[];const u=t.infoData_.getNode(r._path);return u.isEmpty()||(a=Ch(t.infoSyncTree_,r._path,u),setTimeout(()=>{o("ok")},0)),a},stopListening:()=>{}}),$g(t,"connected",!1),t.serverSyncTree_=new Qw({startListening:(r,i,s,o)=>(t.server_.listen(r,s,i,(a,u)=>{const c=o(a,u);Sr(t.eventQueue_,r._path,c)}),[]),stopListening:(r,i)=>{t.server_.unlisten(r,i)}})}function FL(t){const n=t.infoData_.getNode(new ze(".info/serverTimeOffset")).val()||0;return new Date().getTime()+n}function Bg(t){return yL({timestamp:FL(t)})}function Xw(t,e,n,r,i){t.dataUpdateCount++;const s=new ze(e);n=t.interceptServerDataCallback_?t.interceptServerDataCallback_(e,n):n;let o=[];if(i)if(r){const u=yc(n,c=>wt(c));o=_L(t.serverSyncTree_,s,u,i)}else{const u=wt(n);o=gL(t.serverSyncTree_,s,u,i)}else if(r){const u=yc(n,c=>wt(c));o=mL(t.serverSyncTree_,s,u)}else{const u=wt(n);o=Ch(t.serverSyncTree_,s,u)}let a=s;o.length>0&&(a=xh(t,s)),Sr(t.eventQueue_,a,o)}function Jw(t,e){$g(t,"connected",e),e===!1&&zL(t)}function UL(t,e){Sn(e,(n,r)=>{$g(t,n,r)})}function $g(t,e,n){const r=new ze("/.info/"+e),i=wt(n);t.infoData_.updateSnapshot(r,i);const s=Ch(t.infoSyncTree_,r,i);Sr(t.eventQueue_,r,s)}function Hk(t){return t.nextWriteId_++}function jL(t,e,n,r,i){Wg(t,"set",{path:e.toString(),value:n,priority:r});const s=Bg(t),o=wt(n,r),a=Mg(t.serverSyncTree_,e),u=Vk(o,a,s),c=Hk(t),d=bk(t.serverSyncTree_,e,u,c,!0);qk(t.eventQueue_,d),t.server_.put(e.toString(),o.val(!0),(m,w)=>{const I=m==="ok";I||en("set at "+e+" failed: "+m);const P=Di(t.serverSyncTree_,c,!I);Sr(t.eventQueue_,e,P),$L(t,i,m,w)});const f=Xk(t,e);xh(t,f),Sr(t.eventQueue_,f,[])}function zL(t){Wg(t,"onDisconnectEvents");const e=Bg(t),n=Oc();wp(t.onDisconnect_,Re(),(i,s)=>{const o=EL(i,s,t.serverSyncTree_,e);gk(n,i,o)});let r=[];wp(n,Re(),(i,s)=>{r=r.concat(Ch(t.serverSyncTree_,i,s));const o=Xk(t,i);xh(t,o)}),t.onDisconnect_=Oc(),Sr(t.eventQueue_,Re(),r)}function BL(t){t.persistentConnection_&&t.persistentConnection_.interrupt(DL)}function Wg(t,...e){let n="";t.persistentConnection_&&(n=t.persistentConnection_.id+":"),Mt(n,...e)}function $L(t,e,n,r){e&&To(()=>{if(n==="ok")e(null);else{const i=(n||"error").toUpperCase();let s=i;r&&(s+=": "+r);const o=new Error(s);o.code=i,e(o)}})}function Gk(t,e,n){return Mg(t.serverSyncTree_,e,n)||Te.EMPTY_NODE}function qg(t,e=t.transactionQueueTree_){if(e||Ph(t,e),Io(e)){const n=Qk(t,e);H(n.length>0,"Sending zero length transaction queue"),n.every(i=>i.status===0)&&WL(t,Cl(e),n)}else Uk(e)&&Ah(e,n=>{qg(t,n)})}function WL(t,e,n){const r=n.map(c=>c.currentWriteId),i=Gk(t,e,r);let s=i;const o=i.hash();for(let c=0;c<n.length;c++){const d=n[c];H(d.status===0,"tryToSendTransactionQueue_: items in queue should all be run."),d.status=1,d.retryCount++;const f=gn(e,d.path);s=s.updateChild(f,d.currentOutputSnapshotRaw)}const a=s.val(!0),u=e;t.server_.put(u.toString(),a,c=>{Wg(t,"transaction put response",{path:u.toString(),status:c});let d=[];if(c==="ok"){const f=[];for(let m=0;m<n.length;m++)n[m].status=2,d=d.concat(Di(t.serverSyncTree_,n[m].currentWriteId)),n[m].onComplete&&f.push(()=>n[m].onComplete(null,!0,n[m].currentOutputSnapshotResolved)),n[m].unwatcher();Ph(t,jg(t.transactionQueueTree_,e)),qg(t,t.transactionQueueTree_),Sr(t.eventQueue_,e,d);for(let m=0;m<f.length;m++)To(f[m])}else{if(c==="datastale")for(let f=0;f<n.length;f++)n[f].status===3?n[f].status=4:n[f].status=0;else{en("transaction at "+u.toString()+" failed: "+c);for(let f=0;f<n.length;f++)n[f].status=4,n[f].abortReason=c}xh(t,e)}},o)}function xh(t,e){const n=Kk(t,e),r=Cl(n),i=Qk(t,n);return qL(t,i,r),r}function qL(t,e,n){if(e.length===0)return;const r=[];let i=[];const o=e.filter(a=>a.status===0).map(a=>a.currentWriteId);for(let a=0;a<e.length;a++){const u=e[a],c=gn(n,u.path);let d=!1,f;if(H(c!==null,"rerunTransactionsUnderNode_: relativePath should not be null."),u.status===4)d=!0,f=u.abortReason,i=i.concat(Di(t.serverSyncTree_,u.currentWriteId,!0));else if(u.status===0)if(u.retryCount>=ML)d=!0,f="maxretry",i=i.concat(Di(t.serverSyncTree_,u.currentWriteId,!0));else{const m=Gk(t,u.path,o);u.currentInputSnapshot=m;const w=e[a].update(m.val());if(w!==void 0){zg("transaction failed: Data returned ",w,u.path);let I=wt(w);typeof w=="object"&&w!=null&&Ar(w,".priority")||(I=I.updatePriority(m.getPriority()));const O=u.currentWriteId,C=Bg(t),T=Vk(I,m,C);u.currentOutputSnapshotRaw=I,u.currentOutputSnapshotResolved=T,u.currentWriteId=Hk(t),o.splice(o.indexOf(O),1),i=i.concat(bk(t.serverSyncTree_,u.path,T,u.currentWriteId,u.applyLocally)),i=i.concat(Di(t.serverSyncTree_,O,!0))}else d=!0,f="nodata",i=i.concat(Di(t.serverSyncTree_,u.currentWriteId,!0))}Sr(t.eventQueue_,n,i),i=[],d&&(e[a].status=2,function(m){setTimeout(m,Math.floor(0))}(e[a].unwatcher),e[a].onComplete&&(f==="nodata"?r.push(()=>e[a].onComplete(null,!1,e[a].currentInputSnapshot)):r.push(()=>e[a].onComplete(new Error(f),!1,null))))}Ph(t,t.transactionQueueTree_);for(let a=0;a<r.length;a++)To(r[a]);qg(t,t.transactionQueueTree_)}function Kk(t,e){let n,r=t.transactionQueueTree_;for(n=he(e);n!==null&&Io(r)===void 0;)r=jg(r,n),e=Ve(e),n=he(e);return r}function Qk(t,e){const n=[];return Yk(t,e,n),n.sort((r,i)=>r.order-i.order),n}function Yk(t,e,n){const r=Io(e);if(r)for(let i=0;i<r.length;i++)n.push(r[i]);Ah(e,i=>{Yk(t,i,n)})}function Ph(t,e){const n=Io(e);if(n){let r=0;for(let i=0;i<n.length;i++)n[i].status!==2&&(n[r]=n[i],r++);n.length=r,Fk(e,n.length>0?n:void 0)}Ah(e,r=>{Ph(t,r)})}function Xk(t,e){const n=Cl(Kk(t,e)),r=jg(t.transactionQueueTree_,e);return IL(r,i=>{qd(t,i)}),qd(t,r),jk(r,i=>{qd(t,i)}),n}function qd(t,e){const n=Io(e);if(n){const r=[];let i=[],s=-1;for(let o=0;o<n.length;o++)n[o].status===3||(n[o].status===1?(H(s===o-1,"All SENT items should be at beginning of queue."),s=o,n[o].status=3,n[o].abortReason="set"):(H(n[o].status===0,"Unexpected transaction status in abort"),n[o].unwatcher(),i=i.concat(Di(t.serverSyncTree_,n[o].currentWriteId,!0)),n[o].onComplete&&r.push(n[o].onComplete.bind(null,new Error("set"),!1,null))));s===-1?Fk(e,void 0):n.length=s+1,Sr(t.eventQueue_,Cl(e),i);for(let o=0;o<r.length;o++)To(r[o])}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function HL(t){let e="";const n=t.split("/");for(let r=0;r<n.length;r++)if(n[r].length>0){let i=n[r];try{i=decodeURIComponent(i.replace(/\+/g," "))}catch{}e+="/"+i}return e}function GL(t){const e={};t.charAt(0)==="?"&&(t=t.substring(1));for(const n of t.split("&")){if(n.length===0)continue;const r=n.split("=");r.length===2?e[decodeURIComponent(r[0])]=decodeURIComponent(r[1]):en(`Invalid query segment '${n}' in query '${t}'`)}return e}const Zw=function(t,e){const n=KL(t),r=n.namespace;n.domain==="firebase.com"&&Ir(n.host+" is no longer supported. Please use <YOUR FIREBASE>.firebaseio.com instead"),(!r||r==="undefined")&&n.domain!=="localhost"&&Ir("Cannot parse Firebase url. Please use https://<YOUR FIREBASE>.firebaseio.com"),n.secure||CD();const i=n.scheme==="ws"||n.scheme==="wss";return{repoInfo:new XS(n.host,n.secure,r,i,e,"",r!==n.subdomain),path:new ze(n.pathString)}},KL=function(t){let e="",n="",r="",i="",s="",o=!0,a="https",u=443;if(typeof t=="string"){let c=t.indexOf("//");c>=0&&(a=t.substring(0,c-1),t=t.substring(c+2));let d=t.indexOf("/");d===-1&&(d=t.length);let f=t.indexOf("?");f===-1&&(f=t.length),e=t.substring(0,Math.min(d,f)),d<f&&(i=HL(t.substring(d,f)));const m=GL(t.substring(Math.min(t.length,f)));c=e.indexOf(":"),c>=0?(o=a==="https"||a==="wss",u=parseInt(e.substring(c+1),10)):c=e.length;const w=e.slice(0,c);if(w.toLowerCase()==="localhost")n="localhost";else if(w.split(".").length<=2)n=w;else{const I=e.indexOf(".");r=e.substring(0,I).toLowerCase(),n=e.substring(I+1),s=r}"ns"in m&&(s=m.ns)}return{host:e,port:u,domain:n,subdomain:r,secure:o,scheme:a,pathString:i,namespace:s}};/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Hg{constructor(e,n,r,i){this._repo=e,this._path=n,this._queryParams=r,this._orderByCalled=i}get key(){return fe(this._path)?null:ok(this._path)}get ref(){return new os(this._repo,this._path)}get _queryIdentifier(){const e=Fw(this._queryParams),n=Ig(e);return n==="{}"?"default":n}get _queryObject(){return Fw(this._queryParams)}isEqual(e){if(e=Qe(e),!(e instanceof Hg))return!1;const n=this._repo===e._repo,r=uk(this._path,e._path),i=this._queryIdentifier===e._queryIdentifier;return n&&r&&i}toJSON(){return this.toString()}toString(){return this._repo.toString()+lM(this._path)}}class os extends Hg{constructor(e,n){super(e,n,new xg,!1)}get parent(){const e=lk(this._path);return e===null?null:new os(this._repo,e)}get root(){let e=this;for(;e.parent!==null;)e=e.parent;return e}}function Hd(t,e){return t=Qe(t),t._checkNotDeleted("ref"),e!==void 0?QL(t._root,e):t._root}function QL(t,e){return t=Qe(t),he(t._path)===null?xL("child","path",e):$k("child","path",e),new os(t._repo,at(t._path,e))}function YL(t){return Wk("remove",t._path),Ap(t,null)}function Ap(t,e){t=Qe(t),Wk("set",t._path),AL("set",e,t._path);const n=new lh;return jL(t._repo,t._path,e,null,n.wrapCallback(()=>{})),n.promise}fL(os);pL(os);/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const XL="FIREBASE_DATABASE_EMULATOR_HOST",xp={};let JL=!1;function ZL(t,e,n,r){t.repoInfo_=new XS(`${e}:${n}`,!1,t.repoInfo_.namespace,t.repoInfo_.webSocketOnly,t.repoInfo_.nodeAdmin,t.repoInfo_.persistenceKey,t.repoInfo_.includeNamespaceInQueryParams,!0),r&&(t.authTokenProvider_=r)}function eV(t,e,n,r,i){let s=r||t.options.databaseURL;s===void 0&&(t.options.projectId||Ir("Can't determine Firebase Database URL. Be sure to include  a Project ID when calling firebase.initializeApp()."),Mt("Using default host for project ",t.options.projectId),s=`${t.options.projectId}-default-rtdb.firebaseio.com`);let o=Zw(s,i),a=o.repoInfo,u;typeof process<"u"&&vw&&(u=vw[XL]),u?(s=`http://${u}?ns=${a.namespace}`,o=Zw(s,i),a=o.repoInfo):o.repoInfo.secure;const c=new LD(t.name,t.options,e);PL("Invalid Firebase Database URL",o),fe(o.path)||Ir("Database URL must point to the root of a Firebase Database (not including a child path).");const d=nV(a,t,c,new MD(t.name,n));return new rV(d,t)}function tV(t,e){const n=xp[e];(!n||n[t.key]!==t)&&Ir(`Database ${e}(${t.repoInfo_}) has already been deleted.`),BL(t),delete n[t.key]}function nV(t,e,n,r){let i=xp[e.name];i||(i={},xp[e.name]=i);let s=i[t.toURLString()];return s&&Ir("Database initialized multiple times. Please make sure the format of the database URL matches with each database() call."),s=new LL(t,JL,n,r),i[t.toURLString()]=s,s}class rV{constructor(e,n){this._repoInternal=e,this.app=n,this.type="database",this._instanceStarted=!1}get _repo(){return this._instanceStarted||(VL(this._repoInternal,this.app.options.appId,this.app.options.databaseAuthVariableOverride),this._instanceStarted=!0),this._repoInternal}get _root(){return this._rootInternal||(this._rootInternal=new os(this._repo,Re())),this._rootInternal}_delete(){return this._rootInternal!==null&&(tV(this._repo,this.app.name),this._repoInternal=null,this._rootInternal=null),Promise.resolve()}_checkNotDeleted(e){this._rootInternal===null&&Ir("Cannot call "+e+" on a deleted database.")}}function iV(t=hh(),e){const n=ml(t,"database").getImmediate({identifier:e});if(!n._instanceStarted){const r=bm("database");r&&sV(n,...r)}return n}function sV(t,e,n,r={}){t=Qe(t),t._checkNotDeleted("useEmulator"),t._instanceStarted&&Ir("Cannot call useEmulator() after instance has already been initialized.");const i=t._repoInternal;let s;if(i.repoInfo_.nodeAdmin)r.mockUserToken&&Ir('mockUserToken is not supported by the Admin SDK. For client access with mock users, please use the "firebase" package instead of "firebase-admin".'),s=new zu(zu.OWNER);else if(r.mockUserToken){const o=typeof r.mockUserToken=="string"?r.mockUserToken:Nm(r.mockUserToken,t.app.options.projectId);s=new zu(o)}ZL(i,e,n,s)}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function oV(t){wD(yi),ui(new vr("database",(e,{instanceIdentifier:n})=>{const r=e.getProvider("app").getImmediate(),i=e.getProvider("auth-internal"),s=e.getProvider("app-check-internal");return eV(r,i,s,n)},"PUBLIC").setMultipleInstances(!0)),wn(ww,Ew,t),wn(ww,Ew,"esm2017")}pr.prototype.simpleListen=function(t,e){this.sendRequest("q",{p:t},e)};pr.prototype.echo=function(t,e){this.sendRequest("echo",{d:t},e)};oV();function Gg(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(t!=null&&typeof Object.getOwnPropertySymbols=="function")for(var i=0,r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]]);return n}function Jk(){return{"dependent-sdk-initialized-before-auth":"Another Firebase SDK was initialized and is trying to use Auth before Auth is initialized. Please be sure to call `initializeAuth` or `getAuth` before starting any other Firebase SDK."}}const aV=Jk,Zk=new pl("auth","Firebase",Jk());/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Vc=new ch("@firebase/auth");function lV(t,...e){Vc.logLevel<=ce.WARN&&Vc.warn(`Auth (${yi}): ${t}`,...e)}function Bu(t,...e){Vc.logLevel<=ce.ERROR&&Vc.error(`Auth (${yi}): ${t}`,...e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function kr(t,...e){throw Kg(t,...e)}function Yn(t,...e){return Kg(t,...e)}function e1(t,e,n){const r=Object.assign(Object.assign({},aV()),{[e]:n});return new pl("auth","Firebase",r).create(e,{appName:t.name})}function oi(t){return e1(t,"operation-not-supported-in-this-environment","Operations that alter the current user are not supported in conjunction with FirebaseServerApp")}function Kg(t,...e){if(typeof t!="string"){const n=e[0],r=[...e.slice(1)];return r[0]&&(r[0].appName=t.name),t._errorFactory.create(n,...r)}return Zk.create(t,...e)}function ne(t,e,...n){if(!t)throw Kg(e,...n)}function ur(t){const e="INTERNAL ASSERTION FAILED: "+t;throw Bu(e),new Error(e)}function Cr(t,e){t||ur(e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Pp(){var t;return typeof self<"u"&&((t=self.location)===null||t===void 0?void 0:t.href)||""}function uV(){return e0()==="http:"||e0()==="https:"}function e0(){var t;return typeof self<"u"&&((t=self.location)===null||t===void 0?void 0:t.protocol)||null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function cV(){return typeof navigator<"u"&&navigator&&"onLine"in navigator&&typeof navigator.onLine=="boolean"&&(uV()||Ex()||"connection"in navigator)?navigator.onLine:!0}function hV(){if(typeof navigator>"u")return null;const t=navigator;return t.languages&&t.languages[0]||t.language||null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Rl{constructor(e,n){this.shortDelay=e,this.longDelay=n,Cr(n>e,"Short delay should be less than long delay!"),this.isMobile=Om()||WT()}get(){return cV()?this.isMobile?this.longDelay:this.shortDelay:Math.min(5e3,this.shortDelay)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Qg(t,e){Cr(t.emulator,"Emulator should always be set here");const{url:n}=t.emulator;return e?`${n}${e.startsWith("/")?e.slice(1):e}`:n}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class t1{static initialize(e,n,r){this.fetchImpl=e,n&&(this.headersImpl=n),r&&(this.responseImpl=r)}static fetch(){if(this.fetchImpl)return this.fetchImpl;if(typeof self<"u"&&"fetch"in self)return self.fetch;if(typeof globalThis<"u"&&globalThis.fetch)return globalThis.fetch;if(typeof fetch<"u")return fetch;ur("Could not find fetch implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}static headers(){if(this.headersImpl)return this.headersImpl;if(typeof self<"u"&&"Headers"in self)return self.Headers;if(typeof globalThis<"u"&&globalThis.Headers)return globalThis.Headers;if(typeof Headers<"u")return Headers;ur("Could not find Headers implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}static response(){if(this.responseImpl)return this.responseImpl;if(typeof self<"u"&&"Response"in self)return self.Response;if(typeof globalThis<"u"&&globalThis.Response)return globalThis.Response;if(typeof Response<"u")return Response;ur("Could not find Response implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const dV={CREDENTIAL_MISMATCH:"custom-token-mismatch",MISSING_CUSTOM_TOKEN:"internal-error",INVALID_IDENTIFIER:"invalid-email",MISSING_CONTINUE_URI:"internal-error",INVALID_PASSWORD:"wrong-password",MISSING_PASSWORD:"missing-password",INVALID_LOGIN_CREDENTIALS:"invalid-credential",EMAIL_EXISTS:"email-already-in-use",PASSWORD_LOGIN_DISABLED:"operation-not-allowed",INVALID_IDP_RESPONSE:"invalid-credential",INVALID_PENDING_TOKEN:"invalid-credential",FEDERATED_USER_ID_ALREADY_LINKED:"credential-already-in-use",MISSING_REQ_TYPE:"internal-error",EMAIL_NOT_FOUND:"user-not-found",RESET_PASSWORD_EXCEED_LIMIT:"too-many-requests",EXPIRED_OOB_CODE:"expired-action-code",INVALID_OOB_CODE:"invalid-action-code",MISSING_OOB_CODE:"internal-error",CREDENTIAL_TOO_OLD_LOGIN_AGAIN:"requires-recent-login",INVALID_ID_TOKEN:"invalid-user-token",TOKEN_EXPIRED:"user-token-expired",USER_NOT_FOUND:"user-token-expired",TOO_MANY_ATTEMPTS_TRY_LATER:"too-many-requests",PASSWORD_DOES_NOT_MEET_REQUIREMENTS:"password-does-not-meet-requirements",INVALID_CODE:"invalid-verification-code",INVALID_SESSION_INFO:"invalid-verification-id",INVALID_TEMPORARY_PROOF:"invalid-credential",MISSING_SESSION_INFO:"missing-verification-id",SESSION_EXPIRED:"code-expired",MISSING_ANDROID_PACKAGE_NAME:"missing-android-pkg-name",UNAUTHORIZED_DOMAIN:"unauthorized-continue-uri",INVALID_OAUTH_CLIENT_ID:"invalid-oauth-client-id",ADMIN_ONLY_OPERATION:"admin-restricted-operation",INVALID_MFA_PENDING_CREDENTIAL:"invalid-multi-factor-session",MFA_ENROLLMENT_NOT_FOUND:"multi-factor-info-not-found",MISSING_MFA_ENROLLMENT_ID:"missing-multi-factor-info",MISSING_MFA_PENDING_CREDENTIAL:"missing-multi-factor-session",SECOND_FACTOR_EXISTS:"second-factor-already-in-use",SECOND_FACTOR_LIMIT_EXCEEDED:"maximum-second-factor-count-exceeded",BLOCKING_FUNCTION_ERROR_RESPONSE:"internal-error",RECAPTCHA_NOT_ENABLED:"recaptcha-not-enabled",MISSING_RECAPTCHA_TOKEN:"missing-recaptcha-token",INVALID_RECAPTCHA_TOKEN:"invalid-recaptcha-token",INVALID_RECAPTCHA_ACTION:"invalid-recaptcha-action",MISSING_CLIENT_TYPE:"missing-client-type",MISSING_RECAPTCHA_VERSION:"missing-recaptcha-version",INVALID_RECAPTCHA_VERSION:"invalid-recaptcha-version",INVALID_REQ_TYPE:"invalid-req-type"};/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const fV=new Rl(3e4,6e4);function bh(t,e){return t.tenantId&&!e.tenantId?Object.assign(Object.assign({},e),{tenantId:t.tenantId}):e}async function So(t,e,n,r,i={}){return n1(t,i,async()=>{let s={},o={};r&&(e==="GET"?o=r:s={body:JSON.stringify(r)});const a=po(Object.assign({key:t.config.apiKey},o)).slice(1),u=await t._getAdditionalHeaders();u["Content-Type"]="application/json",t.languageCode&&(u["X-Firebase-Locale"]=t.languageCode);const c=Object.assign({method:e,headers:u},s);return wx()||(c.referrerPolicy="no-referrer"),t1.fetch()(i1(t,t.config.apiHost,n,a),c)})}async function n1(t,e,n){t._canInitEmulator=!1;const r=Object.assign(Object.assign({},dV),e);try{const i=new pV(t),s=await Promise.race([n(),i.promise]);i.clearNetworkTimeout();const o=await s.json();if("needConfirmation"in o)throw Tu(t,"account-exists-with-different-credential",o);if(s.ok&&!("errorMessage"in o))return o;{const a=s.ok?o.errorMessage:o.error.message,[u,c]=a.split(" : ");if(u==="FEDERATED_USER_ID_ALREADY_LINKED")throw Tu(t,"credential-already-in-use",o);if(u==="EMAIL_EXISTS")throw Tu(t,"email-already-in-use",o);if(u==="USER_DISABLED")throw Tu(t,"user-disabled",o);const d=r[u]||u.toLowerCase().replace(/[_\s]+/g,"-");if(c)throw e1(t,d,c);kr(t,d)}}catch(i){if(i instanceof Zn)throw i;kr(t,"network-request-failed",{message:String(i)})}}async function r1(t,e,n,r,i={}){const s=await So(t,e,n,r,i);return"mfaPendingCredential"in s&&kr(t,"multi-factor-auth-required",{_serverResponse:s}),s}function i1(t,e,n,r){const i=`${e}${n}?${r}`;return t.config.emulator?Qg(t.config,i):`${t.config.apiScheme}://${i}`}class pV{constructor(e){this.auth=e,this.timer=null,this.promise=new Promise((n,r)=>{this.timer=setTimeout(()=>r(Yn(this.auth,"network-request-failed")),fV.get())})}clearNetworkTimeout(){clearTimeout(this.timer)}}function Tu(t,e,n){const r={appName:t.name};n.email&&(r.email=n.email),n.phoneNumber&&(r.phoneNumber=n.phoneNumber);const i=Yn(t,e,r);return i.customData._tokenResponse=n,i}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function mV(t,e){return So(t,"POST","/v1/accounts:delete",e)}async function s1(t,e){return So(t,"POST","/v1/accounts:lookup",e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Aa(t){if(t)try{const e=new Date(Number(t));if(!isNaN(e.getTime()))return e.toUTCString()}catch{}}async function gV(t,e=!1){const n=Qe(t),r=await n.getIdToken(e),i=Yg(r);ne(i&&i.exp&&i.auth_time&&i.iat,n.auth,"internal-error");const s=typeof i.firebase=="object"?i.firebase:void 0,o=s==null?void 0:s.sign_in_provider;return{claims:i,token:r,authTime:Aa(Gd(i.auth_time)),issuedAtTime:Aa(Gd(i.iat)),expirationTime:Aa(Gd(i.exp)),signInProvider:o||null,signInSecondFactor:(s==null?void 0:s.sign_in_second_factor)||null}}function Gd(t){return Number(t)*1e3}function Yg(t){const[e,n,r]=t.split(".");if(e===void 0||n===void 0||r===void 0)return Bu("JWT malformed, contained fewer than 3 sections"),null;try{const i=_c(n);return i?JSON.parse(i):(Bu("Failed to decode base64 JWT payload"),null)}catch(i){return Bu("Caught error parsing JWT payload as JSON",i==null?void 0:i.toString()),null}}function t0(t){const e=Yg(t);return ne(e,"internal-error"),ne(typeof e.exp<"u","internal-error"),ne(typeof e.iat<"u","internal-error"),Number(e.exp)-Number(e.iat)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function ll(t,e,n=!1){if(n)return e;try{return await e}catch(r){throw r instanceof Zn&&_V(r)&&t.auth.currentUser===t&&await t.auth.signOut(),r}}function _V({code:t}){return t==="auth/user-disabled"||t==="auth/user-token-expired"}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class yV{constructor(e){this.user=e,this.isRunning=!1,this.timerId=null,this.errorBackoff=3e4}_start(){this.isRunning||(this.isRunning=!0,this.schedule())}_stop(){this.isRunning&&(this.isRunning=!1,this.timerId!==null&&clearTimeout(this.timerId))}getInterval(e){var n;if(e){const r=this.errorBackoff;return this.errorBackoff=Math.min(this.errorBackoff*2,96e4),r}else{this.errorBackoff=3e4;const i=((n=this.user.stsTokenManager.expirationTime)!==null&&n!==void 0?n:0)-Date.now()-3e5;return Math.max(0,i)}}schedule(e=!1){if(!this.isRunning)return;const n=this.getInterval(e);this.timerId=setTimeout(async()=>{await this.iteration()},n)}async iteration(){try{await this.user.getIdToken(!0)}catch(e){(e==null?void 0:e.code)==="auth/network-request-failed"&&this.schedule(!0);return}this.schedule()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class bp{constructor(e,n){this.createdAt=e,this.lastLoginAt=n,this._initializeTime()}_initializeTime(){this.lastSignInTime=Aa(this.lastLoginAt),this.creationTime=Aa(this.createdAt)}_copy(e){this.createdAt=e.createdAt,this.lastLoginAt=e.lastLoginAt,this._initializeTime()}toJSON(){return{createdAt:this.createdAt,lastLoginAt:this.lastLoginAt}}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function Fc(t){var e;const n=t.auth,r=await t.getIdToken(),i=await ll(t,s1(n,{idToken:r}));ne(i==null?void 0:i.users.length,n,"internal-error");const s=i.users[0];t._notifyReloadListener(s);const o=!((e=s.providerUserInfo)===null||e===void 0)&&e.length?o1(s.providerUserInfo):[],a=wV(t.providerData,o),u=t.isAnonymous,c=!(t.email&&s.passwordHash)&&!(a!=null&&a.length),d=u?c:!1,f={uid:s.localId,displayName:s.displayName||null,photoURL:s.photoUrl||null,email:s.email||null,emailVerified:s.emailVerified||!1,phoneNumber:s.phoneNumber||null,tenantId:s.tenantId||null,providerData:a,metadata:new bp(s.createdAt,s.lastLoginAt),isAnonymous:d};Object.assign(t,f)}async function vV(t){const e=Qe(t);await Fc(e),await e.auth._persistUserIfCurrent(e),e.auth._notifyListenersIfCurrent(e)}function wV(t,e){return[...t.filter(r=>!e.some(i=>i.providerId===r.providerId)),...e]}function o1(t){return t.map(e=>{var{providerId:n}=e,r=Gg(e,["providerId"]);return{providerId:n,uid:r.rawId||"",displayName:r.displayName||null,email:r.email||null,phoneNumber:r.phoneNumber||null,photoURL:r.photoUrl||null}})}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function EV(t,e){const n=await n1(t,{},async()=>{const r=po({grant_type:"refresh_token",refresh_token:e}).slice(1),{tokenApiHost:i,apiKey:s}=t.config,o=i1(t,i,"/v1/token",`key=${s}`),a=await t._getAdditionalHeaders();return a["Content-Type"]="application/x-www-form-urlencoded",t1.fetch()(o,{method:"POST",headers:a,body:r})});return{accessToken:n.access_token,expiresIn:n.expires_in,refreshToken:n.refresh_token}}async function TV(t,e){return So(t,"POST","/v2/accounts:revokeToken",bh(t,e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class $s{constructor(){this.refreshToken=null,this.accessToken=null,this.expirationTime=null}get isExpired(){return!this.expirationTime||Date.now()>this.expirationTime-3e4}updateFromServerResponse(e){ne(e.idToken,"internal-error"),ne(typeof e.idToken<"u","internal-error"),ne(typeof e.refreshToken<"u","internal-error");const n="expiresIn"in e&&typeof e.expiresIn<"u"?Number(e.expiresIn):t0(e.idToken);this.updateTokensAndExpiration(e.idToken,e.refreshToken,n)}updateFromIdToken(e){ne(e.length!==0,"internal-error");const n=t0(e);this.updateTokensAndExpiration(e,null,n)}async getToken(e,n=!1){return!n&&this.accessToken&&!this.isExpired?this.accessToken:(ne(this.refreshToken,e,"user-token-expired"),this.refreshToken?(await this.refresh(e,this.refreshToken),this.accessToken):null)}clearRefreshToken(){this.refreshToken=null}async refresh(e,n){const{accessToken:r,refreshToken:i,expiresIn:s}=await EV(e,n);this.updateTokensAndExpiration(r,i,Number(s))}updateTokensAndExpiration(e,n,r){this.refreshToken=n||null,this.accessToken=e||null,this.expirationTime=Date.now()+r*1e3}static fromJSON(e,n){const{refreshToken:r,accessToken:i,expirationTime:s}=n,o=new $s;return r&&(ne(typeof r=="string","internal-error",{appName:e}),o.refreshToken=r),i&&(ne(typeof i=="string","internal-error",{appName:e}),o.accessToken=i),s&&(ne(typeof s=="number","internal-error",{appName:e}),o.expirationTime=s),o}toJSON(){return{refreshToken:this.refreshToken,accessToken:this.accessToken,expirationTime:this.expirationTime}}_assign(e){this.accessToken=e.accessToken,this.refreshToken=e.refreshToken,this.expirationTime=e.expirationTime}_clone(){return Object.assign(new $s,this.toJSON())}_performRefresh(){return ur("not implemented")}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Or(t,e){ne(typeof t=="string"||typeof t>"u","internal-error",{appName:e})}class cr{constructor(e){var{uid:n,auth:r,stsTokenManager:i}=e,s=Gg(e,["uid","auth","stsTokenManager"]);this.providerId="firebase",this.proactiveRefresh=new yV(this),this.reloadUserInfo=null,this.reloadListener=null,this.uid=n,this.auth=r,this.stsTokenManager=i,this.accessToken=i.accessToken,this.displayName=s.displayName||null,this.email=s.email||null,this.emailVerified=s.emailVerified||!1,this.phoneNumber=s.phoneNumber||null,this.photoURL=s.photoURL||null,this.isAnonymous=s.isAnonymous||!1,this.tenantId=s.tenantId||null,this.providerData=s.providerData?[...s.providerData]:[],this.metadata=new bp(s.createdAt||void 0,s.lastLoginAt||void 0)}async getIdToken(e){const n=await ll(this,this.stsTokenManager.getToken(this.auth,e));return ne(n,this.auth,"internal-error"),this.accessToken!==n&&(this.accessToken=n,await this.auth._persistUserIfCurrent(this),this.auth._notifyListenersIfCurrent(this)),n}getIdTokenResult(e){return gV(this,e)}reload(){return vV(this)}_assign(e){this!==e&&(ne(this.uid===e.uid,this.auth,"internal-error"),this.displayName=e.displayName,this.photoURL=e.photoURL,this.email=e.email,this.emailVerified=e.emailVerified,this.phoneNumber=e.phoneNumber,this.isAnonymous=e.isAnonymous,this.tenantId=e.tenantId,this.providerData=e.providerData.map(n=>Object.assign({},n)),this.metadata._copy(e.metadata),this.stsTokenManager._assign(e.stsTokenManager))}_clone(e){const n=new cr(Object.assign(Object.assign({},this),{auth:e,stsTokenManager:this.stsTokenManager._clone()}));return n.metadata._copy(this.metadata),n}_onReload(e){ne(!this.reloadListener,this.auth,"internal-error"),this.reloadListener=e,this.reloadUserInfo&&(this._notifyReloadListener(this.reloadUserInfo),this.reloadUserInfo=null)}_notifyReloadListener(e){this.reloadListener?this.reloadListener(e):this.reloadUserInfo=e}_startProactiveRefresh(){this.proactiveRefresh._start()}_stopProactiveRefresh(){this.proactiveRefresh._stop()}async _updateTokensIfNecessary(e,n=!1){let r=!1;e.idToken&&e.idToken!==this.stsTokenManager.accessToken&&(this.stsTokenManager.updateFromServerResponse(e),r=!0),n&&await Fc(this),await this.auth._persistUserIfCurrent(this),r&&this.auth._notifyListenersIfCurrent(this)}async delete(){if(ar(this.auth.app))return Promise.reject(oi(this.auth));const e=await this.getIdToken();return await ll(this,mV(this.auth,{idToken:e})),this.stsTokenManager.clearRefreshToken(),this.auth.signOut()}toJSON(){return Object.assign(Object.assign({uid:this.uid,email:this.email||void 0,emailVerified:this.emailVerified,displayName:this.displayName||void 0,isAnonymous:this.isAnonymous,photoURL:this.photoURL||void 0,phoneNumber:this.phoneNumber||void 0,tenantId:this.tenantId||void 0,providerData:this.providerData.map(e=>Object.assign({},e)),stsTokenManager:this.stsTokenManager.toJSON(),_redirectEventId:this._redirectEventId},this.metadata.toJSON()),{apiKey:this.auth.config.apiKey,appName:this.auth.name})}get refreshToken(){return this.stsTokenManager.refreshToken||""}static _fromJSON(e,n){var r,i,s,o,a,u,c,d;const f=(r=n.displayName)!==null&&r!==void 0?r:void 0,m=(i=n.email)!==null&&i!==void 0?i:void 0,w=(s=n.phoneNumber)!==null&&s!==void 0?s:void 0,I=(o=n.photoURL)!==null&&o!==void 0?o:void 0,P=(a=n.tenantId)!==null&&a!==void 0?a:void 0,O=(u=n._redirectEventId)!==null&&u!==void 0?u:void 0,C=(c=n.createdAt)!==null&&c!==void 0?c:void 0,T=(d=n.lastLoginAt)!==null&&d!==void 0?d:void 0,{uid:S,emailVerified:M,isAnonymous:V,providerData:F,stsTokenManager:y}=n;ne(S&&y,e,"internal-error");const g=$s.fromJSON(this.name,y);ne(typeof S=="string",e,"internal-error"),Or(f,e.name),Or(m,e.name),ne(typeof M=="boolean",e,"internal-error"),ne(typeof V=="boolean",e,"internal-error"),Or(w,e.name),Or(I,e.name),Or(P,e.name),Or(O,e.name),Or(C,e.name),Or(T,e.name);const E=new cr({uid:S,auth:e,email:m,emailVerified:M,displayName:f,isAnonymous:V,photoURL:I,phoneNumber:w,tenantId:P,stsTokenManager:g,createdAt:C,lastLoginAt:T});return F&&Array.isArray(F)&&(E.providerData=F.map(k=>Object.assign({},k))),O&&(E._redirectEventId=O),E}static async _fromIdTokenResponse(e,n,r=!1){const i=new $s;i.updateFromServerResponse(n);const s=new cr({uid:n.localId,auth:e,stsTokenManager:i,isAnonymous:r});return await Fc(s),s}static async _fromGetAccountInfoResponse(e,n,r){const i=n.users[0];ne(i.localId!==void 0,"internal-error");const s=i.providerUserInfo!==void 0?o1(i.providerUserInfo):[],o=!(i.email&&i.passwordHash)&&!(s!=null&&s.length),a=new $s;a.updateFromIdToken(r);const u=new cr({uid:i.localId,auth:e,stsTokenManager:a,isAnonymous:o}),c={uid:i.localId,displayName:i.displayName||null,photoURL:i.photoUrl||null,email:i.email||null,emailVerified:i.emailVerified||!1,phoneNumber:i.phoneNumber||null,tenantId:i.tenantId||null,providerData:s,metadata:new bp(i.createdAt,i.lastLoginAt),isAnonymous:!(i.email&&i.passwordHash)&&!(s!=null&&s.length)};return Object.assign(u,c),u}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const n0=new Map;function hr(t){Cr(t instanceof Function,"Expected a class definition");let e=n0.get(t);return e?(Cr(e instanceof t,"Instance stored in cache mismatched with class"),e):(e=new t,n0.set(t,e),e)}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class a1{constructor(){this.type="NONE",this.storage={}}async _isAvailable(){return!0}async _set(e,n){this.storage[e]=n}async _get(e){const n=this.storage[e];return n===void 0?null:n}async _remove(e){delete this.storage[e]}_addListener(e,n){}_removeListener(e,n){}}a1.type="NONE";const r0=a1;/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function $u(t,e,n){return`firebase:${t}:${e}:${n}`}class Ws{constructor(e,n,r){this.persistence=e,this.auth=n,this.userKey=r;const{config:i,name:s}=this.auth;this.fullUserKey=$u(this.userKey,i.apiKey,s),this.fullPersistenceKey=$u("persistence",i.apiKey,s),this.boundEventHandler=n._onStorageEvent.bind(n),this.persistence._addListener(this.fullUserKey,this.boundEventHandler)}setCurrentUser(e){return this.persistence._set(this.fullUserKey,e.toJSON())}async getCurrentUser(){const e=await this.persistence._get(this.fullUserKey);return e?cr._fromJSON(this.auth,e):null}removeCurrentUser(){return this.persistence._remove(this.fullUserKey)}savePersistenceForRedirect(){return this.persistence._set(this.fullPersistenceKey,this.persistence.type)}async setPersistence(e){if(this.persistence===e)return;const n=await this.getCurrentUser();if(await this.removeCurrentUser(),this.persistence=e,n)return this.setCurrentUser(n)}delete(){this.persistence._removeListener(this.fullUserKey,this.boundEventHandler)}static async create(e,n,r="authUser"){if(!n.length)return new Ws(hr(r0),e,r);const i=(await Promise.all(n.map(async c=>{if(await c._isAvailable())return c}))).filter(c=>c);let s=i[0]||hr(r0);const o=$u(r,e.config.apiKey,e.name);let a=null;for(const c of n)try{const d=await c._get(o);if(d){const f=cr._fromJSON(e,d);c!==s&&(a=f),s=c;break}}catch{}const u=i.filter(c=>c._shouldAllowMigration);return!s._shouldAllowMigration||!u.length?new Ws(s,e,r):(s=u[0],a&&await s._set(o,a.toJSON()),await Promise.all(n.map(async c=>{if(c!==s)try{await c._remove(o)}catch{}})),new Ws(s,e,r))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function i0(t){const e=t.toLowerCase();if(e.includes("opera/")||e.includes("opr/")||e.includes("opios/"))return"Opera";if(h1(e))return"IEMobile";if(e.includes("msie")||e.includes("trident/"))return"IE";if(e.includes("edge/"))return"Edge";if(l1(e))return"Firefox";if(e.includes("silk/"))return"Silk";if(f1(e))return"Blackberry";if(p1(e))return"Webos";if(u1(e))return"Safari";if((e.includes("chrome/")||c1(e))&&!e.includes("edge/"))return"Chrome";if(d1(e))return"Android";{const n=/([a-zA-Z\d\.]+)\/[a-zA-Z\d\.]*$/,r=t.match(n);if((r==null?void 0:r.length)===2)return r[1]}return"Other"}function l1(t=Ft()){return/firefox\//i.test(t)}function u1(t=Ft()){const e=t.toLowerCase();return e.includes("safari/")&&!e.includes("chrome/")&&!e.includes("crios/")&&!e.includes("android")}function c1(t=Ft()){return/crios\//i.test(t)}function h1(t=Ft()){return/iemobile/i.test(t)}function d1(t=Ft()){return/android/i.test(t)}function f1(t=Ft()){return/blackberry/i.test(t)}function p1(t=Ft()){return/webos/i.test(t)}function Xg(t=Ft()){return/iphone|ipad|ipod/i.test(t)||/macintosh/i.test(t)&&/mobile/i.test(t)}function IV(t=Ft()){var e;return Xg(t)&&!!(!((e=window.navigator)===null||e===void 0)&&e.standalone)}function SV(){return Tx()&&document.documentMode===10}function m1(t=Ft()){return Xg(t)||d1(t)||p1(t)||f1(t)||/windows phone/i.test(t)||h1(t)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function g1(t,e=[]){let n;switch(t){case"Browser":n=i0(Ft());break;case"Worker":n=`${i0(Ft())}-${t}`;break;default:n=t}const r=e.length?e.join(","):"FirebaseCore-web";return`${n}/JsCore/${yi}/${r}`}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class kV{constructor(e){this.auth=e,this.queue=[]}pushCallback(e,n){const r=s=>new Promise((o,a)=>{try{const u=e(s);o(u)}catch(u){a(u)}});r.onAbort=n,this.queue.push(r);const i=this.queue.length-1;return()=>{this.queue[i]=()=>Promise.resolve()}}async runMiddleware(e){if(this.auth.currentUser===e)return;const n=[];try{for(const r of this.queue)await r(e),r.onAbort&&n.push(r.onAbort)}catch(r){n.reverse();for(const i of n)try{i()}catch{}throw this.auth._errorFactory.create("login-blocked",{originalMessage:r==null?void 0:r.message})}}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function CV(t,e={}){return So(t,"GET","/v2/passwordPolicy",bh(t,e))}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const RV=6;class AV{constructor(e){var n,r,i,s;const o=e.customStrengthOptions;this.customStrengthOptions={},this.customStrengthOptions.minPasswordLength=(n=o.minPasswordLength)!==null&&n!==void 0?n:RV,o.maxPasswordLength&&(this.customStrengthOptions.maxPasswordLength=o.maxPasswordLength),o.containsLowercaseCharacter!==void 0&&(this.customStrengthOptions.containsLowercaseLetter=o.containsLowercaseCharacter),o.containsUppercaseCharacter!==void 0&&(this.customStrengthOptions.containsUppercaseLetter=o.containsUppercaseCharacter),o.containsNumericCharacter!==void 0&&(this.customStrengthOptions.containsNumericCharacter=o.containsNumericCharacter),o.containsNonAlphanumericCharacter!==void 0&&(this.customStrengthOptions.containsNonAlphanumericCharacter=o.containsNonAlphanumericCharacter),this.enforcementState=e.enforcementState,this.enforcementState==="ENFORCEMENT_STATE_UNSPECIFIED"&&(this.enforcementState="OFF"),this.allowedNonAlphanumericCharacters=(i=(r=e.allowedNonAlphanumericCharacters)===null||r===void 0?void 0:r.join(""))!==null&&i!==void 0?i:"",this.forceUpgradeOnSignin=(s=e.forceUpgradeOnSignin)!==null&&s!==void 0?s:!1,this.schemaVersion=e.schemaVersion}validatePassword(e){var n,r,i,s,o,a;const u={isValid:!0,passwordPolicy:this};return this.validatePasswordLengthOptions(e,u),this.validatePasswordCharacterOptions(e,u),u.isValid&&(u.isValid=(n=u.meetsMinPasswordLength)!==null&&n!==void 0?n:!0),u.isValid&&(u.isValid=(r=u.meetsMaxPasswordLength)!==null&&r!==void 0?r:!0),u.isValid&&(u.isValid=(i=u.containsLowercaseLetter)!==null&&i!==void 0?i:!0),u.isValid&&(u.isValid=(s=u.containsUppercaseLetter)!==null&&s!==void 0?s:!0),u.isValid&&(u.isValid=(o=u.containsNumericCharacter)!==null&&o!==void 0?o:!0),u.isValid&&(u.isValid=(a=u.containsNonAlphanumericCharacter)!==null&&a!==void 0?a:!0),u}validatePasswordLengthOptions(e,n){const r=this.customStrengthOptions.minPasswordLength,i=this.customStrengthOptions.maxPasswordLength;r&&(n.meetsMinPasswordLength=e.length>=r),i&&(n.meetsMaxPasswordLength=e.length<=i)}validatePasswordCharacterOptions(e,n){this.updatePasswordCharacterOptionsStatuses(n,!1,!1,!1,!1);let r;for(let i=0;i<e.length;i++)r=e.charAt(i),this.updatePasswordCharacterOptionsStatuses(n,r>="a"&&r<="z",r>="A"&&r<="Z",r>="0"&&r<="9",this.allowedNonAlphanumericCharacters.includes(r))}updatePasswordCharacterOptionsStatuses(e,n,r,i,s){this.customStrengthOptions.containsLowercaseLetter&&(e.containsLowercaseLetter||(e.containsLowercaseLetter=n)),this.customStrengthOptions.containsUppercaseLetter&&(e.containsUppercaseLetter||(e.containsUppercaseLetter=r)),this.customStrengthOptions.containsNumericCharacter&&(e.containsNumericCharacter||(e.containsNumericCharacter=i)),this.customStrengthOptions.containsNonAlphanumericCharacter&&(e.containsNonAlphanumericCharacter||(e.containsNonAlphanumericCharacter=s))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class xV{constructor(e,n,r,i){this.app=e,this.heartbeatServiceProvider=n,this.appCheckServiceProvider=r,this.config=i,this.currentUser=null,this.emulatorConfig=null,this.operations=Promise.resolve(),this.authStateSubscription=new s0(this),this.idTokenSubscription=new s0(this),this.beforeStateQueue=new kV(this),this.redirectUser=null,this.isProactiveRefreshEnabled=!1,this.EXPECTED_PASSWORD_POLICY_SCHEMA_VERSION=1,this._canInitEmulator=!0,this._isInitialized=!1,this._deleted=!1,this._initializationPromise=null,this._popupRedirectResolver=null,this._errorFactory=Zk,this._agentRecaptchaConfig=null,this._tenantRecaptchaConfigs={},this._projectPasswordPolicy=null,this._tenantPasswordPolicies={},this.lastNotifiedUid=void 0,this.languageCode=null,this.tenantId=null,this.settings={appVerificationDisabledForTesting:!1},this.frameworks=[],this.name=e.name,this.clientVersion=i.sdkClientVersion}_initializeWithPersistence(e,n){return n&&(this._popupRedirectResolver=hr(n)),this._initializationPromise=this.queue(async()=>{var r,i;if(!this._deleted&&(this.persistenceManager=await Ws.create(this,e),!this._deleted)){if(!((r=this._popupRedirectResolver)===null||r===void 0)&&r._shouldInitProactively)try{await this._popupRedirectResolver._initialize(this)}catch{}await this.initializeCurrentUser(n),this.lastNotifiedUid=((i=this.currentUser)===null||i===void 0?void 0:i.uid)||null,!this._deleted&&(this._isInitialized=!0)}}),this._initializationPromise}async _onStorageEvent(){if(this._deleted)return;const e=await this.assertedPersistence.getCurrentUser();if(!(!this.currentUser&&!e)){if(this.currentUser&&e&&this.currentUser.uid===e.uid){this._currentUser._assign(e),await this.currentUser.getIdToken();return}await this._updateCurrentUser(e,!0)}}async initializeCurrentUserFromIdToken(e){try{const n=await s1(this,{idToken:e}),r=await cr._fromGetAccountInfoResponse(this,n,e);await this.directlySetCurrentUser(r)}catch(n){console.warn("FirebaseServerApp could not login user with provided authIdToken: ",n),await this.directlySetCurrentUser(null)}}async initializeCurrentUser(e){var n;if(ar(this.app)){const o=this.app.settings.authIdToken;return o?new Promise(a=>{setTimeout(()=>this.initializeCurrentUserFromIdToken(o).then(a,a))}):this.directlySetCurrentUser(null)}const r=await this.assertedPersistence.getCurrentUser();let i=r,s=!1;if(e&&this.config.authDomain){await this.getOrInitRedirectPersistenceManager();const o=(n=this.redirectUser)===null||n===void 0?void 0:n._redirectEventId,a=i==null?void 0:i._redirectEventId,u=await this.tryRedirectSignIn(e);(!o||o===a)&&(u!=null&&u.user)&&(i=u.user,s=!0)}if(!i)return this.directlySetCurrentUser(null);if(!i._redirectEventId){if(s)try{await this.beforeStateQueue.runMiddleware(i)}catch(o){i=r,this._popupRedirectResolver._overrideRedirectResult(this,()=>Promise.reject(o))}return i?this.reloadAndSetCurrentUserOrClear(i):this.directlySetCurrentUser(null)}return ne(this._popupRedirectResolver,this,"argument-error"),await this.getOrInitRedirectPersistenceManager(),this.redirectUser&&this.redirectUser._redirectEventId===i._redirectEventId?this.directlySetCurrentUser(i):this.reloadAndSetCurrentUserOrClear(i)}async tryRedirectSignIn(e){let n=null;try{n=await this._popupRedirectResolver._completeRedirectFn(this,e,!0)}catch{await this._setRedirectUser(null)}return n}async reloadAndSetCurrentUserOrClear(e){try{await Fc(e)}catch(n){if((n==null?void 0:n.code)!=="auth/network-request-failed")return this.directlySetCurrentUser(null)}return this.directlySetCurrentUser(e)}useDeviceLanguage(){this.languageCode=hV()}async _delete(){this._deleted=!0}async updateCurrentUser(e){if(ar(this.app))return Promise.reject(oi(this));const n=e?Qe(e):null;return n&&ne(n.auth.config.apiKey===this.config.apiKey,this,"invalid-user-token"),this._updateCurrentUser(n&&n._clone(this))}async _updateCurrentUser(e,n=!1){if(!this._deleted)return e&&ne(this.tenantId===e.tenantId,this,"tenant-id-mismatch"),n||await this.beforeStateQueue.runMiddleware(e),this.queue(async()=>{await this.directlySetCurrentUser(e),this.notifyAuthListeners()})}async signOut(){return ar(this.app)?Promise.reject(oi(this)):(await this.beforeStateQueue.runMiddleware(null),(this.redirectPersistenceManager||this._popupRedirectResolver)&&await this._setRedirectUser(null),this._updateCurrentUser(null,!0))}setPersistence(e){return ar(this.app)?Promise.reject(oi(this)):this.queue(async()=>{await this.assertedPersistence.setPersistence(hr(e))})}_getRecaptchaConfig(){return this.tenantId==null?this._agentRecaptchaConfig:this._tenantRecaptchaConfigs[this.tenantId]}async validatePassword(e){this._getPasswordPolicyInternal()||await this._updatePasswordPolicy();const n=this._getPasswordPolicyInternal();return n.schemaVersion!==this.EXPECTED_PASSWORD_POLICY_SCHEMA_VERSION?Promise.reject(this._errorFactory.create("unsupported-password-policy-schema-version",{})):n.validatePassword(e)}_getPasswordPolicyInternal(){return this.tenantId===null?this._projectPasswordPolicy:this._tenantPasswordPolicies[this.tenantId]}async _updatePasswordPolicy(){const e=await CV(this),n=new AV(e);this.tenantId===null?this._projectPasswordPolicy=n:this._tenantPasswordPolicies[this.tenantId]=n}_getPersistence(){return this.assertedPersistence.persistence.type}_updateErrorMap(e){this._errorFactory=new pl("auth","Firebase",e())}onAuthStateChanged(e,n,r){return this.registerStateListener(this.authStateSubscription,e,n,r)}beforeAuthStateChanged(e,n){return this.beforeStateQueue.pushCallback(e,n)}onIdTokenChanged(e,n,r){return this.registerStateListener(this.idTokenSubscription,e,n,r)}authStateReady(){return new Promise((e,n)=>{if(this.currentUser)e();else{const r=this.onAuthStateChanged(()=>{r(),e()},n)}})}async revokeAccessToken(e){if(this.currentUser){const n=await this.currentUser.getIdToken(),r={providerId:"apple.com",tokenType:"ACCESS_TOKEN",token:e,idToken:n};this.tenantId!=null&&(r.tenantId=this.tenantId),await TV(this,r)}}toJSON(){var e;return{apiKey:this.config.apiKey,authDomain:this.config.authDomain,appName:this.name,currentUser:(e=this._currentUser)===null||e===void 0?void 0:e.toJSON()}}async _setRedirectUser(e,n){const r=await this.getOrInitRedirectPersistenceManager(n);return e===null?r.removeCurrentUser():r.setCurrentUser(e)}async getOrInitRedirectPersistenceManager(e){if(!this.redirectPersistenceManager){const n=e&&hr(e)||this._popupRedirectResolver;ne(n,this,"argument-error"),this.redirectPersistenceManager=await Ws.create(this,[hr(n._redirectPersistence)],"redirectUser"),this.redirectUser=await this.redirectPersistenceManager.getCurrentUser()}return this.redirectPersistenceManager}async _redirectUserForId(e){var n,r;return this._isInitialized&&await this.queue(async()=>{}),((n=this._currentUser)===null||n===void 0?void 0:n._redirectEventId)===e?this._currentUser:((r=this.redirectUser)===null||r===void 0?void 0:r._redirectEventId)===e?this.redirectUser:null}async _persistUserIfCurrent(e){if(e===this.currentUser)return this.queue(async()=>this.directlySetCurrentUser(e))}_notifyListenersIfCurrent(e){e===this.currentUser&&this.notifyAuthListeners()}_key(){return`${this.config.authDomain}:${this.config.apiKey}:${this.name}`}_startProactiveRefresh(){this.isProactiveRefreshEnabled=!0,this.currentUser&&this._currentUser._startProactiveRefresh()}_stopProactiveRefresh(){this.isProactiveRefreshEnabled=!1,this.currentUser&&this._currentUser._stopProactiveRefresh()}get _currentUser(){return this.currentUser}notifyAuthListeners(){var e,n;if(!this._isInitialized)return;this.idTokenSubscription.next(this.currentUser);const r=(n=(e=this.currentUser)===null||e===void 0?void 0:e.uid)!==null&&n!==void 0?n:null;this.lastNotifiedUid!==r&&(this.lastNotifiedUid=r,this.authStateSubscription.next(this.currentUser))}registerStateListener(e,n,r,i){if(this._deleted)return()=>{};const s=typeof n=="function"?n:n.next.bind(n);let o=!1;const a=this._isInitialized?Promise.resolve():this._initializationPromise;if(ne(a,this,"internal-error"),a.then(()=>{o||s(this.currentUser)}),typeof n=="function"){const u=e.addObserver(n,r,i);return()=>{o=!0,u()}}else{const u=e.addObserver(n);return()=>{o=!0,u()}}}async directlySetCurrentUser(e){this.currentUser&&this.currentUser!==e&&this._currentUser._stopProactiveRefresh(),e&&this.isProactiveRefreshEnabled&&e._startProactiveRefresh(),this.currentUser=e,e?await this.assertedPersistence.setCurrentUser(e):await this.assertedPersistence.removeCurrentUser()}queue(e){return this.operations=this.operations.then(e,e),this.operations}get assertedPersistence(){return ne(this.persistenceManager,this,"internal-error"),this.persistenceManager}_logFramework(e){!e||this.frameworks.includes(e)||(this.frameworks.push(e),this.frameworks.sort(),this.clientVersion=g1(this.config.clientPlatform,this._getFrameworks()))}_getFrameworks(){return this.frameworks}async _getAdditionalHeaders(){var e;const n={"X-Client-Version":this.clientVersion};this.app.options.appId&&(n["X-Firebase-gmpid"]=this.app.options.appId);const r=await((e=this.heartbeatServiceProvider.getImmediate({optional:!0}))===null||e===void 0?void 0:e.getHeartbeatsHeader());r&&(n["X-Firebase-Client"]=r);const i=await this._getAppCheckToken();return i&&(n["X-Firebase-AppCheck"]=i),n}async _getAppCheckToken(){var e;const n=await((e=this.appCheckServiceProvider.getImmediate({optional:!0}))===null||e===void 0?void 0:e.getToken());return n!=null&&n.error&&lV(`Error while retrieving App Check token: ${n.error}`),n==null?void 0:n.token}}function Nh(t){return Qe(t)}class s0{constructor(e){this.auth=e,this.observer=null,this.addObserver=Ox(n=>this.observer=n)}get next(){return ne(this.observer,this.auth,"internal-error"),this.observer.next.bind(this.observer)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Jg={async loadJS(){throw new Error("Unable to load external scripts")},recaptchaV2Script:"",recaptchaEnterpriseScript:"",gapiScript:""};function PV(t){Jg=t}function bV(t){return Jg.loadJS(t)}function NV(){return Jg.gapiScript}function OV(t){return`__${t}${Math.floor(Math.random()*1e6)}`}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function DV(t,e){const n=ml(t,"auth");if(n.isInitialized()){const i=n.getImmediate(),s=n.getOptions();if(vc(s,e??{}))return i;kr(i,"already-initialized")}return n.initialize({options:e})}function MV(t,e){const n=(e==null?void 0:e.persistence)||[],r=(Array.isArray(n)?n:[n]).map(hr);e!=null&&e.errorMap&&t._updateErrorMap(e.errorMap),t._initializeWithPersistence(r,e==null?void 0:e.popupRedirectResolver)}function LV(t,e,n){const r=Nh(t);ne(r._canInitEmulator,r,"emulator-config-failed"),ne(/^https?:\/\//.test(e),r,"invalid-emulator-scheme");const i=!1,s=_1(e),{host:o,port:a}=VV(e),u=a===null?"":`:${a}`;r.config.emulator={url:`${s}//${o}${u}/`},r.settings.appVerificationDisabledForTesting=!0,r.emulatorConfig=Object.freeze({host:o,port:a,protocol:s.replace(":",""),options:Object.freeze({disableWarnings:i})}),FV()}function _1(t){const e=t.indexOf(":");return e<0?"":t.substr(0,e+1)}function VV(t){const e=_1(t),n=/(\/\/)?([^?#/]+)/.exec(t.substr(e.length));if(!n)return{host:"",port:null};const r=n[2].split("@").pop()||"",i=/^(\[[^\]]+\])(:|$)/.exec(r);if(i){const s=i[1];return{host:s,port:o0(r.substr(s.length+1))}}else{const[s,o]=r.split(":");return{host:s,port:o0(o)}}}function o0(t){if(!t)return null;const e=Number(t);return isNaN(e)?null:e}function FV(){function t(){const e=document.createElement("p"),n=e.style;e.innerText="Running in emulator mode. Do not use with production credentials.",n.position="fixed",n.width="100%",n.backgroundColor="#ffffff",n.border=".1em solid #000000",n.color="#b50000",n.bottom="0px",n.left="0px",n.margin="0px",n.zIndex="10000",n.textAlign="center",e.classList.add("firebase-emulator-warning"),document.body.appendChild(e)}typeof console<"u"&&typeof console.info=="function"&&console.info("WARNING: You are using the Auth Emulator, which is intended for local testing only.  Do not use with production credentials."),typeof window<"u"&&typeof document<"u"&&(document.readyState==="loading"?window.addEventListener("DOMContentLoaded",t):t())}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class y1{constructor(e,n){this.providerId=e,this.signInMethod=n}toJSON(){return ur("not implemented")}_getIdTokenResponse(e){return ur("not implemented")}_linkToIdToken(e,n){return ur("not implemented")}_getReauthenticationResolver(e){return ur("not implemented")}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function qs(t,e){return r1(t,"POST","/v1/accounts:signInWithIdp",bh(t,e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const UV="http://localhost";class Xi extends y1{constructor(){super(...arguments),this.pendingToken=null}static _fromParams(e){const n=new Xi(e.providerId,e.signInMethod);return e.idToken||e.accessToken?(e.idToken&&(n.idToken=e.idToken),e.accessToken&&(n.accessToken=e.accessToken),e.nonce&&!e.pendingToken&&(n.nonce=e.nonce),e.pendingToken&&(n.pendingToken=e.pendingToken)):e.oauthToken&&e.oauthTokenSecret?(n.accessToken=e.oauthToken,n.secret=e.oauthTokenSecret):kr("argument-error"),n}toJSON(){return{idToken:this.idToken,accessToken:this.accessToken,secret:this.secret,nonce:this.nonce,pendingToken:this.pendingToken,providerId:this.providerId,signInMethod:this.signInMethod}}static fromJSON(e){const n=typeof e=="string"?JSON.parse(e):e,{providerId:r,signInMethod:i}=n,s=Gg(n,["providerId","signInMethod"]);if(!r||!i)return null;const o=new Xi(r,i);return o.idToken=s.idToken||void 0,o.accessToken=s.accessToken||void 0,o.secret=s.secret,o.nonce=s.nonce,o.pendingToken=s.pendingToken||null,o}_getIdTokenResponse(e){const n=this.buildRequest();return qs(e,n)}_linkToIdToken(e,n){const r=this.buildRequest();return r.idToken=n,qs(e,r)}_getReauthenticationResolver(e){const n=this.buildRequest();return n.autoCreate=!1,qs(e,n)}buildRequest(){const e={requestUri:UV,returnSecureToken:!0};if(this.pendingToken)e.pendingToken=this.pendingToken;else{const n={};this.idToken&&(n.id_token=this.idToken),this.accessToken&&(n.access_token=this.accessToken),this.secret&&(n.oauth_token_secret=this.secret),n.providerId=this.providerId,this.nonce&&!this.pendingToken&&(n.nonce=this.nonce),e.postBody=po(n)}return e}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class v1{constructor(e){this.providerId=e,this.defaultLanguageCode=null,this.customParameters={}}setDefaultLanguage(e){this.defaultLanguageCode=e}setCustomParameters(e){return this.customParameters=e,this}getCustomParameters(){return this.customParameters}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Al extends v1{constructor(){super(...arguments),this.scopes=[]}addScope(e){return this.scopes.includes(e)||this.scopes.push(e),this}getScopes(){return[...this.scopes]}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ur extends Al{constructor(){super("facebook.com")}static credential(e){return Xi._fromParams({providerId:Ur.PROVIDER_ID,signInMethod:Ur.FACEBOOK_SIGN_IN_METHOD,accessToken:e})}static credentialFromResult(e){return Ur.credentialFromTaggedObject(e)}static credentialFromError(e){return Ur.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e||!("oauthAccessToken"in e)||!e.oauthAccessToken)return null;try{return Ur.credential(e.oauthAccessToken)}catch{return null}}}Ur.FACEBOOK_SIGN_IN_METHOD="facebook.com";Ur.PROVIDER_ID="facebook.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jr extends Al{constructor(){super("google.com"),this.addScope("profile")}static credential(e,n){return Xi._fromParams({providerId:jr.PROVIDER_ID,signInMethod:jr.GOOGLE_SIGN_IN_METHOD,idToken:e,accessToken:n})}static credentialFromResult(e){return jr.credentialFromTaggedObject(e)}static credentialFromError(e){return jr.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e)return null;const{oauthIdToken:n,oauthAccessToken:r}=e;if(!n&&!r)return null;try{return jr.credential(n,r)}catch{return null}}}jr.GOOGLE_SIGN_IN_METHOD="google.com";jr.PROVIDER_ID="google.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zr extends Al{constructor(){super("github.com")}static credential(e){return Xi._fromParams({providerId:zr.PROVIDER_ID,signInMethod:zr.GITHUB_SIGN_IN_METHOD,accessToken:e})}static credentialFromResult(e){return zr.credentialFromTaggedObject(e)}static credentialFromError(e){return zr.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e||!("oauthAccessToken"in e)||!e.oauthAccessToken)return null;try{return zr.credential(e.oauthAccessToken)}catch{return null}}}zr.GITHUB_SIGN_IN_METHOD="github.com";zr.PROVIDER_ID="github.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Br extends Al{constructor(){super("twitter.com")}static credential(e,n){return Xi._fromParams({providerId:Br.PROVIDER_ID,signInMethod:Br.TWITTER_SIGN_IN_METHOD,oauthToken:e,oauthTokenSecret:n})}static credentialFromResult(e){return Br.credentialFromTaggedObject(e)}static credentialFromError(e){return Br.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e)return null;const{oauthAccessToken:n,oauthTokenSecret:r}=e;if(!n||!r)return null;try{return Br.credential(n,r)}catch{return null}}}Br.TWITTER_SIGN_IN_METHOD="twitter.com";Br.PROVIDER_ID="twitter.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function jV(t,e){return r1(t,"POST","/v1/accounts:signUp",bh(t,e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class pi{constructor(e){this.user=e.user,this.providerId=e.providerId,this._tokenResponse=e._tokenResponse,this.operationType=e.operationType}static async _fromIdTokenResponse(e,n,r,i=!1){const s=await cr._fromIdTokenResponse(e,r,i),o=a0(r);return new pi({user:s,providerId:o,_tokenResponse:r,operationType:n})}static async _forOperation(e,n,r){await e._updateTokensIfNecessary(r,!0);const i=a0(r);return new pi({user:e,providerId:i,_tokenResponse:r,operationType:n})}}function a0(t){return t.providerId?t.providerId:"phoneNumber"in t?"phone":null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function zV(t){var e;if(ar(t.app))return Promise.reject(oi(t));const n=Nh(t);if(await n._initializationPromise,!((e=n.currentUser)===null||e===void 0)&&e.isAnonymous)return new pi({user:n.currentUser,providerId:null,operationType:"signIn"});const r=await jV(n,{returnSecureToken:!0}),i=await pi._fromIdTokenResponse(n,"signIn",r,!0);return await n._updateCurrentUser(i.user),i}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Uc extends Zn{constructor(e,n,r,i){var s;super(n.code,n.message),this.operationType=r,this.user=i,Object.setPrototypeOf(this,Uc.prototype),this.customData={appName:e.name,tenantId:(s=e.tenantId)!==null&&s!==void 0?s:void 0,_serverResponse:n.customData._serverResponse,operationType:r}}static _fromErrorAndOperation(e,n,r,i){return new Uc(e,n,r,i)}}function w1(t,e,n,r){return(e==="reauthenticate"?n._getReauthenticationResolver(t):n._getIdTokenResponse(t)).catch(s=>{throw s.code==="auth/multi-factor-auth-required"?Uc._fromErrorAndOperation(t,s,e,r):s})}async function BV(t,e,n=!1){const r=await ll(t,e._linkToIdToken(t.auth,await t.getIdToken()),n);return pi._forOperation(t,"link",r)}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function $V(t,e,n=!1){const{auth:r}=t;if(ar(r.app))return Promise.reject(oi(r));const i="reauthenticate";try{const s=await ll(t,w1(r,i,e,t),n);ne(s.idToken,r,"internal-error");const o=Yg(s.idToken);ne(o,r,"internal-error");const{sub:a}=o;return ne(t.uid===a,r,"user-mismatch"),pi._forOperation(t,i,s)}catch(s){throw(s==null?void 0:s.code)==="auth/user-not-found"&&kr(r,"user-mismatch"),s}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function WV(t,e,n=!1){if(ar(t.app))return Promise.reject(oi(t));const r="signIn",i=await w1(t,r,e),s=await pi._fromIdTokenResponse(t,r,i);return n||await t._updateCurrentUser(s.user),s}function qV(t,e,n,r){return Qe(t).onIdTokenChanged(e,n,r)}function HV(t,e,n){return Qe(t).beforeAuthStateChanged(e,n)}const jc="__sak";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class E1{constructor(e,n){this.storageRetriever=e,this.type=n}_isAvailable(){try{return this.storage?(this.storage.setItem(jc,"1"),this.storage.removeItem(jc),Promise.resolve(!0)):Promise.resolve(!1)}catch{return Promise.resolve(!1)}}_set(e,n){return this.storage.setItem(e,JSON.stringify(n)),Promise.resolve()}_get(e){const n=this.storage.getItem(e);return Promise.resolve(n?JSON.parse(n):null)}_remove(e){return this.storage.removeItem(e),Promise.resolve()}get storage(){return this.storageRetriever()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const GV=1e3,KV=10;class T1 extends E1{constructor(){super(()=>window.localStorage,"LOCAL"),this.boundEventHandler=(e,n)=>this.onStorageEvent(e,n),this.listeners={},this.localCache={},this.pollTimer=null,this.fallbackToPolling=m1(),this._shouldAllowMigration=!0}forAllChangedKeys(e){for(const n of Object.keys(this.listeners)){const r=this.storage.getItem(n),i=this.localCache[n];r!==i&&e(n,i,r)}}onStorageEvent(e,n=!1){if(!e.key){this.forAllChangedKeys((o,a,u)=>{this.notifyListeners(o,u)});return}const r=e.key;n?this.detachListener():this.stopPolling();const i=()=>{const o=this.storage.getItem(r);!n&&this.localCache[r]===o||this.notifyListeners(r,o)},s=this.storage.getItem(r);SV()&&s!==e.newValue&&e.newValue!==e.oldValue?setTimeout(i,KV):i()}notifyListeners(e,n){this.localCache[e]=n;const r=this.listeners[e];if(r)for(const i of Array.from(r))i(n&&JSON.parse(n))}startPolling(){this.stopPolling(),this.pollTimer=setInterval(()=>{this.forAllChangedKeys((e,n,r)=>{this.onStorageEvent(new StorageEvent("storage",{key:e,oldValue:n,newValue:r}),!0)})},GV)}stopPolling(){this.pollTimer&&(clearInterval(this.pollTimer),this.pollTimer=null)}attachListener(){window.addEventListener("storage",this.boundEventHandler)}detachListener(){window.removeEventListener("storage",this.boundEventHandler)}_addListener(e,n){Object.keys(this.listeners).length===0&&(this.fallbackToPolling?this.startPolling():this.attachListener()),this.listeners[e]||(this.listeners[e]=new Set,this.localCache[e]=this.storage.getItem(e)),this.listeners[e].add(n)}_removeListener(e,n){this.listeners[e]&&(this.listeners[e].delete(n),this.listeners[e].size===0&&delete this.listeners[e]),Object.keys(this.listeners).length===0&&(this.detachListener(),this.stopPolling())}async _set(e,n){await super._set(e,n),this.localCache[e]=JSON.stringify(n)}async _get(e){const n=await super._get(e);return this.localCache[e]=JSON.stringify(n),n}async _remove(e){await super._remove(e),delete this.localCache[e]}}T1.type="LOCAL";const QV=T1;/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class I1 extends E1{constructor(){super(()=>window.sessionStorage,"SESSION")}_addListener(e,n){}_removeListener(e,n){}}I1.type="SESSION";const S1=I1;/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function YV(t){return Promise.all(t.map(async e=>{try{return{fulfilled:!0,value:await e}}catch(n){return{fulfilled:!1,reason:n}}}))}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Oh{constructor(e){this.eventTarget=e,this.handlersMap={},this.boundEventHandler=this.handleEvent.bind(this)}static _getInstance(e){const n=this.receivers.find(i=>i.isListeningto(e));if(n)return n;const r=new Oh(e);return this.receivers.push(r),r}isListeningto(e){return this.eventTarget===e}async handleEvent(e){const n=e,{eventId:r,eventType:i,data:s}=n.data,o=this.handlersMap[i];if(!(o!=null&&o.size))return;n.ports[0].postMessage({status:"ack",eventId:r,eventType:i});const a=Array.from(o).map(async c=>c(n.origin,s)),u=await YV(a);n.ports[0].postMessage({status:"done",eventId:r,eventType:i,response:u})}_subscribe(e,n){Object.keys(this.handlersMap).length===0&&this.eventTarget.addEventListener("message",this.boundEventHandler),this.handlersMap[e]||(this.handlersMap[e]=new Set),this.handlersMap[e].add(n)}_unsubscribe(e,n){this.handlersMap[e]&&n&&this.handlersMap[e].delete(n),(!n||this.handlersMap[e].size===0)&&delete this.handlersMap[e],Object.keys(this.handlersMap).length===0&&this.eventTarget.removeEventListener("message",this.boundEventHandler)}}Oh.receivers=[];/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Zg(t="",e=10){let n="";for(let r=0;r<e;r++)n+=Math.floor(Math.random()*10);return t+n}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class XV{constructor(e){this.target=e,this.handlers=new Set}removeMessageHandler(e){e.messageChannel&&(e.messageChannel.port1.removeEventListener("message",e.onMessage),e.messageChannel.port1.close()),this.handlers.delete(e)}async _send(e,n,r=50){const i=typeof MessageChannel<"u"?new MessageChannel:null;if(!i)throw new Error("connection_unavailable");let s,o;return new Promise((a,u)=>{const c=Zg("",20);i.port1.start();const d=setTimeout(()=>{u(new Error("unsupported_event"))},r);o={messageChannel:i,onMessage(f){const m=f;if(m.data.eventId===c)switch(m.data.status){case"ack":clearTimeout(d),s=setTimeout(()=>{u(new Error("timeout"))},3e3);break;case"done":clearTimeout(s),a(m.data.response);break;default:clearTimeout(d),clearTimeout(s),u(new Error("invalid_response"));break}}},this.handlers.add(o),i.port1.addEventListener("message",o.onMessage),this.target.postMessage({eventType:e,eventId:c,data:n},[i.port2])}).finally(()=>{o&&this.removeMessageHandler(o)})}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Xn(){return window}function JV(t){Xn().location.href=t}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function k1(){return typeof Xn().WorkerGlobalScope<"u"&&typeof Xn().importScripts=="function"}async function ZV(){if(!(navigator!=null&&navigator.serviceWorker))return null;try{return(await navigator.serviceWorker.ready).active}catch{return null}}function eF(){var t;return((t=navigator==null?void 0:navigator.serviceWorker)===null||t===void 0?void 0:t.controller)||null}function tF(){return k1()?self:null}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const C1="firebaseLocalStorageDb",nF=1,zc="firebaseLocalStorage",R1="fbase_key";class xl{constructor(e){this.request=e}toPromise(){return new Promise((e,n)=>{this.request.addEventListener("success",()=>{e(this.request.result)}),this.request.addEventListener("error",()=>{n(this.request.error)})})}}function Dh(t,e){return t.transaction([zc],e?"readwrite":"readonly").objectStore(zc)}function rF(){const t=indexedDB.deleteDatabase(C1);return new xl(t).toPromise()}function Np(){const t=indexedDB.open(C1,nF);return new Promise((e,n)=>{t.addEventListener("error",()=>{n(t.error)}),t.addEventListener("upgradeneeded",()=>{const r=t.result;try{r.createObjectStore(zc,{keyPath:R1})}catch(i){n(i)}}),t.addEventListener("success",async()=>{const r=t.result;r.objectStoreNames.contains(zc)?e(r):(r.close(),await rF(),e(await Np()))})})}async function l0(t,e,n){const r=Dh(t,!0).put({[R1]:e,value:n});return new xl(r).toPromise()}async function iF(t,e){const n=Dh(t,!1).get(e),r=await new xl(n).toPromise();return r===void 0?null:r.value}function u0(t,e){const n=Dh(t,!0).delete(e);return new xl(n).toPromise()}const sF=800,oF=3;class A1{constructor(){this.type="LOCAL",this._shouldAllowMigration=!0,this.listeners={},this.localCache={},this.pollTimer=null,this.pendingWrites=0,this.receiver=null,this.sender=null,this.serviceWorkerReceiverAvailable=!1,this.activeServiceWorker=null,this._workerInitializationPromise=this.initializeServiceWorkerMessaging().then(()=>{},()=>{})}async _openDb(){return this.db?this.db:(this.db=await Np(),this.db)}async _withRetries(e){let n=0;for(;;)try{const r=await this._openDb();return await e(r)}catch(r){if(n++>oF)throw r;this.db&&(this.db.close(),this.db=void 0)}}async initializeServiceWorkerMessaging(){return k1()?this.initializeReceiver():this.initializeSender()}async initializeReceiver(){this.receiver=Oh._getInstance(tF()),this.receiver._subscribe("keyChanged",async(e,n)=>({keyProcessed:(await this._poll()).includes(n.key)})),this.receiver._subscribe("ping",async(e,n)=>["keyChanged"])}async initializeSender(){var e,n;if(this.activeServiceWorker=await ZV(),!this.activeServiceWorker)return;this.sender=new XV(this.activeServiceWorker);const r=await this.sender._send("ping",{},800);r&&!((e=r[0])===null||e===void 0)&&e.fulfilled&&!((n=r[0])===null||n===void 0)&&n.value.includes("keyChanged")&&(this.serviceWorkerReceiverAvailable=!0)}async notifyServiceWorker(e){if(!(!this.sender||!this.activeServiceWorker||eF()!==this.activeServiceWorker))try{await this.sender._send("keyChanged",{key:e},this.serviceWorkerReceiverAvailable?800:50)}catch{}}async _isAvailable(){try{if(!indexedDB)return!1;const e=await Np();return await l0(e,jc,"1"),await u0(e,jc),!0}catch{}return!1}async _withPendingWrite(e){this.pendingWrites++;try{await e()}finally{this.pendingWrites--}}async _set(e,n){return this._withPendingWrite(async()=>(await this._withRetries(r=>l0(r,e,n)),this.localCache[e]=n,this.notifyServiceWorker(e)))}async _get(e){const n=await this._withRetries(r=>iF(r,e));return this.localCache[e]=n,n}async _remove(e){return this._withPendingWrite(async()=>(await this._withRetries(n=>u0(n,e)),delete this.localCache[e],this.notifyServiceWorker(e)))}async _poll(){const e=await this._withRetries(i=>{const s=Dh(i,!1).getAll();return new xl(s).toPromise()});if(!e)return[];if(this.pendingWrites!==0)return[];const n=[],r=new Set;if(e.length!==0)for(const{fbase_key:i,value:s}of e)r.add(i),JSON.stringify(this.localCache[i])!==JSON.stringify(s)&&(this.notifyListeners(i,s),n.push(i));for(const i of Object.keys(this.localCache))this.localCache[i]&&!r.has(i)&&(this.notifyListeners(i,null),n.push(i));return n}notifyListeners(e,n){this.localCache[e]=n;const r=this.listeners[e];if(r)for(const i of Array.from(r))i(n)}startPolling(){this.stopPolling(),this.pollTimer=setInterval(async()=>this._poll(),sF)}stopPolling(){this.pollTimer&&(clearInterval(this.pollTimer),this.pollTimer=null)}_addListener(e,n){Object.keys(this.listeners).length===0&&this.startPolling(),this.listeners[e]||(this.listeners[e]=new Set,this._get(e)),this.listeners[e].add(n)}_removeListener(e,n){this.listeners[e]&&(this.listeners[e].delete(n),this.listeners[e].size===0&&delete this.listeners[e]),Object.keys(this.listeners).length===0&&this.stopPolling()}}A1.type="LOCAL";const aF=A1;new Rl(3e4,6e4);/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function lF(t,e){return e?hr(e):(ne(t._popupRedirectResolver,t,"argument-error"),t._popupRedirectResolver)}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class e_ extends y1{constructor(e){super("custom","custom"),this.params=e}_getIdTokenResponse(e){return qs(e,this._buildIdpRequest())}_linkToIdToken(e,n){return qs(e,this._buildIdpRequest(n))}_getReauthenticationResolver(e){return qs(e,this._buildIdpRequest())}_buildIdpRequest(e){const n={requestUri:this.params.requestUri,sessionId:this.params.sessionId,postBody:this.params.postBody,tenantId:this.params.tenantId,pendingToken:this.params.pendingToken,returnSecureToken:!0,returnIdpCredential:!0};return e&&(n.idToken=e),n}}function uF(t){return WV(t.auth,new e_(t),t.bypassAuthState)}function cF(t){const{auth:e,user:n}=t;return ne(n,e,"internal-error"),$V(n,new e_(t),t.bypassAuthState)}async function hF(t){const{auth:e,user:n}=t;return ne(n,e,"internal-error"),BV(n,new e_(t),t.bypassAuthState)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class x1{constructor(e,n,r,i,s=!1){this.auth=e,this.resolver=r,this.user=i,this.bypassAuthState=s,this.pendingPromise=null,this.eventManager=null,this.filter=Array.isArray(n)?n:[n]}execute(){return new Promise(async(e,n)=>{this.pendingPromise={resolve:e,reject:n};try{this.eventManager=await this.resolver._initialize(this.auth),await this.onExecution(),this.eventManager.registerConsumer(this)}catch(r){this.reject(r)}})}async onAuthEvent(e){const{urlResponse:n,sessionId:r,postBody:i,tenantId:s,error:o,type:a}=e;if(o){this.reject(o);return}const u={auth:this.auth,requestUri:n,sessionId:r,tenantId:s||void 0,postBody:i||void 0,user:this.user,bypassAuthState:this.bypassAuthState};try{this.resolve(await this.getIdpTask(a)(u))}catch(c){this.reject(c)}}onError(e){this.reject(e)}getIdpTask(e){switch(e){case"signInViaPopup":case"signInViaRedirect":return uF;case"linkViaPopup":case"linkViaRedirect":return hF;case"reauthViaPopup":case"reauthViaRedirect":return cF;default:kr(this.auth,"internal-error")}}resolve(e){Cr(this.pendingPromise,"Pending promise was never set"),this.pendingPromise.resolve(e),this.unregisterAndCleanUp()}reject(e){Cr(this.pendingPromise,"Pending promise was never set"),this.pendingPromise.reject(e),this.unregisterAndCleanUp()}unregisterAndCleanUp(){this.eventManager&&this.eventManager.unregisterConsumer(this),this.pendingPromise=null,this.cleanUp()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const dF=new Rl(2e3,1e4);class Os extends x1{constructor(e,n,r,i,s){super(e,n,i,s),this.provider=r,this.authWindow=null,this.pollId=null,Os.currentPopupAction&&Os.currentPopupAction.cancel(),Os.currentPopupAction=this}async executeNotNull(){const e=await this.execute();return ne(e,this.auth,"internal-error"),e}async onExecution(){Cr(this.filter.length===1,"Popup operations only handle one event");const e=Zg();this.authWindow=await this.resolver._openPopup(this.auth,this.provider,this.filter[0],e),this.authWindow.associatedEvent=e,this.resolver._originValidation(this.auth).catch(n=>{this.reject(n)}),this.resolver._isIframeWebStorageSupported(this.auth,n=>{n||this.reject(Yn(this.auth,"web-storage-unsupported"))}),this.pollUserCancellation()}get eventId(){var e;return((e=this.authWindow)===null||e===void 0?void 0:e.associatedEvent)||null}cancel(){this.reject(Yn(this.auth,"cancelled-popup-request"))}cleanUp(){this.authWindow&&this.authWindow.close(),this.pollId&&window.clearTimeout(this.pollId),this.authWindow=null,this.pollId=null,Os.currentPopupAction=null}pollUserCancellation(){const e=()=>{var n,r;if(!((r=(n=this.authWindow)===null||n===void 0?void 0:n.window)===null||r===void 0)&&r.closed){this.pollId=window.setTimeout(()=>{this.pollId=null,this.reject(Yn(this.auth,"popup-closed-by-user"))},8e3);return}this.pollId=window.setTimeout(e,dF.get())};e()}}Os.currentPopupAction=null;/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const fF="pendingRedirect",Wu=new Map;class pF extends x1{constructor(e,n,r=!1){super(e,["signInViaRedirect","linkViaRedirect","reauthViaRedirect","unknown"],n,void 0,r),this.eventId=null}async execute(){let e=Wu.get(this.auth._key());if(!e){try{const r=await mF(this.resolver,this.auth)?await super.execute():null;e=()=>Promise.resolve(r)}catch(n){e=()=>Promise.reject(n)}Wu.set(this.auth._key(),e)}return this.bypassAuthState||Wu.set(this.auth._key(),()=>Promise.resolve(null)),e()}async onAuthEvent(e){if(e.type==="signInViaRedirect")return super.onAuthEvent(e);if(e.type==="unknown"){this.resolve(null);return}if(e.eventId){const n=await this.auth._redirectUserForId(e.eventId);if(n)return this.user=n,super.onAuthEvent(e);this.resolve(null)}}async onExecution(){}cleanUp(){}}async function mF(t,e){const n=yF(e),r=_F(t);if(!await r._isAvailable())return!1;const i=await r._get(n)==="true";return await r._remove(n),i}function gF(t,e){Wu.set(t._key(),e)}function _F(t){return hr(t._redirectPersistence)}function yF(t){return $u(fF,t.config.apiKey,t.name)}async function vF(t,e,n=!1){if(ar(t.app))return Promise.reject(oi(t));const r=Nh(t),i=lF(r,e),o=await new pF(r,i,n).execute();return o&&!n&&(delete o.user._redirectEventId,await r._persistUserIfCurrent(o.user),await r._setRedirectUser(null,e)),o}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const wF=10*60*1e3;class EF{constructor(e){this.auth=e,this.cachedEventUids=new Set,this.consumers=new Set,this.queuedRedirectEvent=null,this.hasHandledPotentialRedirect=!1,this.lastProcessedEventTime=Date.now()}registerConsumer(e){this.consumers.add(e),this.queuedRedirectEvent&&this.isEventForConsumer(this.queuedRedirectEvent,e)&&(this.sendToConsumer(this.queuedRedirectEvent,e),this.saveEventToCache(this.queuedRedirectEvent),this.queuedRedirectEvent=null)}unregisterConsumer(e){this.consumers.delete(e)}onEvent(e){if(this.hasEventBeenHandled(e))return!1;let n=!1;return this.consumers.forEach(r=>{this.isEventForConsumer(e,r)&&(n=!0,this.sendToConsumer(e,r),this.saveEventToCache(e))}),this.hasHandledPotentialRedirect||!TF(e)||(this.hasHandledPotentialRedirect=!0,n||(this.queuedRedirectEvent=e,n=!0)),n}sendToConsumer(e,n){var r;if(e.error&&!P1(e)){const i=((r=e.error.code)===null||r===void 0?void 0:r.split("auth/")[1])||"internal-error";n.onError(Yn(this.auth,i))}else n.onAuthEvent(e)}isEventForConsumer(e,n){const r=n.eventId===null||!!e.eventId&&e.eventId===n.eventId;return n.filter.includes(e.type)&&r}hasEventBeenHandled(e){return Date.now()-this.lastProcessedEventTime>=wF&&this.cachedEventUids.clear(),this.cachedEventUids.has(c0(e))}saveEventToCache(e){this.cachedEventUids.add(c0(e)),this.lastProcessedEventTime=Date.now()}}function c0(t){return[t.type,t.eventId,t.sessionId,t.tenantId].filter(e=>e).join("-")}function P1({type:t,error:e}){return t==="unknown"&&(e==null?void 0:e.code)==="auth/no-auth-event"}function TF(t){switch(t.type){case"signInViaRedirect":case"linkViaRedirect":case"reauthViaRedirect":return!0;case"unknown":return P1(t);default:return!1}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function IF(t,e={}){return So(t,"GET","/v1/projects",e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const SF=/^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/,kF=/^https?/;async function CF(t){if(t.config.emulator)return;const{authorizedDomains:e}=await IF(t);for(const n of e)try{if(RF(n))return}catch{}kr(t,"unauthorized-domain")}function RF(t){const e=Pp(),{protocol:n,hostname:r}=new URL(e);if(t.startsWith("chrome-extension://")){const o=new URL(t);return o.hostname===""&&r===""?n==="chrome-extension:"&&t.replace("chrome-extension://","")===e.replace("chrome-extension://",""):n==="chrome-extension:"&&o.hostname===r}if(!kF.test(n))return!1;if(SF.test(t))return r===t;const i=t.replace(/\./g,"\\.");return new RegExp("^(.+\\."+i+"|"+i+")$","i").test(r)}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const AF=new Rl(3e4,6e4);function h0(){const t=Xn().___jsl;if(t!=null&&t.H){for(const e of Object.keys(t.H))if(t.H[e].r=t.H[e].r||[],t.H[e].L=t.H[e].L||[],t.H[e].r=[...t.H[e].L],t.CP)for(let n=0;n<t.CP.length;n++)t.CP[n]=null}}function xF(t){return new Promise((e,n)=>{var r,i,s;function o(){h0(),gapi.load("gapi.iframes",{callback:()=>{e(gapi.iframes.getContext())},ontimeout:()=>{h0(),n(Yn(t,"network-request-failed"))},timeout:AF.get()})}if(!((i=(r=Xn().gapi)===null||r===void 0?void 0:r.iframes)===null||i===void 0)&&i.Iframe)e(gapi.iframes.getContext());else if(!((s=Xn().gapi)===null||s===void 0)&&s.load)o();else{const a=OV("iframefcb");return Xn()[a]=()=>{gapi.load?o():n(Yn(t,"network-request-failed"))},bV(`${NV()}?onload=${a}`).catch(u=>n(u))}}).catch(e=>{throw qu=null,e})}let qu=null;function PF(t){return qu=qu||xF(t),qu}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const bF=new Rl(5e3,15e3),NF="__/auth/iframe",OF="emulator/auth/iframe",DF={style:{position:"absolute",top:"-100px",width:"1px",height:"1px"},"aria-hidden":"true",tabindex:"-1"},MF=new Map([["identitytoolkit.googleapis.com","p"],["staging-identitytoolkit.sandbox.googleapis.com","s"],["test-identitytoolkit.sandbox.googleapis.com","t"]]);function LF(t){const e=t.config;ne(e.authDomain,t,"auth-domain-config-required");const n=e.emulator?Qg(e,OF):`https://${t.config.authDomain}/${NF}`,r={apiKey:e.apiKey,appName:t.name,v:yi},i=MF.get(t.config.apiHost);i&&(r.eid=i);const s=t._getFrameworks();return s.length&&(r.fw=s.join(",")),`${n}?${po(r).slice(1)}`}async function VF(t){const e=await PF(t),n=Xn().gapi;return ne(n,t,"internal-error"),e.open({where:document.body,url:LF(t),messageHandlersFilter:n.iframes.CROSS_ORIGIN_IFRAMES_FILTER,attributes:DF,dontclear:!0},r=>new Promise(async(i,s)=>{await r.restyle({setHideOnLeave:!1});const o=Yn(t,"network-request-failed"),a=Xn().setTimeout(()=>{s(o)},bF.get());function u(){Xn().clearTimeout(a),i(r)}r.ping(u).then(u,()=>{s(o)})}))}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const FF={location:"yes",resizable:"yes",statusbar:"yes",toolbar:"no"},UF=500,jF=600,zF="_blank",BF="http://localhost";class d0{constructor(e){this.window=e,this.associatedEvent=null}close(){if(this.window)try{this.window.close()}catch{}}}function $F(t,e,n,r=UF,i=jF){const s=Math.max((window.screen.availHeight-i)/2,0).toString(),o=Math.max((window.screen.availWidth-r)/2,0).toString();let a="";const u=Object.assign(Object.assign({},FF),{width:r.toString(),height:i.toString(),top:s,left:o}),c=Ft().toLowerCase();n&&(a=c1(c)?zF:n),l1(c)&&(e=e||BF,u.scrollbars="yes");const d=Object.entries(u).reduce((m,[w,I])=>`${m}${w}=${I},`,"");if(IV(c)&&a!=="_self")return WF(e||"",a),new d0(null);const f=window.open(e||"",a,d);ne(f,t,"popup-blocked");try{f.focus()}catch{}return new d0(f)}function WF(t,e){const n=document.createElement("a");n.href=t,n.target=e;const r=document.createEvent("MouseEvent");r.initMouseEvent("click",!0,!0,window,1,0,0,0,0,!1,!1,!1,!1,1,null),n.dispatchEvent(r)}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const qF="__/auth/handler",HF="emulator/auth/handler",GF=encodeURIComponent("fac");async function f0(t,e,n,r,i,s){ne(t.config.authDomain,t,"auth-domain-config-required"),ne(t.config.apiKey,t,"invalid-api-key");const o={apiKey:t.config.apiKey,appName:t.name,authType:n,redirectUrl:r,v:yi,eventId:i};if(e instanceof v1){e.setDefaultLanguage(t.languageCode),o.providerId=e.providerId||"",Kf(e.getCustomParameters())||(o.customParameters=JSON.stringify(e.getCustomParameters()));for(const[d,f]of Object.entries({}))o[d]=f}if(e instanceof Al){const d=e.getScopes().filter(f=>f!=="");d.length>0&&(o.scopes=d.join(","))}t.tenantId&&(o.tid=t.tenantId);const a=o;for(const d of Object.keys(a))a[d]===void 0&&delete a[d];const u=await t._getAppCheckToken(),c=u?`#${GF}=${encodeURIComponent(u)}`:"";return`${KF(t)}?${po(a).slice(1)}${c}`}function KF({config:t}){return t.emulator?Qg(t,HF):`https://${t.authDomain}/${qF}`}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Kd="webStorageSupport";class QF{constructor(){this.eventManagers={},this.iframes={},this.originValidationPromises={},this._redirectPersistence=S1,this._completeRedirectFn=vF,this._overrideRedirectResult=gF}async _openPopup(e,n,r,i){var s;Cr((s=this.eventManagers[e._key()])===null||s===void 0?void 0:s.manager,"_initialize() not called before _openPopup()");const o=await f0(e,n,r,Pp(),i);return $F(e,o,Zg())}async _openRedirect(e,n,r,i){await this._originValidation(e);const s=await f0(e,n,r,Pp(),i);return JV(s),new Promise(()=>{})}_initialize(e){const n=e._key();if(this.eventManagers[n]){const{manager:i,promise:s}=this.eventManagers[n];return i?Promise.resolve(i):(Cr(s,"If manager is not set, promise should be"),s)}const r=this.initAndGetManager(e);return this.eventManagers[n]={promise:r},r.catch(()=>{delete this.eventManagers[n]}),r}async initAndGetManager(e){const n=await VF(e),r=new EF(e);return n.register("authEvent",i=>(ne(i==null?void 0:i.authEvent,e,"invalid-auth-event"),{status:r.onEvent(i.authEvent)?"ACK":"ERROR"}),gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER),this.eventManagers[e._key()]={manager:r},this.iframes[e._key()]=n,r}_isIframeWebStorageSupported(e,n){this.iframes[e._key()].send(Kd,{type:Kd},i=>{var s;const o=(s=i==null?void 0:i[0])===null||s===void 0?void 0:s[Kd];o!==void 0&&n(!!o),kr(e,"internal-error")},gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER)}_originValidation(e){const n=e._key();return this.originValidationPromises[n]||(this.originValidationPromises[n]=CF(e)),this.originValidationPromises[n]}get _shouldInitProactively(){return m1()||u1()||Xg()}}const YF=QF;var p0="@firebase/auth",m0="1.7.9";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class XF{constructor(e){this.auth=e,this.internalListeners=new Map}getUid(){var e;return this.assertAuthConfigured(),((e=this.auth.currentUser)===null||e===void 0?void 0:e.uid)||null}async getToken(e){return this.assertAuthConfigured(),await this.auth._initializationPromise,this.auth.currentUser?{accessToken:await this.auth.currentUser.getIdToken(e)}:null}addAuthTokenListener(e){if(this.assertAuthConfigured(),this.internalListeners.has(e))return;const n=this.auth.onIdTokenChanged(r=>{e((r==null?void 0:r.stsTokenManager.accessToken)||null)});this.internalListeners.set(e,n),this.updateProactiveRefresh()}removeAuthTokenListener(e){this.assertAuthConfigured();const n=this.internalListeners.get(e);n&&(this.internalListeners.delete(e),n(),this.updateProactiveRefresh())}assertAuthConfigured(){ne(this.auth._initializationPromise,"dependent-sdk-initialized-before-auth")}updateProactiveRefresh(){this.internalListeners.size>0?this.auth._startProactiveRefresh():this.auth._stopProactiveRefresh()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function JF(t){switch(t){case"Node":return"node";case"ReactNative":return"rn";case"Worker":return"webworker";case"Cordova":return"cordova";case"WebExtension":return"web-extension";default:return}}function ZF(t){ui(new vr("auth",(e,{options:n})=>{const r=e.getProvider("app").getImmediate(),i=e.getProvider("heartbeat"),s=e.getProvider("app-check-internal"),{apiKey:o,authDomain:a}=r.options;ne(o&&!o.includes(":"),"invalid-api-key",{appName:r.name});const u={apiKey:o,authDomain:a,clientPlatform:t,apiHost:"identitytoolkit.googleapis.com",tokenApiHost:"securetoken.googleapis.com",apiScheme:"https",sdkClientVersion:g1(t)},c=new xV(r,i,s,u);return MV(c,n),c},"PUBLIC").setInstantiationMode("EXPLICIT").setInstanceCreatedCallback((e,n,r)=>{e.getProvider("auth-internal").initialize()})),ui(new vr("auth-internal",e=>{const n=Nh(e.getProvider("auth").getImmediate());return(r=>new XF(r))(n)},"PRIVATE").setInstantiationMode("EXPLICIT")),wn(p0,m0,JF(t)),wn(p0,m0,"esm2017")}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const e4=5*60,t4=$T("authIdTokenMaxAge")||e4;let g0=null;const n4=t=>async e=>{const n=e&&await e.getIdTokenResult(),r=n&&(new Date().getTime()-Date.parse(n.issuedAtTime))/1e3;if(r&&r>t4)return;const i=n==null?void 0:n.token;g0!==i&&(g0=i,await fetch(t,{method:i?"POST":"DELETE",headers:i?{Authorization:`Bearer ${i}`}:{}}))};function r4(t=hh()){const e=ml(t,"auth");if(e.isInitialized())return e.getImmediate();const n=DV(t,{popupRedirectResolver:YF,persistence:[aF,QV,S1]}),r=$T("authTokenSyncURL");if(r&&typeof isSecureContext=="boolean"&&isSecureContext){const s=new URL(r,location.origin);if(location.origin===s.origin){const o=n4(s.toString());HV(n,o,()=>o(n.currentUser)),qV(n,a=>o(a))}}const i=zT("auth");return i&&LV(n,`http://${i}`),n}function i4(){var t,e;return(e=(t=document.getElementsByTagName("head"))===null||t===void 0?void 0:t[0])!==null&&e!==void 0?e:document}PV({loadJS(t){return new Promise((e,n)=>{const r=document.createElement("script");r.setAttribute("src",t),r.onload=e,r.onerror=i=>{const s=Yn("internal-error");s.customData=i,n(s)},r.type="text/javascript",r.charset="UTF-8",i4().appendChild(r)})},gapiScript:"https://apis.google.com/js/api.js",recaptchaV2Script:"https://www.google.com/recaptcha/api.js",recaptchaEnterpriseScript:"https://www.google.com/recaptcha/enterprise.js?render="});ZF("Browser");const xa={apiKey:"AIzaSyC0sUtQ-SsE-IazJNg9AwP-JmQ_xJMR1iY",authDomain:"book-store-bec15.firebaseapp.com",databaseURL:"https://book-store-bec15-default-rtdb.firebaseio.com",projectId:"book-store-bec15",storageBucket:"book-store-bec15.firebasestorage.app",messagingSenderId:"1096744232990",appId:"1:1096744232990:web:186080c3ec42ad7a33660f",measurementId:"G-8YSJN6PWZT"},Mh=KT(xa),s4=r4(Mh),Qd=M2(Mh),Yd=gD(Mh),Xd=iV(Mh);function o4({activeTab:t,setActiveTab:e,bookCount:n,onOpenRules:r}){return v.jsx("header",{style:{position:"sticky",top:0,zIndex:50,backdropFilter:"blur(20px)",WebkitBackdropFilter:"blur(20px)",background:"rgba(9, 13, 22, 0.85)",borderBottom:"1px solid rgba(255, 255, 255, 0.08)",padding:"0.85rem 2rem"},children:v.jsxs("div",{style:{maxWidth:1280,margin:"0 auto",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[v.jsx("div",{style:{width:42,height:42,borderRadius:12,background:"linear-gradient(135deg, #6366f1, #a855f7)",display:"flex",alignItems:"center",justifyContent:"center",boxShadow:"0 0 20px rgba(99, 102, 241, 0.4)"},children:v.jsx(Am,{size:22,color:"#ffffff"})}),v.jsxs("div",{children:[v.jsx("div",{style:{fontSize:"1.25rem",fontWeight:800,letterSpacing:"-0.02em",background:"linear-gradient(to right, #ffffff, #c7d2fe)",WebkitBackgroundClip:"text",WebkitTextFillColor:"transparent"},children:"AudioBook Studio"}),v.jsx("div",{style:{fontSize:"0.75rem",color:"#64748b"},children:"Firebase Markdown Publishing Portal"})]})]}),v.jsxs("div",{style:{display:"flex",background:"rgba(255, 255, 255, 0.04)",padding:"4px",borderRadius:"12px",border:"1px solid rgba(255, 255, 255, 0.06)"},children:[v.jsxs("button",{onClick:()=>e("upload"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="upload"?"var(--accent-primary)":"transparent",color:t==="upload"?"#ffffff":"var(--text-muted)"},children:[v.jsx(xm,{size:16}),"Upload & Parse"]}),v.jsxs("button",{onClick:()=>e("library"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="library"?"var(--accent-primary)":"transparent",color:t==="library"?"#ffffff":"var(--text-muted)"},children:[v.jsx(ix,{size:16}),"Library",typeof n=="number"&&v.jsx("span",{style:{background:t==="library"?"rgba(255,255,255,0.25)":"rgba(255,255,255,0.1)",padding:"1px 7px",borderRadius:"9999px",fontSize:"0.75rem",marginLeft:4},children:n})]})]}),v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[v.jsx("button",{onClick:r,className:"btn-secondary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",color:"#f87171",borderColor:"rgba(239, 68, 68, 0.3)"},title:"Setup Firebase Storage & Firestore Rules",children:"Fix Rules / Permissions"}),v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.6rem",background:"rgba(16, 185, 129, 0.1)",border:"1px solid rgba(16, 185, 129, 0.25)",padding:"0.4rem 0.85rem",borderRadius:"9999px",fontSize:"0.78rem",color:"#6ee7b7"},children:[v.jsx("span",{style:{width:8,height:8,borderRadius:"50%",background:"#10b981",boxShadow:"0 0 10px #10b981"}}),v.jsxs("span",{children:["Firebase: ",v.jsx("strong",{children:xa.projectId})]})]})]})]})})}function a4(t,e=""){const n=t.split(/\r?\n/);let r="",i="",s="",o="",a="";const u=e.replace(/\.(md|markdown|txt)$/i,"").replace(/_/g," "),c=n.find(S=>/^#\s+(.+)/.test(S));c?r=c.replace(/^#\s+/,"").trim():r=u;const d=n.find(S=>/^\s*[\*_]\((.+)\)[\*_]\s*$/.test(S)||/^\s*[\*_]([^\*_]+)[\*_]\s*$/.test(S));if(d){const S=d.match(/[\*_]\(?([^\*\_\(\)]+)\)?[\*_]/);S&&(i=S[1].trim())}const f=t.match(/\*\*(?:মূল\s*লেখক|লেখক|Author|Written By)\s*:\*\*\s*([^\n\r]+)/i);f&&(s=f[1].trim());const m=t.match(/\*\*(?:অনুবাদক\s*ও\s*সংকলক|অনুবাদক|সংকলক|Translator|Compiled By)\s*:\*\*\s*([^\n\r]+)/i);m&&(o=m[1].trim());const w=t.match(/\n\*\*([^\*:\n]{8,80})\*\*\s*\n/);w&&!(f!=null&&f[0].includes(w[1]))&&(a=w[1].trim());const I=[],P=/^##\s+(.+)$/gm,O=[...t.matchAll(P)];if(O.length>0)for(let S=0;S<O.length;S++){const M=O[S],V=M[1].trim(),F=M.index+M[0].length,y=S+1<O.length?O[S+1].index:t.length,g=t.slice(F,y).trim(),E=Jd(g);I.push({id:`chap_${S+1}`,order:S+1,title:V,content:g,wordCount:E,estimatedMinutes:Math.max(1,Math.ceil(E/140))})}else{const S=Jd(t);I.push({id:"chap_1",order:1,title:r||"Full Content",content:t,wordCount:S,estimatedMinutes:Math.max(1,Math.ceil(S/140))})}const C=Jd(t),T=Math.max(1,Math.ceil(C/140));return{title:r||u,subtitle:i,author:s,translator:o,tagline:a,totalWords:C,totalChapters:I.length,estimatedMinutes:T,chapters:I,rawText:t}}function Jd(t){return t?t.trim().split(/\s+/).filter(n=>n.length>0).length:0}function l4(t){if(!t)return`book-${Date.now()}`;const e=t.toLowerCase().replace(/[^\w\s-]/g,"").trim().replace(/\s+/g,"-");return e.length>2?`${e}-${Date.now().toString().slice(-4)}`:`book-${Date.now()}`}function u4({onParsedBook:t,onShowToast:e}){const[n,r]=oe.useState(!1),[i,s]=oe.useState(null),[o,a]=oe.useState(null),[u,c]=oe.useState(null),[d,f]=oe.useState("Personal Finance & Business"),[m,w]=oe.useState("Bangla"),[I,P]=oe.useState(""),O=oe.useRef(null),C=oe.useRef(null),T=V=>{if(!V)return;if(!V.name.match(/\.(md|markdown|txt)$/i)){e({type:"error",title:"Unsupported File",message:"Please upload a Markdown (.md) or text file."});return}s(V);const F=new FileReader;F.onload=y=>{const g=y.target.result,E=a4(g,V.name);t({...E,originalFile:V,filename:V.name,fileSize:V.size,coverFile:u,coverPreview:o,category:d,language:m,audioUrl:I}),e({type:"info",title:"File Parsed Successfully",message:`Extracted "${E.title||V.name}" with ${E.totalChapters} chapters.`})},F.readAsText(V)},S=V=>{var y;const F=(y=V.target.files)==null?void 0:y[0];if(F){c(F);const g=URL.createObjectURL(F);a(g)}},M=()=>{const V=`# ধনী বাবা গরীব বাবা
*(বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ)*

**মূল লেখক:** রবার্ট টি. কিওসাকি  
**অনুবাদক ও সংকলক:** মোঃ আবির আহমেদ  

**আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা**

---

## সূচিপত্র

১. [ভূমিকা: দুই বাবার ভিন্ন জগত](#ভূমিকা-দুই-বাবার-ভিন্ন-জগত)
২. [মানসিকতার পার্থক্য](#মানসিকতার-পার্থক্য)
৩. [পাঠ ১: ধনীরা টাকার জন্য কাজ করে না](#পাঠ-১-ধনীরা-টাকার-জন্য-কাজ-করে-না)
৪. [পাঠ ২: আর্থিক শিক্ষার গুরুত্ব](#পাঠ-২-আর্থিক-শিক্ষার-গুরুত্ব)

---

## ভূমিকা: দুই বাবার ভিন্ন জগত

- রবার্ট কিওসাকির বড় হয়ে ওঠার গল্পটি শুরু হয় দুজন বাবাকে কেন্দ্র করে।
- একজন তার জন্মদাতা পিতা, যাকে তিনি 'গরীব বাবা' বলে সম্বোধন করেছেন। তিনি ছিলেন উচ্চশিক্ষিত কিন্তু সারাজীবন আর্থিক চাপে ভুগেছেন।
- অন্যদিকে, তার বন্ধুর বাবা ছিলেন 'ধনী বাবা', যিনি প্রথাগত উচ্চশিক্ষা না নিয়েও সফল উদ্যোক্তা ও বিনিয়োগকারী হয়েছিলেন।
- গরীব বাবা বলতেন: *"টাকার প্রতি ভালোবাসাই সকল অমঙ্গলের মূল।"*
- ধনী বাবা বলতেন: *"টাকার অভাবই সকল অমঙ্গলের মূল।"*

---

## মানসিকতার পার্থক্য

- গরীব বাবা বলতেন, *"ভালো করে পড়াশোনা করো যাতে তুমি একটি ভালো কোম্পানিতে বড় চাকরি পাও।"*
- ধনী বাবা বলতেন, *"পড়াশোনা করো যাতে তুমি বড় বড় কোম্পানি তৈরি করতে পারো এবং অন্যদের চাকরি দিতে পারো।"*
- গরীব বাবা সরাসরি বলতেন, *"আমি এটা কিনতে পারব না।"*
- ধনী বাবা প্রশ্ন করতে শেখাতেন, *"আমি কীভাবে এটা কিনতে পারি?"*

---

## পাঠ ১: ধনীরা টাকার জন্য কাজ করে না

- মধ্যবিত্ত ও দরিদ্র শ্রেণির মানুষরা ভীতি ও লালসার ফাঁদে পড়ে সারাজীবন অর্থের জন্য মাথার ঘাম পায়ে ফেলে কাজ করে যায়।
- ধনীরা তাদের অর্থকে এমনভাবে বিনিয়োগ করে যাতে অর্থ তাদের জন্য দিনরাত কাজ করে।
`,F=new Blob([V],{type:"text/markdown"}),y=new File([F],"Rich_Dad_Poor_Dad_Bangla_Summary_Full_Book.md",{type:"text/markdown"});T(y)};return v.jsxs("div",{style:{maxWidth:860,margin:"0 auto",display:"flex",flexDirection:"column",gap:"2rem"},children:[v.jsxs("div",{className:"glass-panel",style:{padding:"2rem",position:"relative",overflow:"hidden"},children:[v.jsx("div",{style:{position:"absolute",top:-50,right:-50,width:160,height:160,background:"radial-gradient(circle, rgba(99, 102, 241, 0.25) 0%, transparent 70%)",borderRadius:"50%"}}),v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"flex-start",flexWrap:"wrap",gap:"1rem"},children:[v.jsxs("div",{children:[v.jsxs("span",{className:"badge badge-indigo",style:{marginBottom:"0.75rem"},children:[v.jsx(fv,{size:12})," Markdown to Firebase Pipeline"]}),v.jsx("h1",{style:{fontSize:"1.85rem",marginBottom:"0.5rem"},children:"Upload Audio Book Markdown"}),v.jsxs("p",{style:{color:"var(--text-muted)",fontSize:"0.95rem",maxWidth:540},children:["Drop your ",v.jsx("code",{style:{color:"#a5b4fc",background:"rgba(99,102,241,0.15)",padding:"2px 6px",borderRadius:4},children:"book.md"})," file here. Our parser will automatically extract metadata, organize chapters, and upload both the raw file and structured database records to Firebase."]})]}),v.jsxs("button",{type:"button",onClick:M,className:"btn-secondary",style:{fontSize:"0.85rem"},children:[v.jsx(fv,{size:16,color:"#a855f7"}),"Load Sample Book"]})]})]}),v.jsxs("div",{className:`dropzone ${n?"active":""}`,onDragOver:V=>{V.preventDefault(),r(!0)},onDragLeave:()=>r(!1),onDrop:V=>{var y;V.preventDefault(),r(!1);const F=(y=V.dataTransfer.files)==null?void 0:y[0];T(F)},onClick:()=>{var V;return(V=O.current)==null?void 0:V.click()},children:[v.jsx("input",{type:"file",ref:O,accept:".md,.markdown,.txt",style:{display:"none"},onChange:V=>{var F;return T((F=V.target.files)==null?void 0:F[0])}}),v.jsx("div",{style:{width:64,height:64,borderRadius:16,background:"rgba(99, 102, 241, 0.1)",display:"flex",alignItems:"center",justifyContent:"center",margin:"0 auto 1.25rem",border:"1px solid rgba(99, 102, 241, 0.25)"},children:v.jsx(xm,{size:32,color:"#6366f1"})}),v.jsx("h3",{style:{fontSize:"1.2rem",marginBottom:"0.5rem"},children:i?i.name:"Choose a Markdown book file or drag it here"}),v.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem",marginBottom:"1rem"},children:"Supports .md, .markdown, .txt containing book titles, author credits, and chapter headers (##)"}),v.jsxs("span",{className:"btn-primary",style:{padding:"0.5rem 1.25rem",fontSize:"0.88rem"},children:[v.jsx(ZA,{size:16})," Browse Files"]})]}),v.jsxs("div",{className:"glass-panel",style:{padding:"1.75rem"},children:[v.jsxs("h4",{style:{fontSize:"1.05rem",marginBottom:"1.25rem",display:"flex",alignItems:"center",gap:"0.5rem"},children:[v.jsx(MT,{size:18,color:"#818cf8"})," Book Settings & Optional Cover"]}),v.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(240px, 1fr))",gap:"1.25rem"},children:[v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Language"}),v.jsxs("select",{className:"input-field",value:m,onChange:V=>w(V.target.value),children:[v.jsx("option",{value:"Bangla",children:"বাংলা (Bangla)"}),v.jsx("option",{value:"English",children:"English"}),v.jsx("option",{value:"Hindi",children:"Hindi"}),v.jsx("option",{value:"Other",children:"Other"})]})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Category"}),v.jsxs("select",{className:"input-field",value:d,onChange:V=>f(V.target.value),children:[v.jsx("option",{value:"Personal Finance & Business",children:"Personal Finance & Business"}),v.jsx("option",{value:"Self Improvement",children:"Self Improvement"}),v.jsx("option",{value:"Psychology & Mindset",children:"Psychology & Mindset"}),v.jsx("option",{value:"Productivity & Habits",children:"Productivity & Habits"}),v.jsx("option",{value:"Biographies & History",children:"Biographies & History"}),v.jsx("option",{value:"Fiction & Literature",children:"Fiction & Literature"})]})]}),v.jsxs("div",{style:{gridColumn:"1 / -1"},children:[v.jsx("label",{className:"input-label",children:"Audio Stream / MP3 URL (Optional)"}),v.jsx("input",{type:"url",className:"input-field",placeholder:"https://storage.googleapis.com/... or https://domain.com/audio.mp3",value:I,onChange:V=>P(V.target.value)})]}),v.jsxs("div",{style:{gridColumn:"1 / -1"},children:[v.jsx("label",{className:"input-label",children:"Book Cover Image (Optional)"}),v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"1.25rem",flexWrap:"wrap"},children:[v.jsx("input",{type:"file",ref:C,accept:"image/*",style:{display:"none"},onChange:S}),v.jsxs("button",{type:"button",className:"btn-secondary",onClick:()=>{var V;return(V=C.current)==null?void 0:V.click()},children:[v.jsx(nx,{size:16})," Choose Cover Image"]}),o&&v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[v.jsx("img",{src:o,alt:"Cover Preview",style:{width:48,height:64,objectFit:"cover",borderRadius:6,border:"1px solid var(--border-accent)"}}),v.jsxs("span",{style:{fontSize:"0.85rem",color:"#10b981"},children:[v.jsx(Gf,{size:14,style:{display:"inline",verticalAlign:"middle",marginRight:4}}),"Cover Selected (",u==null?void 0:u.name,")"]})]})]})]})]})]})]})}function t_(){return{async:!1,breaks:!1,extensions:null,gfm:!0,hooks:null,pedantic:!1,renderer:null,silent:!1,tokenizer:null,walkTokens:null}}let as=t_();function b1(t){as=t}const N1=/[&<>"']/,c4=new RegExp(N1.source,"g"),O1=/[<>"']|&(?!(#\d{1,7}|#[Xx][a-fA-F0-9]{1,6}|\w+);)/,h4=new RegExp(O1.source,"g"),d4={"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"},_0=t=>d4[t];function sn(t,e){if(e){if(N1.test(t))return t.replace(c4,_0)}else if(O1.test(t))return t.replace(h4,_0);return t}const f4=/(^|[^\[])\^/g;function Ae(t,e){let n=typeof t=="string"?t:t.source;e=e||"";const r={replace:(i,s)=>{let o=typeof s=="string"?s:s.source;return o=o.replace(f4,"$1"),n=n.replace(i,o),r},getRegex:()=>new RegExp(n,e)};return r}function y0(t){try{t=encodeURI(t).replace(/%25/g,"%")}catch{return null}return t}const Pa={exec:()=>null};function v0(t,e){const n=t.replace(/\|/g,(s,o,a)=>{let u=!1,c=o;for(;--c>=0&&a[c]==="\\";)u=!u;return u?"|":" |"}),r=n.split(/ \|/);let i=0;if(r[0].trim()||r.shift(),r.length>0&&!r[r.length-1].trim()&&r.pop(),e)if(r.length>e)r.splice(e);else for(;r.length<e;)r.push("");for(;i<r.length;i++)r[i]=r[i].trim().replace(/\\\|/g,"|");return r}function ta(t,e,n){const r=t.length;if(r===0)return"";let i=0;for(;i<r&&t.charAt(r-i-1)===e;)i++;return t.slice(0,r-i)}function p4(t,e){if(t.indexOf(e[1])===-1)return-1;let n=0;for(let r=0;r<t.length;r++)if(t[r]==="\\")r++;else if(t[r]===e[0])n++;else if(t[r]===e[1]&&(n--,n<0))return r;return-1}function w0(t,e,n,r){const i=e.href,s=e.title?sn(e.title):null,o=t[1].replace(/\\([\[\]])/g,"$1");if(t[0].charAt(0)!=="!"){r.state.inLink=!0;const a={type:"link",raw:n,href:i,title:s,text:o,tokens:r.inlineTokens(o)};return r.state.inLink=!1,a}return{type:"image",raw:n,href:i,title:s,text:sn(o)}}function m4(t,e){const n=t.match(/^(\s+)(?:```)/);if(n===null)return e;const r=n[1];return e.split(`
`).map(i=>{const s=i.match(/^\s+/);if(s===null)return i;const[o]=s;return o.length>=r.length?i.slice(r.length):i}).join(`
`)}class Bc{constructor(e){be(this,"options");be(this,"rules");be(this,"lexer");this.options=e||as}space(e){const n=this.rules.block.newline.exec(e);if(n&&n[0].length>0)return{type:"space",raw:n[0]}}code(e){const n=this.rules.block.code.exec(e);if(n){const r=n[0].replace(/^(?: {1,4}| {0,3}\t)/gm,"");return{type:"code",raw:n[0],codeBlockStyle:"indented",text:this.options.pedantic?r:ta(r,`
`)}}}fences(e){const n=this.rules.block.fences.exec(e);if(n){const r=n[0],i=m4(r,n[3]||"");return{type:"code",raw:r,lang:n[2]?n[2].trim().replace(this.rules.inline.anyPunctuation,"$1"):n[2],text:i}}}heading(e){const n=this.rules.block.heading.exec(e);if(n){let r=n[2].trim();if(/#$/.test(r)){const i=ta(r,"#");(this.options.pedantic||!i||/ $/.test(i))&&(r=i.trim())}return{type:"heading",raw:n[0],depth:n[1].length,text:r,tokens:this.lexer.inline(r)}}}hr(e){const n=this.rules.block.hr.exec(e);if(n)return{type:"hr",raw:ta(n[0],`
`)}}blockquote(e){const n=this.rules.block.blockquote.exec(e);if(n){let r=ta(n[0],`
`).split(`
`),i="",s="";const o=[];for(;r.length>0;){let a=!1;const u=[];let c;for(c=0;c<r.length;c++)if(/^ {0,3}>/.test(r[c]))u.push(r[c]),a=!0;else if(!a)u.push(r[c]);else break;r=r.slice(c);const d=u.join(`
`),f=d.replace(/\n {0,3}((?:=+|-+) *)(?=\n|$)/g,`
    $1`).replace(/^ {0,3}>[ \t]?/gm,"");i=i?`${i}
${d}`:d,s=s?`${s}
${f}`:f;const m=this.lexer.state.top;if(this.lexer.state.top=!0,this.lexer.blockTokens(f,o,!0),this.lexer.state.top=m,r.length===0)break;const w=o[o.length-1];if((w==null?void 0:w.type)==="code")break;if((w==null?void 0:w.type)==="blockquote"){const I=w,P=I.raw+`
`+r.join(`
`),O=this.blockquote(P);o[o.length-1]=O,i=i.substring(0,i.length-I.raw.length)+O.raw,s=s.substring(0,s.length-I.text.length)+O.text;break}else if((w==null?void 0:w.type)==="list"){const I=w,P=I.raw+`
`+r.join(`
`),O=this.list(P);o[o.length-1]=O,i=i.substring(0,i.length-w.raw.length)+O.raw,s=s.substring(0,s.length-I.raw.length)+O.raw,r=P.substring(o[o.length-1].raw.length).split(`
`);continue}}return{type:"blockquote",raw:i,tokens:o,text:s}}}list(e){let n=this.rules.block.list.exec(e);if(n){let r=n[1].trim();const i=r.length>1,s={type:"list",raw:"",ordered:i,start:i?+r.slice(0,-1):"",loose:!1,items:[]};r=i?`\\d{1,9}\\${r.slice(-1)}`:`\\${r}`,this.options.pedantic&&(r=i?r:"[*+-]");const o=new RegExp(`^( {0,3}${r})((?:[	 ][^\\n]*)?(?:\\n|$))`);let a=!1;for(;e;){let u=!1,c="",d="";if(!(n=o.exec(e))||this.rules.block.hr.test(e))break;c=n[0],e=e.substring(c.length);let f=n[2].split(`
`,1)[0].replace(/^\t+/,C=>" ".repeat(3*C.length)),m=e.split(`
`,1)[0],w=!f.trim(),I=0;if(this.options.pedantic?(I=2,d=f.trimStart()):w?I=n[1].length+1:(I=n[2].search(/[^ ]/),I=I>4?1:I,d=f.slice(I),I+=n[1].length),w&&/^[ \t]*$/.test(m)&&(c+=m+`
`,e=e.substring(m.length+1),u=!0),!u){const C=new RegExp(`^ {0,${Math.min(3,I-1)}}(?:[*+-]|\\d{1,9}[.)])((?:[ 	][^\\n]*)?(?:\\n|$))`),T=new RegExp(`^ {0,${Math.min(3,I-1)}}((?:- *){3,}|(?:_ *){3,}|(?:\\* *){3,})(?:\\n+|$)`),S=new RegExp(`^ {0,${Math.min(3,I-1)}}(?:\`\`\`|~~~)`),M=new RegExp(`^ {0,${Math.min(3,I-1)}}#`),V=new RegExp(`^ {0,${Math.min(3,I-1)}}<(?:[a-z].*>|!--)`,"i");for(;e;){const F=e.split(`
`,1)[0];let y;if(m=F,this.options.pedantic?(m=m.replace(/^ {1,4}(?=( {4})*[^ ])/g,"  "),y=m):y=m.replace(/\t/g,"    "),S.test(m)||M.test(m)||V.test(m)||C.test(m)||T.test(m))break;if(y.search(/[^ ]/)>=I||!m.trim())d+=`
`+y.slice(I);else{if(w||f.replace(/\t/g,"    ").search(/[^ ]/)>=4||S.test(f)||M.test(f)||T.test(f))break;d+=`
`+m}!w&&!m.trim()&&(w=!0),c+=F+`
`,e=e.substring(F.length+1),f=y.slice(I)}}s.loose||(a?s.loose=!0:/\n[ \t]*\n[ \t]*$/.test(c)&&(a=!0));let P=null,O;this.options.gfm&&(P=/^\[[ xX]\] /.exec(d),P&&(O=P[0]!=="[ ] ",d=d.replace(/^\[[ xX]\] +/,""))),s.items.push({type:"list_item",raw:c,task:!!P,checked:O,loose:!1,text:d,tokens:[]}),s.raw+=c}s.items[s.items.length-1].raw=s.items[s.items.length-1].raw.trimEnd(),s.items[s.items.length-1].text=s.items[s.items.length-1].text.trimEnd(),s.raw=s.raw.trimEnd();for(let u=0;u<s.items.length;u++)if(this.lexer.state.top=!1,s.items[u].tokens=this.lexer.blockTokens(s.items[u].text,[]),!s.loose){const c=s.items[u].tokens.filter(f=>f.type==="space"),d=c.length>0&&c.some(f=>/\n.*\n/.test(f.raw));s.loose=d}if(s.loose)for(let u=0;u<s.items.length;u++)s.items[u].loose=!0;return s}}html(e){const n=this.rules.block.html.exec(e);if(n)return{type:"html",block:!0,raw:n[0],pre:n[1]==="pre"||n[1]==="script"||n[1]==="style",text:n[0]}}def(e){const n=this.rules.block.def.exec(e);if(n){const r=n[1].toLowerCase().replace(/\s+/g," "),i=n[2]?n[2].replace(/^<(.*)>$/,"$1").replace(this.rules.inline.anyPunctuation,"$1"):"",s=n[3]?n[3].substring(1,n[3].length-1).replace(this.rules.inline.anyPunctuation,"$1"):n[3];return{type:"def",tag:r,raw:n[0],href:i,title:s}}}table(e){const n=this.rules.block.table.exec(e);if(!n||!/[:|]/.test(n[2]))return;const r=v0(n[1]),i=n[2].replace(/^\||\| *$/g,"").split("|"),s=n[3]&&n[3].trim()?n[3].replace(/\n[ \t]*$/,"").split(`
`):[],o={type:"table",raw:n[0],header:[],align:[],rows:[]};if(r.length===i.length){for(const a of i)/^ *-+: *$/.test(a)?o.align.push("right"):/^ *:-+: *$/.test(a)?o.align.push("center"):/^ *:-+ *$/.test(a)?o.align.push("left"):o.align.push(null);for(let a=0;a<r.length;a++)o.header.push({text:r[a],tokens:this.lexer.inline(r[a]),header:!0,align:o.align[a]});for(const a of s)o.rows.push(v0(a,o.header.length).map((u,c)=>({text:u,tokens:this.lexer.inline(u),header:!1,align:o.align[c]})));return o}}lheading(e){const n=this.rules.block.lheading.exec(e);if(n)return{type:"heading",raw:n[0],depth:n[2].charAt(0)==="="?1:2,text:n[1],tokens:this.lexer.inline(n[1])}}paragraph(e){const n=this.rules.block.paragraph.exec(e);if(n){const r=n[1].charAt(n[1].length-1)===`
`?n[1].slice(0,-1):n[1];return{type:"paragraph",raw:n[0],text:r,tokens:this.lexer.inline(r)}}}text(e){const n=this.rules.block.text.exec(e);if(n)return{type:"text",raw:n[0],text:n[0],tokens:this.lexer.inline(n[0])}}escape(e){const n=this.rules.inline.escape.exec(e);if(n)return{type:"escape",raw:n[0],text:sn(n[1])}}tag(e){const n=this.rules.inline.tag.exec(e);if(n)return!this.lexer.state.inLink&&/^<a /i.test(n[0])?this.lexer.state.inLink=!0:this.lexer.state.inLink&&/^<\/a>/i.test(n[0])&&(this.lexer.state.inLink=!1),!this.lexer.state.inRawBlock&&/^<(pre|code|kbd|script)(\s|>)/i.test(n[0])?this.lexer.state.inRawBlock=!0:this.lexer.state.inRawBlock&&/^<\/(pre|code|kbd|script)(\s|>)/i.test(n[0])&&(this.lexer.state.inRawBlock=!1),{type:"html",raw:n[0],inLink:this.lexer.state.inLink,inRawBlock:this.lexer.state.inRawBlock,block:!1,text:n[0]}}link(e){const n=this.rules.inline.link.exec(e);if(n){const r=n[2].trim();if(!this.options.pedantic&&/^</.test(r)){if(!/>$/.test(r))return;const o=ta(r.slice(0,-1),"\\");if((r.length-o.length)%2===0)return}else{const o=p4(n[2],"()");if(o>-1){const u=(n[0].indexOf("!")===0?5:4)+n[1].length+o;n[2]=n[2].substring(0,o),n[0]=n[0].substring(0,u).trim(),n[3]=""}}let i=n[2],s="";if(this.options.pedantic){const o=/^([^'"]*[^\s])\s+(['"])(.*)\2/.exec(i);o&&(i=o[1],s=o[3])}else s=n[3]?n[3].slice(1,-1):"";return i=i.trim(),/^</.test(i)&&(this.options.pedantic&&!/>$/.test(r)?i=i.slice(1):i=i.slice(1,-1)),w0(n,{href:i&&i.replace(this.rules.inline.anyPunctuation,"$1"),title:s&&s.replace(this.rules.inline.anyPunctuation,"$1")},n[0],this.lexer)}}reflink(e,n){let r;if((r=this.rules.inline.reflink.exec(e))||(r=this.rules.inline.nolink.exec(e))){const i=(r[2]||r[1]).replace(/\s+/g," "),s=n[i.toLowerCase()];if(!s){const o=r[0].charAt(0);return{type:"text",raw:o,text:o}}return w0(r,s,r[0],this.lexer)}}emStrong(e,n,r=""){let i=this.rules.inline.emStrongLDelim.exec(e);if(!i||i[3]&&r.match(/[\p{L}\p{N}]/u))return;if(!(i[1]||i[2]||"")||!r||this.rules.inline.punctuation.exec(r)){const o=[...i[0]].length-1;let a,u,c=o,d=0;const f=i[0][0]==="*"?this.rules.inline.emStrongRDelimAst:this.rules.inline.emStrongRDelimUnd;for(f.lastIndex=0,n=n.slice(-1*e.length+o);(i=f.exec(n))!=null;){if(a=i[1]||i[2]||i[3]||i[4]||i[5]||i[6],!a)continue;if(u=[...a].length,i[3]||i[4]){c+=u;continue}else if((i[5]||i[6])&&o%3&&!((o+u)%3)){d+=u;continue}if(c-=u,c>0)continue;u=Math.min(u,u+c+d);const m=[...i[0]][0].length,w=e.slice(0,o+i.index+m+u);if(Math.min(o,u)%2){const P=w.slice(1,-1);return{type:"em",raw:w,text:P,tokens:this.lexer.inlineTokens(P)}}const I=w.slice(2,-2);return{type:"strong",raw:w,text:I,tokens:this.lexer.inlineTokens(I)}}}}codespan(e){const n=this.rules.inline.code.exec(e);if(n){let r=n[2].replace(/\n/g," ");const i=/[^ ]/.test(r),s=/^ /.test(r)&&/ $/.test(r);return i&&s&&(r=r.substring(1,r.length-1)),r=sn(r,!0),{type:"codespan",raw:n[0],text:r}}}br(e){const n=this.rules.inline.br.exec(e);if(n)return{type:"br",raw:n[0]}}del(e){const n=this.rules.inline.del.exec(e);if(n)return{type:"del",raw:n[0],text:n[2],tokens:this.lexer.inlineTokens(n[2])}}autolink(e){const n=this.rules.inline.autolink.exec(e);if(n){let r,i;return n[2]==="@"?(r=sn(n[1]),i="mailto:"+r):(r=sn(n[1]),i=r),{type:"link",raw:n[0],text:r,href:i,tokens:[{type:"text",raw:r,text:r}]}}}url(e){var r;let n;if(n=this.rules.inline.url.exec(e)){let i,s;if(n[2]==="@")i=sn(n[0]),s="mailto:"+i;else{let o;do o=n[0],n[0]=((r=this.rules.inline._backpedal.exec(n[0]))==null?void 0:r[0])??"";while(o!==n[0]);i=sn(n[0]),n[1]==="www."?s="http://"+n[0]:s=n[0]}return{type:"link",raw:n[0],text:i,href:s,tokens:[{type:"text",raw:i,text:i}]}}}inlineText(e){const n=this.rules.inline.text.exec(e);if(n){let r;return this.lexer.state.inRawBlock?r=n[0]:r=sn(n[0]),{type:"text",raw:n[0],text:r}}}}const g4=/^(?:[ \t]*(?:\n|$))+/,_4=/^((?: {4}| {0,3}\t)[^\n]+(?:\n(?:[ \t]*(?:\n|$))*)?)+/,y4=/^ {0,3}(`{3,}(?=[^`\n]*(?:\n|$))|~{3,})([^\n]*)(?:\n|$)(?:|([\s\S]*?)(?:\n|$))(?: {0,3}\1[~`]* *(?=\n|$)|$)/,Pl=/^ {0,3}((?:-[\t ]*){3,}|(?:_[ \t]*){3,}|(?:\*[ \t]*){3,})(?:\n+|$)/,v4=/^ {0,3}(#{1,6})(?=\s|$)(.*)(?:\n+|$)/,D1=/(?:[*+-]|\d{1,9}[.)])/,M1=Ae(/^(?!bull |blockCode|fences|blockquote|heading|html)((?:.|\n(?!\s*?\n|bull |blockCode|fences|blockquote|heading|html))+?)\n {0,3}(=+|-+) *(?:\n+|$)/).replace(/bull/g,D1).replace(/blockCode/g,/(?: {4}| {0,3}\t)/).replace(/fences/g,/ {0,3}(?:`{3,}|~{3,})/).replace(/blockquote/g,/ {0,3}>/).replace(/heading/g,/ {0,3}#{1,6}/).replace(/html/g,/ {0,3}<[^\n>]+>\n/).getRegex(),n_=/^([^\n]+(?:\n(?!hr|heading|lheading|blockquote|fences|list|html|table| +\n)[^\n]+)*)/,w4=/^[^\n]+/,r_=/(?!\s*\])(?:\\.|[^\[\]\\])+/,E4=Ae(/^ {0,3}\[(label)\]: *(?:\n[ \t]*)?([^<\s][^\s]*|<.*?>)(?:(?: +(?:\n[ \t]*)?| *\n[ \t]*)(title))? *(?:\n+|$)/).replace("label",r_).replace("title",/(?:"(?:\\"?|[^"\\])*"|'[^'\n]*(?:\n[^'\n]+)*\n?'|\([^()]*\))/).getRegex(),T4=Ae(/^( {0,3}bull)([ \t][^\n]+?)?(?:\n|$)/).replace(/bull/g,D1).getRegex(),Lh="address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h[1-6]|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|meta|nav|noframes|ol|optgroup|option|p|param|search|section|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul",i_=/<!--(?:-?>|[\s\S]*?(?:-->|$))/,I4=Ae("^ {0,3}(?:<(script|pre|style|textarea)[\\s>][\\s\\S]*?(?:</\\1>[^\\n]*\\n+|$)|comment[^\\n]*(\\n+|$)|<\\?[\\s\\S]*?(?:\\?>\\n*|$)|<![A-Z][\\s\\S]*?(?:>\\n*|$)|<!\\[CDATA\\[[\\s\\S]*?(?:\\]\\]>\\n*|$)|</?(tag)(?: +|\\n|/?>)[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$)|<(?!script|pre|style|textarea)([a-z][\\w-]*)(?:attribute)*? */?>(?=[ \\t]*(?:\\n|$))[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$)|</(?!script|pre|style|textarea)[a-z][\\w-]*\\s*>(?=[ \\t]*(?:\\n|$))[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$))","i").replace("comment",i_).replace("tag",Lh).replace("attribute",/ +[a-zA-Z:_][\w.:-]*(?: *= *"[^"\n]*"| *= *'[^'\n]*'| *= *[^\s"'=<>`]+)?/).getRegex(),L1=Ae(n_).replace("hr",Pl).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("|lheading","").replace("|table","").replace("blockquote"," {0,3}>").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Lh).getRegex(),S4=Ae(/^( {0,3}> ?(paragraph|[^\n]*)(?:\n|$))+/).replace("paragraph",L1).getRegex(),s_={blockquote:S4,code:_4,def:E4,fences:y4,heading:v4,hr:Pl,html:I4,lheading:M1,list:T4,newline:g4,paragraph:L1,table:Pa,text:w4},E0=Ae("^ *([^\\n ].*)\\n {0,3}((?:\\| *)?:?-+:? *(?:\\| *:?-+:? *)*(?:\\| *)?)(?:\\n((?:(?! *\\n|hr|heading|blockquote|code|fences|list|html).*(?:\\n|$))*)\\n*|$)").replace("hr",Pl).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("blockquote"," {0,3}>").replace("code","(?: {4}| {0,3}	)[^\\n]").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Lh).getRegex(),k4={...s_,table:E0,paragraph:Ae(n_).replace("hr",Pl).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("|lheading","").replace("table",E0).replace("blockquote"," {0,3}>").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Lh).getRegex()},C4={...s_,html:Ae(`^ *(?:comment *(?:\\n|\\s*$)|<(tag)[\\s\\S]+?</\\1> *(?:\\n{2,}|\\s*$)|<tag(?:"[^"]*"|'[^']*'|\\s[^'"/>\\s]*)*?/?> *(?:\\n{2,}|\\s*$))`).replace("comment",i_).replace(/tag/g,"(?!(?:a|em|strong|small|s|cite|q|dfn|abbr|data|time|code|var|samp|kbd|sub|sup|i|b|u|mark|ruby|rt|rp|bdi|bdo|span|br|wbr|ins|del|img)\\b)\\w+(?!:|[^\\w\\s@]*@)\\b").getRegex(),def:/^ *\[([^\]]+)\]: *<?([^\s>]+)>?(?: +(["(][^\n]+[")]))? *(?:\n+|$)/,heading:/^(#{1,6})(.*)(?:\n+|$)/,fences:Pa,lheading:/^(.+?)\n {0,3}(=+|-+) *(?:\n+|$)/,paragraph:Ae(n_).replace("hr",Pl).replace("heading",` *#{1,6} *[^
]`).replace("lheading",M1).replace("|table","").replace("blockquote"," {0,3}>").replace("|fences","").replace("|list","").replace("|html","").replace("|tag","").getRegex()},V1=/^\\([!"#$%&'()*+,\-./:;<=>?@\[\]\\^_`{|}~])/,R4=/^(`+)([^`]|[^`][\s\S]*?[^`])\1(?!`)/,F1=/^( {2,}|\\)\n(?!\s*$)/,A4=/^(`+|[^`])(?:(?= {2,}\n)|[\s\S]*?(?:(?=[\\<!\[`*_]|\b_|$)|[^ ](?= {2,}\n)))/,bl="\\p{P}\\p{S}",x4=Ae(/^((?![*_])[\spunctuation])/,"u").replace(/punctuation/g,bl).getRegex(),P4=/\[[^[\]]*?\]\((?:\\.|[^\\\(\)]|\((?:\\.|[^\\\(\)])*\))*\)|`[^`]*?`|<[^<>]*?>/g,b4=Ae(/^(?:\*+(?:((?!\*)[punct])|[^\s*]))|^_+(?:((?!_)[punct])|([^\s_]))/,"u").replace(/punct/g,bl).getRegex(),N4=Ae("^[^_*]*?__[^_*]*?\\*[^_*]*?(?=__)|[^*]+(?=[^*])|(?!\\*)[punct](\\*+)(?=[\\s]|$)|[^punct\\s](\\*+)(?!\\*)(?=[punct\\s]|$)|(?!\\*)[punct\\s](\\*+)(?=[^punct\\s])|[\\s](\\*+)(?!\\*)(?=[punct])|(?!\\*)[punct](\\*+)(?!\\*)(?=[punct])|[^punct\\s](\\*+)(?=[^punct\\s])","gu").replace(/punct/g,bl).getRegex(),O4=Ae("^[^_*]*?\\*\\*[^_*]*?_[^_*]*?(?=\\*\\*)|[^_]+(?=[^_])|(?!_)[punct](_+)(?=[\\s]|$)|[^punct\\s](_+)(?!_)(?=[punct\\s]|$)|(?!_)[punct\\s](_+)(?=[^punct\\s])|[\\s](_+)(?!_)(?=[punct])|(?!_)[punct](_+)(?!_)(?=[punct])","gu").replace(/punct/g,bl).getRegex(),D4=Ae(/\\([punct])/,"gu").replace(/punct/g,bl).getRegex(),M4=Ae(/^<(scheme:[^\s\x00-\x1f<>]*|email)>/).replace("scheme",/[a-zA-Z][a-zA-Z0-9+.-]{1,31}/).replace("email",/[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(@)[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)+(?![-_])/).getRegex(),L4=Ae(i_).replace("(?:-->|$)","-->").getRegex(),V4=Ae("^comment|^</[a-zA-Z][\\w:-]*\\s*>|^<[a-zA-Z][\\w-]*(?:attribute)*?\\s*/?>|^<\\?[\\s\\S]*?\\?>|^<![a-zA-Z]+\\s[\\s\\S]*?>|^<!\\[CDATA\\[[\\s\\S]*?\\]\\]>").replace("comment",L4).replace("attribute",/\s+[a-zA-Z:_][\w.:-]*(?:\s*=\s*"[^"]*"|\s*=\s*'[^']*'|\s*=\s*[^\s"'=<>`]+)?/).getRegex(),$c=/(?:\[(?:\\.|[^\[\]\\])*\]|\\.|`[^`]*`|[^\[\]\\`])*?/,F4=Ae(/^!?\[(label)\]\(\s*(href)(?:\s+(title))?\s*\)/).replace("label",$c).replace("href",/<(?:\\.|[^\n<>\\])+>|[^\s\x00-\x1f]*/).replace("title",/"(?:\\"?|[^"\\])*"|'(?:\\'?|[^'\\])*'|\((?:\\\)?|[^)\\])*\)/).getRegex(),U1=Ae(/^!?\[(label)\]\[(ref)\]/).replace("label",$c).replace("ref",r_).getRegex(),j1=Ae(/^!?\[(ref)\](?:\[\])?/).replace("ref",r_).getRegex(),U4=Ae("reflink|nolink(?!\\()","g").replace("reflink",U1).replace("nolink",j1).getRegex(),o_={_backpedal:Pa,anyPunctuation:D4,autolink:M4,blockSkip:P4,br:F1,code:R4,del:Pa,emStrongLDelim:b4,emStrongRDelimAst:N4,emStrongRDelimUnd:O4,escape:V1,link:F4,nolink:j1,punctuation:x4,reflink:U1,reflinkSearch:U4,tag:V4,text:A4,url:Pa},j4={...o_,link:Ae(/^!?\[(label)\]\((.*?)\)/).replace("label",$c).getRegex(),reflink:Ae(/^!?\[(label)\]\s*\[([^\]]*)\]/).replace("label",$c).getRegex()},Op={...o_,escape:Ae(V1).replace("])","~|])").getRegex(),url:Ae(/^((?:ftp|https?):\/\/|www\.)(?:[a-zA-Z0-9\-]+\.?)+[^\s<]*|^email/,"i").replace("email",/[A-Za-z0-9._+-]+(@)[a-zA-Z0-9-_]+(?:\.[a-zA-Z0-9-_]*[a-zA-Z0-9])+(?![-_])/).getRegex(),_backpedal:/(?:[^?!.,:;*_'"~()&]+|\([^)]*\)|&(?![a-zA-Z0-9]+;$)|[?!.,:;*_'"~)]+(?!$))+/,del:/^(~~?)(?=[^\s~])((?:\\.|[^\\])*?(?:\\.|[^\s~\\]))\1(?=[^~]|$)/,text:/^([`~]+|[^`~])(?:(?= {2,}\n)|(?=[a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-]+@)|[\s\S]*?(?:(?=[\\<!\[`*~_]|\b_|https?:\/\/|ftp:\/\/|www\.|$)|[^ ](?= {2,}\n)|[^a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-](?=[a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-]+@)))/},z4={...Op,br:Ae(F1).replace("{2,}","*").getRegex(),text:Ae(Op.text).replace("\\b_","\\b_| {2,}\\n").replace(/\{2,\}/g,"*").getRegex()},Iu={normal:s_,gfm:k4,pedantic:C4},na={normal:o_,gfm:Op,breaks:z4,pedantic:j4};class _n{constructor(e){be(this,"tokens");be(this,"options");be(this,"state");be(this,"tokenizer");be(this,"inlineQueue");this.tokens=[],this.tokens.links=Object.create(null),this.options=e||as,this.options.tokenizer=this.options.tokenizer||new Bc,this.tokenizer=this.options.tokenizer,this.tokenizer.options=this.options,this.tokenizer.lexer=this,this.inlineQueue=[],this.state={inLink:!1,inRawBlock:!1,top:!0};const n={block:Iu.normal,inline:na.normal};this.options.pedantic?(n.block=Iu.pedantic,n.inline=na.pedantic):this.options.gfm&&(n.block=Iu.gfm,this.options.breaks?n.inline=na.breaks:n.inline=na.gfm),this.tokenizer.rules=n}static get rules(){return{block:Iu,inline:na}}static lex(e,n){return new _n(n).lex(e)}static lexInline(e,n){return new _n(n).inlineTokens(e)}lex(e){e=e.replace(/\r\n|\r/g,`
`),this.blockTokens(e,this.tokens);for(let n=0;n<this.inlineQueue.length;n++){const r=this.inlineQueue[n];this.inlineTokens(r.src,r.tokens)}return this.inlineQueue=[],this.tokens}blockTokens(e,n=[],r=!1){this.options.pedantic&&(e=e.replace(/\t/g,"    ").replace(/^ +$/gm,""));let i,s,o;for(;e;)if(!(this.options.extensions&&this.options.extensions.block&&this.options.extensions.block.some(a=>(i=a.call({lexer:this},e,n))?(e=e.substring(i.raw.length),n.push(i),!0):!1))){if(i=this.tokenizer.space(e)){e=e.substring(i.raw.length),i.raw.length===1&&n.length>0?n[n.length-1].raw+=`
`:n.push(i);continue}if(i=this.tokenizer.code(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&(s.type==="paragraph"||s.type==="text")?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i);continue}if(i=this.tokenizer.fences(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.heading(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.hr(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.blockquote(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.list(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.html(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.def(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&(s.type==="paragraph"||s.type==="text")?(s.raw+=`
`+i.raw,s.text+=`
`+i.raw,this.inlineQueue[this.inlineQueue.length-1].src=s.text):this.tokens.links[i.tag]||(this.tokens.links[i.tag]={href:i.href,title:i.title});continue}if(i=this.tokenizer.table(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.lheading(e)){e=e.substring(i.raw.length),n.push(i);continue}if(o=e,this.options.extensions&&this.options.extensions.startBlock){let a=1/0;const u=e.slice(1);let c;this.options.extensions.startBlock.forEach(d=>{c=d.call({lexer:this},u),typeof c=="number"&&c>=0&&(a=Math.min(a,c))}),a<1/0&&a>=0&&(o=e.substring(0,a+1))}if(this.state.top&&(i=this.tokenizer.paragraph(o))){s=n[n.length-1],r&&(s==null?void 0:s.type)==="paragraph"?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue.pop(),this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i),r=o.length!==e.length,e=e.substring(i.raw.length);continue}if(i=this.tokenizer.text(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&s.type==="text"?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue.pop(),this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i);continue}if(e){const a="Infinite loop on byte: "+e.charCodeAt(0);if(this.options.silent){console.error(a);break}else throw new Error(a)}}return this.state.top=!0,n}inline(e,n=[]){return this.inlineQueue.push({src:e,tokens:n}),n}inlineTokens(e,n=[]){let r,i,s,o=e,a,u,c;if(this.tokens.links){const d=Object.keys(this.tokens.links);if(d.length>0)for(;(a=this.tokenizer.rules.inline.reflinkSearch.exec(o))!=null;)d.includes(a[0].slice(a[0].lastIndexOf("[")+1,-1))&&(o=o.slice(0,a.index)+"["+"a".repeat(a[0].length-2)+"]"+o.slice(this.tokenizer.rules.inline.reflinkSearch.lastIndex))}for(;(a=this.tokenizer.rules.inline.blockSkip.exec(o))!=null;)o=o.slice(0,a.index)+"["+"a".repeat(a[0].length-2)+"]"+o.slice(this.tokenizer.rules.inline.blockSkip.lastIndex);for(;(a=this.tokenizer.rules.inline.anyPunctuation.exec(o))!=null;)o=o.slice(0,a.index)+"++"+o.slice(this.tokenizer.rules.inline.anyPunctuation.lastIndex);for(;e;)if(u||(c=""),u=!1,!(this.options.extensions&&this.options.extensions.inline&&this.options.extensions.inline.some(d=>(r=d.call({lexer:this},e,n))?(e=e.substring(r.raw.length),n.push(r),!0):!1))){if(r=this.tokenizer.escape(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.tag(e)){e=e.substring(r.raw.length),i=n[n.length-1],i&&r.type==="text"&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(r=this.tokenizer.link(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.reflink(e,this.tokens.links)){e=e.substring(r.raw.length),i=n[n.length-1],i&&r.type==="text"&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(r=this.tokenizer.emStrong(e,o,c)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.codespan(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.br(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.del(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.autolink(e)){e=e.substring(r.raw.length),n.push(r);continue}if(!this.state.inLink&&(r=this.tokenizer.url(e))){e=e.substring(r.raw.length),n.push(r);continue}if(s=e,this.options.extensions&&this.options.extensions.startInline){let d=1/0;const f=e.slice(1);let m;this.options.extensions.startInline.forEach(w=>{m=w.call({lexer:this},f),typeof m=="number"&&m>=0&&(d=Math.min(d,m))}),d<1/0&&d>=0&&(s=e.substring(0,d+1))}if(r=this.tokenizer.inlineText(s)){e=e.substring(r.raw.length),r.raw.slice(-1)!=="_"&&(c=r.raw.slice(-1)),u=!0,i=n[n.length-1],i&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(e){const d="Infinite loop on byte: "+e.charCodeAt(0);if(this.options.silent){console.error(d);break}else throw new Error(d)}}return n}}class Wc{constructor(e){be(this,"options");be(this,"parser");this.options=e||as}space(e){return""}code({text:e,lang:n,escaped:r}){var o;const i=(o=(n||"").match(/^\S*/))==null?void 0:o[0],s=e.replace(/\n$/,"")+`
`;return i?'<pre><code class="language-'+sn(i)+'">'+(r?s:sn(s,!0))+`</code></pre>
`:"<pre><code>"+(r?s:sn(s,!0))+`</code></pre>
`}blockquote({tokens:e}){return`<blockquote>
${this.parser.parse(e)}</blockquote>
`}html({text:e}){return e}heading({tokens:e,depth:n}){return`<h${n}>${this.parser.parseInline(e)}</h${n}>
`}hr(e){return`<hr>
`}list(e){const n=e.ordered,r=e.start;let i="";for(let a=0;a<e.items.length;a++){const u=e.items[a];i+=this.listitem(u)}const s=n?"ol":"ul",o=n&&r!==1?' start="'+r+'"':"";return"<"+s+o+`>
`+i+"</"+s+`>
`}listitem(e){let n="";if(e.task){const r=this.checkbox({checked:!!e.checked});e.loose?e.tokens.length>0&&e.tokens[0].type==="paragraph"?(e.tokens[0].text=r+" "+e.tokens[0].text,e.tokens[0].tokens&&e.tokens[0].tokens.length>0&&e.tokens[0].tokens[0].type==="text"&&(e.tokens[0].tokens[0].text=r+" "+e.tokens[0].tokens[0].text)):e.tokens.unshift({type:"text",raw:r+" ",text:r+" "}):n+=r+" "}return n+=this.parser.parse(e.tokens,!!e.loose),`<li>${n}</li>
`}checkbox({checked:e}){return"<input "+(e?'checked="" ':"")+'disabled="" type="checkbox">'}paragraph({tokens:e}){return`<p>${this.parser.parseInline(e)}</p>
`}table(e){let n="",r="";for(let s=0;s<e.header.length;s++)r+=this.tablecell(e.header[s]);n+=this.tablerow({text:r});let i="";for(let s=0;s<e.rows.length;s++){const o=e.rows[s];r="";for(let a=0;a<o.length;a++)r+=this.tablecell(o[a]);i+=this.tablerow({text:r})}return i&&(i=`<tbody>${i}</tbody>`),`<table>
<thead>
`+n+`</thead>
`+i+`</table>
`}tablerow({text:e}){return`<tr>
${e}</tr>
`}tablecell(e){const n=this.parser.parseInline(e.tokens),r=e.header?"th":"td";return(e.align?`<${r} align="${e.align}">`:`<${r}>`)+n+`</${r}>
`}strong({tokens:e}){return`<strong>${this.parser.parseInline(e)}</strong>`}em({tokens:e}){return`<em>${this.parser.parseInline(e)}</em>`}codespan({text:e}){return`<code>${e}</code>`}br(e){return"<br>"}del({tokens:e}){return`<del>${this.parser.parseInline(e)}</del>`}link({href:e,title:n,tokens:r}){const i=this.parser.parseInline(r),s=y0(e);if(s===null)return i;e=s;let o='<a href="'+e+'"';return n&&(o+=' title="'+n+'"'),o+=">"+i+"</a>",o}image({href:e,title:n,text:r}){const i=y0(e);if(i===null)return r;e=i;let s=`<img src="${e}" alt="${r}"`;return n&&(s+=` title="${n}"`),s+=">",s}text(e){return"tokens"in e&&e.tokens?this.parser.parseInline(e.tokens):e.text}}class a_{strong({text:e}){return e}em({text:e}){return e}codespan({text:e}){return e}del({text:e}){return e}html({text:e}){return e}text({text:e}){return e}link({text:e}){return""+e}image({text:e}){return""+e}br(){return""}}class yn{constructor(e){be(this,"options");be(this,"renderer");be(this,"textRenderer");this.options=e||as,this.options.renderer=this.options.renderer||new Wc,this.renderer=this.options.renderer,this.renderer.options=this.options,this.renderer.parser=this,this.textRenderer=new a_}static parse(e,n){return new yn(n).parse(e)}static parseInline(e,n){return new yn(n).parseInline(e)}parse(e,n=!0){let r="";for(let i=0;i<e.length;i++){const s=e[i];if(this.options.extensions&&this.options.extensions.renderers&&this.options.extensions.renderers[s.type]){const a=s,u=this.options.extensions.renderers[a.type].call({parser:this},a);if(u!==!1||!["space","hr","heading","code","table","blockquote","list","html","paragraph","text"].includes(a.type)){r+=u||"";continue}}const o=s;switch(o.type){case"space":{r+=this.renderer.space(o);continue}case"hr":{r+=this.renderer.hr(o);continue}case"heading":{r+=this.renderer.heading(o);continue}case"code":{r+=this.renderer.code(o);continue}case"table":{r+=this.renderer.table(o);continue}case"blockquote":{r+=this.renderer.blockquote(o);continue}case"list":{r+=this.renderer.list(o);continue}case"html":{r+=this.renderer.html(o);continue}case"paragraph":{r+=this.renderer.paragraph(o);continue}case"text":{let a=o,u=this.renderer.text(a);for(;i+1<e.length&&e[i+1].type==="text";)a=e[++i],u+=`
`+this.renderer.text(a);n?r+=this.renderer.paragraph({type:"paragraph",raw:u,text:u,tokens:[{type:"text",raw:u,text:u}]}):r+=u;continue}default:{const a='Token with "'+o.type+'" type was not found.';if(this.options.silent)return console.error(a),"";throw new Error(a)}}}return r}parseInline(e,n){n=n||this.renderer;let r="";for(let i=0;i<e.length;i++){const s=e[i];if(this.options.extensions&&this.options.extensions.renderers&&this.options.extensions.renderers[s.type]){const a=this.options.extensions.renderers[s.type].call({parser:this},s);if(a!==!1||!["escape","html","link","image","strong","em","codespan","br","del","text"].includes(s.type)){r+=a||"";continue}}const o=s;switch(o.type){case"escape":{r+=n.text(o);break}case"html":{r+=n.html(o);break}case"link":{r+=n.link(o);break}case"image":{r+=n.image(o);break}case"strong":{r+=n.strong(o);break}case"em":{r+=n.em(o);break}case"codespan":{r+=n.codespan(o);break}case"br":{r+=n.br(o);break}case"del":{r+=n.del(o);break}case"text":{r+=n.text(o);break}default:{const a='Token with "'+o.type+'" type was not found.';if(this.options.silent)return console.error(a),"";throw new Error(a)}}}return r}}class ba{constructor(e){be(this,"options");be(this,"block");this.options=e||as}preprocess(e){return e}postprocess(e){return e}processAllTokens(e){return e}provideLexer(){return this.block?_n.lex:_n.lexInline}provideParser(){return this.block?yn.parse:yn.parseInline}}be(ba,"passThroughHooks",new Set(["preprocess","postprocess","processAllTokens"]));class B4{constructor(...e){be(this,"defaults",t_());be(this,"options",this.setOptions);be(this,"parse",this.parseMarkdown(!0));be(this,"parseInline",this.parseMarkdown(!1));be(this,"Parser",yn);be(this,"Renderer",Wc);be(this,"TextRenderer",a_);be(this,"Lexer",_n);be(this,"Tokenizer",Bc);be(this,"Hooks",ba);this.use(...e)}walkTokens(e,n){var i,s;let r=[];for(const o of e)switch(r=r.concat(n.call(this,o)),o.type){case"table":{const a=o;for(const u of a.header)r=r.concat(this.walkTokens(u.tokens,n));for(const u of a.rows)for(const c of u)r=r.concat(this.walkTokens(c.tokens,n));break}case"list":{const a=o;r=r.concat(this.walkTokens(a.items,n));break}default:{const a=o;(s=(i=this.defaults.extensions)==null?void 0:i.childTokens)!=null&&s[a.type]?this.defaults.extensions.childTokens[a.type].forEach(u=>{const c=a[u].flat(1/0);r=r.concat(this.walkTokens(c,n))}):a.tokens&&(r=r.concat(this.walkTokens(a.tokens,n)))}}return r}use(...e){const n=this.defaults.extensions||{renderers:{},childTokens:{}};return e.forEach(r=>{const i={...r};if(i.async=this.defaults.async||i.async||!1,r.extensions&&(r.extensions.forEach(s=>{if(!s.name)throw new Error("extension name required");if("renderer"in s){const o=n.renderers[s.name];o?n.renderers[s.name]=function(...a){let u=s.renderer.apply(this,a);return u===!1&&(u=o.apply(this,a)),u}:n.renderers[s.name]=s.renderer}if("tokenizer"in s){if(!s.level||s.level!=="block"&&s.level!=="inline")throw new Error("extension level must be 'block' or 'inline'");const o=n[s.level];o?o.unshift(s.tokenizer):n[s.level]=[s.tokenizer],s.start&&(s.level==="block"?n.startBlock?n.startBlock.push(s.start):n.startBlock=[s.start]:s.level==="inline"&&(n.startInline?n.startInline.push(s.start):n.startInline=[s.start]))}"childTokens"in s&&s.childTokens&&(n.childTokens[s.name]=s.childTokens)}),i.extensions=n),r.renderer){const s=this.defaults.renderer||new Wc(this.defaults);for(const o in r.renderer){if(!(o in s))throw new Error(`renderer '${o}' does not exist`);if(["options","parser"].includes(o))continue;const a=o,u=r.renderer[a],c=s[a];s[a]=(...d)=>{let f=u.apply(s,d);return f===!1&&(f=c.apply(s,d)),f||""}}i.renderer=s}if(r.tokenizer){const s=this.defaults.tokenizer||new Bc(this.defaults);for(const o in r.tokenizer){if(!(o in s))throw new Error(`tokenizer '${o}' does not exist`);if(["options","rules","lexer"].includes(o))continue;const a=o,u=r.tokenizer[a],c=s[a];s[a]=(...d)=>{let f=u.apply(s,d);return f===!1&&(f=c.apply(s,d)),f}}i.tokenizer=s}if(r.hooks){const s=this.defaults.hooks||new ba;for(const o in r.hooks){if(!(o in s))throw new Error(`hook '${o}' does not exist`);if(["options","block"].includes(o))continue;const a=o,u=r.hooks[a],c=s[a];ba.passThroughHooks.has(o)?s[a]=d=>{if(this.defaults.async)return Promise.resolve(u.call(s,d)).then(m=>c.call(s,m));const f=u.call(s,d);return c.call(s,f)}:s[a]=(...d)=>{let f=u.apply(s,d);return f===!1&&(f=c.apply(s,d)),f}}i.hooks=s}if(r.walkTokens){const s=this.defaults.walkTokens,o=r.walkTokens;i.walkTokens=function(a){let u=[];return u.push(o.call(this,a)),s&&(u=u.concat(s.call(this,a))),u}}this.defaults={...this.defaults,...i}}),this}setOptions(e){return this.defaults={...this.defaults,...e},this}lexer(e,n){return _n.lex(e,n??this.defaults)}parser(e,n){return yn.parse(e,n??this.defaults)}parseMarkdown(e){return(r,i)=>{const s={...i},o={...this.defaults,...s},a=this.onError(!!o.silent,!!o.async);if(this.defaults.async===!0&&s.async===!1)return a(new Error("marked(): The async option was set to true by an extension. Remove async: false from the parse options object to return a Promise."));if(typeof r>"u"||r===null)return a(new Error("marked(): input parameter is undefined or null"));if(typeof r!="string")return a(new Error("marked(): input parameter is of type "+Object.prototype.toString.call(r)+", string expected"));o.hooks&&(o.hooks.options=o,o.hooks.block=e);const u=o.hooks?o.hooks.provideLexer():e?_n.lex:_n.lexInline,c=o.hooks?o.hooks.provideParser():e?yn.parse:yn.parseInline;if(o.async)return Promise.resolve(o.hooks?o.hooks.preprocess(r):r).then(d=>u(d,o)).then(d=>o.hooks?o.hooks.processAllTokens(d):d).then(d=>o.walkTokens?Promise.all(this.walkTokens(d,o.walkTokens)).then(()=>d):d).then(d=>c(d,o)).then(d=>o.hooks?o.hooks.postprocess(d):d).catch(a);try{o.hooks&&(r=o.hooks.preprocess(r));let d=u(r,o);o.hooks&&(d=o.hooks.processAllTokens(d)),o.walkTokens&&this.walkTokens(d,o.walkTokens);let f=c(d,o);return o.hooks&&(f=o.hooks.postprocess(f)),f}catch(d){return a(d)}}}onError(e,n){return r=>{if(r.message+=`
Please report this to https://github.com/markedjs/marked.`,e){const i="<p>An error occurred:</p><pre>"+sn(r.message+"",!0)+"</pre>";return n?Promise.resolve(i):i}if(n)return Promise.reject(r);throw r}}}const Ji=new B4;function we(t,e){return Ji.parse(t,e)}we.options=we.setOptions=function(t){return Ji.setOptions(t),we.defaults=Ji.defaults,b1(we.defaults),we};we.getDefaults=t_;we.defaults=as;we.use=function(...t){return Ji.use(...t),we.defaults=Ji.defaults,b1(we.defaults),we};we.walkTokens=function(t,e){return Ji.walkTokens(t,e)};we.parseInline=Ji.parseInline;we.Parser=yn;we.parser=yn.parse;we.Renderer=Wc;we.TextRenderer=a_;we.Lexer=_n;we.lexer=_n.lex;we.Tokenizer=Bc;we.Hooks=ba;we.parse=we;we.options;we.setOptions;we.use;we.walkTokens;we.parseInline;yn.parse;_n.lex;we.setOptions({gfm:!0,breaks:!0});function $4({bookData:t,onCancel:e,onUpload:n,isUploading:r,uploadProgress:i,uploadStage:s}){var x,N,R,Ye,ct;const[o,a]=oe.useState("chapters"),[u,c]=oe.useState(0),[d,f]=oe.useState(t.title||""),[m,w]=oe.useState(t.subtitle||""),[I,P]=oe.useState(t.author||""),[O,C]=oe.useState(t.translator||""),[T,S]=oe.useState(t.tagline||""),[M,V]=oe.useState(t.category||"Personal Finance & Business"),[F,y]=oe.useState(t.language||"Bangla"),[g,E]=oe.useState(t.audioUrl||""),k=()=>{n({...t,title:d,subtitle:m,author:I,translator:O,tagline:T,category:M,language:F,audioUrl:g})};return v.jsxs("div",{style:{maxWidth:1100,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[v.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"1rem"},children:[v.jsxs("button",{onClick:e,disabled:r,className:"btn-secondary",style:{padding:"0.5rem 0.85rem"},children:[v.jsx(qA,{size:16})," Back"]}),v.jsxs("div",{children:[v.jsxs("div",{style:{fontSize:"0.8rem",color:"var(--text-muted)"},children:["Source File: ",v.jsx("strong",{style:{color:"#c7d2fe"},children:t.filename||"book.md"})]}),v.jsx("h2",{style:{fontSize:"1.4rem"},children:"Review & Publish to Firebase"})]})]}),v.jsx("div",{style:{display:"flex",alignItems:"center",gap:"1rem"},children:v.jsx("button",{onClick:k,disabled:r,className:"btn-primary",style:{minWidth:200,justifyContent:"center"},children:r?v.jsxs(v.Fragment,{children:[v.jsx(sx,{size:18,className:"animate-spin",style:{animation:"spin 1s linear infinite"}}),v.jsxs("span",{children:[i,"% Uploading..."]})]}):v.jsxs(v.Fragment,{children:[v.jsx(xm,{size:18}),v.jsx("span",{children:"Publish to Firebase"})]})})})]}),r&&v.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",border:"1px solid var(--accent-primary)"},children:[v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",marginBottom:"0.5rem",fontSize:"0.85rem"},children:[v.jsx("span",{style:{color:"#a5b4fc",fontWeight:600},children:s||"Uploading..."}),v.jsxs("span",{style:{color:"#f8fafc",fontWeight:700},children:[i,"%"]})]}),v.jsx("div",{style:{width:"100%",height:8,background:"rgba(255,255,255,0.1)",borderRadius:9999,overflow:"hidden"},children:v.jsx("div",{style:{width:`${i}%`,height:"100%",background:"var(--accent-gradient)",transition:"width 0.3s ease"}})})]}),v.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(320px, 1fr))",gap:"1.5rem",alignItems:"start"},children:[v.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem",display:"flex",flexDirection:"column",gap:"1.1rem"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",borderBottom:"1px solid var(--border-subtle)",paddingBottom:"0.75rem"},children:[v.jsx(ox,{size:18,color:"#818cf8"}),v.jsx("h3",{style:{fontSize:"1.1rem"},children:"Extracted Metadata"})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Book Title"}),v.jsx("input",{type:"text",className:"input-field",value:d,onChange:ve=>f(ve.target.value),placeholder:"e.g. ধনী বাবা গরীব বাবা"})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Subtitle / Description"}),v.jsx("input",{type:"text",className:"input-field",value:m,onChange:ve=>w(ve.target.value),placeholder:"e.g. বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ"})]}),v.jsxs("div",{style:{display:"grid",gridTemplateColumns:"1fr 1fr",gap:"0.75rem"},children:[v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Original Author"}),v.jsx("input",{type:"text",className:"input-field",value:I,onChange:ve=>P(ve.target.value),placeholder:"e.g. রবার্ট টি. কিওসাকি"})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Translator / Compiler"}),v.jsx("input",{type:"text",className:"input-field",value:O,onChange:ve=>C(ve.target.value),placeholder:"e.g. মোঃ আবির আহমেদ"})]})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Tagline / Key Takeaway"}),v.jsx("input",{type:"text",className:"input-field",value:T,onChange:ve=>S(ve.target.value),placeholder:"e.g. আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা"})]}),v.jsxs("div",{style:{display:"grid",gridTemplateColumns:"1fr 1fr",gap:"0.75rem"},children:[v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Category"}),v.jsx("input",{type:"text",className:"input-field",value:M,onChange:ve=>V(ve.target.value)})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Language"}),v.jsx("input",{type:"text",className:"input-field",value:F,onChange:ve=>y(ve.target.value)})]})]}),v.jsxs("div",{children:[v.jsx("label",{className:"input-label",children:"Audio Stream Link (MP3)"}),v.jsx("input",{type:"url",className:"input-field",value:g,onChange:ve=>E(ve.target.value),placeholder:"https://..."})]}),v.jsxs("div",{style:{marginTop:"0.5rem",background:"rgba(255, 255, 255, 0.03)",borderRadius:"12px",padding:"1rem",display:"grid",gridTemplateColumns:"1fr 1fr 1fr",gap:"0.5rem",textAlign:"center",border:"1px solid var(--border-subtle)"},children:[v.jsxs("div",{children:[v.jsx("div",{style:{fontSize:"1.25rem",fontWeight:800,color:"#a5b4fc"},children:((x=t.chapters)==null?void 0:x.length)||0}),v.jsx("div",{style:{fontSize:"0.75rem",color:"var(--text-muted)"},children:"Chapters"})]}),v.jsxs("div",{children:[v.jsx("div",{style:{fontSize:"1.25rem",fontWeight:800,color:"#6ee7b7"},children:((N=t.totalWords)==null?void 0:N.toLocaleString())||0}),v.jsx("div",{style:{fontSize:"0.75rem",color:"var(--text-muted)"},children:"Words"})]}),v.jsxs("div",{children:[v.jsxs("div",{style:{fontSize:"1.25rem",fontWeight:800,color:"#f472b6"},children:["~",t.estimatedMinutes||1," min"]}),v.jsx("div",{style:{fontSize:"0.75rem",color:"var(--text-muted)"},children:"Read Time"})]})]})]}),v.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem",display:"flex",flexDirection:"column",gap:"1rem"},children:[v.jsx("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"0.5rem",borderBottom:"1px solid var(--border-subtle)",paddingBottom:"0.75rem"},children:v.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[v.jsxs("button",{onClick:()=>a("chapters"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="chapters"?"var(--accent-primary)":"transparent",color:o==="chapters"?"#fff":"var(--text-muted)",borderColor:o==="chapters"?"var(--accent-primary)":"var(--border-subtle)"},children:[v.jsx(Am,{size:14})," Chapters (",((R=t.chapters)==null?void 0:R.length)||0,")"]}),v.jsxs("button",{onClick:()=>a("full"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="full"?"var(--accent-primary)":"transparent",color:o==="full"?"#fff":"var(--text-muted)",borderColor:o==="full"?"var(--accent-primary)":"var(--border-subtle)"},children:[v.jsx(XA,{size:14})," Rendered View"]}),v.jsxs("button",{onClick:()=>a("raw"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="raw"?"var(--accent-primary)":"transparent",color:o==="raw"?"#fff":"var(--text-muted)",borderColor:o==="raw"?"var(--accent-primary)":"var(--border-subtle)"},children:[v.jsx(QA,{size:14})," Raw Markdown"]})]})}),o==="chapters"&&v.jsxs("div",{style:{display:"flex",flexDirection:"column",gap:"1rem"},children:[v.jsx("div",{style:{display:"flex",gap:"0.5rem",overflowX:"auto",paddingBottom:"0.5rem"},children:(Ye=t.chapters)==null?void 0:Ye.map((ve,et)=>v.jsxs("button",{onClick:()=>c(et),style:{padding:"0.4rem 0.75rem",borderRadius:"8px",border:"1px solid",borderColor:u===et?"var(--accent-primary)":"rgba(255,255,255,0.08)",background:u===et?"rgba(99, 102, 241, 0.2)":"rgba(255,255,255,0.03)",color:u===et?"#a5b4fc":"var(--text-muted)",fontSize:"0.78rem",fontWeight:600,whiteSpace:"nowrap",cursor:"pointer"},children:["#",et+1," ",ve.title.slice(0,24),ve.title.length>24?"...":""]},ve.id))}),((ct=t.chapters)==null?void 0:ct[u])&&v.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.6)",borderRadius:"12px",padding:"1.5rem",border:"1px solid var(--border-subtle)",maxHeight:500,overflowY:"auto"},children:[v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"1rem"},children:[v.jsx("h4",{style:{color:"#a5b4fc",fontSize:"1.15rem"},children:t.chapters[u].title}),v.jsxs("span",{className:"badge badge-emerald",children:[t.chapters[u].wordCount," words (~",t.chapters[u].estimatedMinutes," min)"]})]}),v.jsx("div",{className:"markdown-preview",dangerouslySetInnerHTML:{__html:we.parse(t.chapters[u].content||"")}})]})]}),o==="full"&&v.jsx("div",{className:"markdown-preview",style:{background:"rgba(15, 23, 42, 0.6)",borderRadius:"12px",padding:"1.5rem",border:"1px solid var(--border-subtle)",maxHeight:560,overflowY:"auto"},dangerouslySetInnerHTML:{__html:we.parse(t.rawText||"")}}),o==="raw"&&v.jsx("pre",{style:{background:"rgba(10, 14, 26, 0.95)",borderRadius:"12px",padding:"1.25rem",color:"#94a3b8",fontSize:"0.85rem",lineHeight:1.6,overflowX:"auto",maxHeight:560,fontFamily:"Consolas, Monaco, monospace",border:"1px solid var(--border-subtle)"},children:v.jsx("code",{children:t.rawText})})]})]})]})}function W4({books:t,loading:e,onRefresh:n,onDeleteBook:r,onSelectBook:i}){const[s,o]=oe.useState(""),[a,u]=oe.useState("All"),c=t.filter(f=>{const m=(f.title||"").toLowerCase().includes(s.toLowerCase())||(f.author||"").toLowerCase().includes(s.toLowerCase())||(f.translator||"").toLowerCase().includes(s.toLowerCase()),w=a==="All"||f.category===a;return m&&w}),d=["All",...new Set(t.map(f=>f.category).filter(Boolean))];return v.jsxs("div",{style:{maxWidth:1100,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[v.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem"},children:[v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",flexWrap:"wrap",gap:"1rem",marginBottom:"1.25rem"},children:[v.jsxs("div",{children:[v.jsx("h2",{style:{fontSize:"1.5rem",marginBottom:"0.25rem"},children:"Firebase Book Repository"}),v.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem"},children:"Manage markdown audio books stored in Firestore and Firebase Storage"})]}),v.jsxs("button",{onClick:n,disabled:e,className:"btn-secondary",style:{fontSize:"0.85rem"},children:[v.jsx(dv,{size:15,className:e?"animate-spin":"",style:{animation:e?"spin 1s linear infinite":"none"}}),"Refresh"]})]}),v.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(220px, 1fr))",gap:"1rem"},children:[v.jsxs("div",{style:{position:"relative"},children:[v.jsx(ax,{size:16,color:"#94a3b8",style:{position:"absolute",left:14,top:"50%",transform:"translateY(-50%)"}}),v.jsx("input",{type:"text",className:"input-field",placeholder:"Search by title, author, translator...",value:s,onChange:f=>o(f.target.value),style:{paddingLeft:"2.5rem"}})]}),v.jsx("select",{className:"input-field",value:a,onChange:f=>u(f.target.value),children:d.map(f=>v.jsxs("option",{value:f,children:[f," (",f==="All"?t.length:t.filter(m=>m.category===f).length,")"]},f))})]})]}),e?v.jsxs("div",{className:"glass-panel",style:{padding:"3rem",textAlign:"center",color:"var(--text-muted)"},children:[v.jsx(dv,{size:32,className:"animate-spin",style:{animation:"spin 1s linear infinite",margin:"0 auto 1rem",color:"var(--accent-primary)"}}),v.jsx("div",{children:"Connecting to Firebase & retrieving books..."})]}):c.length===0?v.jsxs("div",{className:"glass-panel",style:{padding:"3.5rem 2rem",textAlign:"center"},children:[v.jsx(Am,{size:48,color:"#6366f1",style:{opacity:.5,margin:"0 auto 1rem"}}),v.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.5rem"},children:"No Books Found"}),v.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.9rem",maxWidth:460,margin:"0 auto 1.5rem"},children:s||a!=="All"?"No books matched your query. Try clearing filters.":"Your Firebase collection is currently empty. Upload your first book.md file using the Upload & Parse tab!"})]}):v.jsx("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fill, minmax(330px, 1fr))",gap:"1.25rem"},children:c.map(f=>{var m;return v.jsxs("div",{className:"glass-panel glass-panel-hover",style:{padding:"1.5rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem"},children:[v.jsxs("div",{children:[v.jsxs("div",{style:{display:"flex",gap:"0.5rem",flexWrap:"wrap",marginBottom:"0.75rem"},children:[v.jsx("span",{className:"badge badge-indigo",children:f.category||"General"}),f.language&&v.jsx("span",{className:"badge badge-emerald",children:f.language})]}),v.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.35rem",color:"#f8fafc",lineHeight:1.3},children:f.title}),f.subtitle&&v.jsx("p",{style:{fontSize:"0.85rem",color:"#a5b4fc",marginBottom:"0.5rem",fontStyle:"italic"},children:f.subtitle}),v.jsxs("div",{style:{fontSize:"0.82rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:[f.author&&v.jsxs("div",{children:[v.jsx("strong",{children:"Author:"})," ",f.author]}),f.translator&&v.jsxs("div",{children:[v.jsx("strong",{children:"Translator:"})," ",f.translator]})]}),v.jsxs("div",{style:{display:"flex",gap:"1rem",padding:"0.75rem 0",borderTop:"1px solid var(--border-subtle)",borderBottom:"1px solid var(--border-subtle)",fontSize:"0.8rem",color:"var(--text-muted)"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.35rem"},children:[v.jsx(rx,{size:14,color:"#818cf8"}),v.jsxs("span",{children:[((m=f.chapters)==null?void 0:m.length)||f.totalChapters||0," Chapters"]})]}),v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.35rem"},children:[v.jsx(KA,{size:14,color:"#6ee7b7"}),v.jsxs("span",{children:["~",f.estimatedMinutes||1," min read"]})]})]})]}),v.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",gap:"0.5rem",marginTop:"0.5rem"},children:[v.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[(f.storageUrl||f.rawMarkdown)&&v.jsxs("button",{onClick:()=>{if(f.storageUrl)window.open(f.storageUrl,"_blank");else if(f.rawMarkdown){const w=new Blob([f.rawMarkdown],{type:"text/markdown"}),I=URL.createObjectURL(w),P=document.createElement("a");P.href=I,P.download=`${f.slug||"book"}.md`,P.click(),URL.revokeObjectURL(I)}},className:"btn-secondary",title:"Download Markdown",style:{padding:"0.45rem 0.75rem",fontSize:"0.8rem"},children:[v.jsx(JA,{size:14})," Raw .md"]}),f.audioUrl&&v.jsxs("a",{href:f.audioUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Open Audio Stream",style:{padding:"0.45rem 0.75rem",fontSize:"0.8rem",color:"#6ee7b7"},children:[v.jsx(tx,{size:14})," Audio"]})]}),v.jsx("button",{onClick:()=>r(f.id,f.storagePath),className:"btn-secondary",title:"Delete Book from Firebase",style:{padding:"0.45rem 0.65rem",color:"#ef4444",borderColor:"rgba(239, 68, 68, 0.2)"},children:v.jsx(ux,{size:15})})]})]},f.id)})})]})}function q4({isOpen:t,onClose:e}){const[n,r]=oe.useState(!1),[i,s]=oe.useState(!1);if(!t)return null;const o=`rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}`,a=`rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if true;
    }
  }
}`,u=(f,m)=>{navigator.clipboard.writeText(f),m==="storage"?(r(!0),setTimeout(()=>r(!1),2e3)):(s(!0),setTimeout(()=>s(!1),2e3))},c=`https://console.firebase.google.com/project/${xa.projectId}/firestore/rules`,d=`https://console.firebase.google.com/project/${xa.projectId}/storage/rules`;return v.jsx("div",{style:{position:"fixed",top:0,left:0,right:0,bottom:0,background:"rgba(0, 0, 0, 0.75)",backdropFilter:"blur(8px)",display:"flex",alignItems:"center",justifyContent:"center",zIndex:9999,padding:"1.5rem"},children:v.jsxs("div",{className:"glass-panel",style:{maxWidth:720,width:"100%",maxHeight:"90vh",overflowY:"auto",padding:"2rem",border:"1px solid rgba(239, 68, 68, 0.4)",boxShadow:"0 20px 50px rgba(0, 0, 0, 0.8)"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"1.25rem"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[v.jsx("div",{style:{width:42,height:42,borderRadius:10,background:"rgba(239, 68, 68, 0.2)",display:"flex",alignItems:"center",justifyContent:"center"},children:v.jsx(lx,{size:24,color:"#ef4444"})}),v.jsxs("div",{children:[v.jsx("h3",{style:{fontSize:"1.3rem",color:"#f8fafc"},children:"Fix Firebase Permissions"}),v.jsxs("p",{style:{fontSize:"0.82rem",color:"var(--text-muted)"},children:["Resolve ",v.jsx("strong",{children:'"Missing or insufficient permissions"'})," in project ",v.jsx("strong",{children:xa.projectId})]})]})]}),v.jsx("button",{onClick:e,style:{background:"transparent",border:"none",color:"#94a3b8",cursor:"pointer",padding:4},children:v.jsx(LT,{size:20})})]}),v.jsxs("div",{style:{background:"rgba(239, 68, 68, 0.12)",border:"1px solid rgba(239, 68, 68, 0.3)",borderRadius:10,padding:"0.85rem 1rem",fontSize:"0.85rem",color:"#fca5a5",marginBottom:"1.25rem",display:"flex",gap:"0.6rem"},children:[v.jsx(cx,{size:18,style:{flexShrink:0,marginTop:2}}),v.jsxs("div",{children:[v.jsx("strong",{children:"Why this happens:"}),' Newly initialized Cloud Firestore and Storage buckets start in "Production/Locked mode" (',v.jsx("code",{children:"allow read, write: if false;"}),"). You need to publish the rules below to allow uploads."]})]}),v.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.8)",padding:"1.25rem",borderRadius:12,border:"1px solid rgba(16, 185, 129, 0.3)",marginBottom:"1.25rem"},children:[v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.75rem",flexWrap:"wrap",gap:"0.5rem"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#6ee7b7"},children:[v.jsx(YA,{size:17}),' 1. Cloud Firestore Rules (Fixes "Missing or insufficient permissions")']}),v.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[v.jsxs("button",{onClick:()=>u(o,"firestore"),className:"btn-secondary",style:{padding:"0.35rem 0.65rem",fontSize:"0.78rem"},children:[i?v.jsx(Gf,{size:14,color:"#10b981"}):v.jsx(cv,{size:14}),i?"Copied":"Copy Firestore Rule"]}),v.jsxs("a",{href:c,target:"_blank",rel:"noopener noreferrer",className:"btn-primary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",textDecoration:"none"},children:["Open Firestore Rules ",v.jsx(hv,{size:13})]})]})]}),v.jsx("pre",{style:{background:"rgba(9, 13, 22, 0.95)",padding:"0.75rem 1rem",borderRadius:8,fontSize:"0.82rem",color:"#cbd5e1",overflowX:"auto",fontFamily:"Consolas, monospace",border:"1px solid rgba(255,255,255,0.06)"},children:v.jsx("code",{children:o})}),v.jsxs("div",{style:{fontSize:"0.78rem",color:"#94a3b8",marginTop:"0.5rem"},children:["Click ",v.jsx("strong",{children:"Open Firestore Rules"})," > Paste above > Click ",v.jsx("strong",{children:"Publish"}),"."]})]}),v.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.8)",padding:"1.25rem",borderRadius:12,border:"1px solid rgba(99, 102, 241, 0.3)",marginBottom:"1.5rem"},children:[v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.75rem",flexWrap:"wrap",gap:"0.5rem"},children:[v.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#a5b4fc"},children:[v.jsx(ex,{size:17})," 2. Firebase Storage Rules (Fixes storage/unauthorized)"]}),v.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[v.jsxs("button",{onClick:()=>u(a,"storage"),className:"btn-secondary",style:{padding:"0.35rem 0.65rem",fontSize:"0.78rem"},children:[n?v.jsx(Gf,{size:14,color:"#10b981"}):v.jsx(cv,{size:14}),n?"Copied":"Copy Storage Rule"]}),v.jsxs("a",{href:d,target:"_blank",rel:"noopener noreferrer",className:"btn-primary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",textDecoration:"none"},children:["Open Storage Rules ",v.jsx(hv,{size:13})]})]})]}),v.jsx("pre",{style:{background:"rgba(9, 13, 22, 0.95)",padding:"0.75rem 1rem",borderRadius:8,fontSize:"0.82rem",color:"#cbd5e1",overflowX:"auto",fontFamily:"Consolas, monospace",border:"1px solid rgba(255,255,255,0.06)"},children:v.jsx("code",{children:a})})]}),v.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",flexWrap:"wrap",gap:"1rem"},children:[v.jsx("div",{style:{fontSize:"0.8rem",color:"#94a3b8"},children:"Once published in Firebase Console, uploads will succeed immediately."}),v.jsx("button",{onClick:e,className:"btn-primary",style:{padding:"0.65rem 1.25rem"},children:"I've Published Rules / Done"})]})]})})}function H4({toasts:t,onDismiss:e}){return!t||t.length===0?null:v.jsx("div",{className:"toast-container",children:t.map(n=>{let r=GA,i="rgba(16, 185, 129, 0.4)",s="#10b981";return n.type==="error"?(r=HA,i="rgba(239, 68, 68, 0.4)",s="#ef4444"):n.type==="info"&&(r=MT,i="rgba(99, 102, 241, 0.4)",s="#6366f1"),v.jsxs("div",{className:"toast",style:{borderColor:i},children:[v.jsx(r,{size:20,color:s,style:{flexShrink:0}}),v.jsxs("div",{style:{flex:1,fontSize:"0.9rem"},children:[n.title&&v.jsx("div",{style:{fontWeight:600,marginBottom:2},children:n.title}),v.jsx("div",{style:{color:"#cbd5e1"},children:n.message})]}),v.jsx("button",{onClick:()=>e(n.id),style:{background:"transparent",border:"none",color:"#64748b",cursor:"pointer",display:"flex",alignItems:"center",padding:4},children:v.jsx(LT,{size:16})})]},n.id)})})}var l_={};(function t(e,n,r,i){var s=!!(e.Worker&&e.Blob&&e.Promise&&e.OffscreenCanvas&&e.OffscreenCanvasRenderingContext2D&&e.HTMLCanvasElement&&e.HTMLCanvasElement.prototype.transferControlToOffscreen&&e.URL&&e.URL.createObjectURL),o=typeof Path2D=="function"&&typeof DOMMatrix=="function",a=function(){if(!e.OffscreenCanvas)return!1;try{var b=new OffscreenCanvas(1,1),A=b.getContext("2d");A.fillRect(0,0,1,1);var B=b.transferToImageBitmap();A.createPattern(B,"no-repeat")}catch{return!1}return!0}();function u(){}function c(b){var A=n.exports.Promise,B=A!==void 0?A:e.Promise;return typeof B=="function"?new B(b):(b(u,u),null)}var d=function(b,A){return{transform:function(B){if(b)return B;if(A.has(B))return A.get(B);var q=new OffscreenCanvas(B.width,B.height),J=q.getContext("2d");return J.drawImage(B,0,0),A.set(B,q),q},clear:function(){A.clear()}}}(a,new Map),f=function(){var b=Math.floor(16.666666666666668),A,B,q={},J=0;return typeof requestAnimationFrame=="function"&&typeof cancelAnimationFrame=="function"?(A=function(ee){var te=Math.random();return q[te]=requestAnimationFrame(function Q(ae){J===ae||J+b-1<ae?(J=ae,delete q[te],ee()):q[te]=requestAnimationFrame(Q)}),te},B=function(ee){q[ee]&&cancelAnimationFrame(q[ee])}):(A=function(ee){return setTimeout(ee,b)},B=function(ee){return clearTimeout(ee)}),{frame:A,cancel:B}}(),m=function(){var b,A,B={};function q(J){function ee(te,Q){J.postMessage({options:te||{},callback:Q})}J.init=function(Q){var ae=Q.transferControlToOffscreen();J.postMessage({canvas:ae},[ae])},J.fire=function(Q,ae,Ce){if(A)return ee(Q,null),A;var xe=Math.random().toString(36).slice(2);return A=c(function(Ee){function Ne(Xe){Xe.data.callback===xe&&(delete B[xe],J.removeEventListener("message",Ne),A=null,d.clear(),Ce(),Ee())}J.addEventListener("message",Ne),ee(Q,xe),B[xe]=Ne.bind(null,{data:{callback:xe}})}),A},J.reset=function(){J.postMessage({reset:!0});for(var Q in B)B[Q](),delete B[Q]}}return function(){if(b)return b;if(!r&&s){var J=["var CONFETTI, SIZE = {}, module = {};","("+t.toString()+")(this, module, true, SIZE);","onmessage = function(msg) {","  if (msg.data.options) {","    CONFETTI(msg.data.options).then(function () {","      if (msg.data.callback) {","        postMessage({ callback: msg.data.callback });","      }","    });","  } else if (msg.data.reset) {","    CONFETTI && CONFETTI.reset();","  } else if (msg.data.resize) {","    SIZE.width = msg.data.resize.width;","    SIZE.height = msg.data.resize.height;","  } else if (msg.data.canvas) {","    SIZE.width = msg.data.canvas.width;","    SIZE.height = msg.data.canvas.height;","    CONFETTI = module.exports.create(msg.data.canvas);","  }","}"].join(`
`);try{b=new Worker(URL.createObjectURL(new Blob([J])))}catch(ee){return typeof console<"u"&&typeof console.warn=="function"&&console.warn("🎊 Could not load worker",ee),null}q(b)}return b}}(),w={particleCount:50,angle:90,spread:45,startVelocity:45,decay:.9,gravity:1,drift:0,ticks:200,x:.5,y:.5,shapes:["square","circle"],zIndex:100,colors:["#26ccff","#a25afd","#ff5e7e","#88ff5a","#fcff42","#ffa62d","#ff36ff"],disableForReducedMotion:!1,scalar:1};function I(b,A){return A?A(b):b}function P(b){return b!=null}function O(b,A,B){return I(b&&P(b[A])?b[A]:w[A],B)}function C(b){return b<0?0:Math.floor(b)}function T(b,A){return Math.floor(Math.random()*(A-b))+b}function S(b){return parseInt(b,16)}function M(b){return b.map(V)}function V(b){var A=String(b).replace(/[^0-9a-f]/gi,"");return A.length<6&&(A=A[0]+A[0]+A[1]+A[1]+A[2]+A[2]),{r:S(A.substring(0,2)),g:S(A.substring(2,4)),b:S(A.substring(4,6))}}function F(b){var A=O(b,"origin",Object);return A.x=O(A,"x",Number),A.y=O(A,"y",Number),A}function y(b){b.width=document.documentElement.clientWidth,b.height=document.documentElement.clientHeight}function g(b){var A=b.getBoundingClientRect();b.width=A.width,b.height=A.height}function E(b){var A=document.createElement("canvas");return A.style.position="fixed",A.style.top="0px",A.style.left="0px",A.style.pointerEvents="none",A.style.zIndex=b,A}function k(b,A,B,q,J,ee,te,Q,ae){b.save(),b.translate(A,B),b.rotate(ee),b.scale(q,J),b.arc(0,0,1,te,Q,ae),b.restore()}function x(b){var A=b.angle*(Math.PI/180),B=b.spread*(Math.PI/180);return{x:b.x,y:b.y,wobble:Math.random()*10,wobbleSpeed:Math.min(.11,Math.random()*.1+.05),velocity:b.startVelocity*.5+Math.random()*b.startVelocity,angle2D:-A+(.5*B-Math.random()*B),tiltAngle:(Math.random()*(.75-.25)+.25)*Math.PI,color:b.color,shape:b.shape,tick:0,totalTicks:b.ticks,decay:b.decay,drift:b.drift,random:Math.random()+2,tiltSin:0,tiltCos:0,wobbleX:0,wobbleY:0,gravity:b.gravity*3,ovalScalar:.6,scalar:b.scalar,flat:b.flat}}function N(b,A){A.x+=Math.cos(A.angle2D)*A.velocity+A.drift,A.y+=Math.sin(A.angle2D)*A.velocity+A.gravity,A.velocity*=A.decay,A.flat?(A.wobble=0,A.wobbleX=A.x+10*A.scalar,A.wobbleY=A.y+10*A.scalar,A.tiltSin=0,A.tiltCos=0,A.random=1):(A.wobble+=A.wobbleSpeed,A.wobbleX=A.x+10*A.scalar*Math.cos(A.wobble),A.wobbleY=A.y+10*A.scalar*Math.sin(A.wobble),A.tiltAngle+=.1,A.tiltSin=Math.sin(A.tiltAngle),A.tiltCos=Math.cos(A.tiltAngle),A.random=Math.random()+2);var B=A.tick++/A.totalTicks,q=A.x+A.random*A.tiltCos,J=A.y+A.random*A.tiltSin,ee=A.wobbleX+A.random*A.tiltCos,te=A.wobbleY+A.random*A.tiltSin;if(b.fillStyle="rgba("+A.color.r+", "+A.color.g+", "+A.color.b+", "+(1-B)+")",b.beginPath(),o&&A.shape.type==="path"&&typeof A.shape.path=="string"&&Array.isArray(A.shape.matrix))b.fill(et(A.shape.path,A.shape.matrix,A.x,A.y,Math.abs(ee-q)*.1,Math.abs(te-J)*.1,Math.PI/10*A.wobble));else if(A.shape.type==="bitmap"){var Q=Math.PI/10*A.wobble,ae=Math.abs(ee-q)*.1,Ce=Math.abs(te-J)*.1,xe=A.shape.bitmap.width*A.scalar,Ee=A.shape.bitmap.height*A.scalar,Ne=new DOMMatrix([Math.cos(Q)*ae,Math.sin(Q)*ae,-Math.sin(Q)*Ce,Math.cos(Q)*Ce,A.x,A.y]);Ne.multiplySelf(new DOMMatrix(A.shape.matrix));var Xe=b.createPattern(d.transform(A.shape.bitmap),"no-repeat");Xe.setTransform(Ne),b.globalAlpha=1-B,b.fillStyle=Xe,b.fillRect(A.x-xe/2,A.y-Ee/2,xe,Ee),b.globalAlpha=1}else if(A.shape==="circle")b.ellipse?b.ellipse(A.x,A.y,Math.abs(ee-q)*A.ovalScalar,Math.abs(te-J)*A.ovalScalar,Math.PI/10*A.wobble,0,2*Math.PI):k(b,A.x,A.y,Math.abs(ee-q)*A.ovalScalar,Math.abs(te-J)*A.ovalScalar,Math.PI/10*A.wobble,0,2*Math.PI);else if(A.shape==="star")for(var le=Math.PI/2*3,ht=4*A.scalar,qt=8*A.scalar,tn=A.x,kn=A.y,Un=5,Ht=Math.PI/Un;Un--;)tn=A.x+Math.cos(le)*qt,kn=A.y+Math.sin(le)*qt,b.lineTo(tn,kn),le+=Ht,tn=A.x+Math.cos(le)*ht,kn=A.y+Math.sin(le)*ht,b.lineTo(tn,kn),le+=Ht;else b.moveTo(Math.floor(A.x),Math.floor(A.y)),b.lineTo(Math.floor(A.wobbleX),Math.floor(J)),b.lineTo(Math.floor(ee),Math.floor(te)),b.lineTo(Math.floor(q),Math.floor(A.wobbleY));return b.closePath(),b.fill(),A.tick<A.totalTicks}function R(b,A,B,q,J){var ee=A.slice(),te=b.getContext("2d"),Q,ae,Ce=c(function(xe){function Ee(){Q=ae=null,te.clearRect(0,0,q.width,q.height),d.clear(),J(),xe()}function Ne(){r&&!(q.width===i.width&&q.height===i.height)&&(q.width=b.width=i.width,q.height=b.height=i.height),!q.width&&!q.height&&(B(b),q.width=b.width,q.height=b.height),te.clearRect(0,0,q.width,q.height),ee=ee.filter(function(Xe){return N(te,Xe)}),ee.length?Q=f.frame(Ne):Ee()}Q=f.frame(Ne),ae=Ee});return{addFettis:function(xe){return ee=ee.concat(xe),Ce},canvas:b,promise:Ce,reset:function(){Q&&f.cancel(Q),ae&&ae()}}}function Ye(b,A){var B=!b,q=!!O(A||{},"resize"),J=!1,ee=O(A,"disableForReducedMotion",Boolean),te=s&&!!O(A||{},"useWorker"),Q=te?m():null,ae=B?y:g,Ce=b&&Q?!!b.__confetti_initialized:!1,xe=typeof matchMedia=="function"&&matchMedia("(prefers-reduced-motion)").matches,Ee;function Ne(le,ht,qt){for(var tn=O(le,"particleCount",C),kn=O(le,"angle",Number),Un=O(le,"spread",Number),Ht=O(le,"startVelocity",Number),Nl=O(le,"decay",Number),Vh=O(le,"gravity",Number),ko=O(le,"drift",Number),ls=O(le,"colors",M),Ol=O(le,"ticks",Number),st=O(le,"shapes"),_t=O(le,"scalar"),us=!!O(le,"flat"),Co=F(le),Ro=tn,Ao=[],vi=b.width*Co.x,Dl=b.height*Co.y;Ro--;)Ao.push(x({x:vi,y:Dl,angle:kn,spread:Un,startVelocity:Ht,color:ls[Ro%ls.length],shape:st[T(0,st.length)],ticks:Ol,decay:Nl,gravity:Vh,drift:ko,scalar:_t,flat:us}));return Ee?Ee.addFettis(Ao):(Ee=R(b,Ao,ae,ht,qt),Ee.promise)}function Xe(le){var ht=ee||O(le,"disableForReducedMotion",Boolean),qt=O(le,"zIndex",Number);if(ht&&xe)return c(function(Ht){Ht()});B&&Ee?b=Ee.canvas:B&&!b&&(b=E(qt),document.body.appendChild(b)),q&&!Ce&&ae(b);var tn={width:b.width,height:b.height};Q&&!Ce&&Q.init(b),Ce=!0,Q&&(b.__confetti_initialized=!0);function kn(){if(Q){var Ht={getBoundingClientRect:function(){if(!B)return b.getBoundingClientRect()}};ae(Ht),Q.postMessage({resize:{width:Ht.width,height:Ht.height}});return}tn.width=tn.height=null}function Un(){Ee=null,q&&(J=!1,e.removeEventListener("resize",kn)),B&&b&&(document.body.contains(b)&&document.body.removeChild(b),b=null,Ce=!1)}return q&&!J&&(J=!0,e.addEventListener("resize",kn,!1)),Q?Q.fire(le,tn,Un):Ne(le,tn,Un)}return Xe.reset=function(){Q&&Q.reset(),Ee&&Ee.reset()},Xe}var ct;function ve(){return ct||(ct=Ye(null,{useWorker:!0,resize:!0})),ct}function et(b,A,B,q,J,ee,te){var Q=new Path2D(b),ae=new Path2D;ae.addPath(Q,new DOMMatrix(A));var Ce=new Path2D;return Ce.addPath(ae,new DOMMatrix([Math.cos(te)*J,Math.sin(te)*J,-Math.sin(te)*ee,Math.cos(te)*ee,B,q])),Ce}function W(b){if(!o)throw new Error("path confetti are not supported in this browser");var A,B;typeof b=="string"?A=b:(A=b.path,B=b.matrix);var q=new Path2D(A),J=document.createElement("canvas"),ee=J.getContext("2d");if(!B){for(var te=1e3,Q=te,ae=te,Ce=0,xe=0,Ee,Ne,Xe=0;Xe<te;Xe+=2)for(var le=0;le<te;le+=2)ee.isPointInPath(q,Xe,le,"nonzero")&&(Q=Math.min(Q,Xe),ae=Math.min(ae,le),Ce=Math.max(Ce,Xe),xe=Math.max(xe,le));Ee=Ce-Q,Ne=xe-ae;var ht=10,qt=Math.min(ht/Ee,ht/Ne);B=[qt,0,0,qt,-Math.round(Ee/2+Q)*qt,-Math.round(Ne/2+ae)*qt]}return{type:"path",path:A,matrix:B}}function X(b){var A,B=1,q="#000000",J='"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji", "EmojiOne Color", "Android Emoji", "Twemoji Mozilla", "system emoji", sans-serif';typeof b=="string"?A=b:(A=b.text,B="scalar"in b?b.scalar:B,J="fontFamily"in b?b.fontFamily:J,q="color"in b?b.color:q);var ee=10*B,te=""+ee+"px "+J,Q=new OffscreenCanvas(ee,ee),ae=Q.getContext("2d");ae.font=te;var Ce=ae.measureText(A),xe=Math.ceil(Ce.actualBoundingBoxRight+Ce.actualBoundingBoxLeft),Ee=Math.ceil(Ce.actualBoundingBoxAscent+Ce.actualBoundingBoxDescent),Ne=2,Xe=Ce.actualBoundingBoxLeft+Ne,le=Ce.actualBoundingBoxAscent+Ne;xe+=Ne+Ne,Ee+=Ne+Ne,Q=new OffscreenCanvas(xe,Ee),ae=Q.getContext("2d"),ae.font=te,ae.fillStyle=q,ae.fillText(A,Xe,le);var ht=1/B;return{type:"bitmap",bitmap:Q.transferToImageBitmap(),matrix:[ht,0,0,ht,-xe*ht/2,-Ee*ht/2]}}n.exports=function(){return ve().apply(this,arguments)},n.exports.reset=function(){ve().reset()},n.exports.create=Ye,n.exports.shapeFromPath=W,n.exports.shapeFromText=X})(function(){return typeof window<"u"?window:typeof self<"u"?self:this||{}}(),l_,!1);const G4=l_.exports;l_.exports.create;function K4(){const[t,e]=oe.useState("upload"),[n,r]=oe.useState(null),[i,s]=oe.useState([]),[o,a]=oe.useState(!1),[u,c]=oe.useState(!1),[d,f]=oe.useState(!1),[m,w]=oe.useState(0),[I,P]=oe.useState(""),[O,C]=oe.useState([]),T=({type:y="info",title:g="",message:E=""})=>{const k=Date.now().toString();C(x=>[...x,{id:k,type:y,title:g,message:E}]),setTimeout(()=>{S(k)},5e3)},S=y=>{C(g=>g.filter(E=>E.id!==y))},M=async()=>{a(!0);let y=[];try{const g=G2(aw(Qd,"books"),K2("createdAt","desc"));(await tO(g)).forEach(k=>{y.push({id:k.id,...k.data()})})}catch(g){console.warn("Firestore fetch error or restricted rules:",g)}try{const g=JSON.parse(localStorage.getItem("audio_books_cache")||"[]"),E=new Set(y.map(x=>x.id)),k=g.filter(x=>!E.has(x.id));y=[...y,...k]}catch{}s(y),a(!1)};oe.useEffect(()=>{zV(s4).catch(y=>{console.log("Anonymous sign-in note:",y.message)}),M()},[]);const V=async y=>{var g,E,k,x;f(!0),w(10),P("Initializing upload...");try{const N=l4(y.title),R=new Date().toISOString();let Ye="",ct="",ve="",et=!1;try{P("Uploading Markdown to Firebase Cloud Storage...");const A=y.originalFile||new Blob([y.rawText],{type:"text/markdown"}),B=y.filename||`${N}.md`;ct=`books/${N}/${B}`;const q=Fd(Yd,ct),J=_w(q,A,{contentType:"text/markdown"});await new Promise((ee,te)=>{J.on("state_changed",Q=>{const ae=Math.round(Q.bytesTransferred/Q.totalBytes*50);w(15+ae)},Q=>te(Q),async()=>{Ye=await yw(J.snapshot.ref),et=!0,ee()})})}catch(A){if(console.warn("Firebase Storage upload error:",A),A.code==="storage/unauthorized"||(g=A.message)!=null&&g.includes("unauthorized"))c(!0),T({type:"info",title:"Storage Rule Notice",message:"Firebase Storage access is currently restricted. Saving complete markdown and chapters directly into Firestore Database!"});else throw A}if(y.coverFile&&et)try{P("Uploading Book Cover Image...");const A=`covers/${N}/${y.coverFile.name}`,B=Fd(Yd,A),q=_w(B,y.coverFile);await new Promise((J,ee)=>{q.on("state_changed",null,te=>ee(te),async()=>{ve=await yw(q.snapshot.ref),J()})})}catch(A){console.warn("Cover upload skipped:",A)}w(85),P("Saving book document to Firebase Firestore...");const W={title:y.title||"Untitled Book",subtitle:y.subtitle||"",author:y.author||"Unknown",translator:y.translator||"",tagline:y.tagline||"",category:y.category||"General",language:y.language||"Bangla",audioUrl:y.audioUrl||"",rawMarkdown:y.rawText||"",storageUrl:Ye||"",storagePath:ct||"",coverUrl:ve||"",totalChapters:((E=y.chapters)==null?void 0:E.length)||0,totalWords:y.totalWords||0,estimatedMinutes:y.estimatedMinutes||1,chapters:(y.chapters||[]).map(A=>({id:A.id,order:A.order,title:A.title,content:A.content,wordCount:A.wordCount,estimatedMinutes:A.estimatedMinutes})),slug:N,createdAt:iO(),publishedAtIso:R};let X="Firestore",b=`book_${Date.now()}`;try{b=(await rO(aw(Qd,"books"),W)).id}catch(A){if(console.warn("Firestore write error:",A),A.code==="permission-denied"||(k=A.message)!=null&&k.toLowerCase().includes("permissions")){c(!0);try{await Ap(Hd(Xd,`books/${b}`),{...W,id:b,createdAt:R}),X="Realtime Database"}catch{const q=JSON.parse(localStorage.getItem("audio_books_cache")||"[]");q.unshift({...W,id:b,createdAt:R,isOfflineSaved:!0}),localStorage.setItem("audio_books_cache",JSON.stringify(q)),X="Browser Local Storage (Pending Firebase Rule)"}}else throw A}if(X==="Firestore")try{await Ap(Hd(Xd,`books/${b}`),{...W,id:b,createdAt:R})}catch{}w(100),P("Upload Complete!"),G4({particleCount:80,spread:70,origin:{y:.6}}),T({type:"info",title:X==="Firestore"?"Book Saved to Firestore!":`Saved to ${X}`,message:X==="Firestore"?`"${y.title}" is saved in Firebase Firestore.`:`Firestore rules locked. Saved "${y.title}" locally. Publish Firestore rules to sync remote.`}),r(null),await M(),e("library")}catch(N){console.error("Failed to upload book:",N),(N.code==="permission-denied"||(x=N.message)!=null&&x.toLowerCase().includes("permissions"))&&c(!0),T({type:"error",title:"Upload Failed",message:N.message||"Missing or insufficient permissions. Check Firebase rules."})}finally{f(!1)}},F=async(y,g)=>{if(window.confirm("Are you sure you want to delete this book from Firebase?"))try{await nO(sS(Qd,"books",y));try{await YL(Hd(Xd,`books/${y}`))}catch{}if(g)try{const E=Fd(Yd,g);await mD(E)}catch(E){console.warn("Could not delete storage file:",E)}s(E=>E.filter(k=>k.id!==y)),T({type:"info",title:"Book Deleted",message:"The book record was removed from Firebase."})}catch(E){console.error("Delete error:",E),T({type:"error",title:"Delete Failed",message:E.message})}};return v.jsxs("div",{style:{minHeight:"100vh",display:"flex",flexDirection:"column"},children:[v.jsx(H4,{toasts:O,onDismiss:S}),v.jsx(q4,{isOpen:u,onClose:()=>c(!1)}),v.jsx(o4,{activeTab:t,setActiveTab:e,bookCount:i.length,onOpenRules:()=>c(!0)}),v.jsx("main",{style:{flex:1,padding:"2rem 1.5rem"},children:t==="upload"?n?v.jsx($4,{bookData:n,onCancel:()=>r(null),onUpload:V,isUploading:d,uploadProgress:m,uploadStage:I}):v.jsx(u4,{onParsedBook:r,onShowToast:T}):v.jsx(W4,{books:i,loading:o,onRefresh:M,onDeleteBook:F})}),v.jsx("footer",{style:{padding:"1.5rem",textAlign:"center",borderTop:"1px solid rgba(255, 255, 255, 0.06)",color:"#64748b",fontSize:"0.82rem"},children:v.jsxs("div",{children:["AudioBook Studio • Firebase Markdown Uploader • Connected to project ",v.jsx("strong",{children:"book-store-bec15"})]})})]})}Zd.createRoot(document.getElementById("root")).render(v.jsx(PC.StrictMode,{children:v.jsx(K4,{})}));
