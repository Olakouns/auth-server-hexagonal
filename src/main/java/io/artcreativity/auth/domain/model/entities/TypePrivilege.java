package io.artcreativity.auth.domain.model.entities;

public enum TypePrivilege {
    ACCESS_TO_DASHBOARD,
    CREATE_USER,
    READ_USER,
    SHOW_DETAIL_USER,
    UPDATE_USER,
    CHANGE_PASSWORD_USER,
    SUSPEND_USER,
    DELETE_USER,

    CREATE_ROLE,
    READ_ROLE,
    UPDATE_ROLE,
    DELETE_ROLE,

    CAN_SEE_SALE_BALANCE_SHEET,
    CAN_SEE_PRODUCT_BALANCE_SHEET,
    CAN_SEE_USER_BALANCE_SHEET,

    CREATE_UPDATE_USER,
    CREATE_UPDATE_ROLE,
    COOKER,
    CAN_SEE_FEEDBACK,

    CREATE_UPDATE_ORDER_SERVICE,       // Receptionniste
    DELETE_ORDER_SERVICE,       // Receptionniste
    READ_ORDER_SERVICE,       // Receptionniste
    ACCEPT_ORDER_SERVICE, // Receptionniste
    SEND_ORDER_SERVICE,
    MANAGE_ORDER_SERVICE,       // Receptionniste

    GENERATE_INVOICE_SERVICE,   // Service Caissier
    UPDATE_INVOICE_SERVICE,   // Service Caissier
    PRINT_INVOICE_SERVICE,   // Service Caissier
    CAN_DO_DISCOUNT_INVOICE_SERVICE,   // Service Caissier
    READ_INVOICE_SERVICE,   // Service Caissier
    MANAGE_INVOICE_SERVICE,   // Service Caissier

    MANAGE_CONFIGURATION,

    CREATE_UPDATE_CUSTOMER,
    DELETE_CUSTOMER,
    READ_CUSTOMER,

    CREATE_UPDATE_PRODUCT,
    READ_PRODUCT,
    DELETE_PRODUCT,

    CREATE_UPDATE_SERVICE,
    READ_SERVICE,
    DELETE_SERVICE,

    MANAGE_SERVICE_ORDER,  // Ventes

    DELIVERY_SLIP_STAFF,

    CAN_SEE_INVOICE_BUSINESS,

    IS_WARE_HOUSE_MAN_SERVICE,

    CREATE_UPDATE_ORDER_RESTAURANT,       // Receptionniste
    DELETE_ORDER_RESTAURANT,       // Receptionniste
    READ_ORDER_RESTAURANT,       // Receptionniste
    ACCEPT_ORDER_RESTAURANT, // Receptionniste
    SEND_ORDER_RESTAURANT,
    MANAGE_ORDER_RESTAURANT,       // Receptionniste
    GENERATE_INVOICE_RESTAURANT,   // Caissier
    UPDATE_INVOICE_RESTAURANT,   // Caissier
    PRINT_INVOICE_RESTAURANT,   // Caissier
    CAN_DO_DISCOUNT_INVOICE_RESTAURANT,   // Caissier
    READ_INVOICE_RESTAURANT,   // Caissier
    MANAGE_INVOICE_RESTAURANT,   // Caissier

    // Activité de transformation
    CREATE_ACTIVITY,
    MANAGER_ACTIVITY,
    CREATE_UPDATE_TASK_ACTIVITY_PRICE,
    READ_TASK_ACTIVITY_PRICE,
    DELETE_TASK_ACTIVITY_PRICE,

    // Compatabilité
    MAKE_ACCOUNTING_ENTRY,
    MAKE_IMPUTATION,
    GENERATE_GRAND_BOOK,
    DEFINE_UPADATE_ACCOUNT,

    // RH
    HUMANS_RESOURCE,

    // COMPANY MANAGER
    UPDATE_COMPANY,
    DELETE_COMPANY,

    // Simple user
    SIMPLE_USER,
    CREATE_COMPANY,
    READ_COMPANY,
    CHANGE_OWN_PASSWORD,

    // SUPER ADMIN
    CREATE_ADMIN_USER,
    READ_ADMIN_USER,
    SHOW_ADMIN_DETAIL_USER,
    UPDATE_ADMIN_USER,
    CHANGE_ADMIN_PASSWORD_USER,
    SUSPEND_ADMIN_USER,
    DELETE_ADMIN_USER,

    CREATE_ADMIN_ROLE,
    READ_ADMIN_ROLE,
    UPDATE_ADMIN_ROLE,
    DELETE_ADMIN_ROLE,

    SHOW_GLOBAL_STAT


}
