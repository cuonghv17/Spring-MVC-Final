function isEmpty(value) {
    return !value || !value.trim();
}
function checkName(value) {
    var regex = /^([a-zA-Z]{1,}(?: [a-zA-Z]+){0,}){0,51}$/;
    return !regex.test(value);
}
function checkGia(value) {
    var regex = /^\d.$/;
    return !regex.test(value);
}
//check date
var nowDate = new Date();
var sNowDate =
    nowDate.getFullYear() +
    '-' +
    (nowDate.getMonth() + 1) +
    '-' +
    (nowDate.getDate() - 2);
function converDate(value) {
    var arrValueUnits = value.split('-');
    var d = parseInt(arrValueUnits[2]);
    var m = parseInt(arrValueUnits[1]) - 1;
    var y = parseInt(arrValueUnits[0]);
    var objDate = new Date(y, m, d);
    return objDate;
}
function checkDate(value) {
    if (converDate(value) - converDate(sNowDate) <= 0) {
        return false;
    }
    return true;
}
function checkTwoY(value1, value2) {
    var arrValue1Units = value1.split('-');
    var arrValue2Units = value2.split('-');
    if (arrValue1Units[0] - arrValue2Units[0] < 2) {
        return true;
    }
    return false;
}
function handleDisplayError(element, validateFunc, element_err, message) {
    if (validateFunc(element.val())) {
        element.addClass('is-invalid');
        element_err.text(message);
        return false;
    }
    element.removeClass('is-invalid');
    element_err.text('');
    return true;
}
function handleDisplayError2(
    element,
    element2,
    validateFunc,
    element_err,
    message
) {
    if (validateFunc(element2.val(), element.val())) {
        element.addClass('is-invalid');
        element_err.text(message);
        return false;
    }
    element.removeClass('is-invalid');
    element_err.text('');
    return true;
}
$('input[type=radio][name=lbds]').change(function () {
    const radioBDS = $('input[name="lbds"]:checked');
    const soNamCN = $('#soNamCN');
    soNamCN.val(radioBDS.val());
});
var selectedId;
var data = [
    {
        id: selectedId || new Date().getTime(),
        ten: '1',
        ngayXD: '1',
        ngayHT: '1',
        dienTich: '1',
        id: '1',
        trangThai: '1',
        giaBan: '1',
        soNam: '1',
    },
];
function render(dataInput) {
    const tbodyEl = $('#tbData');
    let html = '';
    dataInput.forEach((element, index) => {
        html += `<tr>
                    <th scope="row">${index + 1}</th>
                    <td>${element.ten}</td>
                    <td>${element.ngayXD}</td>
                    <td>${element.ngayHT}</td>
                    <td>${element.dienTich}</td>
                    <td>${element.loaiBDS}</td>
                    <td>${element.trangThai}</td>
                    <td>${element.giaBan}</td>
                    <td>${element.soNam}</td>
                    <td>
                        <button
                            type="button"
                            class="btn btn-outline-warning"
                            onclick="editStudent(${element.id})"
                        >
                            <i class="far fa-edit"></i>
                        </button>
                        <button
                            type="button"
                            class="btn btn-outline-danger"
                            onclick="deleteItem(event, ${element.id})"
                        >
                            <i class="far fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>
              `;
    });
    tbodyEl.html(html);
}
$('#form1').submit(function (event) {
    event.preventDefault();
    const name = $(this.txtName);
    const ngayXD = $(this.startDate);
    const ngayHT = $(this.endDate);
    const nhaDT = $(this.info);
    const dienTich = $(this.dienTich);
    const giaBan = $(this.giaBan);
    const trangThai = $(this.trangThai);
    const soNam = $('#soNamCN');
    const dataItem = {
        id: selectedId || new Date().getTime(),
        ten: name.val(),
        ngayXD: ngayXD.val(),
        ngayHT: ngayHT.val(),
        dienTich: dienTich.val(),
        loaiBDS: nhaDT.val(),
        trangThai: trangThai.val(),
        giaBan: giaBan.val(),
        soNam: soNam.val(),
    };
    let isValid = true;
    if (
        !handleDisplayError(
            name,
            isEmpty,
            $('#nameError'),
            'Vui l??ng kh??ng ????? tr???ng t??n'
        )
    ) {
        isValid = false;
    } else {
        if (
            handleDisplayError(
                name,
                checkName,
                $('#nameError'),
                'Vui l??ng ch??? nh???p ch???'
            )
        ) {
            isValid = false;
        }
    }
    if (
        !handleDisplayError(
            ngayXD,
            isEmpty,
            $('#startDateError'),
            'Vui l??ng ch???n ng??y s???n xu???t'
        )
    ) {
        isValid = false;
    }
    if (
        !handleDisplayError(
            ngayHT,
            isEmpty,
            $('#endDateError'),
            'Vui l??ng ch???n ng??y ho??n th??nh'
        )
    ) {
        isValid = false;
    }
    if (
        !handleDisplayError2(
            ngayXD,
            ngayHT,
            checkTwoY,
            $('#endDateError'),
            'Vui l??ng ch???n ng??y ho??n th??nh c??ch 2 n??m so NXD'
        )
    ) {
        console.log('Vui l??ng ch???n ng??y ho??n th??nh c??ch 2 n??m so NXD');
        isValid = false;
    }
    if (
        !handleDisplayError(
            giaBan,
            isEmpty,
            $('#giaBanError'),
            'Vui l??ng nh???p ????ng gi?? b??n'
        )
    ) {
        console.log('Vui l??ng nh???p ????ng gi?? b??n');
        isValid = false;
    }
    if (
        !handleDisplayError(
            giaBan,
            isEmpty,
            $('#giaBanError'),
            'Vui l??ng nh???p ????ng gi?? b??n'
        )
    ) {
        isValid = false;
    }
    if (
        !handleDisplayError(
            giaBan,
            isEmpty,
            $('#giaBanError'),
            'Vui l??ng nh???p ????ng gi?? b??n'
        )
    ) {
        isValid = false;
    }
    if (
        !handleDisplayError(
            $('#soTang'),
            isEmpty,
            $('#soTangError'),
            'Vui l??ng nh???p s??? t???ng'
        )
    ) {
        isValid = false;
    }
    if (
        !handleDisplayError(
            trangThai,
            isEmpty,
            $('#trangThaiError'),
            'Vui l??ng ch???n tr???ng th??i'
        )
    ) {
        isValid = false;
    }
    if (isValid) {
        data.push(dataItem);
    }
    render(data);
});
var dataSearch;
$('#selectClass').change(function (event) {
    const {
        target: { value },
    } = event;
    console.log(value);
    if (value == 0) {
        render(data);
    }
    dataSearch = data.filter((it) => it.soNam == value);
    render(dataSearch);
});
function deleteItem(event, id) {
    let text =
        'B???n c?? ch???c mu???n x??a Row th??ng tin n??y kh??ng?\nEither OK or Cancel.';
    if (confirm(text) == true) {
        event.stopPropagation();
        data = data.filter((item) => item.id !== id); // n?? s??? l???c ra nh???ng th???ng tho??? m??n ??i???u ki???n
        render(data);
    }
}